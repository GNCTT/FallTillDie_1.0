package com.example.falltilldie_10.Object.Item;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameActivity;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.MusicService;
import com.example.falltilldie_10.SoundService;
import com.example.falltilldie_10.Sprite.Sprite;

import java.util.Map;

public class BombItem extends Entity {
    private int animate = 0;
    public static int TIME_EXPLOSIVE = 10;
    private int countDownTime = 0;
    private int countDownTimeDone = 0;
    private int flyStrength;
    private int speedFall;
    private boolean startExplosive;
    public Context gameActivity;
    public Intent soundBoom;


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
    }

    public BombItem(int x, int y, Context context) {
        super(x, y);
        this.gameActivity = context;
        soundBoom = new Intent(gameActivity, SoundService.class);

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
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
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
              //  gameActivity.startService(soundBoom);

            }
            gameActivity.startService(soundBoom);
            ImageEntity = Sprite.movingSprite(Sprite.ImageBombExplosives, animate, 15);
            countDownTimeDone ++;
            if (countDownTimeDone > TIME_EXPLOSIVE) {
                SetDisappear();
                gameActivity.stopService(soundBoom);
            }
        }
    }

    private void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    @Override
    public void draw() {
//        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
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
    }

    public void setExplosive() {
        this.explosive = true;
    }
}
