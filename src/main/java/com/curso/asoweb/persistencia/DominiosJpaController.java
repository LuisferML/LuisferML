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
import com.curso.asoweb.logica.Dominios;
import java.util.ArrayList;
import java.util.Collection;
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.persistencia.exceptions.IllegalOrphanException;
import com.curso.asoweb.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis_
 */
public class DominiosJpaController implements Serializable {

    public DominiosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public DominiosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dominios dominios) {
        if (dominios.getDominiosCollection() == null) {
            dominios.setDominiosCollection(new ArrayList<Dominios>());
        }
        if (dominios.getOpcionesCollection() == null) {
            dominios.setOpcionesCollection(new ArrayList<Opciones>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dominios idDominioPadre = dominios.getIdDominioPadre();
            if (idDominioPadre != null) {
                idDominioPadre = em.getReference(idDominioPadre.getClass(), idDominioPadre.getId());
                dominios.setIdDominioPadre(idDominioPadre);
            }
            Collection<Dominios> attachedDominiosCollection = new ArrayList<Dominios>();
            for (Dominios dominiosCollectionDominiosToAttach : dominios.getDominiosCollection()) {
                dominiosCollectionDominiosToAttach = em.getReference(dominiosCollectionDominiosToAttach.getClass(), dominiosCollectionDominiosToAttach.getId());
                attachedDominiosCollection.add(dominiosCollectionDominiosToAttach);
            }
            dominios.setDominiosCollection(attachedDominiosCollection);
            Collection<Opciones> attachedOpcionesCollection = new ArrayList<Opciones>();
            for (Opciones opcionesCollectionOpcionesToAttach : dominios.getOpcionesCollection()) {
                opcionesCollectionOpcionesToAttach = em.getReference(opcionesCollectionOpcionesToAttach.getClass(), opcionesCollectionOpcionesToAttach.getId());
                attachedOpcionesCollection.add(opcionesCollectionOpcionesToAttach);
            }
            dominios.setOpcionesCollection(attachedOpcionesCollection);
            em.persist(dominios);
            if (idDominioPadre != null) {
                idDominioPadre.getDominiosCollection().add(dominios);
                idDominioPadre = em.merge(idDominioPadre);
            }
            for (Dominios dominiosCollectionDominios : dominios.getDominiosCollection()) {
                Dominios oldIdDominioPadreOfDominiosCollectionDominios = dominiosCollectionDominios.getIdDominioPadre();
                dominiosCollectionDominios.setIdDominioPadre(dominios);
                dominiosCollectionDominios = em.merge(dominiosCollectionDominios);
                if (oldIdDominioPadreOfDominiosCollectionDominios != null) {
                    oldIdDominioPadreOfDominiosCollectionDominios.getDominiosCollection().remove(dominiosCollectionDominios);
                    oldIdDominioPadreOfDominiosCollectionDominios = em.merge(oldIdDominioPadreOfDominiosCollectionDominios);
                }
            }
            for (Opciones opcionesCollectionOpciones : dominios.getOpcionesCollection()) {
                Dominios oldIdDominioOfOpcionesCollectionOpciones = opcionesCollectionOpciones.getIdDominio();
                opcionesCollectionOpciones.setIdDominio(dominios);
                opcionesCollectionOpciones = em.merge(opcionesCollectionOpciones);
                if (oldIdDominioOfOpcionesCollectionOpciones != null) {
                    oldIdDominioOfOpcionesCollectionOpciones.getOpcionesCollection().remove(opcionesCollectionOpciones);
                    oldIdDominioOfOpcionesCollectionOpciones = em.merge(oldIdDominioOfOpcionesCollectionOpciones);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dominios dominios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dominios persistentDominios = em.find(Dominios.class, dominios.getId());
            Dominios idDominioPadreOld = persistentDominios.getIdDominioPadre();
            Dominios idDominioPadreNew = dominios.getIdDominioPadre();
            Collection<Dominios> dominiosCollectionOld = persistentDominios.getDominiosCollection();
            Collection<Dominios> dominiosCollectionNew = dominios.getDominiosCollection();
            Collection<Opciones> opcionesCollectionOld = persistentDominios.getOpcionesCollection();
            Collection<Opciones> opcionesCollectionNew = dominios.getOpcionesCollection();
            List<String> illegalOrphanMessages = null;
            for (Opciones opcionesCollectionOldOpciones : opcionesCollectionOld) {
                if (!opcionesCollectionNew.contains(opcionesCollectionOldOpciones)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Opciones " + opcionesCollectionOldOpciones + " since its idDominio field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idDominioPadreNew != null) {
                idDominioPadreNew = em.getReference(idDominioPadreNew.getClass(), idDominioPadreNew.getId());
                dominios.setIdDominioPadre(idDominioPadreNew);
            }
            Collection<Dominios> attachedDominiosCollectionNew = new ArrayList<Dominios>();
            for (Dominios dominiosCollectionNewDominiosToAttach : dominiosCollectionNew) {
                dominiosCollectionNewDominiosToAttach = em.getReference(dominiosCollectionNewDominiosToAttach.getClass(), dominiosCollectionNewDominiosToAttach.getId());
                attachedDominiosCollectionNew.add(dominiosCollectionNewDominiosToAttach);
            }
            dominiosCollectionNew = attachedDominiosCollectionNew;
            dominios.setDominiosCollection(dominiosCollectionNew);
            Collection<Opciones> attachedOpcionesCollectionNew = new ArrayList<Opciones>();
            for (Opciones opcionesCollectionNewOpcionesToAttach : opcionesCollectionNew) {
                opcionesCollectionNewOpcionesToAttach = em.getReference(opcionesCollectionNewOpcionesToAttach.getClass(), opcionesCollectionNewOpcionesToAttach.getId());
                attachedOpcionesCollectionNew.add(opcionesCollectionNewOpcionesToAttach);
            }
            opcionesCollectionNew = attachedOpcionesCollectionNew;
            dominios.setOpcionesCollection(opcionesCollectionNew);
            dominios = em.merge(dominios);
            if (idDominioPadreOld != null && !idDominioPadreOld.equals(idDominioPadreNew)) {
                idDominioPadreOld.getDominiosCollection().remove(dominios);
                idDominioPadreOld = em.merge(idDominioPadreOld);
            }
            if (idDominioPadreNew != null && !idDominioPadreNew.equals(idDominioPadreOld)) {
                idDominioPadreNew.getDominiosCollection().add(dominios);
                idDominioPadreNew = em.merge(idDominioPadreNew);
            }
            for (Dominios dominiosCollectionOldDominios : dominiosCollectionOld) {
                if (!dominiosCollectionNew.contains(dominiosCollectionOldDominios)) {
                    dominiosCollectionOldDominios.setIdDominioPadre(null);
                    dominiosCollectionOldDominios = em.merge(dominiosCollectionOldDominios);
                }
            }
            for (Dominios dominiosCollectionNewDominios : dominiosCollectionNew) {
                if (!dominiosCollectionOld.contains(dominiosCollectionNewDominios)) {
                    Dominios oldIdDominioPadreOfDominiosCollectionNewDominios = dominiosCollectionNewDominios.getIdDominioPadre();
                    dominiosCollectionNewDominios.setIdDominioPadre(dominios);
                    dominiosCollectionNewDominios = em.merge(dominiosCollectionNewDominios);
                    if (oldIdDominioPadreOfDominiosCollectionNewDominios != null && !oldIdDominioPadreOfDominiosCollectionNewDominios.equals(dominios)) {
                        oldIdDominioPadreOfDominiosCollectionNewDominios.getDominiosCollection().remove(dominiosCollectionNewDominios);
                        oldIdDominioPadreOfDominiosCollectionNewDominios = em.merge(oldIdDominioPadreOfDominiosCollectionNewDominios);
                    }
                }
            }
            for (Opciones opcionesCollectionNewOpciones : opcionesCollectionNew) {
                if (!opcionesCollectionOld.contains(opcionesCollectionNewOpciones)) {
                    Dominios oldIdDominioOfOpcionesCollectionNewOpciones = opcionesCollectionNewOpciones.getIdDominio();
                    opcionesCollectionNewOpciones.setIdDominio(dominios);
                    opcionesCollectionNewOpciones = em.merge(opcionesCollectionNewOpciones);
                    if (oldIdDominioOfOpcionesCollectionNewOpciones != null && !oldIdDominioOfOpcionesCollectionNewOpciones.equals(dominios)) {
                        oldIdDominioOfOpcionesCollectionNewOpciones.getOpcionesCollection().remove(opcionesCollectionNewOpciones);
                        oldIdDominioOfOpcionesCollectionNewOpciones = em.merge(oldIdDominioOfOpcionesCollectionNewOpciones);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dominios.getId();
                if (findDominios(id) == null) {
                    throw new NonexistentEntityException("The dominios with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dominios dominios;
            try {
                dominios = em.getReference(Dominios.class, id);
                dominios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dominios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Opciones> opcionesCollectionOrphanCheck = dominios.getOpcionesCollection();
            for (Opciones opcionesCollectionOrphanCheckOpciones : opcionesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Dominios (" + dominios + ") cannot be destroyed since the Opciones " + opcionesCollectionOrphanCheckOpciones + " in its opcionesCollection field has a non-nullable idDominio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dominios idDominioPadre = dominios.getIdDominioPadre();
            if (idDominioPadre != null) {
                idDominioPadre.getDominiosCollection().remove(dominios);
                idDominioPadre = em.merge(idDominioPadre);
            }
            Collection<Dominios> dominiosCollection = dominios.getDominiosCollection();
            for (Dominios dominiosCollectionDominios : dominiosCollection) {
                dominiosCollectionDominios.setIdDominioPadre(null);
                dominiosCollectionDominios = em.merge(dominiosCollectionDominios);
            }
            em.remove(dominios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dominios> findDominiosEntities() {
        return findDominiosEntities(true, -1, -1);
    }

    public List<Dominios> findDominiosEntities(int maxResults, int firstResult) {
        return findDominiosEntities(false, maxResults, firstResult);
    }

    private List<Dominios> findDominiosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dominios.class));
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

    public Dominios findDominios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dominios.class, id);
        } finally {
            em.close();
        }
    }

    public int getDominiosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dominios> rt = cq.from(Dominios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
