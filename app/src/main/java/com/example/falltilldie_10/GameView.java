package com.example.falltilldie_10;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.falltilldie_10.Map.MapView;
import com.example.falltilldie_10.OnlineGame.Client;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private final static String IP_SERVER = "6.tcp.ngrok.io";
    private final static int port = 15544;
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

    public Client client;
    public boolean online;

    private MapView mapView;

    public GameView(Context context, int screenX, int screenY, int heightScreen, int widthScreen){
        super(context);

        screenRatioX_1 =(float) (widthScreen * 1.00 / (9 * 66));
        screenRatioX_2 =  9 * 66;
        screenRatioY_1 = (float) (heightScreen * 1.00 / (18 * 66));
        screenRatioY_2 = 19 * 66;
        Log.i("tagggx", widthScreen + " " + heightScreen + "  " + screenRatioX_1 + " " + screenRatioY_1);
        this.screenX = screenX;
        this.screenY = screenY;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        canvas = new Canvas();
        paint = new Paint();
        res = getResources();
        mapView = new MapView(screenX, screenY);
        online = false;
    }

    public GameView(Context context, int screenX, int screenY, int heightScreen, int widthScreen, boolean online){
        super(context);

        screenRatioX_1 =(float) (widthScreen * 1.00 / (9 * 66));
        screenRatioX_2 =  9 * 66;
        screenRatioY_1 = (float) (heightScreen * 1.00 / (18 * 66));
        screenRatioY_2 = 19 * 66;
        Log.i("tagggx", widthScreen + " " + heightScreen + "  " + screenRatioX_1 + " " + screenRatioY_1);
        this.screenX = screenX;
        this.screenY = screenY;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        canvas = new Canvas();
        paint = new Paint();
        res = getResources();
        mapView = new MapView(screenX, screenY);
        this.online = online;
    }

    @Override
    public void run() {
        while (isPlaying) {
//            client.read_data();
            if (online) {
                updateOnline();
            } else {
                update();
            }
            draw();
            sleep();
//            if (mapView.isOVer()) {
//                Intent intent = new Intent(this.getContext(), GameOverActivity.class);
//                pause();
//            }
        }


    }

    private void update() {
        mapView.update();
    }

    private void updateOnline() {
        Log.i("updateOnline", "msgUpdate");
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
