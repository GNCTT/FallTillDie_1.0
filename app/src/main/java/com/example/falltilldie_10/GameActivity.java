package com.example.falltilldie_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;
        if (MainActivity.checkOnline) {
            gameView = new GameView(this, point.x, point.y, heightPixels, widthPixels, true);
        } else {
            gameView = new GameView(this, point.x, point.y, heightPixels, widthPixels);
        }
        setContentView(gameView);
    }


    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}