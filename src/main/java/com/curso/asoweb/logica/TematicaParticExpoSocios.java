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
@Table(name = "tematica_partic_expo_socios")
@NamedQueries({
    @NamedQuery(name = "TematicaParticExpoSocios.findAll", query = "SELECT t FROM TematicaParticExpoSocios t"),
    @NamedQuery(name = "TematicaParticExpoSocios.findById", query = "SELECT t FROM TematicaParticExpoSocios t WHERE t.id = :id"),
    @NamedQuery(name = "TematicaParticExpoSocios.findByTematicaEspecifica", query = "SELECT t FROM TematicaParticExpoSocios t WHERE t.tematicaEspecifica = :tematicaEspecifica"),
    @NamedQuery(name = "TematicaParticExpoSocios.findByCanceloParticTematica", query = "SELECT t FROM TematicaParticExpoSocios t WHERE t.canceloParticTematica = :canceloParticTematica"),
    @NamedQuery(name = "TematicaParticExpoSocios.findByFechaCancelacion", query = "SELECT t FROM TematicaParticExpoSocios t WHERE t.fechaCancelacion = :fechaCancelacion"),
    @NamedQuery(name = "TematicaParticExpoSocios.findByFechaCreacion", query = "SELECT t FROM TematicaParticExpoSocios t WHERE t.fechaCreacion = :fechaCreacion")})
public class TematicaParticExpoSocios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "tematica_especifica")
    private String tematicaEspecifica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cancelo_partic_tematica")
    private boolean canceloParticTematica;
    @Column(name = "fecha_cancelacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCancelacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @JoinColumn(name = "id_tematica_general", referencedColumnName = "id")
    @ManyToOne
    private Opciones idTematicaGeneral;
    @JoinColumn(name = "id_partic_expo_socios", referencedColumnName = "id")
    @ManyToOne
    private ParticExpoSocios idParticExpoSocios;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;

    public TematicaParticExpoSocios() {
    }

    public TematicaParticExpoSocios(Integer id) {
        this.id = id;
    }

    public TematicaParticExpoSocios(Integer id, boolean canceloParticTematica, Date fechaCreacion) {
        this.id = id;
        this.canceloParticTematica = canceloParticTematica;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTematicaEspecifica() {
        return tematicaEspecifica;
    }

    public void setTematicaEspecifica(String tematicaEspecifica) {
        this.tematicaEspecifica = tematicaEspecifica;
    }

    public boolean getCanceloParticTematica() {
        return canceloParticTematica;
    }

    public void setCanceloParticTematica(boolean canceloParticTematica) {
        this.canceloParticTematica = canceloParticTematica;
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

    public Opciones getIdTematicaGeneral() {
        return idTematicaGeneral;
    }

    public void setIdTematicaGeneral(Opciones idTematicaGeneral) {
        this.idTematicaGeneral = idTematicaGeneral;
    }

    public ParticExpoSocios getIdParticExpoSocios() {
        return idParticExpoSocios;
    }

    public void setIdParticExpoSocios(ParticExpoSocios idParticExpoSocios) {
        this.idParticExpoSocios = idParticExpoSocios;
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
        if (!(object instanceof TematicaParticExpoSocios)) {
            return false;
        }
        TematicaParticExpoSocios other = (TematicaParticExpoSocios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.TematicaParticExpoSocios[ id=" + id + " ]";
    }
    
}
