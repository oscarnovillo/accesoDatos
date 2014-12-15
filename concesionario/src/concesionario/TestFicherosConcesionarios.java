/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import bd.GestorFicheros;
import concesionario.datos.Alquiler;
import concesionario.datos.Coche;
import concesionario.datos.Franquicia;
import concesionario.datos.Vendido;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;

/**
 *
 * @author profesor
 */
public class TestFicherosConcesionarios {

    public static void main(String[] args) {
            GestorFicheros gf = new GestorFicheros();
      try {
            //    <franquicia id="2" formato="jaxb"/>
            //    <franquicia id="3" formato="json"/>
            //    <franquicia id="5" formato="objetos"/>
            //    <franquicia id="6" formato="json"/>
            Franquicia f3 = new Franquicia(3, "json");
            ArrayList<Coche> stock3 = new ArrayList<>();
            stock3.add(new Coche("1", "r", "r"));
            stock3.add(new Coche("2", "c", "c"));
            stock3.add(new Coche("3", "a", "a"));
            ArrayList<Vendido> ventas3 = new ArrayList<>();
            ventas3.add(new Vendido("1", 10));
            ArrayList<Alquiler> alquileres3 = new ArrayList<>();
            alquileres3.add(new Alquiler("2", 1));
            f3.setStockCoches(stock3);
            f3.setVentasCoches(ventas3);
            f3.setAlquileresCoches(alquileres3);
            gf.guardarFranquicia(f3);
          
            Franquicia f6 = new Franquicia(6, "json");
            ArrayList<Coche> stock6 = new ArrayList<>();
            stock6.add(new Coche("1", "r", "r"));
            stock6.add(new Coche("2", "c", "c"));
            stock6.add(new Coche("6", "a", "a"));
            ArrayList<Vendido> ventas6 = new ArrayList<>();
            ventas6.add(new Vendido("1", 10));
            ArrayList<Alquiler> alquileres6 = new ArrayList<>();
            alquileres6.add(new Alquiler("2", 1));
            f6.setStockCoches(stock6);
            f6.setVentasCoches(ventas6);
            f6.setAlquileresCoches(alquileres6);
            gf.guardarFranquicia(f6);
          
            Franquicia f5 = new Franquicia(2, "objetos");
            ArrayList<Coche> stock5 = new ArrayList<>();
            stock5.add(new Coche("1", "r", "r"));
            stock5.add(new Coche("2", "c", "c"));
            stock5.add(new Coche("3", "a", "a"));
            ArrayList<Vendido> ventas5 = new ArrayList<>();
            ventas5.add(new Vendido("1", 10));
            ArrayList<Alquiler> alquileres5 = new ArrayList<>();
            alquileres5.add(new Alquiler("2", 1));
            f5.setStockCoches(stock5);
            f5.setVentasCoches(ventas5);
            f5.setAlquileresCoches(alquileres5);
            gf.guardarFranquicia(f5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
