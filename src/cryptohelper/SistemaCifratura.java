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
public class SistemaCifratura {
    private int id;
    private String chiave;
    private String metodo;
    private UserInfo creatore;
    private Mappatura map;

    public SistemaCifratura(String chiave, String metodo){
        this.chiave = chiave;
        this.metodo = metodo;
    }
    
    public SistemaCifratura(ResultSet rs){
        try{
            while(rs.next()){
                id = rs.getInt("IDCIFRATURA");
                chiave = rs.getString("CHIAVE");
                metodo = rs.getString("METODO");
            }
        }catch(SQLException e){System.out.println(e);}
    }
    
    public static Vector<SistemaCifratura> caricaSistemiCifratura(UserInfo stud){
        
    }
    
    
}
