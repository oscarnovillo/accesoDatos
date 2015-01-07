/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "linea_pedido")
@NamedQueries({
  @NamedQuery(name = "LineaPedido.findAll", query = "SELECT l FROM LineaPedido l"),
  @NamedQuery(name = "LineaPedido.findByIdLineaPedido", query = "SELECT l FROM LineaPedido l WHERE l.idLineaPedido = :idLineaPedido"),
  @NamedQuery(name = "LineaPedido.findByIdPedido", query = "SELECT l FROM LineaPedido l WHERE l.idPedido = :idPedido"),
  @NamedQuery(name = "LineaPedido.findByCodigoProducto", query = "SELECT l FROM LineaPedido l WHERE l.codigoProducto = :codigoProducto"),
  @NamedQuery(name = "LineaPedido.findByCantidad", query = "SELECT l FROM LineaPedido l WHERE l.cantidad = :cantidad"),
  @NamedQuery(name = "LineaPedido.findByPrecioLinea", query = "SELECT l FROM LineaPedido l WHERE l.precioLinea = :precioLinea")})
public class LineaPedido implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID_LINEA_PEDIDO")
  private Integer idLineaPedido;
  @Basic(optional = false)
  @Column(name = "ID_PEDIDO")
  private int idPedido;
  @Basic(optional = false)
  @Column(name = "CODIGO_PRODUCTO")
  private String codigoProducto;
  @Basic(optional = false)
  @Column(name = "CANTIDAD")
  private int cantidad;
  @Basic(optional = false)
  @Column(name = "PRECIO_LINEA")
  private long precioLinea;

  public LineaPedido() {
  }

  public LineaPedido(Integer idLineaPedido) {
    this.idLineaPedido = idLineaPedido;
  }

  public LineaPedido(Integer idLineaPedido, int idPedido, String codigoProducto, int cantidad, long precioLinea) {
    this.idLineaPedido = idLineaPedido;
    this.idPedido = idPedido;
    this.codigoProducto = codigoProducto;
    this.cantidad = cantidad;
    this.precioLinea = precioLinea;
  }

  public Integer getIdLineaPedido() {
    return idLineaPedido;
  }

  public void setIdLineaPedido(Integer idLineaPedido) {
    this.idLineaPedido = idLineaPedido;
  }

  public int getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(int idPedido) {
    this.idPedido = idPedido;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }

  public long getPrecioLinea() {
    return precioLinea;
  }

  public void setPrecioLinea(long precioLinea) {
    this.precioLinea = precioLinea;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idLineaPedido != null ? idLineaPedido.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LineaPedido)) {
      return false;
    }
    LineaPedido other = (LineaPedido) object;
    if ((this.idLineaPedido == null && other.idLineaPedido != null) || (this.idLineaPedido != null && !this.idLineaPedido.equals(other.idLineaPedido))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.LineaPedido[ idLineaPedido=" + idLineaPedido + " ]";
  }
  
}
