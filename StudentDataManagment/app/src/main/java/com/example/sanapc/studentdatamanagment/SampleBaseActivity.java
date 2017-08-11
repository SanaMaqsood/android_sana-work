package com.example.sanapc.studentdatamanagment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/15/2017.
 */

public class SampleBaseActivity extends AppCompatActivity {

     ListView mlistview;
     ArrayList<Student> mstudents = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylistview_main_activity);
        initView();
        setAdapter();
        initData();

    }

    private void initData() {
        for (int i = 0; i <10; i++) {

            Student mstudentss = new Student(String.valueOf(i), String.valueOf(i));
            mstudents.add(mstudentss);
        }

    }

    private void setAdapter() {
        BaseAdapterPractice mbaseadapter = new BaseAdapterPractice(this, mstudents);
        mlistview.setAdapter(mbaseadapter);
    }

    private void initView() {
        mlistview = (ListView) findViewById(R.id.list_item);

    }

}
