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
import jpa.ComisionesTotales;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.controller.exceptions.PreexistingEntityException;

/**
 *
 * @author oscar
 */
public class ComisionesTotalesJpaController implements Serializable {

  public ComisionesTotalesJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(ComisionesTotales comisionesTotales) throws PreexistingEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(comisionesTotales);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findComisionesTotales(comisionesTotales.getLogin()) != null) {
        throw new PreexistingEntityException("ComisionesTotales " + comisionesTotales + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(ComisionesTotales comisionesTotales) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      comisionesTotales = em.merge(comisionesTotales);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        String id = comisionesTotales.getLogin();
        if (findComisionesTotales(id) == null) {
          throw new NonexistentEntityException("The comisionesTotales with id " + id + " no longer exists.");
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
      ComisionesTotales comisionesTotales;
      try {
        comisionesTotales = em.getReference(ComisionesTotales.class, id);
        comisionesTotales.getLogin();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The comisionesTotales with id " + id + " no longer exists.", enfe);
      }
      em.remove(comisionesTotales);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<ComisionesTotales> findComisionesTotalesEntities() {
    return findComisionesTotalesEntities(true, -1, -1);
  }

  public List<ComisionesTotales> findComisionesTotalesEntities(int maxResults, int firstResult) {
    return findComisionesTotalesEntities(false, maxResults, firstResult);
  }

  private List<ComisionesTotales> findComisionesTotalesEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(ComisionesTotales.class));
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

  public ComisionesTotales findComisionesTotales(String id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(ComisionesTotales.class, id);
    } finally {
      em.close();
    }
  }

  public int getComisionesTotalesCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<ComisionesTotales> rt = cq.from(ComisionesTotales.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
