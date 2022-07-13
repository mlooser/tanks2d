package com.mlooser.gameengine.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryEntityManagerTest {

    private static final String NAME_1 = "name1";
    private static final String NAME_2 = "name2";

    private InMemoryEntityManager inMemoryEntityManager;

    @BeforeEach
    public void beforeEach() {
        inMemoryEntityManager = new InMemoryEntityManager();
    }

    @Test
    void addSingleEntity() {
        Entity e1 = new Entity(NAME_1);

        inMemoryEntityManager.addEntity(e1);

        var foundEntity = inMemoryEntityManager.findEntity(NAME_1);

        assertEquals(e1, foundEntity);
    }

    @Test
    void addManyEntity() {
        Entity e1 = new Entity(NAME_1);
        Entity e2 = new Entity(NAME_2);

        inMemoryEntityManager.addEntity(e1);
        inMemoryEntityManager.addEntity(e2);

        var foundEntity = inMemoryEntityManager.findEntity(NAME_2);

        assertEquals(e2, foundEntity);
    }

    @Test
    void findWhenNoEntities() {
        assertNull(inMemoryEntityManager.findEntity(NAME_1));
        assertFalse(inMemoryEntityManager.findEntities(NAME_1).findAny().isPresent());
    }

    @Test
    void findByDefaultName(){
        Entity e = new Entity();
        inMemoryEntityManager.addEntity(e);

        var foundEntity = inMemoryEntityManager.findEntity(Entity.DEFAULT_NAME);

        assertEquals(e, foundEntity);
    }

    @Test
    void findManyEntities() {
        inMemoryEntityManager.addEntity(new Entity(NAME_1));
        inMemoryEntityManager.addEntity(new Entity(NAME_1));

        assertEquals(2,
                inMemoryEntityManager
                        .findEntities(NAME_1)
                        .count());
    }
}