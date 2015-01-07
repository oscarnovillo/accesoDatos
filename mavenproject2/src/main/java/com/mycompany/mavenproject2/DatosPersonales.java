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
@Table(name = "datos_personales")
@NamedQueries({
  @NamedQuery(name = "DatosPersonales.findAll", query = "SELECT d FROM DatosPersonales d"),
  @NamedQuery(name = "DatosPersonales.findByLogin", query = "SELECT d FROM DatosPersonales d WHERE d.login = :login"),
  @NamedQuery(name = "DatosPersonales.findByNombre", query = "SELECT d FROM DatosPersonales d WHERE d.nombre = :nombre"),
  @NamedQuery(name = "DatosPersonales.findByApellidos", query = "SELECT d FROM DatosPersonales d WHERE d.apellidos = :apellidos"),
  @NamedQuery(name = "DatosPersonales.findByEmail", query = "SELECT d FROM DatosPersonales d WHERE d.email = :email")})
public class DatosPersonales implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "LOGIN")
  private String login;
  @Column(name = "NOMBRE")
  private String nombre;
  @Column(name = "APELLIDOS")
  private String apellidos;
  @Column(name = "EMAIL")
  private String email;

  public DatosPersonales() {
  }

  public DatosPersonales(String login) {
    this.login = login;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
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

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (login != null ? login.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof DatosPersonales)) {
      return false;
    }
    DatosPersonales other = (DatosPersonales) object;
    if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.mavenproject2.DatosPersonales[ login=" + login + " ]";
  }
  
}
