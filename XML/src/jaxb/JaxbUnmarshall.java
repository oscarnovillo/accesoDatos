/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import datos.Persona;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author oscar
 */
public class JaxbUnmarshall {

  public static void main(String[] args) {
    try {

      File file = new File("jaxb.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Persona.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Persona customer = (Persona) jaxbUnmarshaller.unmarshal(file);
      System.out.println(customer);

    } catch (JAXBException e) {
      e.printStackTrace();
    }

  }
}
