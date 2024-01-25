// Luca Callari
// TA: Trien Vuong
// Janurary 16, 2024
// Concealment
// This class allows the user to create a concealment cipher, and encrypt and decrypt strings 
// with said cipher

import java.util.*;

public class Concealment extends Cipher {
    
    // Instance variables

    private int filler;

    // Constructors

    // Creates a new concealment cipher with the given filler
    
    public Concealment(int filler) {
        if(filler<=0){
            throw new IllegalArgumentException();
        }
        this.filler=filler;
    }

    // Generates a random character in between the minimum and maximum, and returns
    // the selected char
    public char randomCharacter(){
        int randomNum = (int) (Math.random() * (Cipher.TOTAL_CHARS)) + Cipher.MIN_CHAR;
        return (char) randomNum;
    }

    // Given an input string, encrypts the input using a concealment cipher with the given filler
    // and returns the result as a string
    
    public String encrypt(String input) {
        String encrypt="";
        int inputCount=0;
        for(int i=1;i<=(input.length()*(filler+1));i++){
            if(i%(filler+1)==0){
                encrypt+=input.charAt(inputCount);
                inputCount++;
            } else {
                encrypt+=this.randomCharacter();
            }
        }
        return encrypt;
    }

    // Given an input string, decrypts the input using a concealment cipher with the given filler
    // and returns the result as a string
    
    public String decrypt(String input) {
        String decrypt="";
        for(int i=0;i<input.length();i++){
            if(i%(filler+1)==filler){
                decrypt+=input.charAt(i);
            } 
        }
        return decrypt;
    }
}
