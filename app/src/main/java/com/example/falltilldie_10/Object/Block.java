package com.example.falltilldie_10.Object;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;
import static com.example.falltilldie_10.Map.MapView.NUM_MAX_FAN;
import static com.example.falltilldie_10.Map.MapView.rand;

import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class Block extends Entity {
    private Brick[] bricks;
    private int size;
    public final static int DISTANCE_BRICK = GameView.getWidthScreen() / 5;
    private int index;

    public Block(int x, int y, int size, int index) {
        super(x, y);
        this.size = size;
        this.index = index;
        bricks = new Brick[NUM_MAX_FAN];
        width = DEFAULT_BRICK_WIDTH * size;
        height = DEFAULT_BRICK_HEIGHT;
        center_x = x + width / 2;
        center_y = y - height / 2;
        speed = FALL_SPEED_BRICK * 1;
        for (int i = 0; i < size; i++) {
            bricks[i] = new Brick(x + i * Entity.DEFAULT_BRICK_WIDTH, y);
        }
        for (int i = size; i < NUM_MAX_FAN; i++) {
            bricks[i] = new Brick(-10000, y);
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
            for (int i = 0; i < size; i++) {
                bricks[i].setFalling(false);
            }
            this.size = 1 + rand.nextInt(NUM_MAX_FAN);
            int pre_block_index = 0;
            if (this.index == 0) {
                pre_block_index = NUM_MAX_FAN - 1;
            } else {
                pre_block_index = index - 1;
            }

            Block preBlock = MapView.blocks[pre_block_index];
            int Max_rand_left = preBlock.getX() - DISTANCE_BRICK;
            int Max_rand_right = preBlock.getX() + preBlock.getWidth() + DISTANCE_BRICK;
            if (Max_rand_left < 0) {
                Max_rand_left = 0;
            }
            if (Max_rand_left + width > GameView.getWidthScreen()) {
                Max_rand_left = GameView.getHeightScreen() - width;
            }

            if (Max_rand_right + width > GameView.getWidthScreen()) {
                Max_rand_right = GameView.getWidthScreen() - width;
            }

            int bound = Max_rand_right - Max_rand_left;
            if (bound < 0) {
                bound = -bound;
            }
            if (bound == 0) {
                bound += 10;
            }
            int rand_location_x = rand.nextInt(bound);
            Log.i("rand: ", " " + rand_location_x);
            x = rand_location_x;

        }
        this.width = DEFAULT_BRICK_WIDTH * size;
        for (int i = 0; i < size; i++) {
            if (!bricks[i].checkFalling()) {
                bricks[i].setX(x + i * bricks[i].getWidth());
                bricks[i].setY(y);
            }
            bricks[i].update();
        }
        Log.i("blockToString", " " + toString());
    }

    public void update2(JSONObject jsonObject) {
        try {
            this.size = jsonObject.getInt("sizeBrick");
            for (int i = 0; i < size; i++) {
                JSONObject brickObject = jsonObject.getJSONObject("brick" + i);
                int x = brickObject.getInt("x");
                int y = brickObject.getInt("y");
                boolean flying = brickObject.getBoolean("flying");
                boolean falling = brickObject.getBoolean("falling");
                bricks[i].update2(x, y, flying, falling);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void updateByData(String data) {

    }

    @Override
    public void draw() {
        for (int i = 0; i < size; i++) {
            bricks[i].draw();
        }

    }

    public int getIndex() {
        return index;
    }

    public Brick getListBrick(int index) {
        return bricks[index];
    }

    public int getSizeBrick() {
        return bricks.length;
    }

    @Override
    public String toString() {
        String resBricks = "";
        for (int i = 0; i < size; i++) {
            resBricks += bricks[i].toString() + " ";
        }
        return "Block{" +
                "x=" + x +
                ", y=" + y +
                ", size=" + size +
                ", bricks= " + resBricks +
                ", index=" + index +
                '}';
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("sizeBrick", size);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            try {
                jsonObject.put("brick" + String.valueOf(i), bricks[i].toJson());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }
}
