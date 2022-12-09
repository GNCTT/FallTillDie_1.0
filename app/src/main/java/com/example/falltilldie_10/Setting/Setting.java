package com.example.falltilldie_10.Setting;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

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
    int currentIndex = 3;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        img_character = findViewById(R.id.imageView_character);
        img_character.setImageResource(R.drawable.avatar2);

        //Tach thanh ham rieng
        List<CharacterSetting> list = new ArrayList<>();
        list.add(new CharacterSetting("ninja1", R.drawable.avatar));
        list.add(new CharacterSetting("ninja2", R.drawable.avatar2));
        list.add(new CharacterSetting("ninja3", R.drawable.run1));
        list.add(new CharacterSetting("ninja4", R.drawable.run2l));

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
                } else {
                    Log.d("SwitchMusic is", "off");
                }
            }
        });

        prevCharacter = findViewById(R.id.prevCharacter);
        prevCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "prev_btn");
                if(currentIndex == 0) {
                    currentIndex = list.size()-1;
                    Log.d("CurrentIndex", "0");
                } else {
                    currentIndex -= 1;
                }
                img_character.setImageResource(list.get(currentIndex).linkImg);
            }
        });

        nextCharacter = findViewById(R.id.nextCharacter);

        nextCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "next_btn");
                if(currentIndex == list.size() - 1) {
                    currentIndex = 0;
                    Log.d("CurrentIndex", "0");
                } else {
                    currentIndex += 1;
                }
                img_character.setImageResource(list.get(currentIndex).linkImg);
            }
        });

//        aboutUS = (Button) findViewById(R.id.btnAboutUs);
//        aboutUS.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("Click aboutUs button", "clicked");
//            }
//        });

//        seekBarSpeed = (SeekBar) findViewById(R.id.seekBarSpeed);
//        seekBarSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                //tra ve gia tri cua speed
//                Log.d("seekBar ", "value" + i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });
    }
}
