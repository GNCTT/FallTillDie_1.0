package com.example.falltilldie_10.Map;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.falltilldie_10.Character.MonsterPigBomb;
import com.example.falltilldie_10.Character.Player;
import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.MainActivity;
import com.example.falltilldie_10.Object.Block;
import com.example.falltilldie_10.Object.Item.BombItem;
import com.example.falltilldie_10.Sprite.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

public class MapView {
    private Background background;
    private int typeBackground;
    private int screenX;
    private int screenY;

    public static Player player;
    public static Player player2;
    public static Block[] blocks;
    public static MonsterPigBomb[] monsterPigBombs;
    public static BombItem[] bombItems;

    public static Random rand;
    public final static int NUM_BLOCK = 10;
    private final static int NUM_BOMB = 20;
    public static int NUM_MONSTER = 1;
    public static int CURRENT_BOMB = 0;
    public final static int NUM_MAX_FAN = 3;
    private int score;
    private int count_score;
    private final int MAX_COUNT_SCORE = 50;
    public Context context;

    public MapView(int screenX, int screenY, Context context) {
        this.screenX = screenX;
        this.screenY = screenY;
        this.context = context;

        background = new Background(screenX, screenY, GameView.res);
        typeBackground = 0;
        //new player
        Log.i("currentIndexImage", " " + MainActivity.currentIndexImage);
        player = new Player(200, 100, MainActivity.currentIndexImage);
        player2 = new Player(200, 200);
        blocks = new Block[NUM_BLOCK];
        monsterPigBombs = new MonsterPigBomb[NUM_BLOCK];
        bombItems = new BombItem[NUM_BOMB];
        rand = new Random();
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsterPigBombs[i] = new MonsterPigBomb(20 + 200 * i, i, i);
        }
        //can tao ngau nhien bang ham.
        for (int i = 0; i < NUM_BLOCK; i++) {
            int int_random = 1 + rand.nextInt(NUM_MAX_FAN);
            blocks[i] = new Block(i * Sprite.ImageFanOn1.getWidth(), GameView.getHeightScreen() + i * - GameView.getHeightScreen() / 5, int_random, i);
        }
        for (int i = 0; i < NUM_BOMB; i++) {
            bombItems[i] = new BombItem(-1000, 1000, context);
        }
        score = 0;
        count_score = 0;
    }

    public void update() {
        count_score ++;
        if (count_score > MAX_COUNT_SCORE) {
            count_score = 0;
            score ++;
        }
        background.update();
        if (player.changeImageByScore()) {
            background.changeBackground(screenX, screenY, GameView.res, typeBackground);
            typeBackground += 1;
            if (typeBackground >= 2) {
                typeBackground = 0;
            }
        }
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i].update();
        }
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsterPigBombs[i].update();
        }
        player.update();
        for (int i = 0; i < NUM_BOMB; i++) {
            bombItems[i].update();
        }
    }

    public void updateOnline(JSONObject playerObject) {
        try {
            int x = playerObject.getInt("x");
            int y = playerObject.getInt("y");
            int dir = playerObject.getInt("dir");
            boolean falling = playerObject.getBoolean("falling");
            int delta_x = playerObject.getInt("delta_x");
            int delta_y = playerObject.getInt("delta_y");
            boolean die = playerObject.getBoolean("die");
            player2.update2(x, y, dir, falling, delta_x, delta_y, die);
            player.update();
            count_score ++;
            if (count_score > MAX_COUNT_SCORE) {
                count_score = 0;
                score ++;
            }
            background.update();
            if (player.changeImageByScore()) {
                background.changeBackground(screenX, screenY, GameView.res, typeBackground);
                typeBackground += 1;
                if (typeBackground >= 2) {
                    typeBackground = 0;
                }
            }
            for (int i = 0; i < NUM_BLOCK; i++) {
                blocks[i].update();
            }
            for (int i = 0; i < NUM_MONSTER; i++) {
                monsterPigBombs[i].update();
            }
            player.update();
            for (int i = 0; i < NUM_BOMB; i++) {
                bombItems[i].update();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void draw() {
        background.draw();
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i].draw();
        }
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsterPigBombs[i].draw();
        }
        player.draw();
        for (int i = 0; i < NUM_BOMB; i++) {
            bombItems[i].draw();
        }
        paint.setColor(Color.WHITE);
        paint.setTextSize(GameView.getWidthScreen() / 20);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(String.valueOf(score), GameView.getWidthScreen() * 9 / 10, GameView.getHeightScreen() * 2 / 50, paint);
    }

    public int getScore() {
        return score;
    }

    public void drawOver() {
        background = new Background(screenX, screenY, GameView.res);
        background.draw();
        paint.setTextSize(GameView.getWidthScreen() / 10);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Your Score: " + String.valueOf(score), GameView.getWidthScreen() / 4, GameView.getHeightScreen() / 2, paint);
    }

    public boolean isOVer() {
        return player.isDie();
    }

    public void draw_waiting() {
        background = new Background(screenX, screenY, GameView.res);
        background.draw();
        paint.setColor(Color.WHITE);
        paint.setTextSize(GameView.getWidthScreen() / 20);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Waiting other player", GameView.getWidthScreen() / 4, GameView.getHeightScreen() / 2, paint);
    }

    public void drawOnline() {

        background.draw();
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i].draw();
        }
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsterPigBombs[i].draw();
        }
        player2.draw();
        player.draw();

        for (int i = 0; i < NUM_BOMB; i++) {
            bombItems[i].draw();
        }
        paint.setColor(Color.WHITE);
        paint.setTextSize(GameView.getWidthScreen() / 20);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(String.valueOf(score), GameView.getWidthScreen() * 9 / 10, GameView.getHeightScreen() * 2 / 50, paint);
    }

    public void draw_not_connect() {
        background = new Background(screenX, screenY, GameView.res);
        background.draw();
        paint.setColor(Color.WHITE);
        paint.setTextSize(GameView.getWidthScreen() / 20);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("Please check your network", GameView.getWidthScreen() / 4, GameView.getHeightScreen() / 2, paint);
    }

    @Override
    public String toString() {
        String blockString = "";
        String monterString = "";
        String bomItemString = "";
        for (int i = 0; i < NUM_BLOCK; i++) {
            blockString += blocks[i].toString();
        }
        for (int i = 0; i < NUM_MONSTER; i++) {
            monterString += monsterPigBombs[i].toString();
        }
        for (int i = 0; i < NUM_BOMB; i++) {
            bomItemString += bombItems[i].toString();
        }

        return "MapView{ " +
                blockString + " " +
                player.toString() + " " +
                monterString + " " +
                '}';
    }

    public JSONObject makeJSonObject() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Player", player.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JSONObject makeJSonObjectPlayer() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Player", player.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
