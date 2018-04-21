package com.example.sisco.ayomileh.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Activity.DiajakActivity;
import com.example.sisco.ayomileh.Activity.EditProfileActivity;
import com.example.sisco.ayomileh.Activity.Main3Activity;
import com.example.sisco.ayomileh.Activity.MengajakActivity;
import com.example.sisco.ayomileh.Model.UserModel;
import com.google.firebase.auth.FirebaseAuth;

import com.example.sisco.ayomileh.Activity.AboutActivity;
import com.example.sisco.ayomileh.Activity.PoinKuponActivity;
import com.example.sisco.ayomileh.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfilFragment extends Fragment implements View.OnClickListener{

    TextView  jenis_kelamin, nama,alamat, keluar, ubah, status, tps, jml_mengajak, jml_poin, jml_diajak;
    LinearLayout mengajak, diajak, poin;
    String jk;
    String cMengajak, cDiajak;

    FirebaseAuth auth;
    DatabaseReference database, dMengajak, dDiajak;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        jenis_kelamin = (TextView) view.findViewById(R.id.jenis_kelamin);
        nama = (TextView) view.findViewById(R.id.nama);
        alamat = (TextView) view.findViewById(R.id.alamat);
        keluar = (TextView) view.findViewById(R.id.txt_keluar);
        ubah = (TextView) view.findViewById(R.id.txt_ubah);
        status = (TextView) view.findViewById(R.id.status);
        tps = (TextView) view.findViewById(R.id.tps);
        jml_mengajak = (TextView) view.findViewById(R.id.jml_mengajak);
        jml_poin = (TextView) view.findViewById(R.id.jml_poin);
        jml_diajak = (TextView) view.findViewById(R.id.jml_diajak);
        mengajak = (LinearLayout)  view.findViewById(R.id.mengajak);
        diajak = (LinearLayout)  view.findViewById(R.id.diajak);
        poin = (LinearLayout) view.findViewById(R.id.poin);

        keluar.setOnClickListener(this);
        ubah.setOnClickListener(this);

        mengajak.setOnClickListener(this);
        diajak.setOnClickListener(this);
        poin.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(auth.getCurrentUser().getUid());

        System.out.println(jml_mengajak.getText().length());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getDataFromDatabase(auth.getCurrentUser().getUid());

    }

    @Override
    public void onClick(View view) {
        if(view == keluar){
            auth.signOut();
            Intent intent = new Intent(getActivity(), Main3Activity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        } else if (view == ubah) {
            Intent intent = new Intent(getActivity(), EditProfileActivity.class);
            getActivity().startActivity(intent);
        }else if (view == mengajak){
            Intent intent = new Intent(getActivity(), MengajakActivity.class);
            getActivity().startActivity(intent);
        }else if (view == diajak){
            Intent intent = new Intent(getActivity(), DiajakActivity.class);
            getActivity().startActivity(intent);

        }else if(view == poin){
            getActivity().startActivity(new Intent(getActivity(),PoinKuponActivity.class));
        }
    }

    private void getDataFromDatabase(final String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                jk = userModel.getJenis_kelamin();
                if (jk.equals("L")){
                    jk = "Tn.";
                }else {
                    jk = "Ny.";
                }

                jenis_kelamin.setText(jk);
                nama.setText(userModel.getNama());
                alamat.setText(userModel.getAlamat());
                status.setText(userModel.getStatus());
                tps.setText(userModel.getNo_tps());
                jml_poin.setText(userModel.getPoint());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        dMengajak = FirebaseDatabase.getInstance().getReference("Ajakan/mengajak/" + userId);
        dMengajak.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cMengajak = String.valueOf(dataSnapshot.getChildrenCount());
                jml_mengajak.setText(cMengajak);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        dDiajak = FirebaseDatabase.getInstance().getReference("Ajakan/diajak/" + userId);
        dDiajak.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cDiajak = String.valueOf(dataSnapshot.getChildrenCount());
                jml_diajak.setText(cDiajak);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
