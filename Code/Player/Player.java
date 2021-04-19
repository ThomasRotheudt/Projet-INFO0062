package Code.Player;

import Code.World.Cells;
import Code.Game.Game;


/**
 * A class that manages the player
 */
public class Player {
    protected int x;
    protected int y;
    protected Cells currentCell;

    /**
     * @param newCell The current cell of the player
     */
    public Player(Cells newCell) {
        x = 0;
        y = 0;
        currentCell = newCell;
    }

    /**
     * @return The current cell of the player
     */
    public Cells getCurrentCell() {
        return currentCell;
    }

    /**
     * @return The X position of the player 
     */
    public int getX(){
        return x;
    }

    /**
     * @return The Y position of the player 
     */
    public int getY(){
        return y;
    }

    /**
     * @param direction The direction in which the player is going to move
     * @param game The game in which the player is going to move
     */
    public void move(String direction, Game game) {

        if(direction.equals("forward") || direction.equals("Forward")) {
            y++;
            if(y > game.getColumns() - 1){
                y = game.getColumns() - 1;
                System.out.println("\n!There is no door in front of you!");
            }
        }else if(direction.equals("backward") || direction.equals("Backward")){
            y--;
            if(y < 0){
                y = 0;
                System.out.println("\n!There is no door behind you!");
            }
        }
        currentCell = game.getCells(x, y);
    }

    /**
     * @param direction The direction in which the player is going to turn
     * @param game The game in which the player is going to move
     */
    public void turn(String direction, Game game){
        if(direction.equals("right") || direction.equals("Right")) {
            x++;
            if(x > game.getLines() - 1){
                x = game.getLines() - 1;
                System.out.println("\n!There is no door left to you!");
            }
        }else if(direction.equals("left") || direction.equals("Left")){
            x--;
            if(x < 0){
                x = 0;
                System.out.println("\n!There is no door right to you!");
            }
        }
        currentCell = game.getCells(x, y);;
    }
}
