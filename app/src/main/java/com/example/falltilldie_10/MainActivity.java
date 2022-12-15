package com.example.falltilldie_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.falltilldie_10.HightCore.HightCore;
import com.example.falltilldie_10.Setting.Setting;

public class MainActivity extends AppCompatActivity {


    private SoundPool soundPool;
    private int sound;
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            AudioAttributes audioAttributes = new AudioAttributes.Builder()
//                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
//                    .setUsage(AudioAttributes.USAGE_GAME)
//                    .build();
//            soundPool = new SoundPool.Builder()
//                    .setMaxStreams(2)
//                    .setAudioAttributes(audioAttributes)
//                    .build();
//        } else
//            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
//        sound = soundPool.load(this, R.raw.music1, 1);
    }

    public void clickPlay(View view) {
        Intent svc=new Intent(this, BackgroundSoundService.class);
        startService(svc);
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);



    }

//    public void clickPlay2P(View view) {
//        Intent intent = new Intent(this, BackgroundSoundService.class);
//        startService(intent);
//    }

    public void clickPlay2P(View view) {
        Log.d("click button","play 2P");

    }

    public void clickExit(View view) {
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