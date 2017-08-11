package com.example.sanapc.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanapc.recyclerview.R;

/**
 * Created by Sana PC on 6/16/2017.
 */

public class GridviewAdaptarExample extends BaseAdapter {
    private String  Letters[];
    private int Icons[];
    private Context context;
    private LayoutInflater inflater;

    public GridviewAdaptarExample(Context context, int Icons[], String Letters[]){
        this.context=context;
        this.Letters=Letters;
        this.Icons=Icons;
    }

    @Override
    public int getCount() {
        return Letters.length;
    }

    @Override
    public Object getItem(int position) {
        return Letters[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridview= convertView;
        if (convertView == null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridview= inflater.inflate(R.layout.gridview_customelayout,null);
        }

        ImageView imageView=(ImageView) gridview.findViewById(R.id.imgview);
        TextView textView=(TextView) gridview.findViewById(R.id.textview);

        imageView.setImageResource(Icons[position]);
        textView.setText(Letters[position]);
        return gridview;
    }
}
