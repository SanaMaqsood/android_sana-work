package com.pk.gov.pitb.email;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by Sana PC on 10/4/2017.
 */

public class PalindromActivity extends AppCompatActivity {


    char[] array = {'A', 'B', 'C', 'B', 'A'};
    int i = 0;
    int j = array.length - 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.palindrom_activity);


        if (isPalindrome(array)) {
            Toast.makeText(this, "this string is palindrome", Toast.LENGTH_LONG).show();
        } else {
            // array is not palindrome
        }
    }
    private boolean isPalindrome(char[] arrayChar) {
        int size = arrayChar.length;
        int halfSize = (int) Math.ceil(size / 2);

        int i = 0;
        int j = size - 1;

        for (int a = 0; a <= halfSize; a++) {
            if (arrayChar[i] == arrayChar[j]) {
                i++;
                j--;
                Toast.makeText(this, arrayChar[i] + "==" + arrayChar[j], Toast.LENGTH_SHORT).show();
            } else {
                return false;
            }
        }

        return true;
    }


}
