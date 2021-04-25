package game;

import player.Player;
import world.Cells;
import world.Door;
import world.container.Box;
import world.objects.Heal;
import world.objects.Key;




public class Game {

    protected Cells[][] gameTab;
    protected int columns, lines;
    
    /**
     * The constructor of the Game
     */
    public Game() {
        columns = 8; lines = 4;

        gameTab = new Cells[lines][columns];

        for (int i = 0; i < lines; i++)
            for (int j = 0; j < columns; j++)
                gameTab[i][j] = new Cells();

        //init of first column
        getCells(0, 0).setDoor(new Door(new Key("Snake")), null, null, new Door());
        getCells(1, 0).setDoor(null, getCells(0, 0).getDoor('E'), null, new Door());
        getCells(2, 0).setDoor(null, getCells(1, 0).getDoor('E'), new Door(), new Door());
        getCells(3, 0).setDoor(null, getCells(2, 0).getDoor('E'), new Door(), null);
        //init of second column
        getCells(0, 1).setDoor(new Door(), null, getCells(0, 0).getDoor('N'), new Door());
        getCells(1, 1).setDoor(null, getCells(0, 1).getDoor('E'), null, null);
        getCells(2, 1).setDoor(new Door(), null, null, new Door());
        getCells(3, 1).setDoor(new Door(), getCells(2, 1).getDoor('E'), null, null);
        //init third column
        getCells(0, 2).setDoor(null, null, getCells(0, 1).getDoor('N'), new Door());
        getCells(1, 2).setDoor(null, getCells(0, 2).getDoor('E'), null, new Door());
        getCells(2, 2).setDoor(new Door(new Key("Fox")), getCells(1, 2).getDoor('E'), getCells(2, 1).getDoor('N'), new Door());
        getCells(3, 2).setDoor(null, null, getCells(3, 1).getDoor('N'), null);
        //init fourth column
        getCells(0, 3).setDoor(null, null, null, new Door());
        getCells(1, 3).setDoor(new Door(new Key("Spider")), getCells(0, 3).getDoor('E'), null, new Door());
        getCells(2, 3).setDoor(null, getCells(1, 3).getDoor('E'), getCells(2, 2).getDoor('N'), new Door());
        getCells(3, 3).setDoor(null, getCells(2, 3).getDoor('E'), null, null);

        //init box of the game board
        getCells(3, 0).setBox(new Box(new Key(), true));

        //init keys of the game board
        getCells(1, 1).addObject(getCells(1, 3).getDoor('N').getKey());
        getCells(3, 2).addObject(getCells(2, 2).getDoor('N').getKey());
        getCells(2, 0).addObject(getCells(3, 0).getBox().getKey());
        getCells(3, 0).getBox().addItems(getCells(0, 0).getDoor('N').getKey());
        getCells(3, 0).getBox().addItems(new Heal());

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
     * @param x The X position of the tab
     * @param y The Y position of the tab
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
        s +="\nCompas:\n   W\nS --> N\n   E\n\n";

        s += "Map:\n";
        for (int i = 0; i < columns; i++) {
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
        s += "\n";
        return s;
    }
}
