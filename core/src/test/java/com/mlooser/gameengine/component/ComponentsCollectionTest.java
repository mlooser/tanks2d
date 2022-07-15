package com.mlooser.gameengine.component;

import com.mlooser.gameengine.entity.Entity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ComponentsCollectionTest {
    private Entity owner;
    private ComponentsCollection components;


    public class ComponentA extends Component{}
    class ComponentB extends Component{}
    class ComponentASub extends ComponentA{}

    @BeforeEach
    public void beforeEach(){
        owner = new Entity();
        components = owner.getComponents();
    }

    @Test
    public void findWhenEmpty(){
        ComponentA foundComponent = components.findComponent(ComponentA.class);
        assertNull(foundComponent);
    }

    @Test
    public void findWhenSingle(){
        ComponentA ca = new ComponentA();
        components.addComponent(ca);

        ComponentA foundComponent = components.findComponent(ComponentA.class);

        assertEquals(ca,foundComponent);
    }

    @Test
    public void findWhenMany(){
        ComponentA ca = new ComponentA();

        components.addComponent(new ComponentB());
        components.addComponent(ca);

        ComponentA foundComponent = components.findComponent(ComponentA.class);

        assertEquals(ca,foundComponent);
    }

    @Test
    public void findBySubclass(){
        ComponentASub ca = new ComponentASub();

        components.addComponent(new ComponentB());
        components.addComponent(ca);

        ComponentA foundComponent = components.findComponent(ComponentA.class);

        assertEquals(ca,foundComponent);
    }

    @Test
    public void findByEntity(){
        ComponentA ca = new ComponentA();
        owner.addComponent(ca);

        ComponentA foundComponent = owner.findComponent(ComponentA.class);

        assertEquals(ca,foundComponent);
    }
}
