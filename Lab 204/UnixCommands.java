import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
/**
 * class UnixCommands.
 *
 * @author Nikita Gerasimov 
 * @version 2018-02-22
 */
public class UnixCommands
{
    public static int[] wc(Reader in) throws IOException{
        BufferedReader br = new BufferedReader(in);
        String line;
        int chars = 0;
        int words = 0;
        int lines = 0;

        while ((line = br.readLine()) != null) {
            lines++;
            StringReader reader = new StringReader(line);
            while (reader.read() != -1) {chars++;}
            if (line.length() > 1) {
                if(!Character.isWhitespace(line.charAt(0))){words++;}

                for (int i = 1; i < line.length(); i++) {
                    if (!Character.isWhitespace(line.charAt(i)) && Character.isWhitespace(line.charAt(i-1))) {words++;}
                } 
            } 
        }

        int [] a = {lines, words, chars+lines};

        return a;
    }

    
    public void tail(Reader in, Writer out, int lines) throws IOException {
        
    }
    
    public static void main(String[] args) throws IOException {
        Reader r = new InputStreamReader(new FileInputStream("warandpeace.txt"), "UTF-8"); 
        int[] a=wc(r);
        System.out.println(a[0] + " " + a[1] + " " + a[2]);
        r.close();
    }
}
