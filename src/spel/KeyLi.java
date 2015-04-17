package spel;

import java.applet.Applet;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;

class KeyLi implements KeyListener{
    HashSet<Integer> set= new HashSet();
    
    KeyLi(Applet applet) {
        applet.addKeyListener(this);
    }
    
    public boolean isDown(int code){
        return set.contains(code);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        set.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        set.remove(e.getKeyCode());
    }

    
    
}
