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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sisco.ayomileh.Activity.DaftarTetapActivity;
import com.example.sisco.ayomileh.Activity.PenggunaActivity;
import com.example.sisco.ayomileh.Activity.UserActivity;
import com.example.sisco.ayomileh.Model.PemilihModel;
import com.example.sisco.ayomileh.Model.UserModel;
import com.example.sisco.ayomileh.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class BelumFragment extends Fragment {

    private RecyclerView mUsersList, mUsersList2;

    private DatabaseReference mUsersDatabase,mUsersDatabase2;

    private LinearLayoutManager mLayoutManager, mLayoutManager2;
    FirebaseUser mCurrent_user;

    public BelumFragment() {
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
        View view = inflater.inflate(R.layout.fragment_belum, container, false);

        mUsersDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        mUsersDatabase.keepSynced(true);

        mLayoutManager = new LinearLayoutManager(getContext());

        mUsersList = (RecyclerView) view.findViewById(R.id.recycler_view);

        mUsersList.setLayoutManager(mLayoutManager);


        mUsersDatabase2 = FirebaseDatabase.getInstance().getReference().child("tps").child("1").child("DaftarPemilih");
        mUsersDatabase2.keepSynced(true);

        mLayoutManager2 = new LinearLayoutManager(getContext());

        mUsersList2 = (RecyclerView) view.findViewById(R.id.recycler_view2);

        mUsersList2.setLayoutManager(mLayoutManager2);


        mCurrent_user = FirebaseAuth.getInstance().getCurrentUser();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        getBelum();
        getBelumTerdaftar();

    }

    private void getBelum(){
        FirebaseRecyclerAdapter<UserModel, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<UserModel, UsersViewHolder>(

                UserModel.class,
                R.layout.item_belum,
                UsersViewHolder.class,
                mUsersDatabase.orderByChild("status").equalTo("Belum Memilih")

        ) {
            @Override
            protected void populateViewHolder(UsersViewHolder usersViewHolder, UserModel users, int position) {

                usersViewHolder.setDisplayName(users.getNama());
                usersViewHolder.setUserStatus(users.getAlamat());
                usersViewHolder.setJenisStatus(users.getJenis_kelamin());

                final String user_id = getRef(position).getKey();

                usersViewHolder.mView.findViewById(R.id.belum).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getContext(), PenggunaActivity.class);
                        intent.putExtra("user_id", user_id);
                        startActivity(intent);

                    }
                });

                usersViewHolder.mView.findViewById(R.id.btn_ajak).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (user_id.equals(mCurrent_user.getUid())){
                            Toast.makeText(getContext(), "Anda tidak bisa mengajak diri anda sendiri.", Toast.LENGTH_LONG).show();

                        }else {
                            Intent intent = new Intent(getContext(), UserActivity.class);
                            intent.putExtra("user_id", user_id);
                            startActivity(intent);
                            getActivity().finish();
                        }
                    }
                });
            }
        };
        firebaseRecyclerAdapter.notifyDataSetChanged();
        mUsersList.setAdapter(firebaseRecyclerAdapter);

    }

    private void getBelumTerdaftar(){
        FirebaseRecyclerAdapter<PemilihModel, UsersViewHolder> firebaseRecyclerAdapter2 = new FirebaseRecyclerAdapter<PemilihModel, UsersViewHolder>(

                PemilihModel.class,
                R.layout.item_daftartetap,
                UsersViewHolder.class,
                mUsersDatabase2.orderByChild("app").equalTo("false")

        ) {
            @Override
            protected void populateViewHolder(final UsersViewHolder usersViewHolder, PemilihModel users, int position) {

                usersViewHolder.setDisplayName(users.getNama());
                usersViewHolder.setUserStatus(users.getAlamat());
                usersViewHolder.setJenisStatus(users.getJk());

                final String user_id = getRef(position).getKey();

                usersViewHolder.mView.findViewById(R.id.sudah).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getContext(), PenggunaActivity.class);
                        intent.putExtra("nama", usersViewHolder.userNameView.getText().toString());
                        intent.putExtra("alamat", usersViewHolder.userStatusView.getText().toString());
                        startActivity(intent);

                    }
                });


            }
        };
        firebaseRecyclerAdapter2.notifyDataSetChanged();
        mUsersList2.setAdapter(firebaseRecyclerAdapter2);

    }

    public static class UsersViewHolder extends RecyclerView.ViewHolder {

        View mView;
        TextView userNameView ;
        TextView userStatusView ;

        public UsersViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

        }

        public void setDisplayName(String name){

            userNameView= (TextView) mView.findViewById(R.id.txt_name);
            userNameView.setText(name);

        }

        public void setUserStatus(String status){

            userStatusView= (TextView) mView.findViewById(R.id.txt_address);
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
