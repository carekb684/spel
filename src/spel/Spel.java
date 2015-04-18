package spel;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Spel extends Applet implements Runnable {

    

    @Override
    public void run() {
        millis = System.currentTimeMillis();

        

        while (true) {
            
            
            
            gubbe.moveHoriz(keyLi);

            letTheBoxesHaveFun(gubbe);

            boolean krash = anyBoxContains(gubbe);
            if (krash) {
                gubbe.x = gubbe.ox;
            }

            gubbe.moveVert(keyLi, krash);

            int dy = 1;
            if (gubbe.vy > 0) {
                dy = -1;
            }

            while (anyBoxContains(gubbe)) {
                gubbe.y += dy;
                gubbe.vy = 0;
            }

            update(getGraphics());

            try {
                Thread.sleep(5);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void init() {
        setPreferredSize(new Dimension(1520, 800));
        //setSize(1520, 800);
        BanCreator.loadBana(banaList);
    }

    @Override
    public void start() {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void update(Graphics g) {

        if (bgi == null) {
            bgi = new BufferedImage(1520, 800, BufferedImage.TYPE_INT_ARGB);
            requestFocus();
        }

        bgi.getGraphics().setColor(Color.WHITE);
        bgi.getGraphics().fillRect(0, 0, 1520, 800);
        paint(bgi.getGraphics());
        try {
            g.drawImage(bgi, 0, 0, this);
        } catch (Exception e) {
        }

    }

    @Override
    public void paint(Graphics g) {
        
        for (Tile tile : banaList) {
            tile.paint(g);
        }
        
        String str = String.format("%d.%d", (System.currentTimeMillis() - millis) / 1000, ((System.currentTimeMillis() - millis) / 100) % 10);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Calibri", Font.PLAIN, 40));
        g.drawString(str, 100, 65);

        
        
        int yCordTime = 0;
        for (int i = 0; i < BanCreator.level; i++) {
            g.setFont(new Font("Calibri", Font.PLAIN, 20));
            g.drawString("Level " + strBanaTid[i], 40, 100 + yCordTime);
            yCordTime += 35;
        }

        

        gubbe.paint(g);
    }

    private boolean anyBoxContains(Gubbe gubbe) {
        for (Tile tile : banaList) {
            if (tile.stops(gubbe)) {
                return true;
            }
        }
        return false;
    }

    private BufferedImage bgi = null;
    private KeyLi keyLi = new KeyLi(this);

    private void letTheBoxesHaveFun(Gubbe gubbe) {
        for (Tile tile : banaList) {
            if (tile.playWith(gubbe, banaList)) {
                if (tile.isRed()) {
                    strBanaTid[BanCreator.level - 1] = (BanCreator.level) + "  " + String.format("%d.%d", (System.currentTimeMillis() - millis) / 1000, ((System.currentTimeMillis() - millis) / 100) % 10);
                }
                break;
            }
        }
    }

    long millis;
    Gubbe gubbe = new Gubbe();
    String[] strBanaTid = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    ArrayList<Tile> banaList = new ArrayList();
    
}
