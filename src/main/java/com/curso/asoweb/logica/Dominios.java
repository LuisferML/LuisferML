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
@Table(name = "dominios")
@NamedQueries({
    @NamedQuery(name = "Dominios.findAll", query = "SELECT d FROM Dominios d"),
    @NamedQuery(name = "Dominios.findById", query = "SELECT d FROM Dominios d WHERE d.id = :id"),
    @NamedQuery(name = "Dominios.findByCodigo", query = "SELECT d FROM Dominios d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Dominios.findByDescripcion", query = "SELECT d FROM Dominios d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Dominios.findByEstado", query = "SELECT d FROM Dominios d WHERE d.estado = :estado")})
public class Dominios implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @OneToMany(mappedBy = "idDominioPadre")
    private Collection<Dominios> dominiosCollection;
    @JoinColumn(name = "id_dominio_padre", referencedColumnName = "id")
    @ManyToOne
    private Dominios idDominioPadre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDominio")
    private Collection<Opciones> opcionesCollection;

    public Dominios() {
    }

    public Dominios(Integer id) {
        this.id = id;
    }

    public Dominios(Integer id, String codigo, String descripcion, Character estado) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
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

    public Collection<Dominios> getDominiosCollection() {
        return dominiosCollection;
    }

    public void setDominiosCollection(Collection<Dominios> dominiosCollection) {
        this.dominiosCollection = dominiosCollection;
    }

    public Dominios getIdDominioPadre() {
        return idDominioPadre;
    }

    public void setIdDominioPadre(Dominios idDominioPadre) {
        this.idDominioPadre = idDominioPadre;
    }

    public Collection<Opciones> getOpcionesCollection() {
        return opcionesCollection;
    }

    public void setOpcionesCollection(Collection<Opciones> opcionesCollection) {
        this.opcionesCollection = opcionesCollection;
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
        if (!(object instanceof Dominios)) {
            return false;
        }
        Dominios other = (Dominios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.Dominios[ id=" + id + " ]";
    }
    
}
