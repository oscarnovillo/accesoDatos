/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

/**
 *
 * @author profesor
 */
public class ToXMLFactory {
    
    
    public ToXMLable build(TiposToXML tipo)
            
    {
        ToXMLable interfaz = null;
        switch(tipo)
        {
            case XSTREAM : interfaz = new XstreamMio(); break;
            case JAXB: interfaz = new JaxbMio(); break;
                
            
        }
        
        return interfaz;
    }
    
    
    
}
