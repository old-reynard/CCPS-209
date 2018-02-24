
/**
 * class VeeringTurtle 
 *
 * @author Nikita Gerasimov
 * @version 2018-02-19
 */
public class VeeringTurtle extends BasicTurtle 
{
    private double veer;
    
    
    public VeeringTurtle (double veer) {
        this.veer = veer;
    }
    
    @Override public void turn(double turnAngle) {
        super.turn(veer);
    }

    @Override public String toString() {
        return "VeeringTurtle";
    }
}
