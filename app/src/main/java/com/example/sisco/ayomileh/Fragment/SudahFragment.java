package com.example.sisco.ayomileh.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sisco.ayomileh.Activity.DaftarTetapActivity;
import com.example.sisco.ayomileh.Activity.PenggunaActivity;
import com.example.sisco.ayomileh.Activity.UserActivity;
import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SudahFragment extends Fragment {

    private RecyclerView mUsersList;

    private DatabaseReference mUsersDatabase;

    private LinearLayoutManager mLayoutManager;
    public FirebaseUser mCurrent_user;

    public SudahFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sudah, container, false);


        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        mUsersDatabase.keepSynced(true);

        mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);

        mUsersList = (RecyclerView) view.findViewById(R.id.recycler_view);
        mUsersList.setHasFixedSize(true);
        mUsersList.setLayoutManager(mLayoutManager);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<UserModel, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UserModel, UsersViewHolder>(

                UserModel.class,
                R.layout.item_daftartetap,
                UsersViewHolder.class,
                mUsersDatabase.orderByChild("status").equalTo("Sudah Memilih")

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder usersViewHolder, UserModel users, int position) {

                usersViewHolder.setDisplayName(users.getNama());
                usersViewHolder.setUserStatus(users.getAlamat());
                usersViewHolder.setJenisStatus(users.getJenis_kelamin());

                final String user_id = getRef(position).getKey();

                usersViewHolder.mView.findViewById(R.id.sudah).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getContext(), PenggunaActivity.class);
                        intent.putExtra("user_id", user_id);
                        startActivity(intent);

                    }
                });
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

        public void setJenisStatus(String status){

            TextView userStatusView = (TextView) mView.findViewById(R.id.txt_jeniskelamin);
            String jenis= "";
            if (status.equals("L")){
                jenis = "Tn. ";
                userStatusView.setText(jenis);
            }else {
                jenis = "Ny. ";
                userStatusView.setText(jenis);
            }


        }
    }

}
