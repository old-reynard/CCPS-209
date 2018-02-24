import java.util.Random;
/**
 * class EggLayingTurtle 
 *
 * @author Nikita Gerasimov
 * @version 2018-02-20
 */
public class EggLayingTurtle extends BasicTurtle 
{
    double prob;
    double diameter;
    private static Random rng = new Random();
    
    public EggLayingTurtle(double diameter, double prob) {
        this.diameter = diameter;
        this.prob = prob;
    }
    
    @Override public String toString() {
        return "EggLayingTurtle";
    }
    
    @Override public void move(double dist) {
        super.move(dist);
        if (rng.nextDouble() < prob) drawEgg(getGraphics2D(), getX(), getY(), diameter);
    }
}
