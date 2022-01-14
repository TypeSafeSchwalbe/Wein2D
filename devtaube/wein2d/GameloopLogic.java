package devtaube.wein2d;

class GameloopThread extends Thread
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private WindowFrame windowFrame;
    private final Gameloop gameloopObject;
    protected int fps = 60;
    private boolean running;
    private int averageFrames = -1;
    // Constructor ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    GameloopThread(WindowFrame windowFrame, Gameloop gameloop) {
        this.windowFrame = windowFrame;
        this.gameloopObject = gameloop;
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
            if(fps > 0 && fps <= 1000) // is fps limited?
            {
                // get Time at start of Frame
                frameStartTime = System.currentTimeMillis();
            }
            // call methods
            synchronized(gameloopObject)
            {
                if(!windowFrame.canvas.locked) gameloopObject.onFrame();
            }
            if(lastFrameCountResetTime + 1000 < System.currentTimeMillis())
            {
                lastFrameCountResetTime = System.currentTimeMillis();
                averageFrames = framesCounter;
                framesCounter = 0;
            }
            framesCounter++;
            if(fps > 0 && fps <= 1000) // is fps limited?
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
            else
            {
                try {
                    Thread.sleep(1);
                } catch (Exception e) { e.printStackTrace(); }
            }
        }
    }
}
