package com.example.falltilldie_10.HightCore;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falltilldie_10.MainActivity;
import com.example.falltilldie_10.R;
import com.example.falltilldie_10.SQL.DatabaseHelper;
import com.example.falltilldie_10.SQL.PlayerHightCore;

import java.util.List;

public class HightCore extends AppCompatActivity {
    private RecyclerView rcv_user;
    private highCoreUserAdapter userAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hightcore);
        Button btn_back = findViewById(R.id.backMain);
        rcv_user = (RecyclerView) findViewById(R.id.rcv_user);
        userAdapter = new highCoreUserAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_user.setLayoutManager(linearLayoutManager);
        userAdapter.setData(getListUser());
        rcv_user.setAdapter(userAdapter);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HightCore.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    //Hàm tạo danh sách; lấy danh sách này từ dữ liệu trả về.
    private List<PlayerHightCore> getListUser () {
        DatabaseHelper dataBaseHelper = new DatabaseHelper(HightCore.this);
        List<PlayerHightCore> everyone = dataBaseHelper.getEveryOne();
        return everyone;
    }
}
