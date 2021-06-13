package gui;

import actions.KeyHandler;
import clocks.GameClock;

import javax.swing.*;

/**
 * Klasa przedstawiająca graficzny interfejs użytkownika
 */
public class Gui {
    public static int width = 1200, height = 1050;
    public static int xoff = 145, yoff = 35;
    public static int dimension = 22;
    public static State st;

    JFrame jf;
    Draw d;

    /**
     * Metoda tworząca okno menu
     */
    public void create(){
        jf = new JFrame("Snake");
        jf.setSize(width,height);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);
        jf.addKeyListener(new KeyHandler());

        st = State.HOME;

        d = new Draw();
        d.setBounds(0,0,width,height);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);

    }

    /**
     * Metoda zwraca status gry
     * @return status gry
     */
    public static State getSt()
    {
        return st;
    }

    /**
     * Metoda ustawia status gry
     * @param st
     */
    public void setSt(State st)
    {
        Draw.st = st;
    }


}

