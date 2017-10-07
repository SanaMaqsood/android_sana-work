package com.example.sanapc.recyclerview.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanapc.recyclerview.R;

/**
 * Created by Sana PC on 6/8/2017.
 */

public class Fragment_BroadcastTwo extends Fragment implements View.OnClickListener{
    RadioButton rdbtn1,rdbtn2,rdbtn3;
    RadioGroup rdgrbtn;
    Context _context;
    BroadcastReceiver BroadcastR;
    View row;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        row = inflater.inflate(R.layout.fregment_broadcast_two,container,false);
        setBroadcast();
        InitViews();
        rdbtn1.setOnClickListener(this);
        rdbtn2.setOnClickListener(this);
        rdbtn3.setOnClickListener(this);
       Onclick();

        return row;


    }

    private void Onclick() {
        rdgrbtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radiog= (RadioButton) row.findViewById(checkedId);
                Toast.makeText(_context.getApplicationContext(), "This is" + radiog.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void InitViews() {
        rdbtn1=(RadioButton) row.findViewById(R.id.rbtn1);
        rdbtn2=(RadioButton) row.findViewById(R.id.rbtn2);
        rdbtn3=(RadioButton) row.findViewById(R.id.rbtn3);
        rdgrbtn=(RadioGroup) row.findViewById(R.id.radiogroup);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        _context=context;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        _context.unregisterReceiver(BroadcastR);
    }
    private void setBroadcast() {
        BroadcastR= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent i) {
                String data= i.getStringExtra("From");
                TextView textview= (TextView) row.findViewById(R.id.tv2);
                LinearLayout llcolor= (LinearLayout) row.findViewById(R.id.linear2);
                llcolor.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                textview.setText(data);


            }
        };
        IntentFilter intfilter= new IntentFilter("MYSECONDFRAGMENT");
        _context.registerReceiver(BroadcastR,intfilter);
    }


    @Override
    public void onClick(View v) {
        if(v instanceof RadioButton){

        }

    }
}
