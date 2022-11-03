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
    public final static Bitmap ImageRoughDefault = BitmapFactory.decodeResource(GameView.res, R.drawable.run1);


    public final static Bitmap ImageFan = BitmapFactory.decodeResource(GameView.res, R.drawable.propeller1);
    private final static int DEFAULT_WIDTH_FAN_SIZE = ImageFan.getWidth();
    private final static int DEFAULT_HEIGHT_FAN_SIZE = ImageFan.getHeight();

    private final static int Default_Width_Size = ImagePigDefault.getWidth();
    private final static int Default_Height_Size = ImagePigDefault.getHeight();

    private final static int DEFAULT_WIDTH_SIZE_ROUGH = ImageRoughDefault.getWidth();
    private final static int DEFAULT_HEIGHT_SIZE_ROUGH = ImageRoughDefault.getHeight();

    private final static int Default_Scale_X = 32;
    private final static int Default_Scale_Y = 21;

    public final static Bitmap ImagePigIdlLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.idll), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigIdlRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.idlr), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static Bitmap ImagePigRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run3l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run4l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run5l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run6l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> PigRunLefts = createListImage(ImagePigRunLeft_1, ImagePigRunLeft_2, ImagePigRunLeft_3,
                                                                        ImagePigRunLeft_4, ImagePigRunLeft_5, ImagePigRunLeft_6);

    public final static Bitmap ImagePigRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run1r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run2r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run3r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run4r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run5r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run6r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> PigRunRights = createListImage(ImagePigRunRight_1, ImagePigRunRight_2, ImagePigRunRight_3,
            ImagePigRunRight_4, ImagePigRunRight_5, ImagePigRunRight_6);

    public final static Bitmap ImagePigFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.falll), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.fallr), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static Bitmap ImageVirtualIdlLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidll), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualIdlRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualidlr), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static Bitmap ImageVirtualRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun3l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun4l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun5l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun6l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> VirtualRunLefts = createListImage(ImageVirtualRunLeft_1, ImageVirtualRunLeft_2, ImageVirtualRunLeft_3,
            ImageVirtualRunLeft_4, ImageVirtualRunLeft_5, ImageVirtualRunLeft_6);

    public final static Bitmap ImageVirtualRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun1r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun2r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun3r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun4r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun5r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualrun6r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> VirtualRunRights = createListImage(ImageVirtualRunRight_1, ImageVirtualRunRight_2, ImageVirtualRunRight_3,
            ImageVirtualRunRight_4, ImageVirtualRunRight_5, ImageVirtualRunRight_6);

    public final static Bitmap ImageVirtualFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualfalllr), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageVirtualFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.virtualfallr), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static Bitmap ImagePigBomIdlLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomIdlRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomidle1r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static Bitmap ImagePigBomRunLeft_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunLeft_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunLeft_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun3l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunLeft_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun4l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunLeft_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun5l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunLeft_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun6l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> PigBomRunLefts = createListImage(ImagePigBomRunLeft_1, ImagePigBomRunLeft_2, ImagePigBomRunLeft_3,
            ImagePigBomRunLeft_4, ImagePigBomRunLeft_5, ImagePigBomRunLeft_6);

    public final static Bitmap ImagePigBomRunRight_1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunRight_2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun2r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunRight_3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun3r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunRight_4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun4r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunRight_5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun5r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomRunRight_6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun6r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> PigBomRunRights = createListImage(ImagePigBomRunRight_1, ImagePigBomRunRight_2, ImagePigBomRunRight_3,
            ImagePigBomRunRight_4 , ImagePigBomRunRight_5, ImagePigBomRunRight_6);

    public final static Bitmap ImagePigBomFallLeft = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImagePigBomFallRight = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.pigbomrun1r), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static Bitmap ImageFanOn1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller1), DEFAULT_WIDTH_FAN_SIZE * 2, DEFAULT_HEIGHT_FAN_SIZE * 3 / 2);
    public final static Bitmap ImageFanOn2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller2), DEFAULT_WIDTH_FAN_SIZE * 2, DEFAULT_HEIGHT_FAN_SIZE * 3 / 2);
    public final static Bitmap ImageFanOn3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller3), DEFAULT_WIDTH_FAN_SIZE * 2, DEFAULT_HEIGHT_FAN_SIZE * 3 / 2);
    public final static Bitmap ImageFanOn4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.propeller4), DEFAULT_WIDTH_FAN_SIZE * 2, DEFAULT_HEIGHT_FAN_SIZE * 3 / 2);

    public final static Bitmap ImageRoughWalkL1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.walk1l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkL2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.walk2l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkL3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.walk3l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkL4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.walk4l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkL5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.walk5l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkL6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.walk6l), Default_Width_Size * Default_Scale_X / Default_Scale_Y, Default_Height_Size * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> RoughWalkLefts = createListImage(ImageRoughWalkL1, ImageRoughWalkL2, ImageRoughWalkL3,
                                                                           ImageRoughWalkL4, ImageRoughWalkL5, ImageRoughWalkL6);

    public final static Bitmap ImageRoughWalkR1 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run1), DEFAULT_WIDTH_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y, DEFAULT_HEIGHT_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkR2 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run2), DEFAULT_WIDTH_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y, DEFAULT_HEIGHT_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkR3 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run3), DEFAULT_WIDTH_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y, DEFAULT_HEIGHT_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkR4 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run4), DEFAULT_WIDTH_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y, DEFAULT_HEIGHT_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkR5 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run5), DEFAULT_WIDTH_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y, DEFAULT_HEIGHT_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y);
    public final static Bitmap ImageRoughWalkR6 = createImage(BitmapFactory.decodeResource(GameView.res, R.drawable.run6), DEFAULT_WIDTH_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y, DEFAULT_HEIGHT_SIZE_ROUGH * Default_Scale_X / Default_Scale_Y);

    public final static ArrayList<Bitmap> RoughWalkRights = createListImage(ImageRoughWalkR1, ImageRoughWalkR2, ImageRoughWalkR3,
            ImageRoughWalkR4, ImageRoughWalkR5, ImageRoughWalkR6);

    public final static ArrayList<Bitmap> ImageFanOn = createListImage(ImageFanOn1, ImageFanOn2, ImageFanOn3, ImageFanOn4, ImageFanOn1, ImageFanOn2);
    public Sprite() {
    }

    public static Bitmap createImage(Bitmap scr, int width, int height) {
        return Bitmap.createScaledBitmap(scr, width, height, false);
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
