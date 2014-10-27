/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.File;
import java.util.ArrayList;
import bd.Archivo;
import ficherosTexto.FicherosTexto;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public String leerFicheroTexto(String nombre) throws FileNotFoundException, IOException {
        StringBuffer fileContent = new StringBuffer();
        FileReader reader = null;
        try {

            reader = new FileReader(nombre);
            BufferedReader buff = new BufferedReader(reader);
            String line = null;
            while ((line = buff.readLine()) != null) {
                fileContent.append(line + "\n");
            }

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FicherosTexto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fileContent.toString();
    }

    public void escribirFicheroTexto(String nombre, String fileContent) throws FileNotFoundException, IOException {

        FileWriter writer = null;
        try {

            writer = new FileWriter(nombre);

            writer.write(fileContent);

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FicherosTexto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
