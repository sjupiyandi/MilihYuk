package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PenggunaActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    TextView nama, alamat, nohp, status;
    String user_id;

    FirebaseAuth auth;
    DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengguna);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nama = (TextView) findViewById(R.id.edt_nama);
        alamat = (TextView) findViewById(R.id.edt_alamat);
        nohp = (TextView) findViewById(R.id.edt_no_hp);
        status = (TextView) findViewById(R.id.edt_status);

        nohp.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        user_id = extras.getString("user_id");
        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(user_id);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getDataFromDatabase(String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nama.setText(dataSnapshot.child("nama").getValue().toString());
                alamat.setText(dataSnapshot.child("alamat").getValue().toString());
                nohp.setText(dataSnapshot.child("no_hp").getValue().toString());
                status.setText(dataSnapshot.child("status").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == nohp){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", nohp.getText().toString(), null));
            startActivity(intent);
        }
    }
}
