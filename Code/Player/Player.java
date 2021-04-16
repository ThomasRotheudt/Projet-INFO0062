package Code.Player;

import Code.World.Cells;
import Code.Game.Game;


/**
 * Player
 */
public class Player {
    public int x;
    public int y;
    public Cells currentCell;


    public Player(Cells newCell) {
        x = 0;
        y = 0;
        currentCell = newCell;
    }

    public void move(String direction, Game game) {

        if(direction.equals("forward") || direction.equals("Forward")) {
            y++;
            if(y > 9){
                y = 9;
                System.out.println("\nThere is no door in front of you");
            }
        }else if(direction.equals("backward") || direction.equals("Backward")){
            y--;
            if(y < 0){
                y = 0;
                System.out.println("\nThere is no door behind you");
            }
        }
        currentCell = game.getCells(x, y);
    }

    public void turn(String direction, Game game){
        if(direction.equals("left") || direction.equals("Left")) {
            x++;
            if(x > 9){
                x = 9;
                System.out.println("\nThere is no door left to you");
            }
        }else if(direction.equals("right") || direction.equals("Right")){
            x--;
            if(x < 0){
                x = 0;
                System.out.println("\nThere is no door right to you");
            }
        }
        currentCell = game.getCells(x, y);;
    }

    public String toString() {
        String s = "{";
        s += + x + ",";
        s += + y + "}";
        return s;
    }
}
