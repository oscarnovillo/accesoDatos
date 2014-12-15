/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario.datos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author profesor
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Vendido implements Serializable {
    public String matricula;
    public double precio;

    public Vendido() {
    }

    public Vendido(String matricula, double precio) {
        this.matricula = matricula;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
