/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.CodigoDeSeguridad;
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
public class CodigoDeSeguridadJpaController implements Serializable {

    public CodigoDeSeguridadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public CodigoDeSeguridadJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    
    
    
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CodigoDeSeguridad codigoDeSeguridad) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios idUsuario = codigoDeSeguridad.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                codigoDeSeguridad.setIdUsuario(idUsuario);
            }
            em.persist(codigoDeSeguridad);
            if (idUsuario != null) {
                idUsuario.getCodigoDeSeguridadCollection().add(codigoDeSeguridad);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CodigoDeSeguridad codigoDeSeguridad) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            CodigoDeSeguridad persistentCodigoDeSeguridad = em.find(CodigoDeSeguridad.class, codigoDeSeguridad.getId());
            Usuarios idUsuarioOld = persistentCodigoDeSeguridad.getIdUsuario();
            Usuarios idUsuarioNew = codigoDeSeguridad.getIdUsuario();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                codigoDeSeguridad.setIdUsuario(idUsuarioNew);
            }
            codigoDeSeguridad = em.merge(codigoDeSeguridad);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getCodigoDeSeguridadCollection().remove(codigoDeSeguridad);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getCodigoDeSeguridadCollection().add(codigoDeSeguridad);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = codigoDeSeguridad.getId();
                if (findCodigoDeSeguridad(id) == null) {
                    throw new NonexistentEntityException("The codigoDeSeguridad with id " + id + " no longer exists.");
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
            CodigoDeSeguridad codigoDeSeguridad;
            try {
                codigoDeSeguridad = em.getReference(CodigoDeSeguridad.class, id);
                codigoDeSeguridad.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The codigoDeSeguridad with id " + id + " no longer exists.", enfe);
            }
            Usuarios idUsuario = codigoDeSeguridad.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getCodigoDeSeguridadCollection().remove(codigoDeSeguridad);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(codigoDeSeguridad);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CodigoDeSeguridad> findCodigoDeSeguridadEntities() {
        return findCodigoDeSeguridadEntities(true, -1, -1);
    }

    public List<CodigoDeSeguridad> findCodigoDeSeguridadEntities(int maxResults, int firstResult) {
        return findCodigoDeSeguridadEntities(false, maxResults, firstResult);
    }

    private List<CodigoDeSeguridad> findCodigoDeSeguridadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CodigoDeSeguridad.class));
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

    public CodigoDeSeguridad findCodigoDeSeguridad(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CodigoDeSeguridad.class, id);
        } finally {
            em.close();
        }
    }

    public int getCodigoDeSeguridadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CodigoDeSeguridad> rt = cq.from(CodigoDeSeguridad.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
