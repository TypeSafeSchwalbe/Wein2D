package wein2d;

import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class Window
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    private WindowFrame jFrame;
    // Primitive
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Window()
    {
        // create instance of jFrame
        jFrame = new WindowFrame();
    }
    public Window(int sizeX, int sizeY)
    {
        // create instance of jFrame and pass wanted size
        jFrame = new WindowFrame(sizeX, sizeY);
    }
    // Input ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean getKey(String keyID) {
        switch(keyID)
        {
            case "ctrl": return jFrame.keyAdapter.ctrl;
            case "shift": return jFrame.keyAdapter.shift;
            case "space": return jFrame.keyAdapter.space;
            case "backspace": return jFrame.keyAdapter.backspace;
            case "enter": return jFrame.keyAdapter.enter;
            case "alt": return jFrame.keyAdapter.alt;
            case "arrUp": return jFrame.keyAdapter.arrUp;
            case "arrDown": return jFrame.keyAdapter.arrDown;
            case "arrLeft": return jFrame.keyAdapter.arrLeft;
            case "arrRight": return jFrame.keyAdapter.arrRight;
            case "keyA": return jFrame.keyAdapter.keyA;
            case "keyB": return jFrame.keyAdapter.keyB;
            case "keyC": return jFrame.keyAdapter.keyC;
            case "keyD": return jFrame.keyAdapter.keyD;
            case "keyE": return jFrame.keyAdapter.keyE;
            case "keyF": return jFrame.keyAdapter.keyF;
            case "keyG": return jFrame.keyAdapter.keyG;
            case "keyH": return jFrame.keyAdapter.keyH;
            case "keyI": return jFrame.keyAdapter.keyI;
            case "keyJ": return jFrame.keyAdapter.keyJ;
            case "keyK": return jFrame.keyAdapter.keyK;
            case "keyL": return jFrame.keyAdapter.keyL;
            case "keyM": return jFrame.keyAdapter.keyM;
            case "keyN": return jFrame.keyAdapter.keyN;
            case "keyO": return jFrame.keyAdapter.keyO;
            case "keyP": return jFrame.keyAdapter.keyP;
            case "keyQ": return jFrame.keyAdapter.keyQ;
            case "keyR": return jFrame.keyAdapter.keyR;
            case "keyS": return jFrame.keyAdapter.keyS;
            case "keyT": return jFrame.keyAdapter.keyT;
            case "keyU": return jFrame.keyAdapter.keyU;
            case "keyV": return jFrame.keyAdapter.keyV;
            case "keyW": return jFrame.keyAdapter.keyW;
            case "keyX": return jFrame.keyAdapter.keyX;
            case "keyY": return jFrame.keyAdapter.keyY;
            case "keyZ": return jFrame.keyAdapter.keyZ;
            case "key0": return jFrame.keyAdapter.key0;
            case "key1": return jFrame.keyAdapter.key1;
            case "key2": return jFrame.keyAdapter.key2;
            case "key3": return jFrame.keyAdapter.key3;
            case "key4": return jFrame.keyAdapter.key4;
            case "key5": return jFrame.keyAdapter.key5;
            case "key6": return jFrame.keyAdapter.key6;
            case "key7": return jFrame.keyAdapter.key7;
            case "key8": return jFrame.keyAdapter.key8;
            case "key9": return jFrame.keyAdapter.key9;
            case "keyF1": return jFrame.keyAdapter.keyF1;
            case "keyF2": return jFrame.keyAdapter.keyF2;
            case "keyF3": return jFrame.keyAdapter.keyF3;
            case "keyF4": return jFrame.keyAdapter.keyF4;
            case "keyF5": return jFrame.keyAdapter.keyF5;
            case "keyF6": return jFrame.keyAdapter.keyF6;
            case "keyF7": return jFrame.keyAdapter.keyF7;
            case "keyF8": return jFrame.keyAdapter.keyF8;
            case "keyF9": return jFrame.keyAdapter.keyF9;
            case "keyF10": return jFrame.keyAdapter.keyF10;
            case "keyF11": return jFrame.keyAdapter.keyF11;
            case "keyF12": return jFrame.keyAdapter.keyF12;
            default: return false;
        }
    }
    public int getMouseX()
    {
      return jFrame.mouseAdapter.mouseX;
    }
    public int getMouseY()
    {
      return jFrame.mouseAdapter.mouseY;
    }
    public boolean getMouseL()
    {
      return jFrame.mouseAdapter.mouseButtonL;
    }
    public boolean getMouseR()
    {
      return jFrame.mouseAdapter.mouseButtonR;
    }
    // Getters ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getWidth()
    {
        // return size of jFrame on X axis
        return jFrame.canvas.sizeX;
    }
    public int getHeight()
    {
        // return size of jFrame on Y axis
        return jFrame.canvas.sizeY;
    }
    public boolean getVisible()
    {
        // return if jFrame is visible
        return jFrame.isVisible();
    }
    // Setters ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void setSize(int givenSizeX, int givenSizeY)
    {
        // change preferred size of canvas
        jFrame.canvas.sizeX = givenSizeX;
        jFrame.canvas.sizeY = givenSizeY;
        // pack
        jFrame.pack();
        // adjust position
        jFrame.centerWindow();
    }
    public void setTitle(String givenTitle)
    {
        // apply title
        jFrame.setTitle(givenTitle);
    }
    public void setIcon(String filePath)
    {
        // store full path as string
        String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
        // replace all leftover backslashes with foreward slashes
        fullFilePath = fullFilePath.replace("\\", "/");
        // load the image from the stores path
        ImageIcon icon = new ImageIcon(fullFilePath);
        // apply the image
        jFrame.setIconImage(icon.getImage());
    }
    public void setResizable(boolean resizable)
    {
        // set jFrame to be or be not resizable
        jFrame.setResizable(resizable);
    }
    public void setVisible(boolean visible)
    {
        // set jFrame to be or be not visible
        jFrame.setVisible(visible);
    }
    public void setFullScreen(boolean fullscreen)
    {
        // destroy original frame
        jFrame.dispose();
        // create new one at its place
        jFrame.createWindow(fullscreen);
    }
    // Gameloop ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void addGameloop(Gameloop givenGameloop)
    {
        jFrame.gameloopLogic = new GameloopLogic(givenGameloop);
    }
    public void startGameloop()
    {
        if(jFrame.gameloopLogic != null)
        {
            jFrame.gameloopLogic.start();
        }
    }
    public void setFPS(int givenFPS)
    {
        if(jFrame.gameloopLogic != null)
        {
            jFrame.gameloopLogic.fps = givenFPS;
        }
    }
    public int getFPS()
    {
        if(jFrame.gameloopLogic != null)
        {
            return jFrame.gameloopLogic.fps;
        }
        else
        return -1;
    }
    // draw ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(0, posX, posY, sizeX, sizeY, colorR, colorG, colorB));
    }
    public void drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(1, posX, posY, sizeX, sizeY, colorR, colorG, colorB));
    }
    public void drawSprite(Sprite sprite, int posX, int posY)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(2, sprite.getImage(), posX, posY));
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(3, sprite.getImage(), posX, posY, sizeX, sizeY));
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int sPosX, int sPosY, int sSizeX, int sSizeY)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(4, sprite.getImage(), posX, posY, posX + sizeX, posY + sizeY, sPosX, sPosY, sPosX + sSizeX, sPosY + sSizeY));
    }
    public void drawText(String content, int posX, int posY, int size, String fontFamily, int colorR, int colorG, int colorB)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(5, content, posX, posY + size, size, fontFamily, colorR, colorG, colorB));
    }
    public void fill(int colorR, int colorG, int colorB)
    {
        jFrame.canvas.renderedObjects.add(new RenderedObject(6, colorR, colorG, colorB));
    }
    // redraw ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void redraw() {
        jFrame.canvas.sizeX = (int) jFrame.getContentPane().getSize().getWidth();
        jFrame.canvas.sizeY = (int) jFrame.getContentPane().getSize().getHeight();
        jFrame.canvas.repaint();
    }
}
