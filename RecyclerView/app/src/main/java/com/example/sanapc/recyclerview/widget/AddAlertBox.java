package com.example.sanapc.recyclerview.widget;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.db.StudentDataBaseSQLiteOpenHelper;
import com.example.sanapc.recyclerview.dto.Student;
import com.example.sanapc.recyclerview.interfaces.RefreshListInterface;

/**
 * Created by Sana PC on 7/4/2017.
 */

public class AddAlertBox extends Dialog implements View.OnClickListener {
    EditText editName, editMarks;
    Button btnAdd;
    String ename, emarks;
    RefreshListInterface mRefreshlistinterface;
    private Student student;

    private StudentDataBaseSQLiteOpenHelper dbHelper;

    public AddAlertBox(Context context, RefreshListInterface mRefreshlistinterface,
                       StudentDataBaseSQLiteOpenHelper dbHelper) {
        super(context);
        setContentView(R.layout.add_data_activity);
        this.mRefreshlistinterface = mRefreshlistinterface;
        this.dbHelper = dbHelper;
        initView();
    }

    public AddAlertBox(Student student, Context context, RefreshListInterface mRefreshlistinterface,
                       StudentDataBaseSQLiteOpenHelper dbHelper) {
        super(context);
        setContentView(R.layout.add_data_activity);
        this.mRefreshlistinterface = mRefreshlistinterface;
        this.dbHelper = dbHelper;
        this.student = student;
        initView();
    }

    private void initView() {
        editName = (EditText) findViewById(R.id.Edtext1);
        editMarks = (EditText) findViewById(R.id.Edtext2);
        btnAdd = (Button) findViewById(R.id.btnaddnew);
        btnAdd.setOnClickListener(this);
        if (student != null) {
            editName.setText(student.name);
            editMarks.setText(String.valueOf(student.marks));
            btnAdd.setText("Update");
        }
    }

    @Override
    public void onClick(View v) {
        String ename = editName.getText().toString();
        String emarks = editMarks.getText().toString();
        switch (v.getId()) {
            case R.id.btnaddnew:
                if (student == null) {
                    DataEntry(ename, Integer.valueOf(emarks));
                    mRefreshlistinterface.refresh();
                    dismiss();
                } else {
                    updateStudent(student.id, ename, Integer.valueOf(emarks));
                    mRefreshlistinterface.refresh();
                    dismiss();
                }
        }

    }

    private void DataEntry(String name, int marks) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(StudentDataBaseSQLiteOpenHelper.NAME, name);
        values.put(StudentDataBaseSQLiteOpenHelper.MARKS, marks);
        db.insert(StudentDataBaseSQLiteOpenHelper.TABLE_STUDENT, null, values);
    }

    private void updateStudent(int id, String name, int marks) {
        try {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(StudentDataBaseSQLiteOpenHelper.NAME, name); //These Fields should be your String values of actual column names
            cv.put(StudentDataBaseSQLiteOpenHelper.MARKS, marks);
            db.update(StudentDataBaseSQLiteOpenHelper.TABLE_STUDENT, cv, StudentDataBaseSQLiteOpenHelper.ID+"=" + id, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
