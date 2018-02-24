import java.util.Random;
import java.awt.*;
/**
 * 
 *
 * @author Nikita Gerasimov
 * @version 2018-02-19
 */
public class RainbowTurtleDecorator extends TurtleDecorator
{
    private Random rng = new Random();
    private Color color;
    private Color randomColor;
    
    public RainbowTurtleDecorator (Turtle turtle) {
       super(turtle); 
    }
    
    @Override public void move (double dist) {
        randomColor = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
        setColor(randomColor);
        getTurtle().move(dist);
    }
    
    @Override public String toString() {
        return "RainbowTurtle(" + getTurtle().toString() + ")";
    }
}
