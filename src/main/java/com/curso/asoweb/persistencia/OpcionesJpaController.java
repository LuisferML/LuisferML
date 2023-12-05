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
import com.curso.asoweb.logica.Opciones;
import com.curso.asoweb.logica.EstadosSocios;
import java.util.ArrayList;
import java.util.Collection;
import com.curso.asoweb.logica.PagosOtrosConceptos;
import com.curso.asoweb.logica.Socios;
import com.curso.asoweb.logica.MensajesEnviadosSocios;
import com.curso.asoweb.logica.TematicaParticExpoSocios;
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
public class OpcionesJpaController implements Serializable {

    public OpcionesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
     public OpcionesJpaController() {
        emf = Persistence.createEntityManagerFactory("asowebPersUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Opciones opciones) {
        if (opciones.getEstadosSociosCollection() == null) {
            opciones.setEstadosSociosCollection(new ArrayList<EstadosSocios>());
        }
        if (opciones.getPagosOtrosConceptosCollection() == null) {
            opciones.setPagosOtrosConceptosCollection(new ArrayList<PagosOtrosConceptos>());
        }
        if (opciones.getPagosOtrosConceptosCollection1() == null) {
            opciones.setPagosOtrosConceptosCollection1(new ArrayList<PagosOtrosConceptos>());
        }
        if (opciones.getPagosOtrosConceptosCollection2() == null) {
            opciones.setPagosOtrosConceptosCollection2(new ArrayList<PagosOtrosConceptos>());
        }
        if (opciones.getSociosCollection() == null) {
            opciones.setSociosCollection(new ArrayList<Socios>());
        }
        if (opciones.getSociosCollection1() == null) {
            opciones.setSociosCollection1(new ArrayList<Socios>());
        }
        if (opciones.getMensajesEnviadosSociosCollection() == null) {
            opciones.setMensajesEnviadosSociosCollection(new ArrayList<MensajesEnviadosSocios>());
        }
        if (opciones.getTematicaParticExpoSociosCollection() == null) {
            opciones.setTematicaParticExpoSociosCollection(new ArrayList<TematicaParticExpoSocios>());
        }
        if (opciones.getOpcionesCollection() == null) {
            opciones.setOpcionesCollection(new ArrayList<Opciones>());
        }
        if (opciones.getPagosCuotasSociosCollection() == null) {
            opciones.setPagosCuotasSociosCollection(new ArrayList<PagosCuotasSocios>());
        }
        if (opciones.getPagosCuotasSociosCollection1() == null) {
            opciones.setPagosCuotasSociosCollection1(new ArrayList<PagosCuotasSocios>());
        }
        if (opciones.getMovimientosSociosCollection() == null) {
            opciones.setMovimientosSociosCollection(new ArrayList<MovimientosSocios>());
        }
        if (opciones.getMovimientosSociosCollection1() == null) {
            opciones.setMovimientosSociosCollection1(new ArrayList<MovimientosSocios>());
        }
        if (opciones.getMovimientosSociosCollection2() == null) {
            opciones.setMovimientosSociosCollection2(new ArrayList<MovimientosSocios>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dominios idDominio = opciones.getIdDominio();
            if (idDominio != null) {
                idDominio = em.getReference(idDominio.getClass(), idDominio.getId());
                opciones.setIdDominio(idDominio);
            }
            Opciones idOpcionPadre = opciones.getIdOpcionPadre();
            if (idOpcionPadre != null) {
                idOpcionPadre = em.getReference(idOpcionPadre.getClass(), idOpcionPadre.getId());
                opciones.setIdOpcionPadre(idOpcionPadre);
            }
            Collection<EstadosSocios> attachedEstadosSociosCollection = new ArrayList<EstadosSocios>();
            for (EstadosSocios estadosSociosCollectionEstadosSociosToAttach : opciones.getEstadosSociosCollection()) {
                estadosSociosCollectionEstadosSociosToAttach = em.getReference(estadosSociosCollectionEstadosSociosToAttach.getClass(), estadosSociosCollectionEstadosSociosToAttach.getId());
                attachedEstadosSociosCollection.add(estadosSociosCollectionEstadosSociosToAttach);
            }
            opciones.setEstadosSociosCollection(attachedEstadosSociosCollection);
            Collection<PagosOtrosConceptos> attachedPagosOtrosConceptosCollection = new ArrayList<PagosOtrosConceptos>();
            for (PagosOtrosConceptos pagosOtrosConceptosCollectionPagosOtrosConceptosToAttach : opciones.getPagosOtrosConceptosCollection()) {
                pagosOtrosConceptosCollectionPagosOtrosConceptosToAttach = em.getReference(pagosOtrosConceptosCollectionPagosOtrosConceptosToAttach.getClass(), pagosOtrosConceptosCollectionPagosOtrosConceptosToAttach.getId());
                attachedPagosOtrosConceptosCollection.add(pagosOtrosConceptosCollectionPagosOtrosConceptosToAttach);
            }
            opciones.setPagosOtrosConceptosCollection(attachedPagosOtrosConceptosCollection);
            Collection<PagosOtrosConceptos> attachedPagosOtrosConceptosCollection1 = new ArrayList<PagosOtrosConceptos>();
            for (PagosOtrosConceptos pagosOtrosConceptosCollection1PagosOtrosConceptosToAttach : opciones.getPagosOtrosConceptosCollection1()) {
                pagosOtrosConceptosCollection1PagosOtrosConceptosToAttach = em.getReference(pagosOtrosConceptosCollection1PagosOtrosConceptosToAttach.getClass(), pagosOtrosConceptosCollection1PagosOtrosConceptosToAttach.getId());
                attachedPagosOtrosConceptosCollection1.add(pagosOtrosConceptosCollection1PagosOtrosConceptosToAttach);
            }
            opciones.setPagosOtrosConceptosCollection1(attachedPagosOtrosConceptosCollection1);
            Collection<PagosOtrosConceptos> attachedPagosOtrosConceptosCollection2 = new ArrayList<PagosOtrosConceptos>();
            for (PagosOtrosConceptos pagosOtrosConceptosCollection2PagosOtrosConceptosToAttach : opciones.getPagosOtrosConceptosCollection2()) {
                pagosOtrosConceptosCollection2PagosOtrosConceptosToAttach = em.getReference(pagosOtrosConceptosCollection2PagosOtrosConceptosToAttach.getClass(), pagosOtrosConceptosCollection2PagosOtrosConceptosToAttach.getId());
                attachedPagosOtrosConceptosCollection2.add(pagosOtrosConceptosCollection2PagosOtrosConceptosToAttach);
            }
            opciones.setPagosOtrosConceptosCollection2(attachedPagosOtrosConceptosCollection2);
            Collection<Socios> attachedSociosCollection = new ArrayList<Socios>();
            for (Socios sociosCollectionSociosToAttach : opciones.getSociosCollection()) {
                sociosCollectionSociosToAttach = em.getReference(sociosCollectionSociosToAttach.getClass(), sociosCollectionSociosToAttach.getId());
                attachedSociosCollection.add(sociosCollectionSociosToAttach);
            }
            opciones.setSociosCollection(attachedSociosCollection);
            Collection<Socios> attachedSociosCollection1 = new ArrayList<Socios>();
            for (Socios sociosCollection1SociosToAttach : opciones.getSociosCollection1()) {
                sociosCollection1SociosToAttach = em.getReference(sociosCollection1SociosToAttach.getClass(), sociosCollection1SociosToAttach.getId());
                attachedSociosCollection1.add(sociosCollection1SociosToAttach);
            }
            opciones.setSociosCollection1(attachedSociosCollection1);
            Collection<MensajesEnviadosSocios> attachedMensajesEnviadosSociosCollection = new ArrayList<MensajesEnviadosSocios>();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach : opciones.getMensajesEnviadosSociosCollection()) {
                mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach = em.getReference(mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach.getClass(), mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach.getId());
                attachedMensajesEnviadosSociosCollection.add(mensajesEnviadosSociosCollectionMensajesEnviadosSociosToAttach);
            }
            opciones.setMensajesEnviadosSociosCollection(attachedMensajesEnviadosSociosCollection);
            Collection<TematicaParticExpoSocios> attachedTematicaParticExpoSociosCollection = new ArrayList<TematicaParticExpoSocios>();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach : opciones.getTematicaParticExpoSociosCollection()) {
                tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach = em.getReference(tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach.getClass(), tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach.getId());
                attachedTematicaParticExpoSociosCollection.add(tematicaParticExpoSociosCollectionTematicaParticExpoSociosToAttach);
            }
            opciones.setTematicaParticExpoSociosCollection(attachedTematicaParticExpoSociosCollection);
            Collection<Opciones> attachedOpcionesCollection = new ArrayList<Opciones>();
            for (Opciones opcionesCollectionOpcionesToAttach : opciones.getOpcionesCollection()) {
                opcionesCollectionOpcionesToAttach = em.getReference(opcionesCollectionOpcionesToAttach.getClass(), opcionesCollectionOpcionesToAttach.getId());
                attachedOpcionesCollection.add(opcionesCollectionOpcionesToAttach);
            }
            opciones.setOpcionesCollection(attachedOpcionesCollection);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollection = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSociosToAttach : opciones.getPagosCuotasSociosCollection()) {
                pagosCuotasSociosCollectionPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollection.add(pagosCuotasSociosCollectionPagosCuotasSociosToAttach);
            }
            opciones.setPagosCuotasSociosCollection(attachedPagosCuotasSociosCollection);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollection1 = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollection1PagosCuotasSociosToAttach : opciones.getPagosCuotasSociosCollection1()) {
                pagosCuotasSociosCollection1PagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollection1PagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollection1PagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollection1.add(pagosCuotasSociosCollection1PagosCuotasSociosToAttach);
            }
            opciones.setPagosCuotasSociosCollection1(attachedPagosCuotasSociosCollection1);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSociosToAttach : opciones.getMovimientosSociosCollection()) {
                movimientosSociosCollectionMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionMovimientosSociosToAttach.getClass(), movimientosSociosCollectionMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection.add(movimientosSociosCollectionMovimientosSociosToAttach);
            }
            opciones.setMovimientosSociosCollection(attachedMovimientosSociosCollection);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection1 = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollection1MovimientosSociosToAttach : opciones.getMovimientosSociosCollection1()) {
                movimientosSociosCollection1MovimientosSociosToAttach = em.getReference(movimientosSociosCollection1MovimientosSociosToAttach.getClass(), movimientosSociosCollection1MovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection1.add(movimientosSociosCollection1MovimientosSociosToAttach);
            }
            opciones.setMovimientosSociosCollection1(attachedMovimientosSociosCollection1);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection2 = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollection2MovimientosSociosToAttach : opciones.getMovimientosSociosCollection2()) {
                movimientosSociosCollection2MovimientosSociosToAttach = em.getReference(movimientosSociosCollection2MovimientosSociosToAttach.getClass(), movimientosSociosCollection2MovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection2.add(movimientosSociosCollection2MovimientosSociosToAttach);
            }
            opciones.setMovimientosSociosCollection2(attachedMovimientosSociosCollection2);
            em.persist(opciones);
            if (idDominio != null) {
                idDominio.getOpcionesCollection().add(opciones);
                idDominio = em.merge(idDominio);
            }
            if (idOpcionPadre != null) {
                idOpcionPadre.getOpcionesCollection().add(opciones);
                idOpcionPadre = em.merge(idOpcionPadre);
            }
            for (EstadosSocios estadosSociosCollectionEstadosSocios : opciones.getEstadosSociosCollection()) {
                Opciones oldIdEstadoOfEstadosSociosCollectionEstadosSocios = estadosSociosCollectionEstadosSocios.getIdEstado();
                estadosSociosCollectionEstadosSocios.setIdEstado(opciones);
                estadosSociosCollectionEstadosSocios = em.merge(estadosSociosCollectionEstadosSocios);
                if (oldIdEstadoOfEstadosSociosCollectionEstadosSocios != null) {
                    oldIdEstadoOfEstadosSociosCollectionEstadosSocios.getEstadosSociosCollection().remove(estadosSociosCollectionEstadosSocios);
                    oldIdEstadoOfEstadosSociosCollectionEstadosSocios = em.merge(oldIdEstadoOfEstadosSociosCollectionEstadosSocios);
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollectionPagosOtrosConceptos : opciones.getPagosOtrosConceptosCollection()) {
                Opciones oldIdConceptoOfPagosOtrosConceptosCollectionPagosOtrosConceptos = pagosOtrosConceptosCollectionPagosOtrosConceptos.getIdConcepto();
                pagosOtrosConceptosCollectionPagosOtrosConceptos.setIdConcepto(opciones);
                pagosOtrosConceptosCollectionPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollectionPagosOtrosConceptos);
                if (oldIdConceptoOfPagosOtrosConceptosCollectionPagosOtrosConceptos != null) {
                    oldIdConceptoOfPagosOtrosConceptosCollectionPagosOtrosConceptos.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptosCollectionPagosOtrosConceptos);
                    oldIdConceptoOfPagosOtrosConceptosCollectionPagosOtrosConceptos = em.merge(oldIdConceptoOfPagosOtrosConceptosCollectionPagosOtrosConceptos);
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollection1PagosOtrosConceptos : opciones.getPagosOtrosConceptosCollection1()) {
                Opciones oldIdEstadoOfPagosOtrosConceptosCollection1PagosOtrosConceptos = pagosOtrosConceptosCollection1PagosOtrosConceptos.getIdEstado();
                pagosOtrosConceptosCollection1PagosOtrosConceptos.setIdEstado(opciones);
                pagosOtrosConceptosCollection1PagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection1PagosOtrosConceptos);
                if (oldIdEstadoOfPagosOtrosConceptosCollection1PagosOtrosConceptos != null) {
                    oldIdEstadoOfPagosOtrosConceptosCollection1PagosOtrosConceptos.getPagosOtrosConceptosCollection1().remove(pagosOtrosConceptosCollection1PagosOtrosConceptos);
                    oldIdEstadoOfPagosOtrosConceptosCollection1PagosOtrosConceptos = em.merge(oldIdEstadoOfPagosOtrosConceptosCollection1PagosOtrosConceptos);
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollection2PagosOtrosConceptos : opciones.getPagosOtrosConceptosCollection2()) {
                Opciones oldIdMedioPagoOfPagosOtrosConceptosCollection2PagosOtrosConceptos = pagosOtrosConceptosCollection2PagosOtrosConceptos.getIdMedioPago();
                pagosOtrosConceptosCollection2PagosOtrosConceptos.setIdMedioPago(opciones);
                pagosOtrosConceptosCollection2PagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection2PagosOtrosConceptos);
                if (oldIdMedioPagoOfPagosOtrosConceptosCollection2PagosOtrosConceptos != null) {
                    oldIdMedioPagoOfPagosOtrosConceptosCollection2PagosOtrosConceptos.getPagosOtrosConceptosCollection2().remove(pagosOtrosConceptosCollection2PagosOtrosConceptos);
                    oldIdMedioPagoOfPagosOtrosConceptosCollection2PagosOtrosConceptos = em.merge(oldIdMedioPagoOfPagosOtrosConceptosCollection2PagosOtrosConceptos);
                }
            }
            for (Socios sociosCollectionSocios : opciones.getSociosCollection()) {
                Opciones oldIdEstadoActualOfSociosCollectionSocios = sociosCollectionSocios.getIdEstadoActual();
                sociosCollectionSocios.setIdEstadoActual(opciones);
                sociosCollectionSocios = em.merge(sociosCollectionSocios);
                if (oldIdEstadoActualOfSociosCollectionSocios != null) {
                    oldIdEstadoActualOfSociosCollectionSocios.getSociosCollection().remove(sociosCollectionSocios);
                    oldIdEstadoActualOfSociosCollectionSocios = em.merge(oldIdEstadoActualOfSociosCollectionSocios);
                }
            }
            for (Socios sociosCollection1Socios : opciones.getSociosCollection1()) {
                Opciones oldIdTipoSocioOfSociosCollection1Socios = sociosCollection1Socios.getIdTipoSocio();
                sociosCollection1Socios.setIdTipoSocio(opciones);
                sociosCollection1Socios = em.merge(sociosCollection1Socios);
                if (oldIdTipoSocioOfSociosCollection1Socios != null) {
                    oldIdTipoSocioOfSociosCollection1Socios.getSociosCollection1().remove(sociosCollection1Socios);
                    oldIdTipoSocioOfSociosCollection1Socios = em.merge(oldIdTipoSocioOfSociosCollection1Socios);
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionMensajesEnviadosSocios : opciones.getMensajesEnviadosSociosCollection()) {
                Opciones oldIdMensajeOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios = mensajesEnviadosSociosCollectionMensajesEnviadosSocios.getIdMensaje();
                mensajesEnviadosSociosCollectionMensajesEnviadosSocios.setIdMensaje(opciones);
                mensajesEnviadosSociosCollectionMensajesEnviadosSocios = em.merge(mensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                if (oldIdMensajeOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios != null) {
                    oldIdMensajeOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                    oldIdMensajeOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios = em.merge(oldIdMensajeOfMensajesEnviadosSociosCollectionMensajesEnviadosSocios);
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSocios : opciones.getTematicaParticExpoSociosCollection()) {
                Opciones oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios = tematicaParticExpoSociosCollectionTematicaParticExpoSocios.getIdTematicaGeneral();
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios.setIdTematicaGeneral(opciones);
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                if (oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios != null) {
                    oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                    oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionTematicaParticExpoSocios);
                }
            }
            for (Opciones opcionesCollectionOpciones : opciones.getOpcionesCollection()) {
                Opciones oldIdOpcionPadreOfOpcionesCollectionOpciones = opcionesCollectionOpciones.getIdOpcionPadre();
                opcionesCollectionOpciones.setIdOpcionPadre(opciones);
                opcionesCollectionOpciones = em.merge(opcionesCollectionOpciones);
                if (oldIdOpcionPadreOfOpcionesCollectionOpciones != null) {
                    oldIdOpcionPadreOfOpcionesCollectionOpciones.getOpcionesCollection().remove(opcionesCollectionOpciones);
                    oldIdOpcionPadreOfOpcionesCollectionOpciones = em.merge(oldIdOpcionPadreOfOpcionesCollectionOpciones);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : opciones.getPagosCuotasSociosCollection()) {
                Opciones oldIdEstadoOfPagosCuotasSociosCollectionPagosCuotasSocios = pagosCuotasSociosCollectionPagosCuotasSocios.getIdEstado();
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdEstado(opciones);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
                if (oldIdEstadoOfPagosCuotasSociosCollectionPagosCuotasSocios != null) {
                    oldIdEstadoOfPagosCuotasSociosCollectionPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionPagosCuotasSocios);
                    oldIdEstadoOfPagosCuotasSociosCollectionPagosCuotasSocios = em.merge(oldIdEstadoOfPagosCuotasSociosCollectionPagosCuotasSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollection1PagosCuotasSocios : opciones.getPagosCuotasSociosCollection1()) {
                Opciones oldIdMotivoExoneracionOfPagosCuotasSociosCollection1PagosCuotasSocios = pagosCuotasSociosCollection1PagosCuotasSocios.getIdMotivoExoneracion();
                pagosCuotasSociosCollection1PagosCuotasSocios.setIdMotivoExoneracion(opciones);
                pagosCuotasSociosCollection1PagosCuotasSocios = em.merge(pagosCuotasSociosCollection1PagosCuotasSocios);
                if (oldIdMotivoExoneracionOfPagosCuotasSociosCollection1PagosCuotasSocios != null) {
                    oldIdMotivoExoneracionOfPagosCuotasSociosCollection1PagosCuotasSocios.getPagosCuotasSociosCollection1().remove(pagosCuotasSociosCollection1PagosCuotasSocios);
                    oldIdMotivoExoneracionOfPagosCuotasSociosCollection1PagosCuotasSocios = em.merge(oldIdMotivoExoneracionOfPagosCuotasSociosCollection1PagosCuotasSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : opciones.getMovimientosSociosCollection()) {
                Opciones oldIdEstadoOfMovimientosSociosCollectionMovimientosSocios = movimientosSociosCollectionMovimientosSocios.getIdEstado();
                movimientosSociosCollectionMovimientosSocios.setIdEstado(opciones);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
                if (oldIdEstadoOfMovimientosSociosCollectionMovimientosSocios != null) {
                    oldIdEstadoOfMovimientosSociosCollectionMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionMovimientosSocios);
                    oldIdEstadoOfMovimientosSociosCollectionMovimientosSocios = em.merge(oldIdEstadoOfMovimientosSociosCollectionMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollection1MovimientosSocios : opciones.getMovimientosSociosCollection1()) {
                Opciones oldIdMedioPagoOfMovimientosSociosCollection1MovimientosSocios = movimientosSociosCollection1MovimientosSocios.getIdMedioPago();
                movimientosSociosCollection1MovimientosSocios.setIdMedioPago(opciones);
                movimientosSociosCollection1MovimientosSocios = em.merge(movimientosSociosCollection1MovimientosSocios);
                if (oldIdMedioPagoOfMovimientosSociosCollection1MovimientosSocios != null) {
                    oldIdMedioPagoOfMovimientosSociosCollection1MovimientosSocios.getMovimientosSociosCollection1().remove(movimientosSociosCollection1MovimientosSocios);
                    oldIdMedioPagoOfMovimientosSociosCollection1MovimientosSocios = em.merge(oldIdMedioPagoOfMovimientosSociosCollection1MovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollection2MovimientosSocios : opciones.getMovimientosSociosCollection2()) {
                Opciones oldIdConceptoOfMovimientosSociosCollection2MovimientosSocios = movimientosSociosCollection2MovimientosSocios.getIdConcepto();
                movimientosSociosCollection2MovimientosSocios.setIdConcepto(opciones);
                movimientosSociosCollection2MovimientosSocios = em.merge(movimientosSociosCollection2MovimientosSocios);
                if (oldIdConceptoOfMovimientosSociosCollection2MovimientosSocios != null) {
                    oldIdConceptoOfMovimientosSociosCollection2MovimientosSocios.getMovimientosSociosCollection2().remove(movimientosSociosCollection2MovimientosSocios);
                    oldIdConceptoOfMovimientosSociosCollection2MovimientosSocios = em.merge(oldIdConceptoOfMovimientosSociosCollection2MovimientosSocios);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Opciones opciones) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Opciones persistentOpciones = em.find(Opciones.class, opciones.getId());
            Dominios idDominioOld = persistentOpciones.getIdDominio();
            Dominios idDominioNew = opciones.getIdDominio();
            Opciones idOpcionPadreOld = persistentOpciones.getIdOpcionPadre();
            Opciones idOpcionPadreNew = opciones.getIdOpcionPadre();
            Collection<EstadosSocios> estadosSociosCollectionOld = persistentOpciones.getEstadosSociosCollection();
            Collection<EstadosSocios> estadosSociosCollectionNew = opciones.getEstadosSociosCollection();
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollectionOld = persistentOpciones.getPagosOtrosConceptosCollection();
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollectionNew = opciones.getPagosOtrosConceptosCollection();
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection1Old = persistentOpciones.getPagosOtrosConceptosCollection1();
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection1New = opciones.getPagosOtrosConceptosCollection1();
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection2Old = persistentOpciones.getPagosOtrosConceptosCollection2();
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection2New = opciones.getPagosOtrosConceptosCollection2();
            Collection<Socios> sociosCollectionOld = persistentOpciones.getSociosCollection();
            Collection<Socios> sociosCollectionNew = opciones.getSociosCollection();
            Collection<Socios> sociosCollection1Old = persistentOpciones.getSociosCollection1();
            Collection<Socios> sociosCollection1New = opciones.getSociosCollection1();
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionOld = persistentOpciones.getMensajesEnviadosSociosCollection();
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionNew = opciones.getMensajesEnviadosSociosCollection();
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionOld = persistentOpciones.getTematicaParticExpoSociosCollection();
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollectionNew = opciones.getTematicaParticExpoSociosCollection();
            Collection<Opciones> opcionesCollectionOld = persistentOpciones.getOpcionesCollection();
            Collection<Opciones> opcionesCollectionNew = opciones.getOpcionesCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionOld = persistentOpciones.getPagosCuotasSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollectionNew = opciones.getPagosCuotasSociosCollection();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection1Old = persistentOpciones.getPagosCuotasSociosCollection1();
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection1New = opciones.getPagosCuotasSociosCollection1();
            Collection<MovimientosSocios> movimientosSociosCollectionOld = persistentOpciones.getMovimientosSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollectionNew = opciones.getMovimientosSociosCollection();
            Collection<MovimientosSocios> movimientosSociosCollection1Old = persistentOpciones.getMovimientosSociosCollection1();
            Collection<MovimientosSocios> movimientosSociosCollection1New = opciones.getMovimientosSociosCollection1();
            Collection<MovimientosSocios> movimientosSociosCollection2Old = persistentOpciones.getMovimientosSociosCollection2();
            Collection<MovimientosSocios> movimientosSociosCollection2New = opciones.getMovimientosSociosCollection2();
            List<String> illegalOrphanMessages = null;
            for (EstadosSocios estadosSociosCollectionOldEstadosSocios : estadosSociosCollectionOld) {
                if (!estadosSociosCollectionNew.contains(estadosSociosCollectionOldEstadosSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain EstadosSocios " + estadosSociosCollectionOldEstadosSocios + " since its idEstado field is not nullable.");
                }
            }
            for (Socios sociosCollectionOldSocios : sociosCollectionOld) {
                if (!sociosCollectionNew.contains(sociosCollectionOldSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Socios " + sociosCollectionOldSocios + " since its idEstadoActual field is not nullable.");
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios : mensajesEnviadosSociosCollectionOld) {
                if (!mensajesEnviadosSociosCollectionNew.contains(mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain MensajesEnviadosSocios " + mensajesEnviadosSociosCollectionOldMensajesEnviadosSocios + " since its idMensaje field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idDominioNew != null) {
                idDominioNew = em.getReference(idDominioNew.getClass(), idDominioNew.getId());
                opciones.setIdDominio(idDominioNew);
            }
            if (idOpcionPadreNew != null) {
                idOpcionPadreNew = em.getReference(idOpcionPadreNew.getClass(), idOpcionPadreNew.getId());
                opciones.setIdOpcionPadre(idOpcionPadreNew);
            }
            Collection<EstadosSocios> attachedEstadosSociosCollectionNew = new ArrayList<EstadosSocios>();
            for (EstadosSocios estadosSociosCollectionNewEstadosSociosToAttach : estadosSociosCollectionNew) {
                estadosSociosCollectionNewEstadosSociosToAttach = em.getReference(estadosSociosCollectionNewEstadosSociosToAttach.getClass(), estadosSociosCollectionNewEstadosSociosToAttach.getId());
                attachedEstadosSociosCollectionNew.add(estadosSociosCollectionNewEstadosSociosToAttach);
            }
            estadosSociosCollectionNew = attachedEstadosSociosCollectionNew;
            opciones.setEstadosSociosCollection(estadosSociosCollectionNew);
            Collection<PagosOtrosConceptos> attachedPagosOtrosConceptosCollectionNew = new ArrayList<PagosOtrosConceptos>();
            for (PagosOtrosConceptos pagosOtrosConceptosCollectionNewPagosOtrosConceptosToAttach : pagosOtrosConceptosCollectionNew) {
                pagosOtrosConceptosCollectionNewPagosOtrosConceptosToAttach = em.getReference(pagosOtrosConceptosCollectionNewPagosOtrosConceptosToAttach.getClass(), pagosOtrosConceptosCollectionNewPagosOtrosConceptosToAttach.getId());
                attachedPagosOtrosConceptosCollectionNew.add(pagosOtrosConceptosCollectionNewPagosOtrosConceptosToAttach);
            }
            pagosOtrosConceptosCollectionNew = attachedPagosOtrosConceptosCollectionNew;
            opciones.setPagosOtrosConceptosCollection(pagosOtrosConceptosCollectionNew);
            Collection<PagosOtrosConceptos> attachedPagosOtrosConceptosCollection1New = new ArrayList<PagosOtrosConceptos>();
            for (PagosOtrosConceptos pagosOtrosConceptosCollection1NewPagosOtrosConceptosToAttach : pagosOtrosConceptosCollection1New) {
                pagosOtrosConceptosCollection1NewPagosOtrosConceptosToAttach = em.getReference(pagosOtrosConceptosCollection1NewPagosOtrosConceptosToAttach.getClass(), pagosOtrosConceptosCollection1NewPagosOtrosConceptosToAttach.getId());
                attachedPagosOtrosConceptosCollection1New.add(pagosOtrosConceptosCollection1NewPagosOtrosConceptosToAttach);
            }
            pagosOtrosConceptosCollection1New = attachedPagosOtrosConceptosCollection1New;
            opciones.setPagosOtrosConceptosCollection1(pagosOtrosConceptosCollection1New);
            Collection<PagosOtrosConceptos> attachedPagosOtrosConceptosCollection2New = new ArrayList<PagosOtrosConceptos>();
            for (PagosOtrosConceptos pagosOtrosConceptosCollection2NewPagosOtrosConceptosToAttach : pagosOtrosConceptosCollection2New) {
                pagosOtrosConceptosCollection2NewPagosOtrosConceptosToAttach = em.getReference(pagosOtrosConceptosCollection2NewPagosOtrosConceptosToAttach.getClass(), pagosOtrosConceptosCollection2NewPagosOtrosConceptosToAttach.getId());
                attachedPagosOtrosConceptosCollection2New.add(pagosOtrosConceptosCollection2NewPagosOtrosConceptosToAttach);
            }
            pagosOtrosConceptosCollection2New = attachedPagosOtrosConceptosCollection2New;
            opciones.setPagosOtrosConceptosCollection2(pagosOtrosConceptosCollection2New);
            Collection<Socios> attachedSociosCollectionNew = new ArrayList<Socios>();
            for (Socios sociosCollectionNewSociosToAttach : sociosCollectionNew) {
                sociosCollectionNewSociosToAttach = em.getReference(sociosCollectionNewSociosToAttach.getClass(), sociosCollectionNewSociosToAttach.getId());
                attachedSociosCollectionNew.add(sociosCollectionNewSociosToAttach);
            }
            sociosCollectionNew = attachedSociosCollectionNew;
            opciones.setSociosCollection(sociosCollectionNew);
            Collection<Socios> attachedSociosCollection1New = new ArrayList<Socios>();
            for (Socios sociosCollection1NewSociosToAttach : sociosCollection1New) {
                sociosCollection1NewSociosToAttach = em.getReference(sociosCollection1NewSociosToAttach.getClass(), sociosCollection1NewSociosToAttach.getId());
                attachedSociosCollection1New.add(sociosCollection1NewSociosToAttach);
            }
            sociosCollection1New = attachedSociosCollection1New;
            opciones.setSociosCollection1(sociosCollection1New);
            Collection<MensajesEnviadosSocios> attachedMensajesEnviadosSociosCollectionNew = new ArrayList<MensajesEnviadosSocios>();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach : mensajesEnviadosSociosCollectionNew) {
                mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach = em.getReference(mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach.getClass(), mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach.getId());
                attachedMensajesEnviadosSociosCollectionNew.add(mensajesEnviadosSociosCollectionNewMensajesEnviadosSociosToAttach);
            }
            mensajesEnviadosSociosCollectionNew = attachedMensajesEnviadosSociosCollectionNew;
            opciones.setMensajesEnviadosSociosCollection(mensajesEnviadosSociosCollectionNew);
            Collection<TematicaParticExpoSocios> attachedTematicaParticExpoSociosCollectionNew = new ArrayList<TematicaParticExpoSocios>();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach : tematicaParticExpoSociosCollectionNew) {
                tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach = em.getReference(tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach.getClass(), tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach.getId());
                attachedTematicaParticExpoSociosCollectionNew.add(tematicaParticExpoSociosCollectionNewTematicaParticExpoSociosToAttach);
            }
            tematicaParticExpoSociosCollectionNew = attachedTematicaParticExpoSociosCollectionNew;
            opciones.setTematicaParticExpoSociosCollection(tematicaParticExpoSociosCollectionNew);
            Collection<Opciones> attachedOpcionesCollectionNew = new ArrayList<Opciones>();
            for (Opciones opcionesCollectionNewOpcionesToAttach : opcionesCollectionNew) {
                opcionesCollectionNewOpcionesToAttach = em.getReference(opcionesCollectionNewOpcionesToAttach.getClass(), opcionesCollectionNewOpcionesToAttach.getId());
                attachedOpcionesCollectionNew.add(opcionesCollectionNewOpcionesToAttach);
            }
            opcionesCollectionNew = attachedOpcionesCollectionNew;
            opciones.setOpcionesCollection(opcionesCollectionNew);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollectionNew = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach : pagosCuotasSociosCollectionNew) {
                pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollectionNew.add(pagosCuotasSociosCollectionNewPagosCuotasSociosToAttach);
            }
            pagosCuotasSociosCollectionNew = attachedPagosCuotasSociosCollectionNew;
            opciones.setPagosCuotasSociosCollection(pagosCuotasSociosCollectionNew);
            Collection<PagosCuotasSocios> attachedPagosCuotasSociosCollection1New = new ArrayList<PagosCuotasSocios>();
            for (PagosCuotasSocios pagosCuotasSociosCollection1NewPagosCuotasSociosToAttach : pagosCuotasSociosCollection1New) {
                pagosCuotasSociosCollection1NewPagosCuotasSociosToAttach = em.getReference(pagosCuotasSociosCollection1NewPagosCuotasSociosToAttach.getClass(), pagosCuotasSociosCollection1NewPagosCuotasSociosToAttach.getId());
                attachedPagosCuotasSociosCollection1New.add(pagosCuotasSociosCollection1NewPagosCuotasSociosToAttach);
            }
            pagosCuotasSociosCollection1New = attachedPagosCuotasSociosCollection1New;
            opciones.setPagosCuotasSociosCollection1(pagosCuotasSociosCollection1New);
            Collection<MovimientosSocios> attachedMovimientosSociosCollectionNew = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSociosToAttach : movimientosSociosCollectionNew) {
                movimientosSociosCollectionNewMovimientosSociosToAttach = em.getReference(movimientosSociosCollectionNewMovimientosSociosToAttach.getClass(), movimientosSociosCollectionNewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollectionNew.add(movimientosSociosCollectionNewMovimientosSociosToAttach);
            }
            movimientosSociosCollectionNew = attachedMovimientosSociosCollectionNew;
            opciones.setMovimientosSociosCollection(movimientosSociosCollectionNew);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection1New = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollection1NewMovimientosSociosToAttach : movimientosSociosCollection1New) {
                movimientosSociosCollection1NewMovimientosSociosToAttach = em.getReference(movimientosSociosCollection1NewMovimientosSociosToAttach.getClass(), movimientosSociosCollection1NewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection1New.add(movimientosSociosCollection1NewMovimientosSociosToAttach);
            }
            movimientosSociosCollection1New = attachedMovimientosSociosCollection1New;
            opciones.setMovimientosSociosCollection1(movimientosSociosCollection1New);
            Collection<MovimientosSocios> attachedMovimientosSociosCollection2New = new ArrayList<MovimientosSocios>();
            for (MovimientosSocios movimientosSociosCollection2NewMovimientosSociosToAttach : movimientosSociosCollection2New) {
                movimientosSociosCollection2NewMovimientosSociosToAttach = em.getReference(movimientosSociosCollection2NewMovimientosSociosToAttach.getClass(), movimientosSociosCollection2NewMovimientosSociosToAttach.getId());
                attachedMovimientosSociosCollection2New.add(movimientosSociosCollection2NewMovimientosSociosToAttach);
            }
            movimientosSociosCollection2New = attachedMovimientosSociosCollection2New;
            opciones.setMovimientosSociosCollection2(movimientosSociosCollection2New);
            opciones = em.merge(opciones);
            if (idDominioOld != null && !idDominioOld.equals(idDominioNew)) {
                idDominioOld.getOpcionesCollection().remove(opciones);
                idDominioOld = em.merge(idDominioOld);
            }
            if (idDominioNew != null && !idDominioNew.equals(idDominioOld)) {
                idDominioNew.getOpcionesCollection().add(opciones);
                idDominioNew = em.merge(idDominioNew);
            }
            if (idOpcionPadreOld != null && !idOpcionPadreOld.equals(idOpcionPadreNew)) {
                idOpcionPadreOld.getOpcionesCollection().remove(opciones);
                idOpcionPadreOld = em.merge(idOpcionPadreOld);
            }
            if (idOpcionPadreNew != null && !idOpcionPadreNew.equals(idOpcionPadreOld)) {
                idOpcionPadreNew.getOpcionesCollection().add(opciones);
                idOpcionPadreNew = em.merge(idOpcionPadreNew);
            }
            for (EstadosSocios estadosSociosCollectionNewEstadosSocios : estadosSociosCollectionNew) {
                if (!estadosSociosCollectionOld.contains(estadosSociosCollectionNewEstadosSocios)) {
                    Opciones oldIdEstadoOfEstadosSociosCollectionNewEstadosSocios = estadosSociosCollectionNewEstadosSocios.getIdEstado();
                    estadosSociosCollectionNewEstadosSocios.setIdEstado(opciones);
                    estadosSociosCollectionNewEstadosSocios = em.merge(estadosSociosCollectionNewEstadosSocios);
                    if (oldIdEstadoOfEstadosSociosCollectionNewEstadosSocios != null && !oldIdEstadoOfEstadosSociosCollectionNewEstadosSocios.equals(opciones)) {
                        oldIdEstadoOfEstadosSociosCollectionNewEstadosSocios.getEstadosSociosCollection().remove(estadosSociosCollectionNewEstadosSocios);
                        oldIdEstadoOfEstadosSociosCollectionNewEstadosSocios = em.merge(oldIdEstadoOfEstadosSociosCollectionNewEstadosSocios);
                    }
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollectionOldPagosOtrosConceptos : pagosOtrosConceptosCollectionOld) {
                if (!pagosOtrosConceptosCollectionNew.contains(pagosOtrosConceptosCollectionOldPagosOtrosConceptos)) {
                    pagosOtrosConceptosCollectionOldPagosOtrosConceptos.setIdConcepto(null);
                    pagosOtrosConceptosCollectionOldPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollectionOldPagosOtrosConceptos);
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollectionNewPagosOtrosConceptos : pagosOtrosConceptosCollectionNew) {
                if (!pagosOtrosConceptosCollectionOld.contains(pagosOtrosConceptosCollectionNewPagosOtrosConceptos)) {
                    Opciones oldIdConceptoOfPagosOtrosConceptosCollectionNewPagosOtrosConceptos = pagosOtrosConceptosCollectionNewPagosOtrosConceptos.getIdConcepto();
                    pagosOtrosConceptosCollectionNewPagosOtrosConceptos.setIdConcepto(opciones);
                    pagosOtrosConceptosCollectionNewPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollectionNewPagosOtrosConceptos);
                    if (oldIdConceptoOfPagosOtrosConceptosCollectionNewPagosOtrosConceptos != null && !oldIdConceptoOfPagosOtrosConceptosCollectionNewPagosOtrosConceptos.equals(opciones)) {
                        oldIdConceptoOfPagosOtrosConceptosCollectionNewPagosOtrosConceptos.getPagosOtrosConceptosCollection().remove(pagosOtrosConceptosCollectionNewPagosOtrosConceptos);
                        oldIdConceptoOfPagosOtrosConceptosCollectionNewPagosOtrosConceptos = em.merge(oldIdConceptoOfPagosOtrosConceptosCollectionNewPagosOtrosConceptos);
                    }
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollection1OldPagosOtrosConceptos : pagosOtrosConceptosCollection1Old) {
                if (!pagosOtrosConceptosCollection1New.contains(pagosOtrosConceptosCollection1OldPagosOtrosConceptos)) {
                    pagosOtrosConceptosCollection1OldPagosOtrosConceptos.setIdEstado(null);
                    pagosOtrosConceptosCollection1OldPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection1OldPagosOtrosConceptos);
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollection1NewPagosOtrosConceptos : pagosOtrosConceptosCollection1New) {
                if (!pagosOtrosConceptosCollection1Old.contains(pagosOtrosConceptosCollection1NewPagosOtrosConceptos)) {
                    Opciones oldIdEstadoOfPagosOtrosConceptosCollection1NewPagosOtrosConceptos = pagosOtrosConceptosCollection1NewPagosOtrosConceptos.getIdEstado();
                    pagosOtrosConceptosCollection1NewPagosOtrosConceptos.setIdEstado(opciones);
                    pagosOtrosConceptosCollection1NewPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection1NewPagosOtrosConceptos);
                    if (oldIdEstadoOfPagosOtrosConceptosCollection1NewPagosOtrosConceptos != null && !oldIdEstadoOfPagosOtrosConceptosCollection1NewPagosOtrosConceptos.equals(opciones)) {
                        oldIdEstadoOfPagosOtrosConceptosCollection1NewPagosOtrosConceptos.getPagosOtrosConceptosCollection1().remove(pagosOtrosConceptosCollection1NewPagosOtrosConceptos);
                        oldIdEstadoOfPagosOtrosConceptosCollection1NewPagosOtrosConceptos = em.merge(oldIdEstadoOfPagosOtrosConceptosCollection1NewPagosOtrosConceptos);
                    }
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollection2OldPagosOtrosConceptos : pagosOtrosConceptosCollection2Old) {
                if (!pagosOtrosConceptosCollection2New.contains(pagosOtrosConceptosCollection2OldPagosOtrosConceptos)) {
                    pagosOtrosConceptosCollection2OldPagosOtrosConceptos.setIdMedioPago(null);
                    pagosOtrosConceptosCollection2OldPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection2OldPagosOtrosConceptos);
                }
            }
            for (PagosOtrosConceptos pagosOtrosConceptosCollection2NewPagosOtrosConceptos : pagosOtrosConceptosCollection2New) {
                if (!pagosOtrosConceptosCollection2Old.contains(pagosOtrosConceptosCollection2NewPagosOtrosConceptos)) {
                    Opciones oldIdMedioPagoOfPagosOtrosConceptosCollection2NewPagosOtrosConceptos = pagosOtrosConceptosCollection2NewPagosOtrosConceptos.getIdMedioPago();
                    pagosOtrosConceptosCollection2NewPagosOtrosConceptos.setIdMedioPago(opciones);
                    pagosOtrosConceptosCollection2NewPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection2NewPagosOtrosConceptos);
                    if (oldIdMedioPagoOfPagosOtrosConceptosCollection2NewPagosOtrosConceptos != null && !oldIdMedioPagoOfPagosOtrosConceptosCollection2NewPagosOtrosConceptos.equals(opciones)) {
                        oldIdMedioPagoOfPagosOtrosConceptosCollection2NewPagosOtrosConceptos.getPagosOtrosConceptosCollection2().remove(pagosOtrosConceptosCollection2NewPagosOtrosConceptos);
                        oldIdMedioPagoOfPagosOtrosConceptosCollection2NewPagosOtrosConceptos = em.merge(oldIdMedioPagoOfPagosOtrosConceptosCollection2NewPagosOtrosConceptos);
                    }
                }
            }
            for (Socios sociosCollectionNewSocios : sociosCollectionNew) {
                if (!sociosCollectionOld.contains(sociosCollectionNewSocios)) {
                    Opciones oldIdEstadoActualOfSociosCollectionNewSocios = sociosCollectionNewSocios.getIdEstadoActual();
                    sociosCollectionNewSocios.setIdEstadoActual(opciones);
                    sociosCollectionNewSocios = em.merge(sociosCollectionNewSocios);
                    if (oldIdEstadoActualOfSociosCollectionNewSocios != null && !oldIdEstadoActualOfSociosCollectionNewSocios.equals(opciones)) {
                        oldIdEstadoActualOfSociosCollectionNewSocios.getSociosCollection().remove(sociosCollectionNewSocios);
                        oldIdEstadoActualOfSociosCollectionNewSocios = em.merge(oldIdEstadoActualOfSociosCollectionNewSocios);
                    }
                }
            }
            for (Socios sociosCollection1OldSocios : sociosCollection1Old) {
                if (!sociosCollection1New.contains(sociosCollection1OldSocios)) {
                    sociosCollection1OldSocios.setIdTipoSocio(null);
                    sociosCollection1OldSocios = em.merge(sociosCollection1OldSocios);
                }
            }
            for (Socios sociosCollection1NewSocios : sociosCollection1New) {
                if (!sociosCollection1Old.contains(sociosCollection1NewSocios)) {
                    Opciones oldIdTipoSocioOfSociosCollection1NewSocios = sociosCollection1NewSocios.getIdTipoSocio();
                    sociosCollection1NewSocios.setIdTipoSocio(opciones);
                    sociosCollection1NewSocios = em.merge(sociosCollection1NewSocios);
                    if (oldIdTipoSocioOfSociosCollection1NewSocios != null && !oldIdTipoSocioOfSociosCollection1NewSocios.equals(opciones)) {
                        oldIdTipoSocioOfSociosCollection1NewSocios.getSociosCollection1().remove(sociosCollection1NewSocios);
                        oldIdTipoSocioOfSociosCollection1NewSocios = em.merge(oldIdTipoSocioOfSociosCollection1NewSocios);
                    }
                }
            }
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios : mensajesEnviadosSociosCollectionNew) {
                if (!mensajesEnviadosSociosCollectionOld.contains(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios)) {
                    Opciones oldIdMensajeOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.getIdMensaje();
                    mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.setIdMensaje(opciones);
                    mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = em.merge(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                    if (oldIdMensajeOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios != null && !oldIdMensajeOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.equals(opciones)) {
                        oldIdMensajeOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios.getMensajesEnviadosSociosCollection().remove(mensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                        oldIdMensajeOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios = em.merge(oldIdMensajeOfMensajesEnviadosSociosCollectionNewMensajesEnviadosSocios);
                    }
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios : tematicaParticExpoSociosCollectionOld) {
                if (!tematicaParticExpoSociosCollectionNew.contains(tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios)) {
                    tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios.setIdTematicaGeneral(null);
                    tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionOldTematicaParticExpoSocios);
                }
            }
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios : tematicaParticExpoSociosCollectionNew) {
                if (!tematicaParticExpoSociosCollectionOld.contains(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios)) {
                    Opciones oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.getIdTematicaGeneral();
                    tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.setIdTematicaGeneral(opciones);
                    tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                    if (oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios != null && !oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.equals(opciones)) {
                        oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios.getTematicaParticExpoSociosCollection().remove(tematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                        oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios = em.merge(oldIdTematicaGeneralOfTematicaParticExpoSociosCollectionNewTematicaParticExpoSocios);
                    }
                }
            }
            for (Opciones opcionesCollectionOldOpciones : opcionesCollectionOld) {
                if (!opcionesCollectionNew.contains(opcionesCollectionOldOpciones)) {
                    opcionesCollectionOldOpciones.setIdOpcionPadre(null);
                    opcionesCollectionOldOpciones = em.merge(opcionesCollectionOldOpciones);
                }
            }
            for (Opciones opcionesCollectionNewOpciones : opcionesCollectionNew) {
                if (!opcionesCollectionOld.contains(opcionesCollectionNewOpciones)) {
                    Opciones oldIdOpcionPadreOfOpcionesCollectionNewOpciones = opcionesCollectionNewOpciones.getIdOpcionPadre();
                    opcionesCollectionNewOpciones.setIdOpcionPadre(opciones);
                    opcionesCollectionNewOpciones = em.merge(opcionesCollectionNewOpciones);
                    if (oldIdOpcionPadreOfOpcionesCollectionNewOpciones != null && !oldIdOpcionPadreOfOpcionesCollectionNewOpciones.equals(opciones)) {
                        oldIdOpcionPadreOfOpcionesCollectionNewOpciones.getOpcionesCollection().remove(opcionesCollectionNewOpciones);
                        oldIdOpcionPadreOfOpcionesCollectionNewOpciones = em.merge(oldIdOpcionPadreOfOpcionesCollectionNewOpciones);
                    }
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionOldPagosCuotasSocios : pagosCuotasSociosCollectionOld) {
                if (!pagosCuotasSociosCollectionNew.contains(pagosCuotasSociosCollectionOldPagosCuotasSocios)) {
                    pagosCuotasSociosCollectionOldPagosCuotasSocios.setIdEstado(null);
                    pagosCuotasSociosCollectionOldPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionOldPagosCuotasSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollectionNewPagosCuotasSocios : pagosCuotasSociosCollectionNew) {
                if (!pagosCuotasSociosCollectionOld.contains(pagosCuotasSociosCollectionNewPagosCuotasSocios)) {
                    Opciones oldIdEstadoOfPagosCuotasSociosCollectionNewPagosCuotasSocios = pagosCuotasSociosCollectionNewPagosCuotasSocios.getIdEstado();
                    pagosCuotasSociosCollectionNewPagosCuotasSocios.setIdEstado(opciones);
                    pagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                    if (oldIdEstadoOfPagosCuotasSociosCollectionNewPagosCuotasSocios != null && !oldIdEstadoOfPagosCuotasSociosCollectionNewPagosCuotasSocios.equals(opciones)) {
                        oldIdEstadoOfPagosCuotasSociosCollectionNewPagosCuotasSocios.getPagosCuotasSociosCollection().remove(pagosCuotasSociosCollectionNewPagosCuotasSocios);
                        oldIdEstadoOfPagosCuotasSociosCollectionNewPagosCuotasSocios = em.merge(oldIdEstadoOfPagosCuotasSociosCollectionNewPagosCuotasSocios);
                    }
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollection1OldPagosCuotasSocios : pagosCuotasSociosCollection1Old) {
                if (!pagosCuotasSociosCollection1New.contains(pagosCuotasSociosCollection1OldPagosCuotasSocios)) {
                    pagosCuotasSociosCollection1OldPagosCuotasSocios.setIdMotivoExoneracion(null);
                    pagosCuotasSociosCollection1OldPagosCuotasSocios = em.merge(pagosCuotasSociosCollection1OldPagosCuotasSocios);
                }
            }
            for (PagosCuotasSocios pagosCuotasSociosCollection1NewPagosCuotasSocios : pagosCuotasSociosCollection1New) {
                if (!pagosCuotasSociosCollection1Old.contains(pagosCuotasSociosCollection1NewPagosCuotasSocios)) {
                    Opciones oldIdMotivoExoneracionOfPagosCuotasSociosCollection1NewPagosCuotasSocios = pagosCuotasSociosCollection1NewPagosCuotasSocios.getIdMotivoExoneracion();
                    pagosCuotasSociosCollection1NewPagosCuotasSocios.setIdMotivoExoneracion(opciones);
                    pagosCuotasSociosCollection1NewPagosCuotasSocios = em.merge(pagosCuotasSociosCollection1NewPagosCuotasSocios);
                    if (oldIdMotivoExoneracionOfPagosCuotasSociosCollection1NewPagosCuotasSocios != null && !oldIdMotivoExoneracionOfPagosCuotasSociosCollection1NewPagosCuotasSocios.equals(opciones)) {
                        oldIdMotivoExoneracionOfPagosCuotasSociosCollection1NewPagosCuotasSocios.getPagosCuotasSociosCollection1().remove(pagosCuotasSociosCollection1NewPagosCuotasSocios);
                        oldIdMotivoExoneracionOfPagosCuotasSociosCollection1NewPagosCuotasSocios = em.merge(oldIdMotivoExoneracionOfPagosCuotasSociosCollection1NewPagosCuotasSocios);
                    }
                }
            }
            for (MovimientosSocios movimientosSociosCollectionOldMovimientosSocios : movimientosSociosCollectionOld) {
                if (!movimientosSociosCollectionNew.contains(movimientosSociosCollectionOldMovimientosSocios)) {
                    movimientosSociosCollectionOldMovimientosSocios.setIdEstado(null);
                    movimientosSociosCollectionOldMovimientosSocios = em.merge(movimientosSociosCollectionOldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollectionNewMovimientosSocios : movimientosSociosCollectionNew) {
                if (!movimientosSociosCollectionOld.contains(movimientosSociosCollectionNewMovimientosSocios)) {
                    Opciones oldIdEstadoOfMovimientosSociosCollectionNewMovimientosSocios = movimientosSociosCollectionNewMovimientosSocios.getIdEstado();
                    movimientosSociosCollectionNewMovimientosSocios.setIdEstado(opciones);
                    movimientosSociosCollectionNewMovimientosSocios = em.merge(movimientosSociosCollectionNewMovimientosSocios);
                    if (oldIdEstadoOfMovimientosSociosCollectionNewMovimientosSocios != null && !oldIdEstadoOfMovimientosSociosCollectionNewMovimientosSocios.equals(opciones)) {
                        oldIdEstadoOfMovimientosSociosCollectionNewMovimientosSocios.getMovimientosSociosCollection().remove(movimientosSociosCollectionNewMovimientosSocios);
                        oldIdEstadoOfMovimientosSociosCollectionNewMovimientosSocios = em.merge(oldIdEstadoOfMovimientosSociosCollectionNewMovimientosSocios);
                    }
                }
            }
            for (MovimientosSocios movimientosSociosCollection1OldMovimientosSocios : movimientosSociosCollection1Old) {
                if (!movimientosSociosCollection1New.contains(movimientosSociosCollection1OldMovimientosSocios)) {
                    movimientosSociosCollection1OldMovimientosSocios.setIdMedioPago(null);
                    movimientosSociosCollection1OldMovimientosSocios = em.merge(movimientosSociosCollection1OldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollection1NewMovimientosSocios : movimientosSociosCollection1New) {
                if (!movimientosSociosCollection1Old.contains(movimientosSociosCollection1NewMovimientosSocios)) {
                    Opciones oldIdMedioPagoOfMovimientosSociosCollection1NewMovimientosSocios = movimientosSociosCollection1NewMovimientosSocios.getIdMedioPago();
                    movimientosSociosCollection1NewMovimientosSocios.setIdMedioPago(opciones);
                    movimientosSociosCollection1NewMovimientosSocios = em.merge(movimientosSociosCollection1NewMovimientosSocios);
                    if (oldIdMedioPagoOfMovimientosSociosCollection1NewMovimientosSocios != null && !oldIdMedioPagoOfMovimientosSociosCollection1NewMovimientosSocios.equals(opciones)) {
                        oldIdMedioPagoOfMovimientosSociosCollection1NewMovimientosSocios.getMovimientosSociosCollection1().remove(movimientosSociosCollection1NewMovimientosSocios);
                        oldIdMedioPagoOfMovimientosSociosCollection1NewMovimientosSocios = em.merge(oldIdMedioPagoOfMovimientosSociosCollection1NewMovimientosSocios);
                    }
                }
            }
            for (MovimientosSocios movimientosSociosCollection2OldMovimientosSocios : movimientosSociosCollection2Old) {
                if (!movimientosSociosCollection2New.contains(movimientosSociosCollection2OldMovimientosSocios)) {
                    movimientosSociosCollection2OldMovimientosSocios.setIdConcepto(null);
                    movimientosSociosCollection2OldMovimientosSocios = em.merge(movimientosSociosCollection2OldMovimientosSocios);
                }
            }
            for (MovimientosSocios movimientosSociosCollection2NewMovimientosSocios : movimientosSociosCollection2New) {
                if (!movimientosSociosCollection2Old.contains(movimientosSociosCollection2NewMovimientosSocios)) {
                    Opciones oldIdConceptoOfMovimientosSociosCollection2NewMovimientosSocios = movimientosSociosCollection2NewMovimientosSocios.getIdConcepto();
                    movimientosSociosCollection2NewMovimientosSocios.setIdConcepto(opciones);
                    movimientosSociosCollection2NewMovimientosSocios = em.merge(movimientosSociosCollection2NewMovimientosSocios);
                    if (oldIdConceptoOfMovimientosSociosCollection2NewMovimientosSocios != null && !oldIdConceptoOfMovimientosSociosCollection2NewMovimientosSocios.equals(opciones)) {
                        oldIdConceptoOfMovimientosSociosCollection2NewMovimientosSocios.getMovimientosSociosCollection2().remove(movimientosSociosCollection2NewMovimientosSocios);
                        oldIdConceptoOfMovimientosSociosCollection2NewMovimientosSocios = em.merge(oldIdConceptoOfMovimientosSociosCollection2NewMovimientosSocios);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = opciones.getId();
                if (findOpciones(id) == null) {
                    throw new NonexistentEntityException("The opciones with id " + id + " no longer exists.");
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
            Opciones opciones;
            try {
                opciones = em.getReference(Opciones.class, id);
                opciones.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The opciones with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<EstadosSocios> estadosSociosCollectionOrphanCheck = opciones.getEstadosSociosCollection();
            for (EstadosSocios estadosSociosCollectionOrphanCheckEstadosSocios : estadosSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Opciones (" + opciones + ") cannot be destroyed since the EstadosSocios " + estadosSociosCollectionOrphanCheckEstadosSocios + " in its estadosSociosCollection field has a non-nullable idEstado field.");
            }
            Collection<Socios> sociosCollectionOrphanCheck = opciones.getSociosCollection();
            for (Socios sociosCollectionOrphanCheckSocios : sociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Opciones (" + opciones + ") cannot be destroyed since the Socios " + sociosCollectionOrphanCheckSocios + " in its sociosCollection field has a non-nullable idEstadoActual field.");
            }
            Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollectionOrphanCheck = opciones.getMensajesEnviadosSociosCollection();
            for (MensajesEnviadosSocios mensajesEnviadosSociosCollectionOrphanCheckMensajesEnviadosSocios : mensajesEnviadosSociosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Opciones (" + opciones + ") cannot be destroyed since the MensajesEnviadosSocios " + mensajesEnviadosSociosCollectionOrphanCheckMensajesEnviadosSocios + " in its mensajesEnviadosSociosCollection field has a non-nullable idMensaje field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Dominios idDominio = opciones.getIdDominio();
            if (idDominio != null) {
                idDominio.getOpcionesCollection().remove(opciones);
                idDominio = em.merge(idDominio);
            }
            Opciones idOpcionPadre = opciones.getIdOpcionPadre();
            if (idOpcionPadre != null) {
                idOpcionPadre.getOpcionesCollection().remove(opciones);
                idOpcionPadre = em.merge(idOpcionPadre);
            }
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection = opciones.getPagosOtrosConceptosCollection();
            for (PagosOtrosConceptos pagosOtrosConceptosCollectionPagosOtrosConceptos : pagosOtrosConceptosCollection) {
                pagosOtrosConceptosCollectionPagosOtrosConceptos.setIdConcepto(null);
                pagosOtrosConceptosCollectionPagosOtrosConceptos = em.merge(pagosOtrosConceptosCollectionPagosOtrosConceptos);
            }
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection1 = opciones.getPagosOtrosConceptosCollection1();
            for (PagosOtrosConceptos pagosOtrosConceptosCollection1PagosOtrosConceptos : pagosOtrosConceptosCollection1) {
                pagosOtrosConceptosCollection1PagosOtrosConceptos.setIdEstado(null);
                pagosOtrosConceptosCollection1PagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection1PagosOtrosConceptos);
            }
            Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection2 = opciones.getPagosOtrosConceptosCollection2();
            for (PagosOtrosConceptos pagosOtrosConceptosCollection2PagosOtrosConceptos : pagosOtrosConceptosCollection2) {
                pagosOtrosConceptosCollection2PagosOtrosConceptos.setIdMedioPago(null);
                pagosOtrosConceptosCollection2PagosOtrosConceptos = em.merge(pagosOtrosConceptosCollection2PagosOtrosConceptos);
            }
            Collection<Socios> sociosCollection1 = opciones.getSociosCollection1();
            for (Socios sociosCollection1Socios : sociosCollection1) {
                sociosCollection1Socios.setIdTipoSocio(null);
                sociosCollection1Socios = em.merge(sociosCollection1Socios);
            }
            Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection = opciones.getTematicaParticExpoSociosCollection();
            for (TematicaParticExpoSocios tematicaParticExpoSociosCollectionTematicaParticExpoSocios : tematicaParticExpoSociosCollection) {
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios.setIdTematicaGeneral(null);
                tematicaParticExpoSociosCollectionTematicaParticExpoSocios = em.merge(tematicaParticExpoSociosCollectionTematicaParticExpoSocios);
            }
            Collection<Opciones> opcionesCollection = opciones.getOpcionesCollection();
            for (Opciones opcionesCollectionOpciones : opcionesCollection) {
                opcionesCollectionOpciones.setIdOpcionPadre(null);
                opcionesCollectionOpciones = em.merge(opcionesCollectionOpciones);
            }
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection = opciones.getPagosCuotasSociosCollection();
            for (PagosCuotasSocios pagosCuotasSociosCollectionPagosCuotasSocios : pagosCuotasSociosCollection) {
                pagosCuotasSociosCollectionPagosCuotasSocios.setIdEstado(null);
                pagosCuotasSociosCollectionPagosCuotasSocios = em.merge(pagosCuotasSociosCollectionPagosCuotasSocios);
            }
            Collection<PagosCuotasSocios> pagosCuotasSociosCollection1 = opciones.getPagosCuotasSociosCollection1();
            for (PagosCuotasSocios pagosCuotasSociosCollection1PagosCuotasSocios : pagosCuotasSociosCollection1) {
                pagosCuotasSociosCollection1PagosCuotasSocios.setIdMotivoExoneracion(null);
                pagosCuotasSociosCollection1PagosCuotasSocios = em.merge(pagosCuotasSociosCollection1PagosCuotasSocios);
            }
            Collection<MovimientosSocios> movimientosSociosCollection = opciones.getMovimientosSociosCollection();
            for (MovimientosSocios movimientosSociosCollectionMovimientosSocios : movimientosSociosCollection) {
                movimientosSociosCollectionMovimientosSocios.setIdEstado(null);
                movimientosSociosCollectionMovimientosSocios = em.merge(movimientosSociosCollectionMovimientosSocios);
            }
            Collection<MovimientosSocios> movimientosSociosCollection1 = opciones.getMovimientosSociosCollection1();
            for (MovimientosSocios movimientosSociosCollection1MovimientosSocios : movimientosSociosCollection1) {
                movimientosSociosCollection1MovimientosSocios.setIdMedioPago(null);
                movimientosSociosCollection1MovimientosSocios = em.merge(movimientosSociosCollection1MovimientosSocios);
            }
            Collection<MovimientosSocios> movimientosSociosCollection2 = opciones.getMovimientosSociosCollection2();
            for (MovimientosSocios movimientosSociosCollection2MovimientosSocios : movimientosSociosCollection2) {
                movimientosSociosCollection2MovimientosSocios.setIdConcepto(null);
                movimientosSociosCollection2MovimientosSocios = em.merge(movimientosSociosCollection2MovimientosSocios);
            }
            em.remove(opciones);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Opciones> findOpcionesEntities() {
        return findOpcionesEntities(true, -1, -1);
    }

    public List<Opciones> findOpcionesEntities(int maxResults, int firstResult) {
        return findOpcionesEntities(false, maxResults, firstResult);
    }

    private List<Opciones> findOpcionesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Opciones.class));
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

    public Opciones findOpciones(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Opciones.class, id);
        } finally {
            em.close();
        }
    }

    public int getOpcionesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Opciones> rt = cq.from(Opciones.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
