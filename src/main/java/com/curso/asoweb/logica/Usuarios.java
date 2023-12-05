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
@Table(name = "usuarios")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email"),
    @NamedQuery(name = "Usuarios.findByClave", query = "SELECT u FROM Usuarios u WHERE u.clave = :clave"),
    @NamedQuery(name = "Usuarios.findByHabilitado", query = "SELECT u FROM Usuarios u WHERE u.habilitado = :habilitado"),
    @NamedQuery(name = "Usuarios.findByCuentaBloqueada", query = "SELECT u FROM Usuarios u WHERE u.cuentaBloqueada = :cuentaBloqueada"),
    @NamedQuery(name = "Usuarios.findByCuentaExpirada", query = "SELECT u FROM Usuarios u WHERE u.cuentaExpirada = :cuentaExpirada"),
    @NamedQuery(name = "Usuarios.findByFechaCreacionUsuario", query = "SELECT u FROM Usuarios u WHERE u.fechaCreacionUsuario = :fechaCreacionUsuario"),
    @NamedQuery(name = "Usuarios.findByCreaSocio", query = "SELECT u FROM Usuarios u WHERE u.creaSocio = :creaSocio")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "usuario")
    private String usuario;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Column(name = "habilitado")
    private boolean habilitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_bloqueada")
    private boolean cuentaBloqueada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_expirada")
    private boolean cuentaExpirada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion_usuario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacionUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "crea_socio")
    private boolean creaSocio;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<CodigoDeSeguridad> codigoDeSeguridadCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion")
    private Collection<Exposiciones> exposicionesCollection;
    @OneToMany(mappedBy = "idUsuarioInactivacion")
    private Collection<MontosCuota> montosCuotaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion")
    private Collection<EstadosSocios> estadosSociosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<RolesUsuarios> rolesUsuariosCollection;
    @JoinColumn(name = "id_socio", referencedColumnName = "id")
    @OneToOne
    private Socios idSocio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion")
    private Collection<Socios> sociosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion")
    private Collection<MensajesEnviadosSocios> mensajesEnviadosSociosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion")
    private Collection<ParticExpoSocios> particExpoSociosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion")
    private Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection;
    @OneToMany(mappedBy = "idUsuarioCreacion")
    private Collection<PagosCuotasSocios> pagosCuotasSociosCollection;
    @OneToMany(mappedBy = "idUsuarioCreacion")
    private Collection<MovimientosSocios> movimientosSociosCollection;
    @OneToMany(mappedBy = "idUsuarioAprobacion")
    private Collection<MovimientosSocios> movimientosSociosCollection1;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String usuario, String email, String clave, boolean habilitado, boolean cuentaBloqueada, boolean cuentaExpirada, Date fechaCreacionUsuario, boolean creaSocio) {
        this.id = id;
        this.usuario = usuario;
        this.email = email;
        this.clave = clave;
        this.habilitado = habilitado;
        this.cuentaBloqueada = cuentaBloqueada;
        this.cuentaExpirada = cuentaExpirada;
        this.fechaCreacionUsuario = fechaCreacionUsuario;
        this.creaSocio = creaSocio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean getCuentaBloqueada() {
        return cuentaBloqueada;
    }

    public void setCuentaBloqueada(boolean cuentaBloqueada) {
        this.cuentaBloqueada = cuentaBloqueada;
    }

    public boolean getCuentaExpirada() {
        return cuentaExpirada;
    }

    public void setCuentaExpirada(boolean cuentaExpirada) {
        this.cuentaExpirada = cuentaExpirada;
    }

    public Date getFechaCreacionUsuario() {
        return fechaCreacionUsuario;
    }

    public void setFechaCreacionUsuario(Date fechaCreacionUsuario) {
        this.fechaCreacionUsuario = fechaCreacionUsuario;
    }

    public boolean getCreaSocio() {
        return creaSocio;
    }

    public void setCreaSocio(boolean creaSocio) {
        this.creaSocio = creaSocio;
    }

    public Collection<CodigoDeSeguridad> getCodigoDeSeguridadCollection() {
        return codigoDeSeguridadCollection;
    }

    public void setCodigoDeSeguridadCollection(Collection<CodigoDeSeguridad> codigoDeSeguridadCollection) {
        this.codigoDeSeguridadCollection = codigoDeSeguridadCollection;
    }

    public Collection<Exposiciones> getExposicionesCollection() {
        return exposicionesCollection;
    }

    public void setExposicionesCollection(Collection<Exposiciones> exposicionesCollection) {
        this.exposicionesCollection = exposicionesCollection;
    }

    public Collection<MontosCuota> getMontosCuotaCollection() {
        return montosCuotaCollection;
    }

    public void setMontosCuotaCollection(Collection<MontosCuota> montosCuotaCollection) {
        this.montosCuotaCollection = montosCuotaCollection;
    }

    public Collection<EstadosSocios> getEstadosSociosCollection() {
        return estadosSociosCollection;
    }

    public void setEstadosSociosCollection(Collection<EstadosSocios> estadosSociosCollection) {
        this.estadosSociosCollection = estadosSociosCollection;
    }

    public Collection<RolesUsuarios> getRolesUsuariosCollection() {
        return rolesUsuariosCollection;
    }

    public void setRolesUsuariosCollection(Collection<RolesUsuarios> rolesUsuariosCollection) {
        this.rolesUsuariosCollection = rolesUsuariosCollection;
    }

    public Socios getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socios idSocio) {
        this.idSocio = idSocio;
    }

    public Collection<Socios> getSociosCollection() {
        return sociosCollection;
    }

    public void setSociosCollection(Collection<Socios> sociosCollection) {
        this.sociosCollection = sociosCollection;
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

    public Collection<TematicaParticExpoSocios> getTematicaParticExpoSociosCollection() {
        return tematicaParticExpoSociosCollection;
    }

    public void setTematicaParticExpoSociosCollection(Collection<TematicaParticExpoSocios> tematicaParticExpoSociosCollection) {
        this.tematicaParticExpoSociosCollection = tematicaParticExpoSociosCollection;
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

    public Collection<MovimientosSocios> getMovimientosSociosCollection1() {
        return movimientosSociosCollection1;
    }

    public void setMovimientosSociosCollection1(Collection<MovimientosSocios> movimientosSociosCollection1) {
        this.movimientosSociosCollection1 = movimientosSociosCollection1;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.Usuarios[ id=" + id + " ]";
    }
    
}
