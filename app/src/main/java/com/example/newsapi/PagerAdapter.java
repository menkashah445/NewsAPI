package com.example.newsapi;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;


    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super (fm, behavior);
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new homefragment ();

            case 1:
                return new Sciencefragments ();
            case 2:
                return new EntairnmentsFragments ();
            case 3:
                return new technologyfragments ();
            case 4:
                return new Sportsfragments ();
            case 5:
                return new healthfrag ();

            default:
                return null;

        }
    }

    @Override
    public int getCount() {

        return tabcount;
    }
}
