package com.example.sisco.ayomileh.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.sisco.ayomileh.Model.RedeemModel;
import com.example.sisco.ayomileh.R;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class RedeemAdapter extends RecyclerView.Adapter<RedeemAdapter.ViewHolder> {

    private ArrayList<RedeemModel> redeemModels;
    Context context;

    public RedeemAdapter(ArrayList<RedeemModel> redeemModels) {
        this.redeemModels= redeemModels;
    }

    @Override
    public RedeemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_redeem, viewGroup, false);
        return new RedeemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RedeemAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.txtPrice.setText(redeemModels.get(i).getPrice());
        viewHolder.txtName.setText(redeemModels.get(i).getName());
        viewHolder.txtPrice.setText("Rp " + redeemModels.get(i).getPrice());
        viewHolder.txtCode.setText("CODE : " + redeemModels.get(i).getCode());
        viewHolder.txtCoin.setText(redeemModels.get(i).getCoin());
        switch (redeemModels.get(i).getImage()){
            case "nasgor":
                viewHolder.imgPhoto.setImageResource(R.drawable.nasgor);
                break;
            case "movie":
                viewHolder.imgPhoto.setImageResource(R.drawable.movie);
                break;
        }
        viewHolder.cvRedeem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("id", eventModels.get(i).getId());
//                context.startActivity(intent);
//                ((Activity) context).finish();
            }
        });
    }

    @Override
    public int getItemCount() {
        return redeemModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        private TextView txtName, txtPrice, txtCode, txtCoin;
        private CardView cvRedeem;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();

            imgPhoto = (ImageView) view.findViewById(R.id.img_photo);
            cvRedeem = (CardView) view.findViewById(R.id.cv_redeem);
            txtName = (TextView) view.findViewById(R.id.txt_name);
            txtPrice = (TextView) view.findViewById(R.id.txt_price);
            txtCode = (TextView) view.findViewById(R.id.txt_code);
            txtCoin = (TextView) view.findViewById(R.id.txt_coin);

        }
    }
}
