package quevedo.hibernate;
// Generated 22-feb-2015 13:48:13 by Hibernate Tools 4.3.1



/**
 * DatosDirecciones generated by hbm2java
 */
public class DatosDirecciones  implements java.io.Serializable {


     private String login;
     private String calle;
     private String portal;
     private String codigoPostal;
     private String piso;
     private String puerta;

    public DatosDirecciones() {
    }

	
    public DatosDirecciones(String login) {
        this.login = login;
    }
    public DatosDirecciones(String login, String calle, String portal, String codigoPostal, String piso, String puerta) {
       this.login = login;
       this.calle = calle;
       this.portal = portal;
       this.codigoPostal = codigoPostal;
       this.piso = piso;
       this.puerta = puerta;
    }
   
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getPortal() {
        return this.portal;
    }
    
    public void setPortal(String portal) {
        this.portal = portal;
    }
    public String getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getPiso() {
        return this.piso;
    }
    
    public void setPiso(String piso) {
        this.piso = piso;
    }
    public String getPuerta() {
        return this.puerta;
    }
    
    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }




}


