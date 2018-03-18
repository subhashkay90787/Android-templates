package com.example.subhash.journal;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TabLayout mytab;
    ViewPager mypager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytab=(TabLayout)findViewById(R.id.mytab);
        mypager=(ViewPager)findViewById(R.id.mypager);
        mypager.setAdapter(new MyOwnPagerAdapter(getSupportFragmentManager()));
        mytab.setupWithViewPager(mypager);
        mytab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mypager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    class MyOwnPagerAdapter extends FragmentPagerAdapter {

        String data[]={"Write","Archives",};

        public MyOwnPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0)
            {
                return new First();
            }
            else if(position==1)
            {
                return new Third();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }
}
