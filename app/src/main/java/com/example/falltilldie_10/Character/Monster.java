package com.example.falltilldie_10.Character;

import android.util.Log;

import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Object.Item.BombItem;
import com.example.falltilldie_10.Sprite.Sprite;

public class Monster extends Player{

    public static int speedFall = 1;
    public static boolean throwing;

    public Monster(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImagePigBomIdlLeft;
        animate = 0;
        throwing = false;
    }

    @Override
    public void update() {
        //animate
        changeAnimate();
        if (y > GameView.getHeightScreen() || y < -200) {
            y = -200;
        }
        //move

        delta_y = DEFAULT_FALL_SPEED * speedFall;
        falling = true;
        move(delta_x, delta_y);
        if (falling == false && throwing == false) {
            throwing = true;
            throwBomb();
            Log.i("helloBug", MapView.bombItems.length + "??");
        }
        chooseSprite();
    }

    public void throwBomb() {
        BombItem bombItem = new BombItem(x, y);
        MapView.bombItems = MapView.addObject(MapView.bombItems, bombItem);
    }


    public void chooseSprite() {
        if (dir == 1) {
            if (delta_x == 0) {
                //ImageEntity = Sprite.ImagePigIdlRight;
//                ImageEntity = Sprite.ImageVirtualIdlRight;
                ImageEntity = Sprite.movingSprite(Sprite.ImagePigBombIdlRights, animate, 15);
            } else {
//                ImageEntity = Sprite.movingSprite(Sprite.PigRunRights, animate, 15);
//                ImageEntity = Sprite.movingSprite(Sprite.VirtualRunRights, animate, 15);
                ImageEntity = Sprite.movingSprite(Sprite.PigBomRunRights, animate, 15);
            }
        }
        else {
            if (delta_x == 0) {
//                ImageEntity = Sprite.ImagePigIdlLeft;
//                ImageEntity = Sprite.ImageVirtualIdlLeft;
                ImageEntity = Sprite.movingSprite(Sprite.ImagePigBombIdlLefts, animate, 15);
            } else {
//                ImageEntity = Sprite.movingSprite(Sprite.PigRunLefts, animate, 15);
//                ImageEntity = Sprite.movingSprite(Sprite.VirtualRunLefts, animate, 15);
                ImageEntity = Sprite.movingSprite(Sprite.PigBomRunLefts, animate, 15);
            }
        }
        if (falling) {
            if (dir == 1) {
//                ImageEntity = Sprite.ImagePigFallRight;
//                ImageEntity = Sprite.ImageVirtualFallRight;
                ImageEntity = Sprite.ImagePigBomFallRight;
            } else {
//                ImageEntity = Sprite.ImagePigFallLeft;
//                ImageEntity = Sprite.ImageVirtualFallLeft;
                ImageEntity = Sprite.ImagePigBomFallLeft;
            }
        }

    }

}
