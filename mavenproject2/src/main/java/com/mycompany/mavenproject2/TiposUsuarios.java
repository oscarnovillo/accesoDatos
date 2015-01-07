/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "tipos_usuarios")
@NamedQueries({
  @NamedQuery(name = "TiposUsuarios.findAll", query = "SELECT t FROM TiposUsuarios t"),
  @NamedQuery(name = "TiposUsuarios.findByIdTipoUsuario", query = "SELECT t FROM TiposUsuarios t WHERE t.idTipoUsuario = :idTipoUsuario"),
  @NamedQuery(name = "TiposUsuarios.findByDescripcion", query = "SELECT t FROM TiposUsuarios t WHERE t.descripcion = :descripcion")})
public class TiposUsuarios implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "ID_TIPO_USUARIO")
  private Integer idTipoUsuario;
  @Basic(optional = false)
  @Column(name = "DESCRIPCION")
  private String descripcion;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
  private List<Usuarios> usuariosList;

  public TiposUsuarios() {
  }

  public TiposUsuarios(Integer idTipoUsuario) {
    this.idTipoUsuario = idTipoUsuario;
  }

  public TiposUsuarios(Integer idTipoUsuario, String descripcion) {
    this.idTipoUsuario = idTipoUsuario;
    this.descripcion = descripcion;
  }

  public Integer getIdTipoUsuario() {
    return idTipoUsuario;
  }

  public void setIdTipoUsuario(Integer idTipoUsuario) {
    this.idTipoUsuario = idTipoUsuario;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public List<Usuarios> getUsuariosList() {
    return usuariosList;
  }

  public void setUsuariosList(List<Usuarios> usuariosList) {
    this.usuariosList = usuariosList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TiposUsuarios)) {
      return false;
    }
    TiposUsuarios other = (TiposUsuarios) object;
    if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.mycompany.mavenproject2.TiposUsuarios[ idTipoUsuario=" + idTipoUsuario + " ]";
  }
  
}
