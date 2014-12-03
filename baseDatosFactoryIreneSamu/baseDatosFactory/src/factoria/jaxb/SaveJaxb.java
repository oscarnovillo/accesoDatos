/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.jaxb;

import datos.Compra;
import factoria.jaxb.Compras;
import datos.Persona;
import factoria.Saveable;
import factoria.jaxb.Personas;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author dam2
 */
public class SaveJaxb implements Saveable {

    @Override
    public void comprasToXML(ArrayList<Compra> datos, String file) {
        Compras listaC = new Compras();
        listaC.setCompras(datos);
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Compras.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(listaC, new File(file));
        } catch (JAXBException ex) {
            
        }
    }

    @Override
    public ArrayList<Compra> comprasFromXML(String file) {
        File f = new File(file);
        Compras c = null;
        JAXBContext jc = null;
        try {
            jc = JAXBContext.newInstance(Compras.class);
            Unmarshaller u = jc.createUnmarshaller();
            c = (Compras) u.unmarshal(f);
        } catch (JAXBException ex) {

        }
        return c.getCompras();
    }

    @Override
    public void personasToXML(HashMap<Integer, Persona> datos, String file) {
        Personas listaP = new Personas();
        listaP.setPersonas(datos);
        JAXBContext jc;
        try {
            jc = JAXBContext.newInstance(Personas.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(listaP, new File(file));
        } catch (JAXBException ex) {

        }
    }

    @Override
    public HashMap<Integer, Persona> personasFromXML(String file) {
        Personas p = null;
        JAXBContext jc = null;

        try {
            jc = JAXBContext.newInstance(Personas.class);
            Unmarshaller u = jc.createUnmarshaller();
            p = (Personas) u.unmarshal(new File(file));
        } catch (JAXBException ex) {
        }
        return p.getPersonas();
    }
}
