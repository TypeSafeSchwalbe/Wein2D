package devtaube.wein2d;

import java.awt.*;
import javax.swing.*;

class Canvas extends JPanel
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    protected WindowFrame windowFrame;
    private Graphics2D currentG = null;
    // Primitive
    protected int width;
    protected int height;
    protected boolean locked = false;
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Canvas(WindowFrame windowFrame, int givenSizeX, int givenSizeY)
    {
        this.windowFrame = windowFrame;
        this.width = givenSizeX;
        this.height = givenSizeY;
    }
    // Override: Get Preferred Size ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Dimension getPreferredSize()
    {
      return new Dimension(width, height);
    }
    // Override: paintComponent ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private int lastWidth = 0;
    private int lastHeight = 0;
    private long lastFrameTime = 0;

    @Override
    public void paintComponent(Graphics g)
    {
        // lock canvas
        locked = true;
        // call super
        super.paintComponent(g);
        // calculate sizing
        width = (int) windowFrame.getContentPane().getSize().getWidth();
        height = (int) windowFrame.getContentPane().getSize().getHeight();
        windowFrame.window.width = width;
        windowFrame.window.height = height;
        // get Graphics2D
        currentG = (Graphics2D) g;
        // reset last frame time on width or height change
        if(lastWidth != width || lastHeight != height)
        {
            lastWidth = width;
            lastHeight = height;
            lastFrameTime = System.nanoTime();
        }
        // call onFrame-Method of gameloopObject
        long time = System.nanoTime();
        windowFrame.window.deltaTime = (double) (time - lastFrameTime) / 1_000_000_000;
        lastFrameTime = time;
        windowFrame.window.onFrame();
        // reset Graphics2D
        currentG = null;
        // unlock canvas
        locked = false;
    }
    // Full Draw Methods
    protected void drawRect(double posX, double posY, double sizeX, double sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        if(sizeX == -1) sizeX = width;
        if(sizeY == -1) sizeY = height;
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        currentG.fillRect((int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(sizeX), (int) Math.floor(sizeY));
    }
    protected void drawOval(double posX, double posY, double sizeX, double sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        currentG.fillOval((int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(sizeX), (int) Math.floor(sizeY));
    }
    protected void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.drawImage(sprite.getImage(), (int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(sizeX), (int) Math.floor(sizeY), srcPosX, srcPosY, srcSizeX, srcSizeY, null);
    }
    protected void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        Font font = new Font(fontFamily, Font.PLAIN, (int) Math.floor(fontSize));
        currentG.setFont(font);
        double newX = posX;
        switch(positioning)
        {
            case TextPositioning.LEFT:
                newX -= currentG.getFontMetrics(font).stringWidth(content);
                break;
            case TextPositioning.CENTER:
                newX -= (currentG.getFontMetrics(font).stringWidth(content) / 2.0);
                break;
        }
        currentG.drawString(content, (int) Math.floor(newX), (int) Math.floor(posY));
    }
    protected void drawLine(double posX, double posY, double endX, double endY, double lineWidth, int colorA, int colorR, int colorG, int colorB)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        currentG.setStroke(new BasicStroke((float) Math.floor(lineWidth)));
        currentG.drawLine((int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(endX), (int) Math.floor(endY));
    }
}
