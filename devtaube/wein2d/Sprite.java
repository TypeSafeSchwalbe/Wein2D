package devtaube.wein2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.net.URL;

public final class Sprite
{

    private Image image;

    public Sprite(String filePath, FileOrigin fileOrigin)
    {
        switch(fileOrigin)
        {
            case WORKING_DIRECTORY:
                try
                {
                    image = ImageIO.read(new File(filePath));
                }
                catch(Exception e) { e.printStackTrace(); }
                break;

            case CLASSPATH:
                try
                {
                    image = ImageIO.read(ClassLoader.getSystemClassLoader().getResourceAsStream(filePath));
                }
                catch(Exception e) { e.printStackTrace(); }
                break;

            case WEB_URL:
                try
                {
                    image = ImageIO.read(new URL(filePath));
                }
                catch(Exception e) { e.printStackTrace(); }
                break;
        }
    }

    public int getWidth() { return image.getWidth(null); }

    public int getHeight() { return image.getWidth(null); }

    public Image getImage()
    {
        return image;
    }

}
