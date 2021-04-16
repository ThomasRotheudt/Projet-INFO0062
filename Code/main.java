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
        Player player = new Player(game.gameTab.get(0).get(0));

        System.out.println("\n\tWelcome to the jungle!\t\n");
        
        do {
            System.out.println(player.currentCell.toString());
            interact = sc.nextLine();

            if(interact.substring(0, 4).equals("move"))
                player.move(interact.substring(5), game);
            
            if(interact.substring(0, 4).equals("turn"))
                player.turn(interact.substring(5), game);
            

        } while (!interact.equals("Quit") && !interact.equals("quit"));
        
        sc.close();
    }
}
