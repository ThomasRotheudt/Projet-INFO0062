package Code.Game;

import java.util.Vector;

import Code.World.Cells;

public class Game {
    protected Vector<Vector<Cells>> gameTab;
    protected int columns, lines;
    
    public Game() {
        columns = 10; lines = 10;

        gameTab = new Vector<Vector<Cells>>();
        Vector <Cells> e;
        Cells c;

        for (int i = 0; i < lines; i++) {
            e = new Vector<Cells>();
            for (int j = 0; j < columns; j++) {
                c = new Cells();
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
}
