package world.container;

import java.util.Vector;

import world.objects.Key;
/**     
 * Box
 */
import world.objects.Object;
public class Box extends Container{
    /** The door is locked or not */
    protected boolean isLocked;
    /** The door's key */
    protected Key keyContainer;

    public Box(Key key, boolean state){
        items = new Vector<Object>();
        isLocked = state;
        keyContainer = key;
    }

    public boolean getState(){
        return isLocked;
    }

    public void setState(boolean newState){
        isLocked = newState;
    }

    public Key getKey(){
        return keyContainer;
    }

    public String toString() {
        String s = "This box contains:\n";
        
        s += super.toString();
        
        return s;
    }
}
