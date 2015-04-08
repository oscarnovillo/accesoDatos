package quevedo.hibernate;
// Generated 22-feb-2015 13:48:13 by Hibernate Tools 4.3.1



/**
 * LineaPedido generated by hbm2java
 */
public class LineaPedido  implements java.io.Serializable {


     private Integer idLineaPedido;
     private int idPedido;
     private String codigoProducto;
     private int cantidad;
     private long precioLinea;

    public LineaPedido() {
    }

    public LineaPedido(int idPedido, String codigoProducto, int cantidad, long precioLinea) {
       this.idPedido = idPedido;
       this.codigoProducto = codigoProducto;
       this.cantidad = cantidad;
       this.precioLinea = precioLinea;
    }
   
    public Integer getIdLineaPedido() {
        return this.idLineaPedido;
    }
    
    public void setIdLineaPedido(Integer idLineaPedido) {
        this.idLineaPedido = idLineaPedido;
    }
    public int getIdPedido() {
        return this.idPedido;
    }
    
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public String getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public long getPrecioLinea() {
        return this.precioLinea;
    }
    
    public void setPrecioLinea(long precioLinea) {
        this.precioLinea = precioLinea;
    }




}

