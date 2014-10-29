
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;



class CocheConverter implements SingleValueConverter {

    @Override
    public String toString(Object o) {
        return ((Coche) o).toString();
    }

    @Override
    public Object fromString(String valor) {
         return new Coche(valor); 
    }

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Coche.class);
    }
}

public class EscribirPersonas {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Creamos un objeto Lista de Personas
        ListaPersonas listaper = new ListaPersonas();
        Persona persona = (Persona) new Persona("pedro", 10,new Coche("ford","focus",120)); //leer una Persona     
        listaper.add(persona);
        persona = (Persona) new Persona("sedro", 15,new Coche("citroen","C4",125)); //leer una Persona     
        listaper.add(persona);
        persona = (Persona) new Persona("fedro", 30,new Coche("renault","megane",110)); //leer una Persona     
 listaper.add(persona);
 
        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            xstream.alias("DatosPersona", Persona.class);
            xstream.useAttributeFor(Persona.class, "coche");
            //quitar etiwueta lista (atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaPersonas.class, "lista");
            //Insrtar los objetos en el XML
            xstream.registerConverter(new CocheConverter());

            xstream.toXML(listaper, new FileOutputStream("Personas.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // fin main
} //fin EscribirPersonas
