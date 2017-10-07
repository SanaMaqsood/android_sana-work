package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.math.BigDecimal;

/**
 * Created by Sana PC on 10/5/2017.
 */

public class FlotSpecifiedDecimal extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float value= 97.8877f;
        BigDecimal wholeValue = BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_DOWN);

    }
}
