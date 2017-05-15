package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
 * Created by Gama on 15/5/17.
 */

public class Pet extends AppCompatActivity implements View.OnClickListener {
    private List<OwnPet> list;
    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;

    private ImageView Pet_Init;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pet);

        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer1.setVisibility(View.VISIBLE);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        transfer2.setVisibility(View.VISIBLE);
        trans_out1 = AnimationUtils.loadAnimation(Pet.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(Pet.this, R.anim.trans_out_down);
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

        Pet_Init = (ImageView) findViewById(R.id.pet_init);
        Pet_Init.setOnClickListener(this);
        DecorateInit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pet_init:
                DecorateInit();
                break;
        }
    }

    class OwnPetAdapter extends RecyclerView.Adapter<OwnPetAdapter.ViewHolder> {

        private List<OwnPet> myPetList;

        private OwnPetAdapter(List<OwnPet> myPetList) {
            this.myPetList = myPetList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pet_item, parent, false);
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
            OwnPet ownPet = myPetList.get(position);
            holder.imageView.setImageResource(ownPet.getImageResourceId());
            holder.PokeMonName.setText(ownPet.getName());
            holder.Ball.setImageResource(ownPet.getBallImageResourceId());
        }

        @Override
        public int getItemCount() {
            return myPetList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView PokeMonName;
            ImageView Ball;
            View PetItemView;
            private ViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.pet_pic);
                PokeMonName = (TextView) view.findViewById(R.id.pet_name);
                Ball = (ImageView) view.findViewById(R.id.Ball);
                PetItemView = view;
            }

        }

    }

    public void DecorateInit() {
        int[] init = new int[15];
        init[0] = R.drawable.pet_init1;
        init[1] = R.drawable.pet_init2;
        init[2] = R.drawable.pet_init3;
        init[3] = R.drawable.pet_init4;
        init[4] = R.drawable.pet_init5;
        init[5] = R.drawable.pet_init6;
        init[6] = R.drawable.pet_init7;
        init[7] = R.drawable.pet_init8;
        init[8] = R.drawable.pet_init9;
        init[9] = R.drawable.pet_init10;
        init[10] = R.drawable.pet_init11;
        init[11] = R.drawable.pet_init12;
        init[12] = R.drawable.pet_init13;
        init[13] = R.drawable.pet_init14;
        init[14] = R.drawable.pet_init15;
        int random = (int) (Math.random() * 15);
        Log.i("Random", String.valueOf(random));
        Pet_Init.setImageResource(init[random]);
    }

}
