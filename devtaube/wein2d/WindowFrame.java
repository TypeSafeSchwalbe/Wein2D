package devtaube.wein2d;

import java.awt.*;
import java.awt.Canvas;
import javax.swing.*;

class WindowFrame extends JFrame
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    protected Window window;
    protected devtaube.wein2d.Canvas canvas;
    protected KeyManager keyAdapter;
    protected MouseManager mouseAdapter;
    protected GameloopThread gameloopThread;
    // Primitive
    protected int screenSizeX;
    protected int screenSizeY;
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    WindowFrame(Window window, int sizeX, int sizeY, boolean fullscreen, String title, boolean resizable, Gameloop gameloop, int fps,  Image icon)
    {
        this.window = window;
        screenSizeX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenSizeY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        canvas = new devtaube.wein2d.Canvas(sizeX, sizeY);
        keyAdapter = new KeyManager();
        mouseAdapter = new MouseManager();

        this.add(canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyAdapter);
        canvas.addMouseListener(mouseAdapter);
        canvas.addMouseMotionListener(mouseAdapter);
        this.setTitle(title);
        this.setResizable(resizable);
        if(icon != null) this.setIconImage(icon);

        if(fullscreen)
        {
            this.setVisible(false);
            this.setUndecorated(true);
            this.canvas.sizeX = screenSizeX;
            this.canvas.sizeY = screenSizeY;
        }

        // apply changes
        this.pack();
        this.setLocation((screenSizeX - this.getWidth()) / 2, (screenSizeY - this.getHeight()) / 2);

        // start gameloop
        if(gameloop != null)
        {
            gameloopThread = new GameloopThread(this, gameloop, fps);
        }

        this.setVisible(true);

        if(gameloopThread != null)
        {
            gameloopThread.start();
        }
    }
}
