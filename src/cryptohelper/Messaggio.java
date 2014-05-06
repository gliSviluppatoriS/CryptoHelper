/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper;

import java.sql.*;
import java.util.Vector;

/**
 *
 * @author lorenzo
 */
public class Messaggio {
    private int id;
    private String testo;
    private String testoCifrato;
    private String lingua;
    private String titolo;
    private boolean bozza;
    private UserInfo mittente;
    private UserInfo destinatario;
    private SistemaCifratura sisCif;
    
    
    public Messaggio(ResultSet rs){
        try {
            while(rs.next()){
                id = rs.getInt("IDMESSAGGIO");
                testo = rs.getString("TESTOMSG");
                testoCifrato = rs.getString("TESTOCIFRATO");
                lingua = rs.getString("LINGUAMSG");
                titolo = rs.getString("TITOLOMSG");
                bozza = rs.getBoolean("BOZZAMGS");
            }
        }catch(SQLException e){System.out.println(e);}
    }
    
    public static Messaggio load(String id){
        return null;
    }
    
    public static Vector<Messaggio> caricaInviati(UserInfo mittente){
        return null;
    }
    
    public static Vector<Messaggio> caricaBozze(UserInfo mittente){
        return null;
    }
    
    public static Vector<Messaggio> caricaRicevuti(UserInfo destinatario){
        return null;
    }
    
    public boolean elimina(){
        return false;
    }
    
    public boolean salva(){
        return false;
    }
    
    public void cifra(){
        
    }
    
    public void send(){
        
    }
}
