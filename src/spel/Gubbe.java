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
   
    
    void paint(Graphics g) {

        
        if(vx<0 ){
            
            g.drawImage(ImageHandler.get("gubbe.png"),(int)x+W,(int)y,-W,H,null);
        }
        else{
            
            g.drawImage(ImageHandler.get("gubbe.png"),(int)x,(int)y,W,H,null);
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
