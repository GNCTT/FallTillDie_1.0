package com.example.falltilldie_10.test_dialog;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.falltilldie_10.R;

public class test_dialog extends AppCompatActivity {
    Button btn_endgame;
    Button btn_pause;
    Button btn_sure;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_dialog);

        btn_endgame = findViewById(R.id.btn_endgamedialog);
        btn_pause = findViewById(R.id.btn_pausedialog);
        btn_sure = findViewById(R.id.btn_suredialog);

        btn_endgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "btn_endgame");
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "btn_pause");
            }
        });

        btn_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "btn_sure");
            }
        });
    }
}
