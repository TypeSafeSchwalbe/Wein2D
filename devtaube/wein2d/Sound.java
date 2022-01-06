package devtaube.wein2d;

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
        String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
        fullFilePath = fullFilePath.replace("\\", "/");
        if (!(new File(fullFilePath).isFile()))
            System.out.println("Error when loading a sound: sound at '" + fullFilePath + "' doesn't exist.");
        else
            loadSound(new File(fullFilePath).getAbsoluteFile());
    }
    public Sound(File file)
    {
        loadSound(file.getAbsoluteFile());
    }
    public Sound(Clip clip)
    {
        this.sound = clip;
        // set up volume control
        volume = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        range = volume.getMaximum() - volume.getMinimum();
    }
    private void loadSound(File file)
    {
        try
        {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            sound = AudioSystem.getClip();
            sound.open(audioStream);
        }
        catch(Exception e)
        {
            System.out.println("Error: Something went wrong when loading the image at '" + file.getAbsolutePath() + "':");
            e.printStackTrace();
        }
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
