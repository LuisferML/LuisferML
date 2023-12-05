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
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.CodigoDeSeguridad;
import java.util.ArrayList;
import java.util.Collection;
import com.curso.asoweb.logica.Exposiciones;
import com.curso.asoweb.logica.MontosCuota;
import com.curso.asoweb.logica.EstadosSocios;
import com.curso.asoweb.logica.RolesUsuarios;
import com.curso.asoweb.logica.MensajesEnviadosSocios;
import com.curso.asoweb.logica.ParticExpoSocios;
import com.curso.asoweb.logica.TematicaParticExpoSocios;
import com.curso.asoweb.logica.PagosCuotasSocios;
import com.curso.asoweb.logica.MovimientosSocios;
import com.curso.asoweb.logica.Usuarios;
import com.curso.asoweb.persistencia.exceptions.IllegalOrphanException;
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
public class UsuariosJpaController implements Serializable {

    public UsuariosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UsuariosJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarios usuarios) {
        if (usuarios.getCodigoDeSeguridadCollection() == null) {
            usuarios.setCodigoDeSeguridadCollection(new ArrayList<CodigoDeSeguridad>());
        }
        if (usuarios.getExposicionesCollection() == null) {
            usuarios.setExposicionesCollection(new ArrayList<Exposiciones>());
        }
        if (usuarios.getMontosCuotaCollection() == null) {
            usuarios.setMontosCuotaCollection(new ArrayList<MontosCuota>());
        }
        if (usuarios.getEstadosSociosCollection() == null) {
            usuarios.setEstadosSociosCollection(new ArrayList<EstadosSocios>());
        }
        if (usuarios.getRolesUsuariosCollection() == null) {
            usuarios.setRolesUsuariosCollection(new ArrayList<RolesUsuarios>());
        }
        if (usuarios.getSociosCollection() == null) {
            usuarios.setSociosCollection(new ArrayList<Socios>());
        }
        if (usuarios.getMensajesEnviadosSociosCollection() == null) {
            usuarios.setMensajesEnviadosSociosCollection(new ArrayList<MensajesEnviadosSocios>());
        }
        if (usuarios.getParticExpoSociosCollection() == null) {
            usuarios.setParticExpoSociosCollection(new ArrayList<ParticExpoSocios>());
        }
        if (usuarios.getTematicaParticExpoSociosCollection() == null) {
            usuarios.setTematicaParticExpoSociosCollection(new ArrayList<TematicaParticExpoSocios>());
        }
        if (usuarios.getPagosCuotasSociosCollection() == null) {
            usuarios.setPagosCuotasSociosCollection(new ArrayList<PagosCuotasSocios>());
        }
        if (usuarios.getMovimientosSociosCollection() == null) {
            usuarios.setMovimientosSociosCollection(new ArrayList<MovimientosSocios>());
        }
        if (usuarios.getMovimientosSociosCollection1() == null) {
            usuarios.setMovimientosSociosCollection1(new ArrayList<MovimientosSocios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Socios idSocio = usuarios.getIdSocio();
            if (idSocio != null) {
                idSocio = em.getReference(idSocio.getClass(), idSocio.getId());
                usuarios.setIdSocio(idSocio);
            }
            Collection<CodigoDeSeguridad> attachedCodigoDeSeguridadCollection = new ArrayList<CodigoDeSeguridad>();
            for (CodigoDeSeguridad codigoDeSeguridadCollectionCodigoDeSeguridadToAttach : usuarios.getCodigoDeSeguridadCollection()) {
                codigoDeSeguridadCollectionCodigoDeSeguridadToAttach = em.getReference(codigoDeSeguridadCollectionCodigoDeSeguridadToAttach.getClass(), codigoDeSeguridadCollectionCodigoDeSeguridadToAttach.getId());
                attachedCodigoDeSeguridadCollection.add(codigoDeSeguridadCollectionCodigoDeSeguridadToAttach);
            }
            usuarios.setCodigoDeSeguridadCollection(attachedCodigoDeSeguridadCollection);
            Collection<Exposiciones> attachedExposicionesCollection = new ArrayList<Exposiciones>();
            for (Exposiciones exposicionesCollectionExposicionesToAttach : usuarios.getExposicionesCollection()) {
                exposicionesCollectionExposicionesToAttach = em.getReference(exposicionesCollectionExposicionesToAttach.getClass(), exposicionesCollectionExposicionesToAttach.getId());
                attachedExposicionesCollection.add(exposicionesCollectionExposicionesToAttach);
            }
            usuarios.setExposicionesCollection(attachedExposicionesCollection);
            Collection<MontosCuota> attachedMontosCuotaCollection = new ArrayList<MontosCuota>();
            for (MontosCuota montosCuotaCollectionMontosCuotaToAttach : usuarios.getMontosCuotaCollection()) {
                montosCuotaCollectionMontosCuotaToAttach = em.getReference(montosCuotaCollectionMontosCuotaToAttach.getClass(), montosCuotaCollectionMontosCuotaToAttach.getId());
                attachedMontosCuotaCollection.add(montosCuotaCollectionMontosCuotaToAttach);
            }
            usuarios.setMontosCuotaCollection(attachedMontosCuotaCollection);
            Collection<EstadosSocios> attachedEstadosSociosCollection = new ArrayList<EstadosSocios>();
            for (EstadosSocios estadosSociosCollectionEstadosSociosToAttach : usuarios.getEstadosSociosCollection()) {
                estadosSociosCollectionEstadosSociosToAttach = em.getReference(estadosSociosCollectionEstadosSociosToAttach.getClass(), estadosSociosCollectionEstadosSociosToAttach.getId());
                attachedEstadosSociosCollection.add(estadosSociosCollectionEstadosSociosToAttach);
            }
            usuarios.setEstadosSociosCollection(attachedEstadosSociosCollection);
            Collection<RolesUsuarios> attachedRolesUsuariosCollection = new ArrayList<RolesUsuarios>();
            for (RolesUsuarios rolesUsuariosCollectionRolesUsuariosToAttach : usuarios.getRolesUsuariosCollection()) {
                rolesUsuariosCollectionRolesUsuariosToAttach = em.getReference(rolesUsuariosCollectionRolesUsuariosToAttach.getClass(), rolesUsuariosCollectionRolesUsuariosToAttach.getRolesUsuarioId());
                attachedRolesUsuariosCollection.add(rolesUsuariosCollectionRolesUsuariosToAttach);
            }
            usuarios.setRolesUsuariosCollection(attachedRolesUsuariosCollection);
            Collection<Socios> attachedSociosCollection = new ArrayList<Socios>();
            for (Socios sociosCollectionSociosToAttach : usuarios.getSociosCollection()) {
                sociosCollectionSociosToAttach = em.getReference(sociosCollectionSociosToAttach.getClass(), sociosCollectionSociosToAttach.getId());
                attachedSociosCollection.add(sociosCollectionSociosToAttach);
            }
            usuarios.setSociosCollection(attachedSociosCollection);
            Collection<MensajesEnviadosSocios> attachedMensajesEnviadosSociosCollection = new ArrayList<MensajesEnviadosSocios>();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach : usuarios.getMensajesEnviadosSociosCollection()) {
                mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach = em.getReference(mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach.getClass(), mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach.getId());
                attachedMensajesEnviadosSociosCollection.add(mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach);
            }
            usuarios.setMensajesEnviadosSociosCollection(attachedMensajesEnviadosSociosCollection);
            Collection<ParticExpoSocios> attachedParticExpoSociosCollection = new ArrayList<ParticExpoSocios>();
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSociosToAttach : usuarios.getParticExpoSociosCollection()) {
                particExpoSociosCollectionParticExpoSociosToAttach = em.getReference(particExpoSociosCollectionParticExpoSociosToAttach.getClass(), particExpoSociosCollectionParticExpoSociosToAttach.getId());
                attachedParticExpoSociosCollection.add(particExpoSociosCollectionParticExpoSociosToAttach);
            }
            usuarios.setParticExpoSociosCollection(attachedParticExpoSociosCollection);
            Collection<TematicaParticExpoSocios> attachedTematicaParticExpoSociosCollection = new ArrayList<TematicaParticExpoSocios>();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach : usuarios.getTematicaParticExpoSociosCollection()) {
                tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach = em.getReference(tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach.getClass(), tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach.getId());
                attachedTematicaParticExpoSociosCollection.add(tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach);
            }
            usuarios.setTematicaParticExpoSociosCollection(attachedTematicaParticExpoSociosCollection);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollection = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSociosToAttach : usuarios.getPagosCuotasSociosCollection()) {
                pagosCuotasSociosCollectionPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollection.add(pagosCuotasSociosCollectionPagosCuotasSociosToAttach);
            }
            usuarios.setPagosCuotasSociosCollection(attachedPagosCuotasSociosCollection);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSociosToAttach : usuarios.getMovimientosSociosCollection()) {
                movimientosSociosCollectionMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionMovimientosSociosToAttach.getClass(), movimientosSociosCollectionMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection.add(movimientosSociosCollectionMovimientosSociosToAttach);
            }
            usuarios.setMovimientosSociosCollection(attachedMovimientosSociosCollection);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection1 = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollection1MovimientosSociosToAttach : usuarios.getMovimientosSociosCollection1()) {
                movimientosSociosCollection1MovimientosSociosToAttach = em.getReference(movimientosSociosCollection1MovimientosSociosToAttach.getClass(), movimientosSociosCollection1MovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection1.add(movimientosSociosCollection1MovimientosSociosToAttach);
            }
            usuarios.setMovimientosSociosCollection1(attachedMovimientosSociosCollection1);
            em.persist(usuarios);
            if (idSocio != null) {
                Usuarios oldUsuariosOfIdSocio = idSocio.getUsuarios();
                if (oldUsuariosOfIdSocio != null) {
                    oldUsuariosOfIdSocio.setIdSocio(null);
                    oldUsuariosOfIdSocio = em.merge(oldUsuariosOfIdSocio);
                }
                idSocio.setUsuarios(usuarios);
                idSocio = em.merge(idSocio);
            }
            for (CodigoDeSeguridad codigoDeSeguridadCollectionCodigoDeSeguridad : usuarios.getCodigoDeSeguridadCollection()) {
                Usuarios oldIdUsuarioOfCodigoDeSeguridadCollectionCodigoDeSeguridad = codigoDeSeguridadCollectionCodigoDeSeguridad.getIdUsuario();
                codigoDeSeguridadCollectionCodigoDeSeguridad.setIdUsuario(usuarios);
                codigoDeSeguridadCollectionCodigoDeSeguridad = em.merge(codigoDeSeguridadCollectionCodigoDeSeguridad);
                if (oldIdUsuarioOfCodigoDeSeguridadCollectionCodigoDeSeguridad != null) {
                    oldIdUsuarioOfCodigoDeSeguridadCollectionCodigoDeSeguridad.getCodigoDeSeguridadCollection().remove(codigoDeSeguridadCollectionCodigoDeSeguridad);
                    oldIdUsuarioOfCodigoDeSeguridadCollectionCodigoDeSeguridad = em.merge(oldIdUsuarioOfCodigoDeSeguridadCollectionCodigoDeSeguridad);
                }
            }
            for (Exposiciones exposicionesCollectionExposiciones : usuarios.getExposicionesCollection()) {
                Usuarios oldIdUsuarioCreacionOfExposicionesCollectionExposiciones = exposicionesCollectionExposiciones.getIdUsuarioCreacion();
                exposicionesCollectionExposiciones.setIdUsuarioCreacion(usuarios);
                exposicionesCollectionExposiciones = em.merge(exposicionesCollectionExposiciones);
                if (oldIdUsuarioCreacionOfExposicionesCollectionExposiciones != null) {
                    oldIdUsuarioCreacionOfExposicionesCollectionExposiciones.getExposicionesCollection().remove(exposicionesCollectionExposiciones);
                    oldIdUsuarioCreacionOfExposicionesCollectionExposiciones = em.merge(oldIdUsuarioCreacionOfExposicionesCollectionExposiciones);
                }
            }
            for (MontosCuota montosCuotaCollectionMontosCuota : usuarios.getMontosCuotaCollection()) {
                Usuarios oldIdUsuarioInactivacionOfMontosCuotaCollectionMontosCuota = montosCuotaCollectionMontosCuota.getIdUsuarioInactivacion();
                montosCuotaCollectionMontosCuota.setIdUsuarioInactivacion(usuarios);
                montosCuotaCollectionMontosCuota = em.merge(montosCuotaCollectionMontosCuota);
                if (oldIdUsuarioInactivacionOfMontosCuotaCollectionMontosCuota != null) {
                    oldIdUsuarioInactivacionOfMontosCuotaCollectionMontosCuota.getMontosCuotaCollection().remove(montosCuotaCollectionMontosCuota);
                    oldIdUsuarioInactivacionOfMontosCuotaCollectionMontosCuota = em.merge(oldIdUsuarioInactivacionOfMontosCuotaCollectionMontosCuota);
                }
            }
            for (EstadosSocios estadosSociosCollectionEstadosSocios : usuarios.getEstadosSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfEstadosSociosCollectionEstadosSocios = estadosSociosCollectionEstadosSocios.getIdUsuarioCreacion();
                estadosSociosCollectionEstadosSocios.setIdUsuarioCreacion(usuarios);
                estadosSociosCollectionEstadosSocios = em.merge(estadosSociosCollectionEstadosSocios);
                if (oldIdUsuarioCreacionOfEstadosSociosCollectionEstadosSocios != null) {
                    oldIdUsuarioCreacionOfEstadosSociosCollectionEstadosSocios.getEstadosSociosCollection().remove(estadosSociosCollectionEstadosSocios);
                    oldIdUsuarioCreacionOfEstadosSociosCollectionEstadosSocios = em.merge(oldIdUsuarioCreacionOfEstadosSociosCollectionEstadosSocios);
                }
            }
            for (RolesUsuarios rolesUsuariosCollectionRolesUsuarios : usuarios.getRolesUsuariosCollection()) {
                Usuarios oldIdUsuarioOfRolesUsuariosCollectionRolesUsuarios = rolesUsuariosCollectionRolesUsuarios.getIdUsuario();
                rolesUsuariosCollectionRolesUsuarios.setIdUsuario(usuarios);
                rolesUsuariosCollectionRolesUsuarios = em.merge(rolesUsuariosCollectionRolesUsuarios);
                if (oldIdUsuarioOfRolesUsuariosCollectionRolesUsuarios != null) {
                    oldIdUsuarioOfRolesUsuariosCollectionRolesUsuarios.getRolesUsuariosCollection().remove(rolesUsuariosCollectionRolesUsuarios);
                    oldIdUsuarioOfRolesUsuariosCollectionRolesUsuarios = em.merge(oldIdUsuarioOfRolesUsuariosCollectionRolesUsuarios);
                }
            }
            for (Socios sociosCollectionSocios : usuarios.getSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfSociosCollectionSocios = sociosCollectionSocios.getIdUsuarioCreacion();
                sociosCollectionSocios.setIdUsuarioCreacion(usuarios);
                sociosCollectionSocios = em.merge(sociosCollectionSocios);
                if (oldIdUsuarioCreacionOfSociosCollectionSocios != null) {
                    oldIdUsuarioCreacionOfSociosCollectionSocios.getSociosCollection().remove(sociosCollectionSocios);
                    oldIdUsuarioCreacionOfSociosCollectionSocios = em.merge(oldIdUsuarioCreacionOfSociosCollectionSocios);
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionMensajesEnviadosSocios : usuarios.getMensajesEnviadosSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios = mensajesEnviadosSociosCollectionMensajesEnviadosSocios.getIdUsuarioCreacion();
                mensajesEnviadosSociosCollectionMensajesEnviadosSocios.setIdUsuarioCreacion(usuarios);
                mensajesEnviadosSociosCollectionMensajesEnviadosSocios = em.merge(mensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                if (oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios != null) {
                    oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                    oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios = em.merge(oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionParticExpoSocios : usuarios.getParticExpoSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfParticExpoSociosCollectionParticExpoSocios = particExpoSociosCollectionParticExpoSocios.getIdUsuarioCreacion();
                particExpoSociosCollectionParticExpoSocios.setIdUsuarioCreacion(usuarios);
                particExpoSociosCollectionParticExpoSocios = em.merge(particExpoSociosCollectionParticExpoSocios);
                if (oldIdUsuarioCreacionOfParticExpoSociosCollectionParticExpoSocios != null) {
                    oldIdUsuarioCreacionOfParticExpoSociosCollectionParticExpoSocios.getParticExpoSociosCollection().remove(particExpoSociosCollectionParticExpoSocios);
                    oldIdUsuarioCreacionOfParticExpoSociosCollectionParticExpoSocios = em.merge(oldIdUsuarioCreacionOfParticExpoSociosCollectionParticExpoSocios);
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSocios : usuarios.getTematicaParticExpoSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios = tematicaParticExpoSociosCollectionTematicaParticExpoSocios.getIdUsuarioCreacion();
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios.setIdUsuarioCreacion(usuarios);
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                if (oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios != null) {
                    oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                    oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : usuarios.getPagosCuotasSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfPagosCuotasSociosCollectionPagosCuotasSocios = pagosCuotasSociosCollectionPagosCuotasSocios.getIdUsuarioCreacion();
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdUsuarioCreacion(usuarios);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
                if (oldIdUsuarioCreacionOfPagosCuotasSociosCollectionPagosCuotasSocios != null) {
                    oldIdUsuarioCreacionOfPagosCuotasSociosCollectionPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionPagosCuotasSocios);
                    oldIdUsuarioCreacionOfPagosCuotasSociosCollectionPagosCuotasSocios = em.merge(oldIdUsuarioCreacionOfPagosCuotasSociosCollectionPagosCuotasSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : usuarios.getMovimientosSociosCollection()) {
                Usuarios oldIdUsuarioCreacionOfMovimientosSociosCollectionMovimientosSocios = movimientosSociosCollectionMovimientosSocios.getIdUsuarioCreacion();
                movimientosSociosCollectionMovimientosSocios.setIdUsuarioCreacion(usuarios);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
                if (oldIdUsuarioCreacionOfMovimientosSociosCollectionMovimientosSocios != null) {
                    oldIdUsuarioCreacionOfMovimientosSociosCollectionMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionMovimientosSocios);
                    oldIdUsuarioCreacionOfMovimientosSociosCollectionMovimientosSocios = em.merge(oldIdUsuarioCreacionOfMovimientosSociosCollectionMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollection1MovimientosSocios : usuarios.getMovimientosSociosCollection1()) {
                Usuarios oldIdUsuarioAprobacionOfMovimientosSociosCollection1MovimientosSocios = movimientosSociosCollection1MovimientosSocios.getIdUsuarioAprobacion();
                movimientosSociosCollection1MovimientosSocios.setIdUsuarioAprobacion(usuarios);
                movimientosSociosCollection1MovimientosSocios = em.merge(movimientosSociosCollection1MovimientosSocios);
                if (oldIdUsuarioAprobacionOfMovimientosSociosCollection1MovimientosSocios != null) {
                    oldIdUsuarioAprobacionOfMovimientosSociosCollection1MovimientosSocios.getMovimientosSociosCollection1().remove(movimientosSociosCollection1MovimientosSocios);
                    oldIdUsuarioAprobacionOfMovimientosSociosCollection1MovimientosSocios = em.merge(oldIdUsuarioAprobacionOfMovimientosSociosCollection1MovimientosSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarios usuarios) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarios persistentUsuarios = em.find(Usuarios.class, usuarios.getId());
            Socios idSocioOld = persistentUsuarios.getIdSocio();
            Socios idSocioNew = usuarios.getIdSocio();
            Collection<CodigoDeSeguridad> codigoDeSeguridadCollectionOld = persistentUsuarios.getCodigoDeSeguridadCollection();
            Collection<CodigoDeSeguridad> codigoDeSeguridadCollectionNew = usuarios.getCodigoDeSeguridadCollection();
            Collection<Exposiciones> exposicionesCollectionOld = persistentUsuarios.getExposicionesCollection();
            Collection<Exposiciones> exposicionesCollectionNew = usuarios.getExposicionesCollection();
            Collection<MontosCuota> montosCuotaCollectionOld = persistentUsuarios.getMontosCuotaCollection();
            Collection<MontosCuota> montosCuotaCollectionNew = usuarios.getMontosCuotaCollection();
            Collection<EstadosSocios> estadosSociosCollectionOld = persistentUsuarios.getEstadosSociosCollection();
            Collection<EstadosSocios> estadosSociosCollectionNew = usuarios.getEstadosSociosCollection();
            Collection<RolesUsuarios> rolesUsuariosCollectionOld = persistentUsuarios.getRolesUsuariosCollection();
            Collection<RolesUsuarios> rolesUsuariosCollectionNew = usuarios.getRolesUsuariosCollection();
            Collection<Socios> sociosCollectionOld = persistentUsuarios.getSociosCollection();
            Collection<Socios> sociosCollectionNew = usuarios.getSociosCollection();
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionOld = persistentUsuarios.getMensajesEnviadosSociosCollection();
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionNew = usuarios.getMensajesEnviadosSociosCollection();
            Collection<ParticExpoSocios> particExpoSociosCollectionOld = persistentUsuarios.getParticExpoSociosCollection();
            Collection<ParticExpoSocios> particExpoSociosCollectionNew = usuarios.getParticExpoSociosCollection();
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionOld = persistentUsuarios.getTematicaParticExpoSociosCollection();
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionNew = usuarios.getTematicaParticExpoSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionOld = persistentUsuarios.getPagosCuotasSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionNew = usuarios.getPagosCuotasSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollectionOld = persistentUsuarios.getMovimientosSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollectionNew = usuarios.getMovimientosSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollection1Old = persistentUsuarios.getMovimientosSociosCollection1();
            Collection<MovimientosSocios> movimientosSociosCollection1New = usuarios.getMovimientosSociosCollection1();
            List<String> illegalOrphanMessages = null;
            for (Exposiciones exposicionesCollectionOldExposiciones : exposicionesCollectionOld) {
                if (!exposicionesCollectionNew.contains(exposicionesCollectionOldExposiciones)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Exposiciones " + exposicionesCollectionOldExposiciones + " since its idUsuarioCreacion field is not nullable.");
                }
            }
            for (EstadosSocios estadosSociosCollectionOldEstadosSocios : estadosSociosCollectionOld) {
                if (!estadosSociosCollectionNew.contains(estadosSociosCollectionOldEstadosSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EstadosSocios " + estadosSociosCollectionOldEstadosSocios + " since its idUsuarioCreacion field is not nullable.");
                }
            }
            for (RolesUsuarios rolesUsuariosCollectionOldRolesUsuarios : rolesUsuariosCollectionOld) {
                if (!rolesUsuariosCollectionNew.contains(rolesUsuariosCollectionOldRolesUsuarios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RolesUsuarios " + rolesUsuariosCollectionOldRolesUsuarios + " since its idUsuario field is not nullable.");
                }
            }
            for (Socios sociosCollectionOldSocios : sociosCollectionOld) {
                if (!sociosCollectionNew.contains(sociosCollectionOldSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Socios " + sociosCollectionOldSocios + " since its idUsuarioCreacion field is not nullable.");
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios : mensajesEnviadosSociosCollectionOld) {
                if (!mensajesEnviadosSociosCollectionNew.contains(mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MensajesEnviadosSocios " + mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios + " since its idUsuarioCreacion field is not nullable.");
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionOldParticExpoSocios : particExpoSociosCollectionOld) {
                if (!particExpoSociosCollectionNew.contains(particExpoSociosCollectionOldParticExpoSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ParticExpoSocios " + particExpoSociosCollectionOldParticExpoSocios + " since its idUsuarioCreacion field is not nullable.");
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios : tematicaParticExpoSociosCollectionOld) {
                if (!tematicaParticExpoSociosCollectionNew.contains(tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TematicaParticExpoSocios " + tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios + " since its idUsuarioCreacion field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idSocioNew != null) {
                idSocioNew = em.getReference(idSocioNew.getClass(), idSocioNew.getId());
                usuarios.setIdSocio(idSocioNew);
            }
            Collection<CodigoDeSeguridad> attachedCodigoDeSeguridadCollectionNew = new ArrayList<CodigoDeSeguridad>();
            for (CodigoDeSeguridad codigoDeSeguridadCollectionNewCodigoDeSeguridadToAttach : codigoDeSeguridadCollectionNew) {
                codigoDeSeguridadCollectionNewCodigoDeSeguridadToAttach = em.getReference(codigoDeSeguridadCollectionNewCodigoDeSeguridadToAttach.getClass(), codigoDeSeguridadCollectionNewCodigoDeSeguridadToAttach.getId());
                attachedCodigoDeSeguridadCollectionNew.add(codigoDeSeguridadCollectionNewCodigoDeSeguridadToAttach);
            }
            codigoDeSeguridadCollectionNew = attachedCodigoDeSeguridadCollectionNew;
            usuarios.setCodigoDeSeguridadCollection(codigoDeSeguridadCollectionNew);
            Collection<Exposiciones> attachedExposicionesCollectionNew = new ArrayList<Exposiciones>();
            for (Exposiciones exposicionesCollectionNewExposicionesToAttach : exposicionesCollectionNew) {
                exposicionesCollectionNewExposicionesToAttach = em.getReference(exposicionesCollectionNewExposicionesToAttach.getClass(), exposicionesCollectionNewExposicionesToAttach.getId());
                attachedExposicionesCollectionNew.add(exposicionesCollectionNewExposicionesToAttach);
            }
            exposicionesCollectionNew = attachedExposicionesCollectionNew;
            usuarios.setExposicionesCollection(exposicionesCollectionNew);
            Collection<MontosCuota> attachedMontosCuotaCollectionNew = new ArrayList<MontosCuota>();
            for (MontosCuota montosCuotaCollectionNewMontosCuotaToAttach : montosCuotaCollectionNew) {
                montosCuotaCollectionNewMontosCuotaToAttach = em.getReference(montosCuotaCollectionNewMontosCuotaToAttach.getClass(), montosCuotaCollectionNewMontosCuotaToAttach.getId());
                attachedMontosCuotaCollectionNew.add(montosCuotaCollectionNewMontosCuotaToAttach);
            }
            montosCuotaCollectionNew = attachedMontosCuotaCollectionNew;
            usuarios.setMontosCuotaCollection(montosCuotaCollectionNew);
            Collection<EstadosSocios> attachedEstadosSociosCollectionNew = new ArrayList<EstadosSocios>();
            for (EstadosSocios estadosSociosCollectionNewEstadosSociosToAttach : estadosSociosCollectionNew) {
                estadosSociosCollectionNewEstadosSociosToAttach = em.getReference(estadosSociosCollectionNewEstadosSociosToAttach.getClass(), estadosSociosCollectionNewEstadosSociosToAttach.getId());
                attachedEstadosSociosCollectionNew.add(estadosSociosCollectionNewEstadosSociosToAttach);
            }
            estadosSociosCollectionNew = attachedEstadosSociosCollectionNew;
            usuarios.setEstadosSociosCollection(estadosSociosCollectionNew);
            Collection<RolesUsuarios> attachedRolesUsuariosCollectionNew = new ArrayList<RolesUsuarios>();
            for (RolesUsuarios rolesUsuariosCollectionNewRolesUsuariosToAttach : rolesUsuariosCollectionNew) {
                rolesUsuariosCollectionNewRolesUsuariosToAttach = em.getReference(rolesUsuariosCollectionNewRolesUsuariosToAttach.getClass(), rolesUsuariosCollectionNewRolesUsuariosToAttach.getRolesUsuarioId());
                attachedRolesUsuariosCollectionNew.add(rolesUsuariosCollectionNewRolesUsuariosToAttach);
            }
            rolesUsuariosCollectionNew = attachedRolesUsuariosCollectionNew;
            usuarios.setRolesUsuariosCollection(rolesUsuariosCollectionNew);
            Collection<Socios> attachedSociosCollectionNew = new ArrayList<Socios>();
            for (Socios sociosCollectionNewSociosToAttach : sociosCollectionNew) {
                sociosCollectionNewSociosToAttach = em.getReference(sociosCollectionNewSociosToAttach.getClass(), sociosCollectionNewSociosToAttach.getId());
                attachedSociosCollectionNew.add(sociosCollectionNewSociosToAttach);
            }
            sociosCollectionNew = attachedSociosCollectionNew;
            usuarios.setSociosCollection(sociosCollectionNew);
            Collection<MensajesEnviadosSocios> attachedMensajesEnviadosSociosCollectionNew = new ArrayList<MensajesEnviadosSocios>();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach : mensajesEnviadosSociosCollectionNew) {
                mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach = em.getReference(mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach.getClass(), mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach.getId());
                attachedMensajesEnviadosSociosCollectionNew.add(mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach);
            }
            mensajesEnviadosSociosCollectionNew = attachedMensajesEnviadosSociosCollectionNew;
            usuarios.setMensajesEnviadosSociosCollection(mensajesEnviadosSociosCollectionNew);
            Collection<ParticExpoSocios> attachedParticExpoSociosCollectionNew = new ArrayList<ParticExpoSocios>();
            for (ParticExpoSocios particExpoSociosCollectionNewParticExpoSociosToAttach : particExpoSociosCollectionNew) {
                particExpoSociosCollectionNewParticExpoSociosToAttach = em.getReference(particExpoSociosCollectionNewParticExpoSociosToAttach.getClass(), particExpoSociosCollectionNewParticExpoSociosToAttach.getId());
                attachedParticExpoSociosCollectionNew.add(particExpoSociosCollectionNewParticExpoSociosToAttach);
            }
            particExpoSociosCollectionNew = attachedParticExpoSociosCollectionNew;
            usuarios.setParticExpoSociosCollection(particExpoSociosCollectionNew);
            Collection<TematicaParticExpoSocios> attachedTematicaParticExpoSociosCollectionNew = new ArrayList<TematicaParticExpoSocios>();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach : tematicaParticExpoSociosCollectionNew) {
                tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach = em.getReference(tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach.getClass(), tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach.getId());
                attachedTematicaParticExpoSociosCollectionNew.add(tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach);
            }
            tematicaParticExpoSociosCollectionNew = attachedTematicaParticExpoSociosCollectionNew;
            usuarios.setTematicaParticExpoSociosCollection(tematicaParticExpoSociosCollectionNew);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollectionNew = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach : pagosCuotasSociosCollectionNew) {
                pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollectionNew.add(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach);
            }
            pagosCuotasSociosCollectionNew = attachedPagosCuotasSociosCollectionNew;
            usuarios.setPagosCuotasSociosCollection(pagosCuotasSociosCollectionNew);
            Collection<MovimientosSocios> attachedMovimientosSociosCollectionNew = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSociosToAttach : movimientosSociosCollectionNew) {
                movimientosSociosCollectionNewMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionNewMovimientosSociosToAttach.getClass(), movimientosSociosCollectionNewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollectionNew.add(movimientosSociosCollectionNewMovimientosSociosToAttach);
            }
            movimientosSociosCollectionNew = attachedMovimientosSociosCollectionNew;
            usuarios.setMovimientosSociosCollection(movimientosSociosCollectionNew);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection1New = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollection1NewMovimientosSociosToAttach : movimientosSociosCollection1New) {
                movimientosSociosCollection1NewMovimientosSociosToAttach = em.getReference(movimientosSociosCollection1NewMovimientosSociosToAttach.getClass(), movimientosSociosCollection1NewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection1New.add(movimientosSociosCollection1NewMovimientosSociosToAttach);
            }
            movimientosSociosCollection1New = attachedMovimientosSociosCollection1New;
            usuarios.setMovimientosSociosCollection1(movimientosSociosCollection1New);
            usuarios = em.merge(usuarios);
            if (idSocioOld != null && !idSocioOld.equals(idSocioNew)) {
                idSocioOld.setUsuarios(null);
                idSocioOld = em.merge(idSocioOld);
            }
            if (idSocioNew != null && !idSocioNew.equals(idSocioOld)) {
                Usuarios oldUsuariosOfIdSocio = idSocioNew.getUsuarios();
                if (oldUsuariosOfIdSocio != null) {
                    oldUsuariosOfIdSocio.setIdSocio(null);
                    oldUsuariosOfIdSocio = em.merge(oldUsuariosOfIdSocio);
                }
                idSocioNew.setUsuarios(usuarios);
                idSocioNew = em.merge(idSocioNew);
            }
            for (CodigoDeSeguridad codigoDeSeguridadCollectionOldCodigoDeSeguridad : codigoDeSeguridadCollectionOld) {
                if (!codigoDeSeguridadCollectionNew.contains(codigoDeSeguridadCollectionOldCodigoDeSeguridad)) {
                    codigoDeSeguridadCollectionOldCodigoDeSeguridad.setIdUsuario(null);
                    codigoDeSeguridadCollectionOldCodigoDeSeguridad = em.merge(codigoDeSeguridadCollectionOldCodigoDeSeguridad);
                }
            }
            for (CodigoDeSeguridad codigoDeSeguridadCollectionNewCodigoDeSeguridad : codigoDeSeguridadCollectionNew) {
                if (!codigoDeSeguridadCollectionOld.contains(codigoDeSeguridadCollectionNewCodigoDeSeguridad)) {
                    Usuarios oldIdUsuarioOfCodigoDeSeguridadCollectionNewCodigoDeSeguridad = codigoDeSeguridadCollectionNewCodigoDeSeguridad.getIdUsuario();
                    codigoDeSeguridadCollectionNewCodigoDeSeguridad.setIdUsuario(usuarios);
                    codigoDeSeguridadCollectionNewCodigoDeSeguridad = em.merge(codigoDeSeguridadCollectionNewCodigoDeSeguridad);
                    if (oldIdUsuarioOfCodigoDeSeguridadCollectionNewCodigoDeSeguridad != null && !oldIdUsuarioOfCodigoDeSeguridadCollectionNewCodigoDeSeguridad.equals(usuarios)) {
                        oldIdUsuarioOfCodigoDeSeguridadCollectionNewCodigoDeSeguridad.getCodigoDeSeguridadCollection().remove(codigoDeSeguridadCollectionNewCodigoDeSeguridad);
                        oldIdUsuarioOfCodigoDeSeguridadCollectionNewCodigoDeSeguridad = em.merge(oldIdUsuarioOfCodigoDeSeguridadCollectionNewCodigoDeSeguridad);
                    }
                }
            }
            for (Exposiciones exposicionesCollectionNewExposiciones : exposicionesCollectionNew) {
                if (!exposicionesCollectionOld.contains(exposicionesCollectionNewExposiciones)) {
                    Usuarios oldIdUsuarioCreacionOfExposicionesCollectionNewExposiciones = exposicionesCollectionNewExposiciones.getIdUsuarioCreacion();
                    exposicionesCollectionNewExposiciones.setIdUsuarioCreacion(usuarios);
                    exposicionesCollectionNewExposiciones = em.merge(exposicionesCollectionNewExposiciones);
                    if (oldIdUsuarioCreacionOfExposicionesCollectionNewExposiciones != null && !oldIdUsuarioCreacionOfExposicionesCollectionNewExposiciones.equals(usuarios)) {
                        oldIdUsuarioCreacionOfExposicionesCollectionNewExposiciones.getExposicionesCollection().remove(exposicionesCollectionNewExposiciones);
                        oldIdUsuarioCreacionOfExposicionesCollectionNewExposiciones = em.merge(oldIdUsuarioCreacionOfExposicionesCollectionNewExposiciones);
                    }
                }
            }
            for (MontosCuota montosCuotaCollectionOldMontosCuota : montosCuotaCollectionOld) {
                if (!montosCuotaCollectionNew.contains(montosCuotaCollectionOldMontosCuota)) {
                    montosCuotaCollectionOldMontosCuota.setIdUsuarioInactivacion(null);
                    montosCuotaCollectionOldMontosCuota = em.merge(montosCuotaCollectionOldMontosCuota);
                }
            }
            for (MontosCuota montosCuotaCollectionNewMontosCuota : montosCuotaCollectionNew) {
                if (!montosCuotaCollectionOld.contains(montosCuotaCollectionNewMontosCuota)) {
                    Usuarios oldIdUsuarioInactivacionOfMontosCuotaCollectionNewMontosCuota = montosCuotaCollectionNewMontosCuota.getIdUsuarioInactivacion();
                    montosCuotaCollectionNewMontosCuota.setIdUsuarioInactivacion(usuarios);
                    montosCuotaCollectionNewMontosCuota = em.merge(montosCuotaCollectionNewMontosCuota);
                    if (oldIdUsuarioInactivacionOfMontosCuotaCollectionNewMontosCuota != null && !oldIdUsuarioInactivacionOfMontosCuotaCollectionNewMontosCuota.equals(usuarios)) {
                        oldIdUsuarioInactivacionOfMontosCuotaCollectionNewMontosCuota.getMontosCuotaCollection().remove(montosCuotaCollectionNewMontosCuota);
                        oldIdUsuarioInactivacionOfMontosCuotaCollectionNewMontosCuota = em.merge(oldIdUsuarioInactivacionOfMontosCuotaCollectionNewMontosCuota);
                    }
                }
            }
            for (EstadosSocios estadosSociosCollectionNewEstadosSocios : estadosSociosCollectionNew) {
                if (!estadosSociosCollectionOld.contains(estadosSociosCollectionNewEstadosSocios)) {
                    Usuarios oldIdUsuarioCreacionOfEstadosSociosCollectionNewEstadosSocios = estadosSociosCollectionNewEstadosSocios.getIdUsuarioCreacion();
                    estadosSociosCollectionNewEstadosSocios.setIdUsuarioCreacion(usuarios);
                    estadosSociosCollectionNewEstadosSocios = em.merge(estadosSociosCollectionNewEstadosSocios);
                    if (oldIdUsuarioCreacionOfEstadosSociosCollectionNewEstadosSocios != null && !oldIdUsuarioCreacionOfEstadosSociosCollectionNewEstadosSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfEstadosSociosCollectionNewEstadosSocios.getEstadosSociosCollection().remove(estadosSociosCollectionNewEstadosSocios);
                        oldIdUsuarioCreacionOfEstadosSociosCollectionNewEstadosSocios = em.merge(oldIdUsuarioCreacionOfEstadosSociosCollectionNewEstadosSocios);
                    }
                }
            }
            for (RolesUsuarios rolesUsuariosCollectionNewRolesUsuarios : rolesUsuariosCollectionNew) {
                if (!rolesUsuariosCollectionOld.contains(rolesUsuariosCollectionNewRolesUsuarios)) {
                    Usuarios oldIdUsuarioOfRolesUsuariosCollectionNewRolesUsuarios = rolesUsuariosCollectionNewRolesUsuarios.getIdUsuario();
                    rolesUsuariosCollectionNewRolesUsuarios.setIdUsuario(usuarios);
                    rolesUsuariosCollectionNewRolesUsuarios = em.merge(rolesUsuariosCollectionNewRolesUsuarios);
                    if (oldIdUsuarioOfRolesUsuariosCollectionNewRolesUsuarios != null && !oldIdUsuarioOfRolesUsuariosCollectionNewRolesUsuarios.equals(usuarios)) {
                        oldIdUsuarioOfRolesUsuariosCollectionNewRolesUsuarios.getRolesUsuariosCollection().remove(rolesUsuariosCollectionNewRolesUsuarios);
                        oldIdUsuarioOfRolesUsuariosCollectionNewRolesUsuarios = em.merge(oldIdUsuarioOfRolesUsuariosCollectionNewRolesUsuarios);
                    }
                }
            }
            for (Socios sociosCollectionNewSocios : sociosCollectionNew) {
                if (!sociosCollectionOld.contains(sociosCollectionNewSocios)) {
                    Usuarios oldIdUsuarioCreacionOfSociosCollectionNewSocios = sociosCollectionNewSocios.getIdUsuarioCreacion();
                    sociosCollectionNewSocios.setIdUsuarioCreacion(usuarios);
                    sociosCollectionNewSocios = em.merge(sociosCollectionNewSocios);
                    if (oldIdUsuarioCreacionOfSociosCollectionNewSocios != null && !oldIdUsuarioCreacionOfSociosCollectionNewSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfSociosCollectionNewSocios.getSociosCollection().remove(sociosCollectionNewSocios);
                        oldIdUsuarioCreacionOfSociosCollectionNewSocios = em.merge(oldIdUsuarioCreacionOfSociosCollectionNewSocios);
                    }
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios : mensajesEnviadosSociosCollectionNew) {
                if (!mensajesEnviadosSociosCollectionOld.contains(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios)) {
                    Usuarios oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.getIdUsuarioCreacion();
                    mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.setIdUsuarioCreacion(usuarios);
                    mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = em.merge(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                    if (oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios != null && !oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                        oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = em.merge(oldIdUsuarioCreacionOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                    }
                }
            }
            for (ParticExpoSocios particExpoSociosCollectionNewParticExpoSocios : particExpoSociosCollectionNew) {
                if (!particExpoSociosCollectionOld.contains(particExpoSociosCollectionNewParticExpoSocios)) {
                    Usuarios oldIdUsuarioCreacionOfParticExpoSociosCollectionNewParticExpoSocios = particExpoSociosCollectionNewParticExpoSocios.getIdUsuarioCreacion();
                    particExpoSociosCollectionNewParticExpoSocios.setIdUsuarioCreacion(usuarios);
                    particExpoSociosCollectionNewParticExpoSocios = em.merge(particExpoSociosCollectionNewParticExpoSocios);
                    if (oldIdUsuarioCreacionOfParticExpoSociosCollectionNewParticExpoSocios != null && !oldIdUsuarioCreacionOfParticExpoSociosCollectionNewParticExpoSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfParticExpoSociosCollectionNewParticExpoSocios.getParticExpoSociosCollection().remove(particExpoSociosCollectionNewParticExpoSocios);
                        oldIdUsuarioCreacionOfParticExpoSociosCollectionNewParticExpoSocios = em.merge(oldIdUsuarioCreacionOfParticExpoSociosCollectionNewParticExpoSocios);
                    }
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios : tematicaParticExpoSociosCollectionNew) {
                if (!tematicaParticExpoSociosCollectionOld.contains(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios)) {
                    Usuarios oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.getIdUsuarioCreacion();
                    tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.setIdUsuarioCreacion(usuarios);
                    tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                    if (oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios != null && !oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                        oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = em.merge(oldIdUsuarioCreacionOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                    }
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionOldPagosCuotasSocios : pagosCuotasSociosCollectionOld) {
                if (!pagosCuotasSociosCollectionNew.contains(pagosCuotasSociosCollectionOldPagosCuotasSocios)) {
                    pagosCuotasSociosCollectionOldPagosCuotasSocios.setIdUsuarioCreacion(null);
                    pagosCuotasSociosCollectionOldPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionOldPagosCuotasSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSocios : pagosCuotasSociosCollectionNew) {
                if (!pagosCuotasSociosCollectionOld.contains(pagosCuotasSociosCollectionNewPagosCuotasSocios)) {
                    Usuarios oldIdUsuarioCreacionOfPagosCuotasSociosCollectionNewPagosCuotasSocios = pagosCuotasSociosCollectionNewPagosCuotasSocios.getIdUsuarioCreacion();
                    pagosCuotasSociosCollectionNewPagosCuotasSocios.setIdUsuarioCreacion(usuarios);
                    pagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                    if (oldIdUsuarioCreacionOfPagosCuotasSociosCollectionNewPagosCuotasSocios != null && !oldIdUsuarioCreacionOfPagosCuotasSociosCollectionNewPagosCuotasSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfPagosCuotasSociosCollectionNewPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                        oldIdUsuarioCreacionOfPagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(oldIdUsuarioCreacionOfPagosCuotasSociosCollectionNewPagosCuotasSocios);
                    }
                }
            }
            for (MovimientosSocios movimientosSociosCollectionOldMovimientosSocios : movimientosSociosCollectionOld) {
                if (!movimientosSociosCollectionNew.contains(movimientosSociosCollectionOldMovimientosSocios)) {
                    movimientosSociosCollectionOldMovimientosSocios.setIdUsuarioCreacion(null);
                    movimientosSociosCollectionOldMovimientosSocios = em.merge(movimientosSociosCollectionOldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSocios : movimientosSociosCollectionNew) {
                if (!movimientosSociosCollectionOld.contains(movimientosSociosCollectionNewMovimientosSocios)) {
                    Usuarios oldIdUsuarioCreacionOfMovimientosSociosCollectionNewMovimientosSocios = movimientosSociosCollectionNewMovimientosSocios.getIdUsuarioCreacion();
                    movimientosSociosCollectionNewMovimientosSocios.setIdUsuarioCreacion(usuarios);
                    movimientosSociosCollectionNewMovimientosSocios = em.merge(movimientosSociosCollectionNewMovimientosSocios);
                    if (oldIdUsuarioCreacionOfMovimientosSociosCollectionNewMovimientosSocios != null && !oldIdUsuarioCreacionOfMovimientosSociosCollectionNewMovimientosSocios.equals(usuarios)) {
                        oldIdUsuarioCreacionOfMovimientosSociosCollectionNewMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionNewMovimientosSocios);
                        oldIdUsuarioCreacionOfMovimientosSociosCollectionNewMovimientosSocios = em.merge(oldIdUsuarioCreacionOfMovimientosSociosCollectionNewMovimientosSocios);
                    }
                }
            }
            for (MovimientosSocios movimientosSociosCollection1OldMovimientosSocios : movimientosSociosCollection1Old) {
                if (!movimientosSociosCollection1New.contains(movimientosSociosCollection1OldMovimientosSocios)) {
                    movimientosSociosCollection1OldMovimientosSocios.setIdUsuarioAprobacion(null);
                    movimientosSociosCollection1OldMovimientosSocios = em.merge(movimientosSociosCollection1OldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollection1NewMovimientosSocios : movimientosSociosCollection1New) {
                if (!movimientosSociosCollection1Old.contains(movimientosSociosCollection1NewMovimientosSocios)) {
                    Usuarios oldIdUsuarioAprobacionOfMovimientosSociosCollection1NewMovimientosSocios = movimientosSociosCollection1NewMovimientosSocios.getIdUsuarioAprobacion();
                    movimientosSociosCollection1NewMovimientosSocios.setIdUsuarioAprobacion(usuarios);
                    movimientosSociosCollection1NewMovimientosSocios = em.merge(movimientosSociosCollection1NewMovimientosSocios);
                    if (oldIdUsuarioAprobacionOfMovimientosSociosCollection1NewMovimientosSocios != null && !oldIdUsuarioAprobacionOfMovimientosSociosCollection1NewMovimientosSocios.equals(usuarios)) {
                        oldIdUsuarioAprobacionOfMovimientosSociosCollection1NewMovimientosSocios.getMovimientosSociosCollection1().remove(movimientosSociosCollection1NewMovimientosSocios);
                        oldIdUsuarioAprobacionOfMovimientosSociosCollection1NewMovimientosSocios = em.merge(oldIdUsuarioAprobacionOfMovimientosSociosCollection1NewMovimientosSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarios.getId();
                if (findUsuarios(id) == null) {
                    throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.");
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
            Usuarios usuarios;
            try {
                usuarios = em.getReference(Usuarios.class, id);
                usuarios.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarios with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Exposiciones> exposicionesCollectionOrphanCheck = usuarios.getExposicionesCollection();
            for (Exposiciones exposicionesCollectionOrphanCheckExposiciones : exposicionesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Exposiciones " + exposicionesCollectionOrphanCheckExposiciones + " in its exposicionesCollection field has a non-nullable idUsuarioCreacion field.");
            }
            Collection<EstadosSocios> estadosSociosCollectionOrphanCheck = usuarios.getEstadosSociosCollection();
            for (EstadosSocios estadosSociosCollectionOrphanCheckEstadosSocios : estadosSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the EstadosSocios " + estadosSociosCollectionOrphanCheckEstadosSocios + " in its estadosSociosCollection field has a non-nullable idUsuarioCreacion field.");
            }
            Collection<RolesUsuarios> rolesUsuariosCollectionOrphanCheck = usuarios.getRolesUsuariosCollection();
            for (RolesUsuarios rolesUsuariosCollectionOrphanCheckRolesUsuarios : rolesUsuariosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the RolesUsuarios " + rolesUsuariosCollectionOrphanCheckRolesUsuarios + " in its rolesUsuariosCollection field has a non-nullable idUsuario field.");
            }
            Collection<Socios> sociosCollectionOrphanCheck = usuarios.getSociosCollection();
            for (Socios sociosCollectionOrphanCheckSocios : sociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the Socios " + sociosCollectionOrphanCheckSocios + " in its sociosCollection field has a non-nullable idUsuarioCreacion field.");
            }
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionOrphanCheck = usuarios.getMensajesEnviadosSociosCollection();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionOrphanCheckMensajesEnviadosSocios : mensajesEnviadosSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the MensajesEnviadosSocios " + mensajesEnviadosSociosCollectionOrphanCheckMensajesEnviadosSocios + " in its mensajesEnviadosSociosCollection field has a non-nullable idUsuarioCreacion field.");
            }
            Collection<ParticExpoSocios> particExpoSociosCollectionOrphanCheck = usuarios.getParticExpoSociosCollection();
            for (ParticExpoSocios particExpoSociosCollectionOrphanCheckParticExpoSocios : particExpoSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the ParticExpoSocios " + particExpoSociosCollectionOrphanCheckParticExpoSocios + " in its particExpoSociosCollection field has a non-nullable idUsuarioCreacion field.");
            }
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionOrphanCheck = usuarios.getTematicaParticExpoSociosCollection();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionOrphanCheckTematicaParticExpoSocios : tematicaParticExpoSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuarios (" + usuarios + ") cannot be destroyed since the TematicaParticExpoSocios " + tematicaParticExpoSociosCollectionOrphanCheckTematicaParticExpoSocios + " in its tematicaParticExpoSociosCollection field has a non-nullable idUsuarioCreacion field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Socios idSocio = usuarios.getIdSocio();
            if (idSocio != null) {
                idSocio.setUsuarios(null);
                idSocio = em.merge(idSocio);
            }
            Collection<CodigoDeSeguridad> codigoDeSeguridadCollection = usuarios.getCodigoDeSeguridadCollection();
            for (CodigoDeSeguridad codigoDeSeguridadCollectionCodigoDeSeguridad : codigoDeSeguridadCollection) {
                codigoDeSeguridadCollectionCodigoDeSeguridad.setIdUsuario(null);
                codigoDeSeguridadCollectionCodigoDeSeguridad = em.merge(codigoDeSeguridadCollectionCodigoDeSeguridad);
            }
            Collection<MontosCuota> montosCuotaCollection = usuarios.getMontosCuotaCollection();
            for (MontosCuota montosCuotaCollectionMontosCuota : montosCuotaCollection) {
                montosCuotaCollectionMontosCuota.setIdUsuarioInactivacion(null);
                montosCuotaCollectionMontosCuota = em.merge(montosCuotaCollectionMontosCuota);
            }
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection = usuarios.getPagosCuotasSociosCollection();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : pagosCuotasSociosCollection) {
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdUsuarioCreacion(null);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
            }
            Collection<MovimientosSocios> movimientosSociosCollection = usuarios.getMovimientosSociosCollection();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : movimientosSociosCollection) {
                movimientosSociosCollectionMovimientosSocios.setIdUsuarioCreacion(null);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
            }
            Collection<MovimientosSocios> movimientosSociosCollection1 = usuarios.getMovimientosSociosCollection1();
            for (MovimientosSocios movimientosSociosCollection1MovimientosSocios : movimientosSociosCollection1) {
                movimientosSociosCollection1MovimientosSocios.setIdUsuarioAprobacion(null);
                movimientosSociosCollection1MovimientosSocios = em.merge(movimientosSociosCollection1MovimientosSocios);
            }
            em.remove(usuarios);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarios> findUsuariosEntities() {
        return findUsuariosEntities(true, -1, -1);
    }

    public List<Usuarios> findUsuariosEntities(int maxResults, int firstResult) {
        return findUsuariosEntities(false, maxResults, firstResult);
    }

    private List<Usuarios> findUsuariosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarios.class));
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

    public Usuarios findUsuarios(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    //METODOS LUIS
    public Usuarios findUsuariosEmail(String emailUsuario) {

        EntityManager em = getEntityManager();
        try {

            System.out.println("el email del usuario a buscar es : ");

            String jpql = "SELECT u FROM Usuarios u WHERE u.email = :emailu";

            TypedQuery<Usuarios> query = em.createQuery(jpql, Usuarios.class);
            query.setParameter("emailu", emailUsuario);

            List<Usuarios> usuariosLista = query.getResultList();
            if (!usuariosLista.isEmpty()) {
                return usuariosLista.get(0);
            } else {
                System.out.println("No se encontró usuario con el email: " + emailUsuario);
                return null;
            }
        } finally {
            em.close();
        }
    }
    
    
    

}
