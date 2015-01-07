
import com.mycompany.mavenproject2.TiposUsuarios;
import com.mycompany.mavenproject2.TiposUsuariosJpaController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oscar
 */
public class Main {
  public static void main(String[] args) {
    testJPA();
  }
  
  public static void testJPA()
          
  {
    try {
      String PERSISTENCE_UNIT_NAME = "com.mycompany_mavenproject2_jar_1.0-SNAPSHOTPU";
      EntityManagerFactory factory;
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      TiposUsuariosJpaController tp = new TiposUsuariosJpaController(factory);
      tp.create(new TiposUsuarios(56,"testing"));
      
    } catch (Exception ex) {
      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
     
     
         
  }
}
