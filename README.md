# Introduction
Wein2D is a simple Graphics Library built on top of the javax.swing and java.awt libraries. It's primarily made for making games. It supports / has:
- creating your own 'Wein2DApplication'-Class that acts as a single window
- drawing simple shapes and images to these windows, including text
- getting mouse and keyboard input from your user
- playing sounds
- simple methods for detecting collision

Other Versions:  
[Wein2DAndroid](https://www.github.com/devtaube/wein2dandroid)  
[Wein2D.js](https://www.github.com/devtaube/wein2d.js)  

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
This is a list of all features, classes and methods.

## Wein2DApplication (abstract class)

Abstract Methods:
- abstract void onFrame() >> gets called once per frame

Methods:
- Getters
   - int getFPS() >> returns the number of frames the gameloop did in the last second (value refreshes once per second), returns -1 if no gameloop object configured, returns 0 if no full second passed yet
- Setters
   - final void setSize(int sizeX, int sizeY) >> set the window's size (848x480 by default)
   - final void setFullscreen(boolean fullscreen) >> set if the window is fullscreen (disabled by default)
   - final void setTitle(String title) >> sets the window's title ("Wein2D Application" by default)
   - final void setResizable(boolean resizable) >> set if the window is resizable (enabled by default)
   - final void setTargetedFPS(int fps) >> set the amount of frames per second the gameloop targets (a value below 1 or above 1000 means unlimited) (60 by default)
   - final void setIcon(String iconPath) >> set the window's icon (none by default)
   - final void setIcon(Image image) >> set the window's icon (none by default)
   - final void setHardwareAcceleration(boolean doHardwareAcceleration) >> use opengl (enabled by default)
   - final void build() >> needed for changes to apply and for window to be visible
- Drawing stuff
   - final void drawRect(double posX, double posY, double sizeX, double sizeY, int colorR, int colorG, int colorB) >> draw rectangle
   - final void drawRect(double posX, double posY, double sizeX, double sizeY, int colorA, int colorR, int colorG, int colorB) >> draw rectangle (with alpha)
   - final void drawOval(double posX, double posY, double sizeX, double sizeY, int colorR, int colorG, int colorB) >> draw oval
   - final void drawOval(double posX, double posY, double sizeX, double sizeY, int colorA, int colorR, int colorG, int colorB) >> draw oval (with alpha)
   - final void drawSprite(Sprite sprite, double posX, double posY) >> draw sprite
   - final void drawSprite(Sprite sprite, double posX, double posY, int colorA) >> draw sprite (with alpha)
   - final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY) >> draw sprite (specified size)
   - final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int colorA) >> draw sprite (specified size, with alpha)
   - final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY) >> draw sprite (specified size and source size)
   - final void drawSprite(Sprite sprite, double posX, double posY, double sizeX, double sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA) >> draw sprite (specified size and source size, with alpha)
   - final void drawText(String content, double posX, double posY, double fontSize, String fontFamily, int colorR, int colorG, int colorB) >> draw text
   - final void drawText(String content, double posX, double posY, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) >> draw text (with alpha)
   - final void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorR, int colorG, int colorB) >> draw text (with positioning)
        - positioning may be: TextPositioning.LEFT, TextPositioning.CENTER, TextPositioning.RIGHT
   - final void drawText(String content, double posX, double posY, int positioning, double fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) >> draw text (with positioning, with alpha)
        - positioning may be: TextPositioning.LEFT, TextPositioning.CENTER, TextPositioning.RIGHT
   - final void fill(int colorR, int colorG, int colorB) >> fill window with color
   - final void fill(int colorA, int colorR, int colorG, int colorB) >> fill window with color (with alpha)
   - final void drawLine(double posX, double posY, double endX, double endY, double width, int colorR, int colorG, int colorB) >> draws a line on screen
   - final void drawLine(double posX, double posY, double endX, double endY, double width, int colorA, int colorR, int colorG, int colorB) >> draws a line on screen with alpha
