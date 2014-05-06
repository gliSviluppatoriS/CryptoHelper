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
            int id;
            String username, pass, nome, cognome;
            while(rs.next()){
                id = rs.getInt("ID");
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

            System.out.println("Sto inserendo uno studente nel DB..");
            String dati = "('"+user+"','"+pwd+"','"+nome+"','"+cognome+"')";
            System.out.println(dati);
            st.executeUpdate("INSERT INTO STUDENTE (LOGIN,PWD,NOME,COGNOME) VALUES "+ dati);
            ResultSet rs = st.executeQuery("SELECT ID FROM STUDENTE WHERE LOGIN ='"+user+"'");
            rs.next();
            int id_stud=rs.getInt("ID");
            st.close();
            conn.close();
            System.out.println("Ho caricato: " + dati);
            student = new Studente(id_stud, nome, cognome, user, pwd);
        }catch(SQLException e){out.println(e);}
        return student;
    }
    
    public static void creaTabellaStudente() throws SQLException { //Se non catturo eccezione devo fare throw
        Connection conn = DriverManager.getConnection(DBurl,  DBuser,  DBpwd);
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE STUDENTE"); //Rimuovo da DB la tabella se esiste già
        } catch (SQLException e){
            System.out.println(e.getMessage() + ": no problem");
        }
        st.executeUpdate("CREATE TABLE STUDENTE" +  //creo la tabella
                "(ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                "LOGIN VARCHAR(30) NOT NULL UNIQUE, " + 
                "PWD VARCHAR(30) NOT NULL, "  +
                "NOME VARCHAR(30) NOT NULL, "  +
                "COGNOME VARCHAR(30) NOT NULL)"
                );
        
        st.close();//chiudo statement (non serve più)
        conn.close(); //chiusura connessione
        System.out.println("Table STUDENTE creata.");
 
    }
    
    public static void creaTabellaDestinatario() throws SQLException { //Se non catturo eccezione devo fare throw
        Connection conn = DriverManager.getConnection(DBurl,  DBuser,  DBpwd);
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE DESTINATARIO"); //Rimuovo da DB la tabella se esiste già
        } catch (SQLException e){
            System.out.println(e.getMessage() + ": no problem");
        }
        st.executeUpdate("CREATE TABLE DESTINATARIO" +  //creo la tabella
                "(IDDESTINATARIO INTEGER NOT NULL," +
                "IDMESSAGGIO INTEGER NOT NULL, " + 
                "PRIMARY KEY(IDDESTINATARIO,IDMESSAGGIO))"
                );
        
        st.close();//chiudo statement (non serve più)
        conn.close(); //chiusura connessione
        System.out.println("Table DESTINATARIO creata.");
 
    }
    
    public static void creaTabellaMittente() throws SQLException { //Se non catturo eccezione devo fare throw
        Connection conn = DriverManager.getConnection(DBurl,  DBuser,  DBpwd);
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE MITTENTE"); //Rimuovo da DB la tabella se esiste già
        } catch (SQLException e){
            System.out.println(e.getMessage() + ": no problem");
        }
        st.executeUpdate("CREATE TABLE MITTENTE" +  //creo la tabella
                "(IDMITTENTE INTEGER NOT NULL," +
                "IDMESSAGGIO INTEGER NOT NULL, " + 
                "PRIMARY KEY(IDMITTENTE,IDMESSAGGIO))"
                );
        
        st.close();//chiudo statement (non serve più)
        conn.close(); //chiusura connessione
        System.out.println("Table MITTENTE creata.");
 
    }
    
    public static void creaTabellaMessaggio() throws SQLException { //Se non catturo eccezione devo fare throw
        Connection conn = DriverManager.getConnection(DBurl,  DBuser,  DBpwd);
        Statement st = conn.createStatement();
        try {
            st.execute("DROP TABLE MESSAGGIO"); //Rimuovo da DB la tabella se esiste già
        } catch (SQLException e){
            System.out.println(e.getMessage() + ": no problem");
        }
        st.executeUpdate("CREATE TABLE MESSAGGIO" +  //creo la tabella
                "(IDMESSAGGIO INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, " +
                "TESTOMSG VARCHAR(500) NOT NULL, " + 
                "TESTOCIFRATO VARCHAR(500) NOT NULL, "  +
                "LINGUAMSG VARCHAR(30) NOT NULL, "  +
                "TITOLOMSG VARCHAR(50) NOT NULL, "  + 
                "BOZZAMSG VARCHAR(500) NOT NULL)"
                );
        
        st.close();//chiudo statement (non serve più)
        conn.close(); //chiusura connessione
        System.out.println("Table MESSAGGIO creata.");
 
    }
    
    public static void main(String[] args) {    
       
//        try { // creazione tabella UTENTI in DB
//            creaTabellaStudente();
//        } catch (SQLException e) {System.out.println(e.getMessage());}
        try { // creazione tabella UTENTI in DB
            creaTabellaMessaggio();
        } catch (SQLException e) {System.out.println(e.getMessage());}
        try { // creazione tabella UTENTI in DB
            creaTabellaDestinatario();
        } catch (SQLException e) {System.out.println(e.getMessage());}
        try { // creazione tabella UTENTI in DB
            creaTabellaMittente();
        } catch (SQLException e) {System.out.println(e.getMessage());}
    }
}
