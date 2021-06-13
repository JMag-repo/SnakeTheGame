package sounds;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sounds{


    public void playSound(String filepath){
        try{

            AudioInputStream Sound = AudioSystem.getAudioInputStream(new File(filepath));
            Clip clip = AudioSystem.getClip();
            clip.open(Sound);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex)
        {
            ex.printStackTrace();
        }
    }
}
