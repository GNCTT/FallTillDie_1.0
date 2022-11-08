package com.example.falltilldie_10;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.falltilldie_10.Character.Player;
import com.example.falltilldie_10.Map.Background;
import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.Sprite.Sprite;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    public static Canvas canvas;
    public static Paint paint;
    public static boolean isPlaying;
    public static int screenX;
    public static int screenY;
    private static int widthScreen;
    private static int heightScreen;
    public static float screenRatioX_1, screenRatioY_1;
    public static float screenRatioX_2, screenRatioY_2;

    public static Resources res;

    public static boolean left = false;
    public static boolean right = false;

    private MapView mapView;

    public GameView(Context context, int screenX, int screenY, int heightScreen, int widthScreen) {
        super(context);

        screenRatioX_1 = (float) (widthScreen * 1.00 / (20));
        screenRatioX_2 =  9 * 66;
        screenRatioY_1 = (float) (heightScreen * 1.00/ (50));
        screenRatioY_2 = 18 * 66;
        Log.i("taggg", widthScreen + " " + heightScreen);
        this.screenX = screenX;
        this.screenY = screenY;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        canvas = new Canvas();
        paint = new Paint();
        res = getResources();
        mapView = new MapView(screenX, screenY);
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    private void update() {
        mapView.update();
    }

    private void draw() {
        //draw
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            mapView.draw();
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep() {
        try {
            thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {

        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public static int getWidthScreen() {
        return widthScreen;
    }

    public static int getHeightScreen() {
        return heightScreen;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    left = true;
                    right = false;
                }
                if (event.getX() > screenX / 2) {
                    right = true;
                    left = false;
                }

                break;
            case MotionEvent.ACTION_UP:
                left = false;
                right = false;
                break;
        }
        return true;
    }

}
