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
public class Mappatura {
    private char[] mappa = new char[26];
    private char[] mappaInversa = new char[26];

    public char[] getMappa() {
        return mappa;
    }

    public char[] getMappaInversa() {
        return mappaInversa;
    }
    
    public char map(char c){
        return c;
    }
    
    public char inversMap(char c){
        return c;
    }
}
