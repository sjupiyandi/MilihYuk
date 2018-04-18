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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.sisco.ayomileh.Activity.DiajakActivity;
import com.example.sisco.ayomileh.Activity.EditProfileActivity;
import com.example.sisco.ayomileh.Activity.Main3Activity;
import com.example.sisco.ayomileh.Activity.MengajakActivity;
import com.google.firebase.auth.FirebaseAuth;

import com.example.sisco.ayomileh.Activity.AboutActivity;
import com.example.sisco.ayomileh.Activity.HistoryActivity;
import com.example.sisco.ayomileh.Activity.LoginActivity;
import com.example.sisco.ayomileh.R;


public class ProfilFragment extends Fragment implements View.OnClickListener{

    TextView  jenis_kelamin, nama, keluar, ubah, status, tps, jml_mengajak, jml_poin, jml_diajak;
    LinearLayout mengajak, diajak, poin;

    FirebaseAuth auth;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        auth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        jenis_kelamin = (TextView) view.findViewById(R.id.jenis_kelamin);
        nama = (TextView) view.findViewById(R.id.nama);
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

        return view;
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

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.profile_menu, menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.history_menu:
                i = new Intent(getActivity(), HistoryActivity.class);
                startActivity(i);
                return true;

            case R.id.about_menu:
                i = new Intent(getActivity(), AboutActivity.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
