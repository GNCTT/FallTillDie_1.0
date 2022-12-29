package com.example.falltilldie_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.falltilldie_10.HightCore.HightCore;
import com.example.falltilldie_10.Setting.CharacterSetting;
import com.example.falltilldie_10.Setting.Setting;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static boolean online;
    public static List<CharacterSetting> list = new ArrayList<>();
    public static int currentIndexImage = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list.add(new CharacterSetting("ninja2", R.drawable.pignormalidle1l));
        list.add(new CharacterSetting("ninja3", R.drawable.pigidle1l));
        list.add(new CharacterSetting("ninja4", R.drawable.virtualidle1l));
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void clickPlay(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

//    public void clickPlay2P(View view) {
//        Intent intent = new Intent(this, BackgroundSoundService.class);
//        startService(intent);
//    }

    public void clickPlay2P(View view) {
        Log.d("click button","play 2P");
        online = true;

    }

    public void clickExit(View view) {
        Intent musicBg=new Intent(this, MusicService.class);
        stopService(musicBg);
        finish();
        System.exit(0);
    }

    public void clickContinue(View view) {
        Log.d("click button", "continue");
    }

    public void clickHightCore(View view) {
        Intent intent = new Intent(this, HightCore.class);
        startActivity(intent);
        Log.d("clcik hightcore","click");
    }

    public void clickSetting(View view) {
        Intent intent = new Intent(this, Setting.class);
        startActivity(intent);
    }

}