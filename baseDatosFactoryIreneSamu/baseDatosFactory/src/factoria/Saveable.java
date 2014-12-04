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
public abstract class Saveable {

    public abstract void comprasToXML(ArrayList<Compra> datos, String file);

    public abstract ArrayList<Compra> comprasFromXML(String file);

    public abstract void personasToXML(HashMap<Integer, Persona> datos, String file);

    public abstract HashMap<Integer, Persona> personasFromXML(String file);
    
    protected abstract String getFileName(String file);
}