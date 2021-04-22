package world.objects;

/**
 * Key a key 
 */
public class Key extends Object {

    protected String code;

    public Key(String code_, boolean hide, String name_){
        weight = 0.010;
        code = code_;
        isHide = hide;
        name = name_;
        type = "key";
    }

    public String getCode(){
        return code;
    }

    public double getWeight(){
        return weight;
    }

    @Override
    public String getType(){
        return super.getType();
    }

    @Override
    public String toString() {
        String s = "a key with the inscription " + "\""+name+"\"";
        return s;
    }
}