- Input
   - final int getMouseX() >> returns the mouse's position on the x-axis
   - final int getMouseY() >> returns the mouse's position on the y-axis
   - final boolean getMouseL() >> returns if the mouse's left button is being pressed
   - final boolean getMouseR() >> returns if the mouse's right button is being pressed
   - final void getKey(int keyID) >> returns if a certain key on the keyboard is being pressed
       - valid key ID's:
         - Key.CTRL, Key.SHIFT, Key.SPACE, Key.BACKSPACE, Key.ENTER, Key.ALT, Key.ESC
         - Key.UP, Key.DOWN, Key.LEFT, Key.RIGHT
         - Key.A, Key.B, Key.C, [...] Key.X, Key.Y, Key.Z
         - Key.N0, Key.N1, Key.N2, [...] Key.N7, Key.N8, Key.N9
         - Key.F1, Key.F2, Key.F3, [...] Key.F10, Key.F11, Key.F12

Variables:  
- int width >> stores the current width of the window
- int height >> stores the current height of the window
- int deltaTime >> time in seconds since last frame

## Sprite
Constructors:  

Sprite(String filePath)  
-> creates and loads the Sprite from the given path  
Sprite(java.io.File file)  
-> creates and loads the sprite from the given file object  
Sprite(java.awt.Image image)  
-> creates the sprite from the given image object  

Methods:
 - final int getWidth() >> returns the sprite's width
 - final int getHeight() >> returns the sprite's height

## Sound
Constructors:  

Sound(String filePath)  
-> creates and loads the sound from the given path  
Sound(java.io.File file)  
-> creates and loads the sound from the given file object  
Sound(javax.sound.sampled.Clip clip)  
-> creates the sound from the given clip object  

Methods:
 - final void play() >> plays the sound  
 - final void setFramePosition(int frame) >> sets the position inside the sound (call this using '0' to play a sound from the start before calling 'play()')  
 - final void setVolume(double volume) >> changes the sound's loudness  
     - 0.0 -> not audible at all  
     - 0.5 -> 50% loudness  
     - 1.0 -> max (100%) loudness  
 - final void loop(boolean loopInfinitly) >> loops the sound  
 - final void stop() >> stops playback of the sound  

## Collision
Methods:
 - static boolean lineTouchingRect(int lineX, int lineY, int lineLengthOnXAxis, int rectPosX, int rectPosY, int rectSizeX, int rectSizeY)
     - returns 'false' if line doesn't touch specified rectangle
     - returns 'true' if line touches specified rectangle
 - static boolean rectTouchingRect(int rect1PosX, int rect1PosY, int rect1SizeX, int rect1SizeY, int rect2PosX, int rect2PosY, int rect2SizeX, int rect2SizeY)
     - returns 'false' if rectangle doesn't touch specified rectangle
     - returns 'true' if rectangle touches specified rectangle
 - static boolean pointInsideRect(int pointX, int pointY, int rectPosX, int rectPosY, int rectSizeX, int rectSizeY)
     - returns 'false' if point isn't inside specified rectangle
     - returns 'true' if point is inside specified rectangle
 - static boolean lineInsideRect(int lineX, int lineY, int lineLengthOnXAxis, int rectPosX, int rectPosY, int rectSizeX, int rectSizeY)
     - returns 'false' if line isn't inside specified rectangle
     - returns 'true' if line is inside specified rectangle
 - static boolean rectInsideRect(int rect1PosX, int rect1PosY, int rect1SizeX, int rect1SizeY, int rect2PosX, int rect2PosY, int rect2SizeX, int rect2SizeY)
     - returns 'false' if rectangle isn't inside specified rectangle
     - returns 'true' if rectangle is inside specified rectangle

## FileIOMethods
Methods:
 - static Sprite loadSpriteFromClassPath(String filePath) >> returns a Sprite object relative to the class path (for example from the root dir of a jar if running inside one)
 - static Sound loadSoundFromClassPath(String filePath) >> returns a Sound object relative to the class path (for example from the root dir of a jar if running inside one)
 - static void serializeObject(Object object, String filePath) >> stores the given object as a file at the given location
 - static Object deserializeObject(String filePath) >> reads an object from the given location and returns it
