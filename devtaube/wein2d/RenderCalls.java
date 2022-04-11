package devtaube.wein2d;

import java.awt.*;

public interface RenderCalls
{

    Graphics2D getGraphics();

    int getWidth();

    int getHeight();

    boolean drawingAllowed();


    default void drawRectInternal(double posX, double posY, double width, double height, int colorA, int colorR, int colorG, int colorB)
    {
        getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        getGraphics().setPaint(new Color(colorR, colorG, colorB));
        getGraphics().fillRect((int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(width), (int) Math.floor(height));
    }

    default void drawOvalInternal(double posX, double posY, double width, double height, int colorA, int colorR, int colorG, int colorB)
    {
        getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        getGraphics().setPaint(new Color(colorR, colorG, colorB));
        getGraphics().fillOval((int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(width), (int) Math.floor(height));
    }

    default void drawSpriteInternal(Sprite sprite, double posX, double posY, double width, double height, int srcPosX, int srcPosY, int srcWidth, int srcHeight, int colorA)
    {
        getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        getGraphics().drawImage(sprite.getImage(), (int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(width), (int) Math.floor(height), srcPosX, srcPosY, srcWidth, srcHeight, null);
    }

    default void drawTextInternal(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB)
    {
        getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        getGraphics().setPaint(new Color(colorR, colorG, colorB));
        Font font = new Font(fontFamily, Font.PLAIN, (int) Math.floor(fontSize));
        getGraphics().setFont(font);
        double newX = posX;
        switch(positioning)
        {
            case TextPositioning.LEFT:
                newX -= getGraphics().getFontMetrics(font).stringWidth(content);
                break;
            case TextPositioning.CENTER:
                newX -= (getGraphics().getFontMetrics(font).stringWidth(content) / 2.0);
                break;
        }
        getGraphics().drawString(content, (int) Math.floor(newX), (int) Math.floor(posY));
    }

    default void drawLineInternal(double posX, double posY, double endX, double endY, double lineWidth, int colorA, int colorR, int colorG, int colorB)
    {
        getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        getGraphics().setPaint(new Color(colorR, colorG, colorB));
        getGraphics().setStroke(new BasicStroke((float) Math.floor(lineWidth)));
        getGraphics().drawLine((int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(endX), (int) Math.floor(endY));
    }

    default void drawVirtualCanvasInternal(VirtualCanvas virtualCanvas, double posX, double posY, double width, double height, int srcPosX, int srcPosY, int srcWidth, int srcHeight, int colorA)
    {
        getGraphics().setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) colorA / 255));
        getGraphics().drawImage(virtualCanvas.getBufferedImage(), (int) Math.floor(posX), (int) Math.floor(posY), (int) Math.floor(width), (int) Math.floor(height), srcPosX, srcPosY, srcWidth, srcHeight, null);
    }


    default void drawRect(double posX, double posY, double width, double height, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawRectInternal(posX, posY, width, height, 255, colorR, colorG, colorB); }

    default void drawRect(double posX, double posY, double width, double height, int colorA, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawRectInternal(posX, posY, width, height, colorA, colorR, colorG, colorB); }

    default void drawOval(double posX, double posY, double width, double height, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawOvalInternal(posX, posY, width, height, 255, colorR, colorG, colorB); }

    default void drawOval(double posX, double posY, double width, double height, int colorA, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawOvalInternal(posX, posY, width, height, colorA, colorR, colorG, colorB); }

    default void drawSprite(Sprite sprite, double posX, double posY) { if(drawingAllowed()) drawSpriteInternal(sprite, posX, posY, sprite.getWidth() + posX, sprite.getHeight() + posY, 0, 0, sprite.getWidth(), sprite.getHeight(), 255); }

    default void drawSprite(Sprite sprite, double posX, double posY, int colorA) { if(drawingAllowed()) drawSpriteInternal(sprite, posX, posY, sprite.getWidth() + posX, sprite.getHeight() + posY, 0, 0, sprite.getWidth(), sprite.getHeight(), colorA); }

    default void drawSprite(Sprite sprite, double posX, double posY, double width, double height) { if(drawingAllowed()) drawSpriteInternal(sprite, posX, posY, width + posX, height + posY, 0, 0, sprite.getWidth(), sprite.getHeight(), 255); }

    default void drawSprite(Sprite sprite, double posX, double posY, double width, double height, int colorA) { if(drawingAllowed()) drawSpriteInternal(sprite, posX, posY, width + posX, height + posY, 0, 0, sprite.getWidth(), sprite.getHeight(), colorA); }

    default void drawSprite(Sprite sprite, double posX, double posY, double width, double height, int srcPosX, int srcPosY, int srcWidth, int srcHeight) { if(drawingAllowed()) drawSpriteInternal(sprite, posX, posY, width + posX, height + posY, srcPosX, srcPosY, srcWidth + srcPosX, srcHeight + srcPosY, 255); }

    default void drawSprite(Sprite sprite, double posX, double posY, double width, double height, int srcPosX, int srcPosY, int srcWidth, int srcHeight, int colorA) { if(drawingAllowed()) drawSpriteInternal(sprite, posX, posY, width + posX, height + posY, srcPosX, srcPosY, srcWidth + srcPosX, srcHeight + srcPosY, colorA); }

    default void drawText(String content, double posX, double posY, double fontSize, String fontFamily, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawTextInternal(content, posX, posY + fontSize, TextPositioning.RIGHT, fontSize, fontFamily, 255, colorR, colorG, colorB); }

    default void drawText(String content, double posX, double posY, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawTextInternal(content, posX, posY + fontSize, TextPositioning.RIGHT, fontSize, fontFamily, colorA, colorR, colorG, colorB); }

    default void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawTextInternal(content, posX, posY + fontSize, positioning, fontSize, fontFamily, 255, colorR, colorG, colorB); }

