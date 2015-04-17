package spel;

import java.awt.Color;
import java.util.ArrayList;

public class RedTile extends Tile {

    public RedTile(int x, int y, int w) {
        super(x, y, w);

    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {
            gubbe.vx = 0;
            gubbe.vy = 0;
            gubbe.x = 50;
            gubbe.y = 710;
            checkpoint = false;
            banaList.clear();
            BanCreator.level++;
            BanCreator.loadBana(banaList);

            return true;
        } else {
            return false;
        }

    }

    boolean isRed() {
        return true;
    }

}
