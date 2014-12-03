/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.xstream;

import com.thoughtworks.xstream.XStream;
import datos.Compra;
import datos.Persona;
import factoria.Saveable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dam2
 */
public class SaveXstream implements Saveable {

    @Override
    public void comprasToXML(ArrayList<Compra> datos, String file) {
        try {
            XStream xstream = new XStream();
            xstream.toXML(datos, new FileOutputStream(file));
            System.out.println("Creado fichero XML compras....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Compra> comprasFromXML(String file) {
        ArrayList<Compra> compras = new ArrayList<>();
        XStream xstream = new XStream();
        try {
            compras = (ArrayList<Compra>) xstream.fromXML(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero nuevo " + file);
        }
        System.out.println("Fin de listado de compras .....");
        return compras;
    }

    @Override
    public void personasToXML(HashMap<Integer, Persona> datos, String file) {
        try {
            XStream xstream = new XStream();
            xstream.toXML(datos, new FileOutputStream(file));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<Integer, Persona> personasFromXML(String file) {
        HashMap<Integer, Persona> personas = new HashMap<>();
        XStream xstream = new XStream();
        try {
            personas = (HashMap) xstream.fromXML(new FileInputStream(file));
        } catch (FileNotFoundException ex) {

        }
        System.out.println("Fin de listado .....");
        return personas;
    }
}
