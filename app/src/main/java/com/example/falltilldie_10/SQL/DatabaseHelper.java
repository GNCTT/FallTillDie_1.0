//package com.example.demodb;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.DatabaseErrorHandler;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DataBaseHelper extends SQLiteOpenHelper {
//    public DataBaseHelper(@Nullable Context context) {
//        super(context,  "customer_db", null, 1);
//    }
//
//    // Gọi vào đây khi lần đầu tiên DB được tạo
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  COLUMN_CUSTOMER_NAME + " TEXT, " + COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_ACTIVE_CUSTOMER + " BOOL)";
//
//        sqLiteDatabase.execSQL(createTableStatement);
//    }
//
//    // Nếu đã có DB thì tạo vào đây
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }
//
//    public static final String USER_TABLE = "CUSTOMER_TABLE";
//    public static final String COLUMN_USER_NAME = "CUSTOMER_NAME";
//    public static final String COLUMN_USER_POINT = "CUSTOMER_AGE";
//
//
//    public boolean addOne(CustomerModel customerModel) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cvs = new ContentValues();
//
//        cvs.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
//        cvs.put(COLUMN_CUSTOMER_AGE, customerModel.getAge());
//        cvs.put(COLUMN_ACTIVE_CUSTOMER, customerModel.isActive());
//
//        long insert = db.insert(CUSTOMER_TABLE, null, cvs);
//        return insert != -1;
//    };
//
//    public List<CustomerModel> getEveryOne () {
//        List<CustomerModel>  returnList = new ArrayList<>();
//
//        String queryString = "SELECT * FROM " + CUSTOMER_TABLE;
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.rawQuery(queryString, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int customerID = cursor.getInt(0);
//                String customerName = cursor.getString(1);
//                int customerAge = cursor.getInt(2);
//                boolean isActive = cursor.getInt(3) == 1;
//
//                CustomerModel newCustomer = new CustomerModel(customerID, customerName, customerAge, isActive);
//
//                returnList.add(newCustomer);
//
//            } while (cursor.moveToNext());
//        } else {
//            // do something
//        }
//
//        cursor.close();
//        db.close();
//
//        return returnList;
//    };
//
//}
