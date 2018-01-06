package com.slama.geronimo_sample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slama.geronimo_sample.R;
import com.slama.geronimo_sample.item.ItemSerie;

import java.util.List;

/**
 * Created by Dell on 06/01/2018.
 */

public class SerieAdapter extends RecyclerView.Adapter<SerieViewHolder> {

    public List<ItemSerie> list;

    //add a constructor taking a list
    public SerieAdapter(List<ItemSerie> list) {
        this.list = list;
    }

    // this function creates the viewHolder
    // and by the same indicate the view to inflate (from the layout xml)
    @Override
    public SerieViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new SerieViewHolder(view);
    }

    // this is where we will fill our cell with the text / image of each ItemSeries
    @Override
    public void onBindViewHolder(SerieViewHolder myViewHolder, int position) {
        ItemSerie itemSerie = list.get(position);
        myViewHolder.bind(itemSerie);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}

