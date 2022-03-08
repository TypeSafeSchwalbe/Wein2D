package devtaube.scenesystem;


public class SceneManager
{

    private static SceneManager SM = new SceneManager();
    private Scene currentScene;

    public static SceneManager getSM() { return SM; }

    public void setScene(Scene scene)
    {
        currentScene = scene;
    }

}
