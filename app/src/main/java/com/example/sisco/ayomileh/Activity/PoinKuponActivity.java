package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.sisco.ayomileh.Adapter.PoinAdapter;
import com.example.sisco.ayomileh.Fragment.ProfilFragment;
import com.example.sisco.ayomileh.R;

public class PoinKuponActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    private TabLayout tabLayout;
    private ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poin_kupon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//
//        Riwayat -> Poin
//        Redeem -> Kupon
//
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.addTab(tabLayout.newTab().setText("Poin"));
        tabLayout.addTab(tabLayout.newTab().setText("Kupon"));


        PoinAdapter riwayatAdapter = new PoinAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(riwayatAdapter);
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String txtMsg = extras.getString("message");
            viewPager.setCurrentItem(1);
            Toast.makeText(this,txtMsg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    @Override
//    public void onBackPressed() {
//        Intent intentMain = new Intent(this, MainActivity.class);
//        intentMain.putExtra("message",2);
//        this.startActivity(intentMain);
//    }

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
}
