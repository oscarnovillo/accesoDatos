/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "pedidos")
@NamedQueries({
  @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p"),
  @NamedQuery(name = "Pedidos.findByIdPedido", query = "SELECT p FROM Pedidos p WHERE p.idPedido = :idPedido"),
  @NamedQuery(name = "Pedidos.findByCodigoProducto", query = "SELECT p FROM Pedidos p WHERE p.codigoProducto = :codigoProducto"),
  @NamedQuery(name = "Pedidos.findByUsuario", query = "SELECT p FROM Pedidos p WHERE p.usuario = :usuario"),
  @NamedQuery(name = "Pedidos.findByDistribuidora", query = "SELECT p FROM Pedidos p WHERE p.distribuidora = :distribuidora"),
  @NamedQuery(name = "Pedidos.findByJefaGrupo", query = "SELECT p FROM Pedidos p WHERE p.jefaGrupo = :jefaGrupo"),
  @NamedQuery(name = "Pedidos.findByPrecioTotal", query = "SELECT p FROM Pedidos p WHERE p.precioTotal = :precioTotal"),
  @NamedQuery(name = "Pedidos.findByFechaCompra", query = "SELECT p FROM Pedidos p WHERE p.fechaCompra = :fechaCompra"),
  @NamedQuery(name = "Pedidos.findByFechaEnvio", query = "SELECT p FROM Pedidos p WHERE p.fechaEnvio = :fechaEnvio")})
public class Pedidos implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID_PEDIDO")
  private Integer idPedido;
  @Basic(optional = false)
  @Column(name = "CODIGO_PRODUCTO")
  private String codigoProducto;
  @Basic(optional = false)
  @Column(name = "USUARIO")
  private String usuario;
  @Basic(optional = false)
  @Column(name = "DISTRIBUIDORA")
  private String distribuidora;
  @Basic(optional = false)
  @Column(name = "JEFA_GRUPO")
  private String jefaGrupo;
  @Basic(optional = false)
  @Column(name = "PRECIO_TOTAL")
  private long precioTotal;
  @Basic(optional = false)
  @Column(name = "FECHA_COMPRA")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaCompra;
  @Basic(optional = false)
  @Column(name = "FECHA_ENVIO")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaEnvio;

  public Pedidos() {
  }

  public Pedidos(Integer idPedido) {
    this.idPedido = idPedido;
  }

  public Pedidos(Integer idPedido, String codigoProducto, String usuario, String distribuidora, String jefaGrupo, long precioTotal, Date fechaCompra, Date fechaEnvio) {
    this.idPedido = idPedido;
    this.codigoProducto = codigoProducto;
    this.usuario = usuario;
    this.distribuidora = distribuidora;
    this.jefaGrupo = jefaGrupo;
    this.precioTotal = precioTotal;
    this.fechaCompra = fechaCompra;
    this.fechaEnvio = fechaEnvio;
  }

  public Integer getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(Integer idPedido) {
    this.idPedido = idPedido;
  }

  public String getCodigoProducto() {
    return codigoProducto;
  }

  public void setCodigoProducto(String codigoProducto) {
    this.codigoProducto = codigoProducto;
  }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getDistribuidora() {
    return distribuidora;
  }

  public void setDistribuidora(String distribuidora) {
    this.distribuidora = distribuidora;
  }

  public String getJefaGrupo() {
    return jefaGrupo;
  }

  public void setJefaGrupo(String jefaGrupo) {
    this.jefaGrupo = jefaGrupo;
  }

  public long getPrecioTotal() {
    return precioTotal;
  }

  public void setPrecioTotal(long precioTotal) {
    this.precioTotal = precioTotal;
  }

  public Date getFechaCompra() {
    return fechaCompra;
  }

  public void setFechaCompra(Date fechaCompra) {
    this.fechaCompra = fechaCompra;
  }

  public Date getFechaEnvio() {
    return fechaEnvio;
  }

  public void setFechaEnvio(Date fechaEnvio) {
    this.fechaEnvio = fechaEnvio;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPedido != null ? idPedido.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pedidos)) {
      return false;
    }
    Pedidos other = (Pedidos) object;
    if ((this.idPedido == null && other.idPedido != null) || (this.idPedido != null && !this.idPedido.equals(other.idPedido))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.mavenproject2.Pedidos[ idPedido=" + idPedido + " ]";
  }
  
}
