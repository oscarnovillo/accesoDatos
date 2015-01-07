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
@Table(name = "comisiones_totales")
@NamedQueries({
  @NamedQuery(name = "ComisionesTotales.findAll", query = "SELECT c FROM ComisionesTotales c"),
  @NamedQuery(name = "ComisionesTotales.findByLogin", query = "SELECT c FROM ComisionesTotales c WHERE c.login = :login"),
  @NamedQuery(name = "ComisionesTotales.findByComisiones", query = "SELECT c FROM ComisionesTotales c WHERE c.comisiones = :comisiones"),
  @NamedQuery(name = "ComisionesTotales.findByFechaComprobacion", query = "SELECT c FROM ComisionesTotales c WHERE c.fechaComprobacion = :fechaComprobacion")})
public class ComisionesTotales implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "LOGIN")
  private String login;
  @Basic(optional = false)
  @Column(name = "COMISIONES")
  private long comisiones;
  @Column(name = "FECHA_COMPROBACION")
  @Temporal(TemporalType.TIMESTAMP)
  private Date fechaComprobacion;

  public ComisionesTotales() {
  }

  public ComisionesTotales(String login) {
    this.login = login;
  }

  public ComisionesTotales(String login, long comisiones) {
    this.login = login;
    this.comisiones = comisiones;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public long getComisiones() {
    return comisiones;
  }

  public void setComisiones(long comisiones) {
    this.comisiones = comisiones;
  }

  public Date getFechaComprobacion() {
    return fechaComprobacion;
  }

  public void setFechaComprobacion(Date fechaComprobacion) {
    this.fechaComprobacion = fechaComprobacion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (login != null ? login.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ComisionesTotales)) {
      return false;
    }
    ComisionesTotales other = (ComisionesTotales) object;
    if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.ComisionesTotales[ login=" + login + " ]";
  }
  
}
