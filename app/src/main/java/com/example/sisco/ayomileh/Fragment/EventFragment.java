package com.example.sisco.ayomileh.Fragment;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Calendar;

import com.example.sisco.ayomileh.Activity.DaftarCalonActivity;
import com.example.sisco.ayomileh.Activity.DaftarTetapActivity;
import com.example.sisco.ayomileh.Activity.ScanActivity;
import com.example.sisco.ayomileh.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements View.OnClickListener{

    ScrollView sc_event;
    ProgressBar pg;

    EditText edtDate, edtLocation,tanda;
    TextView jml_pemilih, jml_belum;
    Button milih, calon, qr;


    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    AlertDialog.Builder builder;

    FirebaseAuth auth;
    Query database;
    DatabaseReference databases,datas;

    public EventFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event, container, false);

        sc_event = (ScrollView) view.findViewById(R.id.sc_event);
        pg = (ProgressBar) view.findViewById(R.id.pgbar);
        jml_pemilih = (TextView) view.findViewById(R.id.jml_pemilih);
        jml_belum = (TextView) view.findViewById(R.id.jml_belum);
        edtDate = (EditText) view.findViewById(R.id.edt_date);
        edtLocation = (EditText) view.findViewById(R.id.edt_location);
        milih = (Button) view.findViewById(R.id.milih);
        calon = (Button) view.findViewById(R.id.calon);
        qr = (Button) view.findViewById(R.id.qr);
        tanda = (EditText) view.findViewById(R.id.txt_tanda);

        edtDate.setOnClickListener(this);
        milih.setOnClickListener(this);
        calon.setOnClickListener(this);
        qr.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();
        getDataFromDatabase(auth.getCurrentUser().getUid());



        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == edtDate){
            new DatePickerDialog(getActivity(), date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        } else if (view == milih){
                Intent intent = new Intent(getContext(), DaftarTetapActivity.class);
                startActivity(intent);
            }else  if(view == calon){
                Intent intent = new Intent(getContext(), DaftarCalonActivity.class);
                startActivity(intent);
            }else if (view == qr){
                Intent intent = new Intent(getContext(), ScanActivity.class);
                startActivity(intent);
            }
    }


    private void getDataFromDatabase(String id){
        datas = FirebaseDatabase.getInstance().getReference("users/"+id);
        datas.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String status = dataSnapshot.child("status").getValue().toString();
                if (status.equals("Sudah Memilih")){

                    tanda.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        databases = FirebaseDatabase.getInstance().getReference("tps").child("1").child("DaftarPemilih");
        databases.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                jml_pemilih.setText(String.valueOf(dataSnapshot.getChildrenCount()));
                database = FirebaseDatabase.getInstance().getReference("users").orderByChild("status").equalTo("Sudah Memilih");
                database.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Long jml_sudah =  Long.parseLong(jml_pemilih.getText().toString()) - dataSnapshot.getChildrenCount();
                        jml_belum.setText(String.valueOf(jml_sudah));
                        pg.setVisibility(View.INVISIBLE);
                        sc_event.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });





    }
}
