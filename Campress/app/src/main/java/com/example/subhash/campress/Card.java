package com.example.subhash.campress;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Subhash on 20/12/2017.
 */

public class Card extends RecyclerView.Adapter<Card.CardAdapter> {
    private List <carddesign> albumList;
    private Context mContext;

    public class CardAdapter extends RecyclerView.ViewHolder{
        TextView Name;
        ImageView Thumbnail;
        public CardAdapter(View view){
            super(view);
            Name=(TextView)view.findViewById(R.id.title);
            Thumbnail=(ImageView)view.findViewById(R.id.thumbnail);
        }

    }

    public Card(List<carddesign> albumList, Context mContext) {
        this.albumList = albumList;
        this.mContext= mContext;
    }
    @Override
    public CardAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardtype, parent, false);

        return new CardAdapter(itemView);
    }

    @Override
    public void onBindViewHolder(CardAdapter holder, int position) {
        carddesign card = albumList.get(position);
        holder.Name.setText(card.getName());
        Glide.with(mContext).load(card.getUrl()).into(holder.Thumbnail);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}
