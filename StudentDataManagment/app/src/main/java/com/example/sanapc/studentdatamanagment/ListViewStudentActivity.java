package com.example.sanapc.studentdatamanagment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListViewStudentActivity extends AppCompatActivity {
    ListView list;
    ArrayList<AddData> myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demolistview);

        list = (ListView) findViewById(R.id.listviewid);
        fetchdata();
        Registerclickcallback();
        setadapter();


    }

    private void setadapter() {
        DantaEntryBaseAdapter mDantaEntryBaseAdapter= new DantaEntryBaseAdapter(getApplicationContext(),myList );
        list.setAdapter(mDantaEntryBaseAdapter);
    }

    private void fetchdata() {
         myList = (ArrayList<AddData>) getIntent().getSerializableExtra("pass");
    }


    public void Registerclickcallback() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "Your Clicked" + position
                        + "which is string" + textView.getText().toString();
                Toast.makeText(ListViewStudentActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
