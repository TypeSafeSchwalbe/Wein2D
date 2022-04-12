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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

class MouseManager extends MouseAdapter implements MouseWheelListener
{

    int mouseX = 0;
    int mouseY = 0;
    boolean mouseButtonL = false;
    boolean mouseButtonS = false;
    boolean mouseButtonR = false;
    int scrolledNotches = 0;

    void resetButtons()
    {
        mouseButtonL = false;
        mouseButtonS = false;
        mouseButtonR = false;
    }

    void resetScrolledNotches()
    {
        scrolledNotches = 0;
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }
    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        switch(e.getButton())
        {
            case 1: mouseButtonL = true; break;
            case 2: mouseButtonS = true; break;
            case 3: mouseButtonR = true; break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        switch(e.getButton())
        {
            case 1: mouseButtonL = false; break;
            case 2: mouseButtonS = false; break;
            case 3: mouseButtonR = false; break;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        scrolledNotches += e.getWheelRotation();
    }
}
