package game;

/**
 * Klasa przedstawiająca tłów węza
 */
public class Tail {
    int x,y;
    boolean wait = true;

    /**
     * Konstruktor przypisujący polożenie do tłowia
     * @param x
     * @param y
     */
    public Tail(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Zwraca x-we położenie tłowia
     * @return położenie x na planszy
     */
    public int getX() {
        return x;
    }

    /**
     * Metoda ustwia położenie tłowia x na planszy
     * @param x położenie x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metoda zwraca y-owe położenie tłowia na planszy
     * @return y-owe położenie na planszy
     */
    public int getY() {
        return y;
    }

    /**
     * Metoda ustawia y-owe położenie tłowia na planszy
     * @param y y-owe położenie na planszy
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Metoda do zwracania true or false skł
     * @return true or false
     */
    public boolean isWait() {
        return wait;
    }

    /**
     * Metoda do ustawiania true or false skł
     * @param wait true or false
     */
    public void setWait(boolean wait) {
        this.wait = wait;
    }
}
