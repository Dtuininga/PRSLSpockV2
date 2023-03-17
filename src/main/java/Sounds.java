import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sounds {
    static void playSound(String soundFile) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File f = new File("..\\Playground\\PRSLSv2\\resources\\" + soundFile);//relative path
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());//toURI properly formats any folder names with spaces instead of %20
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start(); //add time delay to make sure sound can fully play
    }
}
