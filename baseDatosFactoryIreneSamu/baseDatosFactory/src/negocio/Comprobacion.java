/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.Persona;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author dam2
 */
public class Comprobacion {

    public boolean comprobarExistePersona(HashMap<Integer, Persona> hash, int id) {
        boolean existe = false;
        Iterator it = hash.values().iterator();
        while (it.hasNext()) {
            Persona p = (Persona) it.next();
            if (p.getId() == id) {
                existe = true;
            }
        }
        return existe;
    }
}
