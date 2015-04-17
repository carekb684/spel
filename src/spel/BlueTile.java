package spel;

import java.awt.Color;
import java.util.ArrayList;

public class BlueTile extends Tile {

    public BlueTile(int x, int y, int w) {
        super(x, y, w);

    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {
            checkpointx = gubbe.x;
            checkpointy = gubbe.y;
            checkpoint = true;
            
            return true;
        }

        return false;
    }

}
