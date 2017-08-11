package com.example.sanapc.practicedatabaseandrecyclerview.Activity.adaptar;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sanapc.practicedatabaseandrecyclerview.Activity.db.StudentSQLiteDatabase;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.dob.Students;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.interfaces.Refreshactivity;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.widget.AddAlertBox;
import com.example.sanapc.practicedatabaseandrecyclerview.R;

import java.util.List;

/**
 * Created by Sana PC on 7/11/2017.
 */

public class StudentListAdaptar extends RecyclerView.Adapter<StudentListAdaptar.myViewHolder> {
    Context context;
    List<Students> mstudents;
    LayoutInflater layoutInflater;
    StudentSQLiteDatabase studentSQLiteDatabase;
    Refreshactivity refreshactivity;

    public StudentListAdaptar(Context context, List<Students> mstudents, StudentSQLiteDatabase studentSQLiteDatabase, Refreshactivity refreshactivity) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.mstudents = mstudents;
        this.studentSQLiteDatabase = studentSQLiteDatabase;
        this.refreshactivity = refreshactivity;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View row = layoutInflater.inflate(R.layout.student_item, parent, false);
        myViewHolder holder = new myViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, final int position) {
        Students current = mstudents.get(position);
        holder.textView.setText(String.valueOf(current.Id)+")");
        holder.textView1.setText(current.Name);
        if (current.Marks >= 50) {
            holder.textView2.setTextColor(context.getResources().getColor(R.color.green));
            holder.textView2.setTextSize(20);
        } else {
            holder.textView2.setTextColor(context.getResources().getColor(R.color.red));
            holder.textView1.setTextColor(context.getResources().getColor(R.color.red));
            holder.textView1.setTypeface(Typeface.DEFAULT_BOLD);
        }
        holder.textView2.setText(String.valueOf(current.Marks));
        holder.btnalertedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAlertBox medit = new AddAlertBox(mstudents.get(position), context, refreshactivity, studentSQLiteDatabase);
                medit.show();
            }
        });

    }

    @Override
    public int getItemCount() {

        return mstudents.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        TextView textView, textView1, textView2;
        Button btnalertedit;

        public myViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview1);
            textView1 = (TextView) itemView.findViewById(R.id.textview2);
            textView2 = (TextView) itemView.findViewById(R.id.textview3);
            btnalertedit = (Button) itemView.findViewById(R.id.edittext);
        }
    }
}
