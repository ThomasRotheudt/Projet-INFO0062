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

    public Vector<Object> getObject(){
        return items;
    }
    
    public void addObject(Object newObject){
        items.add(newObject);
    }

    public void removeObject(Object object){
        if(items.contains(object))
            items.remove(object);
    }

    public String toString(){
        String s = "\n\n\nYou enter in a rooms of this dungeon, at first glance you see:";

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

        s += "\n\nAfter a closer look you see:\n";
        for (int i = 0; i < items.size(); i++) {
            s += "\t-" + items.get(i);
        }
        if(items.size() <= 0)
            s += "\t-nothing else";
    
        return s;
    }
}
