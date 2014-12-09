/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria;

import factoria.gson.SaveGson;
import factoria.jackson.SaveJackson;
import factoria.xstream.SaveXstream;
import factoria.jaxb.SaveJaxb;
import factoria.serialization.SaveSerialization;
import factoria.xml.SaveXML;

/**
 *
 * @author profesor
 */
public class SaveFactory {

    public Saveable build(TiposSave tipo) {
        Saveable factoria = null;
        switch (tipo) {
            case XSTREAM:
                factoria = new SaveXstream();
                break;
            case JAXB:
                factoria = new SaveJaxb();
                break;
            case GSON:
                factoria = new SaveGson();
                break;
            case JACKSON:
                factoria = new SaveJackson();
                break;
            case XML:
                factoria = new SaveXML();
                break;
            case SERIALIZE:
                factoria = new SaveSerialization();
                break;

        }
        return factoria;
    }
}
