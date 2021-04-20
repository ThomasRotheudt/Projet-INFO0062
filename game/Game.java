package game;

import java.util.Vector;
import player.Player;
import world.Cells;
import world.Door;




public class Game {

    protected Cells[][] gameTab;
    protected int columns, lines;
    
    /**
     * The constructor of the Game
     */
    public Game() {
        columns = 4; lines = 4;

        gameTab = new Cells[lines][columns];

        for (int i = 0; i < lines; i++)
            for (int j = 0; j < columns; j++)
                gameTab[i][j] = new Cells();

    }

    /**
     * @return The number of columns in the game board
     */
    public int getColumns(){
        return columns;
    }

    /**
     * @return The number of rows in the game board
     */
    public int getLines(){
        return lines;
    }

    /**
     * 
     * @param x The X position of the cell
     * @param y The Y position of the cell
     * @return The cell whose the position is (X,Y)
     */
    public Cells getCells(int x, int y) {
        return gameTab[x][y];
    }

    /**
     * 
     * @param player The player which we're going to show
     * @return The current state of the map
     */
    public String toString(Player player){
        String s = " ";
        s +="\nCompas:\n   O\nS --> N\n   E\n\n";

        s += "Map:\n";
        for (int i = 0; i < lines; i++) {
            s += " _";
        }
        for (int i = 0; i < lines; i++) {
            s += "\n";
            for (int j = 0; j < columns; j++) {
                if(i == player.getX() && j == player.getY() && j == 0)
                    s += "|O|";
                else if(i == player.getX() && j == player.getY())
                    s += "O|";
                else if(j == 0)
                    s += "|_|";
                else
                    s += "_|";
            }
        }
        return s;
    }
}
