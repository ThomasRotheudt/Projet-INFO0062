package Code.World;

import Code.World.Object.Key;

/**
 * Door
 */
public class Door {

    /** The name of the door */
    protected String name;
    
    /** The key of the door */
    protected Key keyDoor;

    /** The door is locked or not */
    protected boolean isLocked;


    /*   Method  */
    public Door(String name_, Key key, boolean locked) {
        name = name_;
        keyDoor = key;
        isLocked = locked;
    }

    public Door(String name_) {
        name = name_;
        isLocked = false;
        keyDoor = null;
    }

    public void setKey(Key key) {
        keyDoor = key;
    }
    
}
