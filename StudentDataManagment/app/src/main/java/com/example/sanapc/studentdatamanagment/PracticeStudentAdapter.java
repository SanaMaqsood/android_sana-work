package com.example.sanapc.studentdatamanagment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/15/2017.
 */

public class PracticeStudentAdapter extends BaseAdapter {
    Context mcontext;
    ArrayList<PracticeStudentEntry> mylist;

    public PracticeStudentAdapter(Context context, ArrayList<PracticeStudentEntry> mstudent) {

        this.mcontext = context;
        this.mylist = mstudent;
    }
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
        LayoutInflater inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.practicedisplay_activity,parent,false);

        TextView editname=(TextView) row.findViewById(R.id.tv2);
        TextView editroll=(TextView) row.findViewById(R.id.tv4);
        TextView editaddress=(TextView) row.findViewById(R.id.tv6);
        TextView editedu=(TextView) row.findViewById(R.id.tv8);

        editname.setText(mylist.get(position).getsName());
        editroll.setText(mylist.get(position).getsRoll());
        editaddress.setText(mylist.get(position).getsAddress());
        editedu.setText(mylist.get(position).getsEdu());

        return row;
    }
}
