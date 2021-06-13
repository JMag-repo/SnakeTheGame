package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Klasa przedstawiająca AI dla węża, wąż omija przeszkody i ściany, jego celem jest zjedzenie najbliższego owocu
 */



public class SnakeAI {



    public static Snake2 AISnake = new Snake2();
    public static ArrayList<PickUp> PickUps = new ArrayList<>();
    public static Integer[] Distances = new Integer[5];

    /**
     * Wypełnienie listy owoców
     */
    public static void fillPickUps() {
        PickUps.add(AISnake.pickup);
        PickUps.add(AISnake.pickup2);
        PickUps.add(AISnake.pickup3);
        PickUps.add(AISnake.pickup4);
        PickUps.add(AISnake.pickup5);
    }

    /**
     * Odległość od owoców metodą manhattan
     *
     * @param myPickup owoc
     * @return odległość od owocu
     */
    public static int manhattanDis(PickUp myPickup) {
        int xPos = Math.abs(AISnake.head.getX() - myPickup.getX());
        int yPos = Math.abs(AISnake.head.getY() - myPickup.getY());
        return xPos + yPos;
    }

    /**
     * Obliczenie odległości dla owoców
     */
    public static void calcDist() {
        Distances[0] = manhattanDis(PickUps.get(0));
        Distances[1] = manhattanDis(PickUps.get(1));
        Distances[2] = manhattanDis(PickUps.get(2));
        Distances[3] = manhattanDis(PickUps.get(3));
        Distances[4] = manhattanDis(PickUps.get(4));
    }

    /**
     * zwraca najbliższy owoc
     *
     * @return
     */
    public static PickUp GetClosestFruit() {
        fillPickUps();
        calcDist();
        int min = Collections.min(Arrays.asList(Distances));
        int argmin = 0;
        for (int i = 0; i < Distances.length; i++) {
            if (Distances[i] == min)
                argmin = i;
        }

        return PickUps.get(argmin);

    }

    /**
     * Zmienia kierunke głowy wężą jeżeli wąż ma zamiar wjechać w ściane
     */

    public static void AvoidWalls() {
        int SnakeX = AISnake.head.getX();
        int SnakeY = AISnake.head.getY();
        if (SnakeX == 0 && AISnake.head.getDir() == Dir.LEFT)
            AISnake.head.setDir(Dir.DOWN);
        if (SnakeX == 41 && AISnake.head.getDir() == Dir.RIGHT)
            AISnake.head.setDir(Dir.DOWN);
        if (SnakeY == 0 && AISnake.head.getDir() == Dir.UP && SnakeY <= 20)
            AISnake.head.setDir(Dir.RIGHT);
        if (SnakeY == 0 && AISnake.head.getDir() == Dir.UP && SnakeY > 20)
            AISnake.head.setDir(Dir.LEFT);
        if (SnakeY == 41 && AISnake.head.getDir() == Dir.DOWN && SnakeY > 20)
            AISnake.head.setDir(Dir.LEFT);
        if (SnakeY == 41 && AISnake.head.getDir() == Dir.DOWN && SnakeY <= 20)
            AISnake.head.setDir(Dir.RIGHT);

    }

    /**
     * Zmienia kierunek głowy węża jeżeli wąż ma zamiar wjechać w przeszkode
     */
    public static void AvoidObstacle() {
        int SnakeX = AISnake.head.getX();
        int SnakeY = AISnake.head.getY();

        if (SnakeY == 18 && SnakeX > 5 && SnakeX < 36)
            if (AISnake.head.getDir() == Dir.DOWN)
                AISnake.head.setDir(Dir.LEFT);
        if (SnakeY == 23 && SnakeX > 5 && SnakeX < 36)
            if (AISnake.head.getDir() == Dir.UP)
                AISnake.head.setDir(Dir.LEFT);
        if (SnakeX == 5 && SnakeY > 18 && SnakeY < 23)
            if (AISnake.head.getDir() == Dir.RIGHT)
                AISnake.head.setDir(Dir.UP);
        if (SnakeX == 36 && SnakeY > 18 && SnakeY < 23)
            if (AISnake.head.getDir() == Dir.LEFT)
                AISnake.head.setDir(Dir.UP);


    }


    /**
     * szuka kolejnego ruchu tak aby zjeść najbliższy owoc i nie zderzyć się ze ściana ani prezszkodą
     *
     * @param closest najbliższy owoc
     */
    public static void searchMove(PickUp closest) {
        int x = closest.getX();
        int y = closest.getY();
        if ((AISnake.head.getDir() == Dir.RIGHT || AISnake.head.getDir() == Dir.LEFT)) {

            AvoidWalls();


            if (AISnake.head.getX() > x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() == x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() > x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() > x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() == x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() > x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() < x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() == x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() < x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.RIGHT);
            if (AISnake.head.getX() < x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() == x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() < x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.RIGHT);
            AvoidObstacle();
            if (AISnake.head.getX() == 5 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y <= 19)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() == 5 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y > 19)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() == 36 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y <= 19)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() == 36 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y > 19)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() >1 && AISnake.head.getX() <5 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y > 19)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() >1 && AISnake.head.getX() <5 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y <= 19)
                AISnake.head.setDir(Dir.UP);
            //AvoidObstacle();

        } else if ((AISnake.head.getDir() == Dir.UP || AISnake.head.getDir() == Dir.DOWN)) {

            AvoidWalls();


            if (AISnake.head.getX() > x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() == x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() > x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() > x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() == x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() > x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() < x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.RIGHT);
            if (AISnake.head.getX() == x && AISnake.head.getY() > y)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() < x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.RIGHT);
            if (AISnake.head.getX() < x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.RIGHT);
            if (AISnake.head.getX() == x && AISnake.head.getY() < y)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() < x && AISnake.head.getY() == y)
                AISnake.head.setDir(Dir.RIGHT);
            AvoidObstacle();
            if (AISnake.head.getX() == 5 && AISnake.head.getY() == 18 && AISnake.head.getY() <= 22 && y <= 19)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() == 5 && AISnake.head.getY() == 18 && AISnake.head.getY() <= 22 && y > 19)
                AISnake.head.setDir(Dir.LEFT);
            if (AISnake.head.getX() == 36 && AISnake.head.getY() == 18 && AISnake.head.getY() <= 22 && y <= 19)
                AISnake.head.setDir(Dir.UP);
            if (AISnake.head.getX() == 36 && AISnake.head.getY() == 18 && AISnake.head.getY() <= 22 && y > 19)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() >1 && AISnake.head.getX() <5 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y > 19)
                AISnake.head.setDir(Dir.DOWN);
            if (AISnake.head.getX() >1 && AISnake.head.getX() <5 && AISnake.head.getY() >= 18 && AISnake.head.getY() <= 22 && y <= 19)
                AISnake.head.setDir(Dir.UP);


        }

    }

    /**
     * Metoda odpowiedzialna za znalezienie najbliższego owocu i wykonanie ruchu przybliżającego wężą do zjedzenia tego owocu
     */
    public static void AIMove() {
        PickUp closest = GetClosestFruit();
        searchMove(closest);
    }
}
