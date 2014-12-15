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
        try {
            //            <franquicia id="2" formato="jaxb"/>
            //    <franquicia id="3" formato="json"/>
            //    <franquicia id="5" formato="objetos"/>
            //    <franquicia id="6" formato="json"/>

            Franquicia f = new Franquicia(2, "objetos");
            ArrayList<Coche> stock = new ArrayList<>();
            stock.add(new Coche("1", "r", "r"));
            stock.add(new Coche("2", "c", "c"));
            stock.add(new Coche("3", "a", "a"));
            ArrayList<Vendido> ventas = new ArrayList<>();
            ventas.add(new Vendido("1", 10));
            ArrayList<Alquiler> alquileres = new ArrayList<>();
            alquileres.add(new Alquiler("2", 1));
            f.setStockCoches(stock);
            f.setVentasCoches(ventas);
            f.setAlquileresCoches(alquileres);

            GestorFicheros gf = new GestorFicheros();
            gf.guardarFranquicia(f);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
