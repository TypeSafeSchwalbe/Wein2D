package devtaube.wein2d;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Window
{
    // static initialization
    static
    {
        System.out.println("[Wein2D] Thanks for using Wein2D!");
    }
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    private WindowFrame jFrame;
    // primitives
    public int width = 0;
    public int height = 0;
    // Constructor and setup ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int sizeX;
    private int sizeY;
    private boolean fullscreen;
    private String title;
    private boolean resizable;
    private Gameloop gameloop;
    private int fps;
    private Image icon;
    private boolean doHardwareAcceleration;

    public Window()
    {
        this.sizeX = 848;
        this.sizeY = 480;
        this.fullscreen = false;
        this.title = "Wein2D Application";
        this.resizable = true;
        this.gameloop = null;
        this.fps = 60;
        this.icon = null;
        this.doHardwareAcceleration = true;
    }

    public Window setSize(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        return this;
    }

    public Window setFullscreen(boolean fullscreen)
    {
        this.fullscreen = fullscreen;
        return this;
    }

    public Window setTitle(String title)
    {
        this.title = title;
        return this;
    }

    public Window setResizable(boolean resizable)
    {
        this.resizable = resizable;
        return this;
    }

    public Window setGameloopObject(Gameloop gameloop)
    {
        this.gameloop = gameloop;
        return this;
    }

    public Window setTargetedFPS(int fps)
    {
        this.fps = fps;
        return this;
    }

    public Window setIcon(String iconPath) {
        try
        {
            String fullIconPath = System.getProperty("user.dir") + "/" + iconPath;
            fullIconPath = fullIconPath.replace("\\", "/");
            if (!(new File(fullIconPath).isFile()))
                throw new IllegalArgumentException("Image file at '" + fullIconPath + "' not found.");
            this.icon = ImageIO.read(new File(fullIconPath));
        }
        catch(Exception e) {}
        return this;
    }

    public Window setIcon(Image image)
    {
        this.icon = image;
        return this;
    }

    public Window setHardwareAcceleration(boolean doHardwareAcceleration)
    {
        this.doHardwareAcceleration = doHardwareAcceleration;
        return this;
    }

    public Window build()
    {
        if(doHardwareAcceleration)
        {
            System.setProperty("sun.java2d.transaccel", "True");
            System.setProperty("sun.java2d.d3d", "True");
            System.setProperty("sun.java2d.ddforcevram", "True");
            System.setProperty("sun.java2d.opengl", "True");
        }
        if(gameloop == null) throw new IllegalArgumentException("No object implementing devtaube.wein2d.Gameloop specified. Set one by using '.setGameloopObject(Gameloop gameloop)' before calling '.build()' on your Window object.");
        if(jFrame != null)
        {
            if(jFrame.gameloopThread != null) jFrame.gameloopThread.running = false;
            jFrame.dispose();
        }
        // build window and set width and height variables
        jFrame = new WindowFrame(this, sizeX, sizeY, fullscreen, title, resizable, gameloop, fps, icon);
        return this;
    }

    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getFPS()
    {
        if(jFrame != null)
        {
            if(jFrame.gameloopThread != null)
                return jFrame.gameloopThread.getFPS();
        }
        return -1;
    }

    // Input ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean getKey(int key) {
        return jFrame.keyAdapter.keys[key];
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
    // draw ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(posX, posY, sizeX, sizeY, 255, colorR, colorG, colorB);
    }
    public void drawRect(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(posX, posY, sizeX, sizeY, colorA, colorR, colorG, colorB);
    }

    public void drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawOval(posX, posY, sizeX, sizeY, 255, colorR, colorG, colorB);
    }
    public void drawOval(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawOval(posX, posY, sizeX, sizeY, colorA, colorR, colorG, colorB);
    }

    public void drawSprite(Sprite sprite, int posX, int posY)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sprite.getImage().getWidth(null) + posX, sprite.getImage().getHeight(null) + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), 255);
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int colorA)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sprite.getImage().getWidth(null) + posX, sprite.getImage().getHeight(null) + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), colorA);
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), 255);
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int colorA)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), colorA);
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, srcPosX, srcPosY, srcSizeX + srcPosX, srcSizeY + srcPosY, 255);
    }
    public void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, srcPosX, srcPosY, srcSizeX + srcPosX, srcSizeY + srcPosY, colorA);
    }

    public void drawText(String content, int posX, int posY, int fontSize, String fontFamily, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, TextPositioning.RIGHT, fontSize, fontFamily, 255, colorR, colorG, colorB);
    }
    public void drawText(String content, int posX, int posY, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, TextPositioning.RIGHT, fontSize, fontFamily, colorA, colorR, colorG, colorB);
    }
    public void drawText(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, positioning, fontSize, fontFamily, 255, colorR, colorG, colorB);
    }
    public void drawText(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, positioning, fontSize, fontFamily, colorA, colorR, colorG, colorB);
    }

    public void fill(int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(0, 0, -1, -1, 255, colorR, colorG, colorB);
    }
    public void fill(int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(0, 0, -1, -1, colorA, colorR, colorG, colorB);
    }

    public void drawLine(int posX, int posY, int endX, int endY, int lineWidth, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawLine(posX, posY, endX, endY, lineWidth, 255, colorR, colorG, colorB);
    }
    public void drawLine(int posX, int posY, int endX, int endY, int lineWidth, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawLine(posX, posY, endX, endY, lineWidth, colorA, colorR, colorG, colorB);
    }
}
