/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import datos.Coche;
import datos.Persona;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.text.ParseException;
/**
 *
 * @author oscar
 */
public class Serialize {
  
  public static void main(String[] args) {
  //First way to create a Gson object for faster coding
     Persona p = new Persona(1, "nombre", 12, new Coche("marca", "modelo", 100));
    ArrayList<Persona> a = new ArrayList<>();
    a.add(p);
    LinkedHashMap<Integer,Persona> hash = new LinkedHashMap<>();
    hash.put(p.getId(), p);
Gson gson = new Gson();
 
//Second way to create a Gson object using GsonBuilder
 
Gson gson1 = new GsonBuilder()
             .disableHtmlEscaping()
             .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
             .setPrettyPrinting()
             .serializeNulls()
             .create();
    try {
      FileWriter fw = new FileWriter("gsonJSONHashMap.json");
gson.toJson(hash,fw);
fw.close();
fw = new FileWriter("gsonJSONlista.json");
gson.toJson(a,fw);
fw.close();
fw = new FileWriter("gsonJSONObject.json");
gson.toJson(p,fw);
fw.close();
    } catch (IOException ex) {
      Logger.getLogger(Serialize.class.getName()).log(Level.SEVERE, null, ex);
    }
System.out.println(gson.toJson(p));
System.out.println(gson1.toJson(p));
System.out.println(gson.toJson(a));
System.out.println(gson1.toJson(a));
System.out.println(gson.toJson(hash));
System.out.println(gson1.toJson(hash));
    
  }
}
class DateSerializer implements JsonSerializer<Date>
{
   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   @Override
   public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context)
   {
      return new JsonPrimitive(dateFormat.format(date));
   }
}

class DateDeserializer implements JsonDeserializer<Date>
{
   private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
   @Override
   public Date deserialize(JsonElement dateStr, Type typeOfSrc, JsonDeserializationContext context)
   {
      try
      {
         return dateFormat.parse(dateStr.getAsString());
      }
      catch (ParseException e)
      {
         e.printStackTrace();
      }
      return null;
   }
}