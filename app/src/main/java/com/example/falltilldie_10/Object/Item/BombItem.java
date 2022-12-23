package com.example.falltilldie_10.Object.Item;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;
import android.util.Log;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Sprite.Sprite;

import java.util.Map;

public class BombItem extends Entity {

    private int time_not_collide;
    private boolean can_be_collide;
    private int animate = 0;
    public static int TIME_EXPLOSIVE = 10;
    public static final int TIME_NOT_COLLIDE = 20;
    private int countDownTime = 0;
    private int countDownTimeDone = 0;
    private int flyStrength;
    private int speedFall;
    private boolean startExplosive;
    private boolean beThrow;
        //no instance
    public BombItem(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImageBombLive_1;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        flying = false;
        flyStrength = 30;
        speed = 5;
        speedFall = 1;
        explosive = false;
        startExplosive = false;
        countDownTimeDone = 0;
        countDownTime = 0;
        time_not_collide = 0;
        can_be_collide = false;
        beThrow = false;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        Log.i("" + time_not_collide + " " + can_be_collide + " " + beThrow, "hello2");
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        if (beThrow) {
            time_not_collide++;
        }
        if (time_not_collide > TIME_NOT_COLLIDE) {
            time_not_collide = 0;
            can_be_collide = true;
        }
        changeAnimate();

        if (!explosive && flying) {
            flyStrength -= 2 * speedFall;
            y -= flyStrength;
            x += speed * dir;
        }
        if (flying) {
            if (dir == 1) {
                ImageEntity = Sprite.movingSprite(Sprite.ImageBombLiveRights, animate, 15);
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.ImageBombLiveLefts, animate, 15);
            }
            countDownTime ++;
            if (countDownTime > 40) {
                explosive = true;
                countDownTime = 0;
            }
        }
        if (explosive) {
            if (!startExplosive) {
                animate = 0;
                startExplosive = true;
                x = x - Sprite.ImageBombExplosive_4.getWidth() / 2;
                y = y - Sprite.ImageBombExplosive_4.getHeight() / 2;
            }
            ImageEntity = Sprite.movingSprite(Sprite.ImageBombExplosives, animate, 15);
            countDownTimeDone ++;
            if (countDownTimeDone > TIME_EXPLOSIVE) {
                SetDisappear();
            }
        }
    }

    private void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    public boolean isCan_be_collide() {
        return can_be_collide;
    }

    @Override
    public void draw() {
        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
        if (remove == false) {
            if (explosive) {
                if (dir == 1) {
                    canvas.drawBitmap(ImageEntity, x, y, paint);
                } else {
                    canvas.drawBitmap(ImageEntity, x, y, paint);
                }
            } else {
                canvas.drawBitmap(ImageEntity, x, y, paint);
            }
        }
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
        remove = false;
    }

    public void SetDisappear() {
        x = -1000;
        y = -1000;
        speedFall = 0;
        speed = 0;
        explosive = false;
        remove = false;
        startExplosive = false;
    }

    public void SetAppear(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        flying = true;
        speedFall = 1;
        speed = 5;
        flyStrength = 30;
        countDownTime = 0;
        countDownTimeDone = 0;
        time_not_collide = 0;
        can_be_collide = false;
        beThrow = false;
    }

    public void setBeThrow(boolean beThrow) {
        this.beThrow = beThrow;
    }

    public boolean isBeThrow() {
        return beThrow;
    }

    public void setExplosive() {
        this.explosive = true;
    }


}
