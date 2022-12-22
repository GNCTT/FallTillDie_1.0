package com.example.falltilldie_10.Setting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.example.falltilldie_10.HightCore.HightCore;
import com.example.falltilldie_10.MusicService;
import com.example.falltilldie_10.R;

import java.util.ArrayList;
import java.util.List;

public class Setting extends AppCompatActivity {
    SwitchCompat switchCompatSound;
    SwitchCompat switchCompatMusic;
    Button nextCharacter, prevCharacter;
    ImageView img_character;
    Button aboutUS;
    SeekBar seekBarSpeed;
    private Intent musicBG;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        musicBG = new Intent(this, MusicService.class);

        //Tach thanh ham rieng
        List<Integer> list = new ArrayList<>();
        //truyen vao list gia tri xac dinh cho moi character
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        switchCompatSound = (SwitchCompat) findViewById(R.id.switchCompatSound);
        switchCompatSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true) {
                    Log.d("SwitchSound is", "on");
                } else {
                    Log.d("SwitchSound is", "off");
                }
            }

        });



        switchCompatMusic = (SwitchCompat) findViewById(R.id.switchCompatMusic);
        switchCompatMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true) {
                    Log.d("SwitchMusic is", "on");
                    startService(musicBG);
                } else {
                    Log.d("SwitchMusic is", "off");
                    stopService(musicBG);
                }
            }
        });

        int currentIndex = 0;

        prevCharacter = (Button) findViewById(R.id.prevCharacter);
        prevCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "prev_btn");
//                if(currentIndex == 0) {
//                    currentIndex = list.size();
//                    Log.d("CurrentIndex", "0");
//                } else {
//                    currentIndex -= 1;
//                }
//                String msg = currentIndex.toString;
//                Log.d("currentCharacter is: ", msg);
            }
        });

        nextCharacter = (Button) findViewById(R.id.nextCharacter);

        nextCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "next_btn");
//                if(currentIndex == list.size()) {
//                    currentIndex = 0;
//                    Log.d("CurrentIndex", "0");
//                } else {
//                    currentIndex += 1;
//                }
//                String msg = currentIndex.toString;
//                Log.d("currentCharacter is: ", msg);
            }
        });

        aboutUS = (Button) findViewById(R.id.btnAboutUs);
        aboutUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Click aboutUs button", "clicked");
            }
        });

        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //tra ve gia tri cua speed
                Log.d("seekBar ", "value" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    //ham tao danh sach cac character co the duoc chon
//    private List<Integer> getList() {
//        List<Integer> list = new ArrayList<>();
//        //truyen vao list gia tri xac dinh cho moi character
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        return list;
//    }

    //Dat gia tri cua imageView tuong ung
    //Se lam them hieu ung dong cho cac imageview
    public void setCharacter(int a) {
        img_character = (ImageView) findViewById(R.id.imageView_character);
        img_character.setImageResource(a);
    }
}
