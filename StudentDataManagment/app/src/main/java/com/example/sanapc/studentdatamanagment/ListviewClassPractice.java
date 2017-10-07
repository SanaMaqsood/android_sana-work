package com.example.sanapc.studentdatamanagment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class ListviewClassPractice extends AppCompatActivity {


    private EditText enam, eroll, eaddress, eeducation;
    private String snam, sroll, saddress, seducation;
    private Button btnadd, btndelete, btnshow;
    ArrayList<PracticeStudentEntry> pstudent=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_main_activity);
        initview();
        Clicklistner();
    }
    private void initview(){
        enam=(EditText) findViewById(R.id.ed1);
        eroll=(EditText) findViewById(R.id.ed2);
        eaddress=(EditText) findViewById(R.id.ed3);
        eeducation=(EditText) findViewById(R.id.ed4);
        btnadd=(Button) findViewById(R.id.btnadd);
        btndelete=(Button) findViewById(R.id.btndelete);
        btnshow=(Button) findViewById(R.id.btnshow);



    }

    private void Clicklistner() {
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDatatolist();
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDatatoList();
            }
        });
        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDatatoList();
            }
        });
    }

    private void AddDatatolist(){
        snam=enam.getText().toString();
        sroll=eroll.getText().toString();
        saddress=eaddress.getText().toString();
        seducation=eeducation.getText().toString();

        PracticeStudentEntry adddata= new PracticeStudentEntry(snam,sroll,saddress,seducation);
        pstudent.add(adddata);
        Toast.makeText(getApplicationContext(),"person is added",Toast.LENGTH_LONG).show();

    }
    private  void DeleteDatatoList(){

        for (int i=0;i<pstudent.size();i++)
        {
            if (pstudent.get(i).getsName().equalsIgnoreCase(enam.getText().toString()))
                pstudent.remove(i);
            Toast.makeText(getApplicationContext(),"perosn is deleted",Toast.LENGTH_LONG).show();
        }

    }
    private void ShowDatatoList()
    {
        Intent myinternt= new Intent(this,ListviewClassFetchPrectice.class);
        Bundle mbundle =new Bundle();
        mbundle.putSerializable("pass",pstudent);
        myinternt.putExtras(mbundle);
        startActivity(myinternt);

    }
}
