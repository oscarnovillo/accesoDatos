/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import com.mycompany.mavenproject2.exceptions.NonexistentEntityException;
import com.mycompany.mavenproject2.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author oscar
 */
public class UsuariosJpaController implements Serializable {

  public UsuariosJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Usuarios usuarios) throws PreexistingEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      TiposUsuarios tipoUsuario = usuarios.getTipoUsuario();
      if (tipoUsuario != null) {
        tipoUsuario = em.getReference(tipoUsuario.getClass(), tipoUsuario.getIdTipoUsuario());
        usuarios.setTipoUsuario(tipoUsuario);
      }
      em.persist(usuarios);
      if (tipoUsuario != null) {
        tipoUsuario.getUsuariosList().add(usuarios);
        tipoUsuario = em.merge(tipoUsuario);
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findUsuarios(usuarios.getLogin()) != null) {
        throw new PreexistingEntityException("Usuarios " + usuarios + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Usuarios usuarios) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getLogin());
      TiposUsuarios tipoUsuarioOld = persistentUsuarios.getTipoUsuario();
      TiposUsuarios tipoUsuarioNew = usuarios.getTipoUsuario();
      if (tipoUsuarioNew != null) {
        tipoUsuarioNew = em.getReference(tipoUsuarioNew.getClass(), tipoUsuarioNew.getIdTipoUsuario());
        usuarios.setTipoUsuario(tipoUsuarioNew);
      }
      usuarios = em.merge(usuarios);
      if (tipoUsuarioOld != null && !tipoUsuarioOld.equals(tipoUsuarioNew)) {
        tipoUsuarioOld.getUsuariosList().remove(usuarios);
        tipoUsuarioOld = em.merge(tipoUsuarioOld);
      }
      if (tipoUsuarioNew != null && !tipoUsuarioNew.equals(tipoUsuarioOld)) {
        tipoUsuarioNew.getUsuariosList().add(usuarios);
        tipoUsuarioNew = em.merge(tipoUsuarioNew);
      }
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        String id = usuarios.getLogin();
        if (findUsuarios(id) == null) {
          throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(String id) throws NonexistentEntityException {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      Usuarios usuarios;
      try {
        usuarios = em.getReference(Usuarios.class, id);
        usuarios.getLogin();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
      }
      TiposUsuarios tipoUsuario = usuarios.getTipoUsuario();
      if (tipoUsuario != null) {
        tipoUsuario.getUsuariosList().remove(usuarios);
        tipoUsuario = em.merge(tipoUsuario);
      }
      em.remove(usuarios);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Usuarios> findUsuariosEntities() {
    return findUsuariosEntities(true, -1, -1);
  }

  public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
    return findUsuariosEntities(false, maxResults, firstResult);
  }

  private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Usuarios.class));
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

  public Usuarios findUsuarios(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Usuarios.class, id);
    } finally {
      em.close();
    }
  }

  public int getUsuariosCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Usuarios> rt = cq.from(Usuarios.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
