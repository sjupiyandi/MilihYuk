package com.example.sisco.ayomileh.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Model.MengajakModel;
import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiajakActivity extends AppCompatActivity {

    Toolbar toolbar;

    private RecyclerView mUsersList;
    private DatabaseReference mUsersDatabase;
    private LinearLayoutManager mLayoutManager;
    public FirebaseUser mCurrent_user;
    DatabaseReference database,databases;
    FirebaseAuth auth;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diajak);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Ajakan").child("diajak").child(mCurrent_user.getUid());
        mUsersDatabase.keepSynced(true);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        mUsersList = (RecyclerView) findViewById(R.id.recycler_view);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(mLayoutManager);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<MengajakModel, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<MengajakModel, UsersViewHolder>(

                MengajakModel.class,
                R.layout.item_diajak,
                UsersViewHolder.class,
                mUsersDatabase.orderByChild("type").equalTo("diajak")

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder usersViewHolder, MengajakModel users, final int position) {

                usersViewHolder.setDisplayName(users.getNama());
                usersViewHolder.setUserStatus(users.getAlamat());
                usersViewHolder.setPesanName(users.getPesan());

                final String user_id = getRef(position).getKey();
                final String user_id2 = auth.getCurrentUser().getUid();

                usersViewHolder.mView.findViewById(R.id.btn_abaikan).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mUsersDatabase.child(user_id).removeValue();
                    }
                });
                usersViewHolder.mView.findViewById(R.id.btn_terima).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getDataFromDatabase(user_id,user_id2);
                        mUsersDatabase.removeValue();
                    }
                });
            }
        };


        mUsersList.setAdapter(firebaseRecyclerAdapter);

    }

    private void getDataFromDatabase(String user_id, String userId){
        database = FirebaseDatabase.getInstance().getReference("users/" + user_id);
        database.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                point = Integer.parseInt(dataSnapshot.child("point").getValue().toString());
                point++;
                database.child("point").setValue(String.valueOf(point));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        databases = FirebaseDatabase.getInstance().getReference("users/" + userId);
        databases.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                databases.child("ajak").setValue("true");

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }





    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        View mView;

        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDisplayName(String name){

            TextView userNameView = (TextView) mView.findViewById(R.id.txt_name);
            userNameView.setText(name);

        }

        public void setUserStatus(String status){

            TextView userStatusView = (TextView) mView.findViewById(R.id.txt_address);
            userStatusView.setText(status);

        }


        public void setPesanName(String pesanName) {
            TextView userPesanView = (TextView) mView.findViewById(R.id.txt_pesan);
            userPesanView.setText("\""+pesanName+"\"");
        }
    }
}
