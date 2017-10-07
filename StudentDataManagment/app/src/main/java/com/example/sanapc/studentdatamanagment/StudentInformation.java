package com.example.sanapc.studentdatamanagment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Sana PC on 3/31/2017.
 */

public class StudentInformation extends AppCompatActivity {
    TextView tv1, tv2, tv3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_information);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        //Intent intent = getIntent();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String Name = sharedPreferences.getString(StudentInputActivity.NAME,"");
        String Roll_No = sharedPreferences.getString(StudentInputActivity.ROLL_NO,"");
        String CNic = sharedPreferences.getString(StudentInputActivity.CNiC,"");

        tv1.setText(Name);
        tv2.setText(Roll_No);
        tv3.setText(CNic);
    }

}

