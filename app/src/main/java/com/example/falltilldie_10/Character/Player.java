package com.example.falltilldie_10.Character;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.widget.ImageView;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Sprite.Sprite;

public class Player extends Entity {

    private int dir;
    private boolean falling;
    private int animate;
    private int delta_x;
    private int delta_y;

    public Player(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImagePigIdlLeft;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        dir = 1;
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
            delta_x = -5;
            dir = -1;
        }

        if (GameView.right) {
            delta_x = 5;
            dir = 1;
        }
        if (GameView.right == false && GameView.left == false) {
            delta_x = 0;
        }
        delta_y = 2;
        move(delta_x, delta_y);
        chooseSprite();
    }

    private boolean canMove(int delta_x, int delta_y) {
        return true;
    }

    private void move(int delta_x, int delta_y) {
        if (x + delta_x < 0 || x + delta_x + width > GameView.getWidthScreen()) {
            delta_x = 0;
        }
        if (y + delta_y > 400) {
            delta_y = 0;
        }
        x += delta_x;
        y += delta_y;
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
                ImageEntity = Sprite.movingSprite(Sprite.PigRunRights, animate, 20);
            }
        }
        else {
            if (delta_x == 0) {
                ImageEntity = Sprite.ImagePigIdlLeft;
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.PigRunLefts, animate, 20);
            }
        }
        if (falling) {
            if (dir == -1) {
                ImageEntity = Sprite.ImagePigFallLeft;
            } else {
                ImageEntity = Sprite.ImagePigFallRight;
            }
        }

    }

    @Override
    public void draw() {
//        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
        canvas.drawBitmap(ImageEntity, x, y, paint);
    }
}
