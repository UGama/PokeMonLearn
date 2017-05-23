package com.example.pokemonlearn;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

import static org.litepal.crud.DataSupport.findAll;

/**
 * Created by Gama on 15/5/17.
 */

public class Pet extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
    private List<OwnPet> list;
    private String Name;
    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;

    private PercentRelativeLayout Layout_Left1;
    private PercentRelativeLayout Layout_Left2;
    private PercentRelativeLayout Layout_Right;
    private Button Free;
    private Button Evolve;
    private Button Learn;
    private Animation float1;
    private Animation float2;
    private Animation float3;
    private ImageView Connect1;
    private ImageView Connect2;
    private ImageView Pet_Init;
    private RecyclerView recyclerView;
    private Animation animation2;
    private Animation animation3;
    private boolean FirstTouch;
    private ImageView Pet_Pic;

    private View TempView;
    private boolean Gone;
    private AnimatorSet animatorSet;

    private TextView Pet_Message;
    private ImageView Screen;
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

        list = findAll(OwnPet.class);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        OwnPetAdapter adapter = new OwnPetAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setVisibility(View.GONE);

        Pet_Init = (ImageView) findViewById(R.id.pet_init);
        Pet_Init.setVisibility(View.GONE);
        Pet_Init.setOnClickListener(this);

        animation2 = AnimationUtils.loadAnimation(Pet.this, R.anim.anim2);
        animation3 = AnimationUtils.loadAnimation(Pet.this, R.anim.anim3);
        Layout_Left1 = (PercentRelativeLayout) findViewById(R.id.Layout_Left1);
        Layout_Right = (PercentRelativeLayout) findViewById(R.id.Layout_Right);
        Layout_Left1.startAnimation(animation2);
        Layout_Right.startAnimation(animation2);
        Connect1 = (ImageView) findViewById(R.id.connect1);
        Connect1.startAnimation(animation3);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                recyclerView.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(recyclerView, "translationX", 800, 0);
                objectAnimator1.setDuration(600);
                objectAnimator1.setInterpolator(new LinearInterpolator());
                objectAnimator1.start();
                Pet_Init.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(Pet_Init, "translationX", -800, 0);
                objectAnimator2.setDuration(600);
                objectAnimator2.setInterpolator(new LinearInterpolator());
                objectAnimator2.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Layout_Left2 = (PercentRelativeLayout) findViewById(R.id.Layout_Left2);
        Layout_Left2.setVisibility(View.GONE);
        Connect2 = (ImageView) findViewById(R.id.connect2);
        Connect2.setVisibility(View.GONE);
        FirstTouch = true;

        Free = (Button) findViewById(R.id.free);
        Free.setOnClickListener(this);
        Free.setOnTouchListener(this);
        Free.setVisibility(View.GONE);
        Evolve = (Button) findViewById(R.id.evolve);
        Evolve.setOnClickListener(this);
        Evolve.setOnTouchListener(this);
        Evolve.setVisibility(View.GONE);
        Learn = (Button) findViewById(R.id.learn);
        Learn.setOnClickListener(this);
        Learn.setOnTouchListener(this);
        Learn.setVisibility(View.GONE);
        float1 = AnimationUtils.loadAnimation(Pet.this, R.anim.cap_float1);
        float2 = AnimationUtils.loadAnimation(Pet.this, R.anim.cap_float2);
        float3 = AnimationUtils.loadAnimation(Pet.this, R.anim.cap_float3);

        Pet_Pic = (ImageView) findViewById(R.id.Pet_Pic);

        Pet_Message = (TextView) findViewById(R.id.pet_message);
        Screen = (ImageView) findViewById(R.id.screen);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pet_init:
                //DecorateInit();
                break;
            case R.id.learn:
                Intent intent1 = new Intent(Pet.this, PPokeMonBook.class);
                intent1.putExtra("PokeMon", Name);
                startActivityForResult(intent1, 3);
                overridePendingTransition(0, 0);
                break;
            case R.id.evolve:
                List<PokeMon> pokeMons = DataSupport.where("Name = ?", Name).find(PokeMon.class);
                PokeMon pokeMon = pokeMons.get(0);
                if (pokeMon.Senior == null) {
                    String tip = Name + " 已是最高级形态。";
                    Pet_Message.setText(tip);
                    ScreenRun(Screen);
                } else {
                    Log.i("PokeMon", pokeMon.getName() + " " + pokeMon.Senior);
                    Intent intent2 = new Intent(Pet.this, PPokeMonStone.class);
                    intent2.putExtra("PokeMon", Name);
                    startActivityForResult(intent2, 4);
                    overridePendingTransition(0, 0);
                }
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.free:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Free.getBackground().setAlpha(125);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Free.getBackground().setAlpha(255);
                }
                break;
            case R.id.evolve:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Evolve.getBackground().setAlpha(125);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Evolve.getBackground().setAlpha(255);
                }
                break;
            case R.id.learn:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Learn.getBackground().setAlpha(125);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    Learn.getBackground().setAlpha(255);
                }
                break;
        }
        return false;
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
                    if (FirstTouch) {
                        Free.setVisibility(View.VISIBLE);
                        Evolve.setVisibility(View.VISIBLE);
                        Learn.setVisibility(View.VISIBLE);
                        Free.startAnimation(float3);
                        Evolve.startAnimation(float1);
                        Learn.startAnimation(float2);
                        Layout_Left2.setVisibility(View.VISIBLE);
                        Connect2.setVisibility(View.VISIBLE);
                        TempView = v;
                        ImageView arrow = (ImageView) v.findViewById(R.id.arrow);
                        arrow.setVisibility(View.VISIBLE);
                        Log.i("Pet", "Arrow Move");
                        Up_Down(arrow);
                        FirstTouch = false;
                        Gone = false;
                    } else {
                        if (TempView != v) {
                            Gone = true;
                            animatorSet.end();
                            ImageView new_arrow = (ImageView) v.findViewById(R.id.arrow);
                            new_arrow.setVisibility(View.VISIBLE);
                            ImageView old_arrow = (ImageView) TempView.findViewById(R.id.arrow);
                            old_arrow.setVisibility(View.GONE);
                            TempView = v;
                            Log.i("Pet", "Arrow Move");
                            Up_Down(new_arrow);
                        }
                    }
                    TextView name = (TextView) v.findViewById(R.id.pet_name);
                    Name = name.getText().toString();
                    List<OwnPet> list = DataSupport.where("Name = ?", Name).find(OwnPet.class);
                    OwnPet ownPet = list.get(0);
                    Pet_Pic.setImageResource(ownPet.getImageResourceId());
                    Pet_Message.setText("");
                    Log.i("Pet", Name);
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

    public void Up_Down(View v) {
        final View view = v;

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(v, "translationY", -20, 20);
        objectAnimator1.setDuration(400);
        objectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(v, "translationY", 20, -20);
        objectAnimator2.setDuration(400);
        objectAnimator2.setInterpolator(new AccelerateDecelerateInterpolator());

        animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator1).before(objectAnimator2);
        animatorSet.start();
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (Gone) {
                    Gone = false;
                } else {
                    Up_Down(view);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void ScreenRun(View view) {
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "scaleX",
                1.0f, 0.0f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "translationX",
                0, 450);
        AnimatorSet animSet = new AnimatorSet();
        animSet.setDuration(1500);
        animSet.setInterpolator(new LinearInterpolator());
        animSet.playTogether(anim1, anim2);
        animSet.start();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 4:
                if (resultCode == RESULT_OK) {
                    Layout_Left2.setVisibility(View.GONE);
                    Connect2.setVisibility(View.GONE);
                    FirstTouch = true;
                    list = findAll(OwnPet.class);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                    recyclerView.setLayoutManager(layoutManager);
                    OwnPetAdapter adapter = new OwnPetAdapter(list);
                    recyclerView.setAdapter(adapter);
                }
        }
    }
}
