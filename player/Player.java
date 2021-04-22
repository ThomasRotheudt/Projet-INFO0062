package player;

import java.util.Vector;

import game.Game;
import world.Cells;
import world.objects.Object;
/**
 * A class that manages the player
 */
public class Player {
    protected int x;
    protected int y;
    protected Cells currentCell;
    protected Vector<Object> inventory;

    /**
     * @param newCell The current cell of the player
     */
    public Player(Game game) {
        x = game.getLines() - 2;
        y = 0;
        currentCell = game.getCells(x, y);
        inventory = new Vector<Object>();
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
            }else if(currentCell.getDoor("N").getState()){
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
            }else if(currentCell.getDoor("S").getState()){
                System.out.println("\nThe door is locked\n");
                return;
            }

            y--;
        }
        
        else if(direction.equals("east") || direction.equals("East")) {
            if(currentCell.getDoor("E") == null){
                System.out.println("\nThere is no door here\n");
                return;
            }else if(currentCell.getDoor("E").getState()){
                System.out.println("\nThe door is locked\n");
                return;
            }
            x++;
            
        } 
        
        else if(direction.equals("west") || direction.equals("West")){
            if(currentCell.getDoor("W") == null){
                System.out.println("\nThere is no door here\n");
                return;
            }else if(currentCell.getDoor("W").getState()){
                System.out.println("\nThe door is locked\n");
                return;
            }

            x--;
            
        }
        currentCell = game.getCells(x, y);
    }

    public void take(String object){
        if(currentCell.getObject().size() == 0){
            System.out.println("There are no objects in the room");
            return;
        }
        for (int i = 0; i < currentCell.getObject().size(); i++) {
            if(currentCell.getObject().get(i).getType().equals(object)){
                inventory.add(currentCell.getObject().get(i));
                currentCell.removeObject(currentCell.getObject().get(i));
            }
        }
    }


    public String toString(){

        String s = "\nYou have ";
        if(inventory.size() != 0){
            for (int i = 0; i < inventory.size(); i++) 
                s += inventory.get(i).getType();
            
            s += ".\n";
        }else
            s += "nothing.\n";
        
        return s;
    }
}

