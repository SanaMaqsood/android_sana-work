package com.example.sanapc.recyclerview.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.sanapc.recyclerview.R;

public class MainActivity extends AppCompatActivity {
    //    private RecyclerView recyclerView;
    //    private RViewAdaptar adaptar;
    RelativeLayout bgroundlyt;
    Button btBroadcast;
    public final String ACTION_CHANGE_COLOR = "com.example.sanapc.recyclerview.CHANGE.COLOR";
    private BroadcastReceiver receiver;
    public final String TAG = "Fun with Receiver";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bgroundlyt = (RelativeLayout) findViewById(R.id.bgoundlyt);
        btBroadcast = (Button) findViewById(R.id.bt_broadcast);

        btBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("SOME_OTHER_ACTION");
                sendBroadcast(intent);
            }
        });


        IntentFilter filter = new IntentFilter();
        filter.addAction("SOME_ACTION");
        filter.addAction("SOME_OTHER_ACTION");

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(getApplicationContext(), "This is a Broadcast", Toast.LENGTH_SHORT).show();
                //do something based on the intent's action
            }
        };
        registerReceiver(receiver, filter); // hooking broacast reciever

//        myActivityReceiver= new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent data) {
//                String hexcolor= data.getStringExtra("color");
//                Toast.makeText(context,"Changing Color",Toast.LENGTH_LONG).show();
//                Log.i(TAG,"Color Received ="+ hexcolor);
//                if(null!=hexcolor){
//                   bgroundlyt.setBackgroundColor(Color.parseColor(hexcolor));
//                }
//
//            }
//        };
//        IntentFilter ChangeColorFilter= new IntentFilter(ACTION_CHANGE_COLOR);
//        registerReceiver(myActivityReceiver,ChangeColorFilter);


//        setContentView(R.layout.fragment_navigation_draw);
//        initViews();
//        setAdapter();
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(myActivityReceiver);
    }

    @Override
    protected void onDestroy() {
        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
        super.onDestroy();
    }
    //    public static List<Information> getData() {
//        List<Information> data = new ArrayList<>();
//        int[] icons = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};
//        String[] titles = {"One", "Two", "Three", "Four"};
//
//        for (int i = 0; i < icons.length && i < titles.length; i++) {
//            Information current = new Information();
//            current.iconId = icons[i];
//            current.title = titles[i];
//            data.add(current);
//        }
//        return data;
//    }
//
//    private void initViews() {
//        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    private void setAdapter() {
//        adaptar = new RViewAdaptar(this, getData());
//        recyclerView.setAdapter(adaptar);
//    }
}
