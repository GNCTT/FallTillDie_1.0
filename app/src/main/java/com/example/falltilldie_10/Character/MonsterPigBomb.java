package com.example.falltilldie_10.Character;

import android.util.Log;

import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Object.Item.BombItem;
import com.example.falltilldie_10.Sprite.Sprite;

public class MonsterPigBomb extends Player{

    public static int speedFall = 1;
    public static boolean throwing;
    public static final int distance = 100;
    public static final int countDownThrow = 50;
    public int countDown;
    public static final int TIME_DISAPPEAR = 20;
    public int countDownDisAppear;

    public MonsterPigBomb(int x, int y) {
        super(x, y);
        ImageEntity = Sprite.ImagePigBomIdlLeft;
        animate = 0;
        throwing = false;
        countDown = 0;
        speed = (int)(10 * GameView.screenRatioX_1);
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
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

            int targetX = MapView.player.getX();
            int targetY = MapView.player.getY();
            if (y <= targetY) {
                if (x > targetX) {
                    if (x > targetX + distance) {
                        dir = -1;
                        delta_x = -speed;
                    } else {
                        delta_x = 0;
                    }
                } else {
                    if (x < targetX - distance) {
                        dir = 1;
                        delta_x = speed;
                    } else {
                        delta_x = 0;
                    }
                }
            }

        if (falling == false && throwing == false) {
            throwing = true;
            throwBomb();
        }
        if (throwing == true) {
            countDown ++;
            if (countDown > countDownThrow) {
                countDown = 0;
                throwing = false;
            }
        }
        chooseSprite();
    }

    public void throwBomb() {
        MapView.bombItems[MapView.CURRENT_BOMB].SetAppear(x, y, dir);
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

                ImageEntity = Sprite.movingSprite(Sprite.ImagePigBombIdlLefts, animate, 15);
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.PigBomRunLefts, animate, 15);
            }
        }
        if (falling) {
            if (dir == 1) {
                ImageEntity = Sprite.ImagePigBomFallRight;
            } else {
                ImageEntity = Sprite.ImagePigBomFallLeft;
            }
        }
        //function can cho vao ham rieng
//        if (throwing) {
//            if (dir == 1) {
//                ImageEntity = Sprite.movingSprite(Sprite.PigBomDoneRights, animate, 15);
//            } else {
//                ImageEntity = Sprite.movingSprite(Sprite.PigBomDoneLefts, animate, 15);
//            }
//            countDownDisAppear++;
//            if (countDownDisAppear > TIME_DISAPPEAR) {
//                remove = true;
//                countDownDisAppear = 0;
//            }
//
//        }

    }

}
