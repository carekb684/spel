package spel;

import java.awt.Color;
import java.util.ArrayList;


public class VioletTile extends Tile {
    
    static boolean addBlackTile=false;
    
    public VioletTile(int x, int y, int w) {
        super(x, y, w);
        
    }

    @Override
    public Color getColor() {
        return Color.MAGENTA;
    }

    @Override
    boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList) {
        if (intersects(gubbe.x, gubbe.y, gubbe.W, gubbe.H)) {
            
//            addBlackTile=true;
//            
//            
//            ArrayList stiffs = new ArrayList();
//            for (Tile tile : banaList) {
//                if (tile.addable) {
//                    stiffs.add(tile);
//                }
//            }
//            banaList.addAll(stiffs);
            return true;
        }

        return false;
    }

}
