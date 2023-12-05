/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.MensajesEnviadosSocios;
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
public class MensajesEnviadosSociosJpaController implements Serializable {

    public MensajesEnviadosSociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public MensajesEnviadosSociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MensajesEnviadosSocios mensajesEnviadosSocios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Opciones idMensaje = mensajesEnviadosSocios.getIdMensaje();
            if (idMensaje != null) {
                idMensaje = em.getReference(idMensaje.getClass(), idMensaje.getId());
                mensajesEnviadosSocios.setIdMensaje(idMensaje);
            }
            Socios idSocioDestino = mensajesEnviadosSocios.getIdSocioDestino();
            if (idSocioDestino != null) {
                idSocioDestino = em.getReference(idSocioDestino.getClass(), idSocioDestino.getId());
                mensajesEnviadosSocios.setIdSocioDestino(idSocioDestino);
            }
            Usuarios idUsuarioCreacion = mensajesEnviadosSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                mensajesEnviadosSocios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            em.persist(mensajesEnviadosSocios);
            if (idMensaje != null) {
                idMensaje.getMensajesEnviadosSociosCollection().add(mensajesEnviadosSocios);
                idMensaje = em.merge(idMensaje);
            }
            if (idSocioDestino != null) {
                idSocioDestino.getMensajesEnviadosSociosCollection().add(mensajesEnviadosSocios);
                idSocioDestino = em.merge(idSocioDestino);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getMensajesEnviadosSociosCollection().add(mensajesEnviadosSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MensajesEnviadosSocios mensajesEnviadosSocios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MensajesEnviadosSocios persistentMensajesEnviadosSocios = em.find(MensajesEnviadosSocios.class, mensajesEnviadosSocios.getId());
            Opciones idMensajeOld = persistentMensajesEnviadosSocios.getIdMensaje();
            Opciones idMensajeNew = mensajesEnviadosSocios.getIdMensaje();
            Socios idSocioDestinoOld = persistentMensajesEnviadosSocios.getIdSocioDestino();
            Socios idSocioDestinoNew = mensajesEnviadosSocios.getIdSocioDestino();
            Usuarios idUsuarioCreacionOld = persistentMensajesEnviadosSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = mensajesEnviadosSocios.getIdUsuarioCreacion();
            if (idMensajeNew != null) {
                idMensajeNew = em.getReference(idMensajeNew.getClass(), idMensajeNew.getId());
                mensajesEnviadosSocios.setIdMensaje(idMensajeNew);
            }
            if (idSocioDestinoNew != null) {
                idSocioDestinoNew = em.getReference(idSocioDestinoNew.getClass(), idSocioDestinoNew.getId());
                mensajesEnviadosSocios.setIdSocioDestino(idSocioDestinoNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                mensajesEnviadosSocios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            mensajesEnviadosSocios = em.merge(mensajesEnviadosSocios);
            if (idMensajeOld != null && !idMensajeOld.equals(idMensajeNew)) {
                idMensajeOld.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSocios);
                idMensajeOld = em.merge(idMensajeOld);
            }
            if (idMensajeNew != null && !idMensajeNew.equals(idMensajeOld)) {
                idMensajeNew.getMensajesEnviadosSociosCollection().add(mensajesEnviadosSocios);
                idMensajeNew = em.merge(idMensajeNew);
            }
            if (idSocioDestinoOld != null && !idSocioDestinoOld.equals(idSocioDestinoNew)) {
                idSocioDestinoOld.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSocios);
                idSocioDestinoOld = em.merge(idSocioDestinoOld);
            }
            if (idSocioDestinoNew != null && !idSocioDestinoNew.equals(idSocioDestinoOld)) {
                idSocioDestinoNew.getMensajesEnviadosSociosCollection().add(mensajesEnviadosSocios);
                idSocioDestinoNew = em.merge(idSocioDestinoNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSocios);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getMensajesEnviadosSociosCollection().add(mensajesEnviadosSocios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mensajesEnviadosSocios.getId();
                if (findMensajesEnviadosSocios(id) == null) {
                    throw new NonexistentEntityException("The mensajesEnviadosSocios with id " + id + " no longer exists.");
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
            MensajesEnviadosSocios mensajesEnviadosSocios;
            try {
                mensajesEnviadosSocios = em.getReference(MensajesEnviadosSocios.class, id);
                mensajesEnviadosSocios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mensajesEnviadosSocios with id " + id + " no longer exists.", enfe);
            }
            Opciones idMensaje = mensajesEnviadosSocios.getIdMensaje();
            if (idMensaje != null) {
                idMensaje.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSocios);
                idMensaje = em.merge(idMensaje);
            }
            Socios idSocioDestino = mensajesEnviadosSocios.getIdSocioDestino();
            if (idSocioDestino != null) {
                idSocioDestino.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSocios);
                idSocioDestino = em.merge(idSocioDestino);
            }
            Usuarios idUsuarioCreacion = mensajesEnviadosSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.remove(mensajesEnviadosSocios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MensajesEnviadosSocios> findMensajesEnviadosSociosEntities() {
        return findMensajesEnviadosSociosEntities(true, -1, -1);
    }

    public List<MensajesEnviadosSocios> findMensajesEnviadosSociosEntities(int maxResults, int firstResult) {
        return findMensajesEnviadosSociosEntities(false, maxResults, firstResult);
    }

    private List<MensajesEnviadosSocios> findMensajesEnviadosSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MensajesEnviadosSocios.class));
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

    public MensajesEnviadosSocios findMensajesEnviadosSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MensajesEnviadosSocios.class, id);
        } finally {
            em.close();
        }
    }

    public int getMensajesEnviadosSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MensajesEnviadosSocios> rt = cq.from(MensajesEnviadosSocios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
