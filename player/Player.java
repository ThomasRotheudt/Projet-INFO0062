package player;

import java.util.Vector;

import game.Game;
import world.Cells;
import world.objects.Heal;
import world.objects.Object;
/**
 * A class that manages the player
 */
public class Player {
    private int x, y;
    public int hpPlayer;
    private Cells currentCell;
    private Vector<Object> inventory;
    public boolean victory;

    /**
     * @param newCell The current cell of the player
     */
    public Player(Game game) {
        x = game.getLines() - 2; y = 0; hpPlayer = 100;

        currentCell = game.getCells(x, y);
        inventory = new Vector<Object>();
        victory = false;
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
        if(currentCell.getDoor(direction.toUpperCase().charAt(0)) == null){
            System.out.println("\nThere is no door here\n");
            return;
        }else if(currentCell.getDoor(direction.toUpperCase().charAt(0)).getState()){
            System.out.println("\nThe door is locked\n");
            return;
        }

        switch (direction) {
            case "north":
                y++;
                if(y > game.getColumns() - 1){
                    y = game.getColumns() - 1;
                    System.out.println("\n\t\t\tVictory!!!");
                    victory = true;
                }
                break;

            case "south":
                y--;
                break;

            case "east":
                x++;
                break;

            case "west":
                x--;
                break;
        
            default:
                break;
        }

        currentCell = game.getCells(x, y);
    }
    /**
     * 
     * @param object The object to take
     */
    public void take(String object){
        if(currentCell.getObject().size() == 0){
            System.out.println("There are no objects in the room");
            return;
        }else
            for (int i = currentCell.getObject().size() - 1; i >= 0 ; i--) {
                if(currentCell.getObject().get(i).getType().equals(object)){
                    inventory.add(currentCell.getObject().get(i));
                    currentCell.getObject().remove(currentCell.getObject().get(i));
                    System.out.println("You add it in your bag");
                    return;
                }
            }
    }

    public void unlock(String doorOrBox){
        if(doorOrBox.equals("box")){
            for (int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).equals(currentCell.getBox().getKey())){
                    currentCell.getBox().setState(false);
                    System.out.println("\nBox unlocked\n");
                    return;
                }
            }
            System.out.println("\nYou don't have the key of this box\n");
            return;
        }else{
            if(currentCell.getDoor(doorOrBox.toUpperCase().charAt(0)) == null){
                System.out.println("\nThere is no door here\n");
                return;
    
            }else if(!currentCell.getDoor(doorOrBox.toUpperCase().charAt(0)).getState()){
                System.out.println("The door is already unlocked");
                return;
    
            }else if(inventory.size() == 0){
                System.out.println("\nYou don't have any keys\n");
                return;
    
            }else{
                for (int i = 0; i < inventory.size(); i++) {
                    if(inventory.get(i).equals(currentCell.getDoor(doorOrBox.toUpperCase().charAt(0)).getKey())){
                        currentCell.getDoor(doorOrBox.toUpperCase().charAt(0)).setState(false);
                        System.out.println("\nDoor unlocked\n");
                        return;
                    }
                }
                System.out.println("\nYou don't have the key of this door\n");
                return;
            }
        }
        
    }

    public void open(String container){
        switch (container) {
            case "box":
                if(currentCell.getBox().getState()){
                    System.out.println("\nThis box is locked\n");
                    return;
                }else{
                    System.out.print(currentCell.getBox());
                    for (int i = 0; i < currentCell.getBox().getItems().size(); i++) {
                        currentCell.getObject().add(currentCell.getBox().getItems().get(i));
                        currentCell.getBox().getItems().remove(currentCell.getBox().getItems().get(i));
                    }
                    return;
                }
                
            case "hideout":
                break;
            default:
                break;
        }
    }

    public void use(String object){
        if(inventory.size() == 0){
            System.out.println("\nYou don't have any items\n");
            return;
        }else
            switch (object) {
                case "potion":
                    Heal hp;
                    if(hpPlayer >= 100){
                        System.out.println("\nYou already have your whole life\n");
                        return;
                    }
                    for (int i = inventory.size() - 1; i >= 0; i--) {
                        if(inventory.get(i).getType().equals(object)){

                            hp = (Heal) inventory.get(i);
                            hpPlayer += hp.getHp();

                            if(hpPlayer >= 100)
                                hpPlayer = 100;

                            System.out.println("Potion used");

                            inventory.remove(inventory.get(i));
                        }
                    }
                    return;
            
                default:
                    break;
            }
    }

    public void breakdown(String door){
        if(currentCell.getDoor(door.toUpperCase().charAt(0)) == null){
            System.out.println("\nThere is no door here\n");
            return;
        }else if(!currentCell.getDoor(door.toUpperCase().charAt(0)).getState()){
            System.out.println("The door is already open");
            return;
        }else{
            currentCell.getDoor(door.toUpperCase().charAt(0)).setState(false);
            System.out.println("\nThe shock shook you (-80 hp)\n");
            hpPlayer -= 80;
            if(hpPlayer <= 0)
                System.out.println("\nYou died\n");
                return;
        }
    }

    public String toString(){

        String s = "\nHeal:";
        s += "\n\t" +hpPlayer+ "\n";
        s += "\ninventory:\n";
        if(inventory.size() != 0){
            for (int i = 0; i < inventory.size(); i++) 
                s += "\t-" + inventory.get(i) + "\n";
        }else
            s += "\tnothing.\n";
        
        return s;
    }
}

