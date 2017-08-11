package com.example.sanapc.studentdatamanagment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by Sana PC on 4/25/2017.
 */

public class DataEntryActivity extends AppCompatActivity {
    String sName, sAddress, sEdu ;
    EditText etName, etAddress, etEdu;
    Button btnAdd, btnDelete, btnShow;
    ArrayList<AddData> Dataentry = new ArrayList<AddData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_entry);
        initView();
        ClickListner();

    }

    private void ClickListner() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataToList();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteDataToList();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showData();
            }
        });
    }

    private void initView() {
        etName = (EditText) findViewById(R.id.edName);
        etAddress = (EditText) findViewById(R.id.edAddress);
        etEdu = (EditText) findViewById(R.id.ededu);
        btnAdd = (Button) findViewById(R.id.btnadd);
        btnDelete = (Button) findViewById(R.id.btndelete);
        btnShow = (Button) findViewById(R.id.btn_show);
    }

    private void AddDataToList() {

        sName = etName.getText().toString();
        sAddress = etAddress.getText().toString();
        sEdu = etEdu.getText().toString();

        AddData addata = new AddData(sName, sAddress, sEdu);
        Dataentry.add(addata);
        Toast.makeText(getApplicationContext(), "Person Added", Toast.LENGTH_LONG).show();
    }

    private void DeleteDataToList() {

        for (int i = 0; i < Dataentry.size(); i++) {
            if (Dataentry.get(i).getName().contains(etName.getText().toString())) {
                Dataentry.remove(i);
                Toast.makeText(getApplicationContext(), "Person Deleted", Toast.LENGTH_LONG).show();
            }
        }
        sName = etName.getText().toString();
        sAddress = etAddress.getText().toString();
        sEdu = etEdu.getText().toString();

        AddData addata = new AddData(sName, sAddress, sEdu);
        Dataentry.remove(addata);
    }

    public void showData() {
        Intent myintent = new Intent(this, ListViewStudentActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable("pass", Dataentry);
        myintent.putExtras(mBundle);
        startActivity(myintent);

    }
}
