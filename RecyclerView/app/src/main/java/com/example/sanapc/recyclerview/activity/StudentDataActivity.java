package com.example.sanapc.recyclerview.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.adapter.RecyclerShowStudentData;
import com.example.sanapc.recyclerview.db.StudentDataBaseSQLiteOpenHelper;
import com.example.sanapc.recyclerview.dto.Student;
import com.example.sanapc.recyclerview.interfaces.RefreshListInterface;
import com.example.sanapc.recyclerview.widget.AddAlertBox;
import com.example.sanapc.recyclerview.widget.DeleteAlertBox;

import java.util.ArrayList;

/**
 * Created by Sana PC on 7/3/2017.
 */

public class StudentDataActivity extends AppCompatActivity implements View.OnClickListener, RefreshListInterface{
    RecyclerView recyclerview;
    Button btnAdd, btnEdit, btnDelete;
    RecyclerShowStudentData Radaptar;
    private StudentDataBaseSQLiteOpenHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_activity);

        dbHelper = new StudentDataBaseSQLiteOpenHelper(this); // creating db

        initViews();

        btnAdd.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        displayStudents();
    }

    private void initViews() {
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnEdit = (Button) findViewById(R.id.btnedit);
        btnDelete = (Button) findViewById(R.id.btndelete);
        recyclerview = (RecyclerView) findViewById(R.id.recycler1);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnadd:
                AlertBoxAdd();
                break;
            case R.id.btnedit:
                AlertBoxEdit();
                break;
            case R.id.btndelete:
                AlertBoxDelete();
                break;

        }

    }

    private void AlertBoxDelete() {
        DeleteAlertBox mdelete = new DeleteAlertBox(this, this, dbHelper);
//        DeleteAlertBox deleteAlertBox = new DeleteAlertBox(this, new RefreshListInterface() {
//            @Override
//            public void refresh() {
//                displayStudents();
//            }
//        }, dbHelper);
        mdelete.show();

    }

    private void AlertBoxEdit() {
    }

    private void AlertBoxAdd() {
        AddAlertBox madd = new AddAlertBox(this,this,dbHelper);
        madd.show();
    }

    private void displayStudents() {
        // fetch all students from db (array list of students)
        ArrayList<Student> mListStudent = fetchStudentData();
        // set array list of students in recylerview
        setStudentsToRecyclerView(mListStudent);
    }

    private ArrayList<Student> fetchStudentData() {
        ArrayList<Student> mListStudent = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

//        String projection[] = {StudentDataBaseSQLiteOpenHelper.ID, StudentDataBaseSQLiteOpenHelper.NAME, StudentDataBaseSQLiteOpenHelper.MARKS};
        Cursor c = db.query(StudentDataBaseSQLiteOpenHelper.TABLE_STUDENT, null, null, null, null, null, null);
//        if (c.moveToFirst()) {
//             while (c.moveToNext()){
//                 student= new Student(c.getInt(0),c.getString(1),c.getInt(2));
//                mListStudent.add(student);
//            }
//        }
        if (c.moveToFirst()) {
            Student student1 = new Student(c.getInt(0), c.getString(1), c.getInt(2));
            mListStudent.add(student1);

            while (c.moveToNext()) {
                Student student = new Student(c.getInt(0), c.getString(1), c.getInt(2));
                mListStudent.add(student);

            }
        }

        /*while (c.moveToNext()){
                 student= new Student(c.getInt(0),c.getString(1),c.getInt(2));
                mListStudent.add(student);
            }*/
        return mListStudent;
    }

    private void setStudentsToRecyclerView(ArrayList<Student> mStudentList) {
        Radaptar = new RecyclerShowStudentData(this, mStudentList,dbHelper,this);
        recyclerview.setAdapter(Radaptar);
        Radaptar.notifyDataSetChanged();
    }

    @Override
    public void refresh() {
        displayStudents();
    }


}
