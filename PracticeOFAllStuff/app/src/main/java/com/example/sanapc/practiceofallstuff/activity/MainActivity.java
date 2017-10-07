package com.example.sanapc.practiceofallstuff.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sanapc.practiceofallstuff.R;
import com.example.sanapc.practiceofallstuff.fragments.FragmentOne;
import com.example.sanapc.practiceofallstuff.fragments.FragmentTwo;
import com.example.sanapc.practiceofallstuff.interfaces.RefreshItems;

public class MainActivity extends AppCompatActivity implements RefreshItems {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadfragmentone();
        loadfragmenttwo();

    }

    private void loadfragmenttwo() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft2 = fragmentManager.beginTransaction();
        Fragment fragment2 = new FragmentTwo();
        ft2.replace(R.id.fragmenttwo, fragment2);
        ft2.commit();
    }

    private void loadfragmentone() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft1 = fragmentManager.beginTransaction();
        Fragment fragment = new FragmentOne();
        ((FragmentOne) fragment).setmRefreshItems(this);
        ft1.replace(R.id.fragmentone, fragment);
        ft1.commit();
    }


    @Override
    public void refresh() {
        loadfragmenttwo();
    }
}
