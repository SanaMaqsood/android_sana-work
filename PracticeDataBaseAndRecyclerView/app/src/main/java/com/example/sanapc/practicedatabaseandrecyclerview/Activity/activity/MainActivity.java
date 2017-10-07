package com.example.sanapc.practicedatabaseandrecyclerview.Activity.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.sanapc.practicedatabaseandrecyclerview.Activity.adaptar.StudentListAdaptar;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.db.StudentSQLiteDatabase;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.dob.Students;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.interfaces.Refreshactivity;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.widget.AddAlertBox;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.widget.DeleteAlertBox;
import com.example.sanapc.practicedatabaseandrecyclerview.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Refreshactivity {
    /*
    Views Related Objects
     */
    private Button btnAdd, btnDelete;
    private RecyclerView rvStudents;
    /*
       DB Objects
     */
    private StudentSQLiteDatabase dpHelper;
    /*
           Adapter Objects
    */
    private StudentListAdaptar rAdaptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        dpHelper = new StudentSQLiteDatabase(this);

        initViews();
        initClickListeners();

//        displayStudents();
        setDataToRecyclerView(fetchData());

    }

    private void initClickListeners() {
        btnAdd.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    private void initViews() {
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnDelete = (Button) findViewById(R.id.btndelete);
        rvStudents = (RecyclerView) findViewById(R.id.recyclerv1);
        rvStudents.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnadd:
                addStudents();
                break;
            case R.id.btndelete:
                deleteStudents();
                break;
        }
    }

    public void addStudents() {
        AddAlertBox mAddAlertBox = new AddAlertBox(this, this, dpHelper);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(mAddAlertBox.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mAddAlertBox.show();
        mAddAlertBox.getWindow().setAttributes(lp);
    }

    public void deleteStudents() {
        DeleteAlertBox mDeleteAlertBox = new DeleteAlertBox(this, dpHelper, this);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(mDeleteAlertBox.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        mDeleteAlertBox.show();
        mDeleteAlertBox.getWindow().setAttributes(lp);
    }

    public ArrayList<Students> fetchData() {
        Students students;

        ArrayList<Students> mStudents = new ArrayList<>();
        SQLiteDatabase db = dpHelper.getReadableDatabase();
        Cursor c = db.query(StudentSQLiteDatabase.TABLE_NAME, null, null, null, null, null, null);
        if (c.moveToFirst()) {
            students = new Students(c.getInt(0), c.getString(1), c.getInt(2));
            mStudents.add(students);
            while (c.moveToNext()) {
                students = new Students(c.getInt(0), c.getString(1), c.getInt(2));
                mStudents.add(students);
            }
        }
        return mStudents;
    }

//    public void displayStudents() {
//        ArrayList<Students> mstudent = fetchData() ;
//        setDataToRecyclerView(fetchData());
//    }

    public void setDataToRecyclerView(ArrayList<Students> mStudentsList) {
        rAdaptar = new StudentListAdaptar(this, mStudentsList, dpHelper, this);
        rvStudents.setAdapter(rAdaptar);
    }

    @Override
    public void refresh() {
        setDataToRecyclerView(fetchData());
    }
}
