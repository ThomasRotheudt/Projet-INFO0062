package Code;

import java.util.Scanner;
import Code.Game.Game;
import Code.Player.Player;
import Code.World.Cells;


public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String interact = " ";
        Game game = new Game();
        Player player = new Player(game.getCells(0, 0));
        Cells currentGameCell = new Cells();
        currentGameCell = player.getCurrentCell();

        System.out.println("\n\t\t\t\t\tWelcome adventurer\nAfter weeks of searching for a dungeon, you enter what appears to be the lair of an unknown monster\n");
        
        System.out.println(player.getCurrentCell().toString()+"\n");

        do {

            
            if(!currentGameCell.equals(player.getCurrentCell()))
                System.out.println(player.getCurrentCell().toString()+"\n");

            System.out.println("What will you do adventurer:");


            interact = sc.nextLine();
            
            currentGameCell = player.getCurrentCell();

            if(interact.length() >= 4){
                if(interact.substring(0, 4).equals("move") || interact.substring(0, 4).equals("Move"))
                    if(interact.length() < 5)
                        System.out.println("Choose a direction adventurer");
                    else
                        player.move(interact.substring(5), game);
                
                else if(interact.substring(0, 4).equals("turn") || interact.substring(0, 4).equals("Turn"))
                    if(interact.length() < 5)
                        System.out.println("Choose a direction adventurer");
                    else
                        player.turn(interact.substring(5), game);
            }
            
            if(interact.equals("Map") || interact.equals("map"))
                System.out.println(game.toString(player));

            
            
        } while (!interact.equals("Quit") && !interact.equals("quit"));

        sc.close();
    }
}
