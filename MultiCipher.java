// Luca Callari
// TA: Trien Vuong
// Janurary 16, 2024
// Substitution
// This class allows the user to use multiple ciphers in combination to encrypt and decrypt strings

import java.util.*;

public class MultiCipher extends Cipher {
    
    // Instance variables

    private List<Cipher> ciphers;

    // Constructors

    // Constructs a new multicipher object with the given list of ciphers
    // throws an illegal argument exception if the given list is null
    public MultiCipher(List<Cipher> ciphers){
        if(ciphers == null){
            throw new IllegalArgumentException();
        }
        this.ciphers=ciphers;
    }

    // Methods

    // Encrypts the given string using the list of ciphers in order
    // Returns a string of the encrypted original string
    public String encrypt(String input){
        String curr=input;
        for(int i=0;i<ciphers.size();i++){
            curr=ciphers.get(i).encrypt(curr);
        }
        return curr;
    }

    // Decrypts the given string using the list of ciphers in reverse order
    // Returns a string of the decrypted original string
    public String decrypt(String input){
        String curr=input;
        for(int i=ciphers.size()-1;i>-1;i--){
            curr=ciphers.get(i).decrypt(curr);
        }
        return curr;
    }
}
