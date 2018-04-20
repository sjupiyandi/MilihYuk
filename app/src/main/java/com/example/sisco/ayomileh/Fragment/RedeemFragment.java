package com.example.sisco.ayomileh.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.example.sisco.ayomileh.Adapter.RedeemAdapter;
import com.example.sisco.ayomileh.Model.RedeemModel;
import com.example.sisco.ayomileh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RedeemFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<RedeemModel> data;
    private RedeemAdapter adapter;

    public RedeemFragment() {    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kupon, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        data = RedeemModel.createRedeem();
        RedeemAdapter adapter = new RedeemAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
