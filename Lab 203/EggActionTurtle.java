import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
public class EggActionTurtle extends ActionTurtle 
{
    double diameter;
    double prob;
    Random rng = new Random();
    
    public EggActionTurtle(double diameter, double prob) {
        addAction(new EggAction());
        this.diameter = diameter;
        this.prob = prob;
    }
    
    @Override public String toString() {
        return "EggActionTurtle";
    }
    
    class EggAction implements Action {
        @Override public void action(Turtle turtle){
            double x = turtle.getX();
            double y = turtle.getY();
            if (rng.nextDouble() < prob) {
                Ellipse2D.Double egg = new Ellipse2D.Double(x - diameter/2, y - diameter/2, diameter, diameter);
                Graphics2D g2 = getGraphics2D();
                g2.draw(egg);
                g2.fill(egg);
            }
        }
    }
}
