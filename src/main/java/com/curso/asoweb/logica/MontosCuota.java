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
import javax.validation.constraints.NotNull;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "montos_cuota")
@NamedQueries({
    @NamedQuery(name = "MontosCuota.findAll", query = "SELECT m FROM MontosCuota m"),
    @NamedQuery(name = "MontosCuota.findById", query = "SELECT m FROM MontosCuota m WHERE m.id = :id"),
    @NamedQuery(name = "MontosCuota.findByMonto", query = "SELECT m FROM MontosCuota m WHERE m.monto = :monto"),
    @NamedQuery(name = "MontosCuota.findByFechaCreacion", query = "SELECT m FROM MontosCuota m WHERE m.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "MontosCuota.findByFechaInicioVigencia", query = "SELECT m FROM MontosCuota m WHERE m.fechaInicioVigencia = :fechaInicioVigencia"),
    @NamedQuery(name = "MontosCuota.findByFechaFinVigencia", query = "SELECT m FROM MontosCuota m WHERE m.fechaFinVigencia = :fechaFinVigencia"),
    @NamedQuery(name = "MontosCuota.findByEstado", query = "SELECT m FROM MontosCuota m WHERE m.estado = :estado"),
    @NamedQuery(name = "MontosCuota.findByFechaInactivacion", query = "SELECT m FROM MontosCuota m WHERE m.fechaInactivacion = :fechaInactivacion")})
public class MontosCuota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_vigencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicioVigencia;
    @Column(name = "fecha_fin_vigencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFinVigencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Column(name = "fecha_inactivacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInactivacion;
    @JoinColumn(name = "id_usuario_inactivacion", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuarioInactivacion;

    public MontosCuota() {
    }

    public MontosCuota(Integer id) {
        this.id = id;
    }

    public MontosCuota(Integer id, BigDecimal monto, Date fechaCreacion, Date fechaInicioVigencia, Character estado) {
        this.id = id;
        this.monto = monto;
        this.fechaCreacion = fechaCreacion;
        this.fechaInicioVigencia = fechaInicioVigencia;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaInicioVigencia() {
        return fechaInicioVigencia;
    }

    public void setFechaInicioVigencia(Date fechaInicioVigencia) {
        this.fechaInicioVigencia = fechaInicioVigencia;
    }

    public Date getFechaFinVigencia() {
        return fechaFinVigencia;
    }

    public void setFechaFinVigencia(Date fechaFinVigencia) {
        this.fechaFinVigencia = fechaFinVigencia;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Date getFechaInactivacion() {
        return fechaInactivacion;
    }

    public void setFechaInactivacion(Date fechaInactivacion) {
        this.fechaInactivacion = fechaInactivacion;
    }

    public Usuarios getIdUsuarioInactivacion() {
        return idUsuarioInactivacion;
    }

    public void setIdUsuarioInactivacion(Usuarios idUsuarioInactivacion) {
        this.idUsuarioInactivacion = idUsuarioInactivacion;
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
        if (!(object instanceof MontosCuota)) {
            return false;
        }
        MontosCuota other = (MontosCuota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.MontosCuota[ id=" + id + " ]";
    }
    
}
