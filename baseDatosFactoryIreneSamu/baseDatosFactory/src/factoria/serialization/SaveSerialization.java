/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.serialization;

import datos.Compra;
import datos.Persona;
import factoria.Saveable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author oscar
 */
public class SaveSerialization extends Saveable {

  @Override
  public void comprasToXML(ArrayList<Compra> datos, String file) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public ArrayList<Compra> comprasFromXML(String file) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void personasToXML(HashMap<Integer, Persona> datos, String file) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public HashMap<Integer, Persona> personasFromXML(String file) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  protected String getFileName(String file) {
    file += ConstantesSerialization.FILE_EXTENSION;
    return file;
  }

}
