package spel;

import java.awt.Color;
import java.util.ArrayList;

public class BlackTile extends Tile {
    
    public BlackTile(int x, int y, int w, boolean removable, boolean addable) {
        super(x, y, w);
        this.removable= removable;
        this.addable = addable;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    boolean stops(Gubbe gubbe) {
        return intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H);
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (super.intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {
            gubbe.vx = 0;
        }
        return false;
    }

}
