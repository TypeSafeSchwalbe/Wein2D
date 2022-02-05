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
            throw new IllegalArgumentException("Image file at '" + fullFilePath + "' not found.");
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
            System.out.println("[Wein2D] Error >> Something went wrong when trying to load the sound file at \"" + file.getAbsolutePath() + "\". Stack trace:");
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
    }
    // Play ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void play()
    {
        stop();
        sound.setFramePosition(0);
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
