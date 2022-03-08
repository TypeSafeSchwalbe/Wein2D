package devtaube.entitycomponentsystem;

import java.util.ArrayList;


public abstract class ECSSystem
{

    private static EntityComponentSystem ECS;

    static void addECS(EntityComponentSystem ecs)
    {
        ECS = ecs;
    }


    public <T> ArrayList<T> getComponentsByClass(Class<T> componentClass)
    {
        return ECS.getComponentsByClass(componentClass);
    }


    public abstract void onFrame();


}
