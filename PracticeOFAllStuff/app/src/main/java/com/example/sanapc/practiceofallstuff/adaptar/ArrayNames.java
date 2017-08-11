package com.example.sanapc.practiceofallstuff.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sanapc.practiceofallstuff.R;
import com.example.sanapc.practiceofallstuff.dob.ItemName;

import java.util.ArrayList;

/**
 * Created by Sana PC on 7/18/2017.
 */

public class ArrayNames extends ArrayAdapter<ItemName> {
    Context context;
    ArrayList<ItemName> mList;
    LayoutInflater flater;

    public ArrayNames(Context context, int resouceId, int textViewResourceId, ArrayList<ItemName> itemNames) {
        super(context,resouceId,textViewResourceId, itemNames);
        this.context = context;
        mList = itemNames;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position);
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowview(convertView,position);
    }

    private View rowview(View convertView , int position){

        ItemName rowItem = getItem(position);

        viewHolder holder ;
        View rowview = convertView;
        if (rowview==null) {

            holder = new viewHolder();
            flater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = flater.inflate(R.layout.spinner_name_items, null, false);

            holder.txtTitle = (TextView) rowview.findViewById(R.id.tvname);
            rowview.setTag(holder);
        }else{
            holder = (viewHolder) rowview.getTag();
        }
        holder.txtTitle.setText(rowItem.getName());

        return rowview;
    }

    private class viewHolder{
        TextView txtTitle;

    }

}
