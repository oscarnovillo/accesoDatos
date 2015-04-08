/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienteweb;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/**
 *
 * @author profesor
 */
public class MainJsoup {
    
    
    public static void main(String[] args) {
        try {
            Connection.Response response = null;
//    Jsoup.connect("https://gestiona.madrid.org/wafd/ValidaUsuario.icm")
//        .method(Connection.Method.GET)
//        .execute();
            
            response = Jsoup.connect("http://localhost:8080/mavenprojectWeb/NewServlet")
                    //.cookies(response.cookies())
                    .data("pp","hh")
                    .data("hhh","ll")
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();
            
            Map m = response.cookies();
            
            System.out.println(response.body());
            
            response = Jsoup.connect("http://localhost:8080/mavenprojectWeb/NewServlet")
                    .cookies(m)
                    //.data("json",mapper.writeValueAsString(t))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .execute();
            
            System.out.println(response.body());
        } catch (IOException ex) {
            Logger.getLogger(MainJsoup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
