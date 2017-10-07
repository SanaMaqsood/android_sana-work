package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.pk.gov.pitb.email.dto.Student;

import java.util.ArrayList;

public class StudentMarksActivity extends AppCompatActivity {
    private ArrayList<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_marks);
        initView();

        // initClickListener???
    }

    private void initView() {
        final EditText edName = (EditText) findViewById(R.id.ed_name);
        final EditText edMarks = (EditText) findViewById(R.id.ed_marks);
        Button btnAdd = (Button) findViewById(R.id.btn_add);

// try catch???
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                int marks = Integer.valueOf(edMarks.getText().toString());
                addStudents(name, marks);
            }
        });
    }

    private void displayData(ArrayList<Student> std) {
        TextView tvStudent = (TextView) findViewById(R.id.tv_student);
        tvStudent.setText("");
        for (int i = 0; i < std.size(); i++) {
            tvStudent.setText(tvStudent.getText() + "\n" + std.get(i).getName() + " marks are: " + ": " + std.get(i).getMarks() + "\n");
        }
    }

    private void addStudents(String Name, int Marks) {
        Student std = new Student(Name, Marks);
        studentList.add(std);
        displayData(studentList);
    }
}
