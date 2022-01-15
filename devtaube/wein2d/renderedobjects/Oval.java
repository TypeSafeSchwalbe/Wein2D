package devtaube.wein2d.renderedobjects;

import java.awt.*;

public class Oval implements RenderedObject
{
    // values
    private final int posX;
    private final int posY;
    private final int sizeX;
    private final int sizeY;
    private final int colorA;
    private final int colorR;
    private final int colorG;
    private final int colorB;

    // constructors
    public Oval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) // oval without alpha
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

    public Oval(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB) // oval with alpha
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

    // draw method
    public void draw(Graphics2D g, int windowX, int windowY)
    {
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        g.setPaint(new Color(colorR, colorG, colorB));
        g.fillOval(posX, posY, sizeX, sizeY);
    }
}
