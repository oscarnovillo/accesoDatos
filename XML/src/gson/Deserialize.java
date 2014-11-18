/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import datos.Persona;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author oscar
 */
public class Deserialize {
  public static void main(String[] args) throws FileNotFoundException {
    Gson gson = new Gson();
    try{
      FileReader fr = new FileReader("gsonJSONHashMap.json"); 
      Type typeOfHashMap = new TypeToken<Map<Integer, Persona>>() {
                    }.getType();
      LinkedHashMap<Integer,Persona> hash = gson.fromJson(fr,typeOfHashMap);

      fr.close();
      fr = new FileReader("gsonJSONlista.json"); 
            Type typeOfList = new TypeToken<ArrayList<Persona>>() {
                    }.getType();
            ArrayList<Persona> array = gson.fromJson(fr,typeOfList);
      //Persona[] a = gson.fromJson(fr,Persona[].class);
      fr.close();
      fr = new FileReader("gsonJSONObject.json"); 
      Persona p = gson.fromJson(fr,Persona.class);
      fr.close();
    }catch(Exception e)
    {
      
    }
  }
}
