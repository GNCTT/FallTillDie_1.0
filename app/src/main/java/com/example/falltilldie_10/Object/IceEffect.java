package com.example.falltilldie_10.Object;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Sprite.Sprite;

public class IceEffect extends Entity {
    private final static int FALL_SPEED = (int) (5 * GameView.screenRatioY_1);
    public IceEffect(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImageIceParticle;
        speed = FALL_SPEED;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        y += FALL_SPEED;
    }

    @Override
    public void draw() {
        canvas.drawBitmap(ImageEntity, x, y, paint);
    }
}
