package world.objects;

/**
 * Object
 */
public abstract class Object {
    //The name of the object
    protected String name;
    //Type of the object
    protected String type;


    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String toString() {
        return "a " + type;
    }
}
