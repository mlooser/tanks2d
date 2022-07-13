package com.mlooser.gameengine.entity;

public class Entity {
    public static final String DEFAULT_NAME = "default";
    private String name;

    public Entity() {
        this(DEFAULT_NAME);
    }

    public Entity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
