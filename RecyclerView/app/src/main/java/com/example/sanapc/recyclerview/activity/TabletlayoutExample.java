package com.example.sanapc.recyclerview.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sanapc.recyclerview.R;

/**
 * Created by Sana PC on 6/19/2017.
 */

public class TabletlayoutExample extends AppCompatActivity implements View.OnClickListener {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnplus,btnminus,btnmulti,btndiv,btnback, btnequal;
    TextView Result;
    //    EditText edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9, edit0;
   // String one, two, three, four, five, six;
    EditText EdText1;
    int Res;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelyout);
        intViews();
    }


    private void intViews() {
        EdText1 = (EditText) findViewById(R.id.et_text);
        Result = (TextView) findViewById(R.id.result);
        btn1 = (Button) findViewById(R.id.one);
        btn2 = (Button) findViewById(R.id.two);
        btn3 = (Button) findViewById(R.id.three);
        btn4 = (Button) findViewById(R.id.four);
        btn5 = (Button) findViewById(R.id.five);
        btn6 = (Button) findViewById(R.id.six);
        btn7 = (Button) findViewById(R.id.seven);
        btn8 = (Button) findViewById(R.id.eight);
        btn9 = (Button) findViewById(R.id.nine);
        btn0 = (Button) findViewById(R.id.zero);
        btnback = (Button) findViewById(R.id.back);
        btnplus = (Button) findViewById(R.id.plus);
        btnminus=(Button) findViewById(R.id.minus);
        btnmulti=(Button) findViewById(R.id.times);
        btndiv=(Button) findViewById(R.id.divide);
        btnequal = (Button) findViewById(R.id.equal);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmulti.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnback.setOnClickListener(this);
        btnequal.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        //String num1=EdText1.getText().toString();
        //  String num2= EdText2.getText().toString();

        switch (v.getId()) {
            case R.id.one:
                EdText1.setText(EdText1.getText() + btn1.getText().toString());
                break;
            case R.id.two:
                EdText1.setText(EdText1.getText() + btn2.getText().toString());

                break;
            case R.id.three:
                EdText1.setText(EdText1.getText() + btn3.getText().toString());

                break;
            case R.id.four:
                EdText1.setText(EdText1.getText() + btn4.getText().toString());

                break;
            case R.id.five:
                EdText1.setText(EdText1.getText() + btn5.getText().toString());

                break;
            case R.id.six:
                EdText1.setText(EdText1.getText() + btn6.getText().toString());

                break;
            case R.id.seven:
                EdText1.setText(EdText1.getText() + btn7.getText().toString());

                break;
            case R.id.eight:
                EdText1.setText(EdText1.getText() + btn8.getText().toString());

                break;
            case R.id.nine:
                EdText1.setText(EdText1.getText() + btn9.getText().toString());

                break;
            case R.id.zero:
                EdText1.setText(EdText1.getText() + btn0.getText().toString());

                break;
            case R.id.plus:
                EdText1.setText(EdText1.getText() + btnplus.getText().toString());
                break;
            case R.id.minus:
                EdText1.setText(EdText1.getText() + btnminus.getText().toString());
                break;
            case R.id.times:
                EdText1.setText(EdText1.getText() + btnmulti.getText().toString());
                break;
            case R.id.divide:
                EdText1.setText(EdText1.getText() + btndiv.getText().toString());
                break;
            case R.id.back:
                EdText1.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.equal:
                functions();
                break;
          //  default:

//                if(EdText1.getText().toString().contains("+")){
//                   int pos= EdText1.getText().toString().indexOf("+");
//
//                    int first=Integer.valueOf(EdText1.getText().toString().substring(0,pos-1));
//                    int second=Integer.valueOf(EdText1.getText().toString().substring(pos+1,EdText1.getText().toString().length()));
//
//                    int and=first+second;
//
//                }
            //    break;
        }


    }

    public void functions() {
        float Res = 0;
        if (EdText1.getText().toString().contains("+")) {
            int pos = EdText1.getText().toString().indexOf("+");

            int first = Integer.valueOf(EdText1.getText().toString().substring(0, pos));
            int second = Integer.valueOf(EdText1.getText().toString().substring(pos + 1, EdText1.getText().toString().length()));

             Res = first + second;
        }
        else
        if (EdText1.getText().toString().contains("-")) {
            int pos = EdText1.getText().toString().indexOf("-");

            int first = Integer.valueOf(EdText1.getText().toString().substring(0, pos));
            int second = Integer.valueOf(EdText1.getText().toString().substring(pos + 1, EdText1.getText().toString().length()));

             Res = first - second;
        }
        else
        if (EdText1.getText().toString().contains("*")) {
            int pos = EdText1.getText().toString().indexOf("*");

            int first = Integer.valueOf(EdText1.getText().toString().substring(0, pos));
            int second = Integer.valueOf(EdText1.getText().toString().substring(pos + 1, EdText1.getText().toString().length()));

            Res = first * second;
        }
        else
        if (EdText1.getText().toString().contains("/")) {
            int pos = EdText1.getText().toString().indexOf("/");

            int first = Integer.valueOf(EdText1.getText().toString().substring(0, pos));
            int second = Integer.valueOf(EdText1.getText().toString().substring(pos + 1, EdText1.getText().toString().length()));

            Res = first / second;
        }
        Result.setText(String.valueOf(Res));
        Toast.makeText(getApplicationContext(),""+Result.getText(),Toast.LENGTH_LONG ).show();
    }
}
