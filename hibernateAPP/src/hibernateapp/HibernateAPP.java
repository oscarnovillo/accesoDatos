/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateapp;

import hibernate.mapping.TiposUsuarios;
import hibernate.mapping.Usuarios;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.controller.TiposUsuariosJpaController;
import org.hibernate.Query;
import org.hibernate.Session;
import util.PasswordHash;

/**
 *
 * @author oscar
 */
public class HibernateAPP {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    	//testHibernate();
        testJPA();
    
  }
  
  public static void testHibernate()
  {
    Session session=null;
    try {
      //Get Session
      Usuarios usuario = new Usuarios("admin",new TiposUsuarios(1,""),PasswordHash.createHash("admin"));
      TiposUsuarios tp = new TiposUsuarios(5,"TEST1");
	
      session = hibernate.HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
                //Usuarios admin  = (Usuarios)session.get(Usuarios.class,"admin");
                //System.out.println(admin.getPassword());
                // System.out.println(admin.getTiposUsuarios().getDescripcion());
                 
                Query query =  session.createQuery("from TiposUsuarios");
                
                
                //System.out.println(PasswordHash.validatePassword("admin", admin.getPassword()));
                //admin.setTiposUsuarios(new TiposUsuarios(1,""));
                //session.update(admin);
		//session.save(usuario);

      
               
//      Transaction tx = session.beginTransaction();
//      
//      //Employee emp = (Employee) session.get(Employee.class, empId);
//      session.save(usuario);
//      tx.commit();
    } catch (NoSuchAlgorithmException ex) {
      Logger.getLogger(HibernateAPP.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InvalidKeySpecException ex) {
      Logger.getLogger(HibernateAPP.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally
    {
      		//Commit transaction
		session.getTransaction().commit();
                
    }
    
    //hibernate.HibernateUtil.close();
    
  }
  
  
  public static void testJPA()
          
  {
    try {
      String PERSISTENCE_UNIT_NAME = "hibernateAPPPU";
      EntityManagerFactory factory;
      factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
      TiposUsuariosJpaController tp = new TiposUsuariosJpaController(factory);
      tp.create(new jpa.TiposUsuarios(5,"testing"));
      
    } catch (Exception ex) {
      Logger.getLogger(HibernateAPP.class.getName()).log(Level.SEVERE, null, ex);
    }
     
     
         
  }
  
}
