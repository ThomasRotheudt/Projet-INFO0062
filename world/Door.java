package world;
import world.objects.Key;

/**
 * Door
 */
public class Door {

    /** The door is locked or not */
    protected boolean isLocked;

    protected Key keyDoor;


    public Door() {
        isLocked = false;
        keyDoor = null;
    }

    public Door(Key key){
        isLocked = true;
        keyDoor = key;
    }
    
    public boolean getState(){
        return isLocked;
    }

    public Key getKey(){
        return keyDoor;
    }
}
