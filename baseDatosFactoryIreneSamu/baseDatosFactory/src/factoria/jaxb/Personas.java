/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.jaxb;

import datos.Persona;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dam2
 */

@XmlRootElement
public class Personas {

    private HashMap<Integer, Persona> personas = new HashMap<Integer, Persona>();

    public HashMap<Integer, Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(HashMap<Integer, Persona> personas) {
        this.personas = personas;
    }

    public void addPersona(Persona p) {
        personas.put(p.getId(), p);
    }
}
