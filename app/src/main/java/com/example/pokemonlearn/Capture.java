package com.example.pokemonlearn;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
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
    private ImageView next_text;
    private ImageView Text_Screen;
    private Animation animation1;
    private Animation animation2;
    private int MessageCount;
    private View.OnClickListener messageClick;

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

    private ImageView PMBall;

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
        fightText.setOnClickListener(this);
        fightText.setVisibility(View.GONE);
        fightMessage = (TextView) findViewById(R.id.fight_message);
        fightMessage.setVisibility(View.GONE);
        Text_Screen = (ImageView) findViewById(R.id.screen);
        Text_Screen.setVisibility(View.GONE);
        next_text = (ImageView) findViewById(R.id.next_text);
        next_text.setVisibility(View.GONE);
        MessageCount = 0;

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
                next_text.setVisibility(View.VISIBLE);
                next_text.startAnimation(fightText_show);
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

        fightText_show = AnimationUtils.loadAnimation(Capture.this, R.anim.anim4);
        fightText_show.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation1 = AnimationUtils.loadAnimation(Capture.this, R.anim.up2);
                animation1.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        next_text.startAnimation(animation2);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                animation2 = AnimationUtils.loadAnimation(Capture.this, R.anim.down2);
                animation2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        next_text.startAnimation(animation1);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                next_text.startAnimation(animation1);
                Text_Screen.setVisibility(View.VISIBLE);
                fightMessage.setText("野生的 " + C_PokeMon.getName() + " 出现了！");
                MessageCount++;
                ScreenRun(Text_Screen);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        PMBall = (ImageView) findViewById(R.id.PMBall);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bag:
                Intent intent1 = new Intent(Capture.this, CPokeMonTool.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.pokemonBall:
                Intent intent2 = new Intent(Capture.this, CPokeMonBall.class);
                startActivityForResult(intent2, 2);
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
            case R.id.fight_text:
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String PMTool = data.getStringExtra("PMTool");
                    Log.i("PMTool", PMTool);
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    String pmBall = data.getStringExtra("PMBall");
                    Log.i("PMBall", pmBall);
                    List<PokeMonBall> list = DataSupport.where("Name = ?", pmBall).find(PokeMonBall.class);
                    PMBall.setBackgroundResource(list.get(0).getImageSourceId());
                    PMBall.setVisibility(View.VISIBLE);
                    ProfileMotion(PMBall);
                }
                break;
        }
    }

    public void ScreenRun(View view) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "scaleX",
                1.0f, 0.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "translationX",
                0, 450);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(2000);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.playTogether(anim1, anim2);
        animSet.start();

        messageClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (MessageCount) {
                    case 1:
                        ObjectAnimator anim1 = ObjectAnimator.ofFloat(Text_Screen, "scaleX",
                                1.0f, 0.0f);
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(Text_Screen, "translationX",
                                0, 450);
                        AnimatorSet animSet = new AnimatorSet();
                        animSet.setDuration(2500);
                        animSet.setInterpolator(new LinearInterpolator());
                        animSet.playTogether(anim1, anim2);
                        animSet.start();
                        fightMessage.setText("你要做什么？");
                        animation1.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                next_text.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                next_text.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        animation2.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                next_text.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                next_text.setVisibility(View.GONE);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        MessageCount++;
                        Bag.setVisibility(View.VISIBLE);
                        pokemonBall.setVisibility(View.VISIBLE);
                        run.setVisibility(View.VISIBLE);
                        Bag.startAnimation(float2);
                        pokemonBall.startAnimation(float1);
                        run.startAnimation(float3);
                        break;
                }
            }
        };
        fightText.setOnClickListener(messageClick);
    }

    public void ProfileMotion(final View V) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(2000);
        valueAnimator.setObjectValues(new PointF(70, 475));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue,
                                   PointF endValue) {

                PointF point = new PointF();
                point.x = 70 + 350 * fraction * 2;
                point.y = 0.5f * 450 * ((1 - fraction) * 2) * ((1 - fraction) * 2);
                return point;
            }
        });

        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                V.setX(point.x);
                V.setY(point.y);
            }
        });
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(PMBall, "rotation",
                0.0f, 360f);
        objectAnimator.setDuration(200);
        objectAnimator.setRepeatCount(9);
        objectAnimator.start();
        objectAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                PMInto();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void PMInto() {
        ObjectAnimator anim0 = ObjectAnimator.ofFloat(Pokemon, "rotation", 0, 0);
        anim0.setDuration(200);
        anim0.start();
        anim0.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator anim1 = ObjectAnimator.ofFloat(Pokemon, "scaleX",
                        1.0f, 0.0f);
                ObjectAnimator anim2 = ObjectAnimator.ofFloat(Pokemon, "scaleY",
                        1.0f, 0.0f);
                ObjectAnimator anim3 = ObjectAnimator.ofFloat(Pokemon, "rotation",
                        0.0f, 360f);
                ObjectAnimator anim4 = ObjectAnimator.ofFloat(Pokemon, "translationY",
                        0, -200);
                AnimatorSet animSet = new AnimatorSet();
                animSet.setDuration(1000);
                animSet.setInterpolator(new LinearInterpolator());
                animSet.play(anim1).with(anim2).with(anim3).with(anim4);
                animSet.start();
                animSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        HitGround();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void HitGround() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(1600);
        valueAnimator.setObjectValues(new PointF(770, 0));
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                PointF point = new PointF();
                if (fraction < 0.4) {
                    point.x = 770;
                    point.y = 117 * (fraction * 4) * (fraction * 4);
                } else if (fraction < 0.7) {
                    fraction = 0.7f - fraction;
                    point.x = 770;
                    point.y = 300 - 108 + 75 * (fraction * 4) * (fraction * 4);
                } else {
                    fraction -= 0.7;
                    point.x = 770;
                    point.y = 192 + 75 * (fraction * 4) * (fraction * 4);
                }
                return point;
            }
        });
        valueAnimator.start();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                PMBall.setX(point.x);
                PMBall.setY(point.y);
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Struggle();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void Struggle() {
        final ObjectAnimator anim0 = ObjectAnimator.ofFloat(PMBall, "rotation", 0, 0);
        anim0.setDuration(200);
        anim0.start();
        anim0.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(PMBall, "rotation", 0, 45);
                ValueAnimator valueAnimator = new ValueAnimator();
                valueAnimator.setObjectValues(new PointF(70, 475));
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
                    // fraction = t / duration
                    @Override
                    public PointF evaluate(float fraction, PointF startValue,
                                           PointF endValue) {
                        PointF point = new PointF();
                        point.x = 770 + fraction * 30;
                        point.y = 300;
                        return point;
                    }
                });
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        PointF point = (PointF) animation.getAnimatedValue();
                        PMBall.setX(point.x);
                        PMBall.setY(point.y);
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(300);
                animatorSet.play(objectAnimator).with(valueAnimator);
                animatorSet.start();
                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(PMBall, "rotation", 45, 0);
                        ValueAnimator valueAnimator = new ValueAnimator();
                        valueAnimator.setObjectValues(new PointF(70, 475));
                        valueAnimator.setInterpolator(new LinearInterpolator());
                        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
                            // fraction = t / duration
                            @Override
                            public PointF evaluate(float fraction, PointF startValue,
                                                   PointF endValue) {
                                PointF point = new PointF();
                                point.x = 800 - fraction * 30;
                                point.y = 300;
                                return point;
                            }
                        });
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                PointF point = (PointF) animation.getAnimatedValue();
                                PMBall.setX(point.x);
                                PMBall.setY(point.y);
                            }
                        });
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.setDuration(300);
                        animatorSet.play(objectAnimator).with(valueAnimator);
                        animatorSet.start();
                        animatorSet.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animation) {
                                
                            }

                            @Override
                            public void onAnimationCancel(Animator animation) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animation) {

                            }
                        });
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}