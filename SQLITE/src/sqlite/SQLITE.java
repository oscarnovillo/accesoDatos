/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite;

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
        gestor.connect();
        gestor.saveCliente();
        gestor.close();
    }
    
    
    
    
}
