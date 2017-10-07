package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sana PC on 10/5/2017.
 */

public class DecimalFormat extends AppCompatActivity {
//    //    int[] numArray={1,2,3,4,5,6,4,5,1};
//    int input = 12345;
//    int last_digit = 0;
//    int reversedNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int x = Math.abs(-5878778);  // for integer use Math.abs
        int number= -8786678;
        number = (number < 0 ? -number : number);

        //for float

        float y = -178.978f <= 0.0f ? - 1.0f* - 178.978f : 0.0f; // float










//        while (input != 0) {
//            last_digit = input % 10;
////            if (last_digit % 2 != 0) {
//            reversedNum = reversedNum * 10 + last_digit;
//
////            }
//            input = input / 10;
//        }

//        int nuber= (diffValues(numArray));


//      float value= 97.8877f;
//        BigDecimal wholeValue = BigDecimal.valueOf(value).setScale(2, BigDecimal.ROUND_DOWN);
//        double newValue = value - wholeValue.doubleValue();
//        BigDecimal Fraction = BigDecimal.valueOf(newValue).setScale(2, BigDecimal.ROUND_DOWN);


//        Double toBeTruncated = new Double("2.25989809");
//
//        Double truncatedDouble=new BigDecimal(toBeTruncated ).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();

//        DecimalFormat df = new DecimalFormat("0.00");
//        df.format(55.544545);

    }
//
//    public static int diffValues(int[] numArray) {
//        int numOfDifferentVals = 0;
//        ArrayList<Integer> diffNum = new ArrayList<>();
//
//        for (int i = 0; i < numArray.length; i++) {
//            if (!diffNum.contains(numArray[i])) {
//                diffNum.add(numArray[i]);
//            }
//        }
//
//        if (diffNum.size() == 1) {
//            numOfDifferentVals = 0;
//        } else {
//            numOfDifferentVals = diffNum.size();
//        }
//
//        return numOfDifferentVals;
//    }
}
