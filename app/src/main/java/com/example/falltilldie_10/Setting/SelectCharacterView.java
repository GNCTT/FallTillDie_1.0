package com.example.falltilldie_10.Setting;

import static com.example.falltilldie_10.GameView.canvas;
import static com.example.falltilldie_10.GameView.paint;

import android.content.Context;
import android.graphics.Rect;
import android.view.SurfaceView;

import com.example.falltilldie_10.Sprite.Sprite;

public class SelectCharacterView extends SurfaceView implements Runnable{
    public boolean isChosing;
    private Thread thread;
    public SelectCharacterView(Context context) {
        super(context);
        isChosing = true;
    }

    @Override
    public void run() {
        while(isChosing) {
            draw();
        }
    }

    public void draw() {

        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            canvas.drawRect(new Rect(0, 0, 100, 100), paint);
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
}
