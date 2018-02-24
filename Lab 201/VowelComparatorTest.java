import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;

import java.util.zip.Adler32;

public class VowelComparatorTest {

    private static int TRIALS = 1000000;
    private static int SEED = 87654;
    
    private static void createString(Random rng, StringBuilder sb) {
        int len = rng.nextInt(20);
        for(int i = 0; i < len; i++) {
            boolean upper = rng.nextBoolean();
            sb.append((char)((upper ? 'A' : 'a') + rng.nextInt(26)));
        }
    }
    
    @Test
    public void testCompare() {
        Random rng = new Random(SEED);
        VowelComparator vc = new VowelComparator();
        Adler32 check = new Adler32();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < TRIALS; i++) {
            createString(rng, sb1);
            createString(rng, sb2);
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            assertEquals(0, vc.compare(s1, s1));
            assertEquals(0, vc.compare(s2, s2));
            assertEquals(vc.compare(s1, s2), -vc.compare(s2, s1));
            int res = vc.compare(s1, s2);
            if(res < -1) { res = -1; }
            if(res > 1) { res = 1; }
            check.update((""+(i * res)).getBytes());
            sb1.delete(0, sb1.length());
            sb2.delete(0, sb2.length());
        }
        assertEquals(3337656899L, check.getValue());
    }
    
    
}