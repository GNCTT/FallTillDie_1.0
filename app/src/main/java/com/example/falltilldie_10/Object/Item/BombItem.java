package com.example.falltilldie_10.Object.Item;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.Sprite.Sprite;

public class BombItem extends Entity {
    private int animate = 0;
    public static int TIME_EXPLOSIVE = 10;
    private boolean explosive;
    private int countDownTime = 0;
    private int countDownTimeDone = 0;
    private int flyStrength;
    public BombItem(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImageBombLive_1;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        flying = false;
        flyStrength = 30;
        explosive = false;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        changeAnimate();

        if (!explosive && flying) {
            flyStrength -= 2;
            y -= flyStrength;
            x += 5 * dir;
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
            ImageEntity = Sprite.movingSprite(Sprite.ImageBombExplosives, animate, 20);
            countDownTimeDone ++;
            if (countDownTimeDone > TIME_EXPLOSIVE) {
                countDownTimeDone = 0;
                explosive = false;
                flyStrength = 30;
                flying = false;
                remove = true;
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
            canvas.drawBitmap(ImageEntity, x, y, paint);
        }
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
        remove = false;
    }
}
