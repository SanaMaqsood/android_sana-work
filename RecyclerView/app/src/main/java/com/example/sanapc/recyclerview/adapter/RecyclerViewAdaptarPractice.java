package com.example.sanapc.recyclerview.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.activity.LargeImages;
import com.example.sanapc.recyclerview.dto.Information;

import java.util.List;

/**
 * Created by Sana PC on 6/6/2017.
 */

public class RecyclerViewAdaptarPractice extends RecyclerView.Adapter<RecyclerViewAdaptarPractice.myViewHolder> {
    private LayoutInflater inflater;
    private List<Information> data;
    private Context context;


    public RecyclerViewAdaptarPractice(Context context, List<Information> data) {
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;

    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = inflater.inflate(R.layout.custom_layout_practice, parent, false);
        myViewHolder holder = new myViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, final int position) {
        Information current = data.get(position);
        holder.textView.setText(current.title);
        holder.imageView.setImageResource(current.iconId);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(context, LargeImages.class);
                mainIntent.putExtra("image", data.get(position).iconId);
                context.startActivity(mainIntent);
                Toast.makeText(context, "Image View", Toast.LENGTH_LONG).show();
            }
        });

        holder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirm");
                builder.setMessage("Are You Sure? You want to Delete it?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        data.remove(position);
                        notifyDataSetChanged();// adapter fresh the list
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
                // dialogue box
                // after pressing yes delete the item and refresh the list

                return false;
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "This is a TextView:  " + data.get(position).title, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class myViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public myViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tvList);
            imageView = (ImageView) itemView.findViewById(R.id.imgList);
        }

    }
}
