import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseManager extends MouseAdapter {
  public int mouseX = 0;
  public int mouseY = 0;
  public boolean mouseButtonL = false;
  public boolean mouseButtonR = false;

  public void mouseMoved(MouseEvent e) {
    mouseX = e.getX();
    mouseY = e.getY();
  }
  public void mousePressed(MouseEvent e) {
    if (e.getButton() == 1) { mouseButtonL = true; }
    else if (e.getButton() == 3) { mouseButtonR = true; }
  }
  public void mouseReleased(MouseEvent e) {
    if (e.getButton() == 1) { mouseButtonL = false; }
    else if (e.getButton() == 3) { mouseButtonR = false; }
  }
}
