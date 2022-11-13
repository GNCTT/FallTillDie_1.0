package com.example.falltilldie_10.HightCore;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falltilldie_10.R;

import java.util.ArrayList;
import java.util.List;

public class HightCore extends AppCompatActivity {

    private RecyclerView rcv_user;
    private highCoreUserAdapter userAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hightcore);
        rcv_user = (RecyclerView) findViewById(R.id.rcv_user);
        userAdapter = new highCoreUserAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rcv_user.setLayoutManager(linearLayoutManager);
        userAdapter.setData(getListUser());
        rcv_user.setAdapter(userAdapter);

    }


    //Hàm tạo danh sách; lấy danh sách này từ dữ liệu trả về.
    //Tạm thời fix cứng
    private List<higthCoreUser> getListUser () {
        List<higthCoreUser> list = new ArrayList<>();
        list.add(new higthCoreUser(R.drawable.avatar, "Tim Cook", 4000, 1));
        list.add(new higthCoreUser(R.drawable.avatar2, "Tim cac", 3000, 1));
        list.add(new higthCoreUser(R.drawable.avatar, "Tim aaa", 2000, 1));
        list.add(new higthCoreUser(R.drawable.avatar2, "Timbbbbok", 6000, 1));
        list.add(new higthCoreUser(R.drawable.avatar, "Tim Cook", 4000, 1));
        list.add(new higthCoreUser(R.drawable.avatar2, "Tim Cook", 4000, 1));
        return list;
    }

    //Phần hight core sẽ có 2 mục là điểm cao cho phần offline và điểm cao cho phần online
    //Danh sách hiển thị sử dụng rycycler view. Số lượng hiển thị mỗi mục là top 5.
    //Lưu trữ dữ liệu người chơi 2 phần:
    //1. Lưu trong thiết bị: chỉ của người chơi đăng nhập thiết bị đó
    //2. Lưu online lưu tất cả dữ liệu của tất cả người chơi.
    //Khi game bật(có kết nối internet) cơ sở dữ liệu sẽ cập nhập điểm cao mới của người chơi lên hệ thống
    //& lấy danh sách điểm cao của toàn bộ người chơi để cập nhật về
}
