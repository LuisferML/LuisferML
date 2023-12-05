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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import javax.validation.constraints.Size;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "tipos_movimiento")
@NamedQueries({
    @NamedQuery(name = "TiposMovimiento.findAll", query = "SELECT t FROM TiposMovimiento t"),
    @NamedQuery(name = "TiposMovimiento.findById", query = "SELECT t FROM TiposMovimiento t WHERE t.id = :id"),
    @NamedQuery(name = "TiposMovimiento.findByCodigo", query = "SELECT t FROM TiposMovimiento t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "TiposMovimiento.findByDescripcion", query = "SELECT t FROM TiposMovimiento t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TiposMovimiento.findByEstado", query = "SELECT t FROM TiposMovimiento t WHERE t.estado = :estado"),
    @NamedQuery(name = "TiposMovimiento.findByTipoDebCred", query = "SELECT t FROM TiposMovimiento t WHERE t.tipoDebCred = :tipoDebCred")})
public class TiposMovimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "codigo")
    private String codigo;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 255)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "tipo_deb_cred")
    private String tipoDebCred;
    @OneToMany(mappedBy = "idTipoMovimiento")
    private Collection<MovimientosSocios> movimientosSociosCollection;

    public TiposMovimiento() {
    }

    public TiposMovimiento(Integer id) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoDebCred() {
        return tipoDebCred;
    }

    public void setTipoDebCred(String tipoDebCred) {
        this.tipoDebCred = tipoDebCred;
    }

    public Collection<MovimientosSocios> getMovimientosSociosCollection() {
        return movimientosSociosCollection;
    }

    public void setMovimientosSociosCollection(Collection<MovimientosSocios> movimientosSociosCollection) {
        this.movimientosSociosCollection = movimientosSociosCollection;
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
        if (!(object instanceof TiposMovimiento)) {
            return false;
        }
        TiposMovimiento other = (TiposMovimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.TiposMovimiento[ id=" + id + " ]";
    }
    
}
