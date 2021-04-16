package Code.Player;


/**
 * Player
 */
public class Player {
    public int x;
    public int y;


    public Player() {
        x = 0;
        y = 0;
    }

    public void move(String direction) {

        if(direction.charAt(0) == 'F' || direction.charAt(0) == 'f')
            y++;
        else if(direction.charAt(0) == 'B' || direction.charAt(0) == 'b')
            y--;
    }

    public void turn(String direction){
        
        if(direction.charAt(0) == 'L' || direction.charAt(0) == 'l')
            x++;
        else if(direction.charAt(0) == 'R' || direction.charAt(0) == 'r')
            x--;
    }

}
