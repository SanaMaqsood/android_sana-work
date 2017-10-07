package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sana PC on 10/5/2017.
 */

public class DoubleOrInteger extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.double_or_integer);
          initViews();

    }

    private void initViews() {
        final EditText edIntDouble = (EditText) findViewById(R.id.ed_check);
        final TextView tvDisplay = (TextView) findViewById(R.id.integer_double);
        final Button btnCheck = (Button) findViewById(R.id.btn_check);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = Double.valueOf(edIntDouble.getText().toString());
                if ((isInteger(value)) == true) {
                    tvDisplay.setText("Value is Integer : " + value);
                } else {
                    tvDisplay.setText("Value is not integer : " + value);

                }
            }
        });
    }

    public static boolean isInteger(double value) {
        return Math.ceil(value) == Math.floor(value);
    }
}
