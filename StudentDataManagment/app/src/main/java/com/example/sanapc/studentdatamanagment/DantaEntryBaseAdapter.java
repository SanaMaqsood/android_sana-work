package com.example.sanapc.studentdatamanagment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/15/2017.
 */

public class DantaEntryBaseAdapter extends BaseAdapter {

    Context mycontext;
    ArrayList<AddData> mlist;

    DantaEntryBaseAdapter(Context context, ArrayList<AddData> mlist){
        this.mycontext=context;
        this.mlist=mlist;
    }
    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public AddData getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.student_information,parent,false);

        TextView edName=(TextView) row.findViewById(R.id.tv1);
        TextView edAddress=(TextView) row.findViewById(R.id.tv2);
        TextView edEducation=(TextView) row.findViewById(R.id.tv3);

        edName.setText(mlist.get(position).getName());
        edAddress.setText(mlist.get(position).getAddress());
        edEducation.setText(mlist.get(position).getEducation());

        return row;
    }
}
