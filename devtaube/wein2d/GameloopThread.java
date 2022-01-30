package devtaube.wein2d;

class GameloopThread extends Thread
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private WindowFrame windowFrame;
    protected int fps;
    public boolean running;
    private int averageFrames = 0;
    // Constructor ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    GameloopThread(WindowFrame windowFrame, int fps) {
        this.windowFrame = windowFrame;
        this.fps = fps;
    }
    // Start ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void run()
    {
        running = true;
        gameloop();
    }
    // getFPS ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected int getFPS()
    {
        return averageFrames;
    }
    // Gameloop ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void gameloop()
    {
        long frameStartTime = 0;
        long frameTime;
        long waitTime;
        int framesCounter = 0;
        long lastFrameCountResetTime = 0;
        while (running)
        {
            if(fps > 0) // is fps limited?
            {
                // get Time at start of Frame
                frameStartTime = System.currentTimeMillis();
            }
            // call methods
            if(!windowFrame.canvas.locked) windowFrame.canvas.repaint();
            // calculate FPS
            if(lastFrameCountResetTime + 1000 < System.currentTimeMillis())
            {
                lastFrameCountResetTime = System.currentTimeMillis();
                averageFrames = framesCounter;
                framesCounter = 0;
            }
            framesCounter++;
            // Wait
            if(fps > 0 && running) // is fps limited?
            {
                // calculate amount of sleep
                frameTime = System.currentTimeMillis() - frameStartTime;
                waitTime = 1000 / fps - frameTime;
                // sleep
                if(waitTime > 0)
                {
                    try {
                        Thread.sleep(waitTime);
                    } catch (Exception e) { e.printStackTrace(); }
                }
            }
        }
    }
}
