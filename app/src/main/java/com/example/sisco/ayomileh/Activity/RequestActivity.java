package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import com.example.sisco.ayomileh.R;

public class RequestActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar;
    Button btnRequest;
    EditText edtAddress;
    RadioButton rdoA, rdoB, rdoAB, rdoO, rdoPositif, rdoNegatif;

    Place place;
    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        edtAddress = (EditText) findViewById(R.id.edt_address);
        btnRequest = (Button) findViewById(R.id.btn_request);
        rdoA = (RadioButton) findViewById(R.id.rdo_a);
        rdoB = (RadioButton) findViewById(R.id.rdo_b);
        rdoAB = (RadioButton) findViewById(R.id.rdo_ab);
        rdoO = (RadioButton) findViewById(R.id.rdo_o);
        rdoPositif = (RadioButton) findViewById(R.id.rdo_positive);
        rdoNegatif = (RadioButton) findViewById(R.id.rdo_negative);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        edtAddress.setOnClickListener(this);
        btnRequest.setOnClickListener(this);
        rdoA.setOnClickListener(this);
        rdoB.setOnClickListener(this);
        rdoAB.setOnClickListener(this);
        rdoO.setOnClickListener(this);
        rdoPositif.setOnClickListener(this);
        rdoNegatif.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == btnRequest){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else if(view == edtAddress){
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            try{
                startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
            } catch (GooglePlayServicesRepairableException e){
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e){
                e.printStackTrace();
            }
        } else if(view == rdoA){
            rdoA.setChecked(true);
            rdoB.setChecked(false);
            rdoAB.setChecked(false);
            rdoO.setChecked(false);
        } else if(view == rdoB){
            rdoA.setChecked(false);
            rdoB.setChecked(true);
            rdoAB.setChecked(false);
            rdoO.setChecked(false);
        } else if(view == rdoAB){
            rdoA.setChecked(false);
            rdoB.setChecked(false);
            rdoAB.setChecked(true);
            rdoO.setChecked(false);
        } else if(view == rdoO){
            rdoA.setChecked(false);
            rdoB.setChecked(false);
            rdoAB.setChecked(false);
            rdoO.setChecked(true);
        } else if(view == rdoPositif){
            rdoPositif.setChecked(true);
            rdoNegatif.setChecked(false);
        } else if(view == rdoNegatif){
            rdoPositif.setChecked(false);
            rdoNegatif.setChecked(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PLACE_PICKER_REQUEST){
            if(resultCode == RESULT_OK){
                place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format(place.getAddress().toString());
                String latitude = Double.toString(place.getLatLng().latitude);
                String longitude = Double.toString(place.getLatLng().longitude);
                edtAddress.setText(toastMsg);
            }
        }
    }
}
