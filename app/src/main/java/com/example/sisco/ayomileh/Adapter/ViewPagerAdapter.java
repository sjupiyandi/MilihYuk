package com.example.sisco.ayomileh.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sisco.ayomileh.Fragment.EventFragment;
import com.example.sisco.ayomileh.Fragment.InfoFragment;
import com.example.sisco.ayomileh.Fragment.ProfilFragment;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    //Constructor to the class
    public ViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount = tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                EventFragment tab1 = new EventFragment();
                return tab1;
            case 1:
                InfoFragment tab2 = new InfoFragment();
                return tab2;
            case 2:
                ProfilFragment tab3 = new ProfilFragment();
                return tab3;



            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
