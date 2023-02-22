package com.example.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome, mscience,msports,mentairnment, mtechnology,mhealth;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api = "20f97415ea00405c998161a0277a5cc4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        mtoolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(mtoolbar);
        setContentView (R.layout.activity_main);

        mhome = findViewById (R.id.home);
        mscience = findViewById (R.id.science);
        msports = findViewById (R.id.sports);
        mentairnment  = findViewById (R.id.entairnment);
        mtechnology = findViewById (R.id.technology);
        mhealth = findViewById (R.id.health);

        ViewPager viewPager = findViewById (R.id.fragment_container);
        tabLayout = findViewById (R.id.include);

        pagerAdapter = new PagerAdapter (getSupportFragmentManager (),6);
        viewPager.setAdapter (pagerAdapter);
        
        tabLayout.addOnTabSelectedListener (new TabLayout.OnTabSelectedListener () {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem (tab.getPosition ());
                if(tab.getPosition ()==0||tab.getPosition ()==1||tab.getPosition ()==2||tab.getPosition ()==3
                        ||tab.getPosition ()==4||tab.getPosition ()==5){
                    pagerAdapter.notifyDataSetChanged ();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener (new TabLayout.TabLayoutOnPageChangeListener (tabLayout));



    }

    private void setSupportActionBar(Toolbar mtoolbar) {
    }
}