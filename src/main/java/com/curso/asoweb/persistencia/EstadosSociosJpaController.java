/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.EstadosSocios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.Socios;
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
public class EstadosSociosJpaController implements Serializable {

    public EstadosSociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public EstadosSociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadosSocios estadosSocios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Opciones idEstado = estadosSocios.getIdEstado();
            if (idEstado != null) {
                idEstado = em.getReference(idEstado.getClass(), idEstado.getId());
                estadosSocios.setIdEstado(idEstado);
            }
            Socios idSocio = estadosSocios.getIdSocio();
            if (idSocio != null) {
                idSocio = em.getReference(idSocio.getClass(), idSocio.getId());
                estadosSocios.setIdSocio(idSocio);
            }
            Usuarios idUsuarioCreacion = estadosSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                estadosSocios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            em.persist(estadosSocios);
            if (idEstado != null) {
                idEstado.getEstadosSociosCollection().add(estadosSocios);
                idEstado = em.merge(idEstado);
            }
            if (idSocio != null) {
                idSocio.getEstadosSociosCollection().add(estadosSocios);
                idSocio = em.merge(idSocio);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getEstadosSociosCollection().add(estadosSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadosSocios estadosSocios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadosSocios persistentEstadosSocios = em.find(EstadosSocios.class, estadosSocios.getId());
            Opciones idEstadoOld = persistentEstadosSocios.getIdEstado();
            Opciones idEstadoNew = estadosSocios.getIdEstado();
            Socios idSocioOld = persistentEstadosSocios.getIdSocio();
            Socios idSocioNew = estadosSocios.getIdSocio();
            Usuarios idUsuarioCreacionOld = persistentEstadosSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = estadosSocios.getIdUsuarioCreacion();
            if (idEstadoNew != null) {
                idEstadoNew = em.getReference(idEstadoNew.getClass(), idEstadoNew.getId());
                estadosSocios.setIdEstado(idEstadoNew);
            }
            if (idSocioNew != null) {
                idSocioNew = em.getReference(idSocioNew.getClass(), idSocioNew.getId());
                estadosSocios.setIdSocio(idSocioNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                estadosSocios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            estadosSocios = em.merge(estadosSocios);
            if (idEstadoOld != null && !idEstadoOld.equals(idEstadoNew)) {
                idEstadoOld.getEstadosSociosCollection().remove(estadosSocios);
                idEstadoOld = em.merge(idEstadoOld);
            }
            if (idEstadoNew != null && !idEstadoNew.equals(idEstadoOld)) {
                idEstadoNew.getEstadosSociosCollection().add(estadosSocios);
                idEstadoNew = em.merge(idEstadoNew);
            }
            if (idSocioOld != null && !idSocioOld.equals(idSocioNew)) {
                idSocioOld.getEstadosSociosCollection().remove(estadosSocios);
                idSocioOld = em.merge(idSocioOld);
            }
            if (idSocioNew != null && !idSocioNew.equals(idSocioOld)) {
                idSocioNew.getEstadosSociosCollection().add(estadosSocios);
                idSocioNew = em.merge(idSocioNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getEstadosSociosCollection().remove(estadosSocios);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getEstadosSociosCollection().add(estadosSocios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = estadosSocios.getId();
                if (findEstadosSocios(id) == null) {
                    throw new NonexistentEntityException("The estadosSocios with id " + id + " no longer exists.");
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
            EstadosSocios estadosSocios;
            try {
                estadosSocios = em.getReference(EstadosSocios.class, id);
                estadosSocios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadosSocios with id " + id + " no longer exists.", enfe);
            }
            Opciones idEstado = estadosSocios.getIdEstado();
            if (idEstado != null) {
                idEstado.getEstadosSociosCollection().remove(estadosSocios);
                idEstado = em.merge(idEstado);
            }
            Socios idSocio = estadosSocios.getIdSocio();
            if (idSocio != null) {
                idSocio.getEstadosSociosCollection().remove(estadosSocios);
                idSocio = em.merge(idSocio);
            }
            Usuarios idUsuarioCreacion = estadosSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getEstadosSociosCollection().remove(estadosSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.remove(estadosSocios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadosSocios> findEstadosSociosEntities() {
        return findEstadosSociosEntities(true, -1, -1);
    }

    public List<EstadosSocios> findEstadosSociosEntities(int maxResults, int firstResult) {
        return findEstadosSociosEntities(false, maxResults, firstResult);
    }

    private List<EstadosSocios> findEstadosSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadosSocios.class));
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

    public EstadosSocios findEstadosSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadosSocios.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadosSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadosSocios> rt = cq.from(EstadosSocios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
