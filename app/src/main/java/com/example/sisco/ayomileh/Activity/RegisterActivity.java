package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    EditText edtUsername, edtPassword, edtKonfirmasi;
    String edtNoKtp, edtNoKk, edtNoTps;
    Button btnDaftar;
    ProgressBar pgbar;

    FirebaseAuth auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtUsername = (EditText) findViewById(R.id.edt_username);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        edtKonfirmasi = (EditText) findViewById(R.id.edt_konfirmasi);
        btnDaftar = (Button) findViewById(R.id.btn_daftar);
        pgbar = (ProgressBar) findViewById(R.id.pgbar);

        btnDaftar.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        Bundle extras = getIntent().getExtras();
        edtNoKtp = extras.getString("no_ktp");
        edtNoKk = extras.getString("no_kk");
        edtNoTps = extras.getString("no_tps");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == btnDaftar){
            btnDaftar.setVisibility(View.GONE);
            pgbar.setVisibility(View.VISIBLE);
            final String email = edtUsername.getText().toString() + "@gmail.com";
            String password = edtPassword.getText().toString();
            String konfirmasi = edtKonfirmasi.getText().toString();

            if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(konfirmasi)){
                Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
                btnDaftar.setVisibility(View.VISIBLE);
                pgbar.setVisibility(View.GONE);
                return;
            }

            if(password.length() < 6){
                Toast.makeText(this, "Password tidak boleh kurang dari 6", Toast.LENGTH_SHORT).show();
                btnDaftar.setVisibility(View.VISIBLE);
                pgbar.setVisibility(View.GONE);
                return;
            }

            if(password.equals(konfirmasi)){
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        database = FirebaseDatabase.getInstance().getReference();
                        writeNewUser(auth.getCurrentUser().getUid(), email);
                        getDataFromDatabase(auth.getCurrentUser().getUid());
                        updateData();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);

                    }
                });
            }else {
                Toast.makeText(this, "Password dan konfirmasi password tidak sama", Toast.LENGTH_SHORT).show();
                btnDaftar.setVisibility(View.VISIBLE);
                pgbar.setVisibility(View.GONE);
                return;
            }
        }
    }

    private void writeNewUser(String userId, String email){
        UserModel users = new UserModel("", "", "", "", "", "", "","");
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + userId, users);
        database.updateChildren(childUpdates);
    }

    private void getDataFromDatabase(String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void updateData(){
        database.child("no_ktp").setValue(edtNoKtp);
        database.child("no_kk").setValue(edtNoKk);
        database.child("no_tps").setValue(edtNoTps);
    }
}
