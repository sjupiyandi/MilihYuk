package com.example.sisco.ayomileh.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.example.sisco.ayomileh.Adapter.DonorAdapter;
import com.example.sisco.ayomileh.Adapter.EventAdapter;
import com.example.sisco.ayomileh.Model.EventModel;
import com.example.sisco.ayomileh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    private ArrayList<EventModel> data;
    private EventAdapter adapter;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poin, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        data = EventModel.createHistory();
        DonorAdapter adapter = new DonorAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

}
