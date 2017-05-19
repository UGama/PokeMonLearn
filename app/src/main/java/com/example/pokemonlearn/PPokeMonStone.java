package com.example.pokemonlearn;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Gama on 17/5/17.
 */

public class PPokeMonStone extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private OwnPet P_OwnPet;
    private PokeMon P_PokeMon;
    private PokeMonStone P_PokeMonStone;
    private int[][] Evolve;

    private PercentRelativeLayout Layout_Up;
    private Animation animation2;
    private ImageView Left_Shape;
    private PercentRelativeLayout Right_Shape1;
    private PercentRelativeLayout Right_Shape2;
    private ImageView Connect1;
    private ImageView Connect2;
    private RecyclerView recyclerView;

    private TextView Item_name;
    private ImageView Bag_Pic;

    private ImageView Item;
    private Button Use;
    private Button Cancel;
    private Animation Float2;
    private Animation Float3;
    private boolean FirstTouch;

    private boolean able;

    private TextView Message;
    private ImageView Text;
    private ImageView Screen;
    private Animation Text_Show;

    private Animation animation4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pc_series);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("PokeMon");
        List<OwnPet> list1 = DataSupport.where("Name = ?", Name).find(OwnPet.class);
        P_OwnPet = list1.get(0);
        List<PokeMon> list2 = DataSupport.where("Name = ?", Name).find(PokeMon.class);
        P_PokeMon = list2.get(0);
        Log.i("OwnPet", Name);
        ResolveSeniorString();

        Layout_Up = (PercentRelativeLayout) findViewById(R.id.Layout_up);
        Layout_Up.setOnClickListener(this);
        animation2 = AnimationUtils.loadAnimation(PPokeMonStone.this, R.anim.pc_series_show);
        Left_Shape = (ImageView) findViewById(R.id.left_shape);
        Right_Shape1 = (PercentRelativeLayout) findViewById(R.id.right_shape1);
        Right_Shape2 = (PercentRelativeLayout) findViewById(R.id.right_shape2);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        recyclerView.startAnimation(animation2);
        Connect1 = (ImageView) findViewById(R.id.connect1);
        Connect2 = (ImageView) findViewById(R.id.connect2);
        Left_Shape.startAnimation(animation2);
        Connect1.startAnimation(animation2);
        Connect2.startAnimation(animation2);
        Right_Shape1.startAnimation(animation2);
        Right_Shape2.startAnimation(animation2);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Message.setVisibility(View.VISIBLE);
                Text.setVisibility(View.VISIBLE);
                Screen.setVisibility(View.VISIBLE);
                Message.startAnimation(Text_Show);
                Text.startAnimation(Text_Show);
                Screen.startAnimation(Text_Show);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Item_name = (TextView) findViewById(R.id.item_name);
        Bag_Pic = (ImageView) findViewById(R.id.bag_pic);
        Bag_Pic.setBackgroundResource(R.drawable.init_ball3);

        List<OwnItem> ownItems = DataSupport.where("Type = ?", "3").find(OwnItem.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(PPokeMonStone.this);
        recyclerView.setLayoutManager(layoutManager);
        ItemAdapter adapter2 = new ItemAdapter(ownItems);
        recyclerView.setAdapter(adapter2);

        Item = (ImageView) findViewById(R.id.Item);
        Item.setBackgroundResource(P_OwnPet.getImageResourceId());

        Use = (Button) findViewById(R.id.use);
        Use.setVisibility(View.GONE);
        Use.setOnClickListener(this);
        Use.setOnTouchListener(this);
        Cancel = (Button) findViewById(R.id.cancel);
        Cancel.setVisibility(View.GONE);
        Cancel.setOnClickListener(this);
        Cancel.setOnTouchListener(this);

        Float2 = AnimationUtils.loadAnimation(PPokeMonStone.this, R.anim.cap_float2);
        Float3 = AnimationUtils.loadAnimation(PPokeMonStone.this, R.anim.cap_float3);

        Message = (TextView) findViewById(R.id.PC_message);
        Message.setVisibility(View.GONE);
        Text = (ImageView) findViewById(R.id.PC_text);
        Text.setVisibility(View.GONE);
        Screen = (ImageView) findViewById(R.id.screen);
        Screen.setVisibility(View.GONE);
        Text_Show = AnimationUtils.loadAnimation(PPokeMonStone.this, R.anim.anim4);

        FirstTouch = true;

        animation4 = AnimationUtils.loadAnimation(PPokeMonStone.this, R.anim.pc_series_show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Layout_up:
                Item_name.setText(" ? ? ? ");
                Bag_Pic.setBackgroundResource(R.drawable.init_ball3);
                Item.setVisibility(View.VISIBLE);
                Use.setVisibility(View.GONE);
                Cancel.setVisibility(View.GONE);
                FirstTouch = true;
                break;
            case R.id.use:
                if (able) {
                    String PMStone = Item_name.getText().toString();
                    List<PokeMonStone> pokeMonStones = DataSupport.where("Name = ?", PMStone).find(PokeMonStone.class);
                    P_PokeMonStone = pokeMonStones.get(0);
                    int Senior = 0;
                    for (int i=0;i<Evolve.length;i++) {
                        if (P_PokeMonStone.getNumber() == Evolve[i][0]) {
                            Senior = Evolve[i][1];
                            break;
                        }
                    }
                    Log.i("Senior Number", String.valueOf(Senior));
                    List<PokeMon> pokeMons = DataSupport.where("Number = ?", String.valueOf(Senior)).find(PokeMon.class);
                    PokeMon pokeMon = pokeMons.get(0);
                    Intent intent1 = new Intent(PPokeMonStone.this, Evolve.class);
                    intent1.putExtra("PMName", P_PokeMon.getName());
                    intent1.putExtra("PMStone", PMStone);
                    intent1.putExtra("S-PMName", pokeMon.getName());
                    startActivity(intent1);
                    finish();
                } else {
                    String tip = Item_name.getText().toString() + " 不可使用。";
                    Message.setText(tip);
                    ScreenRun(Screen);
                }
                break;
            case R.id.cancel:
                Intent intent2 = new Intent();
                setResult(RESULT_CANCELED, intent2);
                finish();
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.use:
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    Use.getBackground().setAlpha(125);
                } else if (event.getAction() == MotionEvent.ACTION_UP ) {
                    Use.getBackground().setAlpha(255);
                }
                break;
            case R.id.cancel:
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    Cancel.getBackground().setAlpha(125);
                } else if (event.getAction() == MotionEvent.ACTION_UP ) {
                    Cancel.getBackground().setAlpha(255);
                }
                break;
        }
        return false;
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

        private List<OwnItem> List;

        public ItemAdapter(List<OwnItem> List) {
            this.List = List;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.bag_item_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            holder.ItemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView Name = (TextView) v.findViewById(R.id.name);
                    String name = Name.getText().toString();
                    List<OwnItem> list = DataSupport.where("Name = ?", name).find(OwnItem.class);
                    OwnItem ownItem = list.get(0);
                    Item_name.setText(ownItem.getName());
                    Bag_Pic.setBackgroundResource(ownItem.getImageResourceId());
                    Bag_Pic.startAnimation(animation4);

                    if (FirstTouch) {
                        Use.setVisibility(View.VISIBLE);
                        Cancel.setVisibility(View.VISIBLE);
                        Use.startAnimation(Float2);
                        Cancel.startAnimation(Float3);
                        FirstTouch = false;
                    }

                    able = false;
                    for (int i = 0; i < Evolve.length; i++) {
                        if (Evolve[i][0] == ownItem.getNumberInDex()) {
                            able = true;
                            break;
                        }
                    }
                    Log.i("Able", String.valueOf(able));
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            OwnItem ownItem = List.get(position);
            holder.Name.setText(ownItem.getName());
            holder.Number.setText(String.valueOf(ownItem.getNumber()));
            boolean isUsed = false;
            for (int i=0;i<Evolve.length;i++) {
                if (Evolve[i][0] == ownItem.getNumberInDex()) {
                    isUsed = true;
                    break;
                }
            }
            if (isUsed) {
                holder.Able.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public int getItemCount() {
            return List.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView Name;
            TextView Number;
            View ItemView;
            ImageView Able;

            public ViewHolder(View view) {
                super(view);
                Name = (TextView) view.findViewById(R.id.name);
                Number = (TextView) view.findViewById(R.id.number);
                ItemView = view;
                Able = (ImageView) view.findViewById(R.id.able);
            }
        }
    }

    public void ResolveSeniorString() {
        String SeniorString = P_PokeMon.getSenior();
        char[] SeniorChar = SeniorString.toCharArray();
        int j = -1;
        int l = 0;
        int a = 0;
        for (int i=0;i<SeniorChar.length;i++) {
            if (SeniorChar[i] == '+') {
                a++;
            }
        }
        Evolve = new int[a][2];
        for (int i=0;i<SeniorChar.length;i++) {
            if (SeniorChar[i] == '+') {
                j++;
                l = 0;
            } else if (SeniorChar[i] <= '9' && SeniorChar[i] >= '0') {
                Evolve[j][l] = Evolve[j][l] * 10 + Integer.parseInt(String.valueOf(SeniorChar[i]));
            } else if (SeniorChar[i] == '/') {
                l++;
            }
        }
        for (int i=0;i<Evolve.length;i++) {
            Log.i("EvolveString", String.valueOf(Evolve[i][0]) + " " + String.valueOf(Evolve[i][1]));
        }
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
}
