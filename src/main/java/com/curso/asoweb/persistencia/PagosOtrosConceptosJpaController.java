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
import com.curso.asoweb.logica.PagosOtrosConceptos;
import com.curso.asoweb.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis_
 */
public class PagosOtrosConceptosJpaController implements Serializable {

    public PagosOtrosConceptosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public PagosOtrosConceptosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PagosOtrosConceptos pagosOtrosConceptos) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Opciones idConcepto = pagosOtrosConceptos.getIdConcepto();
            if (idConcepto != null) {
                idConcepto = em.getReference(idConcepto.getClass(), idConcepto.getId());
                pagosOtrosConceptos.setIdConcepto(idConcepto);
            }
            Opciones idEstado = pagosOtrosConceptos.getIdEstado();
            if (idEstado != null) {
                idEstado = em.getReference(idEstado.getClass(), idEstado.getId());
                pagosOtrosConceptos.setIdEstado(idEstado);
            }
            Opciones idMedioPago = pagosOtrosConceptos.getIdMedioPago();
            if (idMedioPago != null) {
                idMedioPago = em.getReference(idMedioPago.getClass(), idMedioPago.getId());
                pagosOtrosConceptos.setIdMedioPago(idMedioPago);
            }
            em.persist(pagosOtrosConceptos);
            if (idConcepto != null) {
                idConcepto.getPagosOtrosConceptosCollection().add(pagosOtrosConceptos);
                idConcepto = em.merge(idConcepto);
            }
            if (idEstado != null) {
                idEstado.getPagosOtrosConceptosCollection().add(pagosOtrosConceptos);
                idEstado = em.merge(idEstado);
            }
            if (idMedioPago != null) {
                idMedioPago.getPagosOtrosConceptosCollection().add(pagosOtrosConceptos);
                idMedioPago = em.merge(idMedioPago);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PagosOtrosConceptos pagosOtrosConceptos) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PagosOtrosConceptos persistentPagosOtrosConceptos = em.find(PagosOtrosConceptos.class, pagosOtrosConceptos.getId());
            Opciones idConceptoOld = persistentPagosOtrosConceptos.getIdConcepto();
            Opciones idConceptoNew = pagosOtrosConceptos.getIdConcepto();
            Opciones idEstadoOld = persistentPagosOtrosConceptos.getIdEstado();
            Opciones idEstadoNew = pagosOtrosConceptos.getIdEstado();
            Opciones idMedioPagoOld = persistentPagosOtrosConceptos.getIdMedioPago();
            Opciones idMedioPagoNew = pagosOtrosConceptos.getIdMedioPago();
            if (idConceptoNew != null) {
                idConceptoNew = em.getReference(idConceptoNew.getClass(), idConceptoNew.getId());
                pagosOtrosConceptos.setIdConcepto(idConceptoNew);
            }
            if (idEstadoNew != null) {
                idEstadoNew = em.getReference(idEstadoNew.getClass(), idEstadoNew.getId());
                pagosOtrosConceptos.setIdEstado(idEstadoNew);
            }
            if (idMedioPagoNew != null) {
                idMedioPagoNew = em.getReference(idMedioPagoNew.getClass(), idMedioPagoNew.getId());
                pagosOtrosConceptos.setIdMedioPago(idMedioPagoNew);
            }
            pagosOtrosConceptos = em.merge(pagosOtrosConceptos);
            if (idConceptoOld != null && !idConceptoOld.equals(idConceptoNew)) {
                idConceptoOld.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptos);
                idConceptoOld = em.merge(idConceptoOld);
            }
            if (idConceptoNew != null && !idConceptoNew.equals(idConceptoOld)) {
                idConceptoNew.getPagosOtrosConceptosCollection().add(pagosOtrosConceptos);
                idConceptoNew = em.merge(idConceptoNew);
            }
            if (idEstadoOld != null && !idEstadoOld.equals(idEstadoNew)) {
                idEstadoOld.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptos);
                idEstadoOld = em.merge(idEstadoOld);
            }
            if (idEstadoNew != null && !idEstadoNew.equals(idEstadoOld)) {
                idEstadoNew.getPagosOtrosConceptosCollection().add(pagosOtrosConceptos);
                idEstadoNew = em.merge(idEstadoNew);
            }
            if (idMedioPagoOld != null && !idMedioPagoOld.equals(idMedioPagoNew)) {
                idMedioPagoOld.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptos);
                idMedioPagoOld = em.merge(idMedioPagoOld);
            }
            if (idMedioPagoNew != null && !idMedioPagoNew.equals(idMedioPagoOld)) {
                idMedioPagoNew.getPagosOtrosConceptosCollection().add(pagosOtrosConceptos);
                idMedioPagoNew = em.merge(idMedioPagoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pagosOtrosConceptos.getId();
                if (findPagosOtrosConceptos(id) == null) {
                    throw new NonexistentEntityException("The pagosOtrosConceptos with id " + id + " no longer exists.");
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
            PagosOtrosConceptos pagosOtrosConceptos;
            try {
                pagosOtrosConceptos = em.getReference(PagosOtrosConceptos.class, id);
                pagosOtrosConceptos.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagosOtrosConceptos with id " + id + " no longer exists.", enfe);
            }
            Opciones idConcepto = pagosOtrosConceptos.getIdConcepto();
            if (idConcepto != null) {
                idConcepto.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptos);
                idConcepto = em.merge(idConcepto);
            }
            Opciones idEstado = pagosOtrosConceptos.getIdEstado();
            if (idEstado != null) {
                idEstado.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptos);
                idEstado = em.merge(idEstado);
            }
            Opciones idMedioPago = pagosOtrosConceptos.getIdMedioPago();
            if (idMedioPago != null) {
                idMedioPago.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptos);
                idMedioPago = em.merge(idMedioPago);
            }
            em.remove(pagosOtrosConceptos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PagosOtrosConceptos> findPagosOtrosConceptosEntities() {
        return findPagosOtrosConceptosEntities(true, -1, -1);
    }

    public List<PagosOtrosConceptos> findPagosOtrosConceptosEntities(int maxResults, int firstResult) {
        return findPagosOtrosConceptosEntities(false, maxResults, firstResult);
    }

    private List<PagosOtrosConceptos> findPagosOtrosConceptosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PagosOtrosConceptos.class));
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

    public PagosOtrosConceptos findPagosOtrosConceptos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PagosOtrosConceptos.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagosOtrosConceptosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PagosOtrosConceptos> rt = cq.from(PagosOtrosConceptos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
