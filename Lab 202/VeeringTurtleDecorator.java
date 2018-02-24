
public class VeeringTurtleDecorator extends TurtleDecorator
{
    private double veer;
    
    public VeeringTurtleDecorator (Turtle turtle, double veer) {
        super(turtle);
        this.veer = veer;
    }
    
    @Override public void turn (double turnAngle) {
        getTurtle().turn(veer);
    }
    
    @Override public String toString() {
        return "VeeringTurtle(" + getTurtle().toString() + ")";
    }
}
