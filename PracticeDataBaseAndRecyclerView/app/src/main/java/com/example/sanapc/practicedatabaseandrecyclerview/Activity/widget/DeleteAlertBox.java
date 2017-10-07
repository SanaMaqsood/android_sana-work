package com.example.sanapc.practicedatabaseandrecyclerview.Activity.widget;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.sanapc.practicedatabaseandrecyclerview.Activity.db.StudentSQLiteDatabase;
import com.example.sanapc.practicedatabaseandrecyclerview.Activity.interfaces.Refreshactivity;
import com.example.sanapc.practicedatabaseandrecyclerview.R;

/**
 * Created by Sana PC on 7/11/2017.
 */

public class DeleteAlertBox extends Dialog implements View.OnClickListener{
    Button btnalertdelete;
    EditText editId;
    StudentSQLiteDatabase dbHelper;
    Refreshactivity refreshactivity;
    public DeleteAlertBox(Context context,StudentSQLiteDatabase dbHelper,Refreshactivity refreshactivity) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.delete_alert_box);
        this.dbHelper=dbHelper;
        this.refreshactivity=refreshactivity;
        initViews();
        btnalertdelete.setOnClickListener(this);

    }

    private void initViews() {
        editId=(EditText) findViewById(R.id.editid);
        editId.setTextColor(getContext().getResources().getColor(R.color.red));
        btnalertdelete=(Button) findViewById(R.id.btnalertdelete);
    }

    @Override
    public void onClick(View v) {
        dbHelper.deleteRow(Integer.valueOf(editId.getText().toString()));
        refreshactivity.refresh();
        dismiss();
    }
}
