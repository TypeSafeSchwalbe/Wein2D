import javax.sound.sampled.*;
import java.io.File;

public class Sound {
  private Clip sound;
  public Sound(String filePath) {
    try {
      String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
      fullFilePath = fullFilePath.replace("\\", "/");
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(fullFilePath).getAbsoluteFile());
      sound = AudioSystem.getClip();
      sound.open(audioInputStream);
      // clip.start();
    } catch (Exception fileLoadingException) {}
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
