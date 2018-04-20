package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.sisco.ayomileh.R;

public class DaftarCalonActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    LinearLayout calon1,calon2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_calon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        calon1 = (LinearLayout) findViewById(R.id.calon1);
        calon2 = (LinearLayout) findViewById(R.id.calon2);

        calon1.setOnClickListener(this);
        calon2.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if (view == calon1){
            Intent intent = new Intent(DaftarCalonActivity.this, CalonActivity.class);
            intent.putExtra("no_urut", "0");
            startActivity(intent);
        }else if(view == calon2){
            Intent intent = new Intent(DaftarCalonActivity.this, CalonActivity.class);
            intent.putExtra("no_urut", "1");
            startActivity(intent);
        }
    }
}
