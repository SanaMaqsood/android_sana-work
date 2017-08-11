package com.example.sanapc.recyclerview.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanapc.recyclerview.dto.Information;
import com.example.sanapc.recyclerview.R;

import java.util.List;

/**
 * Created by Sana PC on 6/9/2017.
 */

public class FragmentRecyclerviewAdaptar extends RecyclerView.Adapter<FragmentRecyclerviewAdaptar.myViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    List<Information> myList;

    public FragmentRecyclerviewAdaptar(Context context, List<Information> list) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.myList = list;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = layoutInflater.inflate(R.layout.fregment_custom_cardview, parent, false);
        myViewHolder holder = new myViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        Information current = myList.get(position);
        holder.textView.setText(current.title);
        holder.imageView.setImageResource(current.iconId);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Image View" + myList.get(position), Toast.LENGTH_LONG).show();

            }
        });
        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirm");
                builder.setMessage("Are you Sure ? You Want to Delete item");
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        myList.remove(position);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                return false;
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Text View" + myList.get(position), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;


        public myViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imgview_list);
            textView = (TextView) itemView.findViewById(R.id.tv_list);
        }
    }
}
