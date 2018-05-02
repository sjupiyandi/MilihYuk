package com.example.sisco.ayomileh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sisco.ayomileh.R;

public class BelumTerdaftarActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    EditText edt_noktp;
    Button ubahstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belum_terdaftar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edt_noktp = (EditText) findViewById(R.id.edt_no_ktp);
        ubahstatus = (Button) findViewById(R.id.ubah_status);

        ubahstatus.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    @Override
    public void onClick(View view) {
        if (view == ubahstatus){
            onBackPressed();
            Toast.makeText(getApplicationContext(), "Ubah Status Berhasil",Toast.LENGTH_SHORT).show();
        }
    }
}
