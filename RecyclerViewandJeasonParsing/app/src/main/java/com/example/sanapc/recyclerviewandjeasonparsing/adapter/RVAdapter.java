package com.example.sanapc.recyclerviewandjeasonparsing.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sanapc.recyclerviewandjeasonparsing.R;
import com.example.sanapc.recyclerviewandjeasonparsing.dto.DataHospital;

/**
 * Created by Sana PC on 7/25/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyHendler> {
    LayoutInflater inflater;
    private DataHospital mData = new DataHospital();
    String name, email, contact, city, country;

    public RVAdapter(Context context, DataHospital mData) {
        this.context = context;
        this.mData = mData;
    }

    Context context;


    @Override
    public MyHendler onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = (LayoutInflater) inflater.from(context);
        View row = inflater.inflate(R.layout.hospital_items, parent, false);
        MyHendler holder=new MyHendler(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHendler holder, int position) {
        name = mData.getHospitals().get(position).getName();
        email = mData.getHospitals().get(position).getEmail();
        contact = mData.getHospitals().get(position).getContact();
        city = mData.getHospitals().get(position).getCity();
        country = mData.getHospitals().get(position).getCountry();
        holder.textView.setText(name);
        holder.textView1.setText(email);
        holder.textView2.setText(contact);
        holder.textView3.setText(city);
        holder.textView4.setText(country);

    }

    @Override
    public int getItemCount() {
        return mData.getHospitals().size();
    }

    class MyHendler extends RecyclerView.ViewHolder {
        TextView textView, textView1, textView2, textView3, textView4;

        public MyHendler(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_name);
            textView1 = (TextView) itemView.findViewById(R.id.tv_email);
            textView2 = (TextView) itemView.findViewById(R.id.tv_contact);
            textView3 = (TextView) itemView.findViewById(R.id.tv_city);
            textView4 = (TextView) itemView.findViewById(R.id.tv_country);
        }
    }
}
