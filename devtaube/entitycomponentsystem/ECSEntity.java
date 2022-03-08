package devtaube.entitycomponentsystem;

import java.util.ArrayList;

public final class ECSEntity
{
    ArrayList<ECSComponent> components = new ArrayList<>();

    public ECSEntity()
    {
    }

    public ECSEntity addComponent(ECSComponent component)
    {
        components.add(component);
        return this;
    }

}
