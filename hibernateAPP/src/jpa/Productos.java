/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "productos")
@NamedQueries({
  @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
  @NamedQuery(name = "Productos.findByCodigo", query = "SELECT p FROM Productos p WHERE p.codigo = :codigo"),
  @NamedQuery(name = "Productos.findByNombre", query = "SELECT p FROM Productos p WHERE p.nombre = :nombre"),
  @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio"),
  @NamedQuery(name = "Productos.findByFechaFin", query = "SELECT p FROM Productos p WHERE p.fechaFin = :fechaFin")})
public class Productos implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "CODIGO")
  private String codigo;
  @Basic(optional = false)
  @Column(name = "NOMBRE")
  private String nombre;
  @Basic(optional = false)
  @Column(name = "PRECIO")
  private double precio;
  @Column(name = "FECHA_FIN")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaFin;

  public Productos() {
  }

  public Productos(String codigo) {
    this.codigo = codigo;
  }

  public Productos(String codigo, String nombre, double precio) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.precio = precio;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codigo != null ? codigo.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Productos)) {
      return false;
    }
    Productos other = (Productos) object;
    if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.Productos[ codigo=" + codigo + " ]";
  }
  
}
