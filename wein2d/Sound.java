package wein2d;

import java.io.*;
import javax.sound.sampled.*;

public class Sound
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Clip sound;
    private FloatControl volume;
    private float range;
    private boolean looping;
    // Constructor ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Sound(String filePath)
    {
        // store full path as string
        String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
        // replace all leftover backslashes with foreward slashes
        fullFilePath = fullFilePath.replace("\\", "/");
        // print if the sound file does even exist
        if (!(new File(fullFilePath).exists()))
        {
          System.out.println("Error when loading a sound: sound at '" + fullFilePath + "' doesn't exist.");
        }
        // load Clip
        try
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(fullFilePath).getAbsoluteFile());
            sound = AudioSystem.getClip();
    		sound.open(audioStream);
        }
        catch(Exception e)
        {}
        // set up volume control
        volume = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        range = volume.getMaximum() - volume.getMinimum();
    }
    // Set Loudness ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private long preFlushSoundTime;
    public void setVolume(double loudness)
    {
        volume.setValue((float) (range * loudness) + volume.getMinimum());
        //preFlushSoundTime = sound.getMicrosecondPosition();
        //sound.flush();
        //sound.setMicrosecondPosition(preFlushSoundTime);
    }
    // Play ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void play()
    {
        sound.start();
    }
    // Loop ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void loop(boolean looping)
    {
        if (looping)
        {
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            this.looping = true;
        }
        else
        {
            sound.loop(0);
            this.looping = false;
        }
    }
    // Stop ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void stop()
    {
        sound.stop();
    }
}
