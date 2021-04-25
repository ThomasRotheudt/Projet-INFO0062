
import game.Game;


import java.util.Scanner;

import player.Player;
import world.Cells;


public class AdventureGame {
    static void help(){
        String s = "\nList of commands:\n";
        s += "\t-Move [direction]: Move around the game grid.\n \t\t\t[direction] can be north, west, east and south\n";
        s += "\n\t-map: See the map of the game\n";
        s += "\n\t-take [object]: Take an object in the several rooms of the game\n";
        s += "\n\t-player: See stats and inventory of the player\n";
        s += "\n\t-unlock [direction/box]: Unlock the selected box or door\n \t\t\t [direction/box] can be north, west, east and south or box\n";
        s += "\n\t-open box: Open the box if it is open and shows you the content\n \t\t\tpour prendre un objet la boite doit être ouverte, elle se ferme quand un objet est pris.\n";
        s += "\n\t-use [object]: Use the object selected\n";
        s += "\n\t-breakdown [direction]: Breaks down a locked door. Costs you life points. You recover life points by drinking potions.";
        System.out.println(s);
    }
    static public boolean manageCommand(String command, Player player, Game game) {
        String[] commandKeys = command.split(" "); 

        switch (commandKeys[0]) {
            case "move":
                if(commandKeys.length == 2){
                    player.move(commandKeys[1], game);
                    return false;
                }else{
                    System.out.println("Choose a direction adventurer");
                    return false;
                }

            case "map":
                System.out.println(game.toString(player));
                return false;
            
            case "take":
                if(commandKeys.length == 2){
                    player.take(commandKeys[1]);
                    return false;
                }else{
                    System.out.println("Choose something to take");
                    return false;
                }

            case "player":
                System.out.println(player);
                return false;

            case "unlock":
                if(commandKeys.length >= 2){
                    player.unlock(commandKeys[1]);
                    return false;
                }else{
                    System.out.println("Choose a door or a box to unlock");
                    return false;
                }
            
            case "open":
                if(commandKeys.length == 2){
                    player.open(commandKeys[1]);
                    return false;
                }else{
                    System.out.println("Choose something to open");
                    return false;
                }
            case "use":
                if(commandKeys.length == 2){
                    player.use(commandKeys[1]);
                    return false;
                }else{
                    System.out.println("Choose something to use");
                    return false;
                }
                
            case "breakdown":
                if(commandKeys.length == 2){
                    player.breakdown(commandKeys[1]);
                    return false;
                }else{
                    System.out.println("Choose something to break");
                    return false;
                }
            
            case "help":
                help();
                return false;

            case "quit":
                return true;

            default:
                return false;
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String interact = " ";

        Game game = new Game();
        Player player = new Player(game);
        Cells currentGameCell = new Cells();
        currentGameCell = player.getCurrentCell();


        System.out.println("\n\t\t\t\t\tWelcome adventurer\nAfter weeks of searching for a dungeon, you enter what appears to be the lair of an unknown monster\n");
        
        System.out.println(player.getCurrentCell().toString()+"\n");

        do {

            if(!currentGameCell.equals(player.getCurrentCell())){
                System.out.println(player.getCurrentCell()+"\n");
                currentGameCell = player.getCurrentCell();
                System.out.println("\nWhat will you do adventurer:");
            }else
                System.out.println("\nWhat will you do adventurer:");

            interact = sc.nextLine();

            
        } while(!manageCommand(interact, player, game) && !player.victory && player.hpPlayer > 0);

        sc.close();
    }
}
