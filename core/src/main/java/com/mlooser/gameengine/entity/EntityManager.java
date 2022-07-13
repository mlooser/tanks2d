package com.mlooser.gameengine.entity;

import java.util.List;
import java.util.stream.Stream;

public interface EntityManager {
    void addEntity(Entity entity);
    Entity findEntity(String name);
    Stream<Entity> findEntities(String name);
}
