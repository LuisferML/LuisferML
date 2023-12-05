/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.persistencia;

import com.curso.asoweb.logica.RolesUsuarios;
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
import javax.persistence.TypedQuery;

/**
 *
 * @author luis_
 */
public class RolesUsuariosJpaController implements Serializable {

    public RolesUsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
   
     public RolesUsuariosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RolesUsuarios rolesUsuarios) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios idUsuario = rolesUsuarios.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                rolesUsuarios.setIdUsuario(idUsuario);
            }
            em.persist(rolesUsuarios);
            if (idUsuario != null) {
                idUsuario.getRolesUsuariosCollection().add(rolesUsuarios);
                idUsuario = em.merge(idUsuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RolesUsuarios rolesUsuarios) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RolesUsuarios persistentRolesUsuarios = em.find(RolesUsuarios.class, rolesUsuarios.getRolesUsuarioId());
            Usuarios idUsuarioOld = persistentRolesUsuarios.getIdUsuario();
            Usuarios idUsuarioNew = rolesUsuarios.getIdUsuario();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                rolesUsuarios.setIdUsuario(idUsuarioNew);
            }
            rolesUsuarios = em.merge(rolesUsuarios);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getRolesUsuariosCollection().remove(rolesUsuarios);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getRolesUsuariosCollection().add(rolesUsuarios);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = rolesUsuarios.getRolesUsuarioId();
                if (findRolesUsuarios(id) == null) {
                    throw new NonexistentEntityException("The rolesUsuarios with id " + id + " no longer exists.");
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
            RolesUsuarios rolesUsuarios;
            try {
                rolesUsuarios = em.getReference(RolesUsuarios.class, id);
                rolesUsuarios.getRolesUsuarioId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rolesUsuarios with id " + id + " no longer exists.", enfe);
            }
            Usuarios idUsuario = rolesUsuarios.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getRolesUsuariosCollection().remove(rolesUsuarios);
                idUsuario = em.merge(idUsuario);
            }
            em.remove(rolesUsuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RolesUsuarios> findRolesUsuariosEntities() {
        return findRolesUsuariosEntities(true, -1, -1);
    }

    public List<RolesUsuarios> findRolesUsuariosEntities(int maxResults, int firstResult) {
        return findRolesUsuariosEntities(false, maxResults, firstResult);
    }

    private List<RolesUsuarios> findRolesUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RolesUsuarios.class));
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

    public RolesUsuarios findRolesUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RolesUsuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolesUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RolesUsuarios> rt = cq.from(RolesUsuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    
    
    
    //METODOS LUIS
    public RolesUsuarios findRolesByUsId(Usuarios us) {
        Usuarios user=us;
        int idUs=user.getId();

        
        EntityManager em = getEntityManager();
        try {

            System.out.println("el id a buscar es el : " + idUs);

            String jpql = "SELECT r FROM RolesUsuarios r WHERE r.idUsuario.id = :idus";

            TypedQuery<RolesUsuarios> query = em.createQuery(jpql, RolesUsuarios.class);
            query.setParameter("idus", idUs);

            List<RolesUsuarios> rolesLista = query.getResultList();
            if (!rolesLista.isEmpty()) {
                return rolesLista.get(0);
            } else {
                System.out.println("No se encontró el rol del usuario con id: " + idUs);
                return null;
            }
        } finally {
            em.close();
        }
    }
    
}
