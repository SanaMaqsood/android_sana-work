package com.example.sanapc.studentdatamanagment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



import java.util.ArrayList;

/**
 * Created by Sana PC on 4/19/2017.
 */

public class TeacherInputActivity extends AppCompatActivity {
    private Button btnAdd, btnNext;
    private EditText etTeacherName, etClass, etCnic, etSalary;
    private String sTeacherName, sClass, sCNIC, sSalary;
    private ArrayList<Teacher> listTeachers = new ArrayList<Teacher>();

    public static final String DATA_TEACHER = "data_teacher";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_teacher_input);

        initView();

        initOnClickListeners();

    }

    private void initView() {
        etTeacherName = (EditText) findViewById(R.id.TeacherName);
        etClass = (EditText) findViewById(R.id.Class);
        etCnic = (EditText) findViewById((R.id.cniC));
        etSalary = (EditText) findViewById(R.id.salary);
        btnAdd = (Button) findViewById(R.id.btn_send);
        btnNext = (Button) findViewById(R.id.next);
    }


    private void initOnClickListeners() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          addDataToList();
                                      }
                                  }
        );

        btnNext.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           initActivityViewTeachers();
                                       }
                                   }
        );
    }


    private void addDataToList() {
        sTeacherName = etTeacherName.getText().toString();
        sClass = etClass.getText().toString();
        sCNIC = etCnic.getText().toString();
        sSalary = etSalary.getText().toString();

        Teacher tech = new Teacher(sTeacherName, sClass, sCNIC, sSalary);
        listTeachers.add(tech);
    }

    private void initActivityViewTeachers() {
        Intent mIntentTeacherInfo = new Intent(this, TeacherInformation.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(DATA_TEACHER, listTeachers);
        mIntentTeacherInfo.putExtras(mBundle);
        startActivity(mIntentTeacherInfo);
//        finish();
    }





}


