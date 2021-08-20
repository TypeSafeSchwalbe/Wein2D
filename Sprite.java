import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class Sprite {
  private Image sprite;
  public Sprite(String filePath) {
    String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
    fullFilePath = fullFilePath.replace("\\", "/");
    try { sprite = ImageIO.read(new File(fullFilePath)); } catch (Exception spriteLoadingException) {}
    if (new File(fullFilePath).exists() == false) {
      System.out.println("Error when loading an Image: Image at '" + fullFilePath + "' doesn't exist.");
    }
  }
  public Image getImage() {
    return sprite;
  }
}
