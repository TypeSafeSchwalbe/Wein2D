package devtaube.wein2d.renderedobjects;

import java.awt.*;

public class Sprite implements RenderedObject
{
    // values
    private final Image sprite;
    private final int posX;
    private final int posY;
    private final int sizeX;
    private final int sizeY;
    private final int srcPosX;
    private final int srcPosY;
    private final int srcSizeX;
    private final int srcSizeY;
    private final int colorA;

    // constructors
    public Sprite(Image sprite, int posX, int posY) // draw image
    {
        this.sprite = sprite;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sprite.getWidth(null) + posX;
        this.sizeY = sprite.getHeight(null) + posY;
        this.srcPosX = 0;
        this.srcPosY = 0;
        this.srcSizeX = sprite.getWidth(null);
        this.srcSizeY = sprite.getHeight(null);
        this.colorA = 255;
    }

    public Sprite(Image sprite, int posX, int posY, int colorA) // draw image with alpha
    {
        this.sprite = sprite;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sprite.getWidth(null) + posX;
        this.sizeY = sprite.getHeight(null) + posY;
        this.srcPosX = 0;
        this.srcPosY = 0;
        this.srcSizeX = sprite.getWidth(null);
        this.srcSizeY = sprite.getHeight(null);
        this.colorA = colorA;
    }

    public Sprite(Image sprite, int posX, int posY, int sizeX, int sizeY) // draw scaled image
    {
        this.sprite = sprite;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.srcPosX = 0;
        this.srcPosY = 0;
        this.srcSizeX = sprite.getWidth(null);
        this.srcSizeY = sprite.getHeight(null);
        this.colorA = 255;
    }

    public Sprite(Image sprite, int posX, int posY, int sizeX, int sizeY, int colorA) // draw scaled image with alpha
    {
        this.sprite = sprite;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.srcPosX = 0;
        this.srcPosY = 0;
        this.srcSizeX = sprite.getWidth(null);
        this.srcSizeY = sprite.getHeight(null);
        this.colorA = colorA;
    }

    public Sprite(Image sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY) // draw cropped scaled image
    {
        this.sprite = sprite;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.srcPosX = srcPosX;
        this.srcPosY = srcPosY;
        this.srcSizeX = srcSizeX;
        this.srcSizeY = srcSizeY;
        this.colorA = 255;
    }

    public Sprite(Image sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA) // draw cropped scaled image with alpha
    {
        this.sprite = sprite;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.srcPosX = srcPosX;
        this.srcPosY = srcPosY;
        this.srcSizeX = srcSizeX;
        this.srcSizeY = srcSizeY;
        this.colorA = colorA;
    }

    // draw method
    public void draw(Graphics2D g, int windowX, int windowY)
    {
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        g.drawImage(sprite, posX, posY, sizeX, sizeY, srcPosX, srcPosY, srcSizeX, srcSizeY, null);
    }
}
