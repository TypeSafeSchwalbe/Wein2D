package devtaube.entitycomponentsystem;

import java.util.ArrayList;


public class EntityComponentSystem
{

    // variables

    private static EntityComponentSystem ECS = new EntityComponentSystem();
    private final ArrayList<ECSEntity> entities = new ArrayList<>();
    private final ArrayList<ECSSystem> systems = new ArrayList<>();


    // designed for use EVERYWHERE

    public static EntityComponentSystem getECS()
    {
        return ECS;
    }

    public void clearEntities()
    {
        entities.clear();
    }

    public void addEntity(ECSEntity ecsEntity)
    {
        entities.add(ecsEntity);
    }


    // designed for use IN MAIN CLASS

    public EntityComponentSystem()
    {
        ECSSystem.addECS(this);
    }

    public void addSystem(ECSSystem ecsSystem)
    {
        systems.add(ecsSystem);
    }

    public void onFrame()
    {
        for (ECSSystem ecsSystem : systems) {
            ecsSystem.onFrame();
        }
    }


    // designed for use IN ENTITYCOMPONENTSYSTEM ABSTRACT CLASSES
    protected <T> ArrayList<T> getComponentsByClass(Class<T> componentClass)
    {
        ArrayList<T> foundComponents = new ArrayList<>();
        for (final ECSEntity ecsEntity: entities) {
            for (final ECSComponent ecsComponent: ecsEntity.components) {
                if (ecsComponent.getClass().getName().equals(componentClass.getName())) {
                    foundComponents.add((T) ecsComponent);
                };
            }
        }
        return foundComponents;
    }

}
