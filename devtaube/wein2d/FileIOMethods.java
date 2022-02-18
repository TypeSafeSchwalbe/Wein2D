package devtaube.wein2d;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Image;
import java.io.*;

public class FileIOMethods
{

    public static Sprite loadSpriteFromClassPath(String filePath)
    {
        try {
            return new Sprite(ImageIO.read(FileIOMethods.class.getClassLoader().getResourceAsStream(filePath)));
        }
        catch(Exception e) { e.printStackTrace(); }
        return null;
    }

    public static Sound loadSoundFromClassPath(String filePath)
    {
        try {
            Clip clip = AudioSystem.getClip();
            InputStream inputStream = FileIOMethods.class.getClassLoader().getResourceAsStream(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream));
            clip.open(audioInputStream);
            return new Sound(clip);
        }
        catch(Exception e) { e.printStackTrace(); }
        return null;
    }

    public static void serializeObject(Object object, String filePath)
    {
        try (
                FileOutputStream fileOutput = new FileOutputStream(filePath);
                ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        ) {
            objectOutput.writeObject(object);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static Object deserializeObject(String filePath)
    {
        try (
                FileInputStream fileInput = new FileInputStream(filePath);
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        ) {
            return objectInput.readObject();
        }
        catch (Exception e) { e.printStackTrace(); }
        return null;
    }

}
