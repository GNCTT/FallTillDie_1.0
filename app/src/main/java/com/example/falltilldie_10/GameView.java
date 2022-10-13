package com.example.falltilldie_10;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import com.example.falltilldie_10.Character.Player;
import com.example.falltilldie_10.Map.Background;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    public static Canvas canvas;
    public static Paint paint;
    private Background background;
    public static boolean isPlaying;
    private int screenX;
    private int screenY;

    private Player player;

    public GameView(Context context, int screenX, int screenY) {
        super(context);
        this.screenX = screenX;
        this.screenY = screenY;
        canvas = new Canvas();
        paint = new Paint();

        background = new Background(screenX, screenY, getResources());
        player = new Player(0, 0);
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
        player.update();
    }

    private void draw() {
        //draw
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            background.draw();
            player.draw();
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
}
