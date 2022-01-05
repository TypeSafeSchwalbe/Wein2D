package devtaube.wein2d.renderedobjects;

import java.awt.*;

public class Rectangle implements RenderedObject
{
    // values
    private final int posX;
    private final int posY;
    private int sizeX;
    private int sizeY;
    private final int colorA;
    private final int colorR;
    private final int colorG;
    private final int colorB;

    // constructors
    public Rectangle(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) // rectangle without alpha
    {
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.colorA = 255;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Rectangle(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB) // rectangle with alpha
    {
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.colorA = colorA;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Rectangle(int colorR, int colorG, int colorB) // fill window
    {
        this.posX = 0;
        this.posY = 0;
        this.sizeX = -1;
        this.sizeY = -1;
        this.colorA = 255;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Rectangle(int colorA, int colorR, int colorG, int colorB) // fill window with alpha
    {
        this.posX = 0;
        this.posY = 0;
        this.sizeX = -1;
        this.sizeY = -1;
        this.colorA = colorA;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    // draw method
    public void draw(Graphics2D g, int windowX, int windowY)
    {
        if(sizeX == -1) sizeX = windowX;
        if(sizeY == -1) sizeY = windowY;
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        g.setPaint(new Color(colorR, colorG, colorB));
        g.fillRect(posX, posY, sizeX, sizeY);
    }
}
