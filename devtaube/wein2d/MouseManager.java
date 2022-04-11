package devtaube.wein2d;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

class MouseManager extends MouseAdapter implements MouseWheelListener
{

    int mouseX = 0;
    int mouseY = 0;
    boolean mouseButtonL = false;
    boolean mouseButtonS = false;
    boolean mouseButtonR = false;
    int scrolledNotches = 0;

    void resetButtons()
    {
        mouseButtonL = false;
        mouseButtonS = false;
        mouseButtonR = false;
    }

    void resetScrolledNotches()
    {
        scrolledNotches = 0;
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        switch(e.getButton())
        {
            case 1: mouseButtonL = true; break;
            case 2: mouseButtonS = true; break;
            case 3: mouseButtonR = true; break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        switch(e.getButton())
        {
            case 1: mouseButtonL = false; break;
            case 2: mouseButtonS = false; break;
            case 3: mouseButtonR = false; break;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        scrolledNotches += e.getWheelRotation();
    }
}
