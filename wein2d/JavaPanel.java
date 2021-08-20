package wein2d;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class JavaPanel extends JPanel {
  protected int[][] rects = {{}};
  protected boolean isRect = false;
  protected int[][] ovals = {{}};
  protected boolean isOval = false;
  protected int[][] sprites1 = {{}};
  protected boolean isSprite1 = false;
  protected Image[] sprites2 = {};
  protected boolean isSprite2 = false;
  protected int[][] fonts1 = {{}};
  protected boolean isFont1 = false;
  protected String[][] fonts2 = {{}};
  protected boolean isFont2 = false;
  protected int pWidth = 0;
  protected int pHeight = 0;
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
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    // Rectangle
    if (isRect == true) {
      for (int i = 0; i < rects.length; i++) {
        if (rects[i][3] > pWidth || rects[i][4] > pHeight || rects[i][3] < 0 - rects[i][5] || rects[i][4] < 0 - rects[i][6]) { continue; }
        else {
          g2d.setPaint(new Color(rects[i][0], rects[i][1], rects[i][2]));
          g2d.fillRect(rects[i][3], rects[i][4], rects[i][5], rects[i][6]);
        }
      }
    }
    isRect = false;
    // Oval
    if (isOval == true) {
      for (int i = 0; i < ovals.length; i++) {
        if (ovals[i][3] > pWidth || ovals[i][4] > pHeight || ovals[i][3] < 0 - ovals[i][5] || ovals[i][4] < 0 - ovals[i][6]) { continue; }
        else {
          g2d.setPaint(new Color(ovals[i][0], ovals[i][1], ovals[i][2]));
          g2d.fillOval(ovals[i][3], ovals[i][4], ovals[i][5], ovals[i][6]);
        }
      }
    }
    isOval = false;
    // Image
    if (isSprite2 == true) {
      for (int i = 0; i < sprites2.length; i++) {
        if (sprites1[i][0] > pWidth || sprites1[i][1] > pHeight || sprites1[i][0] < 0 - sprites2[i].getWidth(null) || sprites1[i][1] < 0 - sprites2[i].getHeight(null)) { continue; }
        else { g2d.drawImage(sprites2[i], sprites1[i][0], sprites1[i][1], null); }
      }
    }
    isSprite1 = false;
    isSprite2 = false;
    // Font
    if (isFont1 == true) {
      for (int i = 0; i < fonts1.length; i++) {
        g2d.setPaint(new Color(fonts1[i][3], fonts1[i][4], fonts1[i][5]));
        g2d.setFont(new Font(fonts2[i][1], Font.PLAIN, fonts1[i][2]));
        g2d.drawString(fonts2[i][0], fonts1[i][0], fonts1[i][1]);
      }
    }
    isFont1 = false;
    isFont2 = false;
    // Reset Arrays
    rects = Arrays.copyOf(rects, 1);
    ovals = Arrays.copyOf(ovals, 1);
    sprites1 = Arrays.copyOf(sprites1, 1);
    sprites2 = Arrays.copyOf(sprites2, 0);
    fonts1 = Arrays.copyOf(fonts1, 1);
    fonts2 = Arrays.copyOf(fonts2, 1);
  }
}
