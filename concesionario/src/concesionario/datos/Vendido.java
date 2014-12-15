/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario.datos;

/**
 *
 * @author profesor
 */
public class Vendido {
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
