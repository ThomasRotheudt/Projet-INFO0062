package Code;

import java.util.Scanner;

import Code.World.Cells;
import Code.World.Door;


public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String choice = " ";

        Cells cellule = new Cells(null, null, null, null);

        System.out.println(cellule.toString());

        System.out.println("\n\tWelcome to the jungle!\t\n");
        
        do {
            

            choice = sc.nextLine();
            
            
        } while (choice == "Quit");
        sc.close();
    }
}
