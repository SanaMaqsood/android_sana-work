package com.example.sanapc.studentdatamanagment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * Created by Sana PC on 5/18/2017.
 */

public class Fragmentation_example extends AppCompatActivity {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentation_example);
        initviews();
        Onclick();
    }

    private void Onclick() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new FragmentOne();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.fragmentspace, fragment);
                ft.commit();

            }});
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new FragmentTwo();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft= fm.beginTransaction();
                ft.replace(R.id.fragmentspace, fragment);
                ft.commit();

            }
        });
    }

    private void initviews() {
        btn1=(Button) findViewById(R.id.btnn1);
        btn2=(Button) findViewById(R.id.btnn2);

    }
}
