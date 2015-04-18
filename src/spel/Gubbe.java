package spel;

import java.awt.Graphics;
import static java.awt.event.KeyEvent.VK_LEFT;
import static java.awt.event.KeyEvent.VK_RIGHT;
import static java.awt.event.KeyEvent.VK_UP;

public class Gubbe {

    double x = 50;
    double y = 710;
    double ox=x, oy=y;
    final int W = 40;
    final int H = 40;
    double vx, vy;
    double G = 0.2;
    static String character="";
    
    void paint(Graphics g) {

        
        if(character.equals("Carl") || character.equals("")){
            g.drawImage(ImageHandler.get("Carl.png"),(int)x+W,(int)y,-W,H,null);
        }
        if(character.equals("Tim")){
            g.drawImage(ImageHandler.get("Tim.png"),(int)x+W,(int)y,-W,H,null);
        }
       if(character.equals("Erik")){
            g.drawImage(ImageHandler.get("Erik2.png"),(int)x+W,(int)y,-W,H,null);
        }
       if(character.equals("Philip")){
            g.drawImage(ImageHandler.get("Philip.png"),(int)x+W,(int)y,-W,H,null);
        }
        
        
    }
    
    void moveHoriz(KeyLi keyLi) {
        ox=x;
        
        if (keyLi.isDown(VK_LEFT)) {
            vx = -4;
        } else if (keyLi.isDown(VK_RIGHT)) {
            vx = 4;
        } else {
            vx= 0;
        }
        
        x+= vx;
    }
        
    void moveVert(KeyLi keyLi, boolean canNotJump) {
        
        if (keyLi.isDown(VK_UP) && vy==0 && !canNotJump) {
            vy= -10;
        }

        oy=y;

        //gubbe gravitation
        y += vy; //s= Vo + at^2/2;
        y += G / 2;
        vy += G;

    }


    
}
