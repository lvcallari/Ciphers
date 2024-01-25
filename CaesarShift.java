// Luca Callari
// TA: Trien Vuong
// Janurary 16, 2024
// Substitution
// This class allows the user to create a caesar shift cipher, and encrypt and decrypt strings 
// with said cipher

public class CaesarShift extends Cipher {
    
    // Instance Variables
    private int shift;

    // Constructors

    // Creates a new CeasarShift with the given shift
    public CaesarShift(int shift){
        if(shift<=0){
            throw new IllegalArgumentException();
        }
        this.shift=shift;
    }

    // Creates and returns the given string as an array of chars

    public char[] toChar(String input){
        char[] array = new char[input.length()];
        for(int i=0;i<input.length();i++){
            array[i]=input.charAt(i);
        }

        return array;
    }

    // Encrypts the given string using a caesarshift cipher and returns the result as a string

    public String encrypt(String input){
        char[] inputArray = this.toChar(input);
        String encrypt="";
        shift%=Cipher.TOTAL_CHARS;
        for(int i=0;i<inputArray.length;i++){
            char output = (char)(Cipher.MIN_CHAR + (inputArray[i] + shift - Cipher.MIN_CHAR) 
                                                                          % Cipher.TOTAL_CHARS);
            encrypt+=String.valueOf(output);
        }
        return encrypt;
    }

    // Decrypts the given string using a caesarshift cipher and returns the result as a string

    public String decrypt(String input){
        char[] inputArray = this.toChar(input);
        String encrypt="";
        shift%=Cipher.TOTAL_CHARS;
        for(int i=0;i<inputArray.length;i++){
            char output = (char)(Cipher.MIN_CHAR + 
            + (inputArray[i] - shift - Cipher.MIN_CHAR + Cipher.TOTAL_CHARS) % Cipher.TOTAL_CHARS);
            encrypt+=String.valueOf(output);
        }
        return encrypt;
    }
}
