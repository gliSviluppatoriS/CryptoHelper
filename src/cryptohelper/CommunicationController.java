/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper;

import java.util.Vector;

/**
 *
 * @author alfredo
 */
public class CommunicationController {
    
    public static void send (Messaggio msg){
        
    }
    
    public static Vector<UserInfo> getDestinatari(Studente usr){
        return null;        
    } 
    
    public static void inviaProposta(Studente usr, UserInfo partner, SistemaCifratura sdc){
    } 
    
    public static Vector<Proposta> getAccettazione(Studente usr){
        return null;        
    } 
    
    public static Vector<Proposta> getProposte(Studente usr){
        return null;        
    } 
    
    public static void inviaDecisione (Proposta prop, String dec){
        
    }
    public static Messaggio apriMessaggioRicevuto(int id){
        return null;
    }
    
}
