package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by Sana PC on 10/5/2017.
 */

public class WholeAndFractionalValue extends AppCompatActivity {
    EditText edValue;
    TextView tvWhole, tvFractional;
    Button btnWholeFrac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whole_andfractional);

        edValue = (EditText) findViewById(R.id.ed_value);
        tvWhole = (TextView) findViewById(R.id.tv_whole);
        tvFractional = (TextView) findViewById(R.id.tv_fractional);
        btnWholeFrac=(Button) findViewById(R.id.btnWhole_frac);


        btnWholeFrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double value = new Double(edValue.getText().toString());
                BigDecimal wholeValue = BigDecimal.valueOf(value).setScale(0, BigDecimal.ROUND_DOWN);
                double newValue = value - wholeValue.doubleValue();
                BigDecimal FractionValue = BigDecimal.valueOf(newValue).setScale(2, BigDecimal.ROUND_DOWN); /// specified fraction in decimal value

                tvWhole.setText("Whole Value is : "+ wholeValue);
                tvFractional.setText("Fractional Value is :  "+ FractionValue);

            }
        });

    }
}
