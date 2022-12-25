package com.example.falltilldie_10.Character;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;
import static com.example.falltilldie_10.Sprite.Sprite.ImageParticleLefts;
import static com.example.falltilldie_10.Sprite.Sprite.ImageParticleRights;

import android.graphics.Bitmap;

import com.example.falltilldie_10.Entity;
import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Object.Block;
import com.example.falltilldie_10.Object.Brick;
import com.example.falltilldie_10.Object.Item.BombItem;
import com.example.falltilldie_10.Sprite.Sprite;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Player extends Entity {

    public int dir;
    public boolean falling;
    public int animate;
    public int delta_x;
    public int delta_y;
    private int score;
    private int countScore;
    private static final int MAX_COUNT_SCORE = 100;
    public static final int DEFAULT_SPEED =(int)(5 * GameView.screenRatioX_1);
    public static final int DEFAULT_FALL_SPEED = (int)(8 * GameView.screenRatioY_1);
    private int speedFall = 1;
    private Bitmap ImageParticle;
    protected boolean die;

    public Player(int x, int y) {
        super(x, y);
//        ImageEntity = Sprite.ImagePigIdlLeft;
        ImageEntity = Sprite.ImagePigIdlRight_1;
//        ImageEntity = Sprite.ImagePigBomIdlLeft;
//        ImageEntity = Sprite.ImageBombDefault;
        width = ImageEntity.getWidth();
        height = ImageEntity.getHeight();
        center_x = x + width / 2;
        center_y = y - height / 2;
        dir = 1;
        falling = true;
        speed = DEFAULT_SPEED;
        animate = 0;
        ImageParticle = Sprite.ImageParticleRight_1;
        score = 0;
        countScore = 0;
        die = false;
    }

    @Override
    public boolean collide(Entity other) {
        return false;
    }

    @Override
    public void update() {
        countScore ++;
        if (countScore > MAX_COUNT_SCORE) {
            countScore = 0;
            score += 1;
        }
        height = ImageEntity.getHeight();
        width = ImageEntity.getWidth();
        checkDie();
        //animate
        changeAnimate();
        //move
        if (GameView.left) {
            delta_x = -speed;
            dir = -1;
        }

        if (GameView.right) {
            delta_x = speed;
            dir = 1;
        }
        if (GameView.right == false && GameView.left == false) {
            delta_x = 0;
        }
        delta_y = DEFAULT_FALL_SPEED * speedFall;
        falling = true;
        move(delta_x, delta_y);
        chooseSprite();
    }

    public void checkDie() {
        if (y < 0 || y + height > GameView.getHeightScreen()) {
            die = true;
        }
    }

    public boolean isDie() {
        return die;
    }

    private boolean canMove(int delta_x, int delta_y) {
        return true;
    }

    public void move(int delta_x, int delta_y) {

        // check bien co the them tin hieu gamover o day
        if (x + delta_x < 0 || x + delta_x + width > GameView.getWidthScreen()) {
            delta_x = 0;
        }

        ArrayList<Entity> listEntity = new ArrayList<>();
        // cos the them nhieu entity sau nay.
        Block[] listEntity2 = MapView.blocks;
        BombItem[] listBomb = (BombItem[]) MapView.bombItems;
        //
        for (int i = 0; i < listEntity2.length; i++) {
            for (int j = 0; j < listEntity2[i].getSizeBrick(); j++) {
                if (!listEntity2[i].getListBrick(j).checkFalling()) {
                    listEntity.add(listEntity2[i].getListBrick(j));
                }
            }
        }
//        for (int i = 0; i < listBomb.length; i++) {
//            if (listBomb[i].isCan_be_collide() && listBomb[i].isBeThrow()) {
//                listEntity.add(listBomb[i]);
//            }
//        }
        // va cham y.
        y += delta_y;
        ArrayList<Entity>  collide_list = checkListCollision(this, listEntity);

        if (collide_list.size() > 0) {
            for (int index = 0; index < collide_list.size(); index++) {
                if (collide_list.get(index) instanceof BombItem) {
                    collide_list.get(index).setExplosive();
                    die = true;
                }
            }
            if (!die) {
                falling = false;
                Entity otherEntity = collide_list.get(0);
                if (delta_y > 0) {
                    y = otherEntity.getTop() - height;
                } else {
                    if (delta_y < 0) {
                        y = otherEntity.getBottom();
                    }
                }
            }
        }

        x += delta_x;
        collide_list = checkListCollision(this, listEntity);
        //hello
        if (collide_list.size() > 0) {
            for (int index = 0; index < collide_list.size(); index++) {
                if (collide_list.get(index) instanceof BombItem) {
                    collide_list.get(index).setExplosive();
                    die = true;
                }
            }
            if (!die) {
                falling = false;
                Entity otherEntity = collide_list.get(0);
                if (delta_x > 0) {
                    x = otherEntity.getLeft() - width;
                } else {
                    if (delta_x < 0) {
                        x = otherEntity.getRight();
                    }
                }
            }
        }


    }


    public void changeAnimate() {
        animate++;
        if (animate > 7500) {
            animate = 0;
        }
    }

    public boolean changeImageByScore() {
        return false;
    }

    public void chooseSprite() {
        if (dir == 1) {
            if (delta_x == 0) {
               ImageEntity = Sprite.movingSprite(Sprite.PigIdlRight, animate, 15);
//                ImageEntity = Sprite.movingSprite(Sprite.VirtualIdlRights, animate, 15);
//                ImageEntity = Sprite.movingSprite(Sprite.ImagePigBombIdlRights, animate, 15);

            } else {
                ImageEntity = Sprite.movingSprite(Sprite.PigRunRights, animate, 15);
//                ImageEntity = Sprite.movingSprite(Sprite.VirtualRunRights, animate, 15);
//                ImageEntity = Sprite.movingSprite(Sprite.PigBomRunRights, animate, 15);
            }
        }
        else {
            if (delta_x == 0) {
                ImageEntity = Sprite.movingSprite(Sprite.PigIdlLefts, animate, 15);
            } else {
                ImageEntity = Sprite.movingSprite(Sprite.PigRunLefts, animate, 15);
            }
        }
        if (falling) {
            if (dir == 1) {
                ImageEntity = Sprite.ImagePigFallRight;
//                ImageEntity = Sprite.movingSprite(Sprite.VirtualDoubleRights, animate, 15);
//                ImageEntity = Sprite.ImagePigBomFallRight;
            } else {
                ImageEntity = Sprite.ImagePigFallLeft;
//                ImageEntity = Sprite.movingSprite(Sprite.VirtualDoubleLefts, animate, 15);
//                ImageEntity = Sprite.ImagePigBomFallLeft;
            }
        }

    }


    @Override
    public void draw() {
//        canvas.drawRect(new Rect(x, y, x + width, y + height), paint);
        if (!remove) {
            canvas.drawBitmap(ImageEntity, x, y, paint);
            if (delta_x != 0) {
                if (delta_x > 0 && !falling) {
                    ImageParticle = Sprite.movingSprite(ImageParticleRights, animate, 15);
                    canvas.drawBitmap(ImageParticle, x - ImageParticle.getWidth(), y + height - ImageParticle.getHeight(), paint);
                }
                if (delta_x < 0 && !falling) {
                    ImageParticle = Sprite.movingSprite(ImageParticleLefts, animate, 15);
                    canvas.drawBitmap(ImageParticle, x + width, y + height - ImageParticle.getHeight(), paint);
                }
            }
        }

    }

    @Override
    public String toString() {
        return "Player{" +
                "dir=" + dir +
                ", falling=" + falling +
                ", delta_x=" + delta_x +
                ", delta_y=" + delta_y +
                ", die=" + die +
                '}';
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("x", x);
            jsonObject.put("y", y);
            jsonObject.put("dir", dir);
            jsonObject.put("falling", falling);
            jsonObject.put("delta_x", delta_x);
            jsonObject.put("delta_y", delta_y);
            jsonObject.put("die", die);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return jsonObject;

    }

    public void update2(int x, int y, int dir, boolean falling, int delta_x, int delta_y, boolean die) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.falling = falling;
        this.delta_x = delta_x;
        this.delta_y = delta_y;
        this.die = die;
        height = ImageEntity.getHeight();
        width = ImageEntity.getWidth();
        checkDie();
        //animate
        changeAnimate();
        delta_y = DEFAULT_FALL_SPEED * speedFall;
        move(delta_x, delta_y);
        chooseSprite();
    }

}