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
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

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

   public void guardarFranquiciaJson(Franquicia franquicia) {
        Gson gson = new Gson();
        FileWriter fw = null;
        try {
            fw = new FileWriter(franquicia.getId()+".json");
            gson.toJson(franquicia, fw);
            fw.close();
        } catch (IOException ex) {
        }
        
    }
    
    public void guardarFranquiciaJaxb(Franquicia franquicia) {
        
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Franquicia.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(franquicia, new File(franquicia.getId()+".jaxb"));
        } catch (JAXBException ex) {

        }
        
    }

    public void guardarFranquiciaObjetos(Franquicia franquicia) {
 
        File f = new File(franquicia.getId()+".dat");
        FileOutputStream file = null;
        try {
            file = new FileOutputStream(f);
            ObjectOutputStream object = new ObjectOutputStream(file);
            object.writeObject(franquicia);
            object.close();
            file.close();
        } catch (Exception ex) {
        }
       
    }
    
    
    public void guardarJDOM(Document document,String file)
    {
                XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(document, new FileWriter(
                    file));
        } catch (IOException ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Document cargarJDOM(String nombreFile)
    {
        Document document = null;
        SAXBuilder saxBuilder = new SAXBuilder();
        File file = new File(nombreFile);
        
        try {
            document = saxBuilder.build(file);
        } catch (JDOMException ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return document;
    }

    
    
    

}
