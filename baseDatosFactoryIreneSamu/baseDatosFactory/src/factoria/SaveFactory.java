/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import factoria.xstream.SaveXstream;
import factoria.jaxb.SaveJaxb;

/**
 *
 * @author profesor
 */
public class SaveFactory {
    
    
    public Saveable build(TiposSave tipo)
    {
        Saveable interfaz = null;
        switch(tipo)
        {
            case XSTREAM : interfaz = new SaveXstream(); break;
            case JAXB: interfaz = new SaveJaxb(); break; 
        }
        return interfaz;
    }   
}