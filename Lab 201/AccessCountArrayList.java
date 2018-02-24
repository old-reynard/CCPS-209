import java.util.*;


/*
 * Lab 201
 * @date 2018-02-16
 * @author Nikita Gerasimov
 * 
 */

public class AccessCountArrayList<E> extends ArrayList<E>
{
    private int getCount;
    private int setCount;
    
    @Override public E get(int idx) {
        this.getCount++;
        return super.get(idx);
    }
    
    @Override public E set(int idx, E element) {
        this.setCount++;
        return super.set(idx, element);
    }
    
    public int getGetCount() {return this.getCount;}
    
    public int getSetCount() {return this.setCount;}
    
    public void resetCounts() {this.getCount = 0; this.setCount = 0;}
}
