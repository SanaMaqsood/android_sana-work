package com.example.sanapc.recyclerviewandjeasonparsing.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sanapc.recyclerviewandjeasonparsing.R;
import com.example.sanapc.recyclerviewandjeasonparsing.adapter.GridViewAdapter;

/**
 * Created by Sana PC on 7/27/2017.
 */

public class GridViewActivity extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_practice);
        gridView=(GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new GridViewAdapter(getBaseContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"I am "+position,Toast.LENGTH_LONG).show();
            }
        });

    }
}
