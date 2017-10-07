package com.example.sanapc.recyclerview.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.TextView;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.activity.StudentDataActivity;
import com.example.sanapc.recyclerview.db.StudentDBHelper;
import com.example.sanapc.recyclerview.db.StudentDataBaseSQLiteOpenHelper;
import com.example.sanapc.recyclerview.dto.Information;
import com.example.sanapc.recyclerview.dto.Student;
import com.example.sanapc.recyclerview.interfaces.RefreshListInterface;
import com.example.sanapc.recyclerview.widget.AddAlertBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana PC on 7/4/2017.
 */

public class RecyclerShowStudentData extends RecyclerView.Adapter<RecyclerShowStudentData.myView> {
    private LayoutInflater inflater;
    private List<Student> mstudent;
    private Context context;
    RefreshListInterface refreshListInterface;
    private StudentDataBaseSQLiteOpenHelper studentDataBaseSQLiteOpenHelper;

    public RecyclerShowStudentData(Context context,List<Student> mstudent, StudentDataBaseSQLiteOpenHelper studentDBHelper, RefreshListInterface refreshListInterface) {
        inflater = LayoutInflater.from(context);
        this.mstudent = mstudent;
        this.context = context;
        this.studentDataBaseSQLiteOpenHelper=studentDBHelper;
        this.refreshListInterface = refreshListInterface;
    }

    @Override
    public myView onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(context);
        View row = inflater.inflate(R.layout.student_custom_item, parent, false);
        myView holder = new myView(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(myView holder, final int position) {
        final Student current = mstudent.get(position);
        holder.textView1.setText(String.valueOf(current.id));
        holder.textView2.setText(current.name);
        holder.textView3.setText(String.valueOf(current.marks));
        holder.btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAlertBox medit= new AddAlertBox(mstudent.get(position),context,refreshListInterface,studentDataBaseSQLiteOpenHelper);
                medit.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mstudent.size();
    }

    class myView extends RecyclerView.ViewHolder{
        TextView textView1,textView2,textView3;
        Button btnedit;
        public myView(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.id_list);
            textView2 = (TextView) itemView.findViewById(R.id.name_list);
            textView3 = (TextView) itemView.findViewById(R.id.marks_list);
            btnedit=(Button) itemView.findViewById(R.id.btnedit);

        }
    }
}
