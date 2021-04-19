package Code.Game;

import java.util.Vector;

import Code.Player.Player;
import Code.World.Cells;
import Code.World.Door;

public class Game {
    protected Vector<Vector<Cells>> gameTab;
    protected int columns, lines;
    
    public Game() {
        columns = 5; lines = 5;

        gameTab = new Vector<Vector<Cells>>();
        Vector <Cells> e;
        Cells c;
        Door d = new Door();

        for (int i = 0; i < columns; i++) {
            e = new Vector<Cells>();
            for (int j = 0; j < lines; j++) {
                c = new Cells(d, null, d, null);
                e.add(c);
            }
            gameTab.add(e);
        }
    }

    public int getColumns(){
        return columns;
    }

    public int getLines(){
        return lines;
    }

    public Cells getCells(int x, int y) {
        return gameTab.get(x).get(y);
    }

    public String toString(Player player){
        String s = " ";

        s += "\nLegend:\n\t O:Player\n\t|_|:cell\n\n";

        s +="Compas:\n   O\nS --> N\n   E\n\n";

        s += "Map:\n";
        for (int i = 0; i < columns; i++) {
            s += "\n";
            for (int j = 0; j < lines; j++) {
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
