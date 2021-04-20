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
    public Player(Game game) {
        x = game.getLines() / 2;
        y = 0;
        currentCell = game.getCells(x, y);
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

        if(direction.equals("north") || direction.equals("North")) {
            y++;
            if(y > game.getColumns() - 1){
                y = game.getColumns() - 1;
                System.out.println("\n!There is no door to the north of the room!\n");
            }
        } 
        
        else if(direction.equals("south") || direction.equals("South")){
            y--;
            if(y < 0){
                y = 0;
                System.out.println("\n!There is no door to the south of the room!\n");
            }
        }
        
        else if(direction.equals("east") || direction.equals("East")) {
            x++;
            if(x > game.getLines() - 1){
                x = game.getLines() - 1;
                System.out.println("\n!There is no door to the west of the room!");
            }
        } 
        
        else if(direction.equals("west") || direction.equals("West")){
            x--;
            if(x < 0){
                x = 0;
                System.out.println("\n!There is no door to the east of the room!");
            }
        }
        currentCell = game.getCells(x, y);
    }
}
