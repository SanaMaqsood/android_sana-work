package com.example.sanapc.practiceofallstuff.adaptar;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sanapc.practiceofallstuff.R;
import com.example.sanapc.practiceofallstuff.interfaces.RefreshItems;
import com.example.sanapc.practiceofallstuff.db.SQLiteCarItemsDb;
import com.example.sanapc.practiceofallstuff.dob.CarItems;

import java.util.List;

/**
 * Created by Sana PC on 7/18/2017.
 */

public class CarItemAdaptar extends RecyclerView.Adapter<CarItemAdaptar.myHolder> {
    LayoutInflater inflater;
    List<CarItems> myItems;
    SQLiteCarItemsDb sqLiteCarItemsDb;
    Context context;

    public CarItemAdaptar(Context context, List<CarItems> myItems, SQLiteCarItemsDb sqLiteCarItemsDb) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.myItems=myItems;
        this.sqLiteCarItemsDb=sqLiteCarItemsDb;
    }

    @Override
    public myHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.car_items, parent, false);
        myHolder holder= new myHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(myHolder holder, int position) {
        CarItems current=myItems.get(position);
        holder.id.setText(Integer.valueOf(current.id).toString());
        holder.name.setText(current.name);
        holder.model.setText(current.model);
        holder.year.setText(current.year);
        holder.regNo.setText(current.regNo);

    }

    @Override
    public int getItemCount() {
        return myItems.size();
    }

    class myHolder extends RecyclerView.ViewHolder {
        TextView id,name, model, year, regNo;

        public myHolder(View itemView) {
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.item_id);
            name = (TextView) itemView.findViewById(R.id.item_name);
            model=(TextView) itemView.findViewById(R.id.item_model);
            year=(TextView) itemView.findViewById(R.id.item_year);
            regNo=(TextView) itemView.findViewById(R.id.item_Reg_no);
        }
    }

}
