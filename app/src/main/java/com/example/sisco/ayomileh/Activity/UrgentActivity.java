package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sisco.ayomileh.R;

public class UrgentActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent);

        btnHelp = (Button) findViewById(R.id.btn_help);

        btnHelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnHelp){
            Uri gmmIntentUri = Uri.parse("geo:-7.9409421,112.6195565,17");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        }
    }
}
