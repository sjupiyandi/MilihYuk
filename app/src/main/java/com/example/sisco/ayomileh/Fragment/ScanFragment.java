package com.example.sisco.ayomileh.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.zxing.integration.android.IntentIntegrator;

import com.example.sisco.ayomileh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanFragment extends Fragment implements View.OnClickListener{

    ImageView imgScan;
    IntentIntegrator qrScan;

    public ScanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scan, container, false);
        imgScan = (ImageView) view.findViewById(R.id.img_scan);
        imgScan.setOnClickListener(this);
        qrScan = new IntentIntegrator(getActivity());
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == imgScan){
            qrScan.initiateScan();
        }
    }
}
