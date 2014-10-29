/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileWriter;  
import java.io.IOException;  
import org.jdom2.Attribute;  
import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.output.Format;  
import org.jdom2.output.XMLOutputter;  
/**
 *
 * @author oscar
 */
public class JdomCreateXMLExample {
  public static void main(String []args){
  
    try {
   // returns an xml element object  
      // school is passed to make it root element in document  
      Element school = new Element("school");

   // created an document object, all elements will be added to it  
      // passes school as parameter to make it root element of document  
      Document document = new Document(school);

      // created other element to add to document  
      Element student = new Element("student");

      // adding child attribute to student element  
      student.setAttribute(new Attribute("id", "1"));
      Element first = new Element("firstname");
      first.addContent(new Element("dentro").setText("thakur"));
     
       student.addContent(first);
      
      student.getChild("firstname").addContent(new Element("dentro2").setText("thakur"));
     
      student.addContent(new Element("lastname").setText("thakur"));
      student.addContent(new Element("email")
              .setText("beingjavaguy@gmail.com"));
      student.addContent(new Element("phone").setText("8788987656"));

      // get root element and added student element as a child of it  
      document.getRootElement().addContent(student);

      // get object to see output of prepared document  
      XMLOutputter xmlOutput = new XMLOutputter();
      // passsed System.out to see document content on console  
      xmlOutput.output(document, System.out);

      // passed fileWriter to write content in specified file  
      xmlOutput.setFormat(Format.getPrettyFormat());
      xmlOutput.output(document, new FileWriter(
              "school.xml"));

    } catch (IOException io) {
      System.out.println(io.getMessage());
    }
  }
}
