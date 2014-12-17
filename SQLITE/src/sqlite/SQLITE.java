/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlite.bd.GestorBD;

/**
 *
 * @author profesor
 */
public class SQLITE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GestorBD gestor =new GestorBD();
        Connection connection = null;
        try
        {
        //gestor.connect();
        connection = DriverManager.getConnection("jdbc:sqlite:./bd/practica");
        gestor.saveCliente(connection);
        gestor.mostrarClientes();
        }
        catch(Exception e){}
        finally{
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLITE.class.getName()).log(Level.SEVERE, null, ex);
            }
       
        }
    }
    
    
    
    
}
