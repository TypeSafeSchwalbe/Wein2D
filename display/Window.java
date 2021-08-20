import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.lang.reflect.*;
import java.lang.Integer;

public class Window extends JFrame {
  // Private Variables
  private JavaPanel panel;
  private KeyManager keyManager;
  private MouseManager mouseManager;
  private Dimension screenDim;
  // Constructor
  public Window(int canvasWidth, int canvasHeight, boolean resizable) {
    screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    JavaPanel javaPanel = new JavaPanel(canvasWidth, canvasHeight);
    this.add(javaPanel);
    this.setFocusable(true);
    this.setResizable(resizable);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = javaPanel;
    keyManager = new KeyManager();
    mouseManager = new MouseManager();
    this.addKeyListener(keyManager);
    panel.addMouseListener(mouseManager);
    panel.addMouseMotionListener(mouseManager);
    this.pack();
    this.setLocation((screenDim.width - this.getWidth()) / 2, (screenDim.height - this.getHeight()) / 2);
  }
  // Methods for changing the Window itself
  public void defineTitle(String title) {
    this.setTitle(title);
  }
  public void defineIcon(String filePath) {
    String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
    fullFilePath = fullFilePath.replace("\\", "/");
    ImageIcon icon = new ImageIcon(fullFilePath);
    this.setIconImage(icon.getImage());
  }
  public void defineVisible(boolean visible) {
    this.setVisible(visible);
  }
  // Method for adding Key and Mouse Input
  public boolean getKeyState(String keyID) {
    switch(keyID) {
      case "ctrl": return keyManager.ctrl;
      case "shift": return keyManager.shift;
      case "space": return keyManager.space;
      case "backspace": return keyManager.backspace;
      case "enter": return keyManager.enter;
      case "alt": return keyManager.alt;
      case "arrUp": return keyManager.arrUp;
      case "arrDown": return keyManager.arrDown;
      case "arrLeft": return keyManager.arrLeft;
      case "arrRight": return keyManager.arrRight;
      case "keyA": return keyManager.keyA;
      case "keyB": return keyManager.keyB;
      case "keyC": return keyManager.keyC;
      case "keyD": return keyManager.keyD;
      case "keyE": return keyManager.keyE;
      case "keyF": return keyManager.keyF;
      case "keyG": return keyManager.keyG;
      case "keyH": return keyManager.keyH;
      case "keyI": return keyManager.keyI;
      case "keyJ": return keyManager.keyJ;
      case "keyK": return keyManager.keyK;
      case "keyL": return keyManager.keyL;
      case "keyM": return keyManager.keyM;
      case "keyN": return keyManager.keyN;
      case "keyO": return keyManager.keyO;
      case "keyP": return keyManager.keyP;
      case "keyQ": return keyManager.keyQ;
      case "keyR": return keyManager.keyR;
      case "keyS": return keyManager.keyS;
      case "keyT": return keyManager.keyT;
      case "keyU": return keyManager.keyU;
      case "keyV": return keyManager.keyV;
      case "keyW": return keyManager.keyW;
      case "keyX": return keyManager.keyX;
      case "keyY": return keyManager.keyY;
      case "keyZ": return keyManager.keyZ;
      case "key0": return keyManager.key0;
      case "key1": return keyManager.key1;
      case "key2": return keyManager.key2;
      case "key3": return keyManager.key3;
      case "key4": return keyManager.key4;
      case "key5": return keyManager.key5;
      case "key6": return keyManager.key6;
      case "key7": return keyManager.key7;
      case "key8": return keyManager.key8;
      case "key9": return keyManager.key9;
      case "keyF1": return keyManager.keyF1;
      case "keyF2": return keyManager.keyF2;
      case "keyF3": return keyManager.keyF3;
      case "keyF4": return keyManager.keyF4;
      case "keyF5": return keyManager.keyF5;
      case "keyF6": return keyManager.keyF6;
      case "keyF7": return keyManager.keyF7;
      case "keyF8": return keyManager.keyF8;
      case "keyF9": return keyManager.keyF9;
      case "keyF10": return keyManager.keyF10;
      case "keyF11": return keyManager.keyF11;
      case "keyF12": return keyManager.keyF12;
      default: return false;
    }
  }
  public int getMousePosX() {
    return mouseManager.mouseX;
  }
  public int getMousePosY() {
    return mouseManager.mouseY;
  }
  public boolean getMouseButtonL() {
    return mouseManager.mouseButtonL;
  }
  public boolean getMouseButtonR() {
    return mouseManager.mouseButtonR;
  }
  // Methods for rendering Objects
  public void drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) {
    int drawArrayLength = panel.rects.length;
    int[] rect = {colorR, colorG, colorB, posX, posY, sizeX, sizeY};
    if (panel.isRect == true) {
      panel.rects = Arrays.copyOf(panel.rects, drawArrayLength + 1);
      panel.rects[drawArrayLength] = rect;
    } else {
      panel.rects[0] = rect;
      panel.isRect = true;
    }
  }
  public void drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) {
    int drawArrayLength = panel.ovals.length;
    int[] oval = {colorR, colorG, colorB, posX, posY, sizeX, sizeY};
    if (panel.isOval == true) {
      panel.ovals = Arrays.copyOf(panel.ovals, drawArrayLength + 1);
      panel.ovals[drawArrayLength] = oval;
    } else {
      panel.ovals[0] = oval;
      panel.isOval = true;
    }
  }
  public void drawSprite(Sprite sprite, int posX, int posY) {
    int drawArrayLength1 = panel.sprites1.length;
    int drawArrayLength2 = panel.sprites2.length;
    int[] sprite1 = {posX, posY};
    Image sprite2 = sprite.getImage();
    if (panel.isSprite1 == true) {
      panel.sprites1 = Arrays.copyOf(panel.sprites1, drawArrayLength1 + 1);
      panel.sprites1[drawArrayLength1] = sprite1;
      panel.sprites2 = Arrays.copyOf(panel.sprites2, drawArrayLength2 + 1);
      panel.sprites2[drawArrayLength2] = sprite2;
    } else {
      panel.sprites1[0] = sprite1;
      panel.sprites2 = Arrays.copyOf(panel.sprites2, 1);
      panel.sprites2[0] = sprite2;
      panel.isSprite1 = true;
      panel.isSprite2 = true;
    }
  }
  // Font
  public void drawText(String content, int posX, int posY, int size, String fontFamily, int colorR, int colorG, int colorB) {
    int drawArrayLength1 = panel.fonts1.length;
    int drawArrayLength2 = panel.fonts2.length;
    int[] font1 = {posX, posY, size, colorR, colorG, colorB};
    String[] font2 = {content, fontFamily};
    if (panel.isFont1 == true) {
      panel.fonts1 = Arrays.copyOf(panel.fonts1, drawArrayLength1 + 1);
      panel.fonts1[drawArrayLength1] = font1;
      panel.fonts2 = Arrays.copyOf(panel.fonts2, drawArrayLength2 + 1);
      panel.fonts2[drawArrayLength2] = font2;
    } else {
      panel.fonts1[0] = font1;
      panel.fonts2[0] = font2;
      panel.isFont1 = true;
      panel.isFont2 = true;
    }
  }
  // Render
  public void update() {
    panel.repaint();
  }
}
