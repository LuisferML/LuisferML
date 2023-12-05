/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.Exposiciones;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.logica.ParticExpoSocios;
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
public class ExposicionesJpaController implements Serializable {

    public ExposicionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public ExposicionesJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Exposiciones exposiciones) {
        if (exposiciones.getParticExpoSociosCollection() == null) {
            exposiciones.setParticExpoSociosCollection(new ArrayList<ParticExpoSocios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios idUsuarioCreacion = exposiciones.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                exposiciones.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            Collection<ParticExpoSocios> attachedParticExpoSociosCollection = new ArrayList<ParticExpoSocios>();
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSociosToAttach : exposiciones.getParticExpoSociosCollection()) {
                particExpoSociosCollectionParticExpoSociosToAttach = em.getReference(particExpoSociosCollectionParticExpoSociosToAttach.getClass(), particExpoSociosCollectionParticExpoSociosToAttach.getId());
                attachedParticExpoSociosCollection.add(particExpoSociosCollectionParticExpoSociosToAttach);
            }
            exposiciones.setParticExpoSociosCollection(attachedParticExpoSociosCollection);
            em.persist(exposiciones);
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getExposicionesCollection().add(exposiciones);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSocios : exposiciones.getParticExpoSociosCollection()) {
                Exposiciones oldIdExposicionOfParticExpoSociosCollectionParticExpoSocios = particExpoSociosCollectionParticExpoSocios.getIdExposicion();
                particExpoSociosCollectionParticExpoSocios.setIdExposicion(exposiciones);
                particExpoSociosCollectionParticExpoSocios = em.merge(particExpoSociosCollectionParticExpoSocios);
                if (oldIdExposicionOfParticExpoSociosCollectionParticExpoSocios != null) {
                    oldIdExposicionOfParticExpoSociosCollectionParticExpoSocios.getParticExpoSociosCollection().remove(particExpoSociosCollectionParticExpoSocios);
                    oldIdExposicionOfParticExpoSociosCollectionParticExpoSocios = em.merge(oldIdExposicionOfParticExpoSociosCollectionParticExpoSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Exposiciones exposiciones) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Exposiciones persistentExposiciones = em.find(Exposiciones.class, exposiciones.getId());
            Usuarios idUsuarioCreacionOld = persistentExposiciones.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = exposiciones.getIdUsuarioCreacion();
            Collection<ParticExpoSocios> particExpoSociosCollectionOld = persistentExposiciones.getParticExpoSociosCollection();
            Collection<ParticExpoSocios> particExpoSociosCollectionNew = exposiciones.getParticExpoSociosCollection();
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                exposiciones.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            Collection<ParticExpoSocios> attachedParticExpoSociosCollectionNew = new ArrayList<ParticExpoSocios>();
            for (ParticExpoSocios particExpoSociosCollectionNewParticExpoSociosToAttach : particExpoSociosCollectionNew) {
                particExpoSociosCollectionNewParticExpoSociosToAttach = em.getReference(particExpoSociosCollectionNewParticExpoSociosToAttach.getClass(), particExpoSociosCollectionNewParticExpoSociosToAttach.getId());
                attachedParticExpoSociosCollectionNew.add(particExpoSociosCollectionNewParticExpoSociosToAttach);
            }
            particExpoSociosCollectionNew = attachedParticExpoSociosCollectionNew;
            exposiciones.setParticExpoSociosCollection(particExpoSociosCollectionNew);
            exposiciones = em.merge(exposiciones);
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getExposicionesCollection().remove(exposiciones);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getExposicionesCollection().add(exposiciones);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            for (ParticExpoSocios particExpoSociosCollectionOldParticExpoSocios : particExpoSociosCollectionOld) {
                if (!particExpoSociosCollectionNew.contains(particExpoSociosCollectionOldParticExpoSocios)) {
                    particExpoSociosCollectionOldParticExpoSocios.setIdExposicion(null);
                    particExpoSociosCollectionOldParticExpoSocios = em.merge(particExpoSociosCollectionOldParticExpoSocios);
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionNewParticExpoSocios : particExpoSociosCollectionNew) {
                if (!particExpoSociosCollectionOld.contains(particExpoSociosCollectionNewParticExpoSocios)) {
                    Exposiciones oldIdExposicionOfParticExpoSociosCollectionNewParticExpoSocios = particExpoSociosCollectionNewParticExpoSocios.getIdExposicion();
                    particExpoSociosCollectionNewParticExpoSocios.setIdExposicion(exposiciones);
                    particExpoSociosCollectionNewParticExpoSocios = em.merge(particExpoSociosCollectionNewParticExpoSocios);
                    if (oldIdExposicionOfParticExpoSociosCollectionNewParticExpoSocios != null && !oldIdExposicionOfParticExpoSociosCollectionNewParticExpoSocios.equals(exposiciones)) {
                        oldIdExposicionOfParticExpoSociosCollectionNewParticExpoSocios.getParticExpoSociosCollection().remove(particExpoSociosCollectionNewParticExpoSocios);
                        oldIdExposicionOfParticExpoSociosCollectionNewParticExpoSocios = em.merge(oldIdExposicionOfParticExpoSociosCollectionNewParticExpoSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = exposiciones.getId();
                if (findExposiciones(id) == null) {
                    throw new NonexistentEntityException("The exposiciones with id " + id + " no longer exists.");
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
            Exposiciones exposiciones;
            try {
                exposiciones = em.getReference(Exposiciones.class, id);
                exposiciones.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The exposiciones with id " + id + " no longer exists.", enfe);
            }
            Usuarios idUsuarioCreacion = exposiciones.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getExposicionesCollection().remove(exposiciones);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            Collection<ParticExpoSocios> particExpoSociosCollection = exposiciones.getParticExpoSociosCollection();
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSocios : particExpoSociosCollection) {
                particExpoSociosCollectionParticExpoSocios.setIdExposicion(null);
                particExpoSociosCollectionParticExpoSocios = em.merge(particExpoSociosCollectionParticExpoSocios);
            }
            em.remove(exposiciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Exposiciones> findExposicionesEntities() {
        return findExposicionesEntities(true, -1, -1);
    }

    public List<Exposiciones> findExposicionesEntities(int maxResults, int firstResult) {
        return findExposicionesEntities(false, maxResults, firstResult);
    }

    private List<Exposiciones> findExposicionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Exposiciones.class));
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

    public Exposiciones findExposiciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Exposiciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getExposicionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Exposiciones> rt = cq.from(Exposiciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
