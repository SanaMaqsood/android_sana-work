package com.example.sanapc.studentdatamanagment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class ListViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demolistview);
        populatelistview();
        Registerclickcallback();


    }

    public void populatelistview() {
        //create list of items
        String[] myitems = {"Blue", "Red", "Green", "Purple"};
        // create the list adapter

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, //context for the activity
               // R.layout.customelistview, R.id.tv22, //layout used
                //myitems); //item to be dispalyed
        //create the configuration
        ListView list = (ListView) findViewById(R.id.listviewid);
      //  list.setAdapter(adapter);

    }

    public void Registerclickcallback() {

        ListView list = (ListView) findViewById(R.id.listviewid);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "Your Clicked" + position
                        + "which is string" + textView.getText().toString();
                Toast.makeText(ListViewActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }
}
