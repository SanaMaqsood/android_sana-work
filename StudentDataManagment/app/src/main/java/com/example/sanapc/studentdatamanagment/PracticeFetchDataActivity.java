package com.example.sanapc.studentdatamanagment;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import java.util.ArrayList;

/**
 * Created by Sana PC on 5/15/2017.
 */

public class PracticeFetchDataActivity extends AppCompatActivity {

    ListView list;
    ArrayList<PracticeStudentEntry> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_listview_student);
        list=(ListView) findViewById(R.id.practice_listview);
        fetchListData();
        setAdapter();
    }

    private void setAdapter() {
        PracticeStudentAdapter adaptar=new PracticeStudentAdapter(getApplicationContext(),mylist);
        list.setAdapter(adaptar);
    }

    private void fetchListData() {
        mylist= (ArrayList<PracticeStudentEntry>) getIntent().getSerializableExtra("pass");
    }


}
