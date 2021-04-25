package world.objects;

/**
 * Key a key 
 */
public class Key extends Object {

    public Key(String name_){
        name = name_;
        type = "key";
    }

    public Key(){
        type = "key";
    }

    public String toString() {
        if(name != null)
            return "a key with the inscription " + "\""+name+"\"";
        else
            return super.toString();
    }
}
