/*
 * Copyright (c) 2022, DevTaube
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *
 *     Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
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

    private int widthBeforeFullscreen = DEFAULT_WIDTH;
    private int heightBeforeFullscreen = DEFAULT_WIDTH;
    private boolean fullscreen = false;

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
        this.width = width;
        this.height = height;
    }

    public final void setTitle(String title)
    {
        frame.setTitle(title);
    }

    public final void setFullscreen(boolean fullscreen)
    {
        this.fullscreen = fullscreen;

        // get frame info
        boolean frameVisible = frame.isVisible();
        boolean frameResizable = frame.isResizable();
        Image frameIcon = frame.getIconImage();
        String frameTitle = frame.getTitle();

        // destroy old frame
        frame.dispose();

        // create new frame from old info
        frame = new JFrame(frameTitle);
        frame.add(panel);
        frame.addKeyListener(keyManager);
        frame.addWindowFocusListener(windowFocusManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(frameResizable);
        frame.setIconImage(frameIcon);

        // configure the new frame
        frame.setUndecorated(fullscreen);
        if(fullscreen)
            frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        else
            frame.setSize(widthBeforeFullscreen, heightBeforeFullscreen);

        // show it and position it if needed
        frame.setVisible(frameVisible);
        if(!fullscreen)
            centerOnScreen(getCurrentScreen());
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
        frame.setIconImage(icon.getBufferedImage());
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
        if(!fullscreen)
        {
            widthBeforeFullscreen = width;
            heightBeforeFullscreen = height;
        }
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
