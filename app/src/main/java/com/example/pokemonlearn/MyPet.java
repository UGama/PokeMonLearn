package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gama on 9/4/17.
 */

public class MyPet extends AppCompatActivity {
    private List<PokeMon> list = new ArrayList<>();
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

        PokeMon p = new PokeMon(1, "Squirtle", R.drawable.squirtle2);
        PokeMon p1 = new PokeMon(2, "Charmander", R.drawable.charmander2);
        PokeMon p2 = new PokeMon(3, "Bulasaur", R.drawable.bulbasaur2);
        PokeMon p3 = new PokeMon(4, "Oddish", R.drawable.oddish2);
        PokeMon p4 = new PokeMon(5, "Pikachu", R.drawable.pikachu2);
        PokeMon p5 = new PokeMon(6, "Chansey", R.drawable.chansey2);
        PokeMon p6 = new PokeMon(7, "Clefairy", R.drawable.clefairy2);
        PokeMon p7 = new PokeMon(8, "Doduo", R.drawable.doduo2);
        PokeMon p8 = new PokeMon(9, "Jigglypuff", R.drawable.jigglypuff2);
        PokeMon p9 = new PokeMon(10, "Gengar", R.drawable.gengar2);
        PokeMon p10 = new PokeMon(11, "Magnemite", R.drawable.magnemite2);
        PokeMon p11 = new PokeMon(12, "Mankey", R.drawable.mankey2);
        PokeMon p12 = new PokeMon(13, "Onix", R.drawable.onix2);
        PokeMon p13 = new PokeMon(14, "Vulpix", R.drawable.vulpix2);
        PokeMon p14 = new PokeMon(15, "Zapdos", R.drawable.zapdos2);
        PokeMon p15 = new PokeMon(16, "Meowth", R.drawable.meowth2);
        PokeMon p16 = new PokeMon(17, "Wobbuffet", R.drawable.wobbuffet);
        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        list.add(p11);
        list.add(p12);
        list.add(p13);
        list.add(p14);
        list.add(p15);
        list.add(p16);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PokeMonAdapter adapter = new PokeMonAdapter(list);
        recyclerView.setAdapter(adapter);
    }

}

