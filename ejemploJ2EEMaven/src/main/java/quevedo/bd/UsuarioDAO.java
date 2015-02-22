/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.bd;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.hibernate.Query;
import org.hibernate.Session;
import quevedo.hibernate.TiposUsuarios;
import quevedo.hibernate.Usuarios;

/**
 *
 * @author oscar
 */
public class UsuarioDAO {
  
  public ArrayList<String> getUsuarios()
  {
    ArrayList<String> lista = new ArrayList<>();
    try {
      InitialContext ctx = new InitialContext();
      //The JDBC Data source that we just created
      DataSource ds = (DataSource) ctx.lookup("jdbc/pepe");
      Connection connection = ds.getConnection();
      if (connection == null)
      {
        throw new SQLException("Error establishing connection!");
      }
      String query = "SELECT * FROM usuarios";

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                lista.add(rs.getString("login")) ;
            }
      
    } catch (NamingException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return lista;
  }
  
  
    public String testHibernate()
  {
    Session session=null;
    String pass= null;
    try {
      //Get Session
      Usuarios usuario = new Usuarios("admin",new TiposUsuarios(1,""),"admin");
      TiposUsuarios tp = new TiposUsuarios(5,"TEST1");
	
      session = quevedo.hibernate.NewHibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
                Usuarios admin  = (Usuarios)session.get(Usuarios.class,"admin");
		session.getTransaction().commit();
                
                pass = admin.getPassword();
    } catch (Exception ex) {
      Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    finally
    {
    }
    return pass;
  }
}
