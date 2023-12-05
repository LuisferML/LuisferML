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
import java.io.Serializable;
import java.util.Collection;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "menus")
@NamedQueries({
    @NamedQuery(name = "Menus.findAll", query = "SELECT m FROM Menus m"),
    @NamedQuery(name = "Menus.findById", query = "SELECT m FROM Menus m WHERE m.id = :id"),
    @NamedQuery(name = "Menus.findByNombre", query = "SELECT m FROM Menus m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Menus.findByTipoMenu", query = "SELECT m FROM Menus m WHERE m.tipoMenu = :tipoMenu"),
    @NamedQuery(name = "Menus.findByTipoUsuario", query = "SELECT m FROM Menus m WHERE m.tipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "Menus.findByEstado", query = "SELECT m FROM Menus m WHERE m.estado = :estado"),
    @NamedQuery(name = "Menus.findByVista", query = "SELECT m FROM Menus m WHERE m.vista = :vista"),
    @NamedQuery(name = "Menus.findByColumnaMenu", query = "SELECT m FROM Menus m WHERE m.columnaMenu = :columnaMenu"),
    @NamedQuery(name = "Menus.findByIcono", query = "SELECT m FROM Menus m WHERE m.icono = :icono")})
public class Menus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_menu")
    private String tipoMenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_usuario")
    private String tipoUsuario;
    @Column(name = "estado")
    private Character estado;
    @Size(max = 300)
    @Column(name = "vista")
    private String vista;
    @Size(max = 50)
    @Column(name = "columna_menu")
    private String columnaMenu;
    @Size(max = 100)
    @Column(name = "icono")
    private String icono;
    @OneToMany(mappedBy = "idSubMenu")
    private Collection<Menus> menusCollection;
    @JoinColumn(name = "id_sub_menu", referencedColumnName = "id")
    @ManyToOne
    private Menus idSubMenu;

    public Menus() {
    }

    public Menus(Integer id) {
        this.id = id;
    }

    public Menus(Integer id, String nombre, String tipoMenu, String tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMenu = tipoMenu;
        this.tipoUsuario = tipoUsuario;
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

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getVista() {
        return vista;
    }

    public void setVista(String vista) {
        this.vista = vista;
    }

    public String getColumnaMenu() {
        return columnaMenu;
    }

    public void setColumnaMenu(String columnaMenu) {
        this.columnaMenu = columnaMenu;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public Collection<Menus> getMenusCollection() {
        return menusCollection;
    }

    public void setMenusCollection(Collection<Menus> menusCollection) {
        this.menusCollection = menusCollection;
    }

    public Menus getIdSubMenu() {
        return idSubMenu;
    }

    public void setIdSubMenu(Menus idSubMenu) {
        this.idSubMenu = idSubMenu;
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
        if (!(object instanceof Menus)) {
            return false;
        }
        Menus other = (Menus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.Menus[ id=" + id + " ]";
    }
    
}
