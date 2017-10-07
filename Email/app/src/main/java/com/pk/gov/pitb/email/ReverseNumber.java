package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Sana PC on 10/6/2017.
 */

public class ReverseNumber extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reverse_integers);

       initViews();

    }

    private void initViews() {
        final EditText edInterger= (EditText) findViewById(R.id.ed_integer);
        Button btnInteger= (Button) findViewById(R.id.btn_integer);
        final TextView tvInteger= (TextView) findViewById(R.id.tv_integer);



        btnInteger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int inputInteger =Integer.valueOf(edInterger.getText().toString());
                int result = (integerReverse(inputInteger));
                int resultOdd=(integerOddReverse(inputInteger));
                int resultEven=(integerEvenReverse(inputInteger));
                tvInteger.setText("Reverse Integer Numbers are: \n " + result +" \n Odd nos: \n "+resultOdd +" \n Even nos : \n" +resultEven);




            }
        });

    }


    public int integerReverse(int input) {
        int reversedNum=0;
        int last_digit=0;
        while (input != 0) {
            last_digit = input % 10;
            reversedNum = reversedNum * 10 + last_digit;
            input = input / 10;
        }
        return  reversedNum;
    }

    public int integerOddReverse(int input) {
        int reversedNum=0;
        int last_digit=0;
        while (input != 0) {
            if(input %2 !=0)
            {
            last_digit = input % 10;
            reversedNum = reversedNum * 10 + last_digit;
            }
            input = input / 10;
        }
        return  reversedNum;
    }
    public int integerEvenReverse(int input) {
        int reversedNum=0;
        int last_digit=0;
        while (input != 0) {
            if(input %2 ==0)
            {
                last_digit = input % 10;
                reversedNum = reversedNum * 10 + last_digit;
            }
            input = input / 10;
        }
        return  reversedNum;
    }

}
