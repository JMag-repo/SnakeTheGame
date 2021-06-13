package game;

/**
 * Klasa przedstawiająca głowe węża
 */
public class Head {
    Dir dir = Dir.RIGHT;
    int x,y;

    /**
     * Konstruktor przypisujący położenie x i y na planszy
     * @param x punkt na planszy
     * @param y punkt na planszy
     */
    public Head(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metoda zwracająca kierunku głowy węża
     * @return kierunek głowy węża
     */
    public Dir getDir() {
        return dir;
    }

    /**
     * Metoda ustawiająca kierunek głowy węża, sprawdza czy zmiana jest dozwolona
     * tj. zmiana ruchu nie może nastąpić o 180 stopni
     * @param dir kierunek do ustawienia
     */
    public void setDir(Dir dir) {
        if(dir == Dir.LEFT)
            if(this.dir != Dir.RIGHT )
                this.dir = dir;
        if(dir == Dir.UP)
            if(this.dir != Dir.DOWN )
                this.dir = dir;
        if(dir == Dir.DOWN)
            if(this.dir != Dir.UP )
                this.dir = dir;
        if(dir == Dir.RIGHT)
            if(this.dir != Dir.LEFT )
                this.dir = dir;


    }

    /**
     * Metoda zwraca x glowy węza
     * @return położenie x
     */
    public int getX() {
        return x;
    }

    /**
     * Metoda ustawia położenie x glowy weża
     * @param x polozenie x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Metoda zwraca polozenie x na planszy
     * @return polozenie glowy weza y
     */
    public int getY() {
        return y;
    }

    /**
     * Metoda ustawia polozenie y na planszy
     * @param y polozenie y
     */
    public void setY(int y) {
        this.y = y;
    }
}
