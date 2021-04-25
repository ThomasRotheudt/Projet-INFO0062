package world;
import world.objects.Key;

/**
 * Door
 */
public class Door {

    /** The door is locked or not */
    protected boolean isLocked;
    /** The door's key */
    protected Key keyDoor;
    /**The symbol of the door */
    protected String symbol;


    public Door() {
        isLocked = false;
        keyDoor = null;
        symbol = null;
    }

    public Door(Key key){
        isLocked = true;
        keyDoor = key;
        symbol = key.getName();
    }
    
    public boolean getState(){
        return isLocked;
    }

    public void setState(boolean newState){
        isLocked = newState;
    }

    public Key getKey(){
        return keyDoor;
    }
}
