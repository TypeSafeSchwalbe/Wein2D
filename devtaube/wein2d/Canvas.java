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
    @Override
    public void paintComponent(Graphics g)
    {
        locked = true; // lock canvas
        // calculate sizing
        width = (int) windowFrame.getContentPane().getSize().getWidth();
        height = (int) windowFrame.getContentPane().getSize().getHeight();
        windowFrame.window.width = width;
        windowFrame.window.height = height;
        // get Graphics2D
        currentG = (Graphics2D) g;
        // call onFrame-Method of gameloopObject
        windowFrame.gameloopObject.onFrame();
        currentG = null;
        locked = false; // unlock canvas
    }
    // Full Draw Methods
    protected void drawRect(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        if(sizeX == -1) sizeX = width;
        if(sizeY == -1) sizeY = height;
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        currentG.fillRect(posX, posY, sizeX, sizeY);
    }
    protected void drawOval(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        currentG.fillOval(posX, posY, sizeX, sizeY);
    }
    protected void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.drawImage(sprite.getImage(), posX, posY, sizeX, sizeY, srcPosX, srcPosY, srcSizeX, srcSizeY, null);
    }
    protected void drawText(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        Font font = new Font(fontFamily, Font.PLAIN, fontSize);
        currentG.setFont(font);
        int newX = posX;
        switch(positioning)
        {
            case TextPositioning.LEFT:
                newX -= currentG.getFontMetrics(font).stringWidth(content);
                break;
            case TextPositioning.CENTER:
                newX -= (currentG.getFontMetrics(font).stringWidth(content) / 2);
                break;
        }
        currentG.drawString(content, newX, posY);
    }
    protected void drawLine(int posX, int posY, int endX, int endY, int lineWidth, int colorA, int colorR, int colorG, int colorB)
    {
        currentG.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        currentG.setPaint(new Color(colorR, colorG, colorB));
        currentG.setStroke(new BasicStroke(lineWidth));
        currentG.drawLine(posX, posY, endX, endY);
    }
}
