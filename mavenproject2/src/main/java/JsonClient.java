
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import quevedo.library.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class JsonClient {
  
  public static void main(String[] args) {
    
    try {
      Connection.Response response = null;
//    Jsoup.connect("https://gestiona.madrid.org/wafd/ValidaUsuario.icm")
//        .method(Connection.Method.GET)
//        .execute();
      
      response = Jsoup.connect("http://localhost:8080/ejemploJ2EEMaven/TestServlet")
               //.cookies(response.cookies())
              .data("json","true")
              .method(Connection.Method.POST)
              .ignoreContentType(true)
              .execute();
      
      String json = response.body();
      // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();
 
        // 3. Convert received JSON to Article
        ArrayList<Test> tests = mapper.readValue(json,  new TypeReference<ArrayList<Test>>(){ });
      
        for(Test test : tests)
          System.out.println(test.getNum());
    } catch (IOException ex) {
      Logger.getLogger(JsonClient.class.getName()).log(Level.SEVERE, null, ex);
    }

    
  }
}
