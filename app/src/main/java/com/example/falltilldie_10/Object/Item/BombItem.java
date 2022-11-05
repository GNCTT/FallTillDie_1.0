package com.example.falltilldie_10.Object.Item;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.Sprite.Sprite;

public class BombItem extends Entity {
    private int animate = 0;
    public BombItem(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImageBombLive_1;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        changeAnimate();
        y ++;
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
        canvas.drawBitmap(Sprite.movingSprite(Sprite.ImageBombLives, animate, 20), x, y, paint);
    }
}
