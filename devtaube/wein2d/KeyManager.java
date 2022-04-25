/*
 * Copyright (c) 2022, DevTaube
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *     Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *
 *     Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package devtaube.wein2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

class KeyManager implements KeyListener
{

    boolean[] keys = new boolean[59];
    String typedText = "";

    void resetButtons()
    {
        Arrays.fill(keys, false);
    }

    void setTypedText(String text) { typedText = text; }

    @Override
    public void keyPressed(KeyEvent e) { keys[getKeyIndex(e.getKeyCode())] = true; }

    @Override
    public void keyReleased(KeyEvent e) { keys[getKeyIndex(e.getKeyCode())] = false; }

    @Override
    public void keyTyped(KeyEvent e)
    {
        if(String.valueOf(e.getKeyChar()).equals(System.lineSeparator()) && e.getKeyChar() == '\n')
            return;

        if(e.getKeyChar() == '\b')
        {
            if(typedText.length() > 0)
                typedText = typedText.substring(0, typedText.length() - 1);

            return;
        }

        if(typedText.length() >= 1000)
            typedText = typedText.substring(1);

        typedText += e.getKeyChar();
    }

    private int getKeyIndex(int keyCode) {
        switch(keyCode)
        {
            case 8: return Key.BACKSPACE;
            case 10: return Key.ENTER;
            case 16: return Key.SHIFT;
            case 17: return Key.CTRL;
            case 18: return Key.ALT;
            case 27: return Key.ESC;
            case 32: return Key.SPACE;
            case 37: return Key.LEFT;
            case 38: return Key.UP;
            case 39: return Key.RIGHT;
            case 40: return Key.DOWN;
            case 48: return Key.N0;
            case 49: return Key.N1;
            case 50: return Key.N2;
            case 51: return Key.N3;
            case 52: return Key.N4;
            case 53: return Key.N5;
            case 54: return Key.N6;
            case 55: return Key.N7;
            case 56: return Key.N8;
            case 57: return Key.N9;
            case 65: return Key.A;
            case 66: return Key.B;
            case 67: return Key.C;
            case 68: return Key.D;
            case 69: return Key.E;
            case 70: return Key.F;
            case 71: return Key.G;
            case 72: return Key.H;
            case 73: return Key.I;
            case 74: return Key.J;
            case 75: return Key.K;
            case 76: return Key.L;
            case 77: return Key.M;
            case 78: return Key.N;
            case 79: return Key.O;
            case 80: return Key.P;
            case 81: return Key.Q;
            case 82: return Key.R;
            case 83: return Key.S;
            case 84: return Key.T;
            case 85: return Key.U;
            case 86: return Key.V;
            case 87: return Key.W;
            case 88: return Key.X;
            case 89: return Key.Y;
            case 90: return Key.Z;
            case 112: return Key.F1;
            case 113: return Key.F2;
            case 114: return Key.F3;
            case 115: return Key.F4;
            case 116: return Key.F5;
            case 117: return Key.F6;
            case 118: return Key.F7;
            case 119: return Key.F8;
            case 120: return Key.F9;
            case 121: return Key.F10;
            case 122: return Key.F11;
            case 123: return Key.F12;
        }
        return 0;
    }
}