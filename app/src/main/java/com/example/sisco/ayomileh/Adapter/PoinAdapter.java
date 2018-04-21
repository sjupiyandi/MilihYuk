package com.example.sisco.ayomileh.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sisco.ayomileh.Fragment.PoinFragment;
import com.example.sisco.ayomileh.Fragment.KuponFragment;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class PoinAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PoinAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                PoinFragment tab1 = new PoinFragment();
                return tab1;
            case 1 :
                KuponFragment tab2 = new KuponFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 :
                return "Poin";
            case 1 :
                return "Kupon";
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
