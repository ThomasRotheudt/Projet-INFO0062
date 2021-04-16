package Code.World;

import java.util.Vector;

import Code.World.Object.Object;

/**
 * Cells
 */
public class Cells {

    // ATTRIBUTS

    /** The doors of the cells */
    public Door frontDoor = null, leftDoor = null, rightDoor = null, backDoor = null;
    /** The items in the cells */
    protected Vector <Object> items;


    // METHOD

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

    public String toString(){
        String s = "\nYou are in a cell, there is:";

        if(frontDoor != null)
            s += "\none door in front of you";
        if(leftDoor != null)
            s += "\none door to your left";
        if(rightDoor != null)
            s += "\none door to your right";
        if(backDoor != null)
            s += "\none door behind you";
        if(frontDoor == null && leftDoor == null && backDoor == null && rightDoor == null)
            s += "\nnothing";
    
        return s;
    }
}
