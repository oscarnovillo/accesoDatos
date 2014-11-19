/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Persona;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class FicherosDatos {

    public void guardar(String nombreFichero, ArrayList<Persona> datos) {
        FileOutputStream file;
        try {
            file = new FileOutputStream(nombreFichero);
            ObjectOutputStream object = new ObjectOutputStream(file);
            for (Persona p : datos) {
                object.writeObject(p);
            }

            object.close();
            file.close();


        } catch (Exception ex) {
        }


    }

    public ArrayList<Persona> cargar(String nombreFichero) {

        ArrayList<Persona> personas = new ArrayList<>();
        Persona p = null;


        try {
            FileInputStream file = new FileInputStream(nombreFichero);
            ObjectInputStream object = new ObjectInputStream(file);

            while (file.available() > 0) {
                p = (Persona) object.readObject();
                personas.add(p);
            }
            object.close();
            file.close();


        } catch (Exception ex) {
            Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }




        return personas;
    }
}
