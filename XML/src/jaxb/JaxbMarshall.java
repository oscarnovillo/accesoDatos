/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import datos.Coche;
import datos.Persona;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

/**
 *
 * @author oscar
 */
public class JaxbMarshall {

  public static void main(String[] args) {
    Persona p = new Persona(1, "nombre", 12, new Coche("marca", "modelo", 100));
    ArrayList<Persona> a = new ArrayList<>();
    a.add(p);

    try {

      File file = new File("jaxb.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Persona.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      // output pretty printed
      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		//jaxbMarshaller.marshal(p, file);
      jaxbMarshaller.marshal(new JAXBElement(new QName("", "personas"), ArrayList.class, a), file);

		//jaxbMarshaller.marshal(p, System.out);
    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }

}
