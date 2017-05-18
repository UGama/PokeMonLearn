package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Gama on 18/5/17.
 */

public class Evolve extends AppCompatActivity {

    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;

    private ImageView Roof1;
    private ImageView Roof2;
    private ImageView PokeMon;
    private ImageView Stone;
    private Animation Left;
    private Animation Right;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.evolve);

        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer1.setVisibility(View.VISIBLE);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        transfer2.setVisibility(View.VISIBLE);
        trans_out1 = AnimationUtils.loadAnimation(Evolve.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(Evolve.this, R.anim.trans_out_down);
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

        Roof1 = (ImageView) findViewById(R.id.roof1);
        Roof2 = (ImageView) findViewById(R.id.roof2);
        PokeMon = (ImageView) findViewById(R.id.pokemon);
        Stone = (ImageView) findViewById(R.id.stone);
        Left = AnimationUtils.loadAnimation(Evolve.this, R.anim.dex_shape_left);
        Right = AnimationUtils.loadAnimation(Evolve.this, R.anim.dex_shape_right);
        Roof1.startAnimation(Right);
        PokeMon.startAnimation(Right);
        Roof2.startAnimation(Left);
        Stone.startAnimation(Left);
    }
}
