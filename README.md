# About
Wein2D is a library for handling graphics, input and sound for Windows applications (and probably MacOS and Linux too) in Java with very similar method names and structure to Wein2D-Android to allow for easy porting of code across libraries.

Wein2D uses [TinySound](https://github.com/finnkuusisto/TinySound) for it's sound.

## Code example
This is a simple Example for a program:
```java
import devtaube.wein2d.*;

public class ExampleProgram extends Wein2DApplication { // extend Application
    double ballX = -0.05; // stores where ball is on the x axis

    public static void main(String[] args) { new ExampleProgram(); }

    public ExampleProgram() {
        this.build(); // complete build and start
    }

    public void onFrame() {
        // calculating
        ballX += 0.2 * deltaTime; // move ball by 1/5 of the screen with per second
        if (ballX > 1.05) ballX = -0.05; // move ball to left if out of screen on the right
        double ballYOffset = Math.sin((ballX * 360 * 2) * Math.PI / 180);
        // rendering
        this.fill(40, 40, 40);
        this.drawOval(
                ballX * width - 25, (height / 2 - 25) + (ballYOffset * height / 4), // posX, posY
                50, 50, // sizeX, sizeY
                (int) ((ballYOffset + 1) / 2 * 255), // red
                150 - (int) ((ballYOffset + 1) / 2 * 150) + 105, // green
                (int) ((ballYOffset + 1) / 2 * 150) + 105 // blue
        );
    }
}
```

# Documentation
Documentation for Wein2D can be found at [https://wein2ddocs.netlify.app](https://wein2ddocs.netlify.app).
