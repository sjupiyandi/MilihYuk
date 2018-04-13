package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;

public class EditProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    FirebaseAuth auth;
    DatabaseReference database;

    EditText edtNama, edtNohp, edtAlamat;
    Button btnSave, btnAva;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtNohp = (EditText) findViewById(R.id.edt_no_hp);
        edtAlamat = (EditText) findViewById(R.id.edt_alamat);

        btnSave = (Button) findViewById(R.id.btn_save);
        btnAva = (Button) findViewById(R.id.btn_ava);

        btnAva.setOnClickListener(this);
        btnSave.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(auth.getCurrentUser().getUid());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == btnSave){
            updateData();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(view == btnAva){
            Toast.makeText(this, "Maaf saat ini belum tersedia", Toast.LENGTH_SHORT).show();
        }
    }

    private void getDataFromDatabase(String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                edtNama.setText(userModel.getNama());
                edtNohp.setText(userModel.getNo_hp());
                edtAlamat.setText(userModel.getAlamat());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    private void updateData(){
        database.child("nama").setValue(edtNama.getText().toString());
        database.child("no_hp").setValue(edtNohp.getText().toString());
        database.child("alamat").setValue(edtAlamat.getText().toString());
        database.child("status").setValue("Belum Memilih");
        database.child("point").setValue("0");
    }
}
