package com.mlooser.gameengine.component;

import com.badlogic.gdx.math.Vector2;

public class Transform2D extends Component {
    private Vector2 position = new Vector2(0,0);
    private float rotation;//radians

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public void move(Vector2 delta){
        position.add(delta);
    }

    public void rotate(float delta){
        rotation += delta;
    }
}
