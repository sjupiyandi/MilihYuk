package com.example.sisco.ayomileh.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.sisco.ayomileh.Adapter.ViewPagerAdapter;
import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    FirebaseUser user;
    DatabaseReference database;
    FirebaseAuth auth;

    public static Context mContext;

    public void binding(){
        bottomNavigationView    = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        viewPager               = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding();

        setupViewPager(viewPager);
//        Bundle extras = getIntent().getExtras();
//        if(extras != null){
//            int pos = extras.getInt("message");
//            viewPager.setCurrentItem(pos);
//        }
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_event:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_info:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_profile:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return true;
                    }
                });
        user = FirebaseAuth.getInstance().getCurrentUser();
        auth = FirebaseAuth.getInstance();

        if(user == null){
            Intent intent = new Intent(this, Main3Activity.class);
            startActivity(intent);
            finish();
        } else {
            getDataFromDatabase();
        }

//        mContext = MainActivity.this;
//        if(getIntent().getStringExtra("click_action") != null){
//            if (getIntent().getStringExtra("click_action").equals("URGENT_ACTION")){
//                Intent intent = new Intent(this, UrgentActivity.class);
//                startActivity(intent);
//            }
//        }
    }

    private void getDataFromDatabase(){
        database = FirebaseDatabase.getInstance().getReference("users/" + auth.getCurrentUser().getUid());
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel userModel = dataSnapshot.getValue(UserModel.class);
                if(userModel.getNama().equals("") || userModel.getNama() == null){
                    Intent intent = new Intent(MainActivity.this, EditProfileActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), 3);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            super.onActivityResult(requestCode, resultCode, data);
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    JSONObject obj = new JSONObject(result.getContents());
                    //setting values to textviews
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                }
            }
        } else {
            Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
