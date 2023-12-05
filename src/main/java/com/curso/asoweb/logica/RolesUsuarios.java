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
import java.io.Serializable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "roles_usuarios")
@NamedQueries({
    @NamedQuery(name = "RolesUsuarios.findAll", query = "SELECT r FROM RolesUsuarios r"),
    @NamedQuery(name = "RolesUsuarios.findByRolesUsuarioId", query = "SELECT r FROM RolesUsuarios r WHERE r.rolesUsuarioId = :rolesUsuarioId"),
    @NamedQuery(name = "RolesUsuarios.findByRolAdmin", query = "SELECT r FROM RolesUsuarios r WHERE r.rolAdmin = :rolAdmin"),
    @NamedQuery(name = "RolesUsuarios.findByRolBaja", query = "SELECT r FROM RolesUsuarios r WHERE r.rolBaja = :rolBaja"),
    @NamedQuery(name = "RolesUsuarios.findByRolCrearsocio", query = "SELECT r FROM RolesUsuarios r WHERE r.rolCrearsocio = :rolCrearsocio")})
public class RolesUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roles_usuario_id")
    private Integer rolesUsuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_admin")
    private boolean rolAdmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_baja")
    private boolean rolBaja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rol_crearsocio")
    private boolean rolCrearsocio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public RolesUsuarios() {
    }

    public RolesUsuarios(Integer rolesUsuarioId) {
        this.rolesUsuarioId = rolesUsuarioId;
    }

    public RolesUsuarios(Integer rolesUsuarioId, boolean rolAdmin, boolean rolBaja, boolean rolCrearsocio) {
        this.rolesUsuarioId = rolesUsuarioId;
        this.rolAdmin = rolAdmin;
        this.rolBaja = rolBaja;
        this.rolCrearsocio = rolCrearsocio;
    }
    public RolesUsuarios(Usuarios idUsuario, boolean rolAdmin) {
        this.idUsuario=idUsuario;
        this.rolAdmin = rolAdmin;
        
    }

    public Integer getRolesUsuarioId() {
        return rolesUsuarioId;
    }

    public void setRolesUsuarioId(Integer rolesUsuarioId) {
        this.rolesUsuarioId = rolesUsuarioId;
    }

    public boolean getRolAdmin() {
        return rolAdmin;
    }

    public void setRolAdmin(boolean rolAdmin) {
        this.rolAdmin = rolAdmin;
    }

    public boolean getRolBaja() {
        return rolBaja;
    }

    public void setRolBaja(boolean rolBaja) {
        this.rolBaja = rolBaja;
    }

    public boolean getRolCrearsocio() {
        return rolCrearsocio;
    }

    public void setRolCrearsocio(boolean rolCrearsocio) {
        this.rolCrearsocio = rolCrearsocio;
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
        hash += (rolesUsuarioId != null ? rolesUsuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolesUsuarios)) {
            return false;
        }
        RolesUsuarios other = (RolesUsuarios) object;
        if ((this.rolesUsuarioId == null && other.rolesUsuarioId != null) || (this.rolesUsuarioId != null && !this.rolesUsuarioId.equals(other.rolesUsuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.RolesUsuarios[ rolesUsuarioId=" + rolesUsuarioId + " ]";
    }
    
}
