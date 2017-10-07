package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sana PC on 10/4/2017.
 */

public class PalindromeActivity extends AppCompatActivity{
  char [] array={'A','B','C','B','A'};
    int i=0;
    int j= array.length-1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_up_float);

    }
    public char Vslue(){
        while (i<=j){
            if(array[i]==array[j]){
                i++;
                j--;
            }
            else if(i+j==array.length){
                break;
            }
            else {
            }
        }
        return array[i];
    }

}
