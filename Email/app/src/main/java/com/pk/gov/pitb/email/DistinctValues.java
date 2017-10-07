package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sana PC on 10/6/2017.
 */

public class DistinctValues extends AppCompatActivity {

    private static final int[] numArray={1,2,3,4,5,6,4,5,1};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.distinct_value);

        TextView distinct=(TextView) findViewById(R.id.distinct);

        int number= (diffValues(numArray));
         distinct.setText("Distinct Values Are ="+number);

    }



    public static int diffValues(int[] numArray){
        int numOfDifferentVals = 0;
        ArrayList<Integer> diffNum = new ArrayList<>();


        for(int i=0; i<numArray.length; i++){
            if(!diffNum.contains(numArray[i])){
                diffNum.add(numArray[i]);
            }
        }

        if(diffNum.size()==1){
            numOfDifferentVals = 0;
        }
        else{
            numOfDifferentVals = diffNum.size();
        }

        return numOfDifferentVals;
    }
}
