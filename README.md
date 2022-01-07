# Introduction
Wein2D is a simple Graphics Library built on top of the javax.swing and java.awt libraries. It's primarily made for making games. It supports / has:
- creating the game/program's window and managing it
- adding your own 'onFrame' method to these windows to get called every frame
- drawing simple shapes and images to these windows, including text
- getting mouse and keyboard input from your user
- playing sounds
- simple methods for detecting collision

There is also a version for android development, [Wein2DAndroid](https://www.github.com/devtaube/wein2dandroid).

## Code example
This is a simple Example for a program (ExampleProgram.java):
![ExampleProgram.java](https://github.com/devtaube/wein2d/blob/main/markdown_images/exampleprogramclass.png?raw=true)

The code is also located in "./testapp".

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
   - int getFPS() >> returns the number of frames the gameloop did in the last second (value refreshes once per second), returns -1 if no gameloop object configured, returns 0 if no full second passed yet
- Gameloop
   - void addGameloop(Gameloop gameloop) >> add an object to the window that implements the "Gameloop" interface
   - void startGameloop() >> starts the gameloop on a new thread if a Gameloop-object is added
   - void setFPS(int fps) >> configures the gameloop to target the passed fps if a Gameloop-object is added
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
   - void drawText(String content, int posX, int posY, String positioning, int fontSize, String fontFamily, int colorR, int colorG, int colorB) >> draw text (with positioning)
        - positioning may be: "LEFT", "CENTER", "RIGHT"
   - void drawText(String content, int posX, int posY, String positioning, int fontSize, String fontFamily, int colorA, int colorR, int colorG, int colorB) >> draw text (with positioning, with alpha)
        - positioning may be: "LEFT", "CENTER", "RIGHT"
   - void fill(int colorR, int colorG, int colorB) >> fill window with color
   - void fill(int colorA, int colorR, int colorG, int colorB) >> fill window with color (with alpha)
   - void redraw() >> needed for your drawing to happen; call it once per frame
- Input
   - int getMouseX() >> returns the mouse's position on the x-axis
   - int getMouseY() >> returns the mouse's position on the y-axis
   - boolean getMouseL() >> returns if the mouse's left button is being pressed
   - boolean getMouseR() >> returns if the mouse's right button is being pressed
   - void getKey(String keyID) >> returns if a certain key on the keyboard is being pressed
       - key ID's: "ctrl", "shift", "space", "backspace", "enter", "alt", "arrUp", "arrDown", "arrLeft", "arrRight", "keyA", "keyB", "keyC", ... , "keyY", "keyZ", "key0", "key1", "key2", ... , "key9", "keyF1", "keyF2", "keyF3", ... , "keyF12"

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
