package world.objects;


/**
 * Key a key 
 */
public class Key extends Object {

    protected String code;
    protected double weight;

    public Key(String code_) {
        weight = 0.010;
        code = code_;
    }
}
