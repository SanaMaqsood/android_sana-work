package com.example.sanapc.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.sanapc.recyclerview.R;

/**1
 * Created by Sana PC on 6/6/2017.
 */

public class LargeImages extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.largeicon);
        int imageRes = getIntent().getExtras().getInt("image");

        imageView = (ImageView) findViewById(R.id.iv_large);
        imageView.setImageResource(imageRes); // imageview setting

    }
}
