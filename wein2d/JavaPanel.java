package wein2d;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class JavaPanel extends JPanel {
  // DrawObjects
  protected DrawObject[] drawObjects = new DrawObject[0];

  // Panel
  protected int pWidth;
  protected int pHeight;

  public JavaPanel(int width, int height) {
    pWidth = width;
    pHeight = height;
  }
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(pWidth, pHeight);
  }
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    for (int drawObject = 0; drawObject < drawObjects.length; drawObject++) {
      DrawObject cDrawObject = drawObjects[drawObject];
      switch(cDrawObject.type) {
        case 0:
          g2d.setPaint(new Color(cDrawObject.colorR, cDrawObject.colorG, cDrawObject.colorB));
          g2d.fillRect(cDrawObject.posX, cDrawObject.posY, cDrawObject.sizeX, cDrawObject.sizeY);
          break;
        case 1:
          g2d.setPaint(new Color(cDrawObject.colorR, cDrawObject.colorG, cDrawObject.colorB));
          g2d.fillOval(cDrawObject.posX, cDrawObject.posY, cDrawObject.sizeX, cDrawObject.sizeY);
          break;
        case 2:
          g2d.drawImage(cDrawObject.image, cDrawObject.posX, cDrawObject.posY, null);
          break;
        case 3:
          g2d.drawImage(cDrawObject.image, cDrawObject.posX, cDrawObject.posY, cDrawObject.sizeX, cDrawObject.sizeY, null);
          break;
        case 4:
          g2d.drawImage(cDrawObject.image, cDrawObject.posX, cDrawObject.posY, cDrawObject.sizeX, cDrawObject.sizeY, cDrawObject.sourcePosX, cDrawObject.sourcePosY, cDrawObject.sourceSizeX, cDrawObject.sourceSizeY, null);
          break;
        case 5:
          g2d.setPaint(new Color(cDrawObject.colorR, cDrawObject.colorG, cDrawObject.colorB));
          g2d.setFont(new Font(cDrawObject.fontFamily, Font.PLAIN, cDrawObject.fontSize));
          g2d.drawString(cDrawObject.content, cDrawObject.posX, cDrawObject.posY);
          break;
      }
    }
    drawObjects = new DrawObject[0];
  }
}
