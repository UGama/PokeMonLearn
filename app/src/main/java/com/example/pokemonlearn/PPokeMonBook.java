package com.example.pokemonlearn;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by Gama on 17/5/17.
 */

public class PPokeMonBook extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private OwnPet P_OwnPet;

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
    private Animation anim4;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pc_series);

        Intent intent = getIntent();
        String Name = intent.getStringExtra("PokeMon");
        List<OwnPet> list = DataSupport.where("Name = ?", Name).find(OwnPet.class);
        P_OwnPet = list.get(0);
        Log.i("OwnPet", Name);

        Layout_Up = (PercentRelativeLayout) findViewById(R.id.Layout_up);
        Layout_Up.setOnClickListener(this);
        animation2 = AnimationUtils.loadAnimation(PPokeMonBook.this, R.anim.pc_series_show);
        Left_Shape = (ImageView) findViewById(R.id.left_shape);
        Right_Shape1 = (PercentRelativeLayout) findViewById(R.id.right_shape1);
        Right_Shape2 = (PercentRelativeLayout) findViewById(R.id.right_shape2);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        Connect1 = (ImageView) findViewById(R.id.connect1);
        Connect2 = (ImageView) findViewById(R.id.connect2);
        Connect1.setVisibility(View.GONE);
        Connect2.setVisibility(View.GONE);
        Left_Shape.startAnimation(animation2);
        Right_Shape1.startAnimation(animation2);
        Right_Shape2.startAnimation(animation2);
        recyclerView.startAnimation(animation2);
        Connect1.startAnimation(animation2);
        Connect2.startAnimation(animation2);
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Connect1.setVisibility(View.VISIBLE);
                Connect2.setVisibility(View.VISIBLE);
                Connect1.startAnimation(anim4);
                Connect2.startAnimation(anim4);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Item_name = (TextView) findViewById(R.id.item_name);
        Bag_Pic = (ImageView) findViewById(R.id.bag_pic);
        Bag_Pic.setBackgroundResource(R.drawable.init_ball4);

        anim4 = AnimationUtils.loadAnimation(PPokeMonBook.this, R.anim.anim4);
        anim4.setAnimationListener(new Animation.AnimationListener() {
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

        List<OwnItem> ownItems = DataSupport.where("Type = ?", "4").find(OwnItem.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(PPokeMonBook.this);
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

        Float2 = AnimationUtils.loadAnimation(PPokeMonBook.this, R.anim.cap_float2);
        Float3 = AnimationUtils.loadAnimation(PPokeMonBook.this, R.anim.cap_float3);

        Message = (TextView) findViewById(R.id.PC_message);
        Message.setVisibility(View.GONE);
        Text = (ImageView) findViewById(R.id.PC_text);
        Text.setVisibility(View.GONE);
        Screen = (ImageView) findViewById(R.id.screen);
        Screen.setVisibility(View.GONE);
        Text_Show = AnimationUtils.loadAnimation(PPokeMonBook.this, R.anim.anim4);

        FirstTouch = true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Layout_up:
                Item_name.setText(" ? ? ? ");
                Bag_Pic.setBackgroundResource(R.drawable.init_ball4);
                Item.setVisibility(View.VISIBLE);
                Use.setVisibility(View.GONE);
                Cancel.setVisibility(View.GONE);
                FirstTouch = true;
                break;
            case R.id.use:
                String PMStone = Item_name.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("PMBook", PMStone);
                setResult(RESULT_OK, intent1);
                finish();
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
                    Bag_Pic.startAnimation(anim4);

                    if (FirstTouch) {
                        Use.setVisibility(View.VISIBLE);
                        Cancel.setVisibility(View.VISIBLE);
                        Use.startAnimation(Float2);
                        Cancel.startAnimation(Float3);
                        FirstTouch = false;
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            OwnItem ownItem = List.get(position);
            holder.Name.setText(ownItem.getName());
            holder.Number.setText(String.valueOf(ownItem.getNumber()));
        }

        @Override
        public int getItemCount() {
            return List.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView Name;
            TextView Number;
            View ItemView;

            public ViewHolder(View view) {
                super(view);
                Name = (TextView) view.findViewById(R.id.name);
                Number = (TextView) view.findViewById(R.id.number);
                ItemView = view;
            }
        }
    }
}

