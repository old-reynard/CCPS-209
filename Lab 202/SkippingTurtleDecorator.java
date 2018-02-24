
/**
 *
 * @author Nikita Gerasimov
 * @version 2018-02-19
 */
public class SkippingTurtleDecorator extends TurtleDecorator 
{
    private int skip;
    private int count;
    
    public SkippingTurtleDecorator(Turtle turtle, int skip) {
        super(turtle);
        this.skip = skip;
    }
    
    @Override public void move(double dist) {
        count++;
        if (count % skip == 0) {
            setPen(false);
        }
        getTurtle().move(dist);
        setPen(true);
    }
    
    @Override public String toString() {
       return "SkippingTurtle(" + getTurtle().toString() + ")"; 
    }
}
