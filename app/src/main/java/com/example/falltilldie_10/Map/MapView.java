package com.example.falltilldie_10.Map;

import com.example.falltilldie_10.Character.MonsterPigBomb;
import com.example.falltilldie_10.Character.Player;
import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Object.Block;
import com.example.falltilldie_10.Object.Item.BombItem;
import com.example.falltilldie_10.Sprite.Sprite;

import java.util.Random;

public class MapView {
    private Background background;
    private int typeBackground;
    private int screenX;
    private int screenY;
    public static Player player;
    public static Block[] blocks;
    public static MonsterPigBomb[] monsterPigBombs;
    public static Entity[] bombItems;
    public static Random rand;
    public final static int NUM_BLOCK = 10;
    private final static int NUM_BOMB = 20;
    private final static int NUM_MONSTER = 1;
    public static int CURRENT_BOMB = 0;
    public final static int NUM_MAX_FAN = 3;

    public MapView(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        background = new Background(screenX, screenY, GameView.res);
        typeBackground = 0;
        //new player
        player = new Player(200, 100);
        blocks = new Block[NUM_BLOCK];
        monsterPigBombs = new MonsterPigBomb[NUM_BLOCK];
        bombItems = new BombItem[NUM_BOMB];
        rand = new Random();
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsterPigBombs[i] = new MonsterPigBomb(400, -100);
        }
        //can tao ngau nhien bang ham.
        for (int i = 0; i < NUM_BLOCK; i++) {
            int int_random = 1 + rand.nextInt(NUM_MAX_FAN);
            blocks[i] = new Block(i * Sprite.ImageFanOn1.getWidth(), GameView.getHeightScreen() + i * - GameView.getHeightScreen() / 5, int_random, i);
        }
        for (int i = 0; i < NUM_BOMB; i++) {
            bombItems[i] = new BombItem(i * 100, 10000);
        }
    }

    public void update() {
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
        for (int i = 0; i < NUM_BLOCK; i++) {
            bombItems[i].update();
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
    }

    public static Entity[] addObject(Entity[] entities, Entity entity) {
        Entity[] entities2 = new Entity[entities.length + 1];
        if (entities.length != 0) {
            for (int i = 0; i < entities.length; i++) {
                entities2[i] = entities[i];
            }
        }
        entities2[entities.length] = entity;
        return entities2;
    }


}
