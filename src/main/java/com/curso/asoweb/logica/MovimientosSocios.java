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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "movimientos_socios")
@NamedQueries({
    @NamedQuery(name = "MovimientosSocios.findAll", query = "SELECT m FROM MovimientosSocios m"),
    @NamedQuery(name = "MovimientosSocios.findById", query = "SELECT m FROM MovimientosSocios m WHERE m.id = :id"),
    @NamedQuery(name = "MovimientosSocios.findByFechaPago", query = "SELECT m FROM MovimientosSocios m WHERE m.fechaPago = :fechaPago"),
    @NamedQuery(name = "MovimientosSocios.findByMonto", query = "SELECT m FROM MovimientosSocios m WHERE m.monto = :monto")})
public class MovimientosSocios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @OneToMany(mappedBy = "idMovimientoSocio")
    private Collection<PagosCuotasSocios> pagosCuotasSociosCollection;
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne
    private Opciones idEstado;
    @JoinColumn(name = "id_medio_pago", referencedColumnName = "id")
    @ManyToOne
    private Opciones idMedioPago;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id")
    @ManyToOne
    private Opciones idConcepto;
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    @ManyToOne
    private Socios idSocio;
    @JoinColumn(name = "id_tipo_movimiento", referencedColumnName = "id")
    @ManyToOne
    private TiposMovimiento idTipoMovimiento;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioCreacion;
    @JoinColumn(name = "id_usuario_aprobacion", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioAprobacion;

    public MovimientosSocios() {
    }

    public MovimientosSocios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Collection<PagosCuotasSocios> getPagosCuotasSociosCollection() {
        return pagosCuotasSociosCollection;
    }

    public void setPagosCuotasSociosCollection(Collection<PagosCuotasSocios> pagosCuotasSociosCollection) {
        this.pagosCuotasSociosCollection = pagosCuotasSociosCollection;
    }

    public Opciones getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Opciones idEstado) {
        this.idEstado = idEstado;
    }

    public Opciones getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(Opciones idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public Opciones getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Opciones idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Socios getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socios idSocio) {
        this.idSocio = idSocio;
    }

    public TiposMovimiento getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(TiposMovimiento idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public Usuarios getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Usuarios idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public Usuarios getIdUsuarioAprobacion() {
        return idUsuarioAprobacion;
    }

    public void setIdUsuarioAprobacion(Usuarios idUsuarioAprobacion) {
        this.idUsuarioAprobacion = idUsuarioAprobacion;
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
        if (!(object instanceof MovimientosSocios)) {
            return false;
        }
        MovimientosSocios other = (MovimientosSocios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.MovimientosSocios[ id=" + id + " ]";
    }
    
}
