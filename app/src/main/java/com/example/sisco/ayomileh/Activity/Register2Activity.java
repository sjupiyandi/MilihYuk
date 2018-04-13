package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register2Activity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    EditText edtNoKtp, edtNoKk, edtNoTps;
    Button btnDaftar;
    ProgressBar pgbar;

    FirebaseAuth auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtNoKtp = (EditText) findViewById(R.id.edt_no_ktp);
        edtNoKk = (EditText) findViewById(R.id.edt_no_kk);
        edtNoTps = (EditText) findViewById(R.id.edt_no_tps);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        pgbar = (ProgressBar) findViewById(R.id.pgbar);

        btnDaftar.setOnClickListener(this);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if ( view == btnDaftar){
            btnDaftar.setVisibility(View.GONE);
            pgbar.setVisibility(View.VISIBLE);
            final String email = edtNoKtp.getText().toString();
            String password = edtNoKk.getText().toString();
            String konfirmasi = edtNoTps.getText().toString();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(konfirmasi)){
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                btnDaftar.setVisibility(View.VISIBLE);
                pgbar.setVisibility(View.GONE);
                return;
            }else {
                Intent intent = new Intent(Register2Activity.this, RegisterActivity.class);
                intent.putExtra("no_ktp", email);
                intent.putExtra("no_kk", password);
                intent.putExtra("no_tps", konfirmasi);
                startActivity(intent);
                finish();
            }


        }
    }


}
