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
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "estados_socios")
@NamedQueries({
    @NamedQuery(name = "EstadosSocios.findAll", query = "SELECT e FROM EstadosSocios e"),
    @NamedQuery(name = "EstadosSocios.findById", query = "SELECT e FROM EstadosSocios e WHERE e.id = :id"),
    @NamedQuery(name = "EstadosSocios.findByFechaEstado", query = "SELECT e FROM EstadosSocios e WHERE e.fechaEstado = :fechaEstado"),
    @NamedQuery(name = "EstadosSocios.findByFechaCreacion", query = "SELECT e FROM EstadosSocios e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "EstadosSocios.findByObservacion", query = "SELECT e FROM EstadosSocios e WHERE e.observacion = :observacion")})
public class EstadosSocios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_estado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 500)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Opciones idEstado;
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Socios idSocio;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;

    public EstadosSocios() {
    }

    public EstadosSocios(Integer id) {
        this.id = id;
    }

    public EstadosSocios(Integer id, Date fechaEstado, Date fechaCreacion) {
        this.id = id;
        this.fechaEstado = fechaEstado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEstado() {
        return fechaEstado;
    }

    public void setFechaEstado(Date fechaEstado) {
        this.fechaEstado = fechaEstado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Opciones getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Opciones idEstado) {
        this.idEstado = idEstado;
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
        if (!(object instanceof EstadosSocios)) {
            return false;
        }
        EstadosSocios other = (EstadosSocios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.EstadosSocios[ id=" + id + " ]";
    }
    
}
