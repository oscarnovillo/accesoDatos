package factoria;


import factoria.TiposToXML;
import factoria.ToXMLFactory;
import factoria.ToXMLable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author profesor
 */
public class UsoFactoria {
    public static void main(String[] args){
        
        ToXMLFactory fac = new ToXMLFactory();
        
        ToXMLable mio = fac.build(TiposToXML.XSTREAM);
        try{
        mio.toXML(mio, null);
        }catch(Exception e){}
        
    }
}
