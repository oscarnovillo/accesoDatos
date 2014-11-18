/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackson;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import datos.Persona;
import java.io.File;
import java.io.IOException;
 

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 *
 * @author oscar
 */
public class Deserialize {
  public static void main(String[] args)
   {
      Persona employee = null;
      LinkedHashMap<Integer,Persona> foo = null;
      ObjectMapper mapper = new ObjectMapper();
      try
      {
         employee =  mapper.readValue(new File("jackson.json"), Persona.class);
         
foo = mapper.readValue(new File("jacksonHashMap.json"),  
        new TypeReference<LinkedHashMap<Integer,Persona>>() { });  
       
      } catch (JsonGenerationException e)
      {
         e.printStackTrace();
      } catch (JsonMappingException e)
      {
         e.printStackTrace();
      } catch (IOException e)
      {
         e.printStackTrace();
      }
      System.out.println(employee);
   }
}
