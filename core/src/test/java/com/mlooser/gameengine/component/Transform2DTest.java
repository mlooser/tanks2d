package com.mlooser.gameengine.component;

import com.badlogic.gdx.math.Vector2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Transform2DTest {

    @Test
    public void moveTest(){
        Transform2D t = new Transform2D();

        t.move(new Vector2(1,1));

        assertEquals(new Vector2(1,1), t.getPosition());
    }

    @Test
    public void rotateTest(){
        Transform2D t = new Transform2D();

        t.rotate(1);

        assertEquals( 1, t.getRotation());
    }

}
