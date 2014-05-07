/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper;

import java.sql.ResultSet;

/**
 *
 * @author lorenzo
 */

public class Proposta {
    private String stato;
    private UserInfo proponente;
    private UserInfo partner;
    private SistemaCifratura proposta;
    
    public Proposta(ResultSet queryResult){
        
    }
    public Proposta(UserInfo prop, UserInfo part, SistemaCifratura sdc){
        proponente = prop;
        partner = part;
        proposta = sdc;
        stato = null;
    }
    
    public static Proposta caricaAttiva(int idProp, int idPart){
        return null;
    }
    
    public void salva(){
        
    }
}
