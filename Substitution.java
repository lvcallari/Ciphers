// Luca Callari
// TA: Trien Vuong
// Janurary 16, 2024
// Substitution
// This class allows the user to create a substitution cipher, and encrypt and decrypt strings 
// with said cipher

public class Substitution extends Cipher {
    
    private String shifter;
    

    // Constructors

    // Creates a substitution cipher with an empty shifter
    public Substitution(){
        shifter = "";
    }

    // Creates a substitution cipher with the given shifter
    // Throws an illegal argument exception if the given shifter is an improper length,
    // contains duplicate letters, or contains letters that are out of range
    public Substitution(String shifter){
        if(this.checkException(shifter)){
            throw new IllegalArgumentException();
        }
        this.shifter = shifter;
    }

    // Methods

    // Checks to see if a given string contains duplicates, is out of range, or is the wrong length
    public boolean checkException(String shifter){
        if(shifter.length()!=Cipher.TOTAL_CHARS){
            return true;
        } 
        for(int i=0;i<shifter.length();i++){
            char checking = shifter.charAt(i);
            int occurences=0;
            if(checking>Cipher.MAX_CHAR || checking<Cipher.MIN_CHAR){
                return true;
            }
            for(int j=0;j<shifter.length();j++){
                if(checking==(shifter.charAt(j))){
                    occurences++;
                }
                if(occurences>1){
                    return true;
                }

            }
        }
        return false;
    }
    
    // Sets the current shifter with the given string
    // Throws an illegal argument exception if the given shifter is an improper length,
    // contains duplicate letters, or contains letters that are out of range
    public void setShifter(String shifter){
        if(this.checkException(shifter)){
            throw new IllegalArgumentException();
        }
        this.shifter = shifter;
    }

    // Creates and returns the given string as an array of chars

    public char[] toChar(String input){
        char[] array = new char[input.length()];
        for(int i=0;i<input.length();i++){
            array[i]=input.charAt(i);
        }

        return array;
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

    // encrypts the given string with a substitution cipher using the avaliable shifter
    // Throws an IllegalStateException if the shifter is null or empty

    public String encrypt(String input){
        if(shifter.length()<1 || shifter==null){
            throw new IllegalStateException();
        }
        String encrypt="";
        char[] shifterArray = this.toChar(shifter);
        char[] alphabetArray = this.alphabetArray();
        char[] inputArray = this.toChar(input);
        for(int i=0;i<inputArray.length;i++){
            int index = this.findInArray(inputArray[i], alphabetArray);
            encrypt+=String.valueOf(shifterArray[index]);
        }
        return encrypt;
    }

    // decrypts the given string with a substitution cipher using the avaliable shifter
    // Throws an IllegalStateException if the shifter is null or empty

    public String decrypt(String input){
        if(shifter.length()<1 || shifter==null){
            throw new IllegalStateException();
        }
        String decrypt="";
        char[] shifterArray = this.toChar(shifter);
        char[] alphabetArray = this.alphabetArray();
        char[] inputArray = this.toChar(input);
        for(int i=0;i<inputArray.length;i++){
            int index = this.findInArray(inputArray[i], shifterArray);
            decrypt+=String.valueOf(alphabetArray[index]);
        }
        return decrypt;
    }


}
