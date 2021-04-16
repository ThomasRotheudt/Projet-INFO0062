package Code.World;

import java.util.Vector;

import Code.World.Object.Object;

/**
 * Cells
 */
public class Cells {
    /** The doors of the cells */
    protected Door frontDoor = null, leftDoor = null, rightDoor = null, backDoor = null;
    /** The number of doors */
    protected int nbrDoor;
    /** The items in the cells */
    protected Vector <Object> items;


    public Cells(Door frontDoor_, Door leftDoor_, Door rightDoor_, Door backDoor_) {
        frontDoor = frontDoor_;
        leftDoor = leftDoor_;
        rightDoor = rightDoor_;
        backDoor = backDoor_;


        items = new Vector<Object>();
    }

    public Cells() {
        frontDoor = new Door("front door");
        leftDoor = new Door("left door");
        rightDoor = new Door("right door");
        backDoor = new Door("back door");

        items = new Vector<Object>();
    }

    public String toString(){
        String s = "\nYou are in a cell, there is ";

        if(frontDoor != null)
            s += "one door in front of you";
        else if(leftDoor != null)
            s += ", one door to your left";
        else if(rightDoor != null)
            s += ", one door to your right";
        else if(backDoor != null)
            s += ", one door behind you";
        else
            s += "nothing.";
        

        return s;
    }

    
}
