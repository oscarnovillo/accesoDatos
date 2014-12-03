/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author profesor
 */
// no se puede quitar por culpa del jaxb
@XmlAccessorType(XmlAccessType.FIELD)
public class Persona implements Serializable {

    private int id;
    private String nombre;
    @XmlTransient
    private ArrayList<Compra> compras;

    public Persona() {
        
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        compras = new ArrayList<>();
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona: id= " + id + " nombre= " + nombre;
    }
}