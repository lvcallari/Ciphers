// Luca Callari
// TA: Trien Vuong
// Janurary 16, 2024
// Substitution
// This class allows the user to create a caesar key cipher, and encrypt and decrypt strings 
// with said cipher

import java.util.*;

public class CaesarKey extends Cipher {
    
    // instance variables
    private String key;

    // Constructors

    // Creates a new Caesar Key object with the given key
    // Throws an illegalargumentexception if  the key is empty, 
    // it contains a character outside our range of valid characters, or it contains any 
    // duplicate characters
    public CaesarKey(String key){
        if(this.checkException(key)){
            throw new IllegalArgumentException();
        }
        this.key = key;
    }

    // Methods

    // Checks to see if a given string contains duplicates, is out of range, or is the wrong length
    public boolean checkException(String input){
        if(input.length()==0){
            return true;
        }
        for(int i=0;i<input.length();i++){
            char checking = input.charAt(i);
            int occurences=0;
            if(checking>Cipher.MAX_CHAR || checking<Cipher.MIN_CHAR){
                return true;
            }
            for(int j=0;j<input.length();j++){
                if(checking==(input.charAt(j))){
                    occurences++;
                }
                if(occurences>1){
                    return true;
                }

            }
        }
        return false;
    }

    // Creates and returns the given string as an array of chars

    public char[] toChar(String input){
        char[] array = new char[input.length()];
        for(int i=0;i<input.length();i++){
            array[i]=input.charAt(i);
        }

        return array;
    }

    // Creates and returns an arraylist of the newly shifted key

    public List<Character> shiftedList(String key){
        List<Character> translation = new ArrayList<Character>();
        for(int i=Cipher.MIN_CHAR;i<=Cipher.MAX_CHAR;i++){
            translation.add((char) i);
        }
        char[] keyArray = this.toChar(key);
        for(int i=keyArray.length-1;i>-1;i--){
            for(int j=0;j<translation.size();j++){
                if(keyArray[i]==translation.get(j)){
                    char curr = translation.remove(j);
                    translation.add(0, curr);
                }
            }
        }
        return translation;
    }

    // Given a char, finds the index of where it appears in the given array
    // Returns the index as an int

    public int findInArray(char letter, char[] array){
        int index=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==letter){
                index=i;
            }
        }
        return index;
    }

    // Given a char, finds the index of where it appears in the given arraylist
    // Returns the index as an int

    public int findInArrayList(char letter, List<Character> array){
        int index=0;
        for(int i=0;i<array.size();i++){
            if(array.get(i).equals(letter)){
                index=i;
            }
        }
        return index;
    }

    // Creates and returns a char array of all the letters in the alphabet in order

    public char[] alphabetArray(){
        char[] alphabet = new char[Cipher.TOTAL_CHARS];
        int count = 0;
        for(int i=Cipher.MIN_CHAR;i<=Cipher.MAX_CHAR;i++){
            alphabet[count]=(char) i;
            count++;
        }
        return alphabet;
    }

    // Given the input of a string, encrypts the given input using a caesar key cipher
    // Returns the encrypted output as a string

    public String encrypt(String input){
        List<Character> encrypter = this.shiftedList(key);
        char[] inputChar = this.toChar(input);
        char[] alphabet = this.alphabetArray();
        String encrypt="";
        for(int i=0;i<inputChar.length;i++){
            int index = this.findInArray(inputChar[i], alphabet);
            encrypt+=String.valueOf(encrypter.get(index));
        }
        return encrypt;
    }

    // Given the input of a string, decrypts the given input using a caesar key cipher
    // Returns the decrypted output as a string

    public String decrypt(String input){
        List<Character> encrypter = this.shiftedList(key);
        char[] inputChar = this.toChar(input);
        char[] alphabet = this.alphabetArray();
        String decrypt="";
        for(int i=0;i<inputChar.length;i++){
            int index = this.findInArrayList(inputChar[i], encrypter);
            decrypt+=String.valueOf(alphabet[index]);
        }
        return decrypt;
    }
}
