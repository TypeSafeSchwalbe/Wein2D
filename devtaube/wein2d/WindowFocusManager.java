package devtaube.wein2d;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class WindowFocusManager implements WindowFocusListener
{

    private WindowFrame windowFrame;

    public WindowFocusManager(WindowFrame windowFrame)
    {
        this.windowFrame = windowFrame;
    }

    @Override
    public void windowGainedFocus(WindowEvent e)
    {
        resetButtons();
    }

    @Override
    public void windowLostFocus(WindowEvent e)
    {
        resetButtons();
    }

    private void resetButtons()
    {
        windowFrame.keyAdapter.resetButtons();
        windowFrame.mouseAdapter.resetButtons();
    }

}
