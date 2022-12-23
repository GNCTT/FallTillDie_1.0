package com.example.falltilldie_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    String player_Name = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;


        if (MainActivity.online) {
            gameView = new GameView(this, point.x, point.y, heightPixels, widthPixels, true);
        } else {
            gameView = new GameView(this, point.x, point.y, heightPixels, widthPixels);
        }
        // Write a message to the database
        Log.i("url", " ");
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        Log.i("url", " " + FirebaseDatabase.getInstance());
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

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