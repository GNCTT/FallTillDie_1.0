package com.example.falltilldie_10.Object.Item;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.Sprite.Sprite;

public class BombItem extends Entity {
    private int animate = 0;
    public BombItem(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {

    }

    private void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    @Override
    public void draw() {

    }
}
