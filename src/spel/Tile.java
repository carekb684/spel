package spel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Tile extends Rectangle {

    public static final int BLACK = 0, RED = 1, GREEN = 2, YELLOW = 3, BLUE = 4, PINK=5, MAGENTA=5;
    static double checkpointx, checkpointy;
    static boolean checkpoint = false;
    
    boolean removable = false;
    boolean addable = false;
    
    
    public Tile(int x, int y, int w) {
        super(x, y, w, w);
    }

    public abstract Color getColor();

    void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(x, y, width, height);
    }

    boolean isRed() {
        return false;
    }

    abstract boolean playWith(Gubbe gubbe, ArrayList<Tile> banaList);

    boolean stops(Gubbe gubbe) {
        return false;
    }

}
