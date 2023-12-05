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
import com.curso.asoweb.logica.Menus;
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
public class MenusJpaController implements Serializable {

    public MenusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public MenusJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Menus menus) {
        if (menus.getMenusCollection() == null) {
            menus.setMenusCollection(new ArrayList<Menus>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menus idSubMenu = menus.getIdSubMenu();
            if (idSubMenu != null) {
                idSubMenu = em.getReference(idSubMenu.getClass(), idSubMenu.getId());
                menus.setIdSubMenu(idSubMenu);
            }
            Collection<Menus> attachedMenusCollection = new ArrayList<Menus>();
            for (Menus menusCollectionMenusToAttach : menus.getMenusCollection()) {
                menusCollectionMenusToAttach = em.getReference(menusCollectionMenusToAttach.getClass(), menusCollectionMenusToAttach.getId());
                attachedMenusCollection.add(menusCollectionMenusToAttach);
            }
            menus.setMenusCollection(attachedMenusCollection);
            em.persist(menus);
            if (idSubMenu != null) {
                idSubMenu.getMenusCollection().add(menus);
                idSubMenu = em.merge(idSubMenu);
            }
            for (Menus menusCollectionMenus : menus.getMenusCollection()) {
                Menus oldIdSubMenuOfMenusCollectionMenus = menusCollectionMenus.getIdSubMenu();
                menusCollectionMenus.setIdSubMenu(menus);
                menusCollectionMenus = em.merge(menusCollectionMenus);
                if (oldIdSubMenuOfMenusCollectionMenus != null) {
                    oldIdSubMenuOfMenusCollectionMenus.getMenusCollection().remove(menusCollectionMenus);
                    oldIdSubMenuOfMenusCollectionMenus = em.merge(oldIdSubMenuOfMenusCollectionMenus);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menus menus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menus persistentMenus = em.find(Menus.class, menus.getId());
            Menus idSubMenuOld = persistentMenus.getIdSubMenu();
            Menus idSubMenuNew = menus.getIdSubMenu();
            Collection<Menus> menusCollectionOld = persistentMenus.getMenusCollection();
            Collection<Menus> menusCollectionNew = menus.getMenusCollection();
            if (idSubMenuNew != null) {
                idSubMenuNew = em.getReference(idSubMenuNew.getClass(), idSubMenuNew.getId());
                menus.setIdSubMenu(idSubMenuNew);
            }
            Collection<Menus> attachedMenusCollectionNew = new ArrayList<Menus>();
            for (Menus menusCollectionNewMenusToAttach : menusCollectionNew) {
                menusCollectionNewMenusToAttach = em.getReference(menusCollectionNewMenusToAttach.getClass(), menusCollectionNewMenusToAttach.getId());
                attachedMenusCollectionNew.add(menusCollectionNewMenusToAttach);
            }
            menusCollectionNew = attachedMenusCollectionNew;
            menus.setMenusCollection(menusCollectionNew);
            menus = em.merge(menus);
            if (idSubMenuOld != null && !idSubMenuOld.equals(idSubMenuNew)) {
                idSubMenuOld.getMenusCollection().remove(menus);
                idSubMenuOld = em.merge(idSubMenuOld);
            }
            if (idSubMenuNew != null && !idSubMenuNew.equals(idSubMenuOld)) {
                idSubMenuNew.getMenusCollection().add(menus);
                idSubMenuNew = em.merge(idSubMenuNew);
            }
            for (Menus menusCollectionOldMenus : menusCollectionOld) {
                if (!menusCollectionNew.contains(menusCollectionOldMenus)) {
                    menusCollectionOldMenus.setIdSubMenu(null);
                    menusCollectionOldMenus = em.merge(menusCollectionOldMenus);
                }
            }
            for (Menus menusCollectionNewMenus : menusCollectionNew) {
                if (!menusCollectionOld.contains(menusCollectionNewMenus)) {
                    Menus oldIdSubMenuOfMenusCollectionNewMenus = menusCollectionNewMenus.getIdSubMenu();
                    menusCollectionNewMenus.setIdSubMenu(menus);
                    menusCollectionNewMenus = em.merge(menusCollectionNewMenus);
                    if (oldIdSubMenuOfMenusCollectionNewMenus != null && !oldIdSubMenuOfMenusCollectionNewMenus.equals(menus)) {
                        oldIdSubMenuOfMenusCollectionNewMenus.getMenusCollection().remove(menusCollectionNewMenus);
                        oldIdSubMenuOfMenusCollectionNewMenus = em.merge(oldIdSubMenuOfMenusCollectionNewMenus);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = menus.getId();
                if (findMenus(id) == null) {
                    throw new NonexistentEntityException("The menus with id " + id + " no longer exists.");
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
            Menus menus;
            try {
                menus = em.getReference(Menus.class, id);
                menus.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menus with id " + id + " no longer exists.", enfe);
            }
            Menus idSubMenu = menus.getIdSubMenu();
            if (idSubMenu != null) {
                idSubMenu.getMenusCollection().remove(menus);
                idSubMenu = em.merge(idSubMenu);
            }
            Collection<Menus> menusCollection = menus.getMenusCollection();
            for (Menus menusCollectionMenus : menusCollection) {
                menusCollectionMenus.setIdSubMenu(null);
                menusCollectionMenus = em.merge(menusCollectionMenus);
            }
            em.remove(menus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menus> findMenusEntities() {
        return findMenusEntities(true, -1, -1);
    }

    public List<Menus> findMenusEntities(int maxResults, int firstResult) {
        return findMenusEntities(false, maxResults, firstResult);
    }

    private List<Menus> findMenusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menus.class));
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

    public Menus findMenus(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menus.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menus> rt = cq.from(Menus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
