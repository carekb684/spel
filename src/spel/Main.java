package spel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class Main extends Frame{
    Spel spel = new Spel();
    
    public Main(){
        
        spel.init();
    //    spel.setPreferredSize(new Dimension(1520,800));
        pack();
        setVisible(true);
        spel.start();
        
        add("Center",spel);
        addWindowListener(closer());
        fixMenus();
        
        
        
    }

    public static void main(String[] args) {
       
        new Main();

    }

    private WindowListener closer() {
        return new WindowAdapter(){
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    };
    }

    private void fixMenus() {
       MenuBar bar = new MenuBar();
       Menu menu = new Menu("Game");
       MenuItem item = new MenuItem("New Game");
       
       menu.add(item);
       item.addActionListener(newGame());
       bar.add(menu);
       setMenuBar(bar);
       
    }

    private ActionListener newGame() {
       return new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent ae) {
            remove(spel);
            spel = new Spel();
            spel.init();
            add("Center",spel);
            validate();
            spel.start();
           }
           
       };
    }
}
