/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package factoria.jaxb;

import datos.Compra;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dam2
 */
@XmlRootElement
public class Compras {
    private ArrayList<Compra> compras = null;

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
    
    public void addCompra(Compra c){
        compras.add(c);
    }
}
