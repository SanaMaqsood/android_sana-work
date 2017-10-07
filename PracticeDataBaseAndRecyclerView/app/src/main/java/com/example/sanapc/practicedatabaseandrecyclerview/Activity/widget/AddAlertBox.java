package com.example.sanapc.practicedatabaseandrecyclerview.Activity.widget;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.sanapc.practicedatabaseandrecyclerview.Activity.db.StudentSQLiteDatabase;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.dob.Students;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.interfaces.Refreshactivity;
import com.example.sanapc.practicedatabaseandrecyclerview.R;

/**
 * Created by Sana PC on 7/11/2017.
 */

public class AddAlertBox extends Dialog implements View.OnClickListener {
    EditText editName, editMarks;
    Button btnalertadd;
    String ename, emarks;
    Students student;
    StudentSQLiteDatabase dbHelper;
    Refreshactivity refreshactivity;
    RelativeLayout relativeLayout;


    public AddAlertBox(Context context, Refreshactivity refreshactivity, StudentSQLiteDatabase dbHelper) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.addalertbox);

        this.dbHelper = dbHelper;
        this.refreshactivity = refreshactivity;
        initViews();
        btnalertadd.setOnClickListener(this);
    }

    public AddAlertBox(Students student, Context context, Refreshactivity refreshactivity, StudentSQLiteDatabase dbHelper) {
        super(context);
        setContentView(R.layout.addalertbox);
        this.student = student;
        this.dbHelper = dbHelper;
        this.refreshactivity = refreshactivity;
        initViews();

        btnalertadd.setOnClickListener(this);
    }

    private void initViews() {
        editName = (EditText) findViewById(R.id.editText1);
        editMarks = (EditText) findViewById(R.id.editText2);
        btnalertadd = (Button) findViewById(R.id.btnalertadd);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative1);
        editName.setTextColor(getContext().getResources().getColor(R.color.dark_green));
        editMarks.setTextColor(getContext().getResources().getColor(R.color.dark_green));

        if (student != null) {
            editName.setText(student.Name);
            editMarks.setText(String.valueOf(student.Marks));
            btnalertadd.setText("update");
            relativeLayout.setBackgroundColor(getContext().getResources().getColor(R.color.light_grey));
            btnalertadd.setBackgroundColor(getContext().getResources().getColor(R.color.yellow));
            editName.setTextColor(getContext().getResources().getColor(R.color.red));
            editMarks.setTextColor(getContext().getResources().getColor(R.color.red));
        }
    }

    @Override
    public void onClick(View v) {
        ename = editName.getText().toString();
        emarks = editMarks.getText().toString();
        switch (v.getId()) {
            case R.id.btnalertadd:
                if (student == null) {
                    DataEntry(ename, Integer.valueOf(emarks));
                    refreshactivity.refresh();
                    dismiss();
                } else {
                    updateDataEntry(student.Id, ename, Integer.valueOf(emarks));
                    refreshactivity.refresh();
                    dismiss();
                }
        }

    }

    public void DataEntry(String name, int marks) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(StudentSQLiteDatabase.NAME, name);
        values.put(StudentSQLiteDatabase.MARKS, marks);
        db.insert(StudentSQLiteDatabase.TABLE_NAME, null, values);

    }

    public void updateDataEntry(int id, String name, int marks) {
        try {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(StudentSQLiteDatabase.NAME, name);
            values.put(StudentSQLiteDatabase.MARKS, marks);
            db.update(StudentSQLiteDatabase.TABLE_NAME, values, StudentSQLiteDatabase.ID + "=" + id, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
