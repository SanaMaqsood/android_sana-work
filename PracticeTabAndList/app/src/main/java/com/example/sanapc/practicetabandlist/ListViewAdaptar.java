package com.example.sanapc.practicetabandlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/26/2017.
 */

public class ListViewAdaptar extends BaseAdapter {
    Context mcontext;
    ArrayList<Students> mylist;
    public ListViewAdaptar(Context context, ArrayList<Students> mlist) {
        this.mcontext=context;
        this.mylist=mlist;
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
        LayoutInflater inflater= (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row= inflater.inflate(R.layout.inflatedviewoflist,parent,false);
        TextView textName=(TextView) row.findViewById(R.id.tv2);
        TextView textRoll=(TextView) row.findViewById(R.id.tv4);
        TextView textAddress=(TextView) row.findViewById(R.id.tv6);
        TextView textCNic=(TextView) row.findViewById(R.id.tv8);

        textName.setText(mylist.get(position).getSName().toString());
        textRoll.setText(mylist.get(position).getSRoll().toString());
        textAddress.setText(mylist.get(position).getSAddress().toString());
        textCNic.setText(mylist.get(position).getSCNic().toString());


        return row;
    }
}
