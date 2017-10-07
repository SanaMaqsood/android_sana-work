package com.example.sanapc.spinnerexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sana PC on 5/30/2017.
 */

public class CustomeSpinner extends AppCompatActivity {
    Spinner spinner;
    ArrayList<ItemData> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custome_spinner);
        spinner =(Spinner) findViewById(R.id.Spinner);


        list.add(new ItemData("Khbr", R.drawable.meme7));
        list.add(new ItemData("USA", R.drawable.meme8));
        list.add(new ItemData("Pakistan",R.drawable.meme9));

        SpinnerAdaptar adaptar=new SpinnerAdaptar(this,R.layout.custom_spinner_layout,R.id.tv1,list);
        spinner.setAdapter(adaptar);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),((ItemData)spinner.getSelectedItem()).getText()+" selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
