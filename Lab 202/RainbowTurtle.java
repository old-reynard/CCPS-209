import java.util.Random;
import java.awt.*;
/**
 * 
 *
 * @author Nikita Gerasimov
 * @version 2018-02-19
 */
public class RainbowTurtle extends BasicTurtle 
{
    private static Random rng = new Random();
    private Color color;
    private Color randomColor;
    
    @Override public String toString() {
        return "RainbowTurtle";
    }
    
    @Override public void move (double dist) {
        randomColor = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        setColor(randomColor);
        super.move(dist);
    }
}
