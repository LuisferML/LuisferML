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
import com.curso.asoweb.logica.Menu;
import com.curso.asoweb.persistencia.exceptions.NonexistentEntityException;
import com.curso.asoweb.persistencia.exceptions.PreexistingEntityException;
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
public class MenuJpaController implements Serializable {

    public MenuJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public MenuJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Menu menu) throws PreexistingEntityException, Exception {
        if (menu.getMenuCollection() == null) {
            menu.setMenuCollection(new ArrayList<Menu>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menu idSubMenu = menu.getIdSubMenu();
            if (idSubMenu != null) {
                idSubMenu = em.getReference(idSubMenu.getClass(), idSubMenu.getId());
                menu.setIdSubMenu(idSubMenu);
            }
            Collection<Menu> attachedMenuCollection = new ArrayList<Menu>();
            for (Menu menuCollectionMenuToAttach : menu.getMenuCollection()) {
                menuCollectionMenuToAttach = em.getReference(menuCollectionMenuToAttach.getClass(), menuCollectionMenuToAttach.getId());
                attachedMenuCollection.add(menuCollectionMenuToAttach);
            }
            menu.setMenuCollection(attachedMenuCollection);
            em.persist(menu);
            if (idSubMenu != null) {
                idSubMenu.getMenuCollection().add(menu);
                idSubMenu = em.merge(idSubMenu);
            }
            for (Menu menuCollectionMenu : menu.getMenuCollection()) {
                Menu oldIdSubMenuOfMenuCollectionMenu = menuCollectionMenu.getIdSubMenu();
                menuCollectionMenu.setIdSubMenu(menu);
                menuCollectionMenu = em.merge(menuCollectionMenu);
                if (oldIdSubMenuOfMenuCollectionMenu != null) {
                    oldIdSubMenuOfMenuCollectionMenu.getMenuCollection().remove(menuCollectionMenu);
                    oldIdSubMenuOfMenuCollectionMenu = em.merge(oldIdSubMenuOfMenuCollectionMenu);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMenu(menu.getId()) != null) {
                throw new PreexistingEntityException("Menu " + menu + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menu menu) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Menu persistentMenu = em.find(Menu.class, menu.getId());
            Menu idSubMenuOld = persistentMenu.getIdSubMenu();
            Menu idSubMenuNew = menu.getIdSubMenu();
            Collection<Menu> menuCollectionOld = persistentMenu.getMenuCollection();
            Collection<Menu> menuCollectionNew = menu.getMenuCollection();
            if (idSubMenuNew != null) {
                idSubMenuNew = em.getReference(idSubMenuNew.getClass(), idSubMenuNew.getId());
                menu.setIdSubMenu(idSubMenuNew);
            }
            Collection<Menu> attachedMenuCollectionNew = new ArrayList<Menu>();
            for (Menu menuCollectionNewMenuToAttach : menuCollectionNew) {
                menuCollectionNewMenuToAttach = em.getReference(menuCollectionNewMenuToAttach.getClass(), menuCollectionNewMenuToAttach.getId());
                attachedMenuCollectionNew.add(menuCollectionNewMenuToAttach);
            }
            menuCollectionNew = attachedMenuCollectionNew;
            menu.setMenuCollection(menuCollectionNew);
            menu = em.merge(menu);
            if (idSubMenuOld != null && !idSubMenuOld.equals(idSubMenuNew)) {
                idSubMenuOld.getMenuCollection().remove(menu);
                idSubMenuOld = em.merge(idSubMenuOld);
            }
            if (idSubMenuNew != null && !idSubMenuNew.equals(idSubMenuOld)) {
                idSubMenuNew.getMenuCollection().add(menu);
                idSubMenuNew = em.merge(idSubMenuNew);
            }
            for (Menu menuCollectionOldMenu : menuCollectionOld) {
                if (!menuCollectionNew.contains(menuCollectionOldMenu)) {
                    menuCollectionOldMenu.setIdSubMenu(null);
                    menuCollectionOldMenu = em.merge(menuCollectionOldMenu);
                }
            }
            for (Menu menuCollectionNewMenu : menuCollectionNew) {
                if (!menuCollectionOld.contains(menuCollectionNewMenu)) {
                    Menu oldIdSubMenuOfMenuCollectionNewMenu = menuCollectionNewMenu.getIdSubMenu();
                    menuCollectionNewMenu.setIdSubMenu(menu);
                    menuCollectionNewMenu = em.merge(menuCollectionNewMenu);
                    if (oldIdSubMenuOfMenuCollectionNewMenu != null && !oldIdSubMenuOfMenuCollectionNewMenu.equals(menu)) {
                        oldIdSubMenuOfMenuCollectionNewMenu.getMenuCollection().remove(menuCollectionNewMenu);
                        oldIdSubMenuOfMenuCollectionNewMenu = em.merge(oldIdSubMenuOfMenuCollectionNewMenu);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = menu.getId();
                if (findMenu(id) == null) {
                    throw new NonexistentEntityException("The menu with id " + id + " no longer exists.");
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
            Menu menu;
            try {
                menu = em.getReference(Menu.class, id);
                menu.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menu with id " + id + " no longer exists.", enfe);
            }
            Menu idSubMenu = menu.getIdSubMenu();
            if (idSubMenu != null) {
                idSubMenu.getMenuCollection().remove(menu);
                idSubMenu = em.merge(idSubMenu);
            }
            Collection<Menu> menuCollection = menu.getMenuCollection();
            for (Menu menuCollectionMenu : menuCollection) {
                menuCollectionMenu.setIdSubMenu(null);
                menuCollectionMenu = em.merge(menuCollectionMenu);
            }
            em.remove(menu);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menu> findMenuEntities() {
        return findMenuEntities(true, -1, -1);
    }

    public List<Menu> findMenuEntities(int maxResults, int firstResult) {
        return findMenuEntities(false, maxResults, firstResult);
    }

    private List<Menu> findMenuEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menu.class));
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

    public Menu findMenu(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menu.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenuCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menu> rt = cq.from(Menu.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
