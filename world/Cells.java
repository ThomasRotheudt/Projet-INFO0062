package world;

import java.util.Vector;

import world.container.Box;
import world.objects.Object;


/**
 * Cells
 */
public class Cells {
    /** The doors of the cells */
    public Door northDoor = null, westDoor = null, eastDoor = null, southDoor = null;
    /** The items in the cells */
    protected Vector <Object> items;
    /** A box in the cell */
    protected Box box = null;


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

    public Door getDoor(Character direction){
        switch(direction){
            case 'N':
                return northDoor;
            case 'E':
                return eastDoor;
            case 'W':
                return westDoor;
            case 'S':
                return southDoor;
            default: 
                return null;
        }
    }

    public void setBox(Box newBox){
        box = newBox;
    }

    public Box getBox() {
        return box;
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

        if(northDoor != null){
            s += "\n\t- a door to the north of the room";
            if(northDoor.symbol != null)
                s += ", there is a strange " + northDoor.symbol + " on the door";

        }if(westDoor != null){
            s += "\n\t- a door to the west of the room";
            if(westDoor.symbol != null)
                s += ", there is a strange " + westDoor.symbol + " on the door";

        }if(eastDoor != null){
            s += "\n\t- a door to the east of the room";
            if(eastDoor.symbol != null)
                s += ", there is a strange " + eastDoor.symbol + " on the door";

        }if(southDoor != null){
            s += "\n\t- a door to the south of the room";
            if(southDoor.symbol != null)
                s += ", there is a strange " + southDoor.symbol + " on the door";

        }if(box != null){
            s += "\n\t- a box in the corner of the room";
        }
        s += "\n\nAfter a closer look you see:\n";
        for (int i = 0; i < items.size(); i++) {
            s += "\t-" + items.get(i) + "\n";
        }
        if(items.size() <= 0)
            s += "\t-nothing else";
    
        return s;
    }
}
