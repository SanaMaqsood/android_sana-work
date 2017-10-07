package com.example.sanapc.recyclerview.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sana PC on 7/4/2017.
 */

public class StudentDataBaseSQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "std.db";
    public static final String TABLE_STUDENT = "student";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static String MARKS = "marks";
    private static final String DETAILS_TABLE_CREATE =
            "CREATE TABLE " + TABLE_STUDENT + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    MARKS + " INTEGER);";

    public StudentDataBaseSQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DETAILS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }

    public void deleteRow(int value)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_STUDENT+ " WHERE "+ID+ " = '"+value+"'");
        db.close();
    }

}