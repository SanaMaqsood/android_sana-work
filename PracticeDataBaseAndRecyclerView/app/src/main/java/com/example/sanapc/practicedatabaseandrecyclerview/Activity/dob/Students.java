package com.example.sanapc.practicedatabaseandrecyclerview.Activity.dob;

import android.support.v7.widget.RecyclerView;

import java.io.Serializable;

/**
 * Created by Sana PC on 7/11/2017.
 */

public class Students implements Serializable {
    public int Id, Marks;
    public String Name;

    public Students(int id, String name, int marks) {
        this.Id=id;
        this.Name= name;
        this.Marks=marks;
    }
}
