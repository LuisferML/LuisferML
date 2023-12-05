/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.MovimientosSocios;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.TiposMovimiento;
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.logica.PagosCuotasSocios;
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
public class MovimientosSociosJpaController implements Serializable {

    public MovimientosSociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public MovimientosSociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MovimientosSocios movimientosSocios) {
        if (movimientosSocios.getPagosCuotasSociosCollection() == null) {
            movimientosSocios.setPagosCuotasSociosCollection(new ArrayList<PagosCuotasSocios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Opciones idEstado = movimientosSocios.getIdEstado();
            if (idEstado != null) {
                idEstado = em.getReference(idEstado.getClass(), idEstado.getId());
                movimientosSocios.setIdEstado(idEstado);
            }
            Opciones idMedioPago = movimientosSocios.getIdMedioPago();
            if (idMedioPago != null) {
                idMedioPago = em.getReference(idMedioPago.getClass(), idMedioPago.getId());
                movimientosSocios.setIdMedioPago(idMedioPago);
            }
            Opciones idConcepto = movimientosSocios.getIdConcepto();
            if (idConcepto != null) {
                idConcepto = em.getReference(idConcepto.getClass(), idConcepto.getId());
                movimientosSocios.setIdConcepto(idConcepto);
            }
            Socios idSocio = movimientosSocios.getIdSocio();
            if (idSocio != null) {
                idSocio = em.getReference(idSocio.getClass(), idSocio.getId());
                movimientosSocios.setIdSocio(idSocio);
            }
            TiposMovimiento idTipoMovimiento = movimientosSocios.getIdTipoMovimiento();
            if (idTipoMovimiento != null) {
                idTipoMovimiento = em.getReference(idTipoMovimiento.getClass(), idTipoMovimiento.getId());
                movimientosSocios.setIdTipoMovimiento(idTipoMovimiento);
            }
            Usuarios idUsuarioCreacion = movimientosSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                movimientosSocios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            Usuarios idUsuarioAprobacion = movimientosSocios.getIdUsuarioAprobacion();
            if (idUsuarioAprobacion != null) {
                idUsuarioAprobacion = em.getReference(idUsuarioAprobacion.getClass(), idUsuarioAprobacion.getId());
                movimientosSocios.setIdUsuarioAprobacion(idUsuarioAprobacion);
            }
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollection = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSociosToAttach : movimientosSocios.getPagosCuotasSociosCollection()) {
                pagosCuotasSociosCollectionPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollection.add(pagosCuotasSociosCollectionPagosCuotasSociosToAttach);
            }
            movimientosSocios.setPagosCuotasSociosCollection(attachedPagosCuotasSociosCollection);
            em.persist(movimientosSocios);
            if (idEstado != null) {
                idEstado.getMovimientosSociosCollection().add(movimientosSocios);
                idEstado = em.merge(idEstado);
            }
            if (idMedioPago != null) {
                idMedioPago.getMovimientosSociosCollection().add(movimientosSocios);
                idMedioPago = em.merge(idMedioPago);
            }
            if (idConcepto != null) {
                idConcepto.getMovimientosSociosCollection().add(movimientosSocios);
                idConcepto = em.merge(idConcepto);
            }
            if (idSocio != null) {
                idSocio.getMovimientosSociosCollection().add(movimientosSocios);
                idSocio = em.merge(idSocio);
            }
            if (idTipoMovimiento != null) {
                idTipoMovimiento.getMovimientosSociosCollection().add(movimientosSocios);
                idTipoMovimiento = em.merge(idTipoMovimiento);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getMovimientosSociosCollection().add(movimientosSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            if (idUsuarioAprobacion != null) {
                idUsuarioAprobacion.getMovimientosSociosCollection().add(movimientosSocios);
                idUsuarioAprobacion = em.merge(idUsuarioAprobacion);
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : movimientosSocios.getPagosCuotasSociosCollection()) {
                MovimientosSocios oldIdMovimientoSocioOfPagosCuotasSociosCollectionPagosCuotasSocios = pagosCuotasSociosCollectionPagosCuotasSocios.getIdMovimientoSocio();
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdMovimientoSocio(movimientosSocios);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
                if (oldIdMovimientoSocioOfPagosCuotasSociosCollectionPagosCuotasSocios != null) {
                    oldIdMovimientoSocioOfPagosCuotasSociosCollectionPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionPagosCuotasSocios);
                    oldIdMovimientoSocioOfPagosCuotasSociosCollectionPagosCuotasSocios = em.merge(oldIdMovimientoSocioOfPagosCuotasSociosCollectionPagosCuotasSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MovimientosSocios movimientosSocios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MovimientosSocios persistentMovimientosSocios = em.find(MovimientosSocios.class, movimientosSocios.getId());
            Opciones idEstadoOld = persistentMovimientosSocios.getIdEstado();
            Opciones idEstadoNew = movimientosSocios.getIdEstado();
            Opciones idMedioPagoOld = persistentMovimientosSocios.getIdMedioPago();
            Opciones idMedioPagoNew = movimientosSocios.getIdMedioPago();
            Opciones idConceptoOld = persistentMovimientosSocios.getIdConcepto();
            Opciones idConceptoNew = movimientosSocios.getIdConcepto();
            Socios idSocioOld = persistentMovimientosSocios.getIdSocio();
            Socios idSocioNew = movimientosSocios.getIdSocio();
            TiposMovimiento idTipoMovimientoOld = persistentMovimientosSocios.getIdTipoMovimiento();
            TiposMovimiento idTipoMovimientoNew = movimientosSocios.getIdTipoMovimiento();
            Usuarios idUsuarioCreacionOld = persistentMovimientosSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = movimientosSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioAprobacionOld = persistentMovimientosSocios.getIdUsuarioAprobacion();
            Usuarios idUsuarioAprobacionNew = movimientosSocios.getIdUsuarioAprobacion();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionOld = persistentMovimientosSocios.getPagosCuotasSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionNew = movimientosSocios.getPagosCuotasSociosCollection();
            if (idEstadoNew != null) {
                idEstadoNew = em.getReference(idEstadoNew.getClass(), idEstadoNew.getId());
                movimientosSocios.setIdEstado(idEstadoNew);
            }
            if (idMedioPagoNew != null) {
                idMedioPagoNew = em.getReference(idMedioPagoNew.getClass(), idMedioPagoNew.getId());
                movimientosSocios.setIdMedioPago(idMedioPagoNew);
            }
            if (idConceptoNew != null) {
                idConceptoNew = em.getReference(idConceptoNew.getClass(), idConceptoNew.getId());
                movimientosSocios.setIdConcepto(idConceptoNew);
            }
            if (idSocioNew != null) {
                idSocioNew = em.getReference(idSocioNew.getClass(), idSocioNew.getId());
                movimientosSocios.setIdSocio(idSocioNew);
            }
            if (idTipoMovimientoNew != null) {
                idTipoMovimientoNew = em.getReference(idTipoMovimientoNew.getClass(), idTipoMovimientoNew.getId());
                movimientosSocios.setIdTipoMovimiento(idTipoMovimientoNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                movimientosSocios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            if (idUsuarioAprobacionNew != null) {
                idUsuarioAprobacionNew = em.getReference(idUsuarioAprobacionNew.getClass(), idUsuarioAprobacionNew.getId());
                movimientosSocios.setIdUsuarioAprobacion(idUsuarioAprobacionNew);
            }
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollectionNew = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach : pagosCuotasSociosCollectionNew) {
                pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollectionNew.add(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach);
            }
            pagosCuotasSociosCollectionNew = attachedPagosCuotasSociosCollectionNew;
            movimientosSocios.setPagosCuotasSociosCollection(pagosCuotasSociosCollectionNew);
            movimientosSocios = em.merge(movimientosSocios);
            if (idEstadoOld != null && !idEstadoOld.equals(idEstadoNew)) {
                idEstadoOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idEstadoOld = em.merge(idEstadoOld);
            }
            if (idEstadoNew != null && !idEstadoNew.equals(idEstadoOld)) {
                idEstadoNew.getMovimientosSociosCollection().add(movimientosSocios);
                idEstadoNew = em.merge(idEstadoNew);
            }
            if (idMedioPagoOld != null && !idMedioPagoOld.equals(idMedioPagoNew)) {
                idMedioPagoOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idMedioPagoOld = em.merge(idMedioPagoOld);
            }
            if (idMedioPagoNew != null && !idMedioPagoNew.equals(idMedioPagoOld)) {
                idMedioPagoNew.getMovimientosSociosCollection().add(movimientosSocios);
                idMedioPagoNew = em.merge(idMedioPagoNew);
            }
            if (idConceptoOld != null && !idConceptoOld.equals(idConceptoNew)) {
                idConceptoOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idConceptoOld = em.merge(idConceptoOld);
            }
            if (idConceptoNew != null && !idConceptoNew.equals(idConceptoOld)) {
                idConceptoNew.getMovimientosSociosCollection().add(movimientosSocios);
                idConceptoNew = em.merge(idConceptoNew);
            }
            if (idSocioOld != null && !idSocioOld.equals(idSocioNew)) {
                idSocioOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idSocioOld = em.merge(idSocioOld);
            }
            if (idSocioNew != null && !idSocioNew.equals(idSocioOld)) {
                idSocioNew.getMovimientosSociosCollection().add(movimientosSocios);
                idSocioNew = em.merge(idSocioNew);
            }
            if (idTipoMovimientoOld != null && !idTipoMovimientoOld.equals(idTipoMovimientoNew)) {
                idTipoMovimientoOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idTipoMovimientoOld = em.merge(idTipoMovimientoOld);
            }
            if (idTipoMovimientoNew != null && !idTipoMovimientoNew.equals(idTipoMovimientoOld)) {
                idTipoMovimientoNew.getMovimientosSociosCollection().add(movimientosSocios);
                idTipoMovimientoNew = em.merge(idTipoMovimientoNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.getMovimientosSociosCollection().add(movimientosSocios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            if (idUsuarioAprobacionOld != null && !idUsuarioAprobacionOld.equals(idUsuarioAprobacionNew)) {
                idUsuarioAprobacionOld.getMovimientosSociosCollection().remove(movimientosSocios);
                idUsuarioAprobacionOld = em.merge(idUsuarioAprobacionOld);
            }
            if (idUsuarioAprobacionNew != null && !idUsuarioAprobacionNew.equals(idUsuarioAprobacionOld)) {
                idUsuarioAprobacionNew.getMovimientosSociosCollection().add(movimientosSocios);
                idUsuarioAprobacionNew = em.merge(idUsuarioAprobacionNew);
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionOldPagosCuotasSocios : pagosCuotasSociosCollectionOld) {
                if (!pagosCuotasSociosCollectionNew.contains(pagosCuotasSociosCollectionOldPagosCuotasSocios)) {
                    pagosCuotasSociosCollectionOldPagosCuotasSocios.setIdMovimientoSocio(null);
                    pagosCuotasSociosCollectionOldPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionOldPagosCuotasSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSocios : pagosCuotasSociosCollectionNew) {
                if (!pagosCuotasSociosCollectionOld.contains(pagosCuotasSociosCollectionNewPagosCuotasSocios)) {
                    MovimientosSocios oldIdMovimientoSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios = pagosCuotasSociosCollectionNewPagosCuotasSocios.getIdMovimientoSocio();
                    pagosCuotasSociosCollectionNewPagosCuotasSocios.setIdMovimientoSocio(movimientosSocios);
                    pagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                    if (oldIdMovimientoSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios != null && !oldIdMovimientoSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios.equals(movimientosSocios)) {
                        oldIdMovimientoSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                        oldIdMovimientoSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(oldIdMovimientoSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = movimientosSocios.getId();
                if (findMovimientosSocios(id) == null) {
                    throw new NonexistentEntityException("The movimientosSocios with id " + id + " no longer exists.");
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
            MovimientosSocios movimientosSocios;
            try {
                movimientosSocios = em.getReference(MovimientosSocios.class, id);
                movimientosSocios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimientosSocios with id " + id + " no longer exists.", enfe);
            }
            Opciones idEstado = movimientosSocios.getIdEstado();
            if (idEstado != null) {
                idEstado.getMovimientosSociosCollection().remove(movimientosSocios);
                idEstado = em.merge(idEstado);
            }
            Opciones idMedioPago = movimientosSocios.getIdMedioPago();
            if (idMedioPago != null) {
                idMedioPago.getMovimientosSociosCollection().remove(movimientosSocios);
                idMedioPago = em.merge(idMedioPago);
            }
            Opciones idConcepto = movimientosSocios.getIdConcepto();
            if (idConcepto != null) {
                idConcepto.getMovimientosSociosCollection().remove(movimientosSocios);
                idConcepto = em.merge(idConcepto);
            }
            Socios idSocio = movimientosSocios.getIdSocio();
            if (idSocio != null) {
                idSocio.getMovimientosSociosCollection().remove(movimientosSocios);
                idSocio = em.merge(idSocio);
            }
            TiposMovimiento idTipoMovimiento = movimientosSocios.getIdTipoMovimiento();
            if (idTipoMovimiento != null) {
                idTipoMovimiento.getMovimientosSociosCollection().remove(movimientosSocios);
                idTipoMovimiento = em.merge(idTipoMovimiento);
            }
            Usuarios idUsuarioCreacion = movimientosSocios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.getMovimientosSociosCollection().remove(movimientosSocios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            Usuarios idUsuarioAprobacion = movimientosSocios.getIdUsuarioAprobacion();
            if (idUsuarioAprobacion != null) {
                idUsuarioAprobacion.getMovimientosSociosCollection().remove(movimientosSocios);
                idUsuarioAprobacion = em.merge(idUsuarioAprobacion);
            }
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection = movimientosSocios.getPagosCuotasSociosCollection();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : pagosCuotasSociosCollection) {
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdMovimientoSocio(null);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
            }
            em.remove(movimientosSocios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MovimientosSocios> findMovimientosSociosEntities() {
        return findMovimientosSociosEntities(true, -1, -1);
    }

    public List<MovimientosSocios> findMovimientosSociosEntities(int maxResults, int firstResult) {
        return findMovimientosSociosEntities(false, maxResults, firstResult);
    }

    private List<MovimientosSocios> findMovimientosSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MovimientosSocios.class));
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

    public MovimientosSocios findMovimientosSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MovimientosSocios.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimientosSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MovimientosSocios> rt = cq.from(MovimientosSocios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
