package devtaube.wein2d;

import javax.swing.*;
import java.awt.*;

public abstract class Wein2DApplication implements RenderCalls
{

    static
    {
        System.setProperty("sun.java2d.transaccel", "true");
        System.setProperty("sun.java2d.d3d", "true");
        System.setProperty("sun.java2d.ddforcevram", "true");
        System.setProperty("sun.java2d.opengl", "true");
    }

    public abstract void onFrame();

    private JFrame frame;
    private Panel panel;
    private Gameloop gameloop;

    private KeyManager keyManager;
    private MouseManager mouseManager;
    private WindowFocusManager windowFocusManager;

    private static final int DEFAULT_WIDTH = 848;
    private static final int DEFAULT_HEIGHT = 480;

    private int lastSetWidth = DEFAULT_WIDTH;
    private int lastSetHeight = DEFAULT_WIDTH;

    public int width = DEFAULT_WIDTH;
    public int height = DEFAULT_HEIGHT;
    public double deltaTime;

    private int lastChangeWidth;
    private int lastChangeHeight;
    private int lastChangeScreen;

    public Wein2DApplication()
    {
        initWindow();
    }


    void initWindow()
    {
        frame = new JFrame();
        panel = new Panel(this);
        gameloop = new Gameloop(panel);

        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        windowFocusManager = new WindowFocusManager();

        panel.addMouseListener(mouseManager);
        panel.addMouseMotionListener(mouseManager);
        panel.addMouseWheelListener(mouseManager);

        frame.add(panel);
        frame.addKeyListener(keyManager);
        frame.addWindowFocusListener(windowFocusManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    int getCurrentScreen()
    {
        GraphicsDevice currentScreenDevice = frame.getGraphicsConfiguration().getDevice();
        GraphicsDevice[] totalScreenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        for (int screen = 0; screen < totalScreenDevices.length; screen++) {
            if(totalScreenDevices[screen].equals(currentScreenDevice))
            {
                return screen;
            }
        }
        return 0;
    }

    void centerOnScreen(int screen)
    {
        GraphicsDevice[] totalScreenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
        if(screen > -1 && screen < totalScreenDevices.length)
        {
            Rectangle screenBounds = totalScreenDevices[screen].getDefaultConfiguration().getBounds();
            frame.setLocation(screenBounds.x + (screenBounds.width - frame.getWidth()) / 2, screenBounds.y + (screenBounds.height - frame.getHeight()) / 2);
        }
    }

    public final void setSize(int width, int height)
    {
        panel.setSize(width, height);
        lastSetWidth = width;
        lastSetHeight = height;
    }

    public final void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public final void setFullscreen(boolean fullscreen)
    {
        if(fullscreen)
        {
            boolean frameVisible = frame.isVisible();
            frame.setVisible(false);
            frame.setUndecorated(true);
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
            frame.setVisible(frameVisible);
        }
        else
        {
            boolean frameVisible = frame.isVisible();
            frame.setVisible(false);
            frame.setUndecorated(false);
            frame.setSize(lastSetWidth, lastSetHeight);
            frame.setVisible(frameVisible);
        }
    }

    public final void setResizable(boolean resizable)
    {
        frame.setResizable(resizable);
    }

    public final void setTargetedFPS(int fps)
    {
        gameloop.setFPS(fps);
    }

    public final void setIcon(Sprite icon)
    {
        frame.setIconImage(icon.getImage());
    }

    public final void build()
    {
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gameloop.start();
    }


    void internalOnFrame()
    {
        width = panel.getWidth();
        height = panel.getHeight();
        deltaTime = gameloop.getDeltaTime();

        if(windowFocusManager.buttonsShouldReset)
        {
            keyManager.resetButtons();
            mouseManager.resetButtons();
            windowFocusManager.buttonsShouldReset = false;
        }

        if(lastChangeWidth != width || lastChangeHeight != height)
        {
            gameloop.resetDeltaTime();
            lastChangeWidth = width;
            lastChangeHeight = height;
        }

        onFrame();

        mouseManager.resetScrolledNotches();

        if(lastChangeScreen != getCurrentScreen())
        {
            lastChangeScreen = getCurrentScreen();

            JFrame oldFrame = frame;
            Panel oldPanel = panel;
            Gameloop oldGameloop = gameloop;

            frame.setVisible(false);
            initWindow();

            setSize(oldPanel.getWidth(), oldPanel.getHeight());
            setTitle(oldFrame.getTitle());
            setFullscreen(oldFrame.getSize().equals(Toolkit.getDefaultToolkit().getScreenSize()));
            setResizable(oldFrame.isResizable());
            setTargetedFPS(oldGameloop.getTargetedFPS());
            frame.setIconImage(oldFrame.getIconImage());
            frame.pack();

            centerOnScreen(lastChangeScreen);

            frame.setVisible(true);

            oldFrame.dispose();

            gameloop.start();
        }
    }

    @Override
    public final Graphics2D getGraphics() { return panel.getCurrentGraphics(); }

    @Override
    public final int getWidth() { return width; }

    @Override
    public final int getHeight() { return height; }

    @Override
    public boolean drawingAllowed() { return !panel.getLocked(); }


    public final boolean getKey(int key) { return keyManager.keys[key]; }

    public final String getTypedText() { return keyManager.typedText; }

    public final void setTypedText(String text) { keyManager.setTypedText(text); }


    public final int getMouseX()
    {
        return mouseManager.mouseX;
    }

    public final int getMouseY()
    {
        return mouseManager.mouseY;
    }

    public final boolean getMouseL() { return mouseManager.mouseButtonL;}

    public final boolean getMouseS()
    {
        return mouseManager.mouseButtonS;
    }

    public final boolean getMouseR()
    {
        return mouseManager.mouseButtonR;
    }

    public final int getScrolledNotches() { return mouseManager.scrolledNotches; }

    public final int getFPS() { return gameloop.getFPS(); }

}
