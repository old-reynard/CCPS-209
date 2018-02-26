import java.io.*;
import java.util.Arrays;
import java.util.*;  

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

    
    public static void tail(Reader in, Writer out, int lines) throws IOException {
        BufferedReader br = new BufferedReader(in);
        PrintWriter pw = new PrintWriter(out);
        String line;
        LinkedList<String> buffer = new LinkedList();
        
        while((line = br.readLine()) != null) {
            if (buffer.size() >= lines) {buffer.removeFirst();}
            buffer.add(line);
        }
        String[] array = buffer.toArray(new String[buffer.size()]);
        for (int i = 0; i < array.length ; i++) { //buffer.size()
            pw.write(array[i]); //buffer.get(i)
            pw.write('\n');
        }
        pw.flush();
    }
    
    public static void main(String[] args) throws IOException {
        Reader r = new InputStreamReader(new FileInputStream("warandpeace.txt"), "UTF-8"); 
        tail(r, new OutputStreamWriter(System.out), 100);
        r.close();
    }
}
