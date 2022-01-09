package devtaube.wein2d;

import devtaube.wein2d.renderedobjects.*;

import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;

class Canvas extends JPanel
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    protected LinkedList<RenderedObject> renderedObjects = new LinkedList<>();
    protected boolean locked = false;
    // Primitive
    protected int sizeX;
    protected int sizeY;
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    Canvas(int givenSizeX, int givenSizeY)
    {
        this.sizeX = givenSizeX;
        this.sizeY = givenSizeY;
    }
    // Override: Get Preferred Size ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Dimension getPreferredSize()
    {
      return new Dimension(sizeX, sizeY);
    }
    // Override: paintComponent ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void paintComponent(Graphics givenG)
    {
        locked = true; // lock canvas
        // get Graphics2D
        Graphics2D g = (Graphics2D) givenG;
        // loop through the list of rendered objects and draw it
        for (RenderedObject renderedObject : renderedObjects)
        {
            if(renderedObject != null) renderedObject.draw(g, sizeX, sizeY);
        }
        // clear list of rendered objects
        renderedObjects.clear();
        locked = false; // unlock canvas
    }
}
