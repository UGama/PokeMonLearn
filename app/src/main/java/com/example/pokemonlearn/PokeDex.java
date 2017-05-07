package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gama on 8/4/17.
 */

public class PokeDex extends AppCompatActivity {
    private Animation Fly_in;
    private Animation Flash;
    private Animation Left;
    private Animation Right;
    private Animation connectanim;
    private Animation Layout_fly_in;
    private Animation Layout_fly_in2;

    private ImageView Computer;
    private ImageView flash2;
    private ImageView Left_shape;
    private ImageView Right_shape;
    private ImageView Connect;

    private int times = 0;

    private TextView explain;

    private PercentRelativeLayout PokeDex_down;

    private RecyclerView recyclerView;
    private ImageView PokeDex_init;
    private ImageView UP;
    private ImageView DOWN;

    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex);
        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        trans_out1 = AnimationUtils.loadAnimation(PokeDex.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(PokeDex.this, R.anim.trans_out_down);
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

        Computer = (ImageView) findViewById(R.id.computer);
        flash2 = (ImageView) findViewById(R.id.flash2);
        flash2.setVisibility(View.GONE);
        Fly_in = AnimationUtils.loadAnimation(PokeDex.this, R.anim.left_fly_in);
        Fly_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flash2.setVisibility(View.VISIBLE);
                flash2.startAnimation(Flash);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Computer.startAnimation(Fly_in);
        Flash = AnimationUtils.loadAnimation(PokeDex.this, R.anim.flash);
        Flash.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (times <= 12) {
                    flash2.startAnimation(Flash);
                    times++;
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Left_shape = (ImageView) findViewById(R.id.choseList);
        Left = AnimationUtils.loadAnimation(PokeDex.this, R.anim.dex_shape_left);
        Left_shape.startAnimation(Left);

        Right_shape = (ImageView) findViewById(R.id.Dex);
        Right = AnimationUtils.loadAnimation(PokeDex.this, R.anim.dex_shape_right);
        Right_shape.startAnimation(Right);

        Connect = (ImageView) findViewById(R.id.connect1);
        connectanim = AnimationUtils.loadAnimation(PokeDex.this, R.anim.anim3);
        Connect.startAnimation(connectanim);

        Connect = (ImageView) findViewById(R.id.connect2);
        Connect.startAnimation(connectanim);

        PokeDex_down = (PercentRelativeLayout) findViewById(R.id.pokeDex_Layout_down);
        Layout_fly_in = AnimationUtils.loadAnimation(PokeDex.this, R.anim.layout_fly_in);
        PokeDex_down.startAnimation(Layout_fly_in);

        PokeDex_init = (ImageView) findViewById(R.id.pokeDex_Pic);
        PokeDex_init.startAnimation(Layout_fly_in);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        Layout_fly_in2 = AnimationUtils.loadAnimation(PokeDex.this, R.anim.layout_fly_in2);
        recyclerView.startAnimation(Layout_fly_in2);

        UP = (ImageView) findViewById(R.id.gold_up);
        DOWN = (ImageView) findViewById(R.id.gold_down);
        UP.startAnimation(Right);
        DOWN.startAnimation(Right);

        ArrayList<PokeMon> list = new ArrayList<>();
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
        PokeDexAdapter adapter = new PokeDexAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
