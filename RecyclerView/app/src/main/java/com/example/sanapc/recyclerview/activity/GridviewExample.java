package com.example.sanapc.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.sanapc.recyclerview.adapter.GridviewAdaptarExample;
import com.example.sanapc.recyclerview.R;

/**
 * Created by Sana PC on 6/16/2017.
 */

public class GridviewExample extends AppCompatActivity {
    GridView gridView;
    int lettersIcons[]= {R.drawable.one,R.drawable.two,
    R.drawable.three, R.drawable.four, R.drawable.meme8};
    String letterslist[]={"One","Two","Three","Four","Five"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewtwo_example);

        gridView=(GridView) findViewById(R.id.gridview);
        GridviewAdaptarExample adaptar= new GridviewAdaptarExample(GridviewExample.this,lettersIcons,letterslist);
        gridView.setAdapter(adaptar);
//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"Clicked Letter"+letterslist,Toast.LENGTH_LONG).show();
//            }
//        });
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clicked Letter"+letterslist,Toast.LENGTH_LONG).show();
            }
        });

    }
}
