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
import jpa.Pedidos;
import jpa.controller.exceptions.NonexistentEntityException;

/**
 *
 * @author oscar
 */
public class PedidosJpaController implements Serializable {

  public PedidosJpaController(EntityManagerFactory emf) {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager() {
    return emf.createEntityManager();
  }

  public void create(Pedidos pedidos) {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(pedidos);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public void edit(Pedidos pedidos) throws NonexistentEntityException, Exception {
    EntityManager em = null;
    try {
      em = getEntityManager();
      em.getTransaction().begin();
      pedidos = em.merge(pedidos);
      em.getTransaction().commit();
    } catch (Exception ex) {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0) {
        Integer id = pedidos.getIdPedido();
        if (findPedidos(id) == null) {
          throw new NonexistentEntityException("The pedidos with id " + id + " no longer exists.");
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
      Pedidos pedidos;
      try {
        pedidos = em.getReference(Pedidos.class, id);
        pedidos.getIdPedido();
      } catch (EntityNotFoundException enfe) {
        throw new NonexistentEntityException("The pedidos with id " + id + " no longer exists.", enfe);
      }
      em.remove(pedidos);
      em.getTransaction().commit();
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

  public List<Pedidos> findPedidosEntities() {
    return findPedidosEntities(true, -1, -1);
  }

  public List<Pedidos> findPedidosEntities(int maxResults, int firstResult) {
    return findPedidosEntities(false, maxResults, firstResult);
  }

  private List<Pedidos> findPedidosEntities(boolean all, int maxResults, int firstResult) {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Pedidos.class));
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

  public Pedidos findPedidos(Integer id) {
    EntityManager em = getEntityManager();
    try {
      return em.find(Pedidos.class, id);
    } finally {
      em.close();
    }
  }

  public int getPedidosCount() {
    EntityManager em = getEntityManager();
    try {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Pedidos> rt = cq.from(Pedidos.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    } finally {
      em.close();
    }
  }
  
}
