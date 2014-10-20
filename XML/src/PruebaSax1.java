import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class PruebaSax1 {		
	public static void main(String[] args)
	              throws FileNotFoundException, IOException,
	                        SAXException {		
		
	 XMLReader  procesadorXML = XMLReaderFactory.createXMLReader();
	 GestionContenido gestor= new GestionContenido();  
	 procesadorXML.setContentHandler(gestor);
 	 InputSource fileXML = new InputSource("alumnos.xml");	
	 procesadorXML.parse(fileXML);        	      
	}
}//fin PruebaSax1

class GestionContenido extends DefaultHandler {	 
	    public GestionContenido() {
	        super();
	    }
	    
	    public void startDocument() {
	        System.out.println("Comienzo del Documento XML");
	    }
	    
	    public void endDocument() {
	        System.out.println("Final del Documento XML");
	    }	 
	    
	    public void startElement(String uri, String nombre,
	              String nombreC, Attributes atts) {
	        System.out.println("\tPrincipio Elemento: " + nombre);	 	        
	    } 
	
	    public void endElement(String uri, String nombre,
	                                 String nombreC) {
	        System.out.println("\tFin Elemento: " + nombre);
	    }
		
		public void characters(char[] ch, int start, int length) throws SAXException {
		   String car=new String(ch, start, length);
		   car = car.replaceAll("[\t\n]","");//quitar saltos de línea		   
		   System.out.println ("\tCaracteres: " + car);		
	    }
}//fin GestionContenido

