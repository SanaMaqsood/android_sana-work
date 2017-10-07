package com.pk.gov.pitb.oopbasicconcepts.dto;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Sana PC on 8/28/2017.
 */

public class BabyDog extends Dog {

    public BabyDog(Context context) {
        super(context);
    }

    public void weep(){
        Toast.makeText(context,"Bbay Dog is weeping",Toast.LENGTH_LONG).show();
    }
}
