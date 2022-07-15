package com.mlooser.gameengine.component;

public class Component {
    protected ComponentsCollection ownerCollection;

    void setOwnerCollection(ComponentsCollection ownerCollection) {
        this.ownerCollection = ownerCollection;
    }
}
