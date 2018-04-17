package com.example.sisco.ayomileh.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.sisco.ayomileh.Model.MengajakModel;
import com.example.sisco.ayomileh.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DiajakActivity extends AppCompatActivity {

    Toolbar toolbar;

    private RecyclerView mUsersList;
    private DatabaseReference mUsersDatabase;
    private LinearLayoutManager mLayoutManager;
    public FirebaseUser mCurrent_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diajak);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();
        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("Ajakan").child(mCurrent_user.getUid());
        mUsersDatabase.keepSynced(true);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        mUsersList = (RecyclerView) findViewById(R.id.recycler_view);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(mLayoutManager);
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
            protected void populateViewHolder(UsersViewHolder usersViewHolder, MengajakModel users, int position) {

                usersViewHolder.setDisplayName(users.getNama());
                usersViewHolder.setUserStatus(users.getAlamat());
                usersViewHolder.setPesanName(users.getPesan());

                final String user_id = getRef(position).getKey();
            }
        };


        mUsersList.setAdapter(firebaseRecyclerAdapter);

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
