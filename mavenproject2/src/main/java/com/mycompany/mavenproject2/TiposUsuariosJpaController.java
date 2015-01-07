/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.exceptions.IllegalOrphanException;
import com.mycompany.mavenproject2.exceptions.NonexistentEntityException;
import com.mycompany.mavenproject2.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author oscar
 */
public class TiposUsuariosJpaController implements Serializable {

  public TiposUsuariosJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(TiposUsuarios tiposUsuarios) throws PreexistingEntityException, Exception {
    if (tiposUsuarios.getUsuariosList() == null) {
      tiposUsuarios.setUsuariosList(new ArrayList<Usuarios>());
    }
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      List<Usuarios> attachedUsuariosList = new ArrayList<Usuarios>();
      for (Usuarios usuariosListUsuariosToAttach : tiposUsuarios.getUsuariosList()) {
        usuariosListUsuariosToAttach = em.getReference(usuariosListUsuariosToAttach.getClass(), usuariosListUsuariosToAttach.getLogin());
        attachedUsuariosList.add(usuariosListUsuariosToAttach);
      }
      tiposUsuarios.setUsuariosList(attachedUsuariosList);
      em.persist(tiposUsuarios);
      for (Usuarios usuariosListUsuarios : tiposUsuarios.getUsuariosList()) {
        TiposUsuarios oldTipoUsuarioOfUsuariosListUsuarios = usuariosListUsuarios.getTipoUsuario();
        usuariosListUsuarios.setTipoUsuario(tiposUsuarios);
        usuariosListUsuarios = em.merge(usuariosListUsuarios);
        if (oldTipoUsuarioOfUsuariosListUsuarios != null) {
          oldTipoUsuarioOfUsuariosListUsuarios.getUsuariosList().remove(usuariosListUsuarios);
          oldTipoUsuarioOfUsuariosListUsuarios = em.merge(oldTipoUsuarioOfUsuariosListUsuarios);
        }
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findTiposUsuarios(tiposUsuarios.getIdTipoUsuario()) != null) {
        throw new PreexistingEntityException("TiposUsuarios " + tiposUsuarios + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(TiposUsuarios tiposUsuarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      TiposUsuarios persistentTiposUsuarios = em.find(TiposUsuarios.class, tiposUsuarios.getIdTipoUsuario());
      List<Usuarios> usuariosListOld = persistentTiposUsuarios.getUsuariosList();
      List<Usuarios> usuariosListNew = tiposUsuarios.getUsuariosList();
      List<String> illegalOrphanMessages = null;
      for (Usuarios usuariosListOldUsuarios : usuariosListOld) {
        if (!usuariosListNew.contains(usuariosListOldUsuarios)) {
          if (illegalOrphanMessages == null) {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Usuarios " + usuariosListOldUsuarios + " since its tipoUsuario field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null) {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      List<Usuarios> attachedUsuariosListNew = new ArrayList<Usuarios>();
      for (Usuarios usuariosListNewUsuariosToAttach : usuariosListNew) {
        usuariosListNewUsuariosToAttach = em.getReference(usuariosListNewUsuariosToAttach.getClass(), usuariosListNewUsuariosToAttach.getLogin());
        attachedUsuariosListNew.add(usuariosListNewUsuariosToAttach);
      }
      usuariosListNew = attachedUsuariosListNew;
      tiposUsuarios.setUsuariosList(usuariosListNew);
      tiposUsuarios = em.merge(tiposUsuarios);
      for (Usuarios usuariosListNewUsuarios : usuariosListNew) {
        if (!usuariosListOld.contains(usuariosListNewUsuarios)) {
          TiposUsuarios oldTipoUsuarioOfUsuariosListNewUsuarios = usuariosListNewUsuarios.getTipoUsuario();
          usuariosListNewUsuarios.setTipoUsuario(tiposUsuarios);
          usuariosListNewUsuarios = em.merge(usuariosListNewUsuarios);
          if (oldTipoUsuarioOfUsuariosListNewUsuarios != null && !oldTipoUsuarioOfUsuariosListNewUsuarios.equals(tiposUsuarios)) {
            oldTipoUsuarioOfUsuariosListNewUsuarios.getUsuariosList().remove(usuariosListNewUsuarios);
            oldTipoUsuarioOfUsuariosListNewUsuarios = em.merge(oldTipoUsuarioOfUsuariosListNewUsuarios);
          }
        }
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Integer id = tiposUsuarios.getIdTipoUsuario();
        if (findTiposUsuarios(id) == null) {
          throw new NonexistentEntityException("The tiposUsuarios with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      TiposUsuarios tiposUsuarios;
      try {
        tiposUsuarios = em.getReference(TiposUsuarios.class, id);
        tiposUsuarios.getIdTipoUsuario();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The tiposUsuarios with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      List<Usuarios> usuariosListOrphanCheck = tiposUsuarios.getUsuariosList();
      for (Usuarios usuariosListOrphanCheckUsuarios : usuariosListOrphanCheck) {
        if (illegalOrphanMessages == null) {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This TiposUsuarios (" + tiposUsuarios + ") cannot be destroyed since the Usuarios " + usuariosListOrphanCheckUsuarios + " in its usuariosList field has a non-nullable tipoUsuario field.");
      }
      if (illegalOrphanMessages != null) {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      em.remove(tiposUsuarios);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<TiposUsuarios> findTiposUsuariosEntities() {
    return findTiposUsuariosEntities(true, -1, -1);
  }

  public List<TiposUsuarios> findTiposUsuariosEntities(int maxResults, int firstResult) {
    return findTiposUsuariosEntities(false, maxResults, firstResult);
  }

  private List<TiposUsuarios> findTiposUsuariosEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(TiposUsuarios.class));
      Query q = em.createQuery(cq);
      if (!all) {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    } finally {
      em.close();
    }
  }

  public TiposUsuarios findTiposUsuarios(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(TiposUsuarios.class, id);
    } finally {
      em.close();
    }
  }

  public int getTiposUsuariosCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<TiposUsuarios> rt = cq.from(TiposUsuarios.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
