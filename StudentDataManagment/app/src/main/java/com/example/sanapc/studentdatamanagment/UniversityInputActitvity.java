package com.example.sanapc.studentdatamanagment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sana PC on 4/19/2017.
 */

public class UniversityInputActitvity extends AppCompatActivity {
     EditText edUniName, edUniCity, edUniCountry, edCourse, edCourseId,etSName,etSRollNo,etSAddress,etCNic;
     Button addUni, addCourse, showDetail,sSubmit;
   private String sUniName, sUniCity, sUniCountry, sCourse, sCourseId;
    private ArrayList<Courses> CourseList = new ArrayList<Courses>();
    private  ArrayList<Student> StudentList= new ArrayList<Student>();

    University mUni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_input);
        initView();
        initOnClickListeners();
    }

    private void initView() {
        edUniName = (EditText) findViewById(R.id.edUniName);
        edUniCity = (EditText) findViewById(R.id.edUniCity);
        edUniCountry = (EditText) findViewById(R.id.edUniCountry);
        edCourse = (EditText) findViewById(R.id.edCourse);
        edCourseId = (EditText) findViewById(R.id.edCourseId);
        etSName=(EditText) findViewById(R.id.etsName);
        etSRollNo=(EditText) findViewById(R.id.etsRollNo);
        etSAddress=(EditText) findViewById(R.id.etsAddress);
        etCNic=(EditText) findViewById(R.id.etsCnic);
        addUni = (Button) findViewById(R.id.btn_uni);
        addCourse = (Button) findViewById(R.id.btn_course);
        showDetail = (Button) findViewById(R.id.btn_show);
        sSubmit=(Button) findViewById(R.id.btn_std);
    }

    private void initOnClickListeners() {
        addUni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUniData();
            }
        });
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourseDataToList();
            }
        });
        showDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        sSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStudentDataToList();
            }
        });

    }

    private void addUniData() {
        sUniName = edUniName.getText().toString();
        sUniCity = edUniCity.getText().toString();
        sUniCountry = edUniCountry.getText().toString();

        mUni = new University();
        mUni.getCity();

        // use of setter
        mUni.setCity(sUniCity);
        mUni.setCountry(sUniCountry);
        mUni.setName(sUniName);


    }

    private void addCourseDataToList() {
        if(mUni==null){
            Toast.makeText(getApplicationContext(), "Enter Uni First", Toast.LENGTH_LONG).show();
        }else {
            Courses mCourse = new Courses();
            mCourse.setCourseName(edCourse.getText().toString());
            mCourse.setId(Integer.valueOf(edCourseId.getText().toString()));
            CourseList.add(mCourse);
            edCourse.setText("");
            edCourseId.setText("");
            mUni.setmCources(CourseList);
        }
    }
    private void addStudentDataToList(){
        if(mUni==null){
            Toast.makeText(getApplicationContext(),"Enter Uni First",Toast.LENGTH_LONG).show();
        }
        else {
          //  Student mStudent = new Student();
         //   mStudent.setName(etSName.getText().toString());
         //   mStudent.setRoolNo(etSRollNo.getText().toString());
            //mStudent.setAddress(etSAddress.getText().toString());
            //mStudent.setCnic(etCNic.getText().toString());
          //  StudentList.add(mStudent);
            etSName.setText("");
            etSRollNo.setText("");
            etSAddress.setText("");
            etCNic.setText("");
            mUni.setmStudent(StudentList);
        }
    }
}

