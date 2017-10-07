package com.pk.gov.pitb.oopbasicconcepts.dto;

import android.content.Context;
import android.util.Log;

/**
 * Created by Sana PC on 8/26/2017.
 */

public class Dog extends Animals {
    public Dog(Context context) {
        super(context);
    }

    @Override
    public void sound() {
        super.sound();
        Log.e("Dog","bark");
    }

    public void bark(){
        Log.e("Dog","Bark");
    }

}
