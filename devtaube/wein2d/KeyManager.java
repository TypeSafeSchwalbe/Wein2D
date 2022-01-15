package devtaube.wein2d;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyManager implements KeyListener
{
    // Variables ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected boolean[] keys = new boolean[58];
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
            case 8: keys[Key.BACKSPACE] = state; break;
            case 10: keys[Key.ENTER] = state; break;
            case 16: keys[Key.SHIFT] = state; break;
            case 17: keys[Key.CTRL] = state; break;
            case 18: keys[Key.ALT] = state; break;
            case 32: keys[Key.SPACE] = state; break;
            case 37: keys[Key.LEFT] = state; break;
            case 38: keys[Key.UP] = state; break;
            case 39: keys[Key.RIGHT] = state; break;
            case 40: keys[Key.DOWN] = state; break;
            case 48: keys[Key.N0] = state; break;
            case 49: keys[Key.N1] = state; break;
            case 50: keys[Key.N2] = state; break;
            case 51: keys[Key.N3] = state; break;
            case 52: keys[Key.N4] = state; break;
            case 53: keys[Key.N5] = state; break;
            case 54: keys[Key.N6] = state; break;
            case 55: keys[Key.N7] = state; break;
            case 56: keys[Key.N8] = state; break;
            case 57: keys[Key.N9] = state; break;
            case 65: keys[Key.A] = state; break;
            case 66: keys[Key.B] = state; break;
            case 67: keys[Key.C] = state; break;
            case 68: keys[Key.D] = state; break;
            case 69: keys[Key.E] = state; break;
            case 70: keys[Key.F] = state; break;
            case 71: keys[Key.G] = state; break;
            case 72: keys[Key.H] = state; break;
            case 73: keys[Key.I] = state; break;
            case 74: keys[Key.J] = state; break;
            case 75: keys[Key.K] = state; break;
            case 76: keys[Key.L] = state; break;
            case 77: keys[Key.M] = state; break;
            case 78: keys[Key.N] = state; break;
            case 79: keys[Key.O] = state; break;
            case 80: keys[Key.P] = state; break;
            case 81: keys[Key.Q] = state; break;
            case 82: keys[Key.R] = state; break;
            case 83: keys[Key.S] = state; break;
            case 84: keys[Key.T] = state; break;
            case 85: keys[Key.U] = state; break;
            case 86: keys[Key.V] = state; break;
            case 87: keys[Key.W] = state; break;
            case 88: keys[Key.X] = state; break;
            case 89: keys[Key.Y] = state; break;
            case 90: keys[Key.Z] = state; break;
            case 112: keys[Key.F1] = state; break;
            case 113: keys[Key.F2] = state; break;
            case 114: keys[Key.F3] = state; break;
            case 115: keys[Key.F4] = state; break;
            case 116: keys[Key.F5] = state; break;
            case 117: keys[Key.F6] = state; break;
            case 118: keys[Key.F7] = state; break;
            case 119: keys[Key.F8] = state; break;
            case 120: keys[Key.F9] = state; break;
            case 121: keys[Key.F10] = state; break;
            case 122: keys[Key.F11] = state; break;
            case 123: keys[Key.F12] = state; break;
        }
    }
}
