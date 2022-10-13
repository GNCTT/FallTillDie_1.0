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
    Bitmap background;

    public Background(int screenX, int screenY, Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background2);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }

    public void draw() {
        canvas.drawBitmap(background, x, y, paint);
    }

}