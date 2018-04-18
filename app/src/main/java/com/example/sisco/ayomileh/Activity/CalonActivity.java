package com.example.sisco.ayomileh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Model.CalonModel;
import com.example.sisco.ayomileh.R;
import com.example.sisco.ayomileh.Server;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CalonActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView nama, nama2, ttl, ttl2, pekerjaan, pekerjaan2, visi, misi, program;

    Retrofit.Builder builder = new Retrofit.Builder().baseUrl("http://api.pemiluapi.org").addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();
    Server userClient = retrofit.create(Server.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calon);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        nama = (TextView) findViewById(R.id.nama);
        nama2 = (TextView) findViewById(R.id.nama2);
        ttl = (TextView) findViewById(R.id.ttl);
        ttl2 = (TextView) findViewById(R.id.ttl2);
        pekerjaan = (TextView) findViewById(R.id.pekerjaan);
        pekerjaan2 = (TextView) findViewById(R.id.pekerjaan2);
        visi = (TextView) findViewById(R.id.visi);
        misi = (TextView) findViewById(R.id.misi);
        program = (TextView) findViewById(R.id.program);

        fetchData("http://api.pemiluapi.org/pilgubjateng/api/v1/profilpaslon");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void fetchData(String url) {
        Call<CalonModel> call = userClient.getCalon(url);
        call.enqueue(new Callback<CalonModel>() {

            @Override
            public void onResponse(Call<CalonModel> call, Response<CalonModel> response) {
                if (response.isSuccessful()) {
                    nama.setText(response.body().getNama_kepala_daerah());
                    nama2.setText(response.body().getNama_wakil_kepala_daerah());
                    ttl.setText(response.body().getTempat_lahir_kepala_daerah()+", "+response.body().getTanggal_lahir_kepala_daerah());
                    ttl2.setText(response.body().getTempat_lahir_wakil()+", "+response.body().getTanggal_lahir_wakil());
                    pekerjaan.setText(response.body().getPekerjaan_kepala_daerah());
                    pekerjaan2.setText(response.body().getPekerjaan_wakil_kepala_daerah());
                    visi.setText(response.body().getVisimisi().getVisi());
//                    String stringMisi = "";
//                    for (CalonModel.VisimisiBean misis : response.body().getVisimisi()) {
//                        stringGenre += genre.getName()+", ";
//                    }

                } else{
                    Toast.makeText(CalonActivity.this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CalonModel> call, Throwable t) {
                Toast.makeText(CalonActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
