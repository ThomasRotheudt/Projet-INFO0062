
import game.Game;


import java.util.Scanner;

import player.Player;
import world.Cells;


public class AdventureGame {
    static public void manageCommand(String command, Player player, Game game) {
        String[] commandKeys = command.split(" "); 

        if(command.startsWith("move ")) {
            if(commandKeys.length == 2)
                player.move(commandKeys[1], game);
            else
                System.out.println("Choose a direction adventurer");

        }else if(command.startsWith("map"))
            System.out.println(game.toString(player));
        
        else if(command.startsWith("take"))
            player.take(commandKeys[1]);
        
        else if(command.startsWith("inventory"))
            System.out.println(player);
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
                System.out.println("What will you do adventurer:");
            }else
                System.out.println("What will you do adventurer:");

            interact = sc.nextLine();

            manageCommand(interact, player, game);

            
        } while (!interact.equals("Quit") && !interact.equals("quit"));

        sc.close();
    }
}
