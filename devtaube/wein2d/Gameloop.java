package devtaube.wein2d;

import javax.swing.*;

class Gameloop extends Thread
{

    private final JComponent component;
    private int fps;

    private double deltaTime;
    private int fpsCount;

    Gameloop(JComponent component)
    {
        this.component = component;
        fps = 60;
    }

    public void setFPS(int fps)
    {
        if(fps <= 0)
            throw new IllegalArgumentException("Targeted FPS cannot be lower than / equal to 0");

        this.fps = fps;
    }

    int getFPS()
    {
        return fpsCount;
    }

    int getTargetedFPS() { return fps; }

    void resetDeltaTime() { deltaTime = 0; }

    double getDeltaTime()
    {
        return deltaTime;
    }

    @Override
    public void run()
    {
        int frameCount = 0;
        long lastFrameCountReset = System.currentTimeMillis();
        long lastFrameTime = System.nanoTime();

        while(true)
        {
            long frameStartTime = System.currentTimeMillis();

            long time = System.nanoTime();
            deltaTime = (double) (time - lastFrameTime) / 1_000_000_000;
            lastFrameTime = time;
            component.repaint();

            frameCount++;
            if(lastFrameCountReset + 1000 < System.currentTimeMillis())
            {
                fpsCount = frameCount;
                frameCount = 0;
            }

            try
            {
                Thread.sleep(1_000 / fps - (frameStartTime - System.currentTimeMillis()));
            }
            catch(Exception ignored) {}
        }
    }

}
