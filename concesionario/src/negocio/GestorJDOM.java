/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import concesionario.datos.Coche;
import concesionario.datos.Franquicia;
import java.util.ArrayList;
import org.jdom2.Document;
import org.jdom2.Element;

/**
 *
 * @author oscar
 */
public class GestorJDOM {

  public Document crearFormatoJDOMVacio() {
    Document concesionario = new Document(new Element("concesionario"));
    Element totales = new Element("totales");
    totales.addContent(new Element("stock").setText("0"));
    totales.addContent(new Element("vendidos").setText("0"));
    totales.addContent(new Element("facturados").setText("0"));
    totales.addContent(new Element("totalfacturado").setText("0"));
    concesionario.getRootElement().addContent(totales);
    concesionario.getRootElement().addContent(new Element("franquicias"));
    return concesionario;
  }

    public Franquicia crearFranquiciaDeElement(Element f) {
    Franquicia franquicia = new Franquicia();
    
    franquicia.setId(Integer.parseInt(f.getAttributeValue("id")));
    franquicia.setFormato(f.getAttributeValue("formato"));
    ArrayList<Coche> stock =  new ArrayList<>();
    Element eStock = f.getChild("stock");
    for (Element eCoche : eStock.getChildren()) {
      stock.add(crearCochedeElement(eCoche));
    }
    franquicia.setStockCoches(stock);

    return franquicia;
  }
  
  public Element crearElementFranquicia(Franquicia f) {
    Element franquicia = new Element("franquicia");
    franquicia.setAttribute("id",""+f.getId());
    franquicia.setAttribute("formato", f.getFormato());
    Element stock = new Element("stock");
    for (Coche c : f.getStockCoches()) {
      stock.addContent(crearCoche(c));
    }
    franquicia.addContent(stock);

    return franquicia;
  }

  public Element crearCoche(Coche c) {
    Element coche = new Element("coche");
    coche.setAttribute("matricula", c.getMatricula());
    coche.addContent(new Element("marca").setText(c.getMarca()));
    coche.addContent(new Element("modelo").setText(c.getModelo()));
    return coche;
  }

   public Coche crearCochedeElement(Element cCoche) {
    Coche coche = new Coche();
    coche.setMarca(cCoche.getChildText("marca"));
    coche.setModelo(cCoche.getChildText("modelo"));
    coche.setMatricula(cCoche.getAttributeValue("matricula"));
    return coche;
  }
}
