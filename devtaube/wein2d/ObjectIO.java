package devtaube.wein2d;

import java.io.*;

public final class ObjectIO
{

    private ObjectIO() {}

    public static void serializeObject(Object object, String filePath)
    {
        try (
                FileOutputStream fileOutput = new FileOutputStream(filePath);
                ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        ) {
            objectOutput.writeObject(object);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public static Object deserializeObject(String filePath)
    {
        try (
                FileInputStream fileInput = new FileInputStream(filePath);
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
        ) {
            return objectInput.readObject();
        }
        catch (Exception e) { e.printStackTrace(); }
        return null;
    }

}
