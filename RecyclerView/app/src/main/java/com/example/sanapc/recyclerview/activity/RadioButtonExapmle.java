package com.example.sanapc.recyclerview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.sanapc.recyclerview.R;

/**
 * Created by Sana PC on 6/16/2017.
 */

public class RadioButtonExapmle extends AppCompatActivity implements View.OnClickListener {
    RadioButton rbHina, rbSana, rbSidra;
    RadioGroup Rgbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobuttonexample);
        initView();


      /*  rbHina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                Toast.makeText(getBaseContext(), "This is" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        rbSana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                Toast.makeText(getBaseContext(), "This is" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        rbSidra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                Toast.makeText(getBaseContext(), "This is" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });*/
        rbHina.setOnClickListener(this);
        rbSana.setOnClickListener(this);
        rbSidra.setOnClickListener(this);

      //  RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rbgroup);
        Rgbtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) findViewById(checkedId);
                Toast.makeText(getBaseContext(), "This is" + rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void initView() {
        Rgbtn = (RadioGroup) findViewById(R.id.rbgroup);
        rbHina = (RadioButton) findViewById(R.id.rbtn1);
        rbSana = (RadioButton) findViewById(R.id.rbtn2);
        rbSidra = (RadioButton) findViewById(R.id.rbtn3);
    }

    @Override
     public void onClick(View v) {
      if(v instanceof RadioButton) {
//            RadioButton rb = (RadioButton) v;
//            Toast.makeText(getBaseContext(), "This is" + rb.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
