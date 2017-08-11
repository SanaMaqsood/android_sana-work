package com.example.bahucomputer.parcelable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

import static com.example.bahucomputer.parcelable.MainActivity.KEY_STUDENT_DATA;

public class Main2Activity extends AppCompatActivity {
    private ListView listView;

    private CustomAdapter mCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initViews();
//     ArrayList<Student> studentArrayList=fetchData();
        setListView(fetchData());
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.lv_students);
    }

    private void setListView(ArrayList<Student> studentArrayList) {
        mCustomAdapter = new CustomAdapter(this, studentArrayList);
        listView.setAdapter(mCustomAdapter);
    }

    private ArrayList<Student> fetchData() {
        ArrayList<Student> studentArrayList = (ArrayList<Student>) getIntent().getSerializableExtra(KEY_STUDENT_DATA);
//      studentArrayList = (ArrayList<Student>) getIntent().getBundleExtra(KEY_DATA).getSerializable(KEY_STUDENT_DATA);
        return studentArrayList;
    }

    private void refreshAdapter() {
        mCustomAdapter.notifyDataSetChanged();
    }
}
