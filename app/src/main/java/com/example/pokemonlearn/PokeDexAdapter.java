package com.example.pokemonlearn;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Gama on 7/5/17.
 */

public class PokeDexAdapter extends RecyclerView.Adapter<PokeDexAdapter.ViewHolder> {
    private List<PokeMon> PokedexList;

    public PokeDexAdapter(List<PokeMon> myPetList) {
        this.PokedexList = myPetList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pokedex_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.PetItemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        PokeMon pokeMon = PokedexList.get(position);
        //holder.imageView.setImageResource(pokeMon.getImageSourceId());
        holder.PokeMonName.setText(pokeMon.getName());
    }

    @Override
    public int getItemCount() {
        return PokedexList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView PokeMonName;
        View PetItemView;
        public ViewHolder(View view) {
            super(view);
            //imageView = (ImageView) view.findViewById(R.id.pet_pic);
            PokeMonName = (TextView) view.findViewById(R.id.pokedex_name);
            PetItemView = view;
        }

    }
}
