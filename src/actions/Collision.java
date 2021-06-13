package actions;

import clocks.GameClock;
import game.Snake;
import game.Snake2;

/**
 * Klasa zawierająca informacje o kolizjach węża z obiektami
 */
public class Collision {
    /**
     * Metoda sprawdza czy wąż skolidował sam ze sobą
     * @return true or false
     */
    public static boolean collideSelf() {
        for(int i = 0; i<Snake.tails.size(); i++){
            if(Snake.head.getX() == Snake.tails.get(i).getX() && Snake.head.getY() == Snake.tails.get(i).getY()
                    && !Snake.tails.get(i).isWait()){
                return true;
            }

        }

        return false;
    }

    /**
     * Metoda sprwadza czy waż uzytkownika wjechał w węża Ai
     * @return
     */
    public static boolean collideSelfAI() {
        for(int i = 0; i<Snake2.tails.size(); i++){
            if(Snake.head.getX() == Snake2.tails.get(i).getX() && Snake.head.getY() == Snake2.tails.get(i).getY()
                    && !Snake2.tails.get(i).isWait()){
                return true;
            }

        }

        return false;
    }

    /**
     * Metoda sprawdza czy wąż skolidował ze ścianą
     * @return true or false
     */
    public static boolean collideWall() {
        return (Snake.head.getX() < 0 || Snake.head.getX() > 41 || Snake.head.getY() < 0 || Snake.head.getY() > 41);
    }

    /**
     * Metoda sprawdzająca czu wąż zjadł owoc i dodająca punkty i dodatkowy elemnt tłowia
     */
    public static void collidePickUp() {
        if (Snake.head.getX() == Snake.pickup.getX() && Snake.head.getY() == Snake.pickup.getY()) {
            Snake.pickup.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup2.getX() && Snake.head.getY() == Snake.pickup2.getY()){
            Snake.pickup2.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup3.getX() && Snake.head.getY() == Snake.pickup3.getY()){
            Snake.pickup3.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup4.getX() && Snake.head.getY() == Snake.pickup4.getY()){
            Snake.pickup4.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.pickup5.getX() && Snake.head.getY() == Snake.pickup5.getY()){
            Snake.pickup5.reset();
            Snake.addTail();
            Snake.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake.head.getX() == Snake.frog.getX() && Snake.head.getY() == Snake.frog.getY()){
            Snake.frog.reset();
            Snake.addTail();
            Snake.addTail();
            Snake.addTail();
            Snake.score +=3;
            if (GameClock.hugeGrowSoundCounter < 1){
                GameClock.hugeGrowSound.playSound(GameClock.filepathHugeGrowSound);
                GameClock.hugeGrowSoundCounter++;
            }
        }
    }

    /**
     * Sprawdza czy wąż Ai zjadł owoc i dodaje element tail
     */
    public static void collidePickUp2() {
        if (Snake2.head.getX() == Snake2.pickup.getX() && Snake2.head.getY() == Snake2.pickup.getY()) {
            Snake2.pickup.reset();
            Snake2.addTail();
            Snake2.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake2.head.getX() == Snake2.pickup2.getX() && Snake2.head.getY() == Snake2.pickup2.getY()){
            Snake2.pickup2.reset();
            Snake2.addTail();
            Snake2.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake2.head.getX() == Snake2.pickup3.getX() && Snake2.head.getY() == Snake2.pickup3.getY()){
            Snake2.pickup3.reset();
            Snake2.addTail();
            Snake2.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake2.head.getX() == Snake2.pickup4.getX() && Snake2.head.getY() == Snake2.pickup4.getY()){
            Snake2.pickup4.reset();
            Snake2.addTail();
            Snake2.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake2.head.getX() == Snake2.pickup5.getX() && Snake2.head.getY() == Snake2.pickup5.getY()){
            Snake2.pickup5.reset();
            Snake2.addTail();
            Snake2.score +=1;
            if (GameClock.growSoundCounter < 1){
                GameClock.growSound.playSound(GameClock.filepathGrowSound);
                GameClock.growSoundCounter++;
            }
        } else if (Snake2.head.getX() == Snake2.frog.getX() && Snake2.head.getY() == Snake2.frog.getY()){
            Snake2.frog.reset();
            Snake2.addTail();
            Snake2.addTail();
            Snake2.addTail();
            Snake2.score +=3;
            if (GameClock.hugeGrowSoundCounter < 1){
                GameClock.hugeGrowSound.playSound(GameClock.filepathHugeGrowSound);
                GameClock.hugeGrowSoundCounter++;
            }
        }
    }


    /**
     * Metoda sprawdzająca czy wąż skolidował z przeszkodą
     * @return true or false
     */
    public static boolean collideObstacle() {
        return (Snake.head.getX() >= 6 && Snake.head.getX() < 36 && Snake.head.getY() >= 19 && Snake.head.getY() < 23);
    }

}
