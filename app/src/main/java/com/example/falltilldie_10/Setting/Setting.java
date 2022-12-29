package com.example.falltilldie_10.Setting;

import static com.example.falltilldie_10.MainActivity.currentIndexImage;
import static com.example.falltilldie_10.MainActivity.list;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.falltilldie_10.MusicService;
import com.example.falltilldie_10.R;

public class Setting extends AppCompatActivity {
    SwitchCompat switchCompatSound;
    SwitchCompat switchCompatMusic;
    Button nextCharacter, prevCharacter, nextBackground, prevBackground;
    ImageView img_character;
    ImageView img_background;
    Button aboutUS;
    SeekBar seekBarSpeed;
    private Intent musicBG;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        musicBG = new Intent(this, MusicService.class);

        img_character = findViewById(R.id.imageView_character);
        currentIndexImage = 1;
        img_character.setImageResource(R.drawable.pigidle1l);

        // chọn nền game
        img_background = findViewById(R.id.imageView_background);
        currentIndexImage = 1;
        img_background.setImageResource(R.drawable.background6);


        Button btn_back = findViewById(R.id.backMain2);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Setting.this, MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        //Tach thanh ham rieng


//        switchCompatSound = (SwitchCompat) findViewById(R.id.switchCompatSound);
//        switchCompatSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b == true) {
//                    Log.d("SwitchSound is", "on");
//                } else {
//                    Log.d("SwitchSound is", "off");
//                }
//            }
//        });

        switchCompatMusic = (SwitchCompat) findViewById(R.id.switchCompatMusic);

        SharedPreferences sharedPreferences=getSharedPreferences("save",MODE_PRIVATE);
        switchCompatMusic.setChecked(sharedPreferences.getBoolean("value",false));

        switchCompatMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchCompatMusic.isChecked())
                {
                    // When switch checked
                    SharedPreferences.Editor editor=getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",true);
                    editor.apply();
                    switchCompatMusic.setChecked(true);
                    startService(musicBG);
                }
                else
                {
                    // When switch unchecked
                    SharedPreferences.Editor editor=getSharedPreferences("save",MODE_PRIVATE).edit();
                    editor.putBoolean("value",false);
                    editor.apply();
                    switchCompatMusic.setChecked(false);
                    stopService(musicBG);
                }
            }
        });

        prevCharacter = findViewById(R.id.prevCharacter);
        prevCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "prev_btn");
                if(MainActivity.currentIndexImage == 0) {
                    MainActivity.currentIndexImage = list.size()-1;
                    Log.d("CurrentIndex", "0");
                } else {
                    MainActivity.currentIndexImage -= 1;
                }
                img_character.setImageResource(list.get(currentIndexImage).linkImg);
            }
        });

        nextCharacter = findViewById(R.id.nextCharacter);

        nextCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "next_btn");
                if(MainActivity.currentIndexImage == list.size() - 1) {
                    MainActivity.currentIndexImage = 0;
                    Log.d("CurrentIndex", "0");
                } else {
                    MainActivity.currentIndexImage += 1;
                }
                img_character.setImageResource(list.get(currentIndexImage).linkImg);
            }
        });

        // Chọn nền game mới có
        prevBackground = findViewById(R.id.prevBackground);
        prevBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "prev_btn");
                if(MainActivity.currentIndexImage == 0) {
                    MainActivity.currentIndexImage = list.size()-1;
                    Log.d("CurrentIndex", "0");
                } else {
                    MainActivity.currentIndexImage -= 1;
                }
                img_background.setImageResource(list.get(currentIndexImage).linkImg);
            }
        });

        nextBackground = findViewById(R.id.nextBackground);

        nextBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "next_btn");
                if(MainActivity.currentIndexImage == list.size() - 1) {
                    MainActivity.currentIndexImage = 0;
                    Log.d("CurrentIndex", "0");
                } else {
                    MainActivity.currentIndexImage += 1;
                }
                img_background.setImageResource(list.get(currentIndexImage).linkImg);
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
