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
public class CalcolatorePseudocasuale extends CalcolatoreMappe{

    public CalcolatorePseudocasuale() {
        
    }
    
    @Override
    public Mappatura calcola(String chiave){
            char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
            Mappatura map;
            char[] CriptedAlphabet1 = {'z','a','q','x','s','w','c','d','e','v','f','r','b','g','t','n','h','y','m','j','u','k','i','l','o','p'};
            char[] CriptedAlphabet2 = {'m','q','a','j','z','u','i','o','l','p','k','w','s','x','f','d','h','y','e','c','b','n','r','t','v','g'};
            char[] CriptedAlphabet3 = {'q','w','e','r','t','y','u','i','o','p','l','k','j','h','g','f','d','s','a','z','x','c','v','b','n','m'};
            
            switch(chiave){
            case  "1":
                map = new Mappatura(alphabet, CriptedAlphabet1);
            break;
            case  "2":
                map = new Mappatura(alphabet, CriptedAlphabet2);
            break;
            default:
                map = new Mappatura(alphabet, CriptedAlphabet3);
        }
        return map;
    }
}

