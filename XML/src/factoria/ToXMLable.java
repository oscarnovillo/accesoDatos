/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

/**
 *
 * @author profesor
 */
public interface ToXMLable {
    
    public void toXML(Object obj,String file);
    
    public Object fromXML(String file);
    
    
}
