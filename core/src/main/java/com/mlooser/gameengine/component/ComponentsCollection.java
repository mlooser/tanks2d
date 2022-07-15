package com.mlooser.gameengine.component;

import com.mlooser.gameengine.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class ComponentsCollection {
    private Entity owner;
    private List<Component> components = new ArrayList<>();

    public ComponentsCollection(Entity owner) {
        this.owner = owner;
    }

    public Entity getOwner() {
        return owner;
    }

    public void addComponent(Component component){
        components.add(component);
        component.setOwnerCollection(this);
    }

    public <TComponent extends Component> TComponent findComponent(Class componentClass){
        return (TComponent) components
                .stream()
                .filter(component -> componentClass.isAssignableFrom(component.getClass()))
                .findFirst()
                .orElse(null);
    }
}
