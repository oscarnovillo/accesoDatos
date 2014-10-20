/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.File;
import java.util.ArrayList;
import javaapplication1.bd.Archivo;

/**
 *
 * @author profesor
 */
public class Navegador {

    public ArrayList<Archivo> directorios(String path) {
        ArrayList<Archivo> archivos = new ArrayList<>();

        File f = new File(path);
        Archivo a = null;
        // comprobar que hay hijos
        if (f.listFiles() != null) {
            
            // equivalente al foreach
//            for (int i = 0; i < f.listFiles().length; i++) {
//                File f1 = f.listFiles()[i];
//            }

            for (File f1 : f.listFiles()) {
                a = crearArchivo(f1);
                archivos.add(a);
            }
        }
        return archivos;
    }

    public Archivo crearArchivo(String path) {
        return crearArchivo(new File(path));
    }

    private Archivo crearArchivo(File f) {
        return new Archivo(f.getName(), f.isDirectory(), f.getAbsolutePath(), f.getParent());
    }
}
