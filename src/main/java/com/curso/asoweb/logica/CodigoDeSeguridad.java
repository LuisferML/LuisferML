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
import javax.validation.constraints.Size;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "codigo_de_seguridad")
@NamedQueries({
    @NamedQuery(name = "CodigoDeSeguridad.findAll", query = "SELECT c FROM CodigoDeSeguridad c"),
    @NamedQuery(name = "CodigoDeSeguridad.findById", query = "SELECT c FROM CodigoDeSeguridad c WHERE c.id = :id"),
    @NamedQuery(name = "CodigoDeSeguridad.findByCodigo", query = "SELECT c FROM CodigoDeSeguridad c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CodigoDeSeguridad.findByHoraPeticion", query = "SELECT c FROM CodigoDeSeguridad c WHERE c.horaPeticion = :horaPeticion"),
    @NamedQuery(name = "CodigoDeSeguridad.findByTipoActivacion", query = "SELECT c FROM CodigoDeSeguridad c WHERE c.tipoActivacion = :tipoActivacion")})
public class CodigoDeSeguridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "hora_peticion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaPeticion;
    @Column(name = "tipo_activacion")
    private Integer tipoActivacion;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuario;

    public CodigoDeSeguridad() {
    }

    public CodigoDeSeguridad(Integer id) {
        this.id = id;
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

    public Date getHoraPeticion() {
        return horaPeticion;
    }

    public void setHoraPeticion(Date horaPeticion) {
        this.horaPeticion = horaPeticion;
    }

    public Integer getTipoActivacion() {
        return tipoActivacion;
    }

    public void setTipoActivacion(Integer tipoActivacion) {
        this.tipoActivacion = tipoActivacion;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof CodigoDeSeguridad)) {
            return false;
        }
        CodigoDeSeguridad other = (CodigoDeSeguridad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.CodigoDeSeguridad[ id=" + id + " ]";
    }
    
}
