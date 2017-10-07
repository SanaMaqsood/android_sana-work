package com.example.sanapc.studentdatamanagment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/16/2017.
 */

public class ListviewBaseClassPrectice extends BaseAdapter {
    Context mcontext;
    ArrayList<PracticeStudentEntry> mylist;

    public ListviewBaseClassPrectice(Context mcontext, ArrayList<PracticeStudentEntry> mylist) {
        this.mcontext = mcontext;
        this.mylist = mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return mylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=  (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.practicedisplay_activity,parent,false);

        TextView tname=(TextView) row.findViewById(R.id.tv2);
        TextView troll=(TextView) row.findViewById(R.id.tv4);
        TextView tadd=(TextView) row.findViewById(R.id.tv6);
        TextView tedu=(TextView) row.findViewById(R.id.tv8);

        tname.setText(mylist.get(position).getsName().toString());
        troll.setText(mylist.get(position).getsRoll().toString());
        tadd.setText(mylist.get(position).getsAddress().toString());
        tedu.setText(mylist.get(position).getsEdu().toString());



        return row;
    }
}
