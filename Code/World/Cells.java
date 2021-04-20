package Code.World;

import java.util.Vector;

import Code.World.Object.Object;

/**
 * Cells
 */
public class Cells {


    /** The doors of the cells */
    public Door frontDoor = null, leftDoor = null, rightDoor = null, backDoor = null;
    /** The items in the cells */
    protected Vector <Object> items;



    public Cells() {
        frontDoor = null;
        leftDoor = null;
        rightDoor = null;
        backDoor = null;

        items = new Vector<Object>();
    }

    public Cells(Door frontDoor_, Door leftDoor_, Door backDoor_, Door rightDoor_) {
        frontDoor = frontDoor_;
        leftDoor = leftDoor_;
        rightDoor = rightDoor_;
        backDoor = backDoor_;

        items = new Vector<Object>();
    }

    public void addObject(Object newObject){
        items.add(newObject);
    }

    public String toString(){
        String s = "\nYou enter in a rooms of this dungeon, at first glance you see:";

        if(frontDoor != null)
            s += "\n\t- a door to the north of the room";
        if(leftDoor != null)
            s += "\n\t- a door to the west of the room";
        if(rightDoor != null)
            s += "\n\t- a door to the east of the room";
        if(backDoor != null)
            s += "\n\t- a door to the south of the room";
        if(frontDoor == null && leftDoor == null && backDoor == null && rightDoor == null)
            s += "\n\tnothing";
    
        return s;
    }
}
