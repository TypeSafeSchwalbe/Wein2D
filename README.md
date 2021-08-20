# Wein2D
A very simple Graphics Library for Java built on top of the native java.awt and javax.swing libraries. It has support for creating multiple Windows, drawing simple shapes, images and text to these Windows, detecting input from keyboard and mouse and playing sounds.

# Basic Example
Here is an example for a simple Window:
```java
public class BasicExample {
  public static void main(String[] args) {
    Window exampleWindow = new Window(500, 500, false);
    exampleWindow.defineTitle("Basic Example");
    exampleWindow.defineVisible(true);
  }
}
```

# Window (Basics)
- **Window(int width, int height, boolean resizable) -> *create a Window Object***
- Window.defineTitle(String title) -> *choose a Title for your Window*
- Window.defineIcon(Sprite icon) -> *choose an Icon for your Window*
- Window.defineVisible(boolean visible) -> *change the visibility of your Window (false by default)*

# Window (Drawing)
- Window.drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) -> *draw a rectangle onto the window*
- Window.drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB) -> *draw an oval onto the window*
- Window.drawSprite(Sprite sprite, int posX, int posY) -> *draw sprite onto the window*
- Window.drawText(String content, int posX, int posY, int size, String fontFamily, int colorR, int colorG, int colorB) -> *draw Text onto the window*
- Window.update() -> *update the window (needed for the drawing methods to take effect)*

# Window (Input)
- Window.getMousePosX() -> *returns the position of the mouse on the X axis (int)*
- Window.getMousePosY() -> *returns the position of the mouse on the Y axis (int)*
- Window.getMouseButtonL() -> *returns the state of the left mouse button (boolean)*
- Window.getMouseButtonR() -> *returns the state of the right mouse button (boolean)*
- Window.getKeyState(String keyID) -> *returns the current state of the given key (boolean)*
* KeyID's: "ctrl", "shift", "space", "backspace", "enter", "alt", "arrUp", "arrDown", "arrLeft", "arrRight", "keyA", "keyB", "keyC", "keyD", "keyE", "keyF", "keyG", "keyH", "keyI", "keyJ", "keyK", "keyL", "keyM", "keyN", "keyO", "keyP", "keyQ", "keyR", "keyS", "keyT", "keyU", "keyV", "keyW", "keyX", "keyY", "keyZ", "key0", "key1", "key2", "key3", "key4", "key5", "key6", "key7", "key8", "key9", "KeyF1", "KeyF2", "KeyF3", "KeyF4", "KeyF5", "KeyF6", "KeyF7", "KeyF8", "KeyF9", "KeyF10", "KeyF11", "KeyF12"

# Sprite
- **Sprite(String filePath) -> *create a Sprite Object from a file for later drawing***

# Sound
- **Sound(String filePath) -> *create a Sound Object from a .wav file***
- Sound.play() -> *play the sound*
- Sound.loop(int times) -> *play the sound and repeat it the amount of times given (0 means it loops indefinitly)*
- Sound.stop() -> *stops playing the sound*
