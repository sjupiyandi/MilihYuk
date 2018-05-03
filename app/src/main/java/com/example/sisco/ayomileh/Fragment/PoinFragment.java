package com.example.sisco.ayomileh.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.sisco.ayomileh.Activity.PoinKuponActivity;
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
public class PoinFragment extends Fragment {

    RecyclerView recyclerView;
    Button btnTukarPoin;
    TextView poin, diskon;
    String kupon;

    FirebaseAuth auth;
    DatabaseReference database;

    public PoinFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_poin, container, false);

        poin = (TextView) view.findViewById(R.id.poin);
        diskon = (TextView) view.findViewById(R.id.diskon);
        btnTukarPoin = view.findViewById(R.id.btnTukarPoin);

        auth =FirebaseAuth.getInstance();
        getDataFromDatabase(auth.getCurrentUser().getUid());


        btnTukarPoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (poin.getText().toString().equals("0")){
                    Toast.makeText(getContext(), "Anda tidak memiliki poin.", Toast.LENGTH_SHORT).show();
                }else if (kupon.equals("true")){
                    Toast.makeText(getContext(), "Tidak dapat menukar, karena anda telah menukarkan kupon sebelumnya.", Toast.LENGTH_SHORT).show();
                }else {
                    updatePoint();
                    KuponModel kuponModel = new KuponModel(Integer.parseInt(poin.getText().toString()), "Diskon Infomaret", auth.getCurrentUser().getUid(),"Belum ditukar");
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/riwayat/kupon/" + auth.getCurrentUser().getUid(), kuponModel);
                    database = FirebaseDatabase.getInstance().getReference();
                    database.updateChildren(childUpdates);
                    Intent intent = new Intent(getContext(),PoinKuponActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                    Toast.makeText(getContext(), "Penukaran Berhasil", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;


    }

    @Override
    public void onResume() {
        super.onResume();
        getDataFromDatabase(auth.getCurrentUser().getUid());

    }

    private void updatePoint() {
        database.child("point").setValue("0");
        database.child("kupon").setValue("true");
    }

    private void getDataFromDatabase(final String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + userId);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                poin.setText(userModel.getPoint());
                diskon.setText(userModel.getPoint());
                kupon = userModel.getKupon();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
