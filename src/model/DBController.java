/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import cryptohelper.Studente;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lorenzo
 */
public class DBController {
    private final static String DBurl = "jdbc:derby://localhost:1527/sample";
    private final static String DBuser = "app";
    private final static String DBpwd = "app";
    
    public static Studente analizeLogin(String user, String pwd){
        Studente student = null;
        try{
            Connection conn = DriverManager.getConnection( DBurl,  DBuser,  DBpwd);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM STUDENTE WHERE LOGIN ='"+user+"' AND PWD ='"+pwd+"'");
            String id, username, pass, nome, cognome;
            while(rs.next()){
                id = rs.getString("ID");
                username = rs.getString("LOGIN");
                pass = rs.getString("PWD");
                nome = rs.getString("NOME");
                cognome = rs.getString("COGNOME");
                student = new Studente(id, nome, cognome, username, pass);
            }        
        }catch(SQLException e){out.println(e);}
        return student;
    }
}
