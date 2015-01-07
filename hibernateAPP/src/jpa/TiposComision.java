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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "tipos_comision")
@NamedQueries({
  @NamedQuery(name = "TiposComision.findAll", query = "SELECT t FROM TiposComision t"),
  @NamedQuery(name = "TiposComision.findByIdTipoComision", query = "SELECT t FROM TiposComision t WHERE t.idTipoComision = :idTipoComision"),
  @NamedQuery(name = "TiposComision.findByIdTipoUsuario", query = "SELECT t FROM TiposComision t WHERE t.idTipoUsuario = :idTipoUsuario"),
  @NamedQuery(name = "TiposComision.findByPorcentaje", query = "SELECT t FROM TiposComision t WHERE t.porcentaje = :porcentaje")})
public class TiposComision implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "ID_TIPO_COMISION")
  private Integer idTipoComision;
  @Basic(optional = false)
  @Column(name = "ID_TIPO_USUARIO")
  private int idTipoUsuario;
  @Basic(optional = false)
  @Column(name = "PORCENTAJE")
  private long porcentaje;

  public TiposComision() {
  }

  public TiposComision(Integer idTipoComision) {
    this.idTipoComision = idTipoComision;
  }

  public TiposComision(Integer idTipoComision, int idTipoUsuario, long porcentaje) {
    this.idTipoComision = idTipoComision;
    this.idTipoUsuario = idTipoUsuario;
    this.porcentaje = porcentaje;
  }

  public Integer getIdTipoComision() {
    return idTipoComision;
  }

  public void setIdTipoComision(Integer idTipoComision) {
    this.idTipoComision = idTipoComision;
  }

  public int getIdTipoUsuario() {
    return idTipoUsuario;
  }

  public void setIdTipoUsuario(int idTipoUsuario) {
    this.idTipoUsuario = idTipoUsuario;
  }

  public long getPorcentaje() {
    return porcentaje;
  }

  public void setPorcentaje(long porcentaje) {
    this.porcentaje = porcentaje;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idTipoComision != null ? idTipoComision.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TiposComision)) {
      return false;
    }
    TiposComision other = (TiposComision) object;
    if ((this.idTipoComision == null && other.idTipoComision != null) || (this.idTipoComision != null && !this.idTipoComision.equals(other.idTipoComision))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.TiposComision[ idTipoComision=" + idTipoComision + " ]";
  }
  
}
