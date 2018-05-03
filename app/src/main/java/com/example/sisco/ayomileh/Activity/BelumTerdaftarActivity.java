package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class BelumTerdaftarActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    TextView error;
    EditText edt_noktp;
    Button ubahstatus;

    FirebaseAuth auth;
    DatabaseReference databasepemilih;
    DatabaseReference database,databases;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belum_terdaftar);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        error = (TextView) findViewById(R.id.txt_error);
        edt_noktp = (EditText) findViewById(R.id.edt_no_ktp);
        ubahstatus = (Button) findViewById(R.id.ubah_status);

        ubahstatus.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent intentBack = new Intent(this,PetugasActivity.class);
        this.startActivity(intentBack);
        this.finish();
    }


    @Override
    public void onClick(View view) {
        if (view == ubahstatus){

            if(TextUtils.isEmpty(edt_noktp.getText().toString())){
                error.setText("Data tidak boleh kosong");

                return;
            }else {
                    databasepemilih = FirebaseDatabase.getInstance().getReference("tps/1/DaftarPemilih");
                    databasepemilih.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(final DataSnapshot dataSnapshot) {
                            for (int i = 0; i<dataSnapshot.getChildrenCount();i++) {

                                if (edt_noktp.getText().toString().equals(dataSnapshot.child(i+"").child("nik").getValue().toString()) && dataSnapshot.child(i+"").child("app").getValue().toString().equals("false") ) {
                                    final int id = i;
                                    final String email = dataSnapshot.child(i+"").child("nama").getValue().toString().substring(0,3)+"@gmail.com";
                                    final String nama = dataSnapshot.child(i+"").child("nama").getValue().toString();
                                    final String alamat = dataSnapshot.child(i+"").child("alamat").getValue().toString();
                                    final String jk = dataSnapshot.child(i+"").child("jk").getValue().toString();
                                    final String no_ktp = dataSnapshot.child(i+"").child("no_ktp").getValue().toString();
                                    final String no_kk = dataSnapshot.child(i+"").child("no_kk").getValue().toString();
                                    final String no_tps = dataSnapshot.child(i+"").child("no_tps").getValue().toString();
                                    auth.createUserWithEmailAndPassword(email, "123456").addOnCompleteListener(BelumTerdaftarActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            databasepemilih = FirebaseDatabase.getInstance().getReference();
                                            writeNewUser(auth.getCurrentUser().getUid(), email);
                                            getDataFromDatabase(auth.getCurrentUser().getUid(),id+"");
                                            updateData(nama, alamat,jk,no_ktp,no_kk,no_tps);
                                            Intent intent = new Intent(getApplicationContext(), PetugasActivity.class);
                                            startActivity(intent);
                                            finish();
                                            Toast.makeText(getApplicationContext(), "Ubah Status Berhasil",Toast.LENGTH_SHORT).show();
                                            auth.signOut();
                                        }
                                    });

                                } else {
                                    error.setText("Data tidak ditemukan");
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

            }

        }
    }

    private void writeNewUser(String userId, String email){
        UserModel users = new UserModel("", "", "", "", "", "", "","","","","");
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/users/" + userId, users);
        database = FirebaseDatabase.getInstance().getReference();
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

    private void updateData(String nama, String alamat, String jenis_kelamin,String no_ktp, String no_kk, String no_tps){
        database.child("nama").setValue(nama);
        database.child("alamat").setValue(alamat);
        database.child("no_ktp").setValue(no_ktp);
        database.child("no_kk").setValue(no_kk);
        database.child("no_tps").setValue(no_tps);
        database.child("jenis_kelamin").setValue(jenis_kelamin);
        database.child("status").setValue("Sudah Memilih");
        database.child("point").setValue("0");
        database.child("kupon").setValue("false");
        database.child("ajak").setValue("false");
    }
}
