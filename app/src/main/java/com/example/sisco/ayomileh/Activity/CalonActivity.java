package com.example.sisco.ayomileh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CalonActivity extends AppCompatActivity {

    Toolbar toolbar;
    ImageView imaageKetua, imageWakil;
    TextView atas,nama, nama2, ttl, ttl2, pekerjaan, pekerjaan2, visi, misi, program;
    String no_urut;

    FirebaseAuth auth;
    DatabaseReference database,dVisi;

//    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://api.pemiluapi.org/").addConverterFactory(GsonConverterFactory.create());
//    Retrofit retrofit = builder.build();
//    Server userClient = retrofit.create(Server.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imaageKetua = (ImageView) findViewById(R.id.imageKetua);
        imageWakil = (ImageView) findViewById(R.id.imageWakil);
        atas =(TextView) findViewById(R.id.atas);
        nama = (TextView) findViewById(R.id.nama);
        nama2 = (TextView) findViewById(R.id.nama2);
        ttl = (TextView) findViewById(R.id.ttl);
        ttl2 = (TextView) findViewById(R.id.ttl2);
        pekerjaan = (TextView) findViewById(R.id.pekerjaan);
        pekerjaan2 = (TextView) findViewById(R.id.pekerjaan2);
        visi = (TextView) findViewById(R.id.visi);
        misi = (TextView) findViewById(R.id.misi);
        program = (TextView) findViewById(R.id.program);

        Bundle extras = getIntent().getExtras();
        no_urut = extras.getString("no_urut");

        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(no_urut);

//        fetchData("http://api.pemiluapi.org/pilgubjateng/api/v1/profilpaslon");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void getDataFromDatabase(String userId){

        database = FirebaseDatabase.getInstance().getReference("paslon/Pascalon/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (no_urut.equals("0")){
                    atas.setText("Pasangan No. Urut 1");
                    imaageKetua.setImageResource(R.drawable.pak1);
                    imageWakil.setImageResource(R.drawable.pak2);
                }else {
                    atas.setText("Pasangan No. Urut 2");
                    imaageKetua.setImageResource(R.drawable.pak3);
                    imageWakil.setImageResource(R.drawable.bu1);
                }
                nama.setText(dataSnapshot.child("nama_kepala_daerah").getValue().toString());
                nama2.setText(dataSnapshot.child("nama_wakil_kepala_daerah").getValue().toString());
                ttl.setText(dataSnapshot.child("tempat_lahir_kepala_daerah").getValue().toString()+", "+dataSnapshot.child("tanggal_lahir_kepala_daerah").getValue().toString());
                ttl2.setText(dataSnapshot.child("tempat_lahir_wakil").getValue().toString()+", "+dataSnapshot.child("tanggal_lahir_wakil").getValue().toString());
                pekerjaan.setText(dataSnapshot.child("pekerjaan_kepala_daerah").getValue().toString());
                pekerjaan2.setText(dataSnapshot.child("pekerjaan_wakil_kepala_daerah").getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        dVisi = FirebaseDatabase.getInstance().getReference("paslon/Pascalon/" + userId+"/visimisi");
        dVisi.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                visi.setText(dataSnapshot.child("visi").getValue().toString());
                String misis="",programs="";
                for (int i =0;i<=2;i++){
                    misis += dataSnapshot.child("misi").child(String.valueOf(i)).getValue().toString()+"\n\n";
                }
                misi.setText(misis);
                for (int i =0;i<=5;i++){
                    programs += dataSnapshot.child("program").child(String.valueOf(i)).getValue().toString()+"\n\n";
                }
                program.setText(programs);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }



//    private void fetchData(String url) {
//        Call<CalonModel> call = userClient.getCalon(url);
//        call.enqueue(new Callback<CalonModel>() {
//
//            @Override
//            public void onResponse(Call<CalonModel> call, Response<CalonModel> response) {
//                if (response.isSuccessful()) {
//                    nama.setText(response.body().getNama_kepala_daerah());
//                    nama2.setText(response.body().getNama_wakil_kepala_daerah());
//                    ttl.setText(response.body().getTempat_lahir_kepala_daerah()+", "+response.body().getTanggal_lahir_kepala_daerah());
//                    ttl2.setText(response.body().getTempat_lahir_wakil()+", "+response.body().getTanggal_lahir_wakil());
//                    pekerjaan.setText(response.body().getPekerjaan_kepala_daerah());
//                    pekerjaan2.setText(response.body().getPekerjaan_wakil_kepala_daerah());
//                    visi.setText(response.body().getVisimisi().getVisi());
//                    String stringMisi = "";
//                    for (CalonModel.VisimisiBean misis : response.body().getVisimisi()) {
//                        stringGenre += genre.getName()+", ";
//                    }

//                } else{
//                    Toast.makeText(CalonActivity.this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CalonModel> call, Throwable t) {
//                Toast.makeText(CalonActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
//            }
////        });
//    }
}
