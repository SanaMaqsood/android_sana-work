package com.example.sanapc.spinnerexample;

import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by Sana PC on 5/30/2017.
 */

public class ItemData implements Serializable {
    String text;
    Integer imgId;

    public ItemData(String text, Integer imgId) {
        this.text = text;
        this.imgId = imgId;
    }

    public String getText() {
        return text;
    }

    public Integer getImgId() {
        return imgId;
    }
}
