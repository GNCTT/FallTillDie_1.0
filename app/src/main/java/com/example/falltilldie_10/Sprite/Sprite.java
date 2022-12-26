package com.example.falltilldie_10.Sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.R;

import java.util.ArrayList;

public class Sprite {
    public final static Bitmap ImagePigDefault = BitmapFactory.decodeResource(GameView.res, R.drawable.idll);
    public final static Bitmap ImagePigBomDefault = BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1l);
    public final static Bitmap ImageVirtualDefault = BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidll);
    public final static Bitmap ImageParticleDefault = BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle1);
    public final static Bitmap ImageBombLive = BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1);
    public final static Bitmap ImageBombExplosive = BitmapFactory.decodeResource(GameView.res, R.drawable.bom4l);
    public final static Bitmap ImageIceParticle = BitmapFactory.decodeResource(GameView.res, R.drawable.ice_particle);

    public final static Bitmap background1 = BitmapFactory.decodeResource(GameView.res, R.drawable.background4);

    public final static Bitmap ImageFan = BitmapFactory.decodeResource(GameView.res, R.drawable.propeller1);
    private final static int DEFAULT_WIDTH_FAN_SIZE = (int) (ImageFan.getWidth() * GameView.screenRatioX_1);
    private final static int DEFAULT_HEIGHT_FAN_SIZE = (int) (ImageFan.getHeight() * GameView.screenRatioY_1);

    private final static int Default_Width_Size = (int) (ImagePigDefault.getWidth() * GameView.screenRatioX_1);
    private final static int Default_Height_Size = (int) (ImagePigDefault.getHeight() * GameView.screenRatioY_1);

    private final static int Default_Width_Size_Bomb = (int) (ImageBombLive.getWidth() * GameView.screenRatioX_1);
    private final static int Default_Height_Size_Bomb = (int) (ImageBombLive.getHeight() * GameView.screenRatioY_1);

    private final static int Default_Width_Size_Bomb_Explosive = (int) (ImageBombExplosive.getWidth() * GameView.screenRatioX_1 * 3 / 2) ;
    private final static int Default_Height_Size_Bomb_Explosive = (int) (ImageBombExplosive.getHeight() * GameView.screenRatioY_1 * 3 / 2);

    private final static int DEFAULT_WIDTH_SIZE_PARTICLE = (int) (ImageParticleDefault.getWidth() * GameView.screenRatioX_1);
    private final static int DEFAULT_HEIGHT_SIZE_PARTICLE = (int) (ImageParticleDefault.getHeight() * GameView.screenRatioY_1);

    private final static int DEFAULT_WIDTH_SIZE_PIG_BOMB = (int)(ImagePigBomDefault.getWidth() * GameView.screenRatioX_1);
    private final static int DEFAULT_HEIGHT_SIZE_PIG_BOMB = (int)(ImagePigBomDefault.getHeight() * GameView.screenRatioY_1);

    private final static int DEFAULT_WIDTH_SIZE_ICE_PARTICLE = (int)(ImageIceParticle.getWidth() * GameView.screenRatioX_1);
    private final static int DEFAULT_HEIGHT_SIZE_ICE_PARTICLE = (int)(ImageIceParticle.getHeight() * GameView.screenRatioY_1);

    private final static int Default_Scale_X = 32;
    private final static int Default_Scale_Y = 21;

    private final static int DEFAULT_BACKGROUND_WIDTH = (int)(background1.getWidth() * GameView.screenRatioX_1);
    private final static int DEFAULT_BACKGROUND_HEIGHT = (int)(background1.getHeight() * GameView.screenRatioY_1);

    public final static Bitmap ImageBackground_1 = createImage(background1, DEFAULT_BACKGROUND_WIDTH, DEFAULT_BACKGROUND_HEIGHT);

    public final static Bitmap ImagePigIdlLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle1l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle2l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle3l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle4l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle5l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle6l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_7 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle7l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_8 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle8l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_9 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle9l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_10 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle10l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_11 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle11l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlLeft_12 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle12l), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigIdlLefts = createListImage(ImagePigIdlLeft_1, ImagePigIdlLeft_2, ImagePigIdlLeft_3, ImagePigIdlLeft_4, ImagePigIdlLeft_5, ImagePigIdlLeft_6,
            ImagePigIdlLeft_7, ImagePigIdlLeft_8, ImagePigIdlLeft_9, ImagePigIdlLeft_10, ImagePigIdlLeft_11, ImagePigIdlLeft_12);

    public final static Bitmap ImageIceParticle_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.ice_particle), DEFAULT_WIDTH_SIZE_ICE_PARTICLE, DEFAULT_HEIGHT_SIZE_ICE_PARTICLE);

    public final static Bitmap ImagePigIdlRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle1r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle2r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle3r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle4r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle5r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle6r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_7 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle7r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_8 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle8r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_9 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle9r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_10 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle10r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_11 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle11r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigIdlRight_12 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigidle12r), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigIdlRight = createListImage(ImagePigIdlRight_1, ImagePigIdlRight_2, ImagePigIdlRight_3, ImagePigIdlRight_4, ImagePigIdlRight_5, ImagePigIdlRight_6,
            ImagePigIdlRight_7, ImagePigIdlRight_8, ImagePigIdlRight_9, ImagePigIdlRight_10, ImagePigIdlRight_11, ImagePigIdlRight_12);

    public final static Bitmap ImagePigRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run1l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run2l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run3l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run4l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run5l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run6l), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigRunLefts = createListImage(ImagePigRunLeft_1, ImagePigRunLeft_2, ImagePigRunLeft_3,
                                                                        ImagePigRunLeft_4, ImagePigRunLeft_5, ImagePigRunLeft_6);

    public final static Bitmap ImagePigRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run1r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run2r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run3r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run4r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run5r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run6r), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigRunRights = createListImage(ImagePigRunRight_1, ImagePigRunRight_2, ImagePigRunRight_3,
            ImagePigRunRight_4, ImagePigRunRight_5, ImagePigRunRight_6);

    public final static Bitmap ImagePigFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.falll), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.fallr), Default_Width_Size, Default_Height_Size);

    public final static Bitmap ImageVirtualIdlLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle1l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle2l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle4l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle5l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle6l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle7l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_7 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle10l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlLeft_8 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle11l), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> VirtualIdlLefts = createListImage(ImageVirtualIdlLeft_1, ImageVirtualIdlLeft_2, ImageVirtualIdlLeft_3,
            ImageVirtualIdlLeft_4, ImageVirtualIdlLeft_5, ImageVirtualIdlLeft_6, ImageVirtualIdlLeft_7, ImageVirtualIdlLeft_8);

    public final static Bitmap ImageVirtualIdlRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle1r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle2r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle4r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle5r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle6r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle7r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_7 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle10r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualIdlRight_8 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidle11r), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> VirtualIdlRights = createListImage(ImageVirtualIdlRight_1, ImageVirtualIdlRight_2, ImageVirtualIdlRight_3, ImageVirtualIdlRight_4, ImageVirtualIdlRight_5,
            ImageVirtualIdlRight_6, ImageVirtualIdlRight_7, ImageVirtualIdlRight_8);

    public final static Bitmap ImageVirtualRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun1l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun2l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun3l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun4l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun5l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun6l), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> VirtualRunLefts = createListImage(ImageVirtualRunLeft_1, ImageVirtualRunLeft_2, ImageVirtualRunLeft_3,
            ImageVirtualRunLeft_4, ImageVirtualRunLeft_5, ImageVirtualRunLeft_6);

    public final static Bitmap ImageVirtualRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun1r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun2r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun3r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun4r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun5r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun6r), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> VirtualRunRights = createListImage(ImageVirtualRunRight_1, ImageVirtualRunRight_2, ImageVirtualRunRight_3,
            ImageVirtualRunRight_4, ImageVirtualRunRight_5, ImageVirtualRunRight_6);

    public final static Bitmap ImageVirtualFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualfalllr), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImageVirtualFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualfallr), Default_Width_Size, Default_Height_Size);


    public final static Bitmap ImagePigNormalIdlLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle1l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle2l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle3l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle4l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle5l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle6l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_7 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle7l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlLeft_8 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle8l), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigNormalIdlLefts = createListImage(ImagePigNormalIdlLeft_1, ImagePigNormalIdlLeft_2, ImagePigNormalIdlLeft_3, ImagePigNormalIdlLeft_4, ImagePigNormalIdlLeft_5,
            ImagePigNormalIdlLeft_6, ImagePigNormalIdlLeft_7, ImagePigNormalIdlLeft_8);

    public final static Bitmap ImagePigNormalIdlRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle1r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle2r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle3r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle4r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle5r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle6r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_7 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle7r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalIdlRight_8 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalidle8r), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigNormalIdlRights = createListImage(ImagePigNormalIdlRight_1, ImagePigNormalIdlRight_2, ImagePigNormalIdlRight_3, ImagePigNormalIdlRight_4, ImagePigNormalIdlRight_5,
            ImagePigNormalIdlRight_6, ImagePigNormalIdlRight_7, ImagePigNormalIdlRight_8);

    public final static Bitmap ImagePigNormalRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun1l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun2l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun3l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun4l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun5l), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun6l), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigNormalRunLefts = createListImage(ImagePigNormalRunLeft_1, ImagePigNormalRunLeft_2, ImagePigNormalRunLeft_3, ImagePigNormalRunLeft_4,
            ImagePigNormalRunLeft_5, ImagePigNormalRunLeft_6);

    public final static Bitmap ImagePigNormalRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun1r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun2r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun3r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun4r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun5r), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalrun6r), Default_Width_Size, Default_Height_Size);

    public final static ArrayList<Bitmap> PigNormalRunRights = createListImage(ImagePigNormalRunRight_1, ImagePigNormalRunRight_2, ImagePigNormalRunRight_3, ImagePigNormalRunRight_4,
            ImagePigNormalRunRight_5, ImagePigNormalRunRight_6);

    public final static Bitmap ImagePigNormalFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalfalll), Default_Width_Size, Default_Height_Size);
    public final static Bitmap ImagePigNormalFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pignormalfallr), Default_Width_Size, Default_Height_Size);

    public final static Bitmap ImagePigBomIdlLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static Bitmap ImagePigBomIdlLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle2l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle3l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle4l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle5l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlLeft6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle6l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> ImagePigBombIdlLefts = createListImage(ImagePigBomIdlLeft_1, ImagePigBomIdlLeft_2, ImagePigBomIdlLeft_3,
            ImagePigBomIdlLeft_4, ImagePigBomIdlLeft_5, ImagePigBomIdlLeft6);

    public final static Bitmap ImagePigBomIdlRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle3r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle4r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle5r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomIdlRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle6r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> ImagePigBombIdlRights = createListImage(ImagePigBomIdlRight_1, ImagePigBomIdlRight_2, ImagePigBomIdlRight_3,
            ImagePigBomIdlRight_4, ImagePigBomIdlRight_5, ImagePigBomIdlRight_6);

    public final static Bitmap ImagePigThrowBombRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb1r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb3r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb4r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb5r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> ImagePigThrowBombRights = createListImage(ImagePigThrowBombRight_1, ImagePigThrowBombRight_2, ImagePigThrowBombRight_3,
            ImagePigThrowBombRight_4, ImagePigThrowBombRight_5);

    public final static Bitmap ImagePigThrowBombLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb1l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb2l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb3l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb4l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigThrowBombLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigthowingbomb5l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> ImagePigThrowBombLefts = createListImage(ImagePigThrowBombLeft_1, ImagePigThrowBombLeft_2, ImagePigThrowBombLeft_3,
            ImagePigThrowBombLeft_4, ImagePigThrowBombLeft_5);

    public final static Bitmap ImagePigBomRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun2l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun3l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun4l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun5l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun6l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> PigBomRunLefts = createListImage(ImagePigBomRunLeft_1, ImagePigBomRunLeft_2, ImagePigBomRunLeft_3,
            ImagePigBomRunLeft_4, ImagePigBomRunLeft_5, ImagePigBomRunLeft_6);

    public final static Bitmap ImagePigBomRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun3r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun4r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun5r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun6r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> PigBomRunRights = createListImage(ImagePigBomRunRight_1, ImagePigBomRunRight_2, ImagePigBomRunRight_3,
            ImagePigBomRunRight_4 , ImagePigBomRunRight_5, ImagePigBomRunRight_6);

    public final static Bitmap ImagePigBomDoneRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone1r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomDoneRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomDoneRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomDoneRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomDoneRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomDoneRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static ArrayList<Bitmap> PigBomDoneRights = createListImage(ImagePigBomDoneRight_1, ImagePigBomDoneRight_2, ImagePigBomDoneRight_3,
            ImagePigBomDoneRight_4 , ImagePigBomDoneRight_5, ImagePigBomDoneRight_6);

    public final static Bitmap ImagePigBomDoneLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomDoneLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomDoneLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomDoneLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomDoneLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomDoneLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomdone2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> PigBomDoneLefts = createListImage(ImagePigBomDoneLeft_1, ImagePigBomDoneLeft_2, ImagePigBomDoneLeft_3,
            ImagePigBomDoneLeft_4 , ImagePigBomDoneLeft_5, ImagePigBomDoneLeft_6);

    public final static Bitmap ImagePigBomFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1l), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);
    public final static Bitmap ImagePigBomFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1r), DEFAULT_WIDTH_SIZE_PIG_BOMB, DEFAULT_HEIGHT_SIZE_PIG_BOMB);

    public final static Bitmap ImageFanOn1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller1), DEFAULT_WIDTH_FAN_SIZE, DEFAULT_HEIGHT_FAN_SIZE );
    public final static Bitmap ImageFanOn2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller2), DEFAULT_WIDTH_FAN_SIZE, DEFAULT_HEIGHT_FAN_SIZE);
    public final static Bitmap ImageFanOn3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller3), DEFAULT_WIDTH_FAN_SIZE, DEFAULT_HEIGHT_FAN_SIZE);
    public final static Bitmap ImageFanOn4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller4), DEFAULT_WIDTH_FAN_SIZE, DEFAULT_HEIGHT_FAN_SIZE );

    public final static ArrayList<Bitmap> ImageFanOn = createListImage(ImageFanOn1, ImageFanOn2, ImageFanOn3, ImageFanOn4);

    public final static Bitmap ImageParticleRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle1), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle2), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle3), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle4), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle5), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle6), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);

    public final static ArrayList<Bitmap> ImageParticleRights = createListImage(ImageParticleRight_1, ImageParticleRight_2, ImageParticleRight_3,
            ImageParticleRight_4, ImageParticleRight_5, ImageParticleRight_6);

    public final static Bitmap ImageParticleLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle1), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle2), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle3), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle4), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle5), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);
    public final static Bitmap ImageParticleLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.runparticle6), DEFAULT_WIDTH_SIZE_PARTICLE, DEFAULT_HEIGHT_SIZE_PARTICLE);

    public final static ArrayList<Bitmap> ImageParticleLefts = createListImage(ImageParticleLeft_1, ImageParticleLeft_2, ImageParticleLeft_3,
            ImageParticleLeft_4, ImageParticleLeft_5, ImageParticleLeft_6);

    public final static Bitmap ImageBombLive_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLive_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive2), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLive_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive3), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLive_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive4), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLive_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLive_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive2), Default_Width_Size_Bomb, Default_Height_Size_Bomb);

    public final static ArrayList<Bitmap> ImageBombLives = createListImage(ImageBombLive_1, ImageBombLive_2, ImageBombLive_3,
            ImageBombLive_4, ImageBombLive_5, ImageBombLive_6);

    public final static Bitmap ImageBombLiveLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1l), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive2l), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive3l), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive4l), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1l), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive2l), Default_Width_Size_Bomb, Default_Height_Size_Bomb);

    public final static ArrayList<Bitmap> ImageBombLiveLefts = createListImage(ImageBombLive_1, ImageBombLive_2, ImageBombLive_3,
            ImageBombLive_4, ImageBombLive_5, ImageBombLive_6);

    public final static Bitmap ImageBombLiveRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1r), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive2r), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive3r), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive4r), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive1r), Default_Width_Size_Bomb, Default_Height_Size_Bomb);
    public final static Bitmap ImageBombLiveRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bomlive2r), Default_Width_Size_Bomb, Default_Height_Size_Bomb);

    public final static ArrayList<Bitmap> ImageBombLiveRights = createListImage(ImageBombLiveRight_1, ImageBombLiveRight_2, ImageBombLiveRight_3,
            ImageBombLiveRight_4, ImageBombLiveRight_5, ImageBombLiveRight_6);

    public final static Bitmap ImageBombExplosive_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bom1l), Default_Width_Size_Bomb_Explosive, Default_Height_Size_Bomb_Explosive);
    public final static Bitmap ImageBombExplosive_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bom2l), Default_Width_Size_Bomb_Explosive, Default_Height_Size_Bomb_Explosive);
    public final static Bitmap ImageBombExplosive_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bom3l), Default_Width_Size_Bomb_Explosive, Default_Height_Size_Bomb_Explosive);
    public final static Bitmap ImageBombExplosive_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bom4l), Default_Width_Size_Bomb_Explosive, Default_Height_Size_Bomb_Explosive);
    public final static Bitmap ImageBombExplosive_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bom5l), Default_Width_Size_Bomb_Explosive, Default_Height_Size_Bomb_Explosive);
    public final static Bitmap ImageBombExplosive_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.bom6l), Default_Width_Size_Bomb_Explosive, Default_Height_Size_Bomb_Explosive);

    public final static ArrayList<Bitmap> ImageBombExplosives = createListImage(ImageBombExplosive_1, ImageBombExplosive_2, ImageBombExplosive_3,
            ImageBombExplosive_4, ImageBombExplosive_5, ImageBombExplosive_6);

    public Sprite() {
    }

    public static Bitmap createImage(Bitmap scr, int width, int height) {
        return Bitmap.createScaledBitmap(scr, width, height, false);
    }

    public static ArrayList<Bitmap> createListImage(Bitmap image1, Bitmap image2, Bitmap image3,
                                                    Bitmap image4) {
        ArrayList<Bitmap> arrImage = new ArrayList<>(4);
        arrImage.add(image1);
        arrImage.add(image2);
        arrImage.add(image3);
        arrImage.add(image4);
        return arrImage;
    }

    public static ArrayList<Bitmap> createListImage(Bitmap image1, Bitmap image2, Bitmap image3,
                                                    Bitmap image4, Bitmap image5) {
        ArrayList<Bitmap> arrImage = new ArrayList<>(5);
        arrImage.add(image1);
        arrImage.add(image2);
        arrImage.add(image3);
        arrImage.add(image4);
        return arrImage;
    }

    public static ArrayList<Bitmap> createListImage(Bitmap image1, Bitmap image2, Bitmap image3,
                                                    Bitmap image4, Bitmap image5, Bitmap image6) {
        ArrayList<Bitmap> arrImage = new ArrayList<>(6);
        arrImage.add(image1);
        arrImage.add(image2);
        arrImage.add(image3);
        arrImage.add(image4);
        arrImage.add(image5);
        arrImage.add(image6);
        return arrImage;
    }

    public static ArrayList<Bitmap> createListImage(Bitmap image1, Bitmap image2, Bitmap image3,
                                                    Bitmap image4, Bitmap image5, Bitmap image6,
                                                    Bitmap image7, Bitmap image8) {
        ArrayList<Bitmap> arrImage = new ArrayList<>(8);
        arrImage.add(image1);
        arrImage.add(image2);
        arrImage.add(image3);
        arrImage.add(image4);
        arrImage.add(image5);
        arrImage.add(image6);
        arrImage.add(image7);
        arrImage.add(image8);
        return arrImage;
    }

    public static ArrayList<Bitmap> createListImage(Bitmap image1, Bitmap image2, Bitmap image3,
                                                    Bitmap image4, Bitmap image5, Bitmap image6,
                                                    Bitmap image7, Bitmap image8, Bitmap image9,
                                                    Bitmap image10, Bitmap image11, Bitmap image12) {
        ArrayList<Bitmap> arrImage = new ArrayList<>(12);
        arrImage.add(image1);
        arrImage.add(image2);
        arrImage.add(image3);
        arrImage.add(image4);
        arrImage.add(image5);
        arrImage.add(image6);
        arrImage.add(image7);
        arrImage.add(image8);
        arrImage.add(image9);
        arrImage.add(image10);
        arrImage.add(image11);
        arrImage.add(image12);
        return arrImage;
    }


    public static Bitmap movingSprite (ArrayList<Bitmap> ArrImage, int animate, int time) {
        int size = ArrImage.size();
        int diff = time / size;
        int calc = animate % time;
        for (int i = 1; i <= size; i++) {
            if (calc < diff * i) {
                return ArrImage.get(i - 1);
            }
        }
        return ArrImage.get(0);
    }

}
