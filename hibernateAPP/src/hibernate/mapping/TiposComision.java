package hibernate.mapping;
// Generated 30-dic-2014 1:01:00 by Hibernate Tools 4.3.1



/**
 * TiposComision generated by hbm2java
 */
public class TiposComision  implements java.io.Serializable {


     private int idTipoComision;
     private TiposUsuarios tiposUsuarios;
     private long porcentaje;

    public TiposComision() {
    }

    public TiposComision(int idTipoComision, TiposUsuarios tiposUsuarios, long porcentaje) {
       this.idTipoComision = idTipoComision;
       this.tiposUsuarios = tiposUsuarios;
       this.porcentaje = porcentaje;
    }
   
    public int getIdTipoComision() {
        return this.idTipoComision;
    }
    
    public void setIdTipoComision(int idTipoComision) {
        this.idTipoComision = idTipoComision;
    }
    public TiposUsuarios getTiposUsuarios() {
        return this.tiposUsuarios;
    }
    
    public void setTiposUsuarios(TiposUsuarios tiposUsuarios) {
        this.tiposUsuarios = tiposUsuarios;
    }
    public long getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }




}


