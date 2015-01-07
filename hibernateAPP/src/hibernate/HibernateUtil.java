/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author oscar
 */
public class HibernateUtil {

  private static SessionFactory sessionFactory;
  private static ServiceRegistry serviceRegistry;

//  static {
//    try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml) 
//      // config file.
//      Configuration cfg = new Configuration();
//      cfg.configure();
//      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
//      sessionFactory = cfg.buildSessionFactory(serviceRegistry);
//    } catch (Throwable ex) {
//      // Log the exception. 
//      System.err.println("Initial SessionFactory creation failed." + ex);
//      throw new ExceptionInInitializerError(ex);
//    }
//  }

      private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	Configuration configuration = new Configuration();
        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("Hibernate Configuration loaded");
        	
        	serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        	System.out.println("Hibernate serviceRegistry created");
        	
        	SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        	
            return sessionFactory;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
  
  	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }
        
        
    public static void close()
    {//StandardServiceRegistryBuilder.destroy(serviceRegistry);
      sessionFactory.close();
      
    }
}
