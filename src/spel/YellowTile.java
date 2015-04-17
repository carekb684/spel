package spel;

import java.awt.Color;
import java.util.ArrayList;

public class YellowTile extends Tile {

    public YellowTile(int x, int y, int w) {
        super(x, y, w);
        
    }
    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {

            gubbe.vx = 0;
            gubbe.vy = 0;
            if (checkpoint) {
                gubbe.x = checkpointx;
                gubbe.y = checkpointy;

            } else {
                gubbe.x = 50;
                gubbe.y = 710;

            }
        }
        return false;

    }
}
