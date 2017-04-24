package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

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

    private ImageView Computer;
    private ImageView flash2;
    private ImageView Left_shape;
    private ImageView Right_shape;
    private ImageView Connect;

    private int times = 0;

    private TextView explain;

    private PercentRelativeLayout PokeDex_down;

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

    }
}
