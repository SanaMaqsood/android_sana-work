package com.example.sanapc.recyclerview.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
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
import android.widget.TextView;

import com.example.sanapc.recyclerview.R;

/**
 * Created by Sana PC on 6/8/2017.
 */

public class Fragment_BroadcastOne extends Fragment {
    Context _context;
    BroadcastReceiver br;
    View row;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        row = inflater.inflate(R.layout.fragment_broadcast_one, container, false);
        setup();
        return row;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        _context = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _context.unregisterReceiver(br);
    }


    private void setup() {
        br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent i) {
                String data= i.getStringExtra("From");
                TextView tv = (TextView) row.findViewById(R.id.fragmentone);
                LinearLayout llColor= (LinearLayout)row.findViewById(R.id.ll_container);
                llColor.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                tv.setText(data);

            }
        };

        IntentFilter iFilter= new IntentFilter("MYFRAGMENT_COLOR");
        _context.registerReceiver(br,iFilter);
    }
}
