package com.example.falltilldie_10;

import android.graphics.Bitmap;

import com.example.falltilldie_10.Sprite.Sprite;

import java.util.ArrayList;

public abstract class Entity {
    protected int x;
    protected int y;
    protected final static int DEFAULT_BRICK_WIDTH = (int) (Sprite.ImageFanOn1.getWidth() * GameView.screenRatioX_1);
    protected final static int DEFAULT_BRICK_HEIGHT = (int) (Sprite.ImageFanOn1.getHeight() * GameView.screenRatioY_1);
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
    protected boolean explosive;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;

        remove = false;
        beDestroy = false;
        flying = false;
    }


    public abstract boolean collide(Entity other);

    public boolean checkCollision(Entity e1, Entity e2) {
        boolean check1 = e1.getRight() <= e2.getLeft() || e1.getLeft() >= e2.getRight();
        boolean check2 = e1.getBottom() <= e2.getTop() || e1.getTop() >= e2.getBottom();
        if (check1 || check2) {
            return false;
        }
        return true;
    }

    public ArrayList<Entity> checkListCollision(Entity e1, ArrayList<Entity> listEntity) {
        ArrayList<Entity> collideList = new ArrayList<>();
        for (int i = 0; i < listEntity.size(); i++) {
            Entity entity = listEntity.get(i);
            if (checkCollision(e1, entity)) {
                collideList.add(entity);
            }
        }
        return collideList;
    }

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

    public void setExplosive() {

    }
}
