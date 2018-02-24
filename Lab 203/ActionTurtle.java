import java.util.*;
public class ActionTurtle extends BasicTurtle //implements Action
{
    private List<Action> actionList = new ArrayList<Action>();
    //private Action ac = new Action();
    
    public void addAction (Action action) {
        actionList.add(action);
    }
    
    @Override public void move(double dist) {
        super.move(dist);
        for (Action a: actionList) {a.action(this);}

    }
}
