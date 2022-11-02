package com.example.falltilldie_10.Character;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.widget.ImageView;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Sprite.Sprite;

import java.util.ArrayList;
import java.util.Map;

public class Player extends Entity {

    private int dir;
    private boolean falling;
    private int animate;
    private int delta_x;
    private int delta_y;
    public static final int DEFAULT_SPEED = 8;
    public static final int DEFAULT_FALL_SPEED = 8;
    private int speedFall;

    public Player(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImagePigIdlLeft;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        center_x = x + width / 2;
        center_y = y - height / 2;
        dir = 1;
        falling = true;
        speed = DEFAULT_SPEED;
        speedFall = 1;
        animate = 0;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        //animate
        changeAnimate();
        //move
        if (GameView.left) {
            delta_x = -speed;
            dir = -1;
        }

        if (GameView.right) {
            delta_x = speed;
            dir = 1;
        }
        if (GameView.right == false && GameView.left == false) {
            delta_x = 0;
        }
        delta_y = DEFAULT_FALL_SPEED * speedFall;
        falling = true;
        move(delta_x, delta_y);
        chooseSprite();
    }

    private boolean canMove(int delta_x, int delta_y) {
        return true;
    }

    private void move(int delta_x, int delta_y) {

        // check bien co the them tin hieu gamover o day
        if (x + delta_x < 0 || x + delta_x + width > GameView.getWidthScreen()) {
            delta_x = 0;
        }

        ArrayList<Entity> listEntity = new ArrayList<>();
        // cos the them nhieu entity sau nay.
        Entity [] listEntity2 = MapView.blocks;
        //
        for (int i = 0; i < listEntity2.length; i++) {
            listEntity.add(listEntity2[i]);
        }
        // va cham y.
        y += delta_y;
        ArrayList<Entity>  collide_list = checkListCollision(this, listEntity);

        if (collide_list.size() > 0) {
            falling = false;
            Entity otherEntity = collide_list.get(0);
            if (delta_y > 0) {
                y = otherEntity.getTop() - height;
            } else {
                if (delta_y < 0) {
                    y = otherEntity.getBottom();
                }
            }
        }

        //va cham x
        x += delta_x;
        collide_list = checkListCollision(this, listEntity);
        if (collide_list.size() > 0) {
            falling = false;
            Entity otherEntity = collide_list.get(0);
            if (delta_x > 0) {
                x = otherEntity.getLeft() - width;
            } else {
                if (delta_x < 0) {
                    x = otherEntity.getRight();
                }
            }
        }


    }


    private void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    public boolean changeImageByScore() {
        if (y == 500) {
            return true;
        }
        return false;
    }

    private void chooseSprite() {
        if (dir == 1) {
            if (delta_x == 0) {
                ImageEntity = Sprite.ImagePigIdlRight;
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.PigRunRights, animate, 15);
            }
        }
        else {
            if (delta_x == 0) {
                ImageEntity = Sprite.ImagePigIdlLeft;
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.PigRunLefts, animate, 15);
            }
        }
        if (falling) {
            if (dir == 1) {
                ImageEntity = Sprite.ImagePigFallRight;
            } else {
                ImageEntity = Sprite.ImagePigFallLeft;
            }
        }

    }

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

    @Override
    public void draw() {
//        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
        canvas.drawBitmap(ImageEntity, x, y, paint);
    }
}
