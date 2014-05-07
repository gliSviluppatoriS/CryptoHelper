/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper;

import static java.lang.Integer.parseInt;

/**
 *
 * @author lorenzo
 */
public class CalcolatoreCesare extends CalcolatoreMappe{

    public CalcolatoreCesare() {
        
    }
    
    @Override
    public Mappatura calcola(String chiave){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int offset = parseInt(chiave);
        Mappatura map;
        char[] criptedAlphabet = new char[26];
        
        for(int i = 0; i< 26; i++){
            criptedAlphabet[i] = alphabet[i+offset%26];
        }
        map = new Mappatura(alphabet, criptedAlphabet);
        return map;
    }
}
