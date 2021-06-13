package game;

import gui.Gui;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa przedstawiająca węża zawiera w sobie obiekty head, tail, frog,pickup
 */
public class Snake {

    public static int score = 0;

    public static boolean waitToMove = false;

    public static Head head = new Head(7, 7);

    public static ArrayList<Tail> tails = new ArrayList<>();

    public static PickUp pickup = new PickUp();
    public static PickUp pickup2 = new PickUp();
    public static PickUp pickup3 = new PickUp();
    public static PickUp pickup4 = new PickUp();
    public static PickUp pickup5 = new PickUp();
    public static Frog frog = new Frog();

    /**
     * Metoda dodająca ogon wężowi
     */
    public static void addTail() {
        if (tails.size() < 1) {
            tails.add(new Tail(head.getX(), head.getY()));
        } else {
            tails.add(new Tail(tails.get(tails.size() - 1).x, tails.get(tails.size() - 1).y));
        }
    }

    /**
     * Metoda wykonująca ruch węża, poprzez ruch głowy i tłowia
     */
    public static void move() {
        //Move Tails
        if (tails.size() >= 2) {
            for (int i = tails.size() - 1; i >= 1; i--) {
                if (tails.get(i).isWait()) {
                    tails.get(i).setWait(false);
                } else {
                    tails.get(i).setX(tails.get(i - 1).getX());
                    tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }

        //Move first Tail to Head
        if (tails.size() >= 1) {
            if (tails.get(0).isWait()) {
                tails.get(0).setWait(false);
            } else {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        //Move Head
        switch (head.getDir())
        {
            case RIGHT -> head.setX(head.getX() + 1);
            case UP -> head.setY(head.getY() - 1);
            case LEFT -> head.setX(head.getX() - 1);
            case DOWN -> head.setY(head.getY() + 1);
        }

    }

    /**
     * Zwraca polożenie x-owe i y-owe węża do struktury
     * @param x
     * @param y
     * @return
     */
    //Position to Coordiantes
    public static Point ptc(int x, int y) {
        Point p = new Point(0, 0);
        p.x = x * Gui.dimension + Gui.xoff;
        p.y = y * Gui.dimension + Gui.yoff;

        return p;
    }

}
