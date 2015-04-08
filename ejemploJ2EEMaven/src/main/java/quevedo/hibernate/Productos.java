package quevedo.hibernate;
// Generated 22-feb-2015 13:48:13 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Productos generated by hbm2java
 */
public class Productos  implements java.io.Serializable {


     private String codigo;
     private String nombre;
     private double precio;
     private Date fechaFin;

    public Productos() {
    }

	
    public Productos(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    public Productos(String codigo, String nombre, double precio, Date fechaFin) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.precio = precio;
       this.fechaFin = fechaFin;
    }
   
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }




}

