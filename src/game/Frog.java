package game;

import gui.Gui;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Klasa zawierająca implementacje żaby, biegającej po planszy
 */
public class Frog {
    int x, y, jump;

    /**
     * Konstruktor klasy generujęacy losow położenie żaby
     */
    public Frog() {
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);
    }

    /**
     * Metoda generująca nowe losowe położenie żaby
     */
    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);
    }

    /**
     * Metoda odpowiadająca za poruszanie się żaby
     * @throws InterruptedException
     */
    public void move() throws InterruptedException
    {
        this.jump = ThreadLocalRandom.current().nextInt(0,4);

        if (jump == 0){
            if (getY() - 1 >= 0){
                setY(getY() - 1);
            }
        } else if (jump == 1) {
            if (getY() + 1 <= 41){
                setY(getY() + 1);
            }
        } else if (jump == 2) {
            if (getX() - 1 >= 0){
                setX(getX() - 1);
            }
        } else {
            if (getX() + 1 <= 41){
                setX(getX() + 1);
            }
        }
    }

    /**
     * Metoda zwracająca x-owe położenie żaby
     * @return x-owe położenie żaby
     */
    public int getX()
    {
        return x;
    }

    /**
     * Metoda ustanawiająca x-owe położenie żaby
     * @param x punkt x na planszy
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Metoda zwracająca y-owe położenie żaby
     * @return y-owe położenie żaby
     */
    public int getY()
    {
        return y;
    }

    /**
     * Metoda ustanawiająca y-owe położenie żaby
     * @param y punkt y na planszy
     */
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * Metoda wpisuje położenie żaby do struktury point
     * @param x położenie x na planszy
     * @param y połóżenie y na planszy
     * @return struktura Point z przypisanymi wartościami
     */
    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * Gui.dimension + Gui.xoff;
        p.y = y * Gui.dimension + Gui.yoff;

        return p;
    }

}
