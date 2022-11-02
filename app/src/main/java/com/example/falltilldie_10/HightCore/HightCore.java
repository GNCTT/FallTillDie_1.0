package com.example.falltilldie_10.HightCore;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.falltilldie_10.R;

public class HightCore extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.hightcore);
    }

    //Phần hight core sẽ có 2 mục là điểm cao cho phần offline và điểm cao cho phần online
    //Danh sách hiển thị sử dụng rycycler view. Số lượng hiển thị mỗi mục là top 5.
    //Lưu trữ dữ liệu người chơi 2 phần:
    //1. Lưu trong thiết bị: chỉ của người chơi đăng nhập thiết bị đó
    //2. Lưu online lưu tất cả dữ liệu của tất cả người chơi.
    //Khi game bật(có kết nối internet) cơ sở dữ liệu sẽ cập nhập điểm cao mới của người chơi lên hệ thống
    //& lấy danh sách điểm cao của toàn bộ người chơi để cập nhật về
}
