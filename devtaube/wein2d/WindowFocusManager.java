package devtaube.wein2d;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

class WindowFocusManager implements WindowFocusListener
{

    boolean buttonsShouldReset = false;

    @Override
    public void windowGainedFocus(WindowEvent e)
    {
        buttonsShouldReset = true;
    }

    @Override
    public void windowLostFocus(WindowEvent e)
    {
        buttonsShouldReset = true;
    }

}
