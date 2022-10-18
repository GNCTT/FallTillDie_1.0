package com.example.falltilldie_10.Sprite;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.R;

import java.util.ArrayList;

public class Sprite {
    public final static Bitmap ImagePigDefault = BitmapFactory.decodeResource(GameView.res, R.drawable.idll);
    private final static int Default_Width_Size = ImagePigDefault.getWidth();
    private final static int Default_Height_Size = ImagePigDefault.getHeight();
    private final static int Default_Scale_X = 4;
    private final static int Default_Scale_Y = 3;

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
