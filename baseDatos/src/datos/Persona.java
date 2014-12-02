/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author profesor
 */
public class Persona implements Serializable, Comparable<Persona> {
    
    
    private int id;
    private String nombre;
    private transient ArrayList<Compra> compras;

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        compras = new ArrayList<>();
    }

    public ArrayList<Compra> getCompras() {
        return compras;
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
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        this.nombre.equals(((Persona)obj).getNombre());
        return true;
    }

    @Override
    public int compareTo(Persona t) {
        return this.nombre.compareTo(t.nombre);

    }
    
    
    
    
    
    
}
