package testapp;

import devtaube.wein2d.*;

public class ExampleProgram implements Gameloop
{
    Window window; // stores the window
    int ballX; // stores the ball's position

    public static void main(String[] args) // create instance of this class on launch
    {
        new ExampleProgram();
    }

    public ExampleProgram() // constructor; gets executed on launch
    {
        window = new Window(848, 480); // create window
        window.addGameloop(this); // add this as a gameloop (it implements Gameloop)
        window.setVisible(true); // set the window to visible
        window.startGameloop(); // start calling 'onFrame()' once per frame
    }

    public void onFrame() // gets called once per frame
    {
        ballX += 3; // move the ball
        if (ballX > 848) ballX = -50; // teleport it to the other side if it hits the edge
        window.fill(255, 255, 255); // fill the screen with white
        window.drawOval(ballX, 215, 50, 50, 59, 187, 164); // draw the ball
        window.redraw(); // let the window do it's drawing
    }
}