package com.example.falltilldie_10.HightCore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.falltilldie_10.R;
import com.example.falltilldie_10.SQL.PlayerHightCore;

import java.util.List;

public class highCoreUserAdapter extends RecyclerView.Adapter<highCoreUserAdapter.highCoreUserViewHolder> {

    private Context mContext;
    private List<PlayerHightCore> mlistUser;

    public highCoreUserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<PlayerHightCore> list) {
        this.mlistUser = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public highCoreUserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_hightcore_item, parent, false);
        return new highCoreUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull highCoreUserViewHolder holder, int position) {
        PlayerHightCore user = mlistUser.get(position);
        if(user == null) {
            return;
        }
        holder.name.setText(user.getName());
        holder.point.setText(Integer.toString(user.getPoint()));

        //Bo 2 point va rank thi duoc, nhung giu thi lai k? Why?
    }

    @Override
    public int getItemCount() {
            return mlistUser.size();
    }

    public class highCoreUserViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView point;
        public highCoreUserViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameUser);
            point = (TextView) itemView.findViewById(R.id.point);
        }
    }
}
