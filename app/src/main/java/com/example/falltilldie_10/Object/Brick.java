package com.example.falltilldie_10.Object;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;
import android.util.Log;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Sprite.Sprite;

import java.util.ArrayList;
import java.util.Random;

public class Brick extends Entity {

    private int animate;
    private boolean falling;
//    private IceEffect[] listIces;
//    private static final int NUM_ICE = 4;
    public Brick(int x, int y) {
        super(x, y);
        speed = FALL_SPEED_BRICK * 2;
        ImageEntity = Sprite.ImageFanOn1;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        animate = 0;
//        listIces = new IceEffect[NUM_ICE];
//        for (int i = 0; i < NUM_ICE; i++) {
//            listIces[i] = new IceEffect(x + width / 5 + i * Sprite.ImageIceParticle.getWidth(), y);
//        }
        falling = false;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        changeAnimate();
        checkCollideBomb();
        if (falling) {
            y += speed;
            if (y > GameView.getHeightScreen() + 1000) {
                falling = false;
            }
        }
//        } else {
//            for (int i = 0; i < NUM_ICE; i++) {
//                if (listIces[i].getY() > y + height + 150) {
//                    listIces[i].setY(y + height);
//                }
//                listIces[i].update();
//            }
//        }
        chooseSprite();
    }

    private void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    public void chooseSprite() {
        if (falling) {
            ImageEntity = Sprite.ImageFanOn1;
        } else {
            ImageEntity = Sprite.movingSprite(Sprite.ImageFanOn, animate, 10);
        }
    }

    public void changeSpeed(int newSpeed) {
        speed = newSpeed;
    }

    @Override
    public void draw() {
//       canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
       canvas.drawBitmap(ImageEntity, x, y, paint);
    }

    public boolean checkFalling() {
        return falling;
    }

    public void checkCollideBomb() {
        ArrayList<Entity> listBomb = new ArrayList<>();
        Entity[] bombItems = MapView.bombItems;
        for (int i = 0; i < bombItems.length; i++) {
            listBomb.add(bombItems[i]);
        }
        ArrayList<Entity> collide_list = checkListCollision(this, listBomb);
        if (collide_list.size() > 0) {
            falling = true;
        }
    }

}
