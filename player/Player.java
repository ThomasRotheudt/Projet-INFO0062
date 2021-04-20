package player;

import game.Game;
import world.Door;
import world.Cells;
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
            if(currentCell.getDoor("N") == null){
                System.out.println("\nThere is no door here\n");
                return;
            }else if(currentCell.getDoor("N").getSate()){
                System.out.println("\nThe door is locked\n");
                return;
            }
            y++;
            if(y > game.getColumns() - 1){
                y = game.getColumns() - 1;
                System.out.println("Victory!!!");
            }

        } 
        
        else if(direction.equals("south") || direction.equals("South")){
            if(currentCell.getDoor("S") == null){
                System.out.println("\nThere is no door here\n");
                return;
            }else if(currentCell.getDoor("S").getSate()){
                System.out.println("\nThe door is locked\n");
                return;
            }

            y--;
        }
        
        else if(direction.equals("east") || direction.equals("East")) {
            if(currentCell.getDoor("E") == null){
                System.out.println("\nThere is no door here\n");
                return;
            }else if(currentCell.getDoor("E").getSate()){
                System.out.println("\nThe door is locked\n");
                return;
            }
            x++;
            
        } 
        
        else if(direction.equals("west") || direction.equals("West")){
            if(currentCell.getDoor("W") == null){
                System.out.println("\nThere is no door here\n");
                return;
            }else if(currentCell.getDoor("W").getSate()){
                System.out.println("\nThe door is locked\n");
                return;
            }

            x--;
            
        }
        currentCell = game.getCells(x, y);
    }
}
