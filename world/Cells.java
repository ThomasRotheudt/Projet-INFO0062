package world;

import java.util.Vector;
import world.Door;
import world.objects.Object;


/**
 * Cells
 */
public class Cells {


    /** The doors of the cells */
    public Door northDoor = null, westDoor = null, eastDoor = null, southDoor = null;
    /** The items in the cells */
    protected Vector <Object> items;



    public Cells() {
        northDoor = null;
        westDoor = null;
        eastDoor = null;
        southDoor = null;

        items = new Vector<Object>();
    }

    public void setDoor(Door newDoorN, Door newDoorW, Door newDoorS, Door newDoorE){
        northDoor = newDoorN;
        westDoor = newDoorW;
        eastDoor = newDoorE;
        southDoor = newDoorS;
    }

    public Door getDoor(String direction){
        switch(direction){
            case "N":
                return northDoor;
            case "E":
                return eastDoor;
            case "W":
                return westDoor;
            case "S":
                return southDoor;
            default: 
                return null;
        }
    }

    public void addObject(Object newObject){
        items.add(newObject);
    }

    public String toString(){
        String s = "\nYou enter in a rooms of this dungeon, at first glance you see:";

        if(northDoor != null)
            s += "\n\t- a door to the north of the room";
        if(westDoor != null)
            s += "\n\t- a door to the west of the room";
        if(eastDoor != null)
            s += "\n\t- a door to the east of the room";
        if(southDoor != null)
            s += "\n\t- a door to the south of the room";
        if(northDoor == null && westDoor == null && eastDoor == null && southDoor == null)
            s += "\n\tnothing"; 
    
        return s;
    }
}
