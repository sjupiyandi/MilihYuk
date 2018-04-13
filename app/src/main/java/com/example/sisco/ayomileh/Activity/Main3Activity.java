package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sisco.ayomileh.R;


public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    Button bDaftar, bMasuk;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bDaftar = (Button) findViewById(R.id.btn_daftar);
        bMasuk = (Button) findViewById(R.id.btn_masuk);

        bDaftar.setOnClickListener(this);
        bMasuk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == bDaftar){
            Intent intent = new Intent(this, Register2Activity.class);
            startActivity(intent);
        }else if (view == bMasuk){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
