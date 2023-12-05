/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.logica;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "opciones")
@NamedQueries({
    @NamedQuery(name = "Opciones.findAll", query = "SELECT o FROM Opciones o"),
    @NamedQuery(name = "Opciones.findById", query = "SELECT o FROM Opciones o WHERE o.id = :id"),
    @NamedQuery(name = "Opciones.findByCodigo", query = "SELECT o FROM Opciones o WHERE o.codigo = :codigo"),
    @NamedQuery(name = "Opciones.findByDescripcion", query = "SELECT o FROM Opciones o WHERE o.descripcion = :descripcion"),
    @NamedQuery(name = "Opciones.findByEstado", query = "SELECT o FROM Opciones o WHERE o.estado = :estado")})
public class Opciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstado")
    private Collection<EstadosSocios> estadosSociosCollection;
    @OneToMany(mappedBy = "idConcepto")
    private Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection;
    @OneToMany(mappedBy = "idEstado")
    private Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection1;
    @OneToMany(mappedBy = "idMedioPago")
    private Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoActual")
    private Collection<Socios> sociosCollection;
    @OneToMany(mappedBy = "idTipoSocio")
    private Collection<Socios> sociosCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMensaje")
    private Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollection;
    @OneToMany(mappedBy = "idTematicaGeneral")
    private Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection;
    @JoinColumn(name = "id_dominio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Dominios idDominio;
    @OneToMany(mappedBy = "idOpcionPadre")
    private Collection<Opciones> opcionesCollection;
    @JoinColumn(name = "id_opcion_padre", referencedColumnName = "id")
    @ManyToOne
    private Opciones idOpcionPadre;
    @OneToMany(mappedBy = "idEstado")
    private Collection<PagosCuotasSocios> pagosCuotasSociosCollection;
    @OneToMany(mappedBy = "idMotivoExoneracion")
    private Collection<PagosCuotasSocios> pagosCuotasSociosCollection1;
    @OneToMany(mappedBy = "idEstado")
    private Collection<MovimientosSocios> movimientosSociosCollection;
    @OneToMany(mappedBy = "idMedioPago")
    private Collection<MovimientosSocios> movimientosSociosCollection1;
    @OneToMany(mappedBy = "idConcepto")
    private Collection<MovimientosSocios> movimientosSociosCollection2;

    public Opciones() {
    }

    public Opciones(Integer id) {
        this.id = id;
    }

    public Opciones(Integer id, String codigo, Character estado) {
        this.id = id;
        this.codigo = codigo;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Collection<EstadosSocios> getEstadosSociosCollection() {
        return estadosSociosCollection;
    }

    public void setEstadosSociosCollection(Collection<EstadosSocios> estadosSociosCollection) {
        this.estadosSociosCollection = estadosSociosCollection;
    }

    public Collection<PagosOtrosConceptos> getPagosOtrosConceptosCollection() {
        return pagosOtrosConceptosCollection;
    }

    public void setPagosOtrosConceptosCollection(Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection) {
        this.pagosOtrosConceptosCollection = pagosOtrosConceptosCollection;
    }

    public Collection<PagosOtrosConceptos> getPagosOtrosConceptosCollection1() {
        return pagosOtrosConceptosCollection1;
    }

    public void setPagosOtrosConceptosCollection1(Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection1) {
        this.pagosOtrosConceptosCollection1 = pagosOtrosConceptosCollection1;
    }

    public Collection<PagosOtrosConceptos> getPagosOtrosConceptosCollection2() {
        return pagosOtrosConceptosCollection2;
    }

    public void setPagosOtrosConceptosCollection2(Collection<PagosOtrosConceptos> pagosOtrosConceptosCollection2) {
        this.pagosOtrosConceptosCollection2 = pagosOtrosConceptosCollection2;
    }

    public Collection<Socios> getSociosCollection() {
        return sociosCollection;
    }

    public void setSociosCollection(Collection<Socios> sociosCollection) {
        this.sociosCollection = sociosCollection;
    }

    public Collection<Socios> getSociosCollection1() {
        return sociosCollection1;
    }

    public void setSociosCollection1(Collection<Socios> sociosCollection1) {
        this.sociosCollection1 = sociosCollection1;
    }

    public Collection<MensajesEnviadosSocios> getMensajesEnviadosSociosCollection() {
        return mensajesEnviadosSociosCollection;
    }

    public void setMensajesEnviadosSociosCollection(Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollection) {
        this.mensajesEnviadosSociosCollection = mensajesEnviadosSociosCollection;
    }

    public Collection<TematicaParticExpoSocios> getTematicaParticExpoSociosCollection() {
        return tematicaParticExpoSociosCollection;
    }

    public void setTematicaParticExpoSociosCollection(Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection) {
        this.tematicaParticExpoSociosCollection = tematicaParticExpoSociosCollection;
    }

    public Dominios getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(Dominios idDominio) {
        this.idDominio = idDominio;
    }

    public Collection<Opciones> getOpcionesCollection() {
        return opcionesCollection;
    }

    public void setOpcionesCollection(Collection<Opciones> opcionesCollection) {
        this.opcionesCollection = opcionesCollection;
    }

    public Opciones getIdOpcionPadre() {
        return idOpcionPadre;
    }

    public void setIdOpcionPadre(Opciones idOpcionPadre) {
        this.idOpcionPadre = idOpcionPadre;
    }

    public Collection<PagosCuotasSocios> getPagosCuotasSociosCollection() {
        return pagosCuotasSociosCollection;
    }

    public void setPagosCuotasSociosCollection(Collection<PagosCuotasSocios> pagosCuotasSociosCollection) {
        this.pagosCuotasSociosCollection = pagosCuotasSociosCollection;
    }

    public Collection<PagosCuotasSocios> getPagosCuotasSociosCollection1() {
        return pagosCuotasSociosCollection1;
    }

    public void setPagosCuotasSociosCollection1(Collection<PagosCuotasSocios> pagosCuotasSociosCollection1) {
        this.pagosCuotasSociosCollection1 = pagosCuotasSociosCollection1;
    }

    public Collection<MovimientosSocios> getMovimientosSociosCollection() {
        return movimientosSociosCollection;
    }

    public void setMovimientosSociosCollection(Collection<MovimientosSocios> movimientosSociosCollection) {
        this.movimientosSociosCollection = movimientosSociosCollection;
    }

    public Collection<MovimientosSocios> getMovimientosSociosCollection1() {
        return movimientosSociosCollection1;
    }

    public void setMovimientosSociosCollection1(Collection<MovimientosSocios> movimientosSociosCollection1) {
        this.movimientosSociosCollection1 = movimientosSociosCollection1;
    }

    public Collection<MovimientosSocios> getMovimientosSociosCollection2() {
        return movimientosSociosCollection2;
    }

    public void setMovimientosSociosCollection2(Collection<MovimientosSocios> movimientosSociosCollection2) {
        this.movimientosSociosCollection2 = movimientosSociosCollection2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Opciones)) {
            return false;
        }
        Opciones other = (Opciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.Opciones[ id=" + id + " ]";
    }
    
}
