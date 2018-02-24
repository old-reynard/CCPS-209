import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

import java.util.zip.Adler32;

public class CutoffIteratorTest {

    private static int TRIALS = 300;
    private static int SEED = 44321;
    
    @Test
    public void testCutoffIterator() {
        Random rng = new Random(SEED);
        ArrayList<Integer> a = new ArrayList<>();
        Adler32 check = new Adler32();
        for(int i = 1; i < TRIALS; i++) {
            a.add(rng.nextInt());
            for(int j = 0; j < i + 10; j++) {
                CutoffIterator<Integer> cit = new CutoffIterator<Integer>(a.iterator(), j);
                int len = 0;
                while(cit.hasNext()) {
                    check.update(cit.next().toString().getBytes());
                    len++;
                }
                assertEquals(len, Math.min(j, i));
            }
        }
        assertEquals(2604106567L, check.getValue());
    }
    
}