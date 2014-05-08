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

    public Mappatura(char[] mapp, char[] inverseMapp){
        mappa = mapp;
        mappaInversa = inverseMapp;
    }
    
    public char[] getMappa() {
        return mappa;
    }

    public char[] getMappaInversa() {
        return mappaInversa;
    }
    
    public char map(char c){
        for(int i = 0; i < 26; i++){
            if(c == mappaInversa[i])
                return mappa[i];
        }
        return c;
    }
    
    public char inversMap(char c){
        for(int i = 0; i < 26; i++){
            if(c == mappa[i])
                return mappaInversa[i];
        }
        return c;
    }
}
