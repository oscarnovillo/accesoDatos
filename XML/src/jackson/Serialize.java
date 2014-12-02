/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonGenerationException;
import datos.Coche;
import datos.Persona;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author oscar
 */
public class Serialize {

    public static void main(String[] args) {
        Persona p = new Persona(1, "nombre", 12, new Coche("marca", "modelo", 100));
        ArrayList<Persona> a = new ArrayList<>();
        a.add(p);
        LinkedHashMap<Integer, Persona> hash = new LinkedHashMap<>();
        hash.put(p.getId(), p);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibilityChecker(
                mapper.getSerializationConfig().
                getDefaultVisibilityChecker().
                withFieldVisibility(JsonAutoDetect.Visibility.ANY).
                withGetterVisibility(JsonAutoDetect.Visibility.NONE));
        try {
            mapper.writeValue(new File("jackson.json"), p);
            mapper.writeValue(new File("jacksonLista.json"), a);
            mapper.writeValue(new File("jacksonHashMap.json"), hash);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
