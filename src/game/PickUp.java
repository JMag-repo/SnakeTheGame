package game;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Klasa przedstawiajaca owoce na planszy
 *
 */
public class PickUp {
    int x, y;

    /**
     * Konstruktor generujacy losowe polozenie owocu na planszy
     */
    public PickUp(){
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);

        if (x >= 6 && x <= 36 && y >= 19 && y <= 23){
            this.x = ThreadLocalRandom.current().nextInt(0,41);
            this.y = ThreadLocalRandom.current().nextInt(0,41);
        }

    }

    /**
     * Metoda generujaca nowe polozenie owocu na planszy
     */
    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,41);
        this.y = ThreadLocalRandom.current().nextInt(0,41);

        if (x >= 6 && x <= 36 && y >= 19 && y <= 23){
            this.x = ThreadLocalRandom.current().nextInt(0,41);
            this.y = ThreadLocalRandom.current().nextInt(0,41);
        }
    }

    /**
     * Metoda zwraca polozenie owocu na planszy
     * @return polozenie x owocu na planszy
     */
    public int getX() {
        return x;
    }

    /**
     * Metoda ustawiajaca polozenie x owocu na planszy
     * @param x polozenie x owocu na planszy
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metoda zwracajaca polozenie owocu x na planszy
     * @return polozenie owocu y na planszy
     */
    public int getY() {
        return y;
    }

    /**
     * Metoda ustawiajaca polozenie y na planszy
     * @param y polozenie y na planszy
     */
    public void setY(int y) {
        this.y = y;
    }
}
