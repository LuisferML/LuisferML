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

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "partic_expo_socios")
@NamedQueries({
    @NamedQuery(name = "ParticExpoSocios.findAll", query = "SELECT p FROM ParticExpoSocios p"),
    @NamedQuery(name = "ParticExpoSocios.findById", query = "SELECT p FROM ParticExpoSocios p WHERE p.id = :id"),
    @NamedQuery(name = "ParticExpoSocios.findByCanceloParticipacion", query = "SELECT p FROM ParticExpoSocios p WHERE p.canceloParticipacion = :canceloParticipacion"),
    @NamedQuery(name = "ParticExpoSocios.findByFechaCancelacion", query = "SELECT p FROM ParticExpoSocios p WHERE p.fechaCancelacion = :fechaCancelacion"),
    @NamedQuery(name = "ParticExpoSocios.findByFechaCreacion", query = "SELECT p FROM ParticExpoSocios p WHERE p.fechaCreacion = :fechaCreacion")})
public class ParticExpoSocios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancelo_participacion")
    private boolean canceloParticipacion;
    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_exposicion", referencedColumnName = "id")
    @ManyToOne
    private Exposiciones idExposicion;
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    @ManyToOne
    private Socios idSocio;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;
    @OneToMany(mappedBy = "idParticExpoSocios")
    private Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection;

    public ParticExpoSocios() {
    }

    public ParticExpoSocios(Integer id) {
        this.id = id;
    }

    public ParticExpoSocios(Integer id, boolean canceloParticipacion, Date fechaCreacion) {
        this.id = id;
        this.canceloParticipacion = canceloParticipacion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getCanceloParticipacion() {
        return canceloParticipacion;
    }

    public void setCanceloParticipacion(boolean canceloParticipacion) {
        this.canceloParticipacion = canceloParticipacion;
    }

    public Date getFechaCancelacion() {
        return fechaCancelacion;
    }

    public void setFechaCancelacion(Date fechaCancelacion) {
        this.fechaCancelacion = fechaCancelacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Exposiciones getIdExposicion() {
        return idExposicion;
    }

    public void setIdExposicion(Exposiciones idExposicion) {
        this.idExposicion = idExposicion;
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

    public Collection<TematicaParticExpoSocios> getTematicaParticExpoSociosCollection() {
        return tematicaParticExpoSociosCollection;
    }

    public void setTematicaParticExpoSociosCollection(Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection) {
        this.tematicaParticExpoSociosCollection = tematicaParticExpoSociosCollection;
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
        if (!(object instanceof ParticExpoSocios)) {
            return false;
        }
        ParticExpoSocios other = (ParticExpoSocios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.ParticExpoSocios[ id=" + id + " ]";
    }
    
}
