package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sisco.ayomileh.Model.KuponModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailKuponActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView persen;
    Button btnNonaktifkanKupon;

    FirebaseAuth auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kupon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        persen = (TextView) findViewById(R.id.persen);
        btnNonaktifkanKupon = findViewById(R.id.btnNonaktifkanKupon);

        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(auth.getCurrentUser().getUid());

        btnNonaktifkanKupon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.child("status").setValue("Sudah ditukar");
                Intent intentBack = new Intent(view.getContext(),PoinKuponActivity.class);
                intentBack.putExtra("message","Penukaran kupon berhasil, anda berhasil mendapatkan diskon.");
                view.getContext().startActivity(intentBack);
                finish();
            }
        });


    }

    private void getDataFromDatabase(String uid) {
        database = FirebaseDatabase.getInstance().getReference("riwayat/kupon/" + uid);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                KuponModel userModel = dataSnapshot.getValue(KuponModel.class);
                persen.setText("Diskon "+userModel.getNilaiKupon() + "% dari total belanja.");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this,PoinKuponActivity.class);
        intentBack.putExtra("message","Penukaran kupon dibatalkan");
        this.startActivity(intentBack);
        this.finish();
    }
}
