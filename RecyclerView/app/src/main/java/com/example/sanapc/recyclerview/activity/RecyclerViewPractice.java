package com.example.sanapc.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.adapter.RecyclerViewAdaptarPractice;
import com.example.sanapc.recyclerview.dto.Information;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana PC on 6/6/2017.
 */

public class RecyclerViewPractice extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdaptarPractice adaptarPractice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_practice);
        initViews();
        setAdaptar();

    }

    public static List<Information> getData() {
        List<Information> data = new ArrayList<>();
        int[] icons = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.four, R.drawable.four, R.drawable.four, R.drawable.four, R.drawable.four};
        String[] titles = {"One", "Two", "Three", "Four", "Four", "Four", "Four", "Four", "Four"};


        for (int i = 0; i < icons.length && i < titles.length; i++) {
            Information current = new Information();
            current.iconId = icons[i];
            current.title = titles[i];
            data.add(current);


        }
        return data;
    }

    private void setAdaptar() {
        adaptarPractice = new RecyclerViewAdaptarPractice(this, getData());
        recyclerView.setAdapter(adaptarPractice);
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
