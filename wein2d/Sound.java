package wein2d;

import javax.sound.sampled.*;
import java.io.File;

public class Sound {
  private Clip sound;
  public Sound(String filePath) {
    String fullFilePath = "";
    try {
      fullFilePath = System.getProperty("user.dir") + "/" + filePath;
      fullFilePath = fullFilePath.replace("\\", "/");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fullFilePath).getAbsoluteFile());
      sound = AudioSystem.getClip();
      sound.open(audioInputStream);
    } catch (Exception fileLoadingException) {}
    if (new File(fullFilePath).exists() == false) {
      System.out.println("Error when loading a Sound: Sound at '" + fullFilePath + "' doesn't exist.");
    }
  }
  public void play() {
    sound.start();
  }
  public void loop(int times) {
    if (times == 0) {
      sound.loop(Clip.LOOP_CONTINUOUSLY);
    } else if (times > 0) {
      sound.loop(times);
    }
  }
  public void stop() {
    sound.stop();
  }
}
