package com.example.falltilldie_10.Object;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.getHeightScreen;
import static com.example.falltilldie_10.GameView.paint;

import android.graphics.Rect;
import android.util.Log;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Sprite.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

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
        }
        chooseSprite();
    }

    public void update2(int x, int y, boolean flying, boolean falling) {
        this.x = x;
        this.y = y;
        this.falling = flying;
        this.falling = falling;
        changeAnimate();
        checkCollideBomb();
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

    public void setFalling(boolean falling) {
        this.falling = falling;
    }

    public void checkCollideBomb() {
        ArrayList<Entity> listBomb = new ArrayList<>();
        Entity[] bombItems = MapView.bombItems;
        for (int i = 0; i < bombItems.length; i++) {
            listBomb.add(bombItems[i]);
        }
        ArrayList<Entity> collide_list = checkListCollision(this, listBomb);
        if (collide_list.size() > 0) {
            for (int i = 0; i < collide_list.size(); i++) {
                collide_list.get(i).setExplosive();
            }
            falling = true;
        }


    }

    @Override
    public String toString() {
        return "Brick{" +
                "x=" + x +
                ", y=" + y +
                ", flying=" + flying +
                ", animate=" + animate +
                ", falling=" + falling +
                '}';
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("x", x);
            jsonObject.put("y", y);
            jsonObject.put("flying", flying);
            jsonObject.put("falling", falling);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;

    }
}
