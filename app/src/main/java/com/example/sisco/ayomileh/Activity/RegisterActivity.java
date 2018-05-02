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
    String nama,alamat ,edtNoKtp, edtNoKk, edtNoTps, jenis_kelamin,id;
    Button btnDaftar;
    ProgressBar pgbar;
    TextView error;

    FirebaseAuth auth;
    DatabaseReference database,databases;

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
        error = (TextView) findViewById(R.id.txt_error);

        btnDaftar.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        Bundle extras = getIntent().getExtras();
        nama = extras.getString("nama");
        alamat = extras.getString("alamat");
        edtNoKtp = extras.getString("no_ktp");
        edtNoKk = extras.getString("no_kk");
        edtNoTps = extras.getString("no_tps");
        jenis_kelamin = extras.getString("jenis_kelamin");
        id = extras.getString("id");

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
                error.setText("Data tidak boleh kosong");
                btnDaftar.setVisibility(View.VISIBLE);
                pgbar.setVisibility(View.GONE);
                return;
            }

            if(password.length() < 6){
                error.setText("Password tidak boleh kurang dari 6");
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
                        getDataFromDatabase(auth.getCurrentUser().getUid(),id);
                        updateData();
                        Intent intent = new Intent(RegisterActivity.this, EditProfileActivity.class);
                        startActivity(intent);

                    }
                });
            }else {
                error.setText("Password dan konfirmasi password tidak sama");
                btnDaftar.setVisibility(View.VISIBLE);
                pgbar.setVisibility(View.GONE);
                return;
            }
        }
    }

    private void writeNewUser(String userId, String email){
        UserModel users = new UserModel("", "", "", "", "", "", "","","");
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + userId, users);
        database.updateChildren(childUpdates);
    }

    private void getDataFromDatabase(String userId, String id){
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

        databases = FirebaseDatabase.getInstance().getReference("tps/1/DaftarPemilih/" + id);
        databases.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                databases.child("app").setValue("true");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void updateData(){
        database.child("nama").setValue(nama);
        database.child("alamat").setValue(alamat);
        database.child("no_ktp").setValue(edtNoKtp);
        database.child("no_kk").setValue(edtNoKk);
        database.child("no_tps").setValue(edtNoTps);
        database.child("jenis_kelamin").setValue(jenis_kelamin);
        database.child("status").setValue("Belum Memilih");
        database.child("point").setValue("0");
    }
}
