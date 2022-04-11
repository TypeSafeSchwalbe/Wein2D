package devtaube.wein2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public final class VirtualCanvas implements RenderCalls
{

    private final BufferedImage bufferedImage;
    private final Graphics2D graphics2D;
    private final int width;
    private final int height;

    public VirtualCanvas(int width, int height)
    {
        this.bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        this.graphics2D = bufferedImage.createGraphics();
        this.width = width;
        this.height = height;
    }

    public BufferedImage getBufferedImage() { return bufferedImage; };

    @Override
    public Graphics2D getGraphics() { return graphics2D; }

    @Override
    public int getWidth() { return width; }

    @Override
    public int getHeight() { return height; }

    @Override
    public boolean drawingAllowed() { return true; }

}
