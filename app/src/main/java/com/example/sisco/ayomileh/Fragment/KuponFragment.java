package com.example.sisco.ayomileh.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.sisco.ayomileh.Activity.DetailKuponActivity;
import com.example.sisco.ayomileh.Adapter.KuponAdapter;
import com.example.sisco.ayomileh.Model.KuponModel;
import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class KuponFragment extends Fragment implements View.OnClickListener{

    TextView persen, keterangan;
    Button tunjukan;
    CardView cv;

    FirebaseAuth auth;
    DatabaseReference database;

    public KuponFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kupon, container, false);

        cv = (CardView) view.findViewById(R.id.cv_redeem);
        persen = (TextView) view.findViewById(R.id.txtPersenan);
        keterangan  = (TextView) view.findViewById(R.id.txtDiskon);
        tunjukan = (Button) view.findViewById(R.id.btnTunjukkan);
        tunjukan.setOnClickListener(this);

        auth =FirebaseAuth.getInstance();
        getDataFromDatabase(auth.getCurrentUser().getUid());

        return view;
    }

    private void getDataFromDatabase(String uid) {
        database = FirebaseDatabase.getInstance().getReference("riwayat/kupon/" + uid);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getChildrenCount() == 0){
                    cv.setVisibility(View.INVISIBLE);
                }else if (dataSnapshot.child("status").getValue().toString().equals("Sudah ditukar")){
                    cv.setVisibility(View.INVISIBLE);
                } else {
                    KuponModel userModel = dataSnapshot.getValue(KuponModel.class);
                    persen.setText(userModel.getNilaiKupon() + "%");
                    keterangan.setText(userModel.getKeteranganKupon());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == tunjukan){
            Intent intent = new Intent(getContext(), DetailKuponActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }
}
