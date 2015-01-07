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
public class DatosDireccionesJpaController implements Serializable {

  public DatosDireccionesJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(DatosDirecciones datosDirecciones) throws PreexistingEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(datosDirecciones);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findDatosDirecciones(datosDirecciones.getLogin()) != null) {
        throw new PreexistingEntityException("DatosDirecciones " + datosDirecciones + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(DatosDirecciones datosDirecciones) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      datosDirecciones = em.merge(datosDirecciones);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        String id = datosDirecciones.getLogin();
        if (findDatosDirecciones(id) == null) {
          throw new NonexistentEntityException("The datosDirecciones with id " + id + " no longer exists.");
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
      DatosDirecciones datosDirecciones;
      try {
        datosDirecciones = em.getReference(DatosDirecciones.class, id);
        datosDirecciones.getLogin();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The datosDirecciones with id " + id + " no longer exists.", enfe);
      }
      em.remove(datosDirecciones);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<DatosDirecciones> findDatosDireccionesEntities() {
    return findDatosDireccionesEntities(true, -1, -1);
  }

  public List<DatosDirecciones> findDatosDireccionesEntities(int maxResults, int firstResult) {
    return findDatosDireccionesEntities(false, maxResults, firstResult);
  }

  private List<DatosDirecciones> findDatosDireccionesEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(DatosDirecciones.class));
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

  public DatosDirecciones findDatosDirecciones(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(DatosDirecciones.class, id);
    } finally {
      em.close();
    }
  }

  public int getDatosDireccionesCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<DatosDirecciones> rt = cq.from(DatosDirecciones.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
