package com.example.falltilldie_10;

import android.graphics.Bitmap;

import com.example.falltilldie_10.Sprite.Sprite;

public abstract class Entity {
    protected int x;
    protected int y;
    protected final static int DEFAULT_BRICK_WIDTH = Sprite.ImageFanOn1.getWidth();
    protected final static int DEFAULT_BRICK_HEIGHT = Sprite.ImageFanOn1.getHeight();
    protected final static int FALL_SPEED_BRICK = 5;

    //rong dai
    protected int width;
    protected int height;

    protected Bitmap ImageEntity;

    protected boolean remove;
    protected boolean beDestroy;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;

        remove = false;
        beDestroy = false;
    }

    public abstract boolean collide(Entity other);

    public abstract void update();
    public abstract void draw();
}
