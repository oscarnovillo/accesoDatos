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
        Saveable factoria = null;
        switch(tipo)
        {
            case XSTREAM : factoria = new SaveXstream(); break;
            case JAXB: factoria = new SaveJaxb(); break; 
        }
        return factoria;
    }   
}