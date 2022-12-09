package com.example.falltilldie_10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.falltilldie_10.HightCore.HightCore;
import com.example.falltilldie_10.SQL.DatabaseHelper;
import com.example.falltilldie_10.SQL.PlayerHightCore;
import com.example.falltilldie_10.Setting.Setting;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.test_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test", "click test button");
                openDialog(Gravity.CENTER);
            }
        });
    }

    private void openDialog(int gravity) {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAtribute = window.getAttributes();
        windowAtribute.gravity = gravity;
        window.setAttributes(windowAtribute);
        dialog.setCancelable(false);
        dialog.show();

        Button btn_exit = dialog.findViewById(R.id.btn_exit);
        Button btn_continue = dialog.findViewById(R.id.btn_continue);
        Button btn_replay = dialog.findViewById(R.id.btn_replay);
        Button btn_saveScore = dialog.findViewById(R.id.btn_savePoint);
        EditText etPlayerName = dialog.findViewById(R.id.etPlayerName);

        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Bấm cái này trở về màn hình chính
                Log.d("click", "exit");
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Cho trở lại trạng thái của game
                Log.d("click", "continue");
            }
        });


        btn_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clcik", "replay");
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        //Luu diem
        btn_saveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "save score");
                String namePlayer = "";
                String nameInput = String.valueOf(etPlayerName.getText());
                if (nameInput.length() == 0) {
                    Log.d("edit text","null");
                    namePlayer = "Unknow";
                } else {
                    Log.d("edit text",nameInput);
                    namePlayer = nameInput;
                }
                Log.d("name check" , namePlayer);

                PlayerHightCore playerHightCore;
                //Dat tat diem bang 1000
                try {
                    playerHightCore = new PlayerHightCore(namePlayer, 1000);
                    Toast.makeText(MainActivity.this, playerHightCore.toString(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
                    playerHightCore = new PlayerHightCore("Unknow", 0);
                }
                DatabaseHelper dataBaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = dataBaseHelper.addOne(playerHightCore);
                Log.d("check", String.valueOf(success));
            }
        });
    }

    public void clickPlay(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

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