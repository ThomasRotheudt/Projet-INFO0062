package world.objects;

import java.util.jar.Attributes.Name;

/**
 * Key a key 
 */
public class Key extends Object {

    protected String code;

    public Key(String code_, boolean hide) {
        weight = 0.010;
        code = code_;
        isHide = hide;
    }

    public String getCode(){
        return code;
    }

    public double getWeight(){
        return weight;
    }
}
