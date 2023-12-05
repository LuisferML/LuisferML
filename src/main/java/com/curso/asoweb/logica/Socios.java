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
import javax.persistence.OneToOne;
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
@Table(name = "socios")
@NamedQueries({
    @NamedQuery(name = "Socios.findAll", query = "SELECT s FROM Socios s"),
    @NamedQuery(name = "Socios.findById", query = "SELECT s FROM Socios s WHERE s.id = :id"),
    @NamedQuery(name = "Socios.findByNombres", query = "SELECT s FROM Socios s WHERE s.nombres = :nombres"),
    @NamedQuery(name = "Socios.findByApellidos", query = "SELECT s FROM Socios s WHERE s.apellidos = :apellidos"),
    @NamedQuery(name = "Socios.findByEmail", query = "SELECT s FROM Socios s WHERE s.email = :email"),
    @NamedQuery(name = "Socios.findByNroSocio", query = "SELECT s FROM Socios s WHERE s.nroSocio = :nroSocio"),
    @NamedQuery(name = "Socios.findByNroCedula", query = "SELECT s FROM Socios s WHERE s.nroCedula = :nroCedula"),
    @NamedQuery(name = "Socios.findByFechaIngreso", query = "SELECT s FROM Socios s WHERE s.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Socios.findByFechaEstadoActual", query = "SELECT s FROM Socios s WHERE s.fechaEstadoActual = :fechaEstadoActual"),
    @NamedQuery(name = "Socios.findByFundador", query = "SELECT s FROM Socios s WHERE s.fundador = :fundador"),
    @NamedQuery(name = "Socios.findByFechaCreacion", query = "SELECT s FROM Socios s WHERE s.fechaCreacion = :fechaCreacion")})
public class Socios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Size(max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 200)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_socio")
    private int nroSocio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_cedula")
    private long nroCedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_estado_actual")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEstadoActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fundador")
    private boolean fundador;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSocio")
    private Collection<EstadosSocios> estadosSociosCollection;
    @OneToOne(mappedBy = "idSocio")
    private Usuarios usuarios;
    @JoinColumn(name = "id_estado_actual", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Opciones idEstadoActual;
    @JoinColumn(name = "id_tipo_socio", referencedColumnName = "id")
    @ManyToOne
    private Opciones idTipoSocio;
    @OneToMany(mappedBy = "idSocioProponente")
    private Collection<Socios> sociosCollection;
    @JoinColumn(name = "id_socio_proponente", referencedColumnName = "id")
    @ManyToOne
    private Socios idSocioProponente;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarioCreacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSocioDestino")
    private Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollection;
    @OneToMany(mappedBy = "idSocio")
    private Collection<ParticExpoSocios> particExpoSociosCollection;
    @OneToMany(mappedBy = "idSocio")
    private Collection<PagosCuotasSocios> pagosCuotasSociosCollection;
    @OneToMany(mappedBy = "idSocio")
    private Collection<MovimientosSocios> movimientosSociosCollection;

    public Socios() {
    }

    public Socios(Integer id) {
        this.id = id;
    }

    public Socios(Integer id, String nombres, int nroSocio, long nroCedula, Date fechaIngreso, Date fechaEstadoActual, boolean fundador, Date fechaCreacion) {
        this.id = id;
        this.nombres = nombres;
        this.nroSocio = nroSocio;
        this.nroCedula = nroCedula;
        this.fechaIngreso = fechaIngreso;
        this.fechaEstadoActual = fechaEstadoActual;
        this.fundador = fundador;
        this.fechaCreacion = fechaCreacion;
    }
    public Socios(Integer id, String nombres,String apellidos,String email, int nroSocio, long nroCedula, Date fechaIngreso,Opciones idEstadoActual,  boolean fundador, 
              Usuarios idUsuarioCreacion,Date fechaCreacion, Date fechaEstadoActual) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos= apellidos;
        this.email=email;
        this.nroSocio = nroSocio;
        this.nroCedula = nroCedula;
        this.fechaIngreso = fechaIngreso;
        this.idEstadoActual=idEstadoActual;
        this.fundador = fundador;
        this.idUsuarioCreacion=idUsuarioCreacion;
        this.fechaCreacion=fechaCreacion;
        this.fechaEstadoActual=fechaEstadoActual;
        
      
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public long getNroCedula() {
        return nroCedula;
    }

    public void setNroCedula(long nroCedula) {
        this.nroCedula = nroCedula;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaEstadoActual() {
        return fechaEstadoActual;
    }

    public void setFechaEstadoActual(Date fechaEstadoActual) {
        this.fechaEstadoActual = fechaEstadoActual;
    }

    public boolean getFundador() {
        return fundador;
    }

    public void setFundador(boolean fundador) {
        this.fundador = fundador;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Collection<EstadosSocios> getEstadosSociosCollection() {
        return estadosSociosCollection;
    }

    public void setEstadosSociosCollection(Collection<EstadosSocios> estadosSociosCollection) {
        this.estadosSociosCollection = estadosSociosCollection;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Opciones getIdEstadoActual() {
        return idEstadoActual;
    }

    public void setIdEstadoActual(Opciones idEstadoActual) {
        this.idEstadoActual = idEstadoActual;
    }

    public Opciones getIdTipoSocio() {
        return idTipoSocio;
    }

    public void setIdTipoSocio(Opciones idTipoSocio) {
        this.idTipoSocio = idTipoSocio;
    }

    public Collection<Socios> getSociosCollection() {
        return sociosCollection;
    }

    public void setSociosCollection(Collection<Socios> sociosCollection) {
        this.sociosCollection = sociosCollection;
    }

    public Socios getIdSocioProponente() {
        return idSocioProponente;
    }

    public void setIdSocioProponente(Socios idSocioProponente) {
        this.idSocioProponente = idSocioProponente;
    }

    public Usuarios getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Usuarios idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public Collection<MensajesEnviadosSocios> getMensajesEnviadosSociosCollection() {
        return mensajesEnviadosSociosCollection;
    }

    public void setMensajesEnviadosSociosCollection(Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollection) {
        this.mensajesEnviadosSociosCollection = mensajesEnviadosSociosCollection;
    }

    public Collection<ParticExpoSocios> getParticExpoSociosCollection() {
        return particExpoSociosCollection;
    }

    public void setParticExpoSociosCollection(Collection<ParticExpoSocios> particExpoSociosCollection) {
        this.particExpoSociosCollection = particExpoSociosCollection;
    }

    public Collection<PagosCuotasSocios> getPagosCuotasSociosCollection() {
        return pagosCuotasSociosCollection;
    }

    public void setPagosCuotasSociosCollection(Collection<PagosCuotasSocios> pagosCuotasSociosCollection) {
        this.pagosCuotasSociosCollection = pagosCuotasSociosCollection;
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
        if (!(object instanceof Socios)) {
            return false;
        }
        Socios other = (Socios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.Socios[ id=" + id + " ]";
    }
    
}
