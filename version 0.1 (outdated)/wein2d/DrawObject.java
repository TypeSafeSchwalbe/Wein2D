package wein2d;

import java.awt.*;
import javax.swing.*;

public class DrawObject {
  /* DrawObject.type
    - 0 = Rectangle
    - 1 = Oval
    - 2 = Sprite
    - 3 = ScaledSprite
    - 4 = CroppedScaledSprite
    - 5 = Text */
  protected int type = 0;

  // all types
  protected int posX;
  protected int posY;
  // Rectangle, Oval, ScaledSprite, CroppedScaledSprite
  protected int sizeX;
  protected int sizeY;
  // Sprite, ScaledSprite, CroppedScaledSprite
  protected Image image;
  // Rectangle, Oval, Text
  protected int colorR;
  protected int colorG;
  protected int colorB;
  // CroppedScaledSprite
  protected int sourcePosX;
  protected int sourcePosY;
  protected int sourceSizeX;
  protected int sourceSizeY;
  // Text
  protected String content;
  protected String fontFamily;
  protected int fontSize;

  // Constructor: Rectangle / Oval
  public DrawObject(int pType, int pPosX, int pPosY, int pSizeX, int pSizeY, int pColorR, int pColorG, int pColorB) {
    type = pType;
    posX = pPosX;
    posY = pPosY;
    sizeX = pSizeX;
    sizeY = pSizeY;
    colorR = pColorR;
    colorG = pColorG;
    colorB = pColorB;
  }
  // Constructor: Sprite
  public DrawObject(int pType, Image pImage, int pPosX, int pPosY) {
    type = pType;
    image = pImage;
    posX = pPosX;
    posY = pPosY;
  }
  // Constructor: ScaledSprite
  public DrawObject(int pType, Image pImage, int pPosX, int pPosY, int pSizeX, int pSizeY) {
    type = pType;
    image = pImage;
    posX = pPosX;
    posY = pPosY;
    sizeX = pSizeX;
    sizeY = pSizeY;
  }
  // Constructor: CroppedScaledSprite
  public DrawObject(int pType, Image pImage, int pPosX, int pPosY, int pSizeX, int pSizeY, int pSourcePosX, int pSourcePosY, int pSourceSizeX, int pSourceSizeY) {
    type = pType;
    image = pImage;
    posX = pPosX;
    posY = pPosY;
    sizeX = pSizeX;
    sizeY = pSizeY;
    sourcePosX = pSourcePosX;
    sourcePosY = pSourcePosY;
    sourceSizeX = pSourceSizeX;
    sourceSizeY = pSourceSizeY;
  }
  // Constructor: Text
  public DrawObject(int pType, String pContent, int pPosX, int pPosY, int pFontSize, String pFontFamily, int pColorR, int pColorG, int pColorB) {
    type = pType;
    content = pContent;
    posX = pPosX;
    posY = pPosY;
    fontSize = pFontSize;
    fontFamily = pFontFamily;
    colorR = pColorR;
    colorG = pColorG;
    colorB = pColorB;
  }
}
