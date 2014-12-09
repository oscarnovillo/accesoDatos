/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import datos.Compra;
import datos.Persona;
import factoria.Saveable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author madrid
 */
public class SaveJackson extends Saveable {

  @Override
    public void comprasToXML(ArrayList<Compra> datos, String file) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(this.getFileName(file)), datos);
        } catch (IOException ex) {
            System.out.println("Archivo creado: Compras guardadas");
        }
    }

    @Override
    public ArrayList<Compra> comprasFromXML(String file) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Compra> lista = null;
        try {
            lista = mapper.readValue(new File(this.getFileName(file)), new TypeReference<ArrayList<Compra>>() {
            });
        } catch (IOException ex) {
            System.out.println("Archivo creado: Compras cargadas");
        }
        return lista;
    }

    @Override
    public void personasToXML(HashMap<Integer, Persona> datos, String file) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibilityChecker(
                mapper.getSerializationConfig().
                getDefaultVisibilityChecker().
                withFieldVisibility(JsonAutoDetect.Visibility.ANY).
                withGetterVisibility(JsonAutoDetect.Visibility.NONE));
        try {
            mapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                    .withGetterVisibility(JsonAutoDetect.Visibility.NONE);
            mapper.writeValue(new File(this.getFileName(file)), datos);

        } catch (Exception ex) {
            System.out.println("Archivo creado: Personas guardadas");
        }
    }

    @Override
    public HashMap<Integer, Persona> personasFromXML(String file) {
        ObjectMapper mapper = new ObjectMapper();
        HashMap<Integer, Persona> lista = null;
        try {
            lista = mapper.readValue(new File(this.getFileName(file)), new TypeReference<HashMap<Integer, Persona>>() {
            });
        } catch (IOException ex) {
            System.out.println("Archivo creado: Personas cargadas");

        }
        return lista;
    }

    @Override
    protected String getFileName(String file) {
        file += ConstantesJackson.FILE_EXTENSION;
        return file;
    }

}
