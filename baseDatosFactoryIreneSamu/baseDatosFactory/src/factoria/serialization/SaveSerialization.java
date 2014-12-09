/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.serialization;

import datos.Compra;
import datos.Persona;
import factoria.Saveable;
import factoria.xml.ConstantesXML;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author oscar
 */
public class SaveSerialization extends Saveable {

    @Override
    public void comprasToXML(ArrayList<Compra> datos, String file) {
        File f = new File(this.getFileName(file));
        FileOutputStream fich = null;
        try {
            fich = new FileOutputStream(f);
            ObjectOutputStream object = new ObjectOutputStream(fich);
            for (Compra c : datos) {
                object.writeObject(c);
            }
            object.close();
            fich.close();
        } catch (Exception ex) {
        }
    }

    @Override
    public ArrayList<Compra> comprasFromXML(String nombreFichero) {
        File f = new File(this.getFileName(nombreFichero));
        ArrayList<Compra> compras = new ArrayList<Compra>();
        if (f.exists()) {
            FileInputStream file = null;
            ObjectInputStream ois = null;
            try {
                file = new FileInputStream(nombreFichero);
                ois = new ObjectInputStream(file);
                while (true) {
                    Object aux = ois.readObject();
                    if (aux instanceof Compra) {
                        Compra c = (Compra) aux;
                        compras.add(c);
                    }
                }
            } catch (EOFException ex) {
                // System.out.println("Fin del fichero");
            } catch (Exception ex) {
                //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    ois.close();
                    file.close();
                } catch (IOException ex) {
                    // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return compras;
    }

    @Override
    public void personasToXML(HashMap<Integer, Persona> datos, String nombreFichero) {
        File f = new File(this.getFileName(nombreFichero));
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(f);
            ObjectOutputStream object = new ObjectOutputStream(file);
            for (Persona p : datos.values()) {
                object.writeObject(p);
            }
            object.close();
            file.close();
        } catch (Exception ex) {
        }
    }

    @Override
    public HashMap<Integer, Persona> personasFromXML(String nombreFichero) {
        FileInputStream file = null;
        ObjectInputStream ois = null;
        HashMap<Integer, Persona> personas = new HashMap<>();

        try {
            file = new FileInputStream(this.getFileName(nombreFichero));
            ois = new ObjectInputStream(file);
            while (true) {
                Object aux = ois.readObject();
                if (aux instanceof Persona) {
                    Persona p = (Persona) aux;
                    personas.put(p.getId(), p);
                }
            }
        } catch (EOFException ex) {
//            System.out.println("Fin del fichero");
        } catch (Exception ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
                file.close();
            } catch (IOException ex) {
                //   Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return personas;
    }

    @Override
    protected String getFileName(String file) {
        file += ConstantesSerialization.FILE_EXTENSION;
        return file;
    }

}
