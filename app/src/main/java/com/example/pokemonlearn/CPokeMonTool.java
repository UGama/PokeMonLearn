package com.example.pokemonlearn;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gama on 11/5/17.
 */

public class CPokeMonTool extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {
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
    private Button Give_Up;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_series);

        animation2 = AnimationUtils.loadAnimation(CPokeMonTool.this, R.anim.c_series_show);
        Left_Shape = (ImageView) findViewById(R.id.left_shape);
        Right_Shape1 = (PercentRelativeLayout) findViewById(R.id.right_shape1);
        Right_Shape2 = (PercentRelativeLayout) findViewById(R.id.right_shape2);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        Connect1 = (ImageView) findViewById(R.id.connect1);
        Connect2 = (ImageView) findViewById(R.id.connect2);
        Left_Shape.startAnimation(animation2);
        Right_Shape1.startAnimation(animation2);
        Right_Shape2.startAnimation(animation2);
        recyclerView.startAnimation(animation2);
        Connect1.startAnimation(animation2);
        Connect2.startAnimation(animation2);

        Item_name = (TextView) findViewById(R.id.item_name);
        Bag_Pic = (ImageView) findViewById(R.id.bag_pic);

        anim4 = AnimationUtils.loadAnimation(CPokeMonTool.this, R.anim.anim4);

        List<PokeMonTool> pokeMonTools = DataSupport.findAll(PokeMonTool.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(CPokeMonTool.this);
        recyclerView.setLayoutManager(layoutManager);
        List<OwnItem> items2 = new ArrayList<>();
        for (PokeMonTool pokeMonTool : pokeMonTools) {
            OwnItem ownItem = new OwnItem(pokeMonTool.getName(), pokeMonTool.getNumber(), 2, pokeMonTool.getImageResourceId());
            items2.add(ownItem);
        }
        ItemAdapter adapter2 = new ItemAdapter(items2);
        recyclerView.setAdapter(adapter2);

        Item = (ImageView) findViewById(R.id.Item);
        Item.setBackgroundResource(R.drawable.bag_decorate1);

        Use = (Button) findViewById(R.id.use);
        Use.setOnClickListener(this);
        Use.setOnTouchListener(this);
        Give_Up = (Button) findViewById(R.id.give_up);
        Give_Up.setOnClickListener(this);
        Give_Up.setOnTouchListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.use:
                String PMTool = Item_name.getText().toString();
                Intent intent1 = new Intent();
                intent1.putExtra("PMTool", PMTool);
                setResult(RESULT_OK, intent1);
                finish();
                break;
            case R.id.give_up:
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
                    ValueAnimator animator = ValueAnimator.ofFloat(0, 20);
                    animator.setTarget(Use);
                    animator.setDuration(100).start();
                    animator.setInterpolator(new LinearInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                    {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation)
                        {
                            Use.setTranslationY((Float) animation.getAnimatedValue());
                        }
                    });
                } else if (event.getAction() == MotionEvent.ACTION_UP ) {
                    ValueAnimator animator = ValueAnimator.ofFloat(20, 0);
                    animator.setTarget(Use);
                    animator.setDuration(100).start();
                    animator.setInterpolator(new LinearInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Use.setTranslationY((Float) animation.getAnimatedValue());
                        }
                    });
                }
                break;
            case R.id.give_up:
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    ValueAnimator animator = ValueAnimator.ofFloat(0, 20);
                    animator.setTarget(Give_Up);
                    animator.setDuration(100).start();
                    animator.setInterpolator(new LinearInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
                    {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation)
                        {
                            Give_Up.setTranslationY((Float) animation.getAnimatedValue());
                        }
                    });
                } else if (event.getAction() == MotionEvent.ACTION_UP ) {
                    ValueAnimator animator = ValueAnimator.ofFloat(20, 0);
                    animator.setTarget(Give_Up);
                    animator.setDuration(100).start();
                    animator.setInterpolator(new LinearInterpolator());
                    animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Give_Up.setTranslationY((Float) animation.getAnimatedValue());
                        }
                    });
                }
        }
        return false;
    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

        private List<OwnItem> List;

        public ItemAdapter(List<OwnItem> List) {
            this.List= List;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.bag_item_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            holder.ItemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    TextView Name = (TextView) v.findViewById(R.id.name);
                    String name = Name.getText().toString();
                    List<OwnItem> list = DataSupport.where("Name = ?", name).find(OwnItem.class);
                    OwnItem ownItem = list.get(0);
                    Item_name.setText(ownItem.getName());
                    Bag_Pic.setBackgroundResource(ownItem.getImageResourceId());
                    Bag_Pic.startAnimation(anim4);

                    Item.setVisibility(View.GONE);
                    Use.setVisibility(View.VISIBLE);
                    Give_Up.setVisibility(View.VISIBLE);
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            OwnItem ownItem= List.get(position);
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
