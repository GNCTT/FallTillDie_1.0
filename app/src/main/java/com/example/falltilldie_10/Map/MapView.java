package com.example.falltilldie_10.Map;

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
    private Block[] blocks;
    private final static int NUM_BLOCK = 4;
    public MapView(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        background = new Background(screenX, screenY, GameView.res);
        typeBackground = 0;
        player = new Player(0, 250);
        blocks = new Block[NUM_BLOCK];
        //can tao ngau nhien bang ham
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i] = new Block(i * 200, i * -400, 1);
        }
    }

    public void update() {
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
    }

    public void draw() {
        background.draw();
        player.draw();
        for (int i = 0; i < NUM_BLOCK; i++) {
            blocks[i].draw();
        }
    }

}
