package com.example.sanapc.practiceofallstuff.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sana PC on 7/20/2017.
 */

public class SQLiteCarItemsDb extends SQLiteOpenHelper {
    public static final String DB_NAME = "car.db";
    public static final String TABLE_NAME = "carData";
    public static final String ID = "idCar";
    public static final String NAME = "name";
    public static final String MODEL = "model";
    public static final String YEAR = "year";
    public static final String REG_NO = "regNo";
    public static final String DETAIL_TABLE_CREAT = "CREATE TABLE " + TABLE_NAME + " (" +
            ID + " INTEGER," + NAME + " TEXT, " + MODEL + " TEXT," + YEAR + " TEXT," + REG_NO +
            " TEXT);";

    public SQLiteCarItemsDb(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DETAIL_TABLE_CREAT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);

    }

}
