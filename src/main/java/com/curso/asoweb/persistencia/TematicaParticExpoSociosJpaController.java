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
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.ParticExpoSocios;
import com.curso.asoweb.logica.TematicaParticExpoSocios;
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
public class TematicaParticExpoSociosJpaController implements Serializable {

    public TematicaParticExpoSociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public TematicaParticExpoSociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TematicaParticExpoSocios tematicaParticExpoSocios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Opciones idTematicaGeneral = tematicaParticExpoSocios.getIdTematicaGeneral();
            if (idTematicaGeneral != null) {
                idTematicaGeneral = em.getReference(idTematicaGeneral.getClass(), idTematicaGeneral.getId());
                tematicaParticExpoSocios.setIdTematicaGeneral(idTematicaGeneral);
            }
            ParticExpoSocios idParticExpoSocios = tematicaParticExpoSocios.getIdParticExpoSocios();
            if (idParticExpoSocios != null) {
                idParticExpoSocios = em.getReference(idParticExpoSocios.getClass(), idParticExpoSocios.getId());
                tematicaParticExpoSocios.setIdParticExpoSocios(idParticExpoSocios);
            }
            Usuarios idUsuarioCreacion = tematicaParticExpoSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                tematicaParticExpoSocios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            em.persist(tematicaParticExpoSocios);
            if (idTematicaGeneral != null) {
                idTematicaGeneral.getTematicaParticExpoSociosCollection().add(tematicaParticExpoSocios);
                idTematicaGeneral = em.merge(idTematicaGeneral);
            }
            if (idParticExpoSocios != null) {
                idParticExpoSocios.getTematicaParticExpoSociosCollection().add(tematicaParticExpoSocios);
                idParticExpoSocios = em.merge(idParticExpoSocios);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getTematicaParticExpoSociosCollection().add(tematicaParticExpoSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TematicaParticExpoSocios tematicaParticExpoSocios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TematicaParticExpoSocios persistentTematicaParticExpoSocios = em.find(TematicaParticExpoSocios.class, tematicaParticExpoSocios.getId());
            Opciones idTematicaGeneralOld = persistentTematicaParticExpoSocios.getIdTematicaGeneral();
            Opciones idTematicaGeneralNew = tematicaParticExpoSocios.getIdTematicaGeneral();
            ParticExpoSocios idParticExpoSociosOld = persistentTematicaParticExpoSocios.getIdParticExpoSocios();
            ParticExpoSocios idParticExpoSociosNew = tematicaParticExpoSocios.getIdParticExpoSocios();
            Usuarios idUsuarioCreacionOld = persistentTematicaParticExpoSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = tematicaParticExpoSocios.getIdUsuarioCreacion();
            if (idTematicaGeneralNew != null) {
                idTematicaGeneralNew = em.getReference(idTematicaGeneralNew.getClass(), idTematicaGeneralNew.getId());
                tematicaParticExpoSocios.setIdTematicaGeneral(idTematicaGeneralNew);
            }
            if (idParticExpoSociosNew != null) {
                idParticExpoSociosNew = em.getReference(idParticExpoSociosNew.getClass(), idParticExpoSociosNew.getId());
                tematicaParticExpoSocios.setIdParticExpoSocios(idParticExpoSociosNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                tematicaParticExpoSocios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            tematicaParticExpoSocios = em.merge(tematicaParticExpoSocios);
            if (idTematicaGeneralOld != null && !idTematicaGeneralOld.equals(idTematicaGeneralNew)) {
                idTematicaGeneralOld.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSocios);
                idTematicaGeneralOld = em.merge(idTematicaGeneralOld);
            }
            if (idTematicaGeneralNew != null && !idTematicaGeneralNew.equals(idTematicaGeneralOld)) {
                idTematicaGeneralNew.getTematicaParticExpoSociosCollection().add(tematicaParticExpoSocios);
                idTematicaGeneralNew = em.merge(idTematicaGeneralNew);
            }
            if (idParticExpoSociosOld != null && !idParticExpoSociosOld.equals(idParticExpoSociosNew)) {
                idParticExpoSociosOld.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSocios);
                idParticExpoSociosOld = em.merge(idParticExpoSociosOld);
            }
            if (idParticExpoSociosNew != null && !idParticExpoSociosNew.equals(idParticExpoSociosOld)) {
                idParticExpoSociosNew.getTematicaParticExpoSociosCollection().add(tematicaParticExpoSocios);
                idParticExpoSociosNew = em.merge(idParticExpoSociosNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSocios);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getTematicaParticExpoSociosCollection().add(tematicaParticExpoSocios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tematicaParticExpoSocios.getId();
                if (findTematicaParticExpoSocios(id) == null) {
                    throw new NonexistentEntityException("The tematicaParticExpoSocios with id " + id + " no longer exists.");
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
            TematicaParticExpoSocios tematicaParticExpoSocios;
            try {
                tematicaParticExpoSocios = em.getReference(TematicaParticExpoSocios.class, id);
                tematicaParticExpoSocios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tematicaParticExpoSocios with id " + id + " no longer exists.", enfe);
            }
            Opciones idTematicaGeneral = tematicaParticExpoSocios.getIdTematicaGeneral();
            if (idTematicaGeneral != null) {
                idTematicaGeneral.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSocios);
                idTematicaGeneral = em.merge(idTematicaGeneral);
            }
            ParticExpoSocios idParticExpoSocios = tematicaParticExpoSocios.getIdParticExpoSocios();
            if (idParticExpoSocios != null) {
                idParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSocios);
                idParticExpoSocios = em.merge(idParticExpoSocios);
            }
            Usuarios idUsuarioCreacion = tematicaParticExpoSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.remove(tematicaParticExpoSocios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TematicaParticExpoSocios> findTematicaParticExpoSociosEntities() {
        return findTematicaParticExpoSociosEntities(true, -1, -1);
    }

    public List<TematicaParticExpoSocios> findTematicaParticExpoSociosEntities(int maxResults, int firstResult) {
        return findTematicaParticExpoSociosEntities(false, maxResults, firstResult);
    }

    private List<TematicaParticExpoSocios> findTematicaParticExpoSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TematicaParticExpoSocios.class));
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

    public TematicaParticExpoSocios findTematicaParticExpoSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TematicaParticExpoSocios.class, id);
        } finally {
            em.close();
        }
    }

    public int getTematicaParticExpoSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TematicaParticExpoSocios> rt = cq.from(TematicaParticExpoSocios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
