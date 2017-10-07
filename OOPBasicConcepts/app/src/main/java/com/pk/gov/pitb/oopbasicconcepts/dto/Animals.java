package com.pk.gov.pitb.oopbasicconcepts.dto;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Sana PC on 8/26/2017.
 */

public class Animals {
    Context context;

    public Animals(Context context) {
        this.context = context;
    }
// statics variables

    public final int legcounts=2;
    public final int eyescount= 2;
    public void eat(){
        Toast.makeText(context,"Eating..",Toast.LENGTH_LONG).show();
    }
    public void sound(){
        Log.e("Animal","sound");
    }
    public static int count(int eyescount, int legcounts){
        int legs= legcounts;
        int eyes= eyescount;
        return Sum(legs,eyes);
    }
    public final int count(){
         return Sum(eyescount,legcounts);
    }
    private static int Sum(int legcounts, int eyescount){
        int sum= legcounts+eyescount;
        return sum;
    }
}
