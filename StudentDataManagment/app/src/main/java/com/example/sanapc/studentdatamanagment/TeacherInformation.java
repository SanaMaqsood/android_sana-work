package com.example.sanapc.studentdatamanagment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Sana PC on 4/19/2017.
 */

public class TeacherInformation extends AppCompatActivity {

    private ListView listTeacher;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_information);
        listTeacher = (ListView) findViewById(R.id.list);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this,
//                R.layout.teacher_information, );
//
//        listTeacher.setAdapter(adapter);

    }


}
