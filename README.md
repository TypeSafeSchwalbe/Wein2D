# Introduction
Wein2D is a simple Graphics Library built on top of the javax.swing and java.awt libraries. It's primarily made for making games. It supports / has:
- creating the game/program's window and managing it
- adding your own 'onFrame' method to these windows to get called every frame
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
package testapp;

import devtaube.wein2d.*;

public class ExampleProgram implements Gameloop { // implements Gameloop so 'onFrame()' can be called

    Window window; // stores the window
    int ballX;

    public static void main(String[] args) { new ExampleProgram(); }

    public ExampleProgram() {
        // new Window() >> creates Window object
        // .setGameloopObject(this) >> adds this object as gameloop object
        // .build(); >> applies settings and shows new window, starts gameloop
        window = new Window().setGameloopObject(this).build();
    }

    public void onFrame() { // gets called once per frame
        ballX += 3;
        if (ballX > window.width) ballX = -50;
        window.fill(40, 40, 40); // fills the screen with gray
        window.drawOval(ballX, (window.height - 50) / 2, 50, 50, 255, 255, 255); // draws an oval
    }
}
```

# Documentation
This is a list of all features, classes and methods.

## Window
Constructor (Builder):  
Window()  
.setGameloopObject(Gameloop gameloop) >> sets an object implementing gameloop (configures gameloop at build) !REQUIRED!  
.setSize(int width, int height) >> sets the size of the window [default: 848, 480]  
.setFullscreen(boolean fullscreen) >> sets if the window is fullscreen or not [default: false]  
.setTitle(String title) >> sets the title of the window [default: "Wein2D Application"]  
.setResizable(boolean resizable) >> sets if the window is resizable or not [default: true]  
.setTargetedFPS(int fps) >> sets the targeted FPS [default: 60]  
.setIcon(String iconPath) >> sets an icon for the window  
.setIcon(java.awt.Image image) >> sets an icon for the window  
.setHardwareAcceleration(boolean doHardwareAcceleration) >> enables or disables hardware acceleration  
.build() >> configures the window, makes it visible and starts the gameloop (applies changes if used on an existing window)  

Methods:
- Getters
   - int getFPS() >> returns the number of frames the gameloop did in the last second (value refreshes once per second), returns -1 if no gameloop object configured, returns 0 if no full second passed yet
- Drawing stuff on screen
   - void drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) >> draw rectangle
   - void drawRect(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB) >> draw rectangle (with alpha)
   - void drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) >> draw oval
   - void drawOval(int posX, int posY, int sizeX, int sizeY, int colorA, int colorR, int colorG, int colorB) >> draw oval (with alpha)
   - void drawSprite(Sprite sprite, int posX, int posY) >> draw sprite
   - void drawSprite(Sprite sprite, int posX, int posY, int colorA) >> draw sprite (with alpha)
   - void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY) >> draw sprite (specified size)
   - void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int colorA) >> draw sprite (specified size, with alpha)
   - void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY) >> draw sprite (specified size and source size)
   - void drawSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY, int srcPosX, int srcPosY, int srcSizeX, int srcSizeY, int colorA) >> draw sprite (specified size and source size, with alpha)
   - void drawText(String content, int posX, int posY, int fontSize, String fontFamily, int colorR, int colorG, int colorB) >> draw text
   - void drawText(String content, int posX, int posY, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) >> draw text (with alpha)
   - void drawText(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorR, int colorG, int colorB) >> draw text (with positioning)
        - positioning may be: TextPositioning.LEFT, TextPositioning.CENTER, TextPositioning.RIGHT
   - void drawText(String content, int posX, int posY, int positioning, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) >> draw text (with positioning, with alpha)
        - positioning may be: TextPositioning.LEFT, TextPositioning.CENTER, TextPositioning.RIGHT
   - void fill(int colorR, int colorG, int colorB) >> fill window with color
   - void fill(int colorA, int colorR, int colorG, int colorB) >> fill window with color (with alpha)
   - void drawLine(int posX, int posY, int endX, int endY, int width, int colorR, int colorG, int colorB) >> draws a line on screen
   - void drawLine(int posX, int posY, int endX, int endY, int width, int colorA, int colorR, int colorG, int colorB) >> draws a line on screen with alpha
   - void redraw() >> needed for your drawing to happen; call it once per frame
- Input
   - int getMouseX() >> returns the mouse's position on the x-axis
   - int getMouseY() >> returns the mouse's position on the y-axis
   - boolean getMouseL() >> returns if the mouse's left button is being pressed
   - boolean getMouseR() >> returns if the mouse's right button is being pressed
   - void getKey(int keyID) >> returns if a certain key on the keyboard is being pressed
       - valid key ID's:
         - Key.CTRL, Key.SHIFT, Key.SPACE, Key.BACKSPACE, Key.ENTER, Key.ALT, Key.ESC
         - Key.UP, Key.DOWN, Key.LEFT, Key.RIGHT
         - Key.A, Key.B, Key.C, [...] Key.X, Key.Y, Key.Z
         - Key.N0, Key.N1, Key.N2, [...] Key.N7, Key.N8, Key.N9
         - Key.F1, Key.F2, Key.F3, [...] Key.F10, Key.F11, Key.F12

Variables:  
- int width >> stores the current width of the window
- int height >> stores the current height of the window

## Sprite
Constructors:  

Sprite(String filePath)  
-> creates and loads the Sprite from the given path  
Sprite(java.io.File file)  
-> creates and loads the sprite from the given file object  
Sprite(java.awt.Image image)  
-> creates the sprite from the given image object  

## Sound
Constructors:  

Sound(String filePath)  
-> creates and loads the sound from the given path  
Sound(java.io.File file)  
-> creates and loads the sound from the given file object  
Sound(javax.sound.sampled.Clip clip)  
-> creates the sound from the given clip object  

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

