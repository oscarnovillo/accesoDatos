
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXml {

    public static void main(String argv[]) throws IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Empleados", null);
            document.setXmlVersion("1.0"); // asignamos la version de nuestro XML

            Element elemento = document.createElement("empleado"); //nodo empleado
            document.getDocumentElement().appendChild(elemento);
            CrearElemento("id", "2", elemento, document); //añadir ID
            CrearElemento("apellido", "hh", elemento, document); //Apellido 
            CrearElemento("dep", "rr", elemento, document); //añadir DEP
            CrearElemento("salario", "sa", elemento, document); //SAL 


            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File("Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            
            
            
            Result console = new StreamResult(System.out);
            transformer.transform(source, console);


        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        
    }//de main

    //Inserci�n de los datos del empleado
    static void CrearElemento(String datoEmple, String valor,
            Element raiz, Document document) {
        Element elem = document.createElement(datoEmple); //creamos hijo
        Text text = document.createTextNode(valor); //damos valor
        raiz.appendChild(elem); //pegamos el elemento hijo a la raiz
        elem.appendChild(text); //pegamos el valor		 	
    }
}//de la clase

