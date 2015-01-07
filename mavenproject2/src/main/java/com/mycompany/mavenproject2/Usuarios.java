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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "usuarios")
@NamedQueries({
  @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
  @NamedQuery(name = "Usuarios.findByLogin", query = "SELECT u FROM Usuarios u WHERE u.login = :login"),
  @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")})
public class Usuarios implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "LOGIN")
  private String login;
  @Basic(optional = false)
  @Column(name = "PASSWORD")
  private String password;
  @JoinColumn(name = "TIPO_USUARIO", referencedColumnName = "ID_TIPO_USUARIO")
  @ManyToOne(optional = false)
  private TiposUsuarios tipoUsuario;

  public Usuarios() {
  }

  public Usuarios(String login) {
    this.login = login;
  }

  public Usuarios(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public TiposUsuarios getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(TiposUsuarios tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
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
    if (!(object instanceof Usuarios)) {
      return false;
    }
    Usuarios other = (Usuarios) object;
    if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.mavenproject2.Usuarios[ login=" + login + " ]";
  }
  
}
