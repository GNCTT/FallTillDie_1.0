package com.example.falltilldie_10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.falltilldie_10.Endgame.Dialog_Endgame;
import com.example.falltilldie_10.HightCore.highCoreUserAdapter;
import com.example.falltilldie_10.SQL.DatabaseHelper;
import com.example.falltilldie_10.SQL.PlayerHightCore;

import java.util.List;

public class GameOverActivity extends AppCompatActivity {
    private RecyclerView rcv_user;
    private highCoreUserAdapter userAdapter;
    private TextView yourScore;
    private int yourScoreInt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_over);
        Button btn_back = findViewById(R.id.backMain);
        yourScore = findViewById(R.id.yourScore);
        yourScoreInt = 90;
        yourScore.setText(String.valueOf(yourScoreInt));
        yourScore.setGravity(Gravity.CENTER);
        rcv_user = (RecyclerView) findViewById(R.id.rcv_user);
        userAdapter = new highCoreUserAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_user.setLayoutManager(linearLayoutManager);
        userAdapter.setData(getListUser());
        rcv_user.setAdapter(userAdapter);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //Hàm tạo danh sách; lấy danh sách này từ dữ liệu trả về.
    private List<PlayerHightCore> getListUser () {
        DatabaseHelper dataBaseHelper = new DatabaseHelper(GameOverActivity.this);
        List<PlayerHightCore> everyone = dataBaseHelper.getEveryOne();
        return everyone;
    }

}