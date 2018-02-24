
/**

 *
 * @author Nikita Gerasimov
 * @version 2018-02-19
 */
public class SkippingTurtle extends BasicTurtle
{
    private int skip;
    private int count;
    
    public SkippingTurtle(int skip) {
        this.skip = skip;
    }
    
    @Override public void move(double dist) {
        count++;
        if (count % skip == 0) {
            setPen(false);
        }
        super.move(dist);
        setPen(true);
    }
    
    @Override public String toString() {
        return "SkippingTurtle";
    }
}
