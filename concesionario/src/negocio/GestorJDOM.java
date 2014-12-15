/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import concesionario.datos.Coche;
import concesionario.datos.Franquicia;
import org.jdom2.Element;

/**
 *
 * @author oscar
 */
public class GestorJDOM {
  
  
  public Element crearElementFranquicia(Franquicia f)
  {
    Element franquicia = new Element("franquicia");
    franquicia.setAttribute("id",""+f.getId());
    Element stock =  new Element("stock");
    for(Coche c : f.getStockCoches())
    {
      stock.addContent(crearCoche(c));
    }
    franquicia.addContent(stock);
    
    return franquicia;
  }
  
  public Element crearCoche(Coche c)
  {
    Element coche =  new Element("coche");
    coche.setAttribute("matricula",c.getMatricula());
    coche.addContent("marca").setText(c.getMarca());
    coche.addContent("modelo").setText(c.getModelo());
    return coche;
  }
  
}
