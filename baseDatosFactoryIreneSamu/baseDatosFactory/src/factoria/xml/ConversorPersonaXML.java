/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.xml;

import datos.Persona;
import org.jdom2.Element;

/**
 *
 * @author madrid
 */
public class ConversorPersonaXML {

    public Element personaFromXML(Persona p) {
        Element persona = new Element("persona");
        persona.setAttribute("id", p.getId() + "");
        persona.addContent(new Element("nombre").setText(p.getNombre()));
        return persona;
    }

    public Persona personaFromXML(Element element) {
        Persona p = null;
        p = new Persona(Integer.parseInt(element.getAttributeValue("id").toString()), element.getChildText("nombre"));
        return p;
    }

}
