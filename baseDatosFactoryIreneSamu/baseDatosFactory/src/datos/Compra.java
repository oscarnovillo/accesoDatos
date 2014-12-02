/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author profesor
 */
// no se puede quitar por culpa del jaxb
@XmlAccessorType(XmlAccessType.FIELD)
public class Compra implements Serializable {
    public int cantidad;
    public String concepto;

    public Compra(int cantidad, String concepto) {
        this.cantidad = cantidad;
        this.concepto = concepto;
    }

    public Compra() {
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}
