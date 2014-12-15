/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author madrid
 */
public class SaveXML {

    public void saveToXML(Document document, String nombreFichero) {

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(document, new FileWriter(
                    nombreFichero));
        } catch (IOException ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Document personasFromXML(String nombreFichero) {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = null;
        File file = new File(nombreFichero);
        if (file.exists()) {
            try {
                document = saxBuilder.build(file);
            } catch (JDOMException ex) {
                // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return document;
    }

}
