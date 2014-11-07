/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package json;

import org.boon.json.ObjectMapper;
import org.boon.json.implementation.ObjectMapperImpl;


import org.boon.Lists;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.boon.Boon.puts;
import org.boon.json.JsonFactory;

/**
 *
 * @author profesor
 */
public class JsonBoon {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper =  JsonFactory.create();

            User user = new User();
            user.setGender( User.Gender.MALE );
            user.setName(new User.Name("Richard", "Hightower"));
            user.setVerified( true );

            puts ( mapper.writeValueAsString( user ) );
            System.out.println(mapper.writeValueAsString( user ));
            
            FileWriter file = new FileWriter("user.json" );

            //file.write(mapper.writeValueAsString( user ));
            mapper.writeValue(file, user);
            file.close();
            
        } catch (IOException ex) {
            Logger.getLogger(JsonBoon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
