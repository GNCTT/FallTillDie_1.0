package com.example.falltilldie_10;

import android.graphics.Bitmap;

import com.example.falltilldie_10.Sprite.Sprite;

public abstract class Entity {
    protected int x;
    protected int y;
    protected final static int DEFAULT_BRICK_WIDTH = Sprite.ImageFanOn1.getWidth();
    protected final static int DEFAULT_BRICK_HEIGHT = Sprite.ImageFanOn1.getHeight();
    protected final static int FALL_SPEED_BRICK = 7;
    protected boolean flying;

    //rong dai
    protected int width;
    protected int height;
    protected int center_x;
    protected int center_y;
    protected int speed;
    protected int dir;
    protected Bitmap ImageEntity;

    protected boolean remove;
    protected boolean beDestroy;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;

        remove = false;
        beDestroy = false;
        flying = false;
    }


    public abstract boolean collide(Entity other);

    public abstract void update();
    public abstract void draw();

    public int getCenter_x() {
        return center_x;
    }

    public int getCenter_y() {
        return center_y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getRight() {
        return x + width;
    }

    public int getLeft() {
        return x;
    }

    public int getTop() {
        return y;
    }

    public int getBottom() {
        return y + height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }
    public void setDir(int dir) {
        this.dir = dir;
    }

    public void SetDisappear() {
    }
    public void SetAppear(int x, int y, int dir) {

    }
}
