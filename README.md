# Wein2D
...is very simple Graphics Library for Java built on top of the java.awt and javax.swing libraries. It has support for creating multiple Windows, drawing simple shapes, images and text to these Windows, detecting input from keyboard and mouse and playing sounds.

# Basic Example
Here is an example for a simple Window:
```java
import wein2d.*;

public class BasicExample {
  public static void main(String[] args) {
    Window exampleWindow = new Window(500, 500);
    exampleWindow.defineTitle("Basic Example");
    exampleWindow.defineVisible(true);
  }
}
```

# Window (Basics)
- **Window(int width, int height) -> *create a Window Object***
- Window.getWidth() -> *returns the Window's width (Width of canvas (JPanel), window itself is a few pixels wider)*
- Window.getHeight() -> *returns the Window's height (Height of canvas (JPanel), window itself is a few pixels taller)*
- Window.defineTitle(String title) -> *choose a Title for your Window*
- Window.defineIcon(Sprite icon) -> *choose an Icon for your Window*
- Window.defineFullScreen(boolean fullScreen) -> *define if the Window fills the entire Screen or not*
- Window.defineResizable(boolean resizable) -> *define if the Window can be resized by the user*
- Window.defineVisible(boolean visible) -> *change the visibility of your Window (false by default)*

# Window (Drawing)
- Window.drawRect(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB, boolean drawAfterSprites) -> *draw a rectangle onto the window*
  * drawAfterSprites -> false = gets drawn before sprites are drawn, true = gets drawn after sprites
- Window.drawOval(int posX, int posY, int sizeX, int sizeY, int colorR, int colorG, int colorB, boolean drawAfterSprites) -> *draw an oval onto the window*
  * drawAfterSprites -> false = gets drawn before sprites are drawn, true = gets drawn after sprites
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
- Sprite.getImage() -> *returns the Sprite as an java.awt.Image (import needed).*
- Sprite.getImage().getWidth(null) -> *returns the Sprite's width.*
- Sprite.getImage().getHeight(null) -> *returns the Sprite's height.*

# Sound
- **Sound(String filePath) -> *create a Sound Object from a .wav file***
- Sound.setLoudness(double loudness) -> *sets the loudness of that particular sound on a scale from 0.0 to 1.0 (0 = quitest, 1 = loudest).*
  * Warning! This sadly only works with 16-Bit audio.
- Sound.play() -> *play the sound*
- Sound.loop(int times) -> *play the sound and repeat it the amount of times given (0 means it loops indefinitly)*
- Sound.stop() -> *stops playing the sound*
