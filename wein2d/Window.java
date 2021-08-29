package wein2d;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;
import java.lang.reflect.*;

public class Window extends JFrame {
  // Private Variables
  private JavaPanel panel;
  private KeyManager keyManager;
  private MouseManager mouseManager;
  private Dimension screenDim;
  // Constructor
  public Window(int canvasWidth, int canvasHeight) {
    screenDim = Toolkit.getDefaultToolkit().getScreenSize();
    panel = new JavaPanel(canvasWidth, canvasHeight);
    createWindow(false);
  }
  public void createWindow(boolean fullscreen) {
    this.add(panel);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    keyManager = new KeyManager();
    mouseManager = new MouseManager();
    this.addKeyListener(keyManager);
    panel.addMouseListener(mouseManager);
    panel.addMouseMotionListener(mouseManager);
    if (fullscreen == true) {
      this.setUndecorated(true);
      boolean visible = this.isVisible();
      this.setVisible(true);
      this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      this.setVisible(visible);
    }
    this.pack();
    if (fullscreen == false) {
      this.setLocation((screenDim.width - this.getWidth()) / 2, (screenDim.height - this.getHeight()) / 2);
    }
  }
  // Getting width and height
  public int getWidth() {
    return panel.pWidth;
  }
  public int getHeight() {
    return panel.pHeight;
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
  public void defineFullScreen(boolean fullscreen) {
    this.dispose();
    this.createWindow(fullscreen);
  }
  public void defineResizable(boolean resizable) {
    this.setResizable(resizable);
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
    int drawObjectsLength = panel.drawObjects.length;
    panel.drawObjects = Arrays.copyOf(panel.drawObjects, drawObjectsLength + 1);
    panel.drawObjects[drawObjectsLength] = new DrawObject(0, posX, posY, sizeX, sizeY, colorR, colorG, colorB);
  }
  public void drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) {
    int drawObjectsLength = panel.drawObjects.length;
    panel.drawObjects = Arrays.copyOf(panel.drawObjects, drawObjectsLength + 1);
    panel.drawObjects[drawObjectsLength] = new DrawObject(1, posX, posY, sizeX, sizeY, colorR, colorG, colorB);
  }
  public void drawSprite(Sprite sprite, int posX, int posY) {
    int drawObjectsLength = panel.drawObjects.length;
    panel.drawObjects = Arrays.copyOf(panel.drawObjects, drawObjectsLength + 1);
    panel.drawObjects[drawObjectsLength] = new DrawObject(2, sprite.getImage(), posX, posY);
  }
  public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY) {
    int drawObjectsLength = panel.drawObjects.length;
    panel.drawObjects = Arrays.copyOf(panel.drawObjects, drawObjectsLength + 1);
    panel.drawObjects[drawObjectsLength] = new DrawObject(3, sprite.getImage(), posX, posY, posX + sizeX, posY + sizeY);
  }
  public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int sPosX, int sPosY, int sSizeX, int sSizeY) {
    int drawObjectsLength = panel.drawObjects.length;
    panel.drawObjects = Arrays.copyOf(panel.drawObjects, drawObjectsLength + 1);
    panel.drawObjects[drawObjectsLength] = new DrawObject(4, sprite.getImage(), posX, posY, posX + sizeX, posY + sizeY, sPosX, sPosY, sPosX + sSizeX, sPosY + sSizeY);
  }
  public void drawText(String content, int posX, int posY, int size, String fontFamily, int colorR, int colorG, int colorB) {
    int drawObjectsLength = panel.drawObjects.length;
    panel.drawObjects = Arrays.copyOf(panel.drawObjects, drawObjectsLength + 1);
    panel.drawObjects[drawObjectsLength] = new DrawObject(5, content, posX, posY, size, fontFamily, colorR, colorG, colorB);
  }
  // Render
  public void update() {
    panel.pWidth = (int) this.getContentPane().getSize().getWidth();
    panel.pHeight = (int) this.getContentPane().getSize().getHeight();
    panel.repaint();
  }
}
