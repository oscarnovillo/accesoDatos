/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import com.google.gson.Gson;
import concesionario.datos.Franquicia;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author profesor
 */
public class GestorFicheros {
    
    
    
    public Franquicia cargarFranquiciaJson(String file) {
        Gson gson = new Gson();
        FileReader fr = null;
        Franquicia franquicia = null;
        try {
            fr = new FileReader(file);
            franquicia = gson.fromJson(fr,Franquicia.class);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(GsonPropio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return franquicia;
    }
    
    public Franquicia cargarFranquiciaJaxb(String file) {
        Franquicia franquicia = null;
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Franquicia.class);
            Unmarshaller u = jc.createUnmarshaller();
            franquicia = (Franquicia) u.unmarshal(new File(file));
        } catch (JAXBException ex) {
        }
        return franquicia;
    }

    public Franquicia cargarFranquiciaObjetos(String file) {
 
                FileInputStream fich = null;
        ObjectInputStream ois = null;
        Franquicia franquicia = null;
        try {
            fich = new FileInputStream(file);
            ois = new ObjectInputStream(fich);
                Object aux = ois.readObject();
                if (aux instanceof Franquicia) {
                    franquicia = (Franquicia) aux;
                }
        } catch (EOFException ex) {
//            System.out.println("Fin del fichero");
        } catch (Exception ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
                fich.close();
            } catch (IOException ex) {
                //   Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return franquicia;
    }


    
    
    

}
