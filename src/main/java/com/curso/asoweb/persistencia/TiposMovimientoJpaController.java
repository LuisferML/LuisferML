/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.curso.asoweb.logica.MovimientosSocios;
import com.curso.asoweb.logica.TiposMovimiento;
import com.curso.asoweb.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis_
 */
public class TiposMovimientoJpaController implements Serializable {

    public TiposMovimientoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public TiposMovimientoJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TiposMovimiento tiposMovimiento) {
        if (tiposMovimiento.getMovimientosSociosCollection() == null) {
            tiposMovimiento.setMovimientosSociosCollection(new ArrayList<MovimientosSocios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<MovimientosSocios> attachedMovimientosSociosCollection = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSociosToAttach : tiposMovimiento.getMovimientosSociosCollection()) {
                movimientosSociosCollectionMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionMovimientosSociosToAttach.getClass(), movimientosSociosCollectionMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection.add(movimientosSociosCollectionMovimientosSociosToAttach);
            }
            tiposMovimiento.setMovimientosSociosCollection(attachedMovimientosSociosCollection);
            em.persist(tiposMovimiento);
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : tiposMovimiento.getMovimientosSociosCollection()) {
                TiposMovimiento oldIdTipoMovimientoOfMovimientosSociosCollectionMovimientosSocios = movimientosSociosCollectionMovimientosSocios.getIdTipoMovimiento();
                movimientosSociosCollectionMovimientosSocios.setIdTipoMovimiento(tiposMovimiento);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
                if (oldIdTipoMovimientoOfMovimientosSociosCollectionMovimientosSocios != null) {
                    oldIdTipoMovimientoOfMovimientosSociosCollectionMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionMovimientosSocios);
                    oldIdTipoMovimientoOfMovimientosSociosCollectionMovimientosSocios = em.merge(oldIdTipoMovimientoOfMovimientosSociosCollectionMovimientosSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TiposMovimiento tiposMovimiento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TiposMovimiento persistentTiposMovimiento = em.find(TiposMovimiento.class, tiposMovimiento.getId());
            Collection<MovimientosSocios> movimientosSociosCollectionOld = persistentTiposMovimiento.getMovimientosSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollectionNew = tiposMovimiento.getMovimientosSociosCollection();
            Collection<MovimientosSocios> attachedMovimientosSociosCollectionNew = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSociosToAttach : movimientosSociosCollectionNew) {
                movimientosSociosCollectionNewMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionNewMovimientosSociosToAttach.getClass(), movimientosSociosCollectionNewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollectionNew.add(movimientosSociosCollectionNewMovimientosSociosToAttach);
            }
            movimientosSociosCollectionNew = attachedMovimientosSociosCollectionNew;
            tiposMovimiento.setMovimientosSociosCollection(movimientosSociosCollectionNew);
            tiposMovimiento = em.merge(tiposMovimiento);
            for (MovimientosSocios movimientosSociosCollectionOldMovimientosSocios : movimientosSociosCollectionOld) {
                if (!movimientosSociosCollectionNew.contains(movimientosSociosCollectionOldMovimientosSocios)) {
                    movimientosSociosCollectionOldMovimientosSocios.setIdTipoMovimiento(null);
                    movimientosSociosCollectionOldMovimientosSocios = em.merge(movimientosSociosCollectionOldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSocios : movimientosSociosCollectionNew) {
                if (!movimientosSociosCollectionOld.contains(movimientosSociosCollectionNewMovimientosSocios)) {
                    TiposMovimiento oldIdTipoMovimientoOfMovimientosSociosCollectionNewMovimientosSocios = movimientosSociosCollectionNewMovimientosSocios.getIdTipoMovimiento();
                    movimientosSociosCollectionNewMovimientosSocios.setIdTipoMovimiento(tiposMovimiento);
                    movimientosSociosCollectionNewMovimientosSocios = em.merge(movimientosSociosCollectionNewMovimientosSocios);
                    if (oldIdTipoMovimientoOfMovimientosSociosCollectionNewMovimientosSocios != null && !oldIdTipoMovimientoOfMovimientosSociosCollectionNewMovimientosSocios.equals(tiposMovimiento)) {
                        oldIdTipoMovimientoOfMovimientosSociosCollectionNewMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionNewMovimientosSocios);
                        oldIdTipoMovimientoOfMovimientosSociosCollectionNewMovimientosSocios = em.merge(oldIdTipoMovimientoOfMovimientosSociosCollectionNewMovimientosSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tiposMovimiento.getId();
                if (findTiposMovimiento(id) == null) {
                    throw new NonexistentEntityException("The tiposMovimiento with id " + id + " no longer exists.");
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
            TiposMovimiento tiposMovimiento;
            try {
                tiposMovimiento = em.getReference(TiposMovimiento.class, id);
                tiposMovimiento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tiposMovimiento with id " + id + " no longer exists.", enfe);
            }
            Collection<MovimientosSocios> movimientosSociosCollection = tiposMovimiento.getMovimientosSociosCollection();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : movimientosSociosCollection) {
                movimientosSociosCollectionMovimientosSocios.setIdTipoMovimiento(null);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
            }
            em.remove(tiposMovimiento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TiposMovimiento> findTiposMovimientoEntities() {
        return findTiposMovimientoEntities(true, -1, -1);
    }

    public List<TiposMovimiento> findTiposMovimientoEntities(int maxResults, int firstResult) {
        return findTiposMovimientoEntities(false, maxResults, firstResult);
    }

    private List<TiposMovimiento> findTiposMovimientoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TiposMovimiento.class));
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

    public TiposMovimiento findTiposMovimiento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TiposMovimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTiposMovimientoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TiposMovimiento> rt = cq.from(TiposMovimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
