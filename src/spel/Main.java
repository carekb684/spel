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


//    1.Black tiles komma tillbaka efter död
//    2.'+' tiles som kommer vid Violet Tile
//    3.Tid på att komma tillbaka
//    4. Death counter

public class Main extends Frame {

    Spel spel = new Spel();
    String character="";
    
    public Main() {

        spel.init();
        //    spel.setPreferredSize(new Dimension(1520,800));
        pack();
        setVisible(true);
        spel.start();

        add("Center", spel);
        addWindowListener(closer());
        fixMenus();

    }

    public static void main(String[] args) {

        new Main();

    }

    private WindowListener closer() {
        return new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        };
    }

    private void fixMenus() {

        

        MenuBar bar = new MenuBar();
        Menu gamemenu = new Menu("Game");
        MenuItem item = new MenuItem("New Game");
        gamemenu.add(item);
        item.addActionListener(newGame());

        Menu charmenu = new Menu("Characters");
        MenuItem charCarl = new MenuItem("Carl");
        MenuItem charTim = new MenuItem("Tim");
        MenuItem charPhilip = new MenuItem("Philip");
        MenuItem charErik = new MenuItem("Erik");
        charmenu.add(charCarl);
        charmenu.add(charPhilip);
        charmenu.add(charTim);
        charmenu.add(charErik);
        charCarl.addActionListener(charCarl());
        charTim.addActionListener(charTim());
        charErik.addActionListener(charErik());
        charPhilip.addActionListener(charPhilip());

        bar.add(charmenu);
        bar.add(gamemenu);
        setMenuBar(bar);

    }

    private ActionListener newGame() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                remove(spel);
                spel = new Spel();
                spel.init();
                add("Center", spel);
                validate();
                spel.start();
                BanCreator.level = 0;
            }

        };
    }

    private ActionListener charCarl() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Gubbe.character ="Carl";
            }

        };
    }
    private ActionListener charPhilip() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
               
                Gubbe.character ="Philip";
            }

        };
    }
    private ActionListener charTim() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Gubbe.character ="Tim";
            }

        };
    }
    private ActionListener charErik() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                
                Gubbe.character ="Erik";
            }

        };
    }
    
   
            
}
