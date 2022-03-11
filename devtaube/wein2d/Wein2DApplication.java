package devtaube.wein2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public abstract class Wein2DApplication implements java.io.Serializable
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    private WindowFrame jFrame;
    // primitives
    public int width = 0;
    public int height = 0;
    public double deltaTime = 0;
    // Constructor and setup ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int sizeX;
    private int sizeY;
    private boolean fullscreen;
    private String title;
    private boolean resizable;
    private int fps;
    private Image icon;
    private boolean doHardwareAcceleration;

    public Wein2DApplication()
    {
        this.sizeX = 848;
        this.sizeY = 480;
        this.fullscreen = false;
        this.title = "Wein2D Application";
        this.resizable = true;
        this.fps = 60;
        this.icon = null;
        this.doHardwareAcceleration = true;
    }

    public final void setSize(int sizeX, int sizeY)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public final void setFullscreen(boolean fullscreen)
    {
        this.fullscreen = fullscreen;
    }

    public final void setTitle(String title)
    {
        this.title = title;
    }

    public final void setResizable(boolean resizable)
    {
        this.resizable = resizable;
    }

    public final void setTargetedFPS(int fps)
    {
        this.fps = fps;
    }

    public final void setIcon(String iconPath)
    {
        try
        {
            String fullIconPath = System.getProperty("user.dir") + "/" + iconPath;
            fullIconPath = fullIconPath.replace("\\", "/");
            if (!(new File(fullIconPath).isFile()))
                throw new IllegalArgumentException("Image file at '" + fullIconPath + "' not found.");
            this.icon = ImageIO.read(new File(fullIconPath));
        }
        catch(Exception e) {}
    }

    public final void setIcon(Image image)
    {
        this.icon = image;
    }

    public final void setIcon(Sprite sprite)
    {
        this.icon = sprite.getImage();
    }

    public final void setHardwareAcceleration(boolean doHardwareAcceleration)
    {
        this.doHardwareAcceleration = doHardwareAcceleration;
    }

    public final void build()
    {
        if(doHardwareAcceleration)
        {
            System.setProperty("sun.java2d.transaccel", "True");
            System.setProperty("sun.java2d.d3d", "True");
            System.setProperty("sun.java2d.ddforcevram", "True");
            System.setProperty("sun.java2d.opengl", "True");
        }
        if(jFrame != null)
        {
            if(jFrame.gameloopThread != null) jFrame.gameloopThread.running = false;
            jFrame.dispose();
        }
        // build window and set width and height variables
        jFrame = new WindowFrame(this, sizeX, sizeY, fullscreen, title, resizable, fps, icon);
    }

    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public final int getFPS()
    {
        if(jFrame != null)
        {
            if(jFrame.gameloopThread != null)
                return jFrame.gameloopThread.getFPS();
        }
        return -1;
    }

    // Input ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final boolean getKey(int key) {
        return jFrame.keyAdapter.keys[key];
    }
    public final int getMouseX()
    {
      return jFrame.mouseAdapter.mouseX;
    }
    public final int getMouseY()
    {
      return jFrame.mouseAdapter.mouseY;
    }
    public final boolean getMouseL()
    {
      return jFrame.mouseAdapter.mouseButtonL;
    }
    public final boolean getMouseR()
    {
      return jFrame.mouseAdapter.mouseButtonR;
    }
    // draw ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public abstract void onFrame();

    public final void drawRect(double posX, double posY, double sizeX, double sizeY, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(posX, posY, sizeX, sizeY, 255, colorR, colorG, colorB);
    }
    public final void drawRect(double posX, double posY, double sizeX, double sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(posX, posY, sizeX, sizeY, colorA, colorR, colorG, colorB);
    }

    public final void drawOval(double posX, double posY, double sizeX, double sizeY, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawOval(posX, posY, sizeX, sizeY, 255, colorR, colorG, colorB);
    }
    public final void drawOval(double posX, double posY, double sizeX, double sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawOval(posX, posY, sizeX, sizeY, colorA, colorR, colorG, colorB);
    }

    public final void drawSprite(Sprite sprite, double posX, double posY)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sprite.getImage().getWidth(null) + posX, sprite.getImage().getHeight(null) + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), 255);
    }
    public final void drawSprite(Sprite sprite, double posX, double posY, int colorA)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sprite.getImage().getWidth(null) + posX, sprite.getImage().getHeight(null) + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), colorA);
    }
    public final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), 255);
    }
    public final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int colorA)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, 0, 0, sprite.getImage().getWidth(null), sprite.getImage().getHeight(null), colorA);
    }
    public final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, srcPosX, srcPosY, srcSizeX + srcPosX, srcSizeY + srcPosY, 255);
    }
    public final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawSprite(sprite, posX, posY, sizeX + posX, sizeY + posY, srcPosX, srcPosY, srcSizeX + srcPosX, srcSizeY + srcPosY, colorA);
    }

    public final void drawText(String content, double posX, double posY, double fontSize, String fontFamily, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, TextPositioning.RIGHT, fontSize, fontFamily, 255, colorR, colorG, colorB);
    }
    public final void drawText(String content, double posX, double posY, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, TextPositioning.RIGHT, fontSize, fontFamily, colorA, colorR, colorG, colorB);
    }
    public final void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, positioning, fontSize, fontFamily, 255, colorR, colorG, colorB);
    }
    public final void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawText(content, posX, posY + fontSize, positioning, fontSize, fontFamily, colorA, colorR, colorG, colorB);
    }

    public final void fill(int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(0, 0, -1, -1, 255, colorR, colorG, colorB);
    }
    public final void fill(int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawRect(0, 0, -1, -1, colorA, colorR, colorG, colorB);
    }

    public final void drawLine(double posX, double posY, double endX, double endY, double lineWidth, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawLine(posX, posY, endX, endY, lineWidth, 255, colorR, colorG, colorB);
    }
    public final void drawLine(double posX, double posY, double endX, double endY, double lineWidth, int colorA, int colorR, int colorG, int colorB)
    {
        if(jFrame.canvas.locked) jFrame.canvas.drawLine(posX, posY, endX, endY, lineWidth, colorA, colorR, colorG, colorB);
    }
}
