package datos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author profesor
 */
public class Coche {
    
    private String marca;
    private String modelo;
    private int velocidadMaxima;

    public Coche()
    {
      
    }
    
    public Coche(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
    }
    
    public Coche(String atributo)
    {
        String [] s = atributo.split(",");
        this.marca = s[0];
        this.modelo = s[1];
        this.velocidadMaxima = Integer.parseInt(s[2]);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    @Override
    public String toString() {
        return marca + ","+ modelo + "," + velocidadMaxima;
    }
    
    
    
}
