package devtaube.wein2d;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;
import java.net.URL;

public final class Sound
{

    private Clip clip;
    private final FloatControl volumeControl;
    private final float volumeRange;

    public Sound(String filePath, FileOrigin fileOrigin)
    {
        try
        {
            AudioInputStream audioInputStream = null;
            switch(fileOrigin)
            {
                case WORKING_DIRECTORY:
                    audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
                    break;

                case CLASSPATH:
                    audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemClassLoader().getResourceAsStream(filePath));
                    break;

                case WEB_URL:
                    audioInputStream = AudioSystem.getAudioInputStream(new URL(filePath));
                    break;
            }
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch(Exception e) { e.printStackTrace(); }
        volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeRange = volumeControl.getMaximum() - volumeControl.getMinimum();
    }

    public void setVolume(double volume)
    {
        volumeControl.setValue((float) (volumeRange * volume) + volumeControl.getMinimum());
    }

    public void play()
    {
        clip.setFramePosition(0);
        clip.start();
    }

    public void loop(boolean looping)
    {
        if(looping)
        {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            clip.loop(0);
        }
    }

    public void stop()
    {
        clip.stop();
    }

    public boolean isPlaying()
    {
        return 0 < clip.getFramePosition() && clip.getFramePosition() < clip.getFrameLength();
    }

}
