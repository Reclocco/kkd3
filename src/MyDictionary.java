import java.util.*;

public class MyDictionary {
    private Dictionary<java.io.Serializable, Integer> dictionary;
    private int counter;
    private int wordSize;


    public MyDictionary(){
        dictionary = new Hashtable<>();
        counter = 0;
        wordSize = 9;

        for(int i=0; i<256; i++){
            dictionary.put(String.valueOf((char) i), i);
        }
        counter = 256;
    }

    public void addWord(String word){
        counter++;
        if((double) counter == Math.pow(2, wordSize)) {
            wordSize++;
        }

        dictionary.put(word, counter);
    }

    public String getWord(String word){
        try {
            return fitBit(word);
        } catch (NullPointerException e){
            addWord(word);
            return fitBit(word);
        }
    }

    public String fitBit(String word){
        StringBuilder fit = new StringBuilder(Integer.toBinaryString(dictionary.get(word)));

        int iter = wordSize-fit.length();
        for(int i=0; i<iter; i++) {
            fit.insert(0, "0");
        }

        return fit.toString();
    }
}
