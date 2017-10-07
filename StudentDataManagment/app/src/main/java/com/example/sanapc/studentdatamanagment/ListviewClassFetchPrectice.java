package com.example.sanapc.studentdatamanagment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/16/2017.
 */

public class ListviewClassFetchPrectice extends AppCompatActivity {
    ListView list;
    ArrayList<PracticeStudentEntry> mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylistview_main_activity);
        list=(ListView) findViewById(R.id.list_item);
        fetchDtat();
        setadapter();
    }


    private void setadapter() {
        ListviewBaseClassPrectice adaptar=new ListviewBaseClassPrectice(getApplicationContext(),mylist);
        list.setAdapter(adaptar);
    }

    private void fetchDtat() {
         mylist=(ArrayList<PracticeStudentEntry>) getIntent().getSerializableExtra("pass");
    }

}
