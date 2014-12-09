/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import datos.Compra;
import datos.Persona;
import factoria.Saveable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author madrid
 */
public class SaveGson extends Saveable {

    @Override
    public void comprasToXML(ArrayList<Compra> datos, String file) {
        FileWriter fw = null;
        try {
            Gson gson = new Gson();
            fw = new FileWriter(this.getFileName(file));
            gson.toJson(datos, fw);
        } catch (IOException ex) {
            // Logger.getLogger(GsonPropio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                //   Logger.getLogger(GsonPropio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public ArrayList<Compra> comprasFromXML(String file) {
        Gson gson = new Gson();
        FileReader fr = null;
        ArrayList<Compra> lista = null;
        try {
            fr = new FileReader(this.getFileName(file));
            Type typeOfList = new TypeToken<ArrayList<Compra>>() {
            }.getType();
            lista = gson.fromJson(fr, typeOfList);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(GsonPropio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public void personasToXML(HashMap<Integer, Persona> datos, String file) {
        Gson gson = new Gson();
        FileWriter fw = null;
        try {
            fw = new FileWriter(this.getFileName(file));
            gson.toJson(datos, fw);
            fw.close();
        } catch (IOException ex) {
        }
    }

    @Override
    public HashMap<Integer, Persona> personasFromXML(String file) {
        Gson gson = new Gson();
        FileReader fr = null;
        HashMap<Integer, Persona> lista = null;
        try {
            fr = new FileReader(this.getFileName(file));
            Type typeOfHash = new TypeToken<HashMap<Integer, Persona>>() {
            }.getType();
            lista = gson.fromJson(fr, typeOfHash);
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no existe aun");
        }
        return lista;
    }

    @Override
    protected String getFileName(String file) {
        file += ConstantesGson.FILE_EXTENSION;
        return file;
    }
}
