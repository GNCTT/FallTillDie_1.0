package com.example.falltilldie_10.Map;

import com.example.falltilldie_10.Character.Monster;
import com.example.falltilldie_10.Character.Player;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Object.Block;
import com.example.falltilldie_10.Sprite.Sprite;

public class MapView {
    private Background background;
    private int typeBackground;
    private int screenX;
    private int screenY;
    private Player player;
    public static Block[] blocks;
    public Monster[] monsters;
    private final static int NUM_BLOCK = 6;
    private final static int NUM_MONSTER = 1;
    public MapView(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        background = new Background(screenX, screenY, GameView.res);
        typeBackground = 0;
        //new player
        player = new Player(400, -100);
        blocks = new Block[NUM_BLOCK];
        monsters = new Monster[NUM_BLOCK];
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsters[i] = new Monster(400, -100);
        }
        //can tao ngau nhien bang ham.
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i] = new Block(i * 100, i * -300, 1);
        }
    }

    public void update() {
        background.update();
        player.update();
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
            monsters[i].update();
        }
    }

    public void draw() {
        background.draw();
        player.draw();
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i].draw();
        }
        for (int i = 0; i < NUM_MONSTER; i++) {
            monsters[i].draw();
        }
    }

}
