package com.example.falltilldie_10.Object;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Sprite.Sprite;

public class Brick extends Entity {

    private int speed;
    private int animate;
    public Brick(int x, int y) {
        super(x, y);
        speed = FALL_SPEED_BRICK * 1;
        ImageEntity = Sprite.ImageFanOn1;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        animate = 0;
    }


    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        changeAnimate();
        y -= speed;
        if (y < -GameView.getHeightScreen()) {
            y = 1500;
        }
        chooseSprite();
    }

    private void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    public void chooseSprite() {
        ImageEntity = Sprite.movingSprite(Sprite.ImageFanOn, animate, 20);
    }

    public void changeSpeed(int newSpeed) {
        speed = newSpeed;
    }

    @Override
    public void draw() {
//       canvas.drawRect(new Rect(x, y, x + width, y - height), paint);
       canvas.drawBitmap(ImageEntity, x + width, y - height, paint);
    }
}
