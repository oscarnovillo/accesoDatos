/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quevedo.bd;

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
  
}
