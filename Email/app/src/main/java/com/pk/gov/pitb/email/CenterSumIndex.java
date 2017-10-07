package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Sana PC on 10/3/2017.
 */

public class CenterSumIndex extends AppCompatActivity {
//    private TextView txtView; // we dont need it on global level

//    private int i = 0; // we dont need it on global level

    private int[] array = {3, 3, 3, 4, 5}; // we can take this array from user
    private int j = array.length - 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.center_sum_index);
        // initViews()??

        TextView txtView = (TextView) findViewById(R.id.tv_sum);
        txtView.setText("Pointer Index for sum is :" + getIndexOfSumCenter());


    }

    // name of function should be meaningful not values()???
    public int getIndexOfSumCenter() {
        int i = 0;
        while (i <= j) {
            if (array[i] < array[j]) {
                array[i + 1] = array[i] + array[i + 1];
                i++;
            } else if (array[i] == array[j] && i + j == array.length) {
                break;
            } else {
                array[j - 1] = array[j] + array[j - 1];
                j--;
            }
        }
        return i;
    }

}
