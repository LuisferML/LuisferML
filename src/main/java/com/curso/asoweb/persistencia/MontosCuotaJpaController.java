/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.MontosCuota;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis_
 */
public class MontosCuotaJpaController implements Serializable {

    public MontosCuotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public MontosCuotaJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MontosCuota montosCuota) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios idUsuarioInactivacion = montosCuota.getIdUsuarioInactivacion();
            if (idUsuarioInactivacion != null) {
                idUsuarioInactivacion = em.getReference(idUsuarioInactivacion.getClass(), idUsuarioInactivacion.getId());
                montosCuota.setIdUsuarioInactivacion(idUsuarioInactivacion);
            }
            em.persist(montosCuota);
            if (idUsuarioInactivacion != null) {
                idUsuarioInactivacion.getMontosCuotaCollection().add(montosCuota);
                idUsuarioInactivacion = em.merge(idUsuarioInactivacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MontosCuota montosCuota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MontosCuota persistentMontosCuota = em.find(MontosCuota.class, montosCuota.getId());
            Usuarios idUsuarioInactivacionOld = persistentMontosCuota.getIdUsuarioInactivacion();
            Usuarios idUsuarioInactivacionNew = montosCuota.getIdUsuarioInactivacion();
            if (idUsuarioInactivacionNew != null) {
                idUsuarioInactivacionNew = em.getReference(idUsuarioInactivacionNew.getClass(), idUsuarioInactivacionNew.getId());
                montosCuota.setIdUsuarioInactivacion(idUsuarioInactivacionNew);
            }
            montosCuota = em.merge(montosCuota);
            if (idUsuarioInactivacionOld != null && !idUsuarioInactivacionOld.equals(idUsuarioInactivacionNew)) {
                idUsuarioInactivacionOld.getMontosCuotaCollection().remove(montosCuota);
                idUsuarioInactivacionOld = em.merge(idUsuarioInactivacionOld);
            }
            if (idUsuarioInactivacionNew != null && !idUsuarioInactivacionNew.equals(idUsuarioInactivacionOld)) {
                idUsuarioInactivacionNew.getMontosCuotaCollection().add(montosCuota);
                idUsuarioInactivacionNew = em.merge(idUsuarioInactivacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = montosCuota.getId();
                if (findMontosCuota(id) == null) {
                    throw new NonexistentEntityException("The montosCuota with id " + id + " no longer exists.");
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
            MontosCuota montosCuota;
            try {
                montosCuota = em.getReference(MontosCuota.class, id);
                montosCuota.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The montosCuota with id " + id + " no longer exists.", enfe);
            }
            Usuarios idUsuarioInactivacion = montosCuota.getIdUsuarioInactivacion();
            if (idUsuarioInactivacion != null) {
                idUsuarioInactivacion.getMontosCuotaCollection().remove(montosCuota);
                idUsuarioInactivacion = em.merge(idUsuarioInactivacion);
            }
            em.remove(montosCuota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MontosCuota> findMontosCuotaEntities() {
        return findMontosCuotaEntities(true, -1, -1);
    }

    public List<MontosCuota> findMontosCuotaEntities(int maxResults, int firstResult) {
        return findMontosCuotaEntities(false, maxResults, firstResult);
    }

    private List<MontosCuota> findMontosCuotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MontosCuota.class));
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

    public MontosCuota findMontosCuota(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MontosCuota.class, id);
        } finally {
            em.close();
        }
    }

    public int getMontosCuotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MontosCuota> rt = cq.from(MontosCuota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
