/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienteweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author profesor
 */
public class Main {

    public static void main(String[] args) {
        try {
            URL oracle = new URL("http://localhost:8080/mavenprojectWeb/NewServlet");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String headerName = null;
            String cookie = null;
            for (int i = 1; (headerName = yc.getHeaderFieldKey(i)) != null; i++) {
                if (headerName.equals("Set-Cookie")) {
                    cookie = yc.getHeaderField(i);
                    System.out.println(cookie);
                }
            }
            cookie = cookie.substring(0, cookie.indexOf(";"));
            String cookieName = cookie.substring(0, cookie.indexOf("="));
            String cookieValue = cookie.substring(cookie.indexOf("=") + 1, cookie.length());
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
            
            oracle = new URL("http://localhost:8080/mavenprojectWeb/NewServlet");
            yc = oracle.openConnection();
            String myCookie = cookieName+"="+cookieValue;
            
            yc.setRequestProperty("Cookie", myCookie);
            yc.connect();
            in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
