package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PracticeActivity extends AppCompatActivity {

    private int arrayIndexRef = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final int[] arrayStudentNumbers = new int[10];
        final List<Integer> arrayListInteger = new ArrayList<>();
        arrayListInteger.set(0,10);
        arrayListInteger.set(1,1);
        arrayListInteger.set(1,2);

        setContentView(R.layout.activity_practice);
        final EditText edPractice = (EditText) findViewById(R.id.ed_practice);
        Button btnPractice = (Button) findViewById(R.id.btn_practice);
        Button btnShow = (Button) findViewById(R.id.btn_show);


        btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int inputNum = Integer.valueOf(edPractice.getText().toString());
                    if (arrayIndexRef < 10) {
                        arrayStudentNumbers[arrayIndexRef] = inputNum;
                        arrayIndexRef++;
                    }
                    arrayListInteger.add(inputNum);

                    edPractice.setText("");
                } catch (Exception e) {
                    Toast.makeText(PracticeActivity.this, "Wrong Input", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });



        //  initStudentNumbers(arrayStudentNumbers);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tvOutPut = (TextView) findViewById(R.id.tv_output);
                for (int i = 0; i < arrayStudentNumbers.length; i++) {
                    if (i == 0) {
                        tvOutPut.setText("Values are: " + arrayStudentNumbers[i]);
                    } else {
                        tvOutPut.setText(tvOutPut.getText().toString() + ", " + arrayStudentNumbers[i]);
                    }
                }

                TextView tvOutPutList = (TextView) findViewById(R.id.tv_output_array_list);
                for (int i = 0; i < arrayListInteger.size(); i++) {
                    if (i == 0) {
                        tvOutPutList.setText("Values are: " + arrayListInteger.get(i).toString());
                    } else {
                        tvOutPutList.setText(tvOutPutList.getText().toString() + ", " + arrayListInteger.get(i).toString());
                    }
                }
            }
        });


    }

    private void initStudentNumbers(int[] arrStud) {
        for (int i = 0; i < arrStud.length; i++) {
            arrStud[i] = getRandom(10);
        }
    }

    private int getRandom(int max) {
        return (int) (Math.random() * max);
    }
}
