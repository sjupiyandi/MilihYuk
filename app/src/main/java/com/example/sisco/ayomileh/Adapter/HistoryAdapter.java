package com.example.sisco.ayomileh.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sisco.ayomileh.Fragment.HistoryFragment;
import com.example.sisco.ayomileh.Fragment.RedeemFragment;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class HistoryAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public HistoryAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                HistoryFragment tab1 = new HistoryFragment();
                return tab1;
            case 1 :
                RedeemFragment tab2 = new RedeemFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 :
                return "Riwayat";
            case 1 :
                return "Redeem";
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
