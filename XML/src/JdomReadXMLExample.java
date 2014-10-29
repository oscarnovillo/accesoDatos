
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;  
import java.io.IOException;  
import java.util.List;  
  
import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.JDOMException;  
import org.jdom2.input.SAXBuilder;  

/**
 *
 * @author oscar
 */
public class JdomReadXMLExample {
  
  
  
  public static void main(String[] args)
  {
// reading can be done using any of the two 'DOM' or 'SAX' parser  
  // we have used saxBuilder object here  
  // please note that this saxBuilder is not internal sax from jdk  
     SAXBuilder saxBuilder = new SAXBuilder();  
       
     // obtain file object   
     File file = new File("students.xml");  
  
  try {  
   // converted file to document object  
   Document document = saxBuilder.build(file);  
   Object o = document.getProperty("1");
   // get root node from xml  
   Element rootNode = document.getRootElement();  
   
   
   // got all xml elements into a list  
      List<Element> studentList = rootNode.getChildren("student");  
        
      // simple iteration to see the result on console  
      for(int i=0;i<=studentList.size()-1;i++){  
       Element element = studentList.get(i);  
       
       System.out.println("id "+element.getAttributeValue("id"));
       System.out.println("First Name : "+element.getChildText("firstname"));  
       System.out.println("Last Name : "+element.getChildText("lastname"));  
       System.out.println("Email : "+element.getChildText("email"));  
       System.out.println("Phone : "+element.getChildText("phone"));  
      }  
       
  } catch (JDOMException e) {  
   // TODO Auto-generated catch block  
   e.printStackTrace();  
  } catch (IOException e) {  
   // TODO Auto-generated catch block  
   e.printStackTrace();  
  }    
  
  }
  
  
}
