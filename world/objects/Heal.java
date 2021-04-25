package world.objects;

public class Heal extends Object{
    private int hp = 20;

    public Heal(){
        type = "potion";
    }

    public int getHp() {
        return hp;
    }
}
