package com.example.sanapc.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.dto.Information;

import java.util.Collections;
import java.util.List;

/**
 * Created by Sana PC on 6/2/2017.
 */

public class RViewAdaptar extends RecyclerView.Adapter<RViewAdaptar.myViewHoloder> {

    private LayoutInflater inflater;
    private List<Information> data = Collections.emptyList();

    public RViewAdaptar(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public myViewHoloder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = inflater.inflate(R.layout.custom_layout, parent, false);
        myViewHoloder holder = new myViewHoloder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHoloder holder, int position) {
        Information current = data.get(position);
        holder.text.setText(current.title);
        holder.icon.setImageResource(current.iconId);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHoloder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView icon;

        public myViewHoloder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.text_list);
            icon = (ImageView) itemView.findViewById(R.id.icon_list);
        }
    }
}
