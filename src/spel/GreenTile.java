package spel;

import java.awt.Color;
import java.util.ArrayList;

public class GreenTile extends Tile {

    public GreenTile(int x, int y, int w) {
        super(x, y, w);
       
    }
    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {
            gubbe.vy = -12;
        }
        return false;
    }

}
