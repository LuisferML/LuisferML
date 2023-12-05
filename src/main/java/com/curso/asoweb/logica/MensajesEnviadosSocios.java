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

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "mensajes_enviados_socios")
@NamedQueries({
    @NamedQuery(name = "MensajesEnviadosSocios.findAll", query = "SELECT m FROM MensajesEnviadosSocios m"),
    @NamedQuery(name = "MensajesEnviadosSocios.findById", query = "SELECT m FROM MensajesEnviadosSocios m WHERE m.id = :id"),
    @NamedQuery(name = "MensajesEnviadosSocios.findByFechaCreacion", query = "SELECT m FROM MensajesEnviadosSocios m WHERE m.fechaCreacion = :fechaCreacion")})
public class MensajesEnviadosSocios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_mensaje", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Opciones idMensaje;
    @JoinColumn(name = "id_socio_destino", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Socios idSocioDestino;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;

    public MensajesEnviadosSocios() {
    }

    public MensajesEnviadosSocios(Integer id) {
        this.id = id;
    }

    public MensajesEnviadosSocios(Integer id, Date fechaCreacion) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Opciones getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Opciones idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Socios getIdSocioDestino() {
        return idSocioDestino;
    }

    public void setIdSocioDestino(Socios idSocioDestino) {
        this.idSocioDestino = idSocioDestino;
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
        if (!(object instanceof MensajesEnviadosSocios)) {
            return false;
        }
        MensajesEnviadosSocios other = (MensajesEnviadosSocios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.MensajesEnviadosSocios[ id=" + id + " ]";
    }
    
}
