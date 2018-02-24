import java.util.*;
public class VowelComparator implements Comparator<String>
{   
    @Override public int compare(String s1, String s2){
        if (countVowels(s1) == countVowels(s2)) {
            return reversed(s1).compareTo(reversed(s2));
        } else if (countVowels(s1) > countVowels(s2)){
            return 1;
        } else {
            return -1;
        }
    }
    
    public int countVowels(String s){
        int count = 0;
        for (int i = 0; i<s.length(); i++) {
           String letter = Character.toString(s.charAt(i));
           if ("AEIOUYaeiouy".contains(letter)) count++;
        } 
        return count;
    }
    
    public String reversed (String s) {
        StringBuilder sRev = new StringBuilder ();
        sRev.append(s).reverse();
        return sRev.toString();
    }
}
