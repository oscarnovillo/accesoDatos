
import java.io.Serializable;

public class Persona implements Serializable {

    private String nombre;
    private int edad;
    private Coche coche;

    public Persona(String nombre, int edad, Coche coche) {
        this.nombre = nombre;
        this.edad = edad;
        this.coche = coche;
    }

    public Persona() {
        this.nombre = null;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public void setEdad(int ed) {
        edad = ed;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}//fin Persona
