import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.*;
import java.util.zip.Adler32;

public class TestWordProblems {
    
    private WordProblems wp = new WordProblems();
    private static final int SEED = 12345;
    private static final int MATCHRUNS = 100;
    private static final int ANARUNS = 300;
    private static ArrayList<String> words = new ArrayList<String>();
    
    private static void readWords() {
        if(words.size() > 0) { return; }
        try {
            Scanner s = new Scanner(new File("words.txt"));
            while(s.hasNextLine()) {
                String word = s.nextLine();
                boolean isGood = true;
                for(int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if(c < 'a' || c > 'z') { isGood = false; break; }
                }
                if(isGood) { words.add(word); }
            }
        } catch(Exception e) {
            System.out.println("Failed to read file 'words.txt': " + e);
        }
        assertTrue(words.size() > 100000);
        System.out.println("Read " + words.size() + " words from words.txt.");
    }
    
    private char randomChar(Random rng, char spec) {
        if(rng.nextDouble() < 0.2) { return spec; }
        else { return (char)('a' + rng.nextInt(26)); }
    }
    
    private String buildString(Random rng, int len, char spec) {
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < len; j++) {
            sb.append(randomChar(rng, spec));
        }
        return sb.toString();
    }
    
    @Test
    public void testFindMatchingWords() {
        readWords();
        java.util.Random rng = new java.util.Random(SEED);
        Adler32 check = new Adler32();
        int total = 0;
        for(int i = 0; i < MATCHRUNS; i++) {
            String pat = buildString(rng, 1 + i % 10, '?');
            ArrayList<String> result = wp.findMatchingWords(words, pat);
            total += result.size();
            for(String word: result) {
                check.update(word.getBytes());
            }
        }
        //System.out.println(check.getValue());
        //System.out.println(total);
        assertEquals(3266665665L, check.getValue());
        assertEquals(634, total);
    }
    
    @Test
    public void testFindAnagrams() {
        readWords();
        java.util.Random rng = new java.util.Random(SEED);
        Adler32 check = new Adler32();
        int total = 0;
        for(int i = 0; i < ANARUNS; i++) {
            String pat = words.get(rng.nextInt(words.size()));
            ArrayList<String> result = wp.findAnagrams(words, pat);
            total += result.size();
            for(String word: result) {
                check.update(word.getBytes());
            }
        }    
        assertEquals(1768237328L, check.getValue());
        assertEquals(338, total);
    }
    
    @Test
    public void testFindSemordnilaps() {
        readWords();
        java.util.Random rng = new java.util.Random(SEED);
        Adler32 check = new Adler32();
        ArrayList<String> result = wp.findSemordnilaps(words);
        for(String word: result) {
            check.update(word.getBytes());
        }   
        assertEquals(4276396468L, check.getValue());
        assertEquals(930, result.size());
    }
    
    @Test
    public void testFindMatchingWordsStar() {
        readWords();
        java.util.Random rng = new java.util.Random(SEED);
        Adler32 check = new Adler32();
        int total = 0;
        for(int i = 0; i < MATCHRUNS; i++) {
            String pat = buildString(rng, 1 + (i / 3) % 10, '*');
            ArrayList<String> result = wp.findMatchingWordsStar(words, pat);
            total += result.size();
            for(String word: result) {
                check.update(word.getBytes());
            }
        } 
        assertEquals(3745875013L, check.getValue());
        assertEquals(163691, total);
    }
}