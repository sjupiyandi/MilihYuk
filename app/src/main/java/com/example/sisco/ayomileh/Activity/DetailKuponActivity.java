package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.sisco.ayomileh.R;

public class DetailKuponActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btnNonaktifkanKupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kupon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnNonaktifkanKupon = findViewById(R.id.btnNonaktifkanKupon);

        btnNonaktifkanKupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(view.getContext(),PoinKuponActivity.class);
                intentBack.putExtra("message","Penukaran kupon berhasil, anda berhasil mendapatkan diskon.");
                view.getContext().startActivity(intentBack);
                finish();
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this,PoinKuponActivity.class);
        intentBack.putExtra("message","Penukaran kupon dibatalkan");
        this.startActivity(intentBack);
        this.finish();
    }
}
