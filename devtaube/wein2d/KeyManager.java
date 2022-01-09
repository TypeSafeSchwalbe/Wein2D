package devtaube.wein2d;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyManager implements KeyListener
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected boolean ctrl = false;
    protected boolean shift = false;
    protected boolean space = false;
    protected boolean backspace = false;
    protected boolean enter = false;
    protected boolean alt = false;
    protected boolean keyA = false;
    protected boolean keyB = false;
    protected boolean keyC = false;
    protected boolean keyD = false;
    protected boolean keyE = false;
    protected boolean keyF = false;
    protected boolean keyG = false;
    protected boolean keyH = false;
    protected boolean keyI = false;
    protected boolean keyJ = false;
    protected boolean keyK = false;
    protected boolean keyL = false;
    protected boolean keyM = false;
    protected boolean keyN = false;
    protected boolean keyO = false;
    protected boolean keyP = false;
    protected boolean keyQ = false;
    protected boolean keyR = false;
    protected boolean keyS = false;
    protected boolean keyT = false;
    protected boolean keyU = false;
    protected boolean keyV = false;
    protected boolean keyW = false;
    protected boolean keyX = false;
    protected boolean keyY = false;
    protected boolean keyZ = false;
    protected boolean arrUp = false;
    protected boolean arrDown = false;
    protected boolean arrLeft = false;
    protected boolean arrRight = false;
    protected boolean key0 = false;
    protected boolean key1 = false;
    protected boolean key2 = false;
    protected boolean key3 = false;
    protected boolean key4 = false;
    protected boolean key5 = false;
    protected boolean key6 = false;
    protected boolean key7 = false;
    protected boolean key8 = false;
    protected boolean key9 = false;
    protected boolean keyF1 = false;
    protected boolean keyF2 = false;
    protected boolean keyF3 = false;
    protected boolean keyF4 = false;
    protected boolean keyF5 = false;
    protected boolean keyF6 = false;
    protected boolean keyF7 = false;
    protected boolean keyF8 = false;
    protected boolean keyF9 = false;
    protected boolean keyF10 = false;
    protected boolean keyF11 = false;
    protected boolean keyF12 = false;
    // KeyPressed ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyPressed(KeyEvent e)
    {
        setKey(e.getKeyCode(), true);
    }
    // KeyReleased ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyReleased(KeyEvent e)
    {
        setKey(e.getKeyCode(), false);
    }
    // KeyTyped ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e)
    {}
    // SetKey ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setKey(int keyID, boolean state) {
        switch(keyID)
        {
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
