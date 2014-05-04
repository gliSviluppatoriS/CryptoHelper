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
import java.util.Random;

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
            st.close();
            conn.close();
        }catch(SQLException e){out.println(e);}
        return student;
    }
    
    public static Studente inserisciStudente(String user, String pwd, String nome, String cognome){
        Studente student = null;
        try{
            Connection conn = DriverManager.getConnection( DBurl,  DBuser,  DBpwd);
            Statement st= conn.createStatement();
            Random generatore = new Random();
            int id_stud = 0;
            int temp; //temp per confrontare i random gia in tabella con quello nuovo
            boolean isInTable=false; //per testare se il numero generato e gia in tabella
            boolean ricontrolla=true; //per ricontrollare se io numero assegnato e in tabella
            ResultSet rs = st.executeQuery("SELECT ID FROM STUDENTE");

            while(ricontrolla) {//finche genero un nuovo random devo controllare se e gia in tabella
                id_stud = generatore.nextInt(1000); //generazione numero random
                while(rs.next() && isInTable != true) {
                    temp = rs.getInt("ID");
                    if(temp==id_stud) //se il numero generato era gia in tabella
                        isInTable=true;
                }
                if(isInTable != true || id_stud!=0)
                    ricontrolla=false;
                else{
                    isInTable=false;
                    rs.beforeFirst();
                }
            }
            System.out.println("Sto inserendo uno studente nel DB..");
            String dati = "('"+id_stud+"','"+user+"','"+pwd+"','"+nome+"','"+cognome+"')";
            System.out.println(dati);
            st.executeUpdate("INSERT INTO STUDENTE (ID,LOGIN,PWD,NOME,COGNOME) VALUES "+ dati);
            st.close();
            conn.close();
            System.out.println("Ho caricato: " + dati);
            student = new Studente(id_stud+"", nome, cognome, user, pwd);
        }catch(SQLException e){out.println(e);}
        return student;
    }
}
