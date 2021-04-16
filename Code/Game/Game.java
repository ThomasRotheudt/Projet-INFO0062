package Code.Game;

import java.util.Vector;

import Code.World.Cells;

public class Game {
    protected Vector<Vector<Cells>> gameTab;

    
    public Game() {

        gameTab = new Vector<Vector<Cells>>();
        Vector <Cells> e;
        Cells c;

        for (int i = 0; i < 10; i++) {
            e = new Vector<Cells>();
            for (int j = 0; j < 10; j++) {
                c = new Cells();
                e.add(c);
            }
            gameTab.add(e);
        }
    }

    public Cells getCells(int x, int y) {
        return gameTab.get(x).get(y);
    }
}
