import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

import java.io.*;
import java.util.*;
import java.util.zip.Adler32;

public class UnixCommandsTest {

    @Test
    public void testWordCount() throws IOException {
        UnixCommands uc = new UnixCommands();
        Reader fr = new InputStreamReader(new FileInputStream("warandpeace.txt"), "UTF-8");
        int[] result = uc.wc(fr);
        fr.close();
        assertTrue(63850 <= result[0] && result[0] <= 63854);
        assertEquals(562491, result[1]);
        assertEquals(3202325, result[2]);
    }
    
    @Test
    public void testTail() throws IOException {
        UnixCommands uc = new UnixCommands();
        int[] trials = { 10, 100, 1000, 10000, 100000 };
        Adler32 check = new Adler32();
        for(int t : trials) {
            StringWriter res = new StringWriter();
            Reader fr = new InputStreamReader(new FileInputStream("warandpeace.txt"), "UTF-8");
            uc.tail(fr, res, t);
            check.update(res.toString().getBytes());
            fr.close();
        }
        assertEquals(61201251L, check.getValue());
    }
}