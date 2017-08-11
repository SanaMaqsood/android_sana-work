package com.example.sanapc.practiceofallstuff.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.sanapc.practiceofallstuff.R;
import com.example.sanapc.practiceofallstuff.dob.ItemModels;

import java.util.ArrayList;

/**
 * Created by Sana PC on 7/18/2017.
 */

public class ArrayModels extends ArrayAdapter<ItemModels> {
    Context context;
    ArrayList<ItemModels> listItem;
    LayoutInflater flater;

   public ArrayModels(Context context, int resouceId, int textViewResourceId, ArrayList<ItemModels> mlist) {
        super(context,resouceId,textViewResourceId,mlist);
        this.context = context;
        this.listItem = mlist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return rowView(convertView, position);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return rowView(convertView, position);
    }

    private View rowView(View convertView, int position) {
        ItemModels Models = getItem(position);
        viewModelHolder holder;
        View rowView = convertView;
        if (rowView == null) {
            holder = new viewModelHolder();
            flater = (LayoutInflater) getContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            rowView = flater.inflate(R.layout.spinner_model_items, null, false);
            holder.textmodel = (TextView) rowView.findViewById(R.id.tvmodel);
            rowView.setTag(holder);
        } else {
            holder = (viewModelHolder) rowView.getTag();
        }
        holder.textmodel.setText(Models.getModel());
        return rowView;
    }
    private class viewModelHolder {
        TextView textmodel;

    }
}
