package devtaube.wein2d;

import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;

public class Sprite
{
    // Store Sprite (Image) ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Image image;
    // Constructor ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Sprite(String filePath)
    {
        // store full path as string
        String fullFilePath = System.getProperty("user.dir") + "/" + filePath;
        // replace all leftover backslashes with foreward slashes
        fullFilePath = fullFilePath.replace("\\", "/");
        // print if the image does even exist
        if (!(new File(fullFilePath).exists()))
        {
          System.out.println("Error when loading an image: image at '" + fullFilePath + "' doesn't exist.");
        }
        // load the image from the stores path
        try
        {
            // load the sprite
            image = ImageIO.read(new File(fullFilePath));
        }
        catch (Exception spriteLoadingException)
        {
            // print if error
            System.out.println("Error: Something went wrong when loading the image at '" + fullFilePath + "'.");
        }
    }
    // Getters ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected Image getImage()
    {
        // return the stored image
        return image;
    }
    public int getWidth()
    {
        return image.getWidth(null);
    }
    public int getHeight()
    {
        return image.getHeight(null);
    }
}
