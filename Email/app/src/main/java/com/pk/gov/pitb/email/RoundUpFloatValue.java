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

public class RoundUpFloatValue extends AppCompatActivity {

    EditText edInput;
    TextView tvShow;
    Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_up_float);

        edInput = (EditText) findViewById(R.id.ed_input);
        tvShow = (TextView) findViewById(R.id.tv_show);
        btnSubmit = (Button) findViewById(R.id.btnsubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float value = Float.valueOf(edInput.getText().toString());
                int i = Math.round(value);
                tvShow.setText("Result is =" + i);
            }
        });
    }
}
