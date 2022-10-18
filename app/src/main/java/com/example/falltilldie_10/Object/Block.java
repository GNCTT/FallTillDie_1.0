package com.example.falltilldie_10.Object;

import android.graphics.Paint;

import com.example.falltilldie_10.Entity;

public class Block extends Entity {
    private Brick[] bricks;
    private int size;

    public Block(int x, int y, int size) {
        super(x, y);
        this.size = size;
        bricks = new Brick[size];
        width = DEFAULT_BRICK_WIDTH * size;
        height = DEFAULT_BRICK_HEIGHT;
        for (int i = 0; i < size; i++) {
            bricks[i] = new Brick(i * Entity.DEFAULT_BRICK_WIDTH, y);
        }
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        for (int i = 0; i < size; i++) {
            bricks[i].update();
        }
    }

    @Override
    public void draw() {
        for (int i = 0; i < size; i++) {
            bricks[i].draw();
        }
    }
}
