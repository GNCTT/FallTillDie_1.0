package com.example.falltilldie_10;

import android.graphics.Bitmap;

public abstract class Entity {
    protected int x;
    protected int y;

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
