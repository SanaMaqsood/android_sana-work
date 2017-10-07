package com.example.sanapc.recyclerview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sanapc.recyclerview.fragment.Fragment_BroadcastOne;
import com.example.sanapc.recyclerview.fragment.Fragment_BroadcastThree;
import com.example.sanapc.recyclerview.fragment.Fragment_BroadcastTwo;
import com.example.sanapc.recyclerview.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sana PC on 6/8/2017.
 */

public class BroadCastWithFregment extends AppCompatActivity implements View.OnClickListener {
    Button btnn1, btnn2, btnn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_main);

        initViews();
        Onclick();

    }

         private void Onclick() {
//        btnn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendInternalBroadcast();
//            }
//        });
//        btnn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                sendInternalBroadcastTwo();
//
//            }
//        });
//       btnn3.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//
//
//           }
//       });
        btnn1.setOnClickListener(this);
        btnn2.setOnClickListener(this);
        btnn3.setOnClickListener(this);

    }

    private void initViews() {

        btnn1 = (Button) findViewById(R.id.btn1);
        btnn2 = (Button) findViewById(R.id.btn2);
        btnn3 = (Button) findViewById(R.id.btn3);

    }

    private void sendInternalBroadcastTwo() {
        Intent intent = new Intent();
        intent.setAction("MYSECONDFRAGMENT");
        intent.putExtra("From", "This is my Second Fragment");
        sendBroadcast(intent);

    }

    private void sendInternalBroadcast() {
        Intent intent = new Intent();
        intent.setAction("MYFRAGMENT_COLOR"); // intent filter
        // shout speaker
        intent.putExtra("From", "This is my First Fragment");
        sendBroadcast(intent);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:
                Fragment fragmentOne = new Fragment_BroadcastOne();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentspace, fragmentOne);
                ft.commit();
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 2 seconds
                        sendInternalBroadcast();
                    }
                }, 1000);

                break;
            case R.id.btn2:
                Fragment fragmentTwo = new Fragment_BroadcastTwo();
                FragmentManager fma = getSupportFragmentManager();
                FragmentTransaction fta = fma.beginTransaction();
                fta.replace(R.id.fragmentspace, fragmentTwo);
                fta.commit();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // this code will be executed after 2 seconds
                        sendInternalBroadcastTwo();
                    }
                }, 2000);

                break;
            case R.id.btn3:
                Fragment fragmentThree = new Fragment_BroadcastThree();
                FragmentManager fmb = getSupportFragmentManager();
                FragmentTransaction ftb = fmb.beginTransaction();
                ftb.replace(R.id.fragmentspace, fragmentThree);
                ftb.commit();


                break;
            default:
                break;
        }

    }
}
