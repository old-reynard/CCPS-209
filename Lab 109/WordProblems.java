import java.util.*;
import java.util.regex.Matcher;  
import java.util.regex.Pattern;  
/**
 * Java lab 9
 *
 * @author Nikita Gerasimov
 * @date 2018-02-05
 */
public class WordProblems
{
    public ArrayList<String> findMatchingWords(ArrayList<String> words, String pattern) { //
        //ArrayList<String> unmatched = createArrayList();
        ArrayList<String> matched = new ArrayList<String>();
        
        for (String s:words) {
            if (s.length() == pattern.length()) { 
            ArrayList<String> hasLetters = new ArrayList();
            for (int i = 0; i < s.length(); i++) { // find all the letters used in the pattern and pack them in an arraylist
                if (pattern.charAt(i) != '?' && !hasLetters.contains(Character.toString(s.charAt(i)))) {hasLetters.add(Character.toString(s.charAt(i)));}
            }
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (pattern.charAt(j) == '?') { // look for all the question marks and compare the corresponding characters in Word to the pattern
                    String thisChar = Character.toString(s.charAt(j));
                    if (hasLetters.contains(thisChar)) {count++;} 
                } else {
                    if (pattern.charAt(j) != s.charAt(j)) count++;
                }
            } if (count == 0 && !matched.contains(s)) {matched.add(s);} // if nothing has been found, add the word to the final arraylist;
        }  
    }   return matched;
    }
    
    public ArrayList<String> findSemordnilaps(ArrayList<String> words) { //

        ArrayList<String> result = new ArrayList<String>();
        Map<String, String> map = new HashMap<String, String>();
        for (String s: words) {map.put(s, s);}
        for (String s: words) {
            String reversed = "";
            for (int i=s.length()-1; i>=0; i--) {reversed += s.charAt(i);}
            //result.add(reversed);
            //int foundIndex = Collections.binarySearch(rev, reversed);
            //System.out.println(reversed + Integer.toString(foundIndex));
            //if (words.contains(reversed) && !reversed.equals(s)) result.add(reversed);
            if (map.containsKey(reversed) && !reversed.equals(s)) result.add(reversed);
        }
        
        return result;
    }
    
    public ArrayList<String> findAnagrams(ArrayList<String> words, String word) {

        ArrayList<String> result = new ArrayList<String>();
        Map <String, ArrayList> map = new HashMap<String, ArrayList>();
        ArrayList<String> dorw = new ArrayList<String>();
        for (int k = 0; k<word.length(); k++) {dorw.add(Character.toString(word.charAt(k)));}
        Collections.sort(dorw);
        map.put(word, dorw);

        for (String s:words) {
            if (s.length() == word.length()) {
                ArrayList<String> letters = new ArrayList<String>();
                for (int i = 0; i<s.length(); i++) {letters.add(Character.toString(s.charAt(i)));}
                Collections.sort(letters);
                map.put(s, letters);

            }
        }
        
        for (String s:words) {
            if (s.length() == word.length() && map.get(s).equals(map.get(word))) result.add(s);
        }
        
        return result;
    }
    
    public ArrayList<String> findMatchingWordsStar(ArrayList<String> words, String pattern) {

        ArrayList<String> result = new ArrayList<String>();
        String patternE = "";
        for (int i = 0; i<pattern.length(); i++) {
            if (pattern.charAt(i) == '*') {patternE = patternE + ".";}
            patternE += pattern.charAt(i);
        }
        
        for (String s:words) {
            Pattern p = Pattern.compile("\\b" + patternE + "\\b");
            Matcher m = p.matcher(s);
            if (m.matches()) {result.add(s);}
        }

    
        return result;
    }

}
