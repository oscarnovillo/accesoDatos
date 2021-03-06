
import datos.Coche;
import datos.Persona;
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;



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

        LinkedHashMap<String,Persona> lhm = new LinkedHashMap<>();
        //Creamos un objeto Lista de Personas
        ListaPersonas listaper = new ListaPersonas();
        Persona persona = (Persona) new Persona(1,"pedro", 10,new Coche("ford","focus",120)); //leer una Persona     
        lhm.put(""+persona.getId(), persona);
        listaper.add(persona);
        persona = (Persona) new Persona(2,"sedro", 15,new Coche("citroen","C4",125)); //leer una Persona     
        lhm.put(""+persona.getId(), persona);
        listaper.add(persona);
        persona = (Persona) new Persona(3,"fedro", 30,new Coche("renault","megane",110)); //leer una Persona     
        lhm.put(""+persona.getId(), persona);
 listaper.add(persona);
 
        try {
            XStream xstream = new XStream();
            //cambiar de nombre a las etiquetas XML
            //xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            //xstream.alias("DatosPersona", Persona.class);
            //xstream.omitField(Persona.class, "coche");
            //xstream.useAttributeFor(Persona.class, "coche");
            //xstream.useAttributeFor(Persona.class, "id");
            //quitar etiwueta lista (atributo de la clase ListaPersonas)
            //xstream.addImplicitCollection(ListaPersonas.class, "lista");
            //xstream.addImplicitMap(LinkedHashMap.Class, null, null, null);
            //Insrtar los objetos en el XML
            //xstream.registerConverter(new CocheConverter());
            xstream.toXML(lhm, new FileOutputStream("Personas.xml"));
            System.out.println("Creado fichero XML....");
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // fin main
} //fin EscribirPersonas
