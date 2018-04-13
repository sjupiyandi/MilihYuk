package com.example.sisco.ayomileh.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.example.sisco.ayomileh.Activity.Main3Activity;
import com.google.firebase.auth.FirebaseAuth;

import com.example.sisco.ayomileh.Activity.AboutActivity;
import com.example.sisco.ayomileh.Activity.HistoryActivity;
import com.example.sisco.ayomileh.Activity.LoginActivity;
import com.example.sisco.ayomileh.R;


public class ProfilFragment extends Fragment implements View.OnClickListener{

    ImageView icMenu, imgLogout;
    TextView txtLogout;

    FirebaseAuth auth;

    public ProfilFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        auth = FirebaseAuth.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        icMenu = (ImageView) view.findViewById(R.id.ic_menu);
        imgLogout = (ImageView) view.findViewById(R.id.img_logout);
        txtLogout = (TextView) view.findViewById(R.id.txt_logout);

        icMenu.setOnClickListener(this);
        imgLogout.setOnClickListener(this);
        txtLogout.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view == icMenu){
            PopupMenu popup = new PopupMenu(getContext(), view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.profile_menu, popup.getMenu());
            popup.show();
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if(menuItem.getItemId() == R.id.history_menu){
                        Intent intent = new Intent(getActivity(), HistoryActivity.class);
                        getContext().startActivity(intent);
                    } else if (menuItem.getItemId() == R.id.about_menu){
                        Intent intent = new Intent(getActivity(), AboutActivity.class);
                        getContext().startActivity(intent);
                    }
                    return true;
                }
            });
        } else if(view == txtLogout || view == imgLogout){
            auth.signOut();
            Intent intent = new Intent(getActivity(), Main3Activity.class);
            getActivity().startActivity(intent);
            getActivity().finish();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.profile_menu, menu);
        return;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.history_menu:
                i = new Intent(getActivity(), HistoryActivity.class);
                startActivity(i);
                return true;

            case R.id.about_menu:
                i = new Intent(getActivity(), AboutActivity.class);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
