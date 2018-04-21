package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScanActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    String status = "";
    int point;

    Button imgScan;
    IntentIntegrator qrScan;

    FirebaseAuth auth;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imgScan = (Button) findViewById(R.id.scan_qr);
        imgScan.setOnClickListener(this);
        qrScan = new IntentIntegrator(this);

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
        if(view == imgScan){
            qrScan.initiateScan();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String re = scanResult.getContents();
            if (status.equals("Belum Memilih")){
                if (re.equals("Version 2")){
                    getDataFromDatabases(auth.getCurrentUser().getUid());
                    Toast.makeText(this,"Scan Berhasil",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this,"QR Code Salah",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"Anda telah melakukan scan",Toast.LENGTH_SHORT).show();
            }

        }
        // else continue with any other code you need in the method

    }

    private void getDataFromDatabase(String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status = dataSnapshot.child("status").getValue().toString();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void getDataFromDatabases(String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                database.child("status").setValue("Sudah Memilih");
                point = Integer.parseInt(dataSnapshot.child("point").getValue().toString());
                point+= 10;
                database.child("point").setValue(String.valueOf(point));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
