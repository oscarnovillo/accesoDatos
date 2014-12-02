/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import datos.Compra;
import datos.Persona;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author profesor
 */
public interface Saveable {

    public void comprasToXML(ArrayList<Compra> datos, String file);

    public ArrayList<Compra> comprasFromXML(String file);

    public void personasToXML(HashMap<Integer, Persona> datos, String file);

    public HashMap<Integer, Persona> personasFromXML(String file);
}