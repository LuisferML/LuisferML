/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.curso.asoweb.logica;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "pagos_cuotas_socios")
@NamedQueries({
    @NamedQuery(name = "PagosCuotasSocios.findAll", query = "SELECT p FROM PagosCuotasSocios p"),
    @NamedQuery(name = "PagosCuotasSocios.findById", query = "SELECT p FROM PagosCuotasSocios p WHERE p.id = :id"),
    @NamedQuery(name = "PagosCuotasSocios.findByAnhoCuota", query = "SELECT p FROM PagosCuotasSocios p WHERE p.anhoCuota = :anhoCuota"),
    @NamedQuery(name = "PagosCuotasSocios.findByExonerado", query = "SELECT p FROM PagosCuotasSocios p WHERE p.exonerado = :exonerado"),
    @NamedQuery(name = "PagosCuotasSocios.findByFechaCreacion", query = "SELECT p FROM PagosCuotasSocios p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PagosCuotasSocios.findByMesCuota", query = "SELECT p FROM PagosCuotasSocios p WHERE p.mesCuota = :mesCuota"),
    @NamedQuery(name = "PagosCuotasSocios.findByMontoCuota", query = "SELECT p FROM PagosCuotasSocios p WHERE p.montoCuota = :montoCuota")})
public class PagosCuotasSocios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "anho_cuota")
    private BigDecimal anhoCuota;
    @Column(name = "exonerado")
    private Boolean exonerado;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Column(name = "mes_cuota")
    private BigDecimal mesCuota;
    @Column(name = "monto_cuota")
    private BigDecimal montoCuota;
    @JoinColumn(name = "id_movimiento_socio", referencedColumnName = "id")
    @ManyToOne
    private MovimientosSocios idMovimientoSocio;
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne
    private Opciones idEstado;
    @JoinColumn(name = "id_motivo_exoneracion", referencedColumnName = "id")
    @ManyToOne
    private Opciones idMotivoExoneracion;
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    @ManyToOne
    private Socios idSocio;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioCreacion;

    public PagosCuotasSocios() {
    }

    public PagosCuotasSocios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAnhoCuota() {
        return anhoCuota;
    }

    public void setAnhoCuota(BigDecimal anhoCuota) {
        this.anhoCuota = anhoCuota;
    }

    public Boolean getExonerado() {
        return exonerado;
    }

    public void setExonerado(Boolean exonerado) {
        this.exonerado = exonerado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getMesCuota() {
        return mesCuota;
    }

    public void setMesCuota(BigDecimal mesCuota) {
        this.mesCuota = mesCuota;
    }

    public BigDecimal getMontoCuota() {
        return montoCuota;
    }

    public void setMontoCuota(BigDecimal montoCuota) {
        this.montoCuota = montoCuota;
    }

    public MovimientosSocios getIdMovimientoSocio() {
        return idMovimientoSocio;
    }

    public void setIdMovimientoSocio(MovimientosSocios idMovimientoSocio) {
        this.idMovimientoSocio = idMovimientoSocio;
    }

    public Opciones getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Opciones idEstado) {
        this.idEstado = idEstado;
    }

    public Opciones getIdMotivoExoneracion() {
        return idMotivoExoneracion;
    }

    public void setIdMotivoExoneracion(Opciones idMotivoExoneracion) {
        this.idMotivoExoneracion = idMotivoExoneracion;
    }

    public Socios getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socios idSocio) {
        this.idSocio = idSocio;
    }

    public Usuarios getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Usuarios idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
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
        if (!(object instanceof PagosCuotasSocios)) {
            return false;
        }
        PagosCuotasSocios other = (PagosCuotasSocios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.PagosCuotasSocios[ id=" + id + " ]";
    }
    
}
