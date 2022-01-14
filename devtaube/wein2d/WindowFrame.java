package devtaube.wein2d;

import java.awt.*;
import java.awt.Canvas;
import javax.swing.*;

class WindowFrame extends JFrame
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    protected devtaube.wein2d.Canvas canvas;
    protected KeyManager keyAdapter;
    protected MouseManager mouseAdapter;
    protected GameloopThread gameloopThread;
    // Primitive
    int screenSizeX;
    int screenSizeY;
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    WindowFrame()
    {
        // get Size of Screen
        screenSizeX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenSizeY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        // create instance of canvas
        canvas = new devtaube.wein2d.Canvas(848, 480);
        // create instance of key and mouse adapters
        keyAdapter = new KeyManager();
        mouseAdapter = new MouseManager();
        // set up window
        createWindow(false);
    }
    WindowFrame(int sizeX, int sizeY)
    {
        // get Size of Screen
        screenSizeX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenSizeY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        // create instance of canvas
        canvas = new devtaube.wein2d.Canvas(sizeX, sizeY);
        // create instance of key and mouse adapters
        keyAdapter = new KeyManager();
        mouseAdapter = new MouseManager();
        // set up window
        createWindow(false);
    }
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected void createWindow(boolean fullscreen)
    {
        // add canavs to window
        this.add(canvas);
        // configure window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add key listener
        this.addKeyListener(keyAdapter);
        // add mouse listener
        canvas.addMouseListener(mouseAdapter);
        canvas.addMouseMotionListener(mouseAdapter);
        // make window fullscreen if needed
        if (fullscreen)
        {
            // store if the window is visible
            boolean wasVisible = this.isVisible();
            // make the window invisible to remove decorations correctly
            this.setVisible(false);
            // remove decorations
            this.setUndecorated(true);
            // make the window visible to configure fullscreen correctly
            this.setVisible(true);
            // move to top left of screen to fill whole screen
            this.setLocation(0, 0);
            // set fullscreen
            this.canvas.sizeX = screenSizeX;
            this.canvas.sizeY = screenSizeY;
            // set it to the same visibility as before
            this.setVisible(wasVisible);
        }
        // apply changes
        this.pack();
        // position it in middle of screen if not fullscreen
        if (!fullscreen)
        {
            centerWindow();
        }
    }
    protected void centerWindow()
    {
        this.setLocation((screenSizeX - this.getWidth()) / 2, (screenSizeY - this.getHeight()) / 2);
    }
}
