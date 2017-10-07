package com.example.sanapc.spinnerexample;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/30/2017.
 */

public class SpinnerAdaptar extends ArrayAdapter<ItemData> {


    int groupId;
    Activity context;
    ArrayList<ItemData> list;
    LayoutInflater inflater;

    public SpinnerAdaptar(Activity context, int groupId, int id, ArrayList<ItemData> list) {
        super(context, id, list);
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupId = groupId;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(groupId, parent, false);
        ImageView imgview = (ImageView) row.findViewById(R.id.img);
        imgview.setImageResource(list.get(position).getImgId());
        TextView textView = (TextView) row.findViewById(R.id.tv1);
        textView.setText(list.get(position).getText());
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
