package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Gama on 9/4/17.
 */

public class MyPet extends AppCompatActivity {
    private List<OwnPet> list;
    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypet);

        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        trans_out1 = AnimationUtils.loadAnimation(MyPet.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(MyPet.this, R.anim.trans_out_down);
        transfer1.startAnimation(trans_out1);
        transfer2.startAnimation(trans_out2);
        trans_out2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                transfer1.setVisibility(View.GONE);
                transfer2.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        list = DataSupport.findAll(OwnPet.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        OwnPetAdapter adapter = new OwnPetAdapter(list);
        recyclerView.setAdapter(adapter);
    }
    class OwnPetAdapter extends RecyclerView.Adapter<OwnPetAdapter.ViewHolder> {

        private List<OwnPet> myPetList;

        public OwnPetAdapter(List<OwnPet> myPetList) {
            this.myPetList = myPetList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mypet_item, parent, false);
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
            OwnPet pokeMon = myPetList.get(position);
            holder.imageView.setImageResource(pokeMon.getImageResourceId());
            holder.PokeMonName.setText(pokeMon.getName());
        }

        @Override
        public int getItemCount() {
            return myPetList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView PokeMonName;
            View PetItemView;
            public ViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.pet_pic);
                PokeMonName = (TextView) view.findViewById(R.id.pet_name);
                PetItemView = view;
            }

        }

    }

}

