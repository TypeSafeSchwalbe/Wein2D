package devtaube.wein2d;

import java.awt.*;
import javax.swing.*;

class WindowFrame extends JFrame
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // References
    protected Wein2DApplication window;
    protected devtaube.wein2d.Canvas canvas;
    protected KeyManager keyAdapter;
    protected MouseManager mouseAdapter;
    protected WindowFocusManager windowFocusListener;
    protected GameloopThread gameloopThread;
    // Primitive
    protected int screenSizeX;
    protected int screenSizeY;
    // Constructors ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    WindowFrame(Wein2DApplication window, int sizeX, int sizeY, boolean fullscreen, String title, boolean resizable, int fps, Image icon)
    {
        this.window = window;

        screenSizeX = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        screenSizeY = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        canvas = new devtaube.wein2d.Canvas(this, sizeX, sizeY);
        keyAdapter = new KeyManager();
        mouseAdapter = new MouseManager();
        windowFocusListener = new WindowFocusManager(this);

        this.add(canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyAdapter);
        canvas.addMouseListener(mouseAdapter);
        canvas.addMouseMotionListener(mouseAdapter);
        this.addWindowFocusListener(windowFocusListener);
        this.setTitle(title);
        this.setResizable(resizable);
        if(icon != null) this.setIconImage(icon);

        if(fullscreen)
        {
            this.setVisible(false);
            this.setUndecorated(true);
            this.canvas.width = screenSizeX;
            this.canvas.height = screenSizeY;
        }

        // apply changes
        this.pack();
        this.setLocation((screenSizeX - this.getWidth()) / 2, (screenSizeY - this.getHeight()) / 2);

        // start gameloop
        gameloopThread = new GameloopThread(this, fps);

        this.setVisible(true);

        if(gameloopThread != null)
        {
            gameloopThread.start();
        }
    }
}
