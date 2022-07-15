package com.mlooser.gameengine.entity;

import com.mlooser.gameengine.component.Component;
import com.mlooser.gameengine.component.ComponentsCollection;

public class Entity {
    public static final String DEFAULT_NAME = "default";
    private String name;

    private ComponentsCollection components;

    public Entity() {
        this(DEFAULT_NAME);
    }

    public Entity(String name) {
        this.name = name;
        components = new ComponentsCollection(this);
    }

    public String getName() {
        return name;
    }

    public <TComponent extends Component> TComponent findComponent(Class componentClass){
        return components.findComponent(componentClass);
    }

    public ComponentsCollection getComponents() {
        return components;
    }

    public void addComponent(Component component){
        components.addComponent(component);
    }
}
