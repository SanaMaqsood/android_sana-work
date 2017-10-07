package com.example.sanapc.practicetabandlist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Sana PC on 5/25/2017.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int ZERO = 0;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                if (position == ZERO)
                    return new TablayoutOne();
            case 1:
                if (position == ONE)
                    return new TabLayoutTwo();
            case 2:
                if (position == TWO)
                    return new TabLayoutThree();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
