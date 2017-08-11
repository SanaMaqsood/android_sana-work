package com.example.sanapc.recyclerview.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sanapc.recyclerview.R;
import com.example.sanapc.recyclerview.db.StudentDataBaseSQLiteOpenHelper;
import com.example.sanapc.recyclerview.interfaces.RefreshListInterface;

/**
 * Created by Sana PC on 7/7/2017.
 */

public class DeleteAlertBox extends Dialog implements View.OnClickListener {
    EditText editId;
    Button btndelete;
    RefreshListInterface mRefreshListInterface;
    StudentDataBaseSQLiteOpenHelper dbHelper;

    public DeleteAlertBox(Context context, RefreshListInterface mRefreshListInterface, StudentDataBaseSQLiteOpenHelper dbHelper) {
        super(context);
        this.dbHelper = dbHelper;
        this.mRefreshListInterface=mRefreshListInterface;
        setContentView(R.layout.delete_data_activity);
        initValues();
        btndelete.setOnClickListener(this);

    }

    private void initValues() {
        editId = (EditText) findViewById(R.id.EdID);
        btndelete = (Button) findViewById(R.id.btndelete);
    }

    @Override
    public void onClick(View v) {
        dbHelper.deleteRow(Integer.valueOf(editId.getText().toString()));
        mRefreshListInterface.refresh();
        dismiss();
    }
}
