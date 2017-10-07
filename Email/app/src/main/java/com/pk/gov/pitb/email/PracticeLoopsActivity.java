package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sana PC on 10/3/2017.
 */

public class PracticeLoopsActivity extends AppCompatActivity {
//    EditText edText;
//    TextView txtView;
//    Button btnSubmit;
    int i = 0;
    int length;
    int[] array = new int[length];
    int j = array.length - 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_loops);

//        txtView = (TextView) findViewById(R.id.txtView);
//        edText = (EditText) findViewById(R.id.edtxt);
//        btnSubmit=(Button) findViewById(R.id.btnadd);
//
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String string = edText.getText().toString();
//                length = string.length();
//                for (int k = 0; k < length; k++) {
//                    array[k] = Character.getNumericValue(string.charAt(i));
//
//                }
//                txtView.setText("Pointer Index for sum is :" + Value());
//            }
//        });




    }

    public int Value() {
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
