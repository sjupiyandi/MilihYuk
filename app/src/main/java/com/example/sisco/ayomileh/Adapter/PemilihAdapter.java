package com.example.sisco.ayomileh.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.sisco.ayomileh.Fragment.BelumFragment;
import com.example.sisco.ayomileh.Fragment.SudahFragment;

/**
 * Created by LENOVO on 14/04/2018.
 */

public class PemilihAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    public PemilihAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                BelumFragment tab1 = new BelumFragment();
                return tab1;
            case 1 :
                SudahFragment tab2 = new SudahFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 :
                return "Belum Memilih";
            case 1 :
                return "Sudah Memilih";
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
