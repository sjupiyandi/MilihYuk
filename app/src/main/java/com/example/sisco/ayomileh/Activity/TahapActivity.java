package com.example.sisco.ayomileh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TahapActivity extends AppCompatActivity {

    Toolbar toolbar;

    TextView tahap;
    String tahapan = "";

    FirebaseAuth auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahap);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tahap = (TextView) findViewById(R.id.tahap);

        auth = FirebaseAuth.getInstance();
        for (int i = 0; i<=6; i++) {
            getDataFromDatabase(i);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getDataFromDatabase(int i){

            database = FirebaseDatabase.getInstance().getReference("tahapan/penyelenggaraan/"+i);
            database.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    tahapan += dataSnapshot.child("detail").getValue().toString()+"\n";
                    tahapan += "Tanggal Awal :  "+dataSnapshot.child("tgl_awal").getValue().toString()+"\n";
                    tahapan += "Tanggal Akhir :  "+dataSnapshot.child("tgl_akhir").getValue().toString()+"\n\n";
                    tahap.setText(tahapan);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

    }
