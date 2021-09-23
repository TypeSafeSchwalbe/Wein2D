package wein2d;

import java.awt.*;
import javax.swing.*;

class RenderedObject
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Primitive
     /////////////////////////////////////////
     // RenderedObject => type
     //
     // 0 -> Rectangle
     // 1 -> Oval
     // 2 -> Sprite
     // 3 -> Sprite (scaled)
     // 4 -> Sprite (scaled and cropped)
     // 5 -> Text
     /////////////////////////////////////////
    protected int type = 0;

    protected int posX; // all
    protected int posY; // all
    protected int sizeX; // Rectangle, Oval, ScaledSprite, CroppedScaledSprite
    protected int sizeY; // Rectangle, Oval, ScaledSprite, CroppedScaledSprite
    protected Image image; // Sprite, ScaledSprite, CroppedScaledSprite
    protected int colorR; // Rectangle, Oval, Text
    protected int colorG; // Rectangle, Oval, Text
    protected int colorB; // Rectangle, Oval, Text
    protected int sourcePosX; // CroppedScaledSprite
    protected int sourcePosY; // CroppedScaledSprite
    protected int sourceSizeX; // CroppedScaledSprite
    protected int sourceSizeY; // CroppedScaledSprite
    protected String content; // Text
    protected String fontFamily; // Text
    protected int fontSize; // Text
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    RenderedObject(int givenType, int givenPosX, int givenPosY, int givenSizeX, int givenSizeY, int givenColorR, int givenColorG, int givenColorB) // rectangle || oval
    {
      type = givenType;
      posX = givenPosX;
      posY = givenPosY;
      sizeX = givenSizeX;
      sizeY = givenSizeY;
      colorR = givenColorR;
      colorG = givenColorG;
      colorB = givenColorB;
    }
    RenderedObject(int givenType, Image givenImage, int givenPosX, int givenPosY) // sprite
    {
      type = givenType;
      image = givenImage;
      posX = givenPosX;
      posY = givenPosY;
    }
    RenderedObject(int givenType, Image givenImage, int givenPosX, int givenPosY, int givenSizeX, int givenSizeY) // scaled sprite
    {
      type = givenType;
      image = givenImage;
      posX = givenPosX;
      posY = givenPosY;
      sizeX = givenSizeX;
      sizeY = givenSizeY;
    }
    RenderedObject(int givenType, Image givenImage, int givenPosX, int givenPosY, int givenSizeX, int givenSizeY, int givenSourcePosX, int givenSourcePosY, int givenSourceSizeX, int givenSourceSizeY) // scaled and cropped sprite
    {
      type = givenType;
      image = givenImage;
      posX = givenPosX;
      posY = givenPosY;
      sizeX = givenSizeX;
      sizeY = givenSizeY;
      sourcePosX = givenSourcePosX;
      sourcePosY = givenSourcePosY;
      sourceSizeX = givenSourceSizeX;
      sourceSizeY = givenSourceSizeY;
    }
    RenderedObject(int givenType, String givenContent, int givenPosX, int givenPosY, int givenFontSize, String givenFontFamily, int givenColorR, int givenColorG, int givenColorB) // text
    {
      type = givenType;
      content = givenContent;
      posX = givenPosX;
      posY = givenPosY;
      fontSize = givenFontSize;
      fontFamily = givenFontFamily;
      colorR = givenColorR;
      colorG = givenColorG;
      colorB = givenColorB;
    }
    // draw ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void draw(Graphics2D g)
    {
        switch(type)
        {
            case 0:
                g.setPaint(new Color(colorR, colorG, colorB));
                g.fillRect(posX, posY, sizeX, sizeY);
                break;
            case 1:
                g.setPaint(new Color(colorR, colorG, colorB));
                g.fillOval(posX, posY, sizeX, sizeY);
                break;
            case 2:
                g.drawImage(image, posX, posY, null);
                break;
            case 3:
                g.drawImage(image, posX, posY, sizeX, sizeY, null);
                break;
            case 4:
                g.drawImage(image, posX, posY, sizeX, sizeY, sourcePosX, sourcePosY, sourceSizeX, sourceSizeY, null);
                break;
            case 5:
                g.setPaint(new Color(colorR, colorG, colorB));
                g.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
                g.drawString(content, posX, posY);
                break;
        }
    }
}
