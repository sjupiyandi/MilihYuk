package com.example.sisco.ayomileh.Fragment;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.example.sisco.ayomileh.Activity.RequestActivity;
import com.example.sisco.ayomileh.Adapter.EventAdapter;
import com.example.sisco.ayomileh.Model.EventModel;
import com.example.sisco.ayomileh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment implements View.OnClickListener{

    private ArrayList<EventModel> data;
    private EventAdapter adapter;

    EditText edtDate, edtLocation;

    Calendar myCalendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener date;
    CharSequence locations[] = new CharSequence[] {"Kota Batu", "Kota Malang", "Kabupaten Malang"};
    AlertDialog.Builder builder;

    public EventFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_event, container, false);

        edtDate = (EditText) view.findViewById(R.id.edt_date);
        edtLocation = (EditText) view.findViewById(R.id.edt_location);

        date = new DatePickerDialog.OnDateSetListener(){
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };
        edtDate.setOnClickListener(this);
        edtLocation.setOnClickListener(this);

        builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Pilih Daerah");
        builder.setItems(locations, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case 0:
                        edtLocation.setText("Kota Batu");
                        break;
                    case 1:
                        edtLocation.setText("Kota Malang");
                        break;
                    case 2:
                        edtLocation.setText("Kab. Malang");
                        break;
                }
            }
        });
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == edtDate){
            new DatePickerDialog(getActivity(), date, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        } else if (view == edtLocation){
            builder.show();
        }
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        edtDate.setText(sdf.format(myCalendar.getTime()));
    }
}
