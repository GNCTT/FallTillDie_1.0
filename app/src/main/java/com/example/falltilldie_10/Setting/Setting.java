package com.example.falltilldie_10.Setting;

import android.annotation.SuppressLint;
import android.content.Intent;
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

import com.example.falltilldie_10.MainActivity;
import com.example.falltilldie_10.R;

import java.util.ArrayList;
import java.util.List;

public class Setting extends AppCompatActivity {
    SwitchCompat switchCompatSound;
    SwitchCompat switchCompatMusic;
    Button nextCharacter, prevCharacter;
    Button nextBg, prevBg;
    ImageView img_character;
    Button aboutUS;
    SeekBar seekBarSpeed;
    
    boolean checkSwitchCompatSound = false;
    boolean checkswitchCompatMusic = false;

    int currentIndex = 0;
    int indexBackground = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        img_character = findViewById(R.id.imageView_character);
        img_character.setImageResource(R.drawable.virtualidll);

        Button btn_back = findViewById(R.id.backMain2);


//        Truyền các thông tin cài đặt về main
        //Giá tri cua hinh anh la chi so cua hinh + 1;
        //Luu danh sách avatar trong folder Drawable, tên mặc định: character + index && background + index
        //Bật, tắt nhạc và âm thanh -> giá trị true, false
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, MainActivity.class);
                intent.putExtra("turnOnSound", checkSwitchCompatSound);
                intent.putExtra("turnOnMusic", checkswitchCompatMusic);
                intent.putExtra("character", currentIndex + 1);
                intent.putExtra("backgound", indexBackground + 1);
                startActivity(intent);
            }
        });

        List<CharacterSetting> list = new ArrayList<>();
        list.add(new CharacterSetting("ninja2", R.drawable.character2));
        list.add(new CharacterSetting("ninja3", R.drawable.character3));
        list.add(new CharacterSetting("ninja4", R.drawable.character1));
        list.add(new CharacterSetting("ninja1", R.drawable.character4));


        List<BackgroundSetting> listBackground = new ArrayList<>();
        listBackground.add(new BackgroundSetting("back1", R.drawable.background1));
        listBackground.add(new BackgroundSetting("back2", R.drawable.background2));
        listBackground.add(new BackgroundSetting("back3", R.drawable.background3));
        listBackground.add(new BackgroundSetting("back4", R.drawable.background4));
        listBackground.add(new BackgroundSetting("back5", R.drawable.background5));
        listBackground.add(new BackgroundSetting("back6", R.drawable.background6));


        switchCompatSound = (SwitchCompat) findViewById(R.id.switchCompatSound);
        switchCompatSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true) {
                    Log.d("SwitchSound is", "on");
                } else {
                    Log.d("SwitchSound is", "off");
                }
                checkSwitchCompatSound = b;
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
                checkswitchCompatMusic = b;
            }
        });

        prevCharacter = findViewById(R.id.prevCharacter);
        prevCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                if(currentIndex == list.size() - 1) {
                    currentIndex = 0;
                } else {
                    currentIndex += 1;
                }
                img_character.setImageResource(list.get(currentIndex).linkImg);
            }
        });


        ImageView imgViewBg = findViewById(R.id.imageView_Background);
        prevBg = findViewById(R.id.prevBackground);
        nextBg = findViewById(R.id.nextBackground);

        prevBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexBackground == 0) {
                    indexBackground = listBackground.size()-1;
                    Log.d("CurrentIndex", "0");
                } else {
                    indexBackground -= 1;
                }
                imgViewBg.setImageResource(listBackground.get(indexBackground).linkImg);
            }
        });
        nextBg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexBackground == listBackground.size() - 1) {
                    indexBackground = 0;
                } else {
                    indexBackground += 1;
                }
                imgViewBg.setImageResource(listBackground.get(indexBackground).linkImg);
            }
        });
    }
}
