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
        if (!(new File(fullFilePath).isFile()))
            System.out.println("[Wein2D] Error >> Image file at '" + fullFilePath + "' not found.");
        loadImage(new File(fullFilePath).getAbsoluteFile());
    }
    private void loadImage(File file)
    {
        try
        {
            image = ImageIO.read(file);
        }
        catch (Exception e)
        {
            System.out.println("[Wein2D] Error >> Something went wrong when trying to load the image file at \"" + file.getAbsolutePath() + "\". Stack trace:");
            e.printStackTrace();
        }
    }
    public Sprite(Image image)
    {
        this.image = image;
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
