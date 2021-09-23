package wein2d;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyManager implements KeyListener {
  public boolean ctrl = false;
  public boolean shift = false;
  public boolean space = false;
  public boolean backspace = false;
  public boolean enter = false;
  public boolean alt = false;
  public boolean keyA = false;
  public boolean keyB = false;
  public boolean keyC = false;
  public boolean keyD = false;
  public boolean keyE = false;
  public boolean keyF = false;
  public boolean keyG = false;
  public boolean keyH = false;
  public boolean keyI = false;
  public boolean keyJ = false;
  public boolean keyK = false;
  public boolean keyL = false;
  public boolean keyM = false;
  public boolean keyN = false;
  public boolean keyO = false;
  public boolean keyP = false;
  public boolean keyQ = false;
  public boolean keyR = false;
  public boolean keyS = false;
  public boolean keyT = false;
  public boolean keyU = false;
  public boolean keyV = false;
  public boolean keyW = false;
  public boolean keyX = false;
  public boolean keyY = false;
  public boolean keyZ = false;
  public boolean arrUp = false;
  public boolean arrDown = false;
  public boolean arrLeft = false;
  public boolean arrRight = false;
  public boolean key0 = false;
  public boolean key1 = false;
  public boolean key2 = false;
  public boolean key3 = false;
  public boolean key4 = false;
  public boolean key5 = false;
  public boolean key6 = false;
  public boolean key7 = false;
  public boolean key8 = false;
  public boolean key9 = false;
  public boolean keyF1 = false;
  public boolean keyF2 = false;
  public boolean keyF3 = false;
  public boolean keyF4 = false;
  public boolean keyF5 = false;
  public boolean keyF6 = false;
  public boolean keyF7 = false;
  public boolean keyF8 = false;
  public boolean keyF9 = false;
  public boolean keyF10 = false;
  public boolean keyF11 = false;
  public boolean keyF12 = false;

  @Override
  public void keyPressed(KeyEvent e) {
    setKey(e.getKeyCode(), true);
  }
  @Override
  public void keyReleased(KeyEvent e) {
    setKey(e.getKeyCode(), false);
  }
  @Override public void keyTyped(KeyEvent e) {}

  private void setKey(int keyID, boolean state) {
    switch(keyID) {
      case 8: backspace = state; break;
      case 10: enter = state; break;
      case 16: shift = state; break;
      case 17: ctrl = state; break;
      case 18: alt = state; break;
      case 32: space = state; break;
      case 37: arrLeft = state; break;
      case 38: arrUp = state; break;
      case 39: arrRight = state; break;
      case 40: arrDown = state; break;
      case 48: key0 = state; break;
      case 49: key1 = state; break;
      case 50: key2 = state; break;
      case 51: key3 = state; break;
      case 52: key4 = state; break;
      case 53: key5 = state; break;
      case 54: key6 = state; break;
      case 55: key7 = state; break;
      case 56: key8 = state; break;
      case 57: key9 = state; break;
      case 65: keyA = state; break;
      case 66: keyB = state; break;
      case 67: keyC = state; break;
      case 68: keyD = state; break;
      case 69: keyE = state; break;
      case 70: keyF = state; break;
      case 71: keyG = state; break;
      case 72: keyH = state; break;
      case 73: keyI = state; break;
      case 74: keyJ = state; break;
      case 75: keyK = state; break;
      case 76: keyL = state; break;
      case 77: keyM = state; break;
      case 78: keyN = state; break;
      case 79: keyO = state; break;
      case 80: keyP = state; break;
      case 81: keyQ = state; break;
      case 82: keyR = state; break;
      case 83: keyS = state; break;
      case 84: keyT = state; break;
      case 85: keyU = state; break;
      case 86: keyV = state; break;
      case 87: keyW = state; break;
      case 88: keyX = state; break;
      case 89: keyY = state; break;
      case 90: keyZ = state; break;
      case 112: keyF1 = state; break;
      case 113: keyF2 = state; break;
      case 114: keyF3 = state; break;
      case 115: keyF4 = state; break;
      case 116: keyF5 = state; break;
      case 117: keyF6 = state; break;
      case 118: keyF7 = state; break;
      case 119: keyF8 = state; break;
      case 120: keyF9 = state; break;
      case 121: keyF10 = state; break;
      case 122: keyF11 = state; break;
      case 123: keyF12 = state; break;
    }
  }
}
