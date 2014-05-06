/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper;

/**
 *
 * @author lorenzo
 */
public abstract class CalcolatoreMappe {
    
    public  static  CalcolatoreMappe create(String metodo){
        return null;
}
    
    public abstract Mappatura calcola(String chiave);
}
