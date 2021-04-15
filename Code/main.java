package Code;

import java.util.Scanner;


public class main {
    public static void main() {

        Scanner sc = new Scanner(System.in);
        String choice = " ";

        System.out.println("\n\tWelcome to the jungle!\t\n");
        
        do {
            

            choice = sc.nextLine();
            
            
        } while (choice == "Quit");
        sc.close();
    }
}
