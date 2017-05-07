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

}

