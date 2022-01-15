package devtaube.wein2d.renderedobjects;

import java.awt.*;
import devtaube.wein2d.TextPositioning;

public class Text implements RenderedObject
{
    // values
    private final String content;
    private final int posX;
    private final int posY;
    private final int positioning;
    private final int fontSize;
    private final String fontFamily;
    private final int colorA;
    private final int colorR;
    private final int colorG;
    private final int colorB;

    // constructors
    public Text(String content, int posX, int posY, int fontSize, String fontFamily, int colorR, int colorG, int colorB) // draw text with custom font
    {
        this.content = content;
        this.posX = posX;
        this.posY = posY;
        this.positioning = TextPositioning.RIGHT;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.colorA = 255;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Text(String content, int posX, int posY, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) // draw text with custom font and alpha
    {
        this.content = content;
        this.posX = posX;
        this.posY = posY;
        this.positioning = TextPositioning.RIGHT;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.colorA = colorA;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Text(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorR, int colorG, int colorB) // draw text with custom font
    {
        this.content = content;
        this.posX = posX;
        this.posY = posY;
        this.positioning = positioning;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
        this.colorA = 255;
        this.colorR = colorR;
        this.colorG = colorG;
        this.colorB = colorB;
    }

    public Text(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) // draw text with custom font and alpha
    {
        this.content = content;
        this.posX = posX;
        this.posY = posY;
        this.positioning = positioning;
        this.fontSize = fontSize;
        this.fontFamily = fontFamily;
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
        Font font = new Font(fontFamily, Font.PLAIN, fontSize);
        g.setFont(font);
        int newX = posX;
        switch(positioning)
        {
            case TextPositioning.LEFT:
                newX -= g.getFontMetrics(font).stringWidth(content);
                break;
            case TextPositioning.CENTER:
                newX -= (g.getFontMetrics(font).stringWidth(content) / 2);
                break;
        }
        g.drawString(content, newX, posY);
    }
}
