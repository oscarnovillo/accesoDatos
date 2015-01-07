/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.DatosPersonales;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.controller.exceptions.PreexistingEntityException;

/**
 *
 * @author oscar
 */
public class DatosPersonalesJpaController implements Serializable {

  public DatosPersonalesJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(DatosPersonales datosPersonales) throws PreexistingEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(datosPersonales);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findDatosPersonales(datosPersonales.getLogin()) != null) {
        throw new PreexistingEntityException("DatosPersonales " + datosPersonales + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(DatosPersonales datosPersonales) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      datosPersonales = em.merge(datosPersonales);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        String id = datosPersonales.getLogin();
        if (findDatosPersonales(id) == null) {
          throw new NonexistentEntityException("The datosPersonales with id " + id + " no longer exists.");
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
      DatosPersonales datosPersonales;
      try {
        datosPersonales = em.getReference(DatosPersonales.class, id);
        datosPersonales.getLogin();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The datosPersonales with id " + id + " no longer exists.", enfe);
      }
      em.remove(datosPersonales);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<DatosPersonales> findDatosPersonalesEntities() {
    return findDatosPersonalesEntities(true, -1, -1);
  }

  public List<DatosPersonales> findDatosPersonalesEntities(int maxResults, int firstResult) {
    return findDatosPersonalesEntities(false, maxResults, firstResult);
  }

  private List<DatosPersonales> findDatosPersonalesEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(DatosPersonales.class));
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

  public DatosPersonales findDatosPersonales(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(DatosPersonales.class, id);
    } finally {
      em.close();
    }
  }

  public int getDatosPersonalesCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<DatosPersonales> rt = cq.from(DatosPersonales.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
