package com.example.sanapc.practicetabandlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/25/2017.
 */

public class TablayoutOne extends Fragment {
    private FloatingActionButton fab;
    EditText editName, editRoll, editAddress, editCNic;
    Button btnAdd, btnDelete, btnShow;
    ArrayList<Students> StudentData = new ArrayList<>();
    String sName, sRoll, sAddress, scNic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tablayoutfirst, container, false);
        initViews(v);
        onClick();
        return v;
    }

    private void onClick() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDataToLList();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeletDataToList();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Wellcome to application", Toast.LENGTH_LONG).show();

            }
        });
//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showData();
//
//            }
//        });

    }

//    private void showData() {
//        Intent myIntent;
//        myIntent = new Intent(getActivity(), TabLayoutTwo.class);
//        Bundle myBundle = new Bundle();
//        myBundle.putSerializable("pass", StudentData);
//        myIntent.putExtras(myBundle);
//        startActivity(myIntent);

//    }

    private void DeletDataToList() {
        for (int i = 0; i < StudentData.size(); i++) {
            if (StudentData.get(i).SName.contains(editName.getText().toString())) {
                StudentData.remove(i);
                Toast.makeText(getActivity(), "Person Deleted", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void AddDataToLList() {
        sName = editName.getText().toString();
        sRoll = editRoll.getText().toString();
        sAddress = editAddress.getText().toString();
        scNic = editCNic.getText().toString();
        Students addData = new Students(sName, sRoll, sAddress, scNic);
        StudentData.add(addData);
        ((MainActivity) getActivity()).notifyDataChange(StudentData);
        Toast.makeText(getActivity(), "Person Added", Toast.LENGTH_LONG).show();
    }

    private void initViews(View view) {
        fab=(FloatingActionButton) view.findViewById(R.id.fab);
        editName = (EditText) view.findViewById(R.id.edit1);
        editRoll = (EditText) view.findViewById(R.id.edit2);
        editAddress = (EditText) view.findViewById(R.id.edit3);
        editCNic = (EditText) view.findViewById(R.id.edit4);
        btnAdd = (Button) view.findViewById(R.id.btnadd);
        btnDelete = (Button) view.findViewById(R.id.btndelete);
//        btnShow = (Button) view.findViewById(R.id.btnshow);
    }


    public ArrayList<Students> getStudentData() {
        return StudentData;
    }
}
