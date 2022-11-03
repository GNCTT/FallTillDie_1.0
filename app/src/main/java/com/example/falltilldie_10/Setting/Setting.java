package com.example.falltilldie_10.Setting;

import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.falltilldie_10.GameView;
import com.example.falltilldie_10.R;

public class Setting extends AppCompatActivity {

    public GameView gameView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;
        gameView = new GameView(this, point.x, point.y, heightPixels, widthPixels);
        setContentView(gameView);
    }
}
