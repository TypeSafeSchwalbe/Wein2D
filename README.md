# Introduction
Wein2D is a simple Graphics Library built on top of the javax.swing and java.awt libraries. It's primarily made for making games. It supports / has:
- creating the game/program's window and managing it
- adding your own 'onFrame' method to these windows to get called every frame
- drawing simple shapes and images to these windows
- getting mouse and keyboard input from your user
- playing sounds
- simple methods for detecting collision

There is also a stripped version for android development, [Wein2DAndroid](https://www.github.com/devtaube/wein2dandroid).

## Code example
This is a simple Example for a program.
```java
import wein2d.*;
public class ExampleProgram implements Gameloop
{
    Window window; // stores the window
    int ballX; // stores the ball's position
    public static void main(String[] args) { new ExampleProgram(); } // create instance of this class on launch
    public ExampleProgram() { // constructor; gets executed on launch
        window = new Window(848, 480); // create window
        window.addGameloop(this); // add this as a gameloop (it implements Gameloop)
        window.setVisible(true); // set the window to visible
        window.startGameloop(); // start calling 'onFrame()' once per frame
    }
    public void onFrame(double deltaTime) { // gets called once per frame
        ballX += 3; // move the ball
        if (ballX > 848) ballX = -50; // teleport it to the other side if it hits the edge
        window.fill(255, 255, 255); // fill the screen with white
        window.drawOval(ballX, 215, 50, 50, 59, 187, 164); // draw the ball
        window.redraw(); // let the window do it's drawing
    }
}
```

# Documentation
This is a list of all features, classes and methods.

## Window
Constructors:  
Window()
Window(int width, int height)
-> creates a Window

Methods:
- Setters
   - void setVisible(boolean visible) >> defines if the window is visible
   - void setSize(int width, int height) >> sets the size of the window
   - void setTitle(String title) >> sets the title of the window
   - void setIcon(String filePath)  >> sets the window's icon
   - void setResizable(boolean resizable) >> defines if the window can be resized
   - void setFullScreen(boolean fullscreen) >> defines if the window takes up the entire screen
- Getters
   - int getWidth() >> get the width of the window in pixels
   - int getHeight() >> get the height of the window in pixels
   - boolean getVisible() >> get if the window is visible
   - int getFPS() >> returns the FPS the gameloop is configured to (returns -1 if no Gameloop-object added)
- Gameloop
   - void addGameloop(Gameloop gameloop) >> add an object to the window that implements the "Gameloop" interface
   - void startGameloop() >> starts the gameloop if a Gameloop-object is added
   - void setFPS(int fps) >> configures the gameloop to target the passed fps if a Gameloop-object is added
- Drawing stuff on screen
   - void fill(int colorR, int colorG, int colorB) >> fills the screen with the specified color (useful for screen clearing)
   - void drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) >> draws a rectangle on screen after 'redraw()' is called
   - void drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) >> draws an oval on screen after 'redraw()' is called
   - void drawSprite(Sprite sprite, int posX, int posY) >> draws a sprite on screen after 'redraw()' is called
   - void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY) >> draws a sprite on screen after 'redraw()' is called
   - void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY) >> draws a sprite on screen after 'redraw()' is called
   - void drawText(String content, int posX, int posY, int size, String fontFamily, int colorR, int colorG, int colorB) >> draws text on screen after 'redraw()' is called
   - void redraw() >> needed for your drawing to happen; call it once per frame
- Input
   - int getMouseX() >> returns the mouse's position on the x-axis
   - int getMouseY() >> returns the mouse's position on the y-axis
   - boolean getMouseL() >> returns if the mouse's left button is being pressed
   - boolean getMouseR() >> returns if the mouse's right button is being pressed
   - void getKey(String keyID) >> returns if a certain key on the keyboard is being pressed
       - key ID's: "ctrl", "shift", "space", "backspace", "enter", "alt", "arrUp", "arrDown", "arrLeft", "arrRight", "keyA", "keyB", "keyC", ... , "keyY", "keyZ", "key0", "key1", "key2", ... , "key9", "keyF1", "keyF2", "keyF3", ... , "keyF12"

## Sprite
Constructor:  
Sprite(String filePath)
-> creates and loads the Sprite from the given Path

## Sound
Constructor:  
Sound(String filePath)
-> creates and loads the Sound from the given Path

Methods:
 - void play() >> plays the sound
 - void setVolume(double volume) >> changes the sound's loudness
     - 0.0 -> not audible at all
     - 0.5 -> 50% loudness
     - 1.0 -> max (100%) loudness
 - void loop(boolean loopInfinitly) >> loops the sound
 - void stop() >> stops playback of the sound

## Gameloop
-> interface  

Methods:
  - void onFrame() >> gets called every frame after the object, that implements it, has been passed to a window object via 'addGameloop(Gameloop gameloop)'

## Collision
Methods:
 - static boolean lineTouchingRect(int lineX, int lineY, int lineLength, int rectPosX, int rectPosY, int rectSizeX, int rectSizeY)
     - returns 'false' if line doesn't touch specified rectangle
     - returns 'true' if line touches specified rectangle
 - static boolean rectTouchingRect(int rect1PosX, int rect1PosY, int rect1SizeX, int rect1SizeY, int rect2PosX, int rect2PosY, int rect2SizeX, int rect2SizeY)
     - returns 'false' if rectangle doesn't touch specified rectangle
     - returns 'true' if rectangle touches specified rectangle
 - static boolean pointInsideRect(int pointX, int pointY, int rectPosX, int rectPosY, int rectSizeX, int rectSizeY)
     - returns 'false' if point isn't inside specified rectangle
     - returns 'true' if point is inside specified rectangle
 - static boolean lineInsideRect(int lineX, int lineY, int lineLength, int rectPosX, int rectPosY, int rectSizeX, int rectSizeY)
     - returns 'false' if line isn't inside specified rectangle
     - returns 'true' if line is inside specified rectangle
 - static boolean rectInsideRect(int rect1PosX, int rect1PosY, int rect1SizeX, int rect1SizeY, int rect2PosX, int rect2PosY, int rect2SizeX, int rect2SizeY)
     - returns 'false' if rectangle isn't inside specified rectangle
     - returns 'true' if rectangle is inside specified rectangle
