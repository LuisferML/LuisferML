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
import java.util.Collection;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "exposiciones")
@NamedQueries({
    @NamedQuery(name = "Exposiciones.findAll", query = "SELECT e FROM Exposiciones e"),
    @NamedQuery(name = "Exposiciones.findById", query = "SELECT e FROM Exposiciones e WHERE e.id = :id"),
    @NamedQuery(name = "Exposiciones.findByNombre", query = "SELECT e FROM Exposiciones e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Exposiciones.findByDescripcion", query = "SELECT e FROM Exposiciones e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Exposiciones.findByOrganiza", query = "SELECT e FROM Exposiciones e WHERE e.organiza = :organiza"),
    @NamedQuery(name = "Exposiciones.findByUbicacion", query = "SELECT e FROM Exposiciones e WHERE e.ubicacion = :ubicacion"),
    @NamedQuery(name = "Exposiciones.findByFechaExpo", query = "SELECT e FROM Exposiciones e WHERE e.fechaExpo = :fechaExpo"),
    @NamedQuery(name = "Exposiciones.findByContacto", query = "SELECT e FROM Exposiciones e WHERE e.contacto = :contacto"),
    @NamedQuery(name = "Exposiciones.findByFechaCreacion", query = "SELECT e FROM Exposiciones e WHERE e.fechaCreacion = :fechaCreacion")})
public class Exposiciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "organiza")
    private String organiza;
    @Size(max = 200)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_expo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaExpo;
    @Size(max = 200)
    @Column(name = "contacto")
    private String contacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;
    @OneToMany(mappedBy = "idExposicion")
    private Collection<ParticExpoSocios> particExpoSociosCollection;

    public Exposiciones() {
    }

    public Exposiciones(Integer id) {
        this.id = id;
    }

    public Exposiciones(Integer id, String nombre, Date fechaExpo, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaExpo = fechaExpo;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrganiza() {
        return organiza;
    }

    public void setOrganiza(String organiza) {
        this.organiza = organiza;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaExpo() {
        return fechaExpo;
    }

    public void setFechaExpo(Date fechaExpo) {
        this.fechaExpo = fechaExpo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuarios getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Usuarios idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public Collection<ParticExpoSocios> getParticExpoSociosCollection() {
        return particExpoSociosCollection;
    }

    public void setParticExpoSociosCollection(Collection<ParticExpoSocios> particExpoSociosCollection) {
        this.particExpoSociosCollection = particExpoSociosCollection;
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
        if (!(object instanceof Exposiciones)) {
            return false;
        }
        Exposiciones other = (Exposiciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.Exposiciones[ id=" + id + " ]";
    }
    
}
