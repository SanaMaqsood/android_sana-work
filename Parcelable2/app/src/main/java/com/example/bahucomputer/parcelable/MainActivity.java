package com.example.bahucomputer.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_STUDENT_DATA = "studentARRAYLIST";
    public static final String KEY_DATA = "data";

    private ArrayList<Student> studentArrayList = new ArrayList<>();
    private EditText ename, eregistration;
    private Button enter, send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initOnClickListeners();
    }

    private void initOnClickListeners() {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getName = ename.getText().toString();
                String getRegistration = eregistration.getText().toString();

                if (isValid(getName, getRegistration)) { //when name is empty
                    Student student = new Student(getName, getRegistration);
                    studentArrayList.add(student);

                    resetEditText();
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                Bundle mBundle = new Bundle();
//                mBundle.putSerializable(KEY_STUDENT_DATA, studentArrayList);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
//                intent.putExtra(KEY_DATA, mBundle);
                intent.putExtra(KEY_STUDENT_DATA, studentArrayList);
                startActivity(intent);
            }
        });
    }


    private void resetEditText() {
        ename.setText("");
        eregistration.setText("");
    }

    private void initViews() {
        ename = (EditText) findViewById(R.id.Name);
        eregistration = (EditText) findViewById(R.id.registration);
        enter = (Button) findViewById(R.id.enter);
        send = (Button) findViewById(R.id.send);
    }

    private boolean isValid(String getName, String getRegistration) {
        if (getName != null && getRegistration != null && getName.toString().replaceAll(" ", "").length() > 0 && getRegistration.toString().replaceAll(" ", "").length() > 0) { //when name is empty
            return true;
        } else {
            return false;
        }
    }
}

