package com.example.sanapc.practicetabandlist;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);


        final TabLayout.Tab tab1 = tabLayout.newTab();
        final TabLayout.Tab tab2 = tabLayout.newTab();
        final TabLayout.Tab tab3 = tabLayout.newTab();

        tab1.setIcon(R.drawable.ww);
        tab2.setIcon(R.drawable.www);
        tab3.setIcon(R.drawable.wwww);
        tab1.setText("TAB1");
        tab2.setText("TAB2");
        tab3.setText("TAB3");

        tabLayout.addTab(tab1, 0);
        tabLayout.addTab(tab2, 1);
        tabLayout.addTab(tab3, 2);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selected));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        tab1.setIcon(R.drawable.ww);
                        tab2.setIcon(R.drawable.www);
                        tab3.setIcon(R.drawable.wwww);
                        break;
                    case 1:
                        tab1.setIcon(R.drawable.ww1);
                        tab2.setIcon(R.drawable.ww2);
                        tab3.setIcon(R.drawable.wwww);
                        break;
                    case 2:
                        tab1.setIcon(R.drawable.www1);
                        tab2.setIcon(R.drawable.www2);
                        tab3.setIcon(R.drawable.wwww);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.Tab_Layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    public void notifyDataChange(ArrayList<Students> StudentData){
        viewPagerAdapter.notifyDataSetChanged();
        refreshFragment(StudentData);
    }

    private void refreshFragment(ArrayList<Students> StudentData){
        FragmentManager fm = getSupportFragmentManager();
        if (fm != null) {
            List<Fragment> fragments = fm.getFragments();
            for(int i = fragments.size() - 1; i >= 0; i--){
                Fragment fragment = fragments.get(i);
                if(fragment != null) {
                    if(fragment instanceof TabLayoutTwo) {
                        ((TabLayoutTwo) fragment).resetAdapter(StudentData);
                        // do something
                    }
                    break;
                }
            }
        }
    }
}
