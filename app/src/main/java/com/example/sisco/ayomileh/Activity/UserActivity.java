package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Model.MengajakModel;
import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class UserActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    TextView nama, status, alamat;
    EditText pesan;
    Button btnkirim;

    FirebaseAuth auth;
    DatabaseReference database,databases;
    FirebaseUser mCurrent_user;

    public String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nama = (TextView) findViewById(R.id.edt_nama);
        status = (TextView) findViewById(R.id.edt_no_hp);
        alamat = (TextView) findViewById(R.id.edt_alamat);
        pesan = (EditText) findViewById(R.id.edt_pesan);
        btnkirim = (Button) findViewById(R.id.btn_send1);
        btnkirim.setOnClickListener(this);

        Bundle extras = getIntent().getExtras();
        user_id = extras.getString("user_id");

        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(user_id);
        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();
        databases = FirebaseDatabase.getInstance().getReference();
    }

    private void getDataFromDatabase(String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                nama.setText(userModel.getNama());
                status.setText(userModel.getStatus());
                alamat.setText(userModel.getAlamat());
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
    public void onClick(View view) {
        if (view == btnkirim){
            MengajakModel mengajakModel = new MengajakModel("","","","");
            Map requestMap = new HashMap();
            requestMap.put("Ajakan/" + mCurrent_user.getUid() + "/" + user_id + "/nama", nama.getText().toString());
            requestMap.put("Ajakan/" + user_id + "/" + mCurrent_user.getUid() + "/nama", nama.getText().toString());
            requestMap.put("Ajakan/" + mCurrent_user.getUid() + "/" + user_id + "/alamat", alamat.getText().toString());
            requestMap.put("Ajakan/" + user_id + "/" + mCurrent_user.getUid() + "/alamat", alamat.getText().toString());
            requestMap.put("Ajakan/" + mCurrent_user.getUid() + "/" + user_id + "/pesan", pesan.getText().toString());
            requestMap.put("Ajakan/" + user_id + "/" + mCurrent_user.getUid() + "/pesan", pesan.getText().toString());
            requestMap.put("Ajakan/" + mCurrent_user.getUid() + "/" + user_id + "/type", "mengajak");
            requestMap.put("Ajakan/" + user_id + "/" + mCurrent_user.getUid() + "/type", "diajak");
            databases.updateChildren(requestMap, new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {

                    if(databaseError != null){

                        Toast.makeText(UserActivity.this, "There was some error in sending request", Toast.LENGTH_SHORT).show();

                    } else {

                        Intent intent = new Intent(UserActivity.this, DaftarTetapActivity.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(getApplicationContext(), "Ajakan berhasil dikirim. Anda akan mendapatk point jika pengguna lain menerima ajakan anda. Point yang anda dapatkan bisa dilihat dihalaman profile.", Toast.LENGTH_LONG).show();

                    }
                }
            });
            databases.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    MengajakModel userModel = dataSnapshot.getValue(MengajakModel.class);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
