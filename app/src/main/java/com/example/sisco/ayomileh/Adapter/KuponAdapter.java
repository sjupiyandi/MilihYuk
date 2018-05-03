package com.example.sisco.ayomileh.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.sisco.ayomileh.Activity.DetailKuponActivity;
import com.example.sisco.ayomileh.Activity.PoinKuponActivity;
import com.example.sisco.ayomileh.Model.KuponModel;
import com.example.sisco.ayomileh.R;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class KuponAdapter extends RecyclerView.Adapter<KuponAdapter.ViewHolder> {

    private ArrayList<KuponModel> kuponModels;
    Context context;

    public KuponAdapter(ArrayList<KuponModel> kuponModels) {
        this.kuponModels = kuponModels;
    }

    @Override
    public KuponAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_kupon, viewGroup, false);
        return new KuponAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final KuponAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.txtPersenan.setText(kuponModels.get(i).getNilaiKupon()+"%");
        viewHolder.txtDiskon.setText(kuponModels.get(i).getKeteranganKupon());

        viewHolder.btnTunjukkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailKuponActivity.class);
                intent.putExtra("diskonKupon",kuponModels.get(i).getNilaiKupon());
                intent.putExtra("idKupon",kuponModels.get(i).getIdKupon());
                context.startActivity(intent);
                ((PoinKuponActivity)context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return kuponModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgKupon;
        TextView txtPersenan, txtDiskon;
        Button btnTunjukkan;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();

            imgKupon = view.findViewById(R.id.ivLogoDiskon);
            txtPersenan = view.findViewById(R.id.txtPersenan);
            txtDiskon = view.findViewById(R.id.txtDiskon);
            btnTunjukkan = view.findViewById(R.id.btnTunjukkan);
        }
    }
}
