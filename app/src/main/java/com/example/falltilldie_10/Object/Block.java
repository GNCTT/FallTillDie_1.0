package com.example.falltilldie_10.Object;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Paint;
import android.graphics.Rect;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;

public class Block extends Entity {
    private Brick[] bricks;
    private int size;

    public Block(int x, int y, int size) {
        super(x, y);
        this.size = size;
        bricks = new Brick[size];
        width = DEFAULT_BRICK_WIDTH * size;
        height = DEFAULT_BRICK_HEIGHT;
        center_x = x + width / 2;
        center_y = y - height / 2;
        speed = FALL_SPEED_BRICK * 1;
        for (int i = 0; i < size; i++) {
            bricks[i] = new Brick(x + i * Entity.DEFAULT_BRICK_WIDTH, y);
        }
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        y -= speed;
        if (y < -GameView.getHeightScreen()) {
            y = GameView.getHeightScreen();
        }
        for (int i = 0; i < size; i++) {
            bricks[i].update();
        }
    }

    @Override
    public void draw() {
//        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
        for (int i = 0; i < size; i++) {
            bricks[i].draw();
        }

    }
}
