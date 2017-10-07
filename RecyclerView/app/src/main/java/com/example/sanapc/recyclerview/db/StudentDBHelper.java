package com.example.sanapc.recyclerview.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sana PC on 7/3/2017.
 */

public class StudentDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "std.db";
    public static final String TABLE_STUDENT = "student";

    public StudentDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_STUDENT + " (sid text,sname text,marks text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("drop table if exists student");
    }
}
