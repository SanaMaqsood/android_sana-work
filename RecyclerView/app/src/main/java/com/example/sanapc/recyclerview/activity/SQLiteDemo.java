package com.example.sanapc.recyclerview.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.db.StudentDBHelper;


/**
 * Created by Sana PC on 7/3/2017.
 */

public class SQLiteDemo extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlitedemo);

        StudentDBHelper dbHelper= new StudentDBHelper(this);
//        SQLiteDatabase db= dbHelper.getWritableDatabase();
//
//        ContentValues values= new ContentValues();
//        values.put("sid","2");
//        values.put("sname","sidra");
//        values.put("marks","60");
//
//         long row =db.insert("student",null,values);
//
//        System.out.println("row is"+row);

       SQLiteDatabase dab= dbHelper.getReadableDatabase();
        String projection[]={"sid","sname","marks"};
     /*   Cursor c = null;
        try {
            c = db.query("student",projection,null,null,null,null,null);
            //c.moveToPosition(1);
            c.moveToFirst();
            Log.e("values", c.getString(1));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("row is"+c);
            c.close();
        }*/

   Cursor c=dab.query(StudentDBHelper.TABLE_STUDENT,null,null,null,null,null,null);
        c.moveToPosition(1);
        System.out.println("name is "+c.getString(1));
    }
}
