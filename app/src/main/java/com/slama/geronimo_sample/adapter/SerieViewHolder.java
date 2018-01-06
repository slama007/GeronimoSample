package com.slama.geronimo_sample.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.slama.geronimo_sample.R;
import com.slama.geronimo_sample.item.ItemSerie;

/**
 * Created by Dell on 06/01/2018.
 */

public class SerieViewHolder extends RecyclerView.ViewHolder{

    private TextView itemTitle;
    private TextView itemDetail;
    private TextView detailButton;
    private TextView shareButton;
    private ImageView imageView;

    // itemView is the view corresponding to 1 cell
    public SerieViewHolder(View itemView) {
        super(itemView);

        //c'est ici que l'on fait nos findView
        shareButton = (TextView) itemView.findViewById(R.id.item_view_share_button);
        detailButton = (TextView) itemView.findViewById(R.id.item_view_details_button);
        itemDetail = (TextView) itemView.findViewById(R.id.item_view_detail);
        itemTitle = (TextView) itemView.findViewById(R.id.item_view_title);
        imageView = (ImageView) itemView.findViewById(R.id.item_view_image);
    }

    // add a function to fill the cell according to an ItemSerie
    public void bind(final ItemSerie itemSerie){
        itemTitle.setText(itemSerie.getTitle());
        itemDetail.setText(itemSerie.getDetail());
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", "Hello : " +itemSerie.getImageUrl());
                intent.setType("text/plain");
                view.getContext().startActivity(intent);
            }
        });
        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Details : " + itemSerie.getDetail(), Toast.LENGTH_SHORT).show();
            }
        });
        Glide.with(imageView.getContext())
                .load(itemSerie.getImageUrl())
                .apply(new RequestOptions().placeholder(R.drawable.erreur_image).error(R.drawable.erreur_image).centerCrop().fitCenter())
                .into(imageView);
    }
}
