package com.example.subhash.journal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Subhash on 02/02/2018.
 */

public class card extends RecyclerView.Adapter<card.cardAdapter>{
    private List<Cardview> a;
    public class cardAdapter extends RecyclerView.ViewHolder{
        TextView Time,Date,Data;
        public cardAdapter(View view){
            super(view);
            Date=(TextView)view.findViewById(R.id.date);
            Time=(TextView)view.findViewById(R.id.time);
            Data=(TextView)view.findViewById(R.id.data);
        }

    }

    public card(List<Cardview> a) {
        this.a=a;

    }

    @Override
    public cardAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddesign, parent, false);
        return new cardAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(cardAdapter holder, int position) {
        Cardview card = a.get(position);
        holder.Date.setText(Cardview.getdate());
        holder.Time.setText(Cardview.gettime());
        holder.Data.setText(Cardview.getdata());
    }

    @Override
    public int getItemCount() {
       return a.size();
    }



}
