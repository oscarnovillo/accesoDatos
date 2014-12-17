/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author profesor
 */
public class GestorBD {

    String url = "./bd/practica";
    Connection connect;
    Properties props;

    public void connect()  {
        try {
            
                //Context ctx = new InitialContext();
//                 props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
//    props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");
//    InitialContext ctx = new InitialContext(props);
//    
//    
//    org.sqlite.SQLiteDataSource ds = (SQLiteDataSource) ctx.lookup("java:comp/env/jdbc/sqlite");
//   ds.setUrl("jdbc:sqlite:" + url);
//    connect = ds.getConnection();
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");
            }
        } catch (Exception ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    
    public void crearTransaccion()
    {
        try {
            connect.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void close() {
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void saveCliente(Connection connect){
        try {
         
            PreparedStatement st = connect.prepareStatement(
                    "insert into clientes (nombre) values (?)");
            st.setString(1, "paco");
            int filas= st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }
     
      public void mostrarClientes(){
        ResultSet result = null;
        try {
            PreparedStatement st = connect.prepareStatement(
                    "select * from clientes");
            result = st.executeQuery();

            while (result.next()) {
                System.out.print("ID: ");
                System.out.println(result.getInt("id"));

                System.out.print("Nombre: ");
                System.out.println(result.getString("nombre"));

   

                System.out.println("=======================");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
