package com.example.sanapc.practicedatabaseandrecyclerview.Activity.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sana PC on 7/11/2017.
 */

public class StudentSQLiteDatabase extends SQLiteOpenHelper {
    public static final String DB_NAME = "stud.db";
    public static final String TABLE_NAME = "student";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String MARKS = "marks";
    private static final String DETAILS_TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    NAME + " TEXT, " +
                    MARKS + " INTEGER);";

    public StudentSQLiteDatabase(Context context) {
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

    public void deleteRow(int value) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = '" + value + "'");
        db.close();
    }
}