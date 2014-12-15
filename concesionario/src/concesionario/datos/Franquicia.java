/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario.datos;

import java.util.ArrayList;

/**
 *
 * @author profesor
 */
public class Franquicia {
    public int id;
    public String formato;
    public ArrayList<Coche> stockCoches;
    public ArrayList<Vendido> ventasCoches;
    public ArrayList<Alquiler> alquileresCoches;
    

    public Franquicia() {
    }

    public Franquicia(int id, String formato) {
        this.id = id;
        this.formato = formato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public ArrayList<Coche> getStockCoches() {
        return stockCoches;
    }

    public void setStockCoches(ArrayList<Coche> stockCoches) {
        this.stockCoches = stockCoches;
    }

    public ArrayList<Vendido> getVentasCoches() {
        return ventasCoches;
    }

    public void setVentasCoches(ArrayList<Vendido> ventasCoches) {
        this.ventasCoches = ventasCoches;
    }

    public ArrayList<Alquiler> getAlquileresCoches() {
        return alquileresCoches;
    }

    public void setAlquileresCoches(ArrayList<Alquiler> alquileresCoches) {
        this.alquileresCoches = alquileresCoches;
    }

    @Override
    public String toString() {
        return "Franquicia{" + "id=" + id + ", formato=" + formato + '}';
    }
    
    
    
}
