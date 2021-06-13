package gui;

import clocks.GameClock;
import game.Frog;
import game.Score;
import game.Snake;
import game.SnakeAI;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa przedstawiająca graficzną wersje planszy i elementów na niej
 */
public class Draw extends JLabel {

    public static State st = State.GAME;
    public static Point p;
    public static Point f;

    /**
     * Metoda rysująca obiekty na planszy
     * @param g element graficzny
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        //Draw Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Gui.width, Gui.height);

        if (Gui.getSt() == State.GAME) {
            //Draw Snake Tails
            g.setColor(new Color(51, 204, 51));
            for (int i = 0; i < Snake.tails.size(); i++)
            {
                p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
                g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);
            }

            //Draw Snake Head
            g.setColor(new Color(238, 201, 0));
            p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);

            //Draw AiSnake Head
            g.setColor(new Color(64, 0, 123));
            p = SnakeAI.AISnake.ptc(SnakeAI.AISnake.head.getX(), SnakeAI.AISnake.head.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);
            //AiSnake tails
            g.setColor(new Color(121, 14, 51));
            for (int i = 0; i < SnakeAI.AISnake.tails.size(); i++)
            {
                p = SnakeAI.AISnake.ptc(SnakeAI.AISnake.tails.get(i).getX(), SnakeAI.AISnake.tails.get(i).getY());
                g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);
            }



            //Draw PickUp
            g.setColor(new Color(204, 51, 0));
            p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);

            g.setColor(new Color(255, 140, 0));
            p = Snake.ptc(Snake.pickup2.getX(), Snake.pickup2.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);

            g.setColor(new Color(191, 62, 255));
            p = Snake.ptc(Snake.pickup3.getX(), Snake.pickup3.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);

            g.setColor(new Color(0, 0, 255));
            p = Snake.ptc(Snake.pickup4.getX(), Snake.pickup4.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);

            g.setColor(new Color(0, 255, 255));
            p = Snake.ptc(Snake.pickup5.getX(), Snake.pickup5.getY());
            g.fillRect(p.x, p.y, Gui.dimension, Gui.dimension);

            //Draw Grid
            g.setColor(new Color(51, 204, 51));
            for (int i = 0; i < 42; i++)
            {
                for (int j = 0; j < 42; j++)
                {
                    g.drawRect(i * Gui.dimension + Gui.xoff, j * Gui.dimension + Gui.yoff, Gui.dimension, Gui.dimension);
                }
            }

            //Draw Border
            g.setColor(new Color(51, 204, 51));
            g.drawRect(Gui.xoff, Gui.yoff, 594, 594);

            //Draw Score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Current score: " + Snake.score, 5, 25);

            //Draw Obstacle
            g.setColor(Color.gray);
            for (int i = 6; i < 36; i++){
                for (int j = 19; j < 23; j++){
                    g.fillRect(i * Gui.dimension + Gui.xoff, j * Gui.dimension + Gui.yoff, Gui.dimension, Gui.dimension);
                }

            }

            //Draw Frog
            g.setColor(new Color(138,54,15));
            f = Frog.ptc(Snake.frog.getX(), Snake.frog.getY());
            g.fillRect(f.x, f.y, Gui.dimension, Gui.dimension);

        } else if (Gui.getSt() == State.OVER) {
            //Draw GAME OVER screen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g.drawString("Press SPACE to restart!", Gui.width / 2 + 40, Gui.height / 2 + 150);
            g.drawString("Press CTRL to back to menu!", Gui.width / 2, Gui.height / 2 + 180);
            g.drawString("Press ESC to exit!", Gui.width / 2 + 70, Gui.height / 2 + 210);
            ImageIcon img = new ImageIcon("./src/img/defeat.png");
            img.paintIcon(this, g, 86, 200);
            g.setFont(new Font("Times New Roman", Font.BOLD, 60));
            g.drawString("TOP 10", 60, 550);
            g.setFont(new Font("Times New Roman", Font.BOLD, 25));
            for (int i = 0; i <= Score.points.size() - 1; i++){
                if (i == 9){
                    g.drawString((i+1 + ". " + " Score: " + Score.points.get(i)), 86, 960);
                } else if (i < 9) {
                    g.drawString((i+1 + ". " + " Score: " + Score.points.get(i)), 100, 600 + i*40);
                }
            }
        } else if (Gui.getSt() == State.HOME){
            //Draw HOME screen
            g.setColor(Color.WHITE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            g.drawString("Press SPACE to start!", Gui.width/2 - 130, Gui.height - 220);
            g.drawString("Press ESC to exit!", Gui.width/2 - 105, Gui.height - 190);
            g.drawString("Press CTRL to choose level!", Gui.width/2 - 170, Gui.height - 130);
            g.drawString("Current level: " + lvl(), Gui.width/2 - 120, Gui.height - 100);
            ImageIcon img = new ImageIcon(pth());
            Image newimage = img.getImage();
            Image newimg = newimage.getScaledInstance(600, 450, Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            img.paintIcon(this, g, 300, 300);
            g.setColor(Color.BLUE);
            g.setFont(new Font("Times New Roman", Font.BOLD, 80));
            g.drawString("SNAKE", Gui.width/2 - 150, 150);
            g.setColor(Color.GREEN);
            g.setFont(new Font("Times New Roman", Font.BOLD, 90));
            g.drawString("SNAKE", Gui.width/2 - 160, 160);
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.BOLD, 100));
            g.drawString("SNAKE", Gui.width/2 - 170, 170);
        }

        repaint();

    }

    /**
     * Metoda zwracająca poziom trudności
     * @return
     */
    public String lvl(){
        if (GameClock.level == 100){
            return "HARD";
        } else if (GameClock.level == 150){
            return "MEDIUM";
        } else {
            return "EASY";
        }
    }

    /**
     * Zmiana koloru węża w menu w zależności od stopnia trudności
     * @return
     */
    public String pth(){
        if (GameClock.level == 100){
            return "./src/img/snake3.png";
        } else if (GameClock.level == 150){
            return "./src/img/snake2.png";
        } else {
            return "./src/img/snake1.png";
        }
    }

}
