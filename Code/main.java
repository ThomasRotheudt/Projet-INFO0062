package Code;

import java.util.ArrayList;
import java.util.Scanner;

import Code.Game.Game;
import Code.Player.Player;


public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String interact = " ";
        Game game = new Game();
        Player player = new Player(game.getCells(0, 0));

        System.out.println("\n\t\t\t\t\tWelcome adventurer\n After weeks of searching for a dungeon, you enter what appears to be the lair of an unknown monster\n");
        
        do {
            System.out.println(player.getCurrentCell().toString()+"\n");

            System.out.println("What will you do adventurer:");
            interact = sc.nextLine();

            if(interact.substring(0, 4).equals("move"))
                player.move(interact.substring(5), game);
            
            if(interact.substring(0, 4).equals("turn"))
                player.turn(interact.substring(5), game);
            
            System.out.println(player.toString());
        } while (!interact.equals("Quit") && !interact.equals("quit"));

        sc.close();
    }
}
