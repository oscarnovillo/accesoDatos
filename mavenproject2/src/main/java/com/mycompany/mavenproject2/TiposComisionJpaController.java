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
public class TiposComisionJpaController implements Serializable {

  public TiposComisionJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(TiposComision tiposComision) throws PreexistingEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(tiposComision);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (findTiposComision(tiposComision.getIdTipoComision()) != null) {
        throw new PreexistingEntityException("TiposComision " + tiposComision + " already exists.", ex);
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(TiposComision tiposComision) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      tiposComision = em.merge(tiposComision);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Integer id = tiposComision.getIdTipoComision();
        if (findTiposComision(id) == null) {
          throw new NonexistentEntityException("The tiposComision with id " + id + " no longer exists.");
        }
      }
      throw ex;
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void destroy(Integer id) throws NonexistentEntityException {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      TiposComision tiposComision;
      try {
        tiposComision = em.getReference(TiposComision.class, id);
        tiposComision.getIdTipoComision();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The tiposComision with id " + id + " no longer exists.", enfe);
      }
      em.remove(tiposComision);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<TiposComision> findTiposComisionEntities() {
    return findTiposComisionEntities(true, -1, -1);
  }

  public List<TiposComision> findTiposComisionEntities(int maxResults, int firstResult) {
    return findTiposComisionEntities(false, maxResults, firstResult);
  }

  private List<TiposComision> findTiposComisionEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(TiposComision.class));
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

  public TiposComision findTiposComision(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(TiposComision.class, id);
    } finally {
      em.close();
    }
  }

  public int getTiposComisionCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<TiposComision> rt = cq.from(TiposComision.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
