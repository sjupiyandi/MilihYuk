package com.example.sisco.ayomileh.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.example.sisco.ayomileh.Model.EventModel;
import com.example.sisco.ayomileh.R;

/**
 * Created by Princhaa on /22Oct/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private ArrayList<EventModel> eventModels;
    Context context;

    public EventAdapter(ArrayList<EventModel> eventModels) {
        this.eventModels = eventModels;
    }

    @Override
    public EventAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_event, viewGroup, false);
        return new EventAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.txtDate.setText(eventModels.get(i).getDate());
        viewHolder.txtName.setText(eventModels.get(i).getName());
        viewHolder.txtAddress.setText(eventModels.get(i).getAddress());
        viewHolder.txtTime.setText(eventModels.get(i).getTime());
        viewHolder.cvEvent.setOnClickListener(new View.OnClickListener() {
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
        return eventModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtDate, txtName, txtAddress, txtTime;
        private CardView cvEvent;

        public ViewHolder(View view) {
            super(view);
            context = view.getContext();

            txtDate = (TextView) view.findViewById(R.id.txt_date);
            txtName = (TextView) view.findViewById(R.id.txt_name);
            txtAddress = (TextView) view.findViewById(R.id.txt_address);
            txtTime = (TextView) view.findViewById(R.id.txt_time);
            cvEvent = (CardView) view.findViewById(R.id.cv_event);
        }
    }
}
