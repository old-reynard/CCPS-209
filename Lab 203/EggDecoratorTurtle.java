import java.util.Random;
/**
 *class EggDecoratorTurtle 
 *
 * @author Nikita Gerasimov
 * @version 2018-02-19
 */
public class EggDecoratorTurtle extends TurtleDecorator 
{
    private double diameter;
    private double prob;
    Random rng = new Random();
    
    public EggDecoratorTurtle (Turtle turtle, double diameter, double prob){
        super(turtle);
        this.diameter = diameter;
        this.prob = prob;
    }
    
    @Override public String toString(){
        return "EggDecoratorTurtle(" + getTurtle().toString() + ")";
    }
    
    @Override public void move(double dist){
        getTurtle().move(dist);
        if (rng.nextDouble() < prob) drawEgg(getGraphics2D(), getX(), getY(), diameter);
    }
}
