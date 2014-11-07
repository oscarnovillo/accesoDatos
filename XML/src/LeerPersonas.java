
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import java.util.LinkedHashMap;

public class LeerPersonas {

    public static void main(String[] args) throws IOException {

        XStream xstream = new XStream();

        //xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        //xstream.alias("DatosPersona", Persona.class);
        //xstream.useAttributeFor(Persona.class, "coche");
        //xstream.addImplicitCollection(ListaPersonas.class, "lista");
        //xstream.registerConverter(new CocheConverter());
       // ListaPersonas listadoTodas = (ListaPersonas) xstream.fromXML(new FileInputStream("Personas.xml"));
        LinkedHashMap<String,Persona> listadoTodasMap = (LinkedHashMap) xstream.fromXML(new FileInputStream("Personas.xml"));

        //System.out.println("Numero de Personas: " + listadoTodas.getListaPersonas().size());

        List<Persona> listaPersonas = new ArrayList<Persona>();
       // listaPersonas = listadoTodas.getListaPersonas();

        Iterator iterador = listaPersonas.listIterator(); //Le solicito a la lista que me devuelva un iterador con todos los el elementos contenidos en ella
        while (iterador.hasNext()) {
            Persona p = (Persona) iterador.next(); //Obtengo el elemento contenido 
            System.out.println("Nombre: " + p.getNombre()
                    + ", edad: " + p.getEdad()
                    + ",coche " + p.getCoche());
        }
        System.out.println("Fin de listado .....");
    } //fin main
}//fin LeerPersonas 