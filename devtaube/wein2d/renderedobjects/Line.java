package devtaube.wein2d.renderedobjects;

import java.awt.*;

public class Line implements RenderedObject
{
    // values
    private final int posX;
    private final int posY;
    private final int endX;
    private final int endY;
    private final int lineWidth;
    private final int colorA;
    private final int colorR;
    private final int colorG;
    private final int colorB;

    // constructors
    public Line(int posX, int posY, int endX, int endY, int lineWidth, int colorR, int colorG, int colorB)
    {
        this.posX = posX;
        this.posY = posY;
        this.endX = endX;
        this.endY = endY;
        this.lineWidth = lineWidth;
        this.colorA = 255;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Line(int posX, int posY, int endX, int endY, int lineWidth, int colorA, int colorR, int colorG, int colorB)
    {
        this.posX = posX;
        this.posY = posY;
        this.endX = endX;
        this.endY = endY;
        this.lineWidth = lineWidth;
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
        g.setStroke(new BasicStroke(lineWidth));
        g.drawLine(posX, posY, endX, endY);
    }
}
