package com.yangjian.newgank.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yang on 2018/6/22.
 * Function：
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "gank";
    public static final int VERSION = 1;
    public static final String CACHE = "cache";
    public static final String ID = "_id";
    public static final String URL = "url";
    public static final String DATA = "data";
    public static final String TIME = "time";

    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS "
                + CACHE + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + URL + " TEXT, "
                + TIME + " TEXT, "
                + DATA + " TEXT)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
