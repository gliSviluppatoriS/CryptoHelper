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
public interface CalcolatoreMappe {
    
    public CalcolatoreMappe create(String metodo);//da modello di progetto dovrebbe essere static ma i metodi static non possono stare in un interface 
    
    public Mappatura calcola(String chiave);
}
