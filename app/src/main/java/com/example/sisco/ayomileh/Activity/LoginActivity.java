package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.sisco.ayomileh.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    EditText edtUsername, edtPassword;
    Button btnMasuk;
    TextView txtDaftar;
    ProgressBar pgBar;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        btnMasuk = (Button) findViewById(R.id.btn_masuk);
        pgBar = (ProgressBar) findViewById(R.id.pgbar);

        btnMasuk.setOnClickListener(this);
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == btnMasuk){
            pgBar.setVisibility(View.VISIBLE);
            btnMasuk.setVisibility(View.GONE);
            auth.signInWithEmailAndPassword(edtUsername.getText().toString()+ "@gmail.com", edtPassword.getText().toString()).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        // there was an error
                        if(edtPassword.getText().toString().length() < 6){
                            Toast.makeText(LoginActivity.this, "Password salah", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Email atau password salah", Toast.LENGTH_SHORT).show();
                        }
                        pgBar.setVisibility(View.GONE);
                        btnMasuk.setVisibility(View.VISIBLE);
                    } else {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }
}
