package com.example.falltilldie_10.SQL;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class Player {
    String name;
    int point;

    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
