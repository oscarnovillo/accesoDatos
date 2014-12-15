/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package concesionario;

import negocio.GestorFicheros;
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
            stock3.add(new Coche("31", "r", "r"));
            stock3.add(new Coche("32", "c", "c"));
            stock3.add(new Coche("33", "a", "a"));
            ArrayList<Vendido> ventas3 = new ArrayList<>();
            ventas3.add(new Vendido("31", 10));
            ArrayList<Alquiler> alquileres3 = new ArrayList<>();
            alquileres3.add(new Alquiler("32", 1));
            f3.setStockCoches(stock3);
            f3.setVentasCoches(ventas3);
            f3.setAlquileresCoches(alquileres3);
            gf.guardarFranquicia(f3);

             Franquicia f2 = new Franquicia(2, "jaxb");
            ArrayList<Coche> stock2 = new ArrayList<>();
            stock2.add(new Coche("21", "r", "r"));
            stock2.add(new Coche("22", "c", "c"));
            stock2.add(new Coche("22", "a", "a"));
            ArrayList<Vendido> ventas2 = new ArrayList<>();
            ventas2.add(new Vendido("21", 10));
            ArrayList<Alquiler> alquileres2 = new ArrayList<>();
            alquileres2.add(new Alquiler("22", 1));
            f2.setStockCoches(stock2);
            f2.setVentasCoches(ventas2);
            f2.setAlquileresCoches(alquileres2);
            gf.guardarFranquicia(f2);
            
            
            Franquicia f6 = new Franquicia(6, "json");
            ArrayList<Coche> stock6 = new ArrayList<>();
            stock6.add(new Coche("61", "r", "r"));
            stock6.add(new Coche("62", "c", "c"));
            stock6.add(new Coche("66", "a", "a"));
            ArrayList<Vendido> ventas6 = new ArrayList<>();
            ventas6.add(new Vendido("61", 10));
            ArrayList<Alquiler> alquileres6 = new ArrayList<>();
            alquileres6.add(new Alquiler("62", 1));
            f6.setStockCoches(stock6);
            f6.setVentasCoches(ventas6);
            f6.setAlquileresCoches(alquileres6);
            gf.guardarFranquicia(f6);
          
            Franquicia f5 = new Franquicia(5, "objetos");
            ArrayList<Coche> stock5 = new ArrayList<>();
            stock5.add(new Coche("51", "r", "r"));
            stock5.add(new Coche("52", "c", "c"));
            stock5.add(new Coche("53", "a", "a"));
            ArrayList<Vendido> ventas5 = new ArrayList<>();
            ventas5.add(new Vendido("51", 10));
            ArrayList<Alquiler> alquileres5 = new ArrayList<>();
            alquileres5.add(new Alquiler("52", 1));
            f5.setStockCoches(stock5);
            f5.setVentasCoches(ventas5);
            f5.setAlquileresCoches(alquileres5);
            gf.guardarFranquicia(f5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
