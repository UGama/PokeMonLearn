package com.example.pokemonlearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

import static com.example.pokemonlearn.R.id.transfer1;

/**
 * Created by Gama on 7/4/17.
 */

public class Capture extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private ImageView transfer;
    private ImageView white;
    private Animation shrink_white;
    private Animation shrink;

    private ImageView Pokemon;
    private ImageView roof;
    private ImageView character;
    private Animation show_up;
    private Animation show_up2;

    private ImageView fightText;
    private Animation fightText_show;
    private TextView fightMessage;

    private Button Bag;
    private Button pokemonBall;
    private Button run;
    private Animation float1;
    private Animation float2;
    private Animation float3;

    private Animation trans1_in;
    private Animation trans2_in;
    private ImageView transfer21;
    private ImageView transfer22;
    private Animation transit;

    private PokeMon C_PokeMon;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.capture);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        Log.i("Capture", name);

        List<PokeMon> List;
        List = DataSupport.where("Name = ?", name).find(PokeMon.class);
        C_PokeMon = List.get(0);

        white = (ImageView) findViewById(transfer1);
        white.setVisibility(View.VISIBLE);
        shrink_white = AnimationUtils.loadAnimation(Capture.this, R.anim.white_disapper);
        white.startAnimation(shrink_white);
        shrink_white.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                white.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Pokemon = (ImageView) findViewById(R.id.pokemon_capture);
        Pokemon.setBackgroundResource(C_PokeMon.getImageSourceId());
        Pokemon.setVisibility(View.GONE);
        roof = (ImageView) findViewById(R.id.roof);
        roof.setVisibility(View.GONE);
        character = (ImageView) findViewById(R.id.character_capture);
        character.setVisibility(View.GONE);
        fightText = (ImageView) findViewById(R.id.fight_text);
        fightText.setVisibility(View.GONE);
        fightMessage = (TextView) findViewById(R.id.fight_message);
        fightMessage.setVisibility(View.GONE);
        fightText_show = AnimationUtils.loadAnimation(Capture.this, R.anim.anim4);

        Bag = (Button) findViewById(R.id.bag);
        Bag.setVisibility(View.GONE);
        Bag.setOnClickListener(this);
        Bag.setOnTouchListener(this);
        pokemonBall = (Button) findViewById(R.id.pokemonBall);
        pokemonBall.setVisibility(View.GONE);
        pokemonBall.setOnClickListener(this);
        pokemonBall.setOnTouchListener(this);
        run = (Button) findViewById(R.id.run);
        run.setVisibility(View.GONE);
        run.setOnClickListener(this);
        run.setOnTouchListener(this);
        float1 = AnimationUtils.loadAnimation(Capture.this, R.anim.cap_float1);
        float2 = AnimationUtils.loadAnimation(Capture.this, R.anim.cap_float2);
        float3 = AnimationUtils.loadAnimation(Capture.this, R.anim.cap_float3);

        show_up = AnimationUtils.loadAnimation(Capture.this, R.anim.show_up);
        show_up2 = AnimationUtils.loadAnimation(Capture.this, R.anim.show_up2);
        show_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fightText.setVisibility(View.VISIBLE);
                fightText.startAnimation(fightText_show);
                fightMessage.setVisibility(View.VISIBLE);
                fightMessage.startAnimation(fightText_show);
                Bag.setVisibility(View.VISIBLE);
                pokemonBall.setVisibility(View.VISIBLE);
                run.setVisibility(View.VISIBLE);
                Bag.startAnimation(float2);
                pokemonBall.startAnimation(float1);
                run.startAnimation(float3);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        transfer = (ImageView) findViewById(R.id.transfer2);
        transfer.setVisibility(View.VISIBLE);
        shrink = AnimationUtils.loadAnimation(Capture.this, R.anim.shrink);
        transfer.startAnimation(shrink);
        shrink.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Pokemon.setVisibility(View.VISIBLE);
                Pokemon.startAnimation(show_up);
                roof.setVisibility(View.VISIBLE);
                roof.startAnimation(show_up);
                character.setVisibility(View.VISIBLE);
                character.startAnimation(show_up2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        trans1_in = AnimationUtils.loadAnimation(Capture.this, R.anim.trans_in_up);
        trans2_in = AnimationUtils.loadAnimation(Capture.this, R.anim.trans_in_down);
        transfer21 = (ImageView) findViewById(R.id.transfer21);
        transfer22 = (ImageView) findViewById(R.id.transfer22);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bag:
                break;
            case R.id.pokemonBall:
                break;
            case R.id.run:
                trans1_in = AnimationUtils.loadAnimation(Capture.this, R.anim.trans_in_up);
                trans2_in = AnimationUtils.loadAnimation(Capture.this, R.anim.trans_in_down);
                transfer21.setVisibility(View.VISIBLE);
                transfer21.startAnimation(trans1_in);
                transfer22.setVisibility(View.VISIBLE);
                transfer22.startAnimation(trans2_in);
                trans1_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                        transit = AnimationUtils.loadAnimation(Capture.this, R.anim.transit);
                        transfer21.startAnimation(transit);
                        transit.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                transfer21.setVisibility(View.GONE);
                                transfer22.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.bag:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Bag.getBackground().setAlpha(120);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Bag.getBackground().setAlpha(255);
                }
                break;
            case R.id.pokemonBall:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    pokemonBall.getBackground().setAlpha(120);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    pokemonBall.getBackground().setAlpha(255);
                }
                break;
            case R.id.run:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    run.getBackground().setAlpha(120);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    run.getBackground().setAlpha(255);
                }
                break;
        }
        return false;
    }
}