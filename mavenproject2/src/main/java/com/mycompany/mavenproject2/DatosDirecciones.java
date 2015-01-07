/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "datos_direcciones")
@NamedQueries({
  @NamedQuery(name = "DatosDirecciones.findAll", query = "SELECT d FROM DatosDirecciones d"),
  @NamedQuery(name = "DatosDirecciones.findByLogin", query = "SELECT d FROM DatosDirecciones d WHERE d.login = :login"),
  @NamedQuery(name = "DatosDirecciones.findByCalle", query = "SELECT d FROM DatosDirecciones d WHERE d.calle = :calle"),
  @NamedQuery(name = "DatosDirecciones.findByPortal", query = "SELECT d FROM DatosDirecciones d WHERE d.portal = :portal"),
  @NamedQuery(name = "DatosDirecciones.findByCodigoPostal", query = "SELECT d FROM DatosDirecciones d WHERE d.codigoPostal = :codigoPostal"),
  @NamedQuery(name = "DatosDirecciones.findByPiso", query = "SELECT d FROM DatosDirecciones d WHERE d.piso = :piso"),
  @NamedQuery(name = "DatosDirecciones.findByPuerta", query = "SELECT d FROM DatosDirecciones d WHERE d.puerta = :puerta")})
public class DatosDirecciones implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "LOGIN")
  private String login;
  @Column(name = "CALLE")
  private String calle;
  @Column(name = "PORTAL")
  private String portal;
  @Column(name = "CODIGO_POSTAL")
  private String codigoPostal;
  @Column(name = "PISO")
  private String piso;
  @Column(name = "PUERTA")
  private String puerta;

  public DatosDirecciones() {
  }

  public DatosDirecciones(String login) {
    this.login = login;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getCalle() {
    return calle;
  }

  public void setCalle(String calle) {
    this.calle = calle;
  }

  public String getPortal() {
    return portal;
  }

  public void setPortal(String portal) {
    this.portal = portal;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getPiso() {
    return piso;
  }

  public void setPiso(String piso) {
    this.piso = piso;
  }

  public String getPuerta() {
    return puerta;
  }

  public void setPuerta(String puerta) {
    this.puerta = puerta;
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
    if (!(object instanceof DatosDirecciones)) {
      return false;
    }
    DatosDirecciones other = (DatosDirecciones) object;
    if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.mavenproject2.DatosDirecciones[ login=" + login + " ]";
  }
  
}
