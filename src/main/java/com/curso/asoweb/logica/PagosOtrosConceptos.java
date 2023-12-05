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
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
 *
 * @author luis_
 */
@Entity
@Table(name = "pagos_otros_conceptos")
@NamedQueries({
    @NamedQuery(name = "PagosOtrosConceptos.findAll", query = "SELECT p FROM PagosOtrosConceptos p"),
    @NamedQuery(name = "PagosOtrosConceptos.findById", query = "SELECT p FROM PagosOtrosConceptos p WHERE p.id = :id"),
    @NamedQuery(name = "PagosOtrosConceptos.findByFechaPago", query = "SELECT p FROM PagosOtrosConceptos p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "PagosOtrosConceptos.findByIdSocio", query = "SELECT p FROM PagosOtrosConceptos p WHERE p.idSocio = :idSocio"),
    @NamedQuery(name = "PagosOtrosConceptos.findByMonto", query = "SELECT p FROM PagosOtrosConceptos p WHERE p.monto = :monto")})
public class PagosOtrosConceptos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "id_socio")
    private BigInteger idSocio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private BigDecimal monto;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id")
    @ManyToOne
    private Opciones idConcepto;
    @JoinColumn(name = "id_estado", referencedColumnName = "id")
    @ManyToOne
    private Opciones idEstado;
    @JoinColumn(name = "id_medio_pago", referencedColumnName = "id")
    @ManyToOne
    private Opciones idMedioPago;

    public PagosOtrosConceptos() {
    }

    public PagosOtrosConceptos(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigInteger getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(BigInteger idSocio) {
        this.idSocio = idSocio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public Opciones getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(Opciones idConcepto) {
        this.idConcepto = idConcepto;
    }

    public Opciones getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Opciones idEstado) {
        this.idEstado = idEstado;
    }

    public Opciones getIdMedioPago() {
        return idMedioPago;
    }

    public void setIdMedioPago(Opciones idMedioPago) {
        this.idMedioPago = idMedioPago;
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
        if (!(object instanceof PagosOtrosConceptos)) {
            return false;
        }
        PagosOtrosConceptos other = (PagosOtrosConceptos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.curso.asoweb.logica.PagosOtrosConceptos[ id=" + id + " ]";
    }
    
}
