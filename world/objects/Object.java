package world.objects;

/**
 * Object
 */
public abstract class Object {
    //The name of the object
    protected String name;
    //Weight of the object (Kg)
    protected double weight;
    //The object is hide or not
    protected boolean isHide;
    //Type of the object
    protected String type;


    public String getType(){
        return type;
    }
}
