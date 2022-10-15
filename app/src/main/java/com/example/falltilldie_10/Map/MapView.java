package com.example.falltilldie_10.Map;

import com.example.falltilldie_10.Character.Player;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Sprite.Sprite;

public class MapView {
    private Background background;
    private int typeBackground;
    private int screenX;
    private int screenY;
    private Player player;

    public MapView(int screenX, int screenY) {
        this.screenX = screenX;
        this.screenY = screenY;
        background = new Background(screenX, screenY, GameView.res);
        typeBackground = 0;
        player = new Player(0, 250);
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
    }

    public void draw() {
        background.draw();
        player.draw();
    }

}
