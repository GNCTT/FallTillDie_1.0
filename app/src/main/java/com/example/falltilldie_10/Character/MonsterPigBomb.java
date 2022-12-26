package com.example.falltilldie_10.Character;

import android.util.Log;

import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Object.Item.BombItem;
import com.example.falltilldie_10.Sprite.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

public class MonsterPigBomb extends Player{

    public static int speedFall = 1;
    public boolean throwing;
    public boolean afterThrow;
    public static final int distance = 50;
    public static final int countDownThrow = 50;
    private int countDown;
    public static final int TIME_THROW = 20;
    private int countTimeThrow;
    private int indexBomb;
    public static final int TIME_DISAPPEAR = 20;
    public int countDownDisAppear;

    public MonsterPigBomb(int x, int y, int index) {
        super(x, y);
        ImageEntity = Sprite.ImagePigBomIdlLeft;
        animate = 0;
        throwing = false;
        afterThrow = false;
        countDown = 0;
        countTimeThrow = 0;
        speed = (int)(5 * GameView.screenRatioX_1);
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        indexBomb = index;
    }

    @Override
    public void update() {
        //animate
        changeAnimate();
        if (y > GameView.getHeightScreen() || y < -200) {
            y = -200;
            die = false;
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
        if (!afterThrow) {
            animate = 0;
            afterThrow = true;
        }
        if (afterThrow) {
            countTimeThrow++;
            if (this.countTimeThrow > TIME_THROW) {
                BombItem bombItem = (BombItem) MapView.bombItems[indexBomb];
                if (bombItem.getX() == -1000) {
                    countTimeThrow = 0;
                    throwing = true;
                    bombItem.SetAppear(x, y, dir);
//                    bombItem.setBeThrow(true);
                }
                afterThrow = false;
            }
        }

    }

    public void update2(JSONObject jsonObject) {
        try {
//            x = jsonObject.getInt("x");
//            y = jsonObject.getInt("y");
            dir = jsonObject.getInt("dir");
            throwing = jsonObject.getBoolean("throwing");
            afterThrow = jsonObject.getBoolean("afterThrowing");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        update();
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
        if (throwing && !falling) {
            if (dir == 1) {
                ImageEntity = Sprite.movingSprite(Sprite.ImagePigThrowBombRights, animate, 30);
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.ImagePigThrowBombLefts, animate, 30);
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

//    @Override
//    public String toString() {
//        return "MonsterPigBomb{" +
//                "dir=" + dir +
//                ", falling=" + falling +
//                ", delta_x=" + delta_x +
//                ", delta_y=" + delta_y +
//                ", die=" + die +
//                '}';
//    }


    @Override
    public String toString() {
        return "MonsterPigBomb{" +
                "throwing=" + throwing +
                ", afterThrow=" + afterThrow +
                ", countDown=" + countDown +
                ", countTimeThrow=" + countTimeThrow +
                ", indexBomb=" + indexBomb +
                ", countDownDisAppear=" + countDownDisAppear +
                ", dir=" + dir +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("x", x);
            jsonObject.put("y", y);
            jsonObject.put("dir", dir);
            jsonObject.put("throwing", throwing);
            jsonObject.put("afterThrow", afterThrow);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
