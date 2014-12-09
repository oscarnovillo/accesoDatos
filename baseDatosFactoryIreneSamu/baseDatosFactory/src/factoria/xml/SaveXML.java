/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.xml;

import datos.Compra;
import datos.Persona;
import factoria.Saveable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author madrid
 */
public class SaveXML extends Saveable {

    @Override
    public void comprasToXML(ArrayList<Compra> datos, String nombreFichero) {
        Element raiz = new Element("compras");
        Document document = new Document(raiz);
        Compra c = null;
        for (int i = 0; i < datos.size(); i++) {
            Element comprita = new Element("compra");
            c = datos.get(i);
            comprita.addContent(new Element("cantidad").setText(c.getCantidad() + ""));
            comprita.addContent(new Element("concepto").setText(c.getConcepto()));
            raiz.addContent(comprita);
        }
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(document, new FileWriter(
                    this.getFileName(nombreFichero)));
        } catch (IOException ex) {
            //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<Compra> comprasFromXML(String nombreFichero) {
        File f = new File(this.getFileName(nombreFichero));
        ArrayList<Compra> compras = new ArrayList<Compra>();
        SAXBuilder saxBuilder = new SAXBuilder();
        Compra c = null;
        if (f.exists()) {

            Document document = null;
            try {
                document = saxBuilder.build(f);
                Element rootNode = document.getRootElement();
                List<Element> comprasList = rootNode.getChildren("compra");
                for (int i = 0; i <= comprasList.size() - 1; i++) {
                    Element element = comprasList.get(i);
                    c = new Compra(Integer.parseInt(element.getChildText("cantidad").toString()), element.getChildText("concepto"));
                    compras.add(c);
                }
            } catch (JDOMException ex) {
                //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return compras;
    }

    @Override
    public void personasToXML(HashMap<Integer, Persona> datos, String nombreFichero) {
        Element raiz = new Element("personas");
        Document document = new Document(raiz);
        ConversorPersonaXML conversor = new ConversorPersonaXML();
        
        for (Persona p : datos.values()) {
            raiz.addContent(conversor.personaFromXML(p));
        }
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        try {
            xmlOutput.output(document, new FileWriter(
                    this.getFileName(nombreFichero)));
        } catch (IOException ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HashMap<Integer, Persona> personasFromXML(String nombreFichero) {
        HashMap<Integer, Persona> personas = new HashMap<>();
        SAXBuilder saxBuilder = new SAXBuilder();
        File file = new File(this.getFileName(nombreFichero));
        ConversorPersonaXML conversor = new ConversorPersonaXML();
        try {
            Document document = saxBuilder.build(file);
            Element rootNode = document.getRootElement();
            List<Element> personasList = rootNode.getChildren("persona");
            for (Element element : personasList) {
                Persona p = conversor.personaFromXML(element);
                personas.put(p.getId(), p);
            }
        } catch (JDOMException ex) {
            // Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(FicherosDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personas;
    }

    @Override
    protected String getFileName(String file) {
        file += ConstantesXML.FILE_EXTENSION;
        return file;
    }

}
