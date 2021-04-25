package world.container;

import java.util.Vector;

import world.objects.Object;

public class Container {
    /** The type of container */
    String type;
    /** The objects of the container */
    Vector<Object> items;

    public void addItems(Object newObject){
        items.add(newObject);
    }

    public Vector<Object> getItems() {
        return items;
    }

    public String toString() {
        String s = "";
        if(items.size() != 0){
            for (int i = 0; i < items.size(); i++) {
                s += "\t-" + items.get(i) + "\n";
            }
        }else
            s += "\t-nothing\n";

        return s;
    }
}
