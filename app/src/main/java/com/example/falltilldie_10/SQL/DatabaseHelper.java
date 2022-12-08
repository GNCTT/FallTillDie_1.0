package com.example.falltilldie_10.SQL;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.falltilldie_10.SQL.Player;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context,  "customer_db", null, 1);
    }
    // Gọi vào đây khi lần đầu tiên DB được tạo
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + PLAYER_TABLE + " (" + COLUMN_PLAYER_NAME + " TEXT, " + COLUMN_PLAYER_POINT + " INT)";
        sqLiteDatabase.execSQL(createTableStatement);
    }
    // Nếu đã có DB thì tạo vào đây
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public static final String PLAYER_TABLE = "PLAYER_TABLE";
    public static final String COLUMN_PLAYER_NAME = "PLAYER_NAME";
    public static final String COLUMN_PLAYER_POINT = "PLAYER_POINT";

    public boolean addOne(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cvs = new ContentValues();
        cvs.put(COLUMN_PLAYER_NAME, player.getName());
        cvs.put(COLUMN_PLAYER_POINT, player.getPoint());
        long insert = db.insert(PLAYER_TABLE, null, cvs);
        return insert != -1;
    };
    public List<Player> getEveryOne () {
        List<Player>  returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + PLAYER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                String playerName = cursor.getString(0);
                int playerPoint = cursor.getInt(1);
                Player newPlayer = new Player(playerName, playerPoint);
                returnList.add(newPlayer);

            } while (cursor.moveToNext());
        } else {
            // do something
        }
        cursor.close();
        db.close();
        return returnList;
    };
    //Lay 3 thang top diem cao nhat trong db
    public List<Player> getTop3 () {
        List<Player>  returnList = new ArrayList<>();
        String queryString = "SELECT " + COLUMN_PLAYER_NAME + ", " + COLUMN_PLAYER_POINT + " from " + PLAYER_TABLE
                + " where " + COLUMN_PLAYER_POINT + " in(select top" +"3 " + COLUMN_PLAYER_POINT + " from " + PLAYER_TABLE
                + " order by " + COLUMN_PLAYER_POINT + ");";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                String playerName = cursor.getString(0);
                int playerPoint = cursor.getInt(1);
                Player newPlayer = new Player(playerName, playerPoint);
                returnList.add(newPlayer);

            } while (cursor.moveToNext());
        } else {
            // do something
        }
        cursor.close();
        db.close();
        return returnList;
    };
}