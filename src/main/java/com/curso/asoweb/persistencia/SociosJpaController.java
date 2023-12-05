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
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.EstadosSocios;
import java.util.ArrayList;
import java.util.Collection;
import com.curso.asoweb.logica.MensajesEnviadosSocios;
import com.curso.asoweb.logica.ParticExpoSocios;
import com.curso.asoweb.logica.PagosCuotasSocios;
import com.curso.asoweb.logica.MovimientosSocios;
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
public class SociosJpaController implements Serializable {

    public SociosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public SociosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Socios socios) throws IllegalOrphanException {
        if (socios.getEstadosSociosCollection() == null) {
            socios.setEstadosSociosCollection(new ArrayList<EstadosSocios>());
        }
        if (socios.getSociosCollection() == null) {
            socios.setSociosCollection(new ArrayList<Socios>());
        }
        if (socios.getMensajesEnviadosSociosCollection() == null) {
            socios.setMensajesEnviadosSociosCollection(new ArrayList<MensajesEnviadosSocios>());
        }
        if (socios.getParticExpoSociosCollection() == null) {
            socios.setParticExpoSociosCollection(new ArrayList<ParticExpoSocios>());
        }
        if (socios.getPagosCuotasSociosCollection() == null) {
            socios.setPagosCuotasSociosCollection(new ArrayList<PagosCuotasSocios>());
        }
        if (socios.getMovimientosSociosCollection() == null) {
            socios.setMovimientosSociosCollection(new ArrayList<MovimientosSocios>());
        }
        List<String> illegalOrphanMessages = null;
        Usuarios idUsuarioCreacionOrphanCheck = socios.getIdUsuarioCreacion();
        if (idUsuarioCreacionOrphanCheck != null) {
            Socios oldIdSocioOfIdUsuarioCreacion = idUsuarioCreacionOrphanCheck.getIdSocio();
            if (oldIdSocioOfIdUsuarioCreacion != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Usuarios " + idUsuarioCreacionOrphanCheck + " already has an item of type Socios whose idUsuarioCreacion column cannot be null. Please make another selection for the idUsuarioCreacion field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios usuarios = socios.getUsuarios();
            if (usuarios != null) {
                usuarios = em.getReference(usuarios.getClass(), usuarios.getId());
                socios.setUsuarios(usuarios);
            }
            Opciones idEstadoActual = socios.getIdEstadoActual();
            if (idEstadoActual != null) {
                idEstadoActual = em.getReference(idEstadoActual.getClass(), idEstadoActual.getId());
                socios.setIdEstadoActual(idEstadoActual);
            }
            Opciones idTipoSocio = socios.getIdTipoSocio();
            if (idTipoSocio != null) {
                idTipoSocio = em.getReference(idTipoSocio.getClass(), idTipoSocio.getId());
                socios.setIdTipoSocio(idTipoSocio);
            }
            Socios idSocioProponente = socios.getIdSocioProponente();
            if (idSocioProponente != null) {
                idSocioProponente = em.getReference(idSocioProponente.getClass(), idSocioProponente.getId());
                socios.setIdSocioProponente(idSocioProponente);
            }
            Usuarios idUsuarioCreacion = socios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion = em.getReference(idUsuarioCreacion.getClass(), idUsuarioCreacion.getId());
                socios.setIdUsuarioCreacion(idUsuarioCreacion);
            }
            Collection<EstadosSocios> attachedEstadosSociosCollection = new ArrayList<EstadosSocios>();
            for (EstadosSocios estadosSociosCollectionEstadosSociosToAttach : socios.getEstadosSociosCollection()) {
                estadosSociosCollectionEstadosSociosToAttach = em.getReference(estadosSociosCollectionEstadosSociosToAttach.getClass(), estadosSociosCollectionEstadosSociosToAttach.getId());
                attachedEstadosSociosCollection.add(estadosSociosCollectionEstadosSociosToAttach);
            }
            socios.setEstadosSociosCollection(attachedEstadosSociosCollection);
            Collection<Socios> attachedSociosCollection = new ArrayList<Socios>();
            for (Socios sociosCollectionSociosToAttach : socios.getSociosCollection()) {
                sociosCollectionSociosToAttach = em.getReference(sociosCollectionSociosToAttach.getClass(), sociosCollectionSociosToAttach.getId());
                attachedSociosCollection.add(sociosCollectionSociosToAttach);
            }
            socios.setSociosCollection(attachedSociosCollection);
            Collection<MensajesEnviadosSocios> attachedMensajesEnviadosSociosCollection = new ArrayList<MensajesEnviadosSocios>();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach : socios.getMensajesEnviadosSociosCollection()) {
                mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach = em.getReference(mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach.getClass(), mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach.getId());
                attachedMensajesEnviadosSociosCollection.add(mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach);
            }
            socios.setMensajesEnviadosSociosCollection(attachedMensajesEnviadosSociosCollection);
            Collection<ParticExpoSocios> attachedParticExpoSociosCollection = new ArrayList<ParticExpoSocios>();
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSociosToAttach : socios.getParticExpoSociosCollection()) {
                particExpoSociosCollectionParticExpoSociosToAttach = em.getReference(particExpoSociosCollectionParticExpoSociosToAttach.getClass(), particExpoSociosCollectionParticExpoSociosToAttach.getId());
                attachedParticExpoSociosCollection.add(particExpoSociosCollectionParticExpoSociosToAttach);
            }
            socios.setParticExpoSociosCollection(attachedParticExpoSociosCollection);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollection = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSociosToAttach : socios.getPagosCuotasSociosCollection()) {
                pagosCuotasSociosCollectionPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollection.add(pagosCuotasSociosCollectionPagosCuotasSociosToAttach);
            }
            socios.setPagosCuotasSociosCollection(attachedPagosCuotasSociosCollection);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSociosToAttach : socios.getMovimientosSociosCollection()) {
                movimientosSociosCollectionMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionMovimientosSociosToAttach.getClass(), movimientosSociosCollectionMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection.add(movimientosSociosCollectionMovimientosSociosToAttach);
            }
            socios.setMovimientosSociosCollection(attachedMovimientosSociosCollection);
            em.persist(socios);
            if (usuarios != null) {
                Socios oldIdSocioOfUsuarios = usuarios.getIdSocio();
                if (oldIdSocioOfUsuarios != null) {
                    oldIdSocioOfUsuarios.setUsuarios(null);
                    oldIdSocioOfUsuarios = em.merge(oldIdSocioOfUsuarios);
                }
                usuarios.setIdSocio(socios);
                usuarios = em.merge(usuarios);
            }
            if (idEstadoActual != null) {
                idEstadoActual.getSociosCollection().add(socios);
                idEstadoActual = em.merge(idEstadoActual);
            }
            if (idTipoSocio != null) {
                idTipoSocio.getSociosCollection().add(socios);
                idTipoSocio = em.merge(idTipoSocio);
            }
            if (idSocioProponente != null) {
                idSocioProponente.getSociosCollection().add(socios);
                idSocioProponente = em.merge(idSocioProponente);
            }
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.setIdSocio(socios);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            for (EstadosSocios estadosSociosCollectionEstadosSocios : socios.getEstadosSociosCollection()) {
                Socios oldIdSocioOfEstadosSociosCollectionEstadosSocios = estadosSociosCollectionEstadosSocios.getIdSocio();
                estadosSociosCollectionEstadosSocios.setIdSocio(socios);
                estadosSociosCollectionEstadosSocios = em.merge(estadosSociosCollectionEstadosSocios);
                if (oldIdSocioOfEstadosSociosCollectionEstadosSocios != null) {
                    oldIdSocioOfEstadosSociosCollectionEstadosSocios.getEstadosSociosCollection().remove(estadosSociosCollectionEstadosSocios);
                    oldIdSocioOfEstadosSociosCollectionEstadosSocios = em.merge(oldIdSocioOfEstadosSociosCollectionEstadosSocios);
                }
            }
            for (Socios sociosCollectionSocios : socios.getSociosCollection()) {
                Socios oldIdSocioProponenteOfSociosCollectionSocios = sociosCollectionSocios.getIdSocioProponente();
                sociosCollectionSocios.setIdSocioProponente(socios);
                sociosCollectionSocios = em.merge(sociosCollectionSocios);
                if (oldIdSocioProponenteOfSociosCollectionSocios != null) {
                    oldIdSocioProponenteOfSociosCollectionSocios.getSociosCollection().remove(sociosCollectionSocios);
                    oldIdSocioProponenteOfSociosCollectionSocios = em.merge(oldIdSocioProponenteOfSociosCollectionSocios);
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionMensajesEnviadosSocios : socios.getMensajesEnviadosSociosCollection()) {
                Socios oldIdSocioDestinoOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios = mensajesEnviadosSociosCollectionMensajesEnviadosSocios.getIdSocioDestino();
                mensajesEnviadosSociosCollectionMensajesEnviadosSocios.setIdSocioDestino(socios);
                mensajesEnviadosSociosCollectionMensajesEnviadosSocios = em.merge(mensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                if (oldIdSocioDestinoOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios != null) {
                    oldIdSocioDestinoOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                    oldIdSocioDestinoOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios = em.merge(oldIdSocioDestinoOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSocios : socios.getParticExpoSociosCollection()) {
                Socios oldIdSocioOfParticExpoSociosCollectionParticExpoSocios = particExpoSociosCollectionParticExpoSocios.getIdSocio();
                particExpoSociosCollectionParticExpoSocios.setIdSocio(socios);
                particExpoSociosCollectionParticExpoSocios = em.merge(particExpoSociosCollectionParticExpoSocios);
                if (oldIdSocioOfParticExpoSociosCollectionParticExpoSocios != null) {
                    oldIdSocioOfParticExpoSociosCollectionParticExpoSocios.getParticExpoSociosCollection().remove(particExpoSociosCollectionParticExpoSocios);
                    oldIdSocioOfParticExpoSociosCollectionParticExpoSocios = em.merge(oldIdSocioOfParticExpoSociosCollectionParticExpoSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : socios.getPagosCuotasSociosCollection()) {
                Socios oldIdSocioOfPagosCuotasSociosCollectionPagosCuotasSocios = pagosCuotasSociosCollectionPagosCuotasSocios.getIdSocio();
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdSocio(socios);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
                if (oldIdSocioOfPagosCuotasSociosCollectionPagosCuotasSocios != null) {
                    oldIdSocioOfPagosCuotasSociosCollectionPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionPagosCuotasSocios);
                    oldIdSocioOfPagosCuotasSociosCollectionPagosCuotasSocios = em.merge(oldIdSocioOfPagosCuotasSociosCollectionPagosCuotasSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : socios.getMovimientosSociosCollection()) {
                Socios oldIdSocioOfMovimientosSociosCollectionMovimientosSocios = movimientosSociosCollectionMovimientosSocios.getIdSocio();
                movimientosSociosCollectionMovimientosSocios.setIdSocio(socios);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
                if (oldIdSocioOfMovimientosSociosCollectionMovimientosSocios != null) {
                    oldIdSocioOfMovimientosSociosCollectionMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionMovimientosSocios);
                    oldIdSocioOfMovimientosSociosCollectionMovimientosSocios = em.merge(oldIdSocioOfMovimientosSociosCollectionMovimientosSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Socios socios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Socios persistentSocios = em.find(Socios.class, socios.getId());
            Usuarios usuariosOld = persistentSocios.getUsuarios();
            Usuarios usuariosNew = socios.getUsuarios();
            Opciones idEstadoActualOld = persistentSocios.getIdEstadoActual();
            Opciones idEstadoActualNew = socios.getIdEstadoActual();
            Opciones idTipoSocioOld = persistentSocios.getIdTipoSocio();
            Opciones idTipoSocioNew = socios.getIdTipoSocio();
            Socios idSocioProponenteOld = persistentSocios.getIdSocioProponente();
            Socios idSocioProponenteNew = socios.getIdSocioProponente();
            Usuarios idUsuarioCreacionOld = persistentSocios.getIdUsuarioCreacion();
            Usuarios idUsuarioCreacionNew = socios.getIdUsuarioCreacion();
            Collection<EstadosSocios> estadosSociosCollectionOld = persistentSocios.getEstadosSociosCollection();
            Collection<EstadosSocios> estadosSociosCollectionNew = socios.getEstadosSociosCollection();
            Collection<Socios> sociosCollectionOld = persistentSocios.getSociosCollection();
            Collection<Socios> sociosCollectionNew = socios.getSociosCollection();
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionOld = persistentSocios.getMensajesEnviadosSociosCollection();
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionNew = socios.getMensajesEnviadosSociosCollection();
            Collection<ParticExpoSocios> particExpoSociosCollectionOld = persistentSocios.getParticExpoSociosCollection();
            Collection<ParticExpoSocios> particExpoSociosCollectionNew = socios.getParticExpoSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionOld = persistentSocios.getPagosCuotasSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionNew = socios.getPagosCuotasSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollectionOld = persistentSocios.getMovimientosSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollectionNew = socios.getMovimientosSociosCollection();
            List<String> illegalOrphanMessages = null;
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                Socios oldIdSocioOfIdUsuarioCreacion = idUsuarioCreacionNew.getIdSocio();
                if (oldIdSocioOfIdUsuarioCreacion != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Usuarios " + idUsuarioCreacionNew + " already has an item of type Socios whose idUsuarioCreacion column cannot be null. Please make another selection for the idUsuarioCreacion field.");
                }
            }
            for (EstadosSocios estadosSociosCollectionOldEstadosSocios : estadosSociosCollectionOld) {
                if (!estadosSociosCollectionNew.contains(estadosSociosCollectionOldEstadosSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EstadosSocios " + estadosSociosCollectionOldEstadosSocios + " since its idSocio field is not nullable.");
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios : mensajesEnviadosSociosCollectionOld) {
                if (!mensajesEnviadosSociosCollectionNew.contains(mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MensajesEnviadosSocios " + mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios + " since its idSocioDestino field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (usuariosNew != null) {
                usuariosNew = em.getReference(usuariosNew.getClass(), usuariosNew.getId());
                socios.setUsuarios(usuariosNew);
            }
            if (idEstadoActualNew != null) {
                idEstadoActualNew = em.getReference(idEstadoActualNew.getClass(), idEstadoActualNew.getId());
                socios.setIdEstadoActual(idEstadoActualNew);
            }
            if (idTipoSocioNew != null) {
                idTipoSocioNew = em.getReference(idTipoSocioNew.getClass(), idTipoSocioNew.getId());
                socios.setIdTipoSocio(idTipoSocioNew);
            }
            if (idSocioProponenteNew != null) {
                idSocioProponenteNew = em.getReference(idSocioProponenteNew.getClass(), idSocioProponenteNew.getId());
                socios.setIdSocioProponente(idSocioProponenteNew);
            }
            if (idUsuarioCreacionNew != null) {
                idUsuarioCreacionNew = em.getReference(idUsuarioCreacionNew.getClass(), idUsuarioCreacionNew.getId());
                socios.setIdUsuarioCreacion(idUsuarioCreacionNew);
            }
            Collection<EstadosSocios> attachedEstadosSociosCollectionNew = new ArrayList<EstadosSocios>();
            for (EstadosSocios estadosSociosCollectionNewEstadosSociosToAttach : estadosSociosCollectionNew) {
                estadosSociosCollectionNewEstadosSociosToAttach = em.getReference(estadosSociosCollectionNewEstadosSociosToAttach.getClass(), estadosSociosCollectionNewEstadosSociosToAttach.getId());
                attachedEstadosSociosCollectionNew.add(estadosSociosCollectionNewEstadosSociosToAttach);
            }
            estadosSociosCollectionNew = attachedEstadosSociosCollectionNew;
            socios.setEstadosSociosCollection(estadosSociosCollectionNew);
            Collection<Socios> attachedSociosCollectionNew = new ArrayList<Socios>();
            for (Socios sociosCollectionNewSociosToAttach : sociosCollectionNew) {
                sociosCollectionNewSociosToAttach = em.getReference(sociosCollectionNewSociosToAttach.getClass(), sociosCollectionNewSociosToAttach.getId());
                attachedSociosCollectionNew.add(sociosCollectionNewSociosToAttach);
            }
            sociosCollectionNew = attachedSociosCollectionNew;
            socios.setSociosCollection(sociosCollectionNew);
            Collection<MensajesEnviadosSocios> attachedMensajesEnviadosSociosCollectionNew = new ArrayList<MensajesEnviadosSocios>();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach : mensajesEnviadosSociosCollectionNew) {
                mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach = em.getReference(mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach.getClass(), mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach.getId());
                attachedMensajesEnviadosSociosCollectionNew.add(mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach);
            }
            mensajesEnviadosSociosCollectionNew = attachedMensajesEnviadosSociosCollectionNew;
            socios.setMensajesEnviadosSociosCollection(mensajesEnviadosSociosCollectionNew);
            Collection<ParticExpoSocios> attachedParticExpoSociosCollectionNew = new ArrayList<ParticExpoSocios>();
            for (ParticExpoSocios particExpoSociosCollectionNewParticExpoSociosToAttach : particExpoSociosCollectionNew) {
                particExpoSociosCollectionNewParticExpoSociosToAttach = em.getReference(particExpoSociosCollectionNewParticExpoSociosToAttach.getClass(), particExpoSociosCollectionNewParticExpoSociosToAttach.getId());
                attachedParticExpoSociosCollectionNew.add(particExpoSociosCollectionNewParticExpoSociosToAttach);
            }
            particExpoSociosCollectionNew = attachedParticExpoSociosCollectionNew;
            socios.setParticExpoSociosCollection(particExpoSociosCollectionNew);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollectionNew = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach : pagosCuotasSociosCollectionNew) {
                pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollectionNew.add(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach);
            }
            pagosCuotasSociosCollectionNew = attachedPagosCuotasSociosCollectionNew;
            socios.setPagosCuotasSociosCollection(pagosCuotasSociosCollectionNew);
            Collection<MovimientosSocios> attachedMovimientosSociosCollectionNew = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSociosToAttach : movimientosSociosCollectionNew) {
                movimientosSociosCollectionNewMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionNewMovimientosSociosToAttach.getClass(), movimientosSociosCollectionNewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollectionNew.add(movimientosSociosCollectionNewMovimientosSociosToAttach);
            }
            movimientosSociosCollectionNew = attachedMovimientosSociosCollectionNew;
            socios.setMovimientosSociosCollection(movimientosSociosCollectionNew);
            socios = em.merge(socios);
            if (usuariosOld != null && !usuariosOld.equals(usuariosNew)) {
                usuariosOld.setIdSocio(null);
                usuariosOld = em.merge(usuariosOld);
            }
            if (usuariosNew != null && !usuariosNew.equals(usuariosOld)) {
                Socios oldIdSocioOfUsuarios = usuariosNew.getIdSocio();
                if (oldIdSocioOfUsuarios != null) {
                    oldIdSocioOfUsuarios.setUsuarios(null);
                    oldIdSocioOfUsuarios = em.merge(oldIdSocioOfUsuarios);
                }
                usuariosNew.setIdSocio(socios);
                usuariosNew = em.merge(usuariosNew);
            }
            if (idEstadoActualOld != null && !idEstadoActualOld.equals(idEstadoActualNew)) {
                idEstadoActualOld.getSociosCollection().remove(socios);
                idEstadoActualOld = em.merge(idEstadoActualOld);
            }
            if (idEstadoActualNew != null && !idEstadoActualNew.equals(idEstadoActualOld)) {
                idEstadoActualNew.getSociosCollection().add(socios);
                idEstadoActualNew = em.merge(idEstadoActualNew);
            }
            if (idTipoSocioOld != null && !idTipoSocioOld.equals(idTipoSocioNew)) {
                idTipoSocioOld.getSociosCollection().remove(socios);
                idTipoSocioOld = em.merge(idTipoSocioOld);
            }
            if (idTipoSocioNew != null && !idTipoSocioNew.equals(idTipoSocioOld)) {
                idTipoSocioNew.getSociosCollection().add(socios);
                idTipoSocioNew = em.merge(idTipoSocioNew);
            }
            if (idSocioProponenteOld != null && !idSocioProponenteOld.equals(idSocioProponenteNew)) {
                idSocioProponenteOld.getSociosCollection().remove(socios);
                idSocioProponenteOld = em.merge(idSocioProponenteOld);
            }
            if (idSocioProponenteNew != null && !idSocioProponenteNew.equals(idSocioProponenteOld)) {
                idSocioProponenteNew.getSociosCollection().add(socios);
                idSocioProponenteNew = em.merge(idSocioProponenteNew);
            }
            if (idUsuarioCreacionOld != null && !idUsuarioCreacionOld.equals(idUsuarioCreacionNew)) {
                idUsuarioCreacionOld.setIdSocio(null);
                idUsuarioCreacionOld = em.merge(idUsuarioCreacionOld);
            }
            if (idUsuarioCreacionNew != null && !idUsuarioCreacionNew.equals(idUsuarioCreacionOld)) {
                idUsuarioCreacionNew.setIdSocio(socios);
                idUsuarioCreacionNew = em.merge(idUsuarioCreacionNew);
            }
            for (EstadosSocios estadosSociosCollectionNewEstadosSocios : estadosSociosCollectionNew) {
                if (!estadosSociosCollectionOld.contains(estadosSociosCollectionNewEstadosSocios)) {
                    Socios oldIdSocioOfEstadosSociosCollectionNewEstadosSocios = estadosSociosCollectionNewEstadosSocios.getIdSocio();
                    estadosSociosCollectionNewEstadosSocios.setIdSocio(socios);
                    estadosSociosCollectionNewEstadosSocios = em.merge(estadosSociosCollectionNewEstadosSocios);
                    if (oldIdSocioOfEstadosSociosCollectionNewEstadosSocios != null && !oldIdSocioOfEstadosSociosCollectionNewEstadosSocios.equals(socios)) {
                        oldIdSocioOfEstadosSociosCollectionNewEstadosSocios.getEstadosSociosCollection().remove(estadosSociosCollectionNewEstadosSocios);
                        oldIdSocioOfEstadosSociosCollectionNewEstadosSocios = em.merge(oldIdSocioOfEstadosSociosCollectionNewEstadosSocios);
                    }
                }
            }
            for (Socios sociosCollectionOldSocios : sociosCollectionOld) {
                if (!sociosCollectionNew.contains(sociosCollectionOldSocios)) {
                    sociosCollectionOldSocios.setIdSocioProponente(null);
                    sociosCollectionOldSocios = em.merge(sociosCollectionOldSocios);
                }
            }
            for (Socios sociosCollectionNewSocios : sociosCollectionNew) {
                if (!sociosCollectionOld.contains(sociosCollectionNewSocios)) {
                    Socios oldIdSocioProponenteOfSociosCollectionNewSocios = sociosCollectionNewSocios.getIdSocioProponente();
                    sociosCollectionNewSocios.setIdSocioProponente(socios);
                    sociosCollectionNewSocios = em.merge(sociosCollectionNewSocios);
                    if (oldIdSocioProponenteOfSociosCollectionNewSocios != null && !oldIdSocioProponenteOfSociosCollectionNewSocios.equals(socios)) {
                        oldIdSocioProponenteOfSociosCollectionNewSocios.getSociosCollection().remove(sociosCollectionNewSocios);
                        oldIdSocioProponenteOfSociosCollectionNewSocios = em.merge(oldIdSocioProponenteOfSociosCollectionNewSocios);
                    }
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios : mensajesEnviadosSociosCollectionNew) {
                if (!mensajesEnviadosSociosCollectionOld.contains(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios)) {
                    Socios oldIdSocioDestinoOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.getIdSocioDestino();
                    mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.setIdSocioDestino(socios);
                    mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = em.merge(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                    if (oldIdSocioDestinoOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios != null && !oldIdSocioDestinoOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.equals(socios)) {
                        oldIdSocioDestinoOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                        oldIdSocioDestinoOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = em.merge(oldIdSocioDestinoOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                    }
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionOldParticExpoSocios : particExpoSociosCollectionOld) {
                if (!particExpoSociosCollectionNew.contains(particExpoSociosCollectionOldParticExpoSocios)) {
                    particExpoSociosCollectionOldParticExpoSocios.setIdSocio(null);
                    particExpoSociosCollectionOldParticExpoSocios = em.merge(particExpoSociosCollectionOldParticExpoSocios);
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionNewParticExpoSocios : particExpoSociosCollectionNew) {
                if (!particExpoSociosCollectionOld.contains(particExpoSociosCollectionNewParticExpoSocios)) {
                    Socios oldIdSocioOfParticExpoSociosCollectionNewParticExpoSocios = particExpoSociosCollectionNewParticExpoSocios.getIdSocio();
                    particExpoSociosCollectionNewParticExpoSocios.setIdSocio(socios);
                    particExpoSociosCollectionNewParticExpoSocios = em.merge(particExpoSociosCollectionNewParticExpoSocios);
                    if (oldIdSocioOfParticExpoSociosCollectionNewParticExpoSocios != null && !oldIdSocioOfParticExpoSociosCollectionNewParticExpoSocios.equals(socios)) {
                        oldIdSocioOfParticExpoSociosCollectionNewParticExpoSocios.getParticExpoSociosCollection().remove(particExpoSociosCollectionNewParticExpoSocios);
                        oldIdSocioOfParticExpoSociosCollectionNewParticExpoSocios = em.merge(oldIdSocioOfParticExpoSociosCollectionNewParticExpoSocios);
                    }
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionOldPagosCuotasSocios : pagosCuotasSociosCollectionOld) {
                if (!pagosCuotasSociosCollectionNew.contains(pagosCuotasSociosCollectionOldPagosCuotasSocios)) {
                    pagosCuotasSociosCollectionOldPagosCuotasSocios.setIdSocio(null);
                    pagosCuotasSociosCollectionOldPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionOldPagosCuotasSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSocios : pagosCuotasSociosCollectionNew) {
                if (!pagosCuotasSociosCollectionOld.contains(pagosCuotasSociosCollectionNewPagosCuotasSocios)) {
                    Socios oldIdSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios = pagosCuotasSociosCollectionNewPagosCuotasSocios.getIdSocio();
                    pagosCuotasSociosCollectionNewPagosCuotasSocios.setIdSocio(socios);
                    pagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                    if (oldIdSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios != null && !oldIdSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios.equals(socios)) {
                        oldIdSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                        oldIdSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(oldIdSocioOfPagosCuotasSociosCollectionNewPagosCuotasSocios);
                    }
                }
            }
            for (MovimientosSocios movimientosSociosCollectionOldMovimientosSocios : movimientosSociosCollectionOld) {
                if (!movimientosSociosCollectionNew.contains(movimientosSociosCollectionOldMovimientosSocios)) {
                    movimientosSociosCollectionOldMovimientosSocios.setIdSocio(null);
                    movimientosSociosCollectionOldMovimientosSocios = em.merge(movimientosSociosCollectionOldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSocios : movimientosSociosCollectionNew) {
                if (!movimientosSociosCollectionOld.contains(movimientosSociosCollectionNewMovimientosSocios)) {
                    Socios oldIdSocioOfMovimientosSociosCollectionNewMovimientosSocios = movimientosSociosCollectionNewMovimientosSocios.getIdSocio();
                    movimientosSociosCollectionNewMovimientosSocios.setIdSocio(socios);
                    movimientosSociosCollectionNewMovimientosSocios = em.merge(movimientosSociosCollectionNewMovimientosSocios);
                    if (oldIdSocioOfMovimientosSociosCollectionNewMovimientosSocios != null && !oldIdSocioOfMovimientosSociosCollectionNewMovimientosSocios.equals(socios)) {
                        oldIdSocioOfMovimientosSociosCollectionNewMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionNewMovimientosSocios);
                        oldIdSocioOfMovimientosSociosCollectionNewMovimientosSocios = em.merge(oldIdSocioOfMovimientosSociosCollectionNewMovimientosSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = socios.getId();
                if (findSocios(id) == null) {
                    throw new NonexistentEntityException("The socios with id " + id + " no longer exists.");
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
            Socios socios;
            try {
                socios = em.getReference(Socios.class, id);
                socios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The socios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<EstadosSocios> estadosSociosCollectionOrphanCheck = socios.getEstadosSociosCollection();
            for (EstadosSocios estadosSociosCollectionOrphanCheckEstadosSocios : estadosSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Socios (" + socios + ") cannot be destroyed since the EstadosSocios " + estadosSociosCollectionOrphanCheckEstadosSocios + " in its estadosSociosCollection field has a non-nullable idSocio field.");
            }
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionOrphanCheck = socios.getMensajesEnviadosSociosCollection();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionOrphanCheckMensajesEnviadosSocios : mensajesEnviadosSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Socios (" + socios + ") cannot be destroyed since the MensajesEnviadosSocios " + mensajesEnviadosSociosCollectionOrphanCheckMensajesEnviadosSocios + " in its mensajesEnviadosSociosCollection field has a non-nullable idSocioDestino field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Usuarios usuarios = socios.getUsuarios();
            if (usuarios != null) {
                usuarios.setIdSocio(null);
                usuarios = em.merge(usuarios);
            }
            Opciones idEstadoActual = socios.getIdEstadoActual();
            if (idEstadoActual != null) {
                idEstadoActual.getSociosCollection().remove(socios);
                idEstadoActual = em.merge(idEstadoActual);
            }
            Opciones idTipoSocio = socios.getIdTipoSocio();
            if (idTipoSocio != null) {
                idTipoSocio.getSociosCollection().remove(socios);
                idTipoSocio = em.merge(idTipoSocio);
            }
            Socios idSocioProponente = socios.getIdSocioProponente();
            if (idSocioProponente != null) {
                idSocioProponente.getSociosCollection().remove(socios);
                idSocioProponente = em.merge(idSocioProponente);
            }
            Usuarios idUsuarioCreacion = socios.getIdUsuarioCreacion();
            if (idUsuarioCreacion != null) {
                idUsuarioCreacion.setIdSocio(null);
                idUsuarioCreacion = em.merge(idUsuarioCreacion);
            }
            Collection<Socios> sociosCollection = socios.getSociosCollection();
            for (Socios sociosCollectionSocios : sociosCollection) {
                sociosCollectionSocios.setIdSocioProponente(null);
                sociosCollectionSocios = em.merge(sociosCollectionSocios);
            }
            Collection<ParticExpoSocios> particExpoSociosCollection = socios.getParticExpoSociosCollection();
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSocios : particExpoSociosCollection) {
                particExpoSociosCollectionParticExpoSocios.setIdSocio(null);
                particExpoSociosCollectionParticExpoSocios = em.merge(particExpoSociosCollectionParticExpoSocios);
            }
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection = socios.getPagosCuotasSociosCollection();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : pagosCuotasSociosCollection) {
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdSocio(null);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
            }
            Collection<MovimientosSocios> movimientosSociosCollection = socios.getMovimientosSociosCollection();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : movimientosSociosCollection) {
                movimientosSociosCollectionMovimientosSocios.setIdSocio(null);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
            }
            em.remove(socios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Socios> findSociosEntities() {
        return findSociosEntities(true, -1, -1);
    }

    public List<Socios> findSociosEntities(int maxResults, int firstResult) {
        return findSociosEntities(false, maxResults, firstResult);
    }

    private List<Socios> findSociosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Socios.class));
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

    public Socios findSocios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Socios.class, id);
        } finally {
            em.close();
        }
    }

    public int getSociosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Socios> rt = cq.from(Socios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
