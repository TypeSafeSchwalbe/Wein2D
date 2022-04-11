package devtaube.wein2d;

import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {

    private final Wein2DApplication wein2DApplication;
    private Graphics2D currentGraphics;

    private boolean locked;

    public Panel(Wein2DApplication wein2DApplication) {
        this.wein2DApplication = wein2DApplication;
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(wein2DApplication.width, wein2DApplication.height);
    }

    @Override
    public void paintComponent(Graphics g) {
        locked = false;

        super.paintComponent(g);
        currentGraphics = (Graphics2D) g;

        wein2DApplication.internalOnFrame();

        locked = true;
    }

    boolean getLocked()
    {
        return locked;
    }

    Graphics2D getCurrentGraphics()
    {
        return currentGraphics;
    }

}
