package com.example.sanapc.studentdatamanagment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/15/2017.
 */

public class PracticeMainActivity extends AppCompatActivity {

    private EditText ed1, ed2, ed3, ed4;
    String sname, sroll, saddress, sedu;
    private Button bt1, bt2, bt3;
    ArrayList<PracticeStudentEntry> Practicelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_main_activity);
        initView();
        Clicklistner();

    }

    private void Clicklistner() {

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDatatoList();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deletDatatoList();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowData();
            }
        });
    }

    private void deletDatatoList() {


        for (int i = 0; i < Practicelist.size(); i++) {

            if (Practicelist.get(i).getsName().equalsIgnoreCase(ed1.getText().toString())) {
                Practicelist.remove(i);
                Toast.makeText(getApplicationContext(), "Person Deleted", Toast.LENGTH_LONG).show();
            }

        }
    }

    private void AddDatatoList() {
        sname = ed1.getText().toString();
        sroll = ed2.getText().toString();
        saddress = ed3.getText().toString();
        sedu = ed4.getText().toString();

        PracticeStudentEntry adddata = new PracticeStudentEntry(sname, sroll, saddress, sedu);
        Practicelist.add(adddata);
        Toast.makeText(getApplicationContext(), "Person Added", Toast.LENGTH_LONG).show();

    }

    private void initView() {
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        ed3 = (EditText) findViewById(R.id.ed3);
        ed4 = (EditText) findViewById(R.id.ed4);
        bt1 = (Button) findViewById(R.id.btnadd);
        bt2 = (Button) findViewById(R.id.btndelete);
        bt3 = (Button) findViewById(R.id.btnshow);

    }
  private void ShowData(){
      Intent myintent = new Intent(this, PracticeFetchDataActivity.class);
      Bundle mBundle = new Bundle();
      mBundle.putSerializable("pass", Practicelist);
      myintent.putExtras(mBundle);
      startActivity(myintent);

  }
}
