package com.example.sanapc.studentdatamanagment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/15/2017.
 */

public class BaseAdapterPractice extends BaseAdapter {


    private Context mcontext;
    private ArrayList<Student> mlist;

    public BaseAdapterPractice(Context context, ArrayList<Student> mstudent) {

        this.mcontext = context;
        this.mlist = mstudent;
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.mylistview_activity, parent, false);


        TextView tvName = (TextView) row.findViewById(R.id.tview1);
        TextView tvRollno = (TextView) row.findViewById(R.id.tView2);

        tvName.setText(mlist.get(position).getName());
        tvRollno.setText(mlist.get(position).getRoolNo());


        return row;
    }
}
