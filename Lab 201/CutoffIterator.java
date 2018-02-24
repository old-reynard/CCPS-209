import java.util.*;

/*
 * Lab 201
 * @author Nikita Gerasimov 
 * @date 2018-02-16
 */

public class CutoffIterator<E> implements Iterator<E> 
{
    private Iterator<E> it;
    int limit;
    
    public CutoffIterator(Iterator<E> it, int limit){
        this.it = it;
        this.limit = limit;
    }
    
    @Override public E next(){
        limit--;
        return it.next();
    }
    
    @Override public boolean hasNext() {
        if (limit != 0) return it.hasNext();
        else return false;
    }
}
