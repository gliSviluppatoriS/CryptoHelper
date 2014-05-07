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
public class CalcolatoreParolachiave extends CalcolatoreMappe{

    public CalcolatoreParolachiave() {
        
    }

    @Override
    public Mappatura calcola(String chiave){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Mappatura map;
        char[] criptedAlphabet = new char[26];
        boolean scarta;
        boolean found = false;
        int i = 0;
        int k = 0;
        int u = 0;
        
        chiave = chiave.toLowerCase();
        while(i < chiave.length()){                       //scorro la parola chiave lettera per lettera
            scarta = false;
            for(int j = 0; j< 26 && scarta == false; j++){ 
                if(chiave.charAt(i) == criptedAlphabet[j])//controllo se la lettera che sto prendendo in esame era doppia e quindi lavevo precedentemente inserita nell'array
                    scarta = true;                        //e dunque se la trovo metto scarta (letera) a true
            }
            if(scarta == false){                          //se la lettera non è da scartare la inserisco nell'array criptedAlphabet
                criptedAlphabet[k] = chiave.charAt(i);
                k++;
            }
            i++;
        }
        
        while(u< 26 && found == false){                   //scorro alphabet per trovare l'indice della lettera che nell'alfabeto segue l'ultima lettera che avevo inserito nell'array criptedAlphabet quando controllavo la parola chiave
            if(criptedAlphabet[k-1] == alphabet[u])       //se trovo l'ultima lettera che avevo inserito setto found a true
                found = true;                             //in questo modo esco dal ciclo con all'interno di u l'indice della lettera che segue nell'alfabeto l'ultima inserita in  criptedAlphabet
            u++;
        }
            
        while(k< 26){                                     //ciclo finchè non ho finito di riempire l'array criptedAlphabet
            scarta = false;
            for(int j = 0; j< 26 && scarta == false; j++){
                if(alphabet[u%26] == criptedAlphabet[j])  //controllo che una l'ettera dell'alfabeto non fosse già stata inserita precedentemente, nel caso la scarto
                    scarta = true;
            }
            if(scarta == false){
                criptedAlphabet[k] = alphabet[u%26];
                k++;
            }
            u++;
        }
        map = new Mappatura(alphabet, criptedAlphabet);
        return map;   
    } 
}
