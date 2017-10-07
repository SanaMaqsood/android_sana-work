package com.example.sanapc.fragmentpractice;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sana PC on 5/18/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (position == 0)
                    return new TabFragment();
                break;
            case 1:
                if (position == 1)
                    return new TabFragmentTwo();
                break;
            case 2:
                if (position == 2)
                    return new TabFragmentThree();
                break;


        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
