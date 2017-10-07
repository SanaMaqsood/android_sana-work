package com.example.sanapc.fragmentpractice;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout tablyout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        final TabLayout.Tab test01 = tablyout.newTab();
        final TabLayout.Tab test02 = tablyout.newTab();
        final TabLayout.Tab test03 = tablyout.newTab();

        test01.setIcon(R.drawable.ww);
        test02.setIcon(R.drawable.www);
        test03.setIcon(R.drawable.wwww);
        test01.setText("Tab 1");
        test02.setText("Tab 2");
        test03.setText("Tab 3");



        tablyout.addTab(test01, 0);
        tablyout.addTab(test02, 1);
        tablyout.addTab(test03, 2);


        tablyout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tablyout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablyout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        test01.setIcon(R.drawable.ww);
                        test02.setIcon(R.drawable.www);
                        test03.setIcon(R.drawable.wwww);
                        break;
                    case 1:
                        test01.setIcon(R.drawable.ww1);
                        test02.setIcon(R.drawable.ww2);
                        test03.setIcon(R.drawable.wwww);
                        break;
                    case 2:
                        test01.setIcon(R.drawable.www1);
                        test02.setIcon(R.drawable.www2);
                        test03.setIcon(R.drawable.wwww);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        tablyout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    private void initview() {
        tablyout = (TabLayout) findViewById(R.id.Tab_Layout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }


}
