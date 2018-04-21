package com.example.sisco.ayomileh.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.sisco.ayomileh.Activity.DaftarCalonActivity;
import com.example.sisco.ayomileh.Activity.DaftarTetapActivity;
import com.example.sisco.ayomileh.Activity.LaporActivity;
import com.example.sisco.ayomileh.Activity.PelanggaranActivity;
import com.example.sisco.ayomileh.Activity.TahapActivity;
import com.example.sisco.ayomileh.Activity.TentangActivity;
import com.example.sisco.ayomileh.R;

public class InfoFragment extends Fragment implements View.OnClickListener{

    LinearLayout profileCalon, tahapan, pelanggaran, lapor, tentang;

    public InfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        profileCalon = (LinearLayout) view.findViewById(R.id.profile_calon);
        tahapan = (LinearLayout) view.findViewById(R.id.tahapan);
        pelanggaran = (LinearLayout) view.findViewById(R.id.pelanggaran_pilkada);
        lapor = (LinearLayout) view.findViewById(R.id.lapor_pelanggaran);
        tentang = (LinearLayout) view.findViewById(R.id.tentang);

        profileCalon.setOnClickListener(this);
        tahapan.setOnClickListener(this);
        pelanggaran.setOnClickListener(this);
        lapor.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        if (view == profileCalon){
            Intent intent = new Intent(getActivity(), DaftarCalonActivity.class);
            startActivity(intent);
        }else if (view == tahapan){
            Intent intent = new Intent(getActivity(), TahapActivity.class);
            startActivity(intent);
        }else if (view == pelanggaran){
            Intent intent = new Intent(getActivity(), PelanggaranActivity.class);
            startActivity(intent);
        }else if (view == lapor){
            Intent intent = new Intent(getActivity(), LaporActivity.class);
            startActivity(intent);
        }else if (view == tentang){
            Intent intent = new Intent(getActivity(), TentangActivity.class);
            startActivity(intent);
        }
    }
}
