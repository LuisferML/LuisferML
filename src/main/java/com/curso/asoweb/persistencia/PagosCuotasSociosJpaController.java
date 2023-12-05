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
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.PagosCuotasSocios;
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
public class PagosCuotasSociosJpaController implements Serializable {

    public PagosCuotasSociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public PagosCuotasSociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PagosCuotasSocios pagosCuotasSocios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MovimientosSocios idMovimientoSocio = pagosCuotasSocios.getIdMovimientoSocio();
            if (idMovimientoSocio != null) {
                idMovimientoSocio = em.getReference(idMovimientoSocio.getClass(), idMovimientoSocio.getId());
                pagosCuotasSocios.setIdMovimientoSocio(idMovimientoSocio);
            }
            Opciones idEstado = pagosCuotasSocios.getIdEstado();
            if (idEstado != null) {
                idEstado = em.getReference(idEstado.getClass(), idEstado.getId());
                pagosCuotasSocios.setIdEstado(idEstado);
            }
            Opciones idMotivoExoneracion = pagosCuotasSocios.getIdMotivoExoneracion();
            if (idMotivoExoneracion != null) {
                idMotivoExoneracion = em.getReference(idMotivoExoneracion.getClass(), idMotivoExoneracion.getId());
                pagosCuotasSocios.setIdMotivoExoneracion(idMotivoExoneracion);
            }
            Socios idSocio = pagosCuotasSocios.getIdSocio();
            if (idSocio != null) {
                idSocio = em.getReference(idSocio.getClass(), idSocio.getId());
                pagosCuotasSocios.setIdSocio(idSocio);
            }
            Usuarios idUsuarioCreacion = pagosCuotasSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                pagosCuotasSocios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            em.persist(pagosCuotasSocios);
            if (idMovimientoSocio != null) {
                idMovimientoSocio.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idMovimientoSocio = em.merge(idMovimientoSocio);
            }
            if (idEstado != null) {
                idEstado.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idEstado = em.merge(idEstado);
            }
            if (idMotivoExoneracion != null) {
                idMotivoExoneracion.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idMotivoExoneracion = em.merge(idMotivoExoneracion);
            }
            if (idSocio != null) {
                idSocio.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idSocio = em.merge(idSocio);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PagosCuotasSocios pagosCuotasSocios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PagosCuotasSocios persistentPagosCuotasSocios = em.find(PagosCuotasSocios.class, pagosCuotasSocios.getId());
            MovimientosSocios idMovimientoSocioOld = persistentPagosCuotasSocios.getIdMovimientoSocio();
            MovimientosSocios idMovimientoSocioNew = pagosCuotasSocios.getIdMovimientoSocio();
            Opciones idEstadoOld = persistentPagosCuotasSocios.getIdEstado();
            Opciones idEstadoNew = pagosCuotasSocios.getIdEstado();
            Opciones idMotivoExoneracionOld = persistentPagosCuotasSocios.getIdMotivoExoneracion();
            Opciones idMotivoExoneracionNew = pagosCuotasSocios.getIdMotivoExoneracion();
            Socios idSocioOld = persistentPagosCuotasSocios.getIdSocio();
            Socios idSocioNew = pagosCuotasSocios.getIdSocio();
            Usuarios idUsuarioCreacionOld = persistentPagosCuotasSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = pagosCuotasSocios.getIdUsuarioCreacion();
            if (idMovimientoSocioNew != null) {
                idMovimientoSocioNew = em.getReference(idMovimientoSocioNew.getClass(), idMovimientoSocioNew.getId());
                pagosCuotasSocios.setIdMovimientoSocio(idMovimientoSocioNew);
            }
            if (idEstadoNew != null) {
                idEstadoNew = em.getReference(idEstadoNew.getClass(), idEstadoNew.getId());
                pagosCuotasSocios.setIdEstado(idEstadoNew);
            }
            if (idMotivoExoneracionNew != null) {
                idMotivoExoneracionNew = em.getReference(idMotivoExoneracionNew.getClass(), idMotivoExoneracionNew.getId());
                pagosCuotasSocios.setIdMotivoExoneracion(idMotivoExoneracionNew);
            }
            if (idSocioNew != null) {
                idSocioNew = em.getReference(idSocioNew.getClass(), idSocioNew.getId());
                pagosCuotasSocios.setIdSocio(idSocioNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                pagosCuotasSocios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            pagosCuotasSocios = em.merge(pagosCuotasSocios);
            if (idMovimientoSocioOld != null && !idMovimientoSocioOld.equals(idMovimientoSocioNew)) {
                idMovimientoSocioOld.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idMovimientoSocioOld = em.merge(idMovimientoSocioOld);
            }
            if (idMovimientoSocioNew != null && !idMovimientoSocioNew.equals(idMovimientoSocioOld)) {
                idMovimientoSocioNew.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idMovimientoSocioNew = em.merge(idMovimientoSocioNew);
            }
            if (idEstadoOld != null && !idEstadoOld.equals(idEstadoNew)) {
                idEstadoOld.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idEstadoOld = em.merge(idEstadoOld);
            }
            if (idEstadoNew != null && !idEstadoNew.equals(idEstadoOld)) {
                idEstadoNew.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idEstadoNew = em.merge(idEstadoNew);
            }
            if (idMotivoExoneracionOld != null && !idMotivoExoneracionOld.equals(idMotivoExoneracionNew)) {
                idMotivoExoneracionOld.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idMotivoExoneracionOld = em.merge(idMotivoExoneracionOld);
            }
            if (idMotivoExoneracionNew != null && !idMotivoExoneracionNew.equals(idMotivoExoneracionOld)) {
                idMotivoExoneracionNew.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idMotivoExoneracionNew = em.merge(idMotivoExoneracionNew);
            }
            if (idSocioOld != null && !idSocioOld.equals(idSocioNew)) {
                idSocioOld.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idSocioOld = em.merge(idSocioOld);
            }
            if (idSocioNew != null && !idSocioNew.equals(idSocioOld)) {
                idSocioNew.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idSocioNew = em.merge(idSocioNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getPagosCuotasSociosCollection().add(pagosCuotasSocios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pagosCuotasSocios.getId();
                if (findPagosCuotasSocios(id) == null) {
                    throw new NonexistentEntityException("The pagosCuotasSocios with id " + id + " no longer exists.");
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
            PagosCuotasSocios pagosCuotasSocios;
            try {
                pagosCuotasSocios = em.getReference(PagosCuotasSocios.class, id);
                pagosCuotasSocios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagosCuotasSocios with id " + id + " no longer exists.", enfe);
            }
            MovimientosSocios idMovimientoSocio = pagosCuotasSocios.getIdMovimientoSocio();
            if (idMovimientoSocio != null) {
                idMovimientoSocio.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idMovimientoSocio = em.merge(idMovimientoSocio);
            }
            Opciones idEstado = pagosCuotasSocios.getIdEstado();
            if (idEstado != null) {
                idEstado.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idEstado = em.merge(idEstado);
            }
            Opciones idMotivoExoneracion = pagosCuotasSocios.getIdMotivoExoneracion();
            if (idMotivoExoneracion != null) {
                idMotivoExoneracion.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idMotivoExoneracion = em.merge(idMotivoExoneracion);
            }
            Socios idSocio = pagosCuotasSocios.getIdSocio();
            if (idSocio != null) {
                idSocio.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idSocio = em.merge(idSocio);
            }
            Usuarios idUsuarioCreacion = pagosCuotasSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getPagosCuotasSociosCollection().remove(pagosCuotasSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            em.remove(pagosCuotasSocios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PagosCuotasSocios> findPagosCuotasSociosEntities() {
        return findPagosCuotasSociosEntities(true, -1, -1);
    }

    public List<PagosCuotasSocios> findPagosCuotasSociosEntities(int maxResults, int firstResult) {
        return findPagosCuotasSociosEntities(false, maxResults, firstResult);
    }

    private List<PagosCuotasSocios> findPagosCuotasSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PagosCuotasSocios.class));
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

    public PagosCuotasSocios findPagosCuotasSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PagosCuotasSocios.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagosCuotasSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PagosCuotasSocios> rt = cq.from(PagosCuotasSocios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
