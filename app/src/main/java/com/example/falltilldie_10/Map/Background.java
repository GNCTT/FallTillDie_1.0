package com.example.falltilldie_10.Map;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.falltilldie_10.R;

public class Background {

    private int x = 0, y = 0;
    Bitmap backgroundImage;
    Bitmap background;
    Bitmap background1;
    Bitmap background2;

    public Background(int screenX, int screenY, Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background5);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
        background1 = BitmapFactory.decodeResource(res, R.drawable.background4);
        background1 = Bitmap.createScaledBitmap(background1, screenX, screenY, false);
        background2 = BitmapFactory.decodeResource(res, R.drawable.background3);
        background2 = Bitmap.createScaledBitmap(background2, screenX, screenY, false);
        backgroundImage = background;
    }

    public void changeBackground(int screenX, int screenY, Resources res, int typeBackground) {
        switch (typeBackground){
            case 0:
                backgroundImage = background;
                break;
            case 1:
                backgroundImage = background1;
                break;
            default:
                backgroundImage = background2;
                break;
        }
    }

    public void draw() {
        canvas.drawBitmap(backgroundImage, x, y, paint);
    }

}