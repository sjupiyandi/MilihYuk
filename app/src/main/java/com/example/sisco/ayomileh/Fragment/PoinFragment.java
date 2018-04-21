package com.example.sisco.ayomileh.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.sisco.ayomileh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PoinFragment extends Fragment {

    RecyclerView recyclerView;

    public PoinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poin, container, false);
        Button btnTukarPoin;
        btnTukarPoin = view.findViewById(R.id.btnTukarPoin);
        btnTukarPoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Penukaran Berhasil",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
