import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.InputStream;

/**
 * Created by Hannes on 20/05/2017.
 */
public class Sound {
    private String track;
    InputStream inputStream;
    AudioStream audioStream;

    public Sound(String track){
        this.track = track;

    }

    public void playSound(){
        try {
            inputStream = getClass().getResourceAsStream(track);
            audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception e){
            System.err.println("Couldn't find a sound file");
        }
    }

    public void stopSound(){
        try {
            AudioPlayer.player.stop(audioStream);
        } catch (Exception e){
            System.err.println("Couldn't find a sound file");
        }
    }
}
