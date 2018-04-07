package com.examples.hp.easymarket;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 04-04-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //Database name
    public static final String DATABASE_NAME="easymarket.db";

    //farmers Table
    public static final String TABLE_NAME1="sellerRegister";
    public static final String COL_1f="ID";
    public static final String COL_2f="SellerName";
    public static final String COL_3f="Email";
    public static final String COL_4f="Password";
    public static final String COL_5f="Phone";


    //items Table
    public static final String TABLE_NAME2="itemDetails";
    public static final String COL_1i="ID";
    public static final String COL_2i="item";
    public static final String COL_3i="description";
    public static final String COL_4i="price";
    public static final String COL_5i="sellername";
    public static final String COL_6i="phone";

    //Users Table
    public static final String TABLE_NAME3="userRegisteration";
    public static final String COL_1="ID";
    public static final String COL_2="FirstName";
    public static final String COL_3="LastName";
    public static final String COL_4="Password";
    public static final String COL_5="Email";
    public static final String COL_6="Phone";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,  null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME1 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,SellerName TEXT,Password TEXT,Phone TEXT,Email TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,item TEXT,description TEXT,price TEXT,sellername TEXT,phone TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME3 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,FirstName TEXT,lastName TEXT,Password TEXT,Email TEXT,Phone TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME1); //Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME2);
       db.execSQL("DROP TABLE IF EXISTS" +TABLE_NAME3);
        //db.execSQL("DROP DATABASE " +DATABASE_NAME);

        //Drop older table if exists
//Drop older table if exists
        onCreate(db);

    }
}