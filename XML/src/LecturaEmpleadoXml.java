
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class LecturaEmpleadoXml {

    public static void main(String argv[]) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("Documento1.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Elemento raíz: " + document.getDocumentElement().getNodeName());

            // para sacar atributos
            System.out.println(document.getDocumentElement().getAttribute("id"));


            // coger lista de elementos
            NodeList deportistas = document.getDocumentElement()
                    .getElementsByTagName("deportista");
            for (int i = 0; i < deportistas.getLength(); i++) {
                Node deporte = deportistas.item(i);

                System.out.println(deporte.getNodeName() + deporte.getNodeType()
                        + deporte.getNodeValue() + "\n TextContent" + deporte.getTextContent());

                if (deporte.getNodeType() == Node.ELEMENT_NODE) {
                    Element eDeporte = (Element) deporte;
                    System.out.println(eDeporte.getAttribute("attr"));
                    System.out.println(getNodo("deporte", eDeporte));
                    System.out.println(getNodo("nombre", eDeporte));
                }
            }



            // Para que funcione tiene que haber DTD o Schema que defina atributo de tipo ID
            // sirve para coger un elemento concreto.
            Element deportista = document.getElementById("1");
            System.out.println(deportista.getTextContent());

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

            Element raiz = document.getDocumentElement();
            navegarXML(raiz);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//fin de main

    private static void navegarXML(Node e) throws Exception {
        if (e.hasChildNodes()) {
            NodeList list = e.getChildNodes();
            for (int i=0; i< list.getLength();i++)
            {
                Node n = list.item(i);
                System.out.println(n.getNodeName()+n.getNodeType()+n.getNodeValue());
                if (n.hasChildNodes())
                {
                    navegarXML(n);
                }
            }
        }




    }

//obtener la información de un nodo
    private static String getNodo(String etiqueta, Element elem) {
        NodeList nodo = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
//return elem.getElementsByTagName(etiqueta).item(0).getTextContent();
        Node valornodo = (Node) nodo.item(0);
        return valornodo.getNodeValue();
    }
}//fin de la clase
