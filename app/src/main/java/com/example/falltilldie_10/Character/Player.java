package com.example.falltilldie_10.Character;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;

import com.example.falltilldie_10.Entity;

public class Player extends Entity {

    private final static int WIDTH_SIZE = 50;
    private final static int HEIGHT_SIZE = 50;

    public Player(int x, int y) {
        super(x, y);
        width = WIDTH_SIZE;
        height = HEIGHT_SIZE;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        y += 2;
        if (y > 1000) {
            y = 0;
            x += 10;
        }
    }

    @Override
    public void draw() {
        canvas.drawRect(new Rect(x, y, x + width,y - height), paint);
    }
}