    default void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawTextInternal(content, posX, posY + fontSize, positioning, fontSize, fontFamily, colorA, colorR, colorG, colorB); }

    default void fill(int colorR, int colorG, int colorB) { if(drawingAllowed()) drawRectInternal(0, 0, getWidth(), getHeight(), 255, colorR, colorG, colorB); }

    default void fill(int colorA, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawRectInternal(0, 0, getWidth(), getHeight(), colorA, colorR, colorG, colorB); }

    default void drawLine(double posX, double posY, double endX, double endY, double lineWidth, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawLineInternal(posX, posY, endX, endY, lineWidth, 255, colorR, colorG, colorB); }

    default void drawLine(double posX, double posY, double endX, double endY, double lineWidth, int colorA, int colorR, int colorG, int colorB) { if(drawingAllowed()) drawLineInternal(posX, posY, endX, endY, lineWidth, colorA, colorR, colorG, colorB); }

    default void drawVirtualCanvas(VirtualCanvas virtualCanvas, double posX, double posY) { if(drawingAllowed()) drawVirtualCanvasInternal(virtualCanvas, posX, posY, virtualCanvas.getWidth() + posX, virtualCanvas.getHeight() + posY, 0, 0, virtualCanvas.getWidth(), virtualCanvas.getHeight(), 255); }

    default void drawVirtualCanvas(VirtualCanvas virtualCanvas, double posX, double posY, int colorA) { if(drawingAllowed()) drawVirtualCanvasInternal(virtualCanvas, posX, posY, virtualCanvas.getWidth() + posX, virtualCanvas.getHeight() + posY, 0, 0, virtualCanvas.getWidth(), virtualCanvas.getHeight(), colorA); }

    default void drawVirtualCanvas(VirtualCanvas virtualCanvas, double posX, double posY, double width, double height) { if(drawingAllowed()) drawVirtualCanvasInternal(virtualCanvas, posX, posY, width + posX, height + posY, 0, 0, virtualCanvas.getWidth(), virtualCanvas.getHeight(), 255); }

    default void drawVirtualCanvas(VirtualCanvas virtualCanvas, double posX, double posY, double width, double height, int colorA) { if(drawingAllowed()) drawVirtualCanvasInternal(virtualCanvas, posX, posY, width + posX, height + posY, 0, 0, virtualCanvas.getWidth(), virtualCanvas.getHeight(), colorA); }

    default void drawVirtualCanvas(VirtualCanvas virtualCanvas, double posX, double posY, double width, double height, int srcPosX, int srcPosY, int srcWidth, int srcHeight) { if(drawingAllowed()) drawVirtualCanvasInternal(virtualCanvas, posX, posY, width + posX, height + posY, srcPosX, srcPosY, srcWidth + srcPosX, srcHeight + srcPosY, 255); }

    default void drawVirtualCanvas(VirtualCanvas virtualCanvas, double posX, double posY, double width, double height, int srcPosX, int srcPosY, int srcWidth, int srcHeight, int colorA) { if(drawingAllowed()) drawVirtualCanvasInternal(virtualCanvas, posX, posY, width + posX, height + posY, srcPosX, srcPosY, srcWidth + srcPosX, srcHeight + srcPosY, colorA); }

}
