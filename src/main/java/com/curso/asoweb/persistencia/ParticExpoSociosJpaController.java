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
import com.curso.asoweb.logica.Exposiciones;
import com.curso.asoweb.logica.ParticExpoSocios;
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.logica.TematicaParticExpoSocios;
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
public class ParticExpoSociosJpaController implements Serializable {

    public ParticExpoSociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public ParticExpoSociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ParticExpoSocios particExpoSocios) {
        if (particExpoSocios.getTematicaParticExpoSociosCollection() == null) {
            particExpoSocios.setTematicaParticExpoSociosCollection(new ArrayList<TematicaParticExpoSocios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Exposiciones idExposicion = particExpoSocios.getIdExposicion();
            if (idExposicion != null) {
                idExposicion = em.getReference(idExposicion.getClass(), idExposicion.getId());
                particExpoSocios.setIdExposicion(idExposicion);
            }
            Socios idSocio = particExpoSocios.getIdSocio();
            if (idSocio != null) {
                idSocio = em.getReference(idSocio.getClass(), idSocio.getId());
                particExpoSocios.setIdSocio(idSocio);
            }
            Usuarios idUsuarioCreacion = particExpoSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                particExpoSocios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            Collection<TematicaParticExpoSocios> attachedTematicaParticExpoSociosCollection = new ArrayList<TematicaParticExpoSocios>();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach : particExpoSocios.getTematicaParticExpoSociosCollection()) {
                tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach = em.getReference(tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach.getClass(), tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach.getId());
                attachedTematicaParticExpoSociosCollection.add(tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach);
            }
            particExpoSocios.setTematicaParticExpoSociosCollection(attachedTematicaParticExpoSociosCollection);
            em.persist(particExpoSocios);
            if (idExposicion != null) {
                idExposicion.getParticExpoSociosCollection().add(particExpoSocios);
                idExposicion = em.merge(idExposicion);
            }
            if (idSocio != null) {
                idSocio.getParticExpoSociosCollection().add(particExpoSocios);
                idSocio = em.merge(idSocio);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getParticExpoSociosCollection().add(particExpoSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSocios : particExpoSocios.getTematicaParticExpoSociosCollection()) {
                ParticExpoSocios oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios = tematicaParticExpoSociosCollectionTematicaParticExpoSocios.getIdParticExpoSocios();
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios.setIdParticExpoSocios(particExpoSocios);
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                if (oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios != null) {
                    oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                    oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ParticExpoSocios particExpoSocios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ParticExpoSocios persistentParticExpoSocios = em.find(ParticExpoSocios.class, particExpoSocios.getId());
            Exposiciones idExposicionOld = persistentParticExpoSocios.getIdExposicion();
            Exposiciones idExposicionNew = particExpoSocios.getIdExposicion();
            Socios idSocioOld = persistentParticExpoSocios.getIdSocio();
            Socios idSocioNew = particExpoSocios.getIdSocio();
            Usuarios idUsuarioCreacionOld = persistentParticExpoSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = particExpoSocios.getIdUsuarioCreacion();
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionOld = persistentParticExpoSocios.getTematicaParticExpoSociosCollection();
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionNew = particExpoSocios.getTematicaParticExpoSociosCollection();
            if (idExposicionNew != null) {
                idExposicionNew = em.getReference(idExposicionNew.getClass(), idExposicionNew.getId());
                particExpoSocios.setIdExposicion(idExposicionNew);
            }
            if (idSocioNew != null) {
                idSocioNew = em.getReference(idSocioNew.getClass(), idSocioNew.getId());
                particExpoSocios.setIdSocio(idSocioNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                particExpoSocios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            Collection<TematicaParticExpoSocios> attachedTematicaParticExpoSociosCollectionNew = new ArrayList<TematicaParticExpoSocios>();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach : tematicaParticExpoSociosCollectionNew) {
                tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach = em.getReference(tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach.getClass(), tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach.getId());
                attachedTematicaParticExpoSociosCollectionNew.add(tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach);
            }
            tematicaParticExpoSociosCollectionNew = attachedTematicaParticExpoSociosCollectionNew;
            particExpoSocios.setTematicaParticExpoSociosCollection(tematicaParticExpoSociosCollectionNew);
            particExpoSocios = em.merge(particExpoSocios);
            if (idExposicionOld != null && !idExposicionOld.equals(idExposicionNew)) {
                idExposicionOld.getParticExpoSociosCollection().remove(particExpoSocios);
                idExposicionOld = em.merge(idExposicionOld);
            }
            if (idExposicionNew != null && !idExposicionNew.equals(idExposicionOld)) {
                idExposicionNew.getParticExpoSociosCollection().add(particExpoSocios);
                idExposicionNew = em.merge(idExposicionNew);
            }
            if (idSocioOld != null && !idSocioOld.equals(idSocioNew)) {
                idSocioOld.getParticExpoSociosCollection().remove(particExpoSocios);
                idSocioOld = em.merge(idSocioOld);
            }
            if (idSocioNew != null && !idSocioNew.equals(idSocioOld)) {
                idSocioNew.getParticExpoSociosCollection().add(particExpoSocios);
                idSocioNew = em.merge(idSocioNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getParticExpoSociosCollection().remove(particExpoSocios);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getParticExpoSociosCollection().add(particExpoSocios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios : tematicaParticExpoSociosCollectionOld) {
                if (!tematicaParticExpoSociosCollectionNew.contains(tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios)) {
                    tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios.setIdParticExpoSocios(null);
                    tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios);
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios : tematicaParticExpoSociosCollectionNew) {
                if (!tematicaParticExpoSociosCollectionOld.contains(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios)) {
                    ParticExpoSocios oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.getIdParticExpoSocios();
                    tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.setIdParticExpoSocios(particExpoSocios);
                    tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                    if (oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios != null && !oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.equals(particExpoSocios)) {
                        oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                        oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = em.merge(oldIdParticExpoSociosOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = particExpoSocios.getId();
                if (findParticExpoSocios(id) == null) {
                    throw new NonexistentEntityException("The particExpoSocios with id " + id + " no longer exists.");
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
            ParticExpoSocios particExpoSocios;
            try {
                particExpoSocios = em.getReference(ParticExpoSocios.class, id);
                particExpoSocios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The particExpoSocios with id " + id + " no longer exists.", enfe);
            }
            Exposiciones idExposicion = particExpoSocios.getIdExposicion();
            if (idExposicion != null) {
                idExposicion.getParticExpoSociosCollection().remove(particExpoSocios);
                idExposicion = em.merge(idExposicion);
            }
            Socios idSocio = particExpoSocios.getIdSocio();
            if (idSocio != null) {
                idSocio.getParticExpoSociosCollection().remove(particExpoSocios);
                idSocio = em.merge(idSocio);
            }
            Usuarios idUsuarioCreacion = particExpoSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getParticExpoSociosCollection().remove(particExpoSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection = particExpoSocios.getTematicaParticExpoSociosCollection();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSocios : tematicaParticExpoSociosCollection) {
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios.setIdParticExpoSocios(null);
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
            }
            em.remove(particExpoSocios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ParticExpoSocios> findParticExpoSociosEntities() {
        return findParticExpoSociosEntities(true, -1, -1);
    }

    public List<ParticExpoSocios> findParticExpoSociosEntities(int maxResults, int firstResult) {
        return findParticExpoSociosEntities(false, maxResults, firstResult);
    }

    private List<ParticExpoSocios> findParticExpoSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ParticExpoSocios.class));
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

    public ParticExpoSocios findParticExpoSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ParticExpoSocios.class, id);
        } finally {
            em.close();
        }
    }

    public int getParticExpoSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ParticExpoSocios> rt = cq.from(ParticExpoSocios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
