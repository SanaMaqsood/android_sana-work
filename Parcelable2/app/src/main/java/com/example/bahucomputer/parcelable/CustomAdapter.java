package com.example.bahucomputer.parcelable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class CustomAdapter extends BaseAdapter {


    Context context;
    ArrayList<com.example.bahucomputer.parcelable.Student> studentArrayList;

    public CustomAdapter(Context mContext, ArrayList<com.example.bahucomputer.parcelable.Student> studentArrayList) {

        this.context = mContext;
        this.studentArrayList = studentArrayList;
    }


    @Override
    public int getCount() {
        return studentArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return studentArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = view;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.customrow, null);

        }

        TextView studentName = (TextView) v.findViewById(R.id.studentName);
        TextView studentregistration = (TextView) v.findViewById(R.id.studentregistration);

        studentName.setText(studentArrayList.get(i).getName());
        studentregistration.setText(studentArrayList.get(i).getRegistration());

        return v;
    }
}