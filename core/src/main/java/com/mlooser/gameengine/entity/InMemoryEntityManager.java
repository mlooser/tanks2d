package com.mlooser.gameengine.entity;

import java.util.*;
import java.util.stream.Stream;

public class InMemoryEntityManager implements EntityManager{
    private Map<String, List<Entity>> entities = new HashMap<>();


    @Override
    public synchronized void addEntity(Entity entity) {
        List<Entity> entitiesByName = entities.get(entity.getName());
        if(entitiesByName == null){
            entities.put(entity.getName(), entitiesByName = new ArrayList<>());
        }
        entitiesByName.add(entity);
    }

    @Override
    public Entity findEntity(String name) {
        return findEntities(name)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Stream<Entity> findEntities(String name) {
        return entities
                .getOrDefault(name, Collections.EMPTY_LIST)
                .stream();
    }
}
