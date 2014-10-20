import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class LecturaEmpleadoXml {
 public static void main(String argv[]) {
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  try {
	 
	  DocumentBuilder builder = factory.newDocumentBuilder();
	  Document document = builder.parse(new File("Documento1.xml"));
	  document.getDocumentElement().normalize();

	  System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());
	  Element empleado = document.getElementById("hol");
          System.out.println(empleado.getTextContent());

//	  for (int i = 0; i < empleados.getLength(); i ++) {
//
//	    Node emple = empleados.item(i);
//
//	    if (emple.getNodeType() == Node.ELEMENT_NODE) {
//
//            Element elemento = (Element) emple;
//
//            System.out.println("ID: " + getNodo("id", elemento));
//            System.out.println("Apellido: " + getNodo("apellido", elemento));
//            System.out.println("Departamento: " + getNodo("dep", elemento));
//			System.out.println("Salario: " + getNodo("salario", elemento));
//
//	    }
 //   }
  } catch (Exception e) { e.printStackTrace();}
 }//fin de main
 
 //obtener la información de un nodo
 private static String getNodo(String etiqueta, Element elem)
 {
	  NodeList nodo= elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
	  Node valornodo = (Node) nodo.item(0);
	  return valornodo.getNodeValue();
 }
}//fin de la clase
