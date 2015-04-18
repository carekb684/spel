package spel;

import java.awt.Color;
import java.util.ArrayList;

public class PinkTile extends Tile {

    

    public PinkTile(int x, int y, int w) {
        super(x, y, w);

    }

    @Override
    public Color getColor() {
        return Color.PINK;
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {
            ArrayList stiffs = new ArrayList();
            for (Tile tile : banaList) {
                if (tile.removable) {
                    stiffs.add(tile);
                }
            }
            banaList.removeAll(stiffs);
            return true;
        }

        return false;
    }
    
    
    
    

}
