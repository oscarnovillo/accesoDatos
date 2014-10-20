/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
* EDITADO FUERA
 */
package bd;

/**
 *
 * @author profesor
 */
public class Archivo {
    
    private String nombre;
    private boolean isDirectorio;
    private String path;
    private String parentPath;

    public Archivo(String nombre, boolean isDirectorio, String path, String parentPath) {
        this.nombre = nombre;
        this.isDirectorio = isDirectorio;
        this.path = path;
        this.parentPath = parentPath;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the isDirectorio
     */
    public boolean isIsDirectorio() {
        return isDirectorio;
    }

    /**
     * @param isDirectorio the isDirectorio to set
     */
    public void setIsDirectorio(boolean isDirectorio) {
        this.isDirectorio = isDirectorio;
    }


    @Override
    public String toString() {
        return nombre;
    }
    
    
    
}
