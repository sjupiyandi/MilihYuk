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

import com.example.sisco.ayomileh.Activity.DaftarCalonActivity;
import com.example.sisco.ayomileh.Activity.DaftarTetapActivity;
import com.example.sisco.ayomileh.R;

public class InfoFragment extends Fragment implements View.OnClickListener{

    Button btn_daftarTetap, btn_daftarcalon;

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
        btn_daftarTetap = (Button) view.findViewById(R.id.btn_daftartetap);
        btn_daftarcalon = (Button) view.findViewById(R.id.btn_daftarcalon);

        btn_daftarTetap.setOnClickListener(this);
        btn_daftarcalon.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {
        if (view == btn_daftarTetap){
            Intent intent = new Intent(getActivity(), DaftarTetapActivity.class);
            startActivity(intent);
        }else if (view == btn_daftarcalon){
            Intent intent = new Intent(getActivity(), DaftarCalonActivity.class);
            startActivity(intent);
        }
    }
}
