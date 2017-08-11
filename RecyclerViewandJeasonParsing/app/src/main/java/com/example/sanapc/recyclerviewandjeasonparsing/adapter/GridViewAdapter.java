package com.example.sanapc.recyclerviewandjeasonparsing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.sanapc.recyclerviewandjeasonparsing.R;

/**
 * Created by Sana PC on 7/27/2017.
 */

public class GridViewAdapter extends BaseAdapter{
    private Context context;
    private Integer[] showimages={R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
    R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine,R.drawable.eleven,
    R.drawable.twelve,R.drawable.thirteen,R.drawable.fourteen,R.drawable.fifteen,R.drawable.sixteen,
    R.drawable.seventeen,R.drawable.eighteen,R.drawable.ninghteen,R.drawable.tweenteen};
   public GridViewAdapter(Context c){
       this.context=c;

    }

    @Override
    public int getCount() {
        return showimages.length;
    }

    @Override
    public Object getItem(int position) {
        return showimages[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(150,100));
        imageView.setImageResource(showimages[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8,8,8,8);
        return imageView;
    }

}
