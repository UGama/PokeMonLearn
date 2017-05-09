package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gama on 7/4/17.
 */

public class Bag extends AppCompatActivity {
    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private ViewPagerIndicator indicator;

    private TextView Item;
    private ImageView Background;
    private ImageView RightArrow;
    private ImageView LeftArrow;

    private Animation animation1;
    private Animation animation2;
    private Animation animation3;
    private Animation layout_in;

    private PercentRelativeLayout layout_down;

    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;

    private RecyclerView recyclerView;
    private ImageView Bag_Pic;
    private Animation anim4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bag);

        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer1.setVisibility(View.VISIBLE);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        transfer2.setVisibility(View.VISIBLE);
        trans_out1 = AnimationUtils.loadAnimation(Bag.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(Bag.this, R.anim.trans_out_down);
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

        myPagerAdapter = new MyPagerAdapter();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(myPagerAdapter);
        indicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        indicator.setLength(myPagerAdapter.List.size());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.setSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Item = (TextView) findViewById(R.id.Item);
        Background = (ImageView) findViewById(R.id.background);
        animation3 = AnimationUtils.loadAnimation(Bag.this, R.anim.anim2);
        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                RightArrow.setVisibility(View.VISIBLE);
                LeftArrow.setVisibility(View.VISIBLE);
                RightArrow.startAnimation(animation1);
                LeftArrow.startAnimation(animation1);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        Background.startAnimation(animation3);
        Item.startAnimation(animation3);
        viewPager.startAnimation(animation3);

        RightArrow = (ImageView) findViewById(R.id.right_arrow);
        RightArrow.setVisibility(View.GONE);
        LeftArrow = (ImageView) findViewById(R.id.left_arrow);
        LeftArrow.setVisibility(View.GONE);
        animation1 = AnimationUtils.loadAnimation(Bag.this, R.anim.up);
        animation2 = AnimationUtils.loadAnimation(Bag.this, R.anim.down);
        animation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                RightArrow.startAnimation(animation2);
                LeftArrow.startAnimation(animation2);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        animation2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                RightArrow.startAnimation(animation1);
                LeftArrow.startAnimation(animation1);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        layout_down = (PercentRelativeLayout) findViewById(R.id.bag_layout_down);
        layout_in = AnimationUtils.loadAnimation(Bag.this, R.anim.anim3);
        layout_down.startAnimation(layout_in);

        Bag_Pic = (ImageView) findViewById(R.id.bag_pic);
        Bag_Pic.startAnimation(animation3);



    }
    public class MyPagerAdapter extends android.support.v4.view.PagerAdapter{

        List<String> List = new ArrayList<>();

        public MyPagerAdapter(){
            List.add("精灵球");
            List.add("道具");
            List.add("工具");
            List.add("秘籍");
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position%List.size();
            View view = LayoutInflater.from(Bag.this).inflate(R.layout.bag_item, null);
            TextView textView = (TextView) view.findViewById(R.id.item);
            textView.setText(List.get(position));
            recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
            List<PokeMonBall> pokeMons = DataSupport.findAll(PokeMonBall.class);
            LinearLayoutManager layoutManager = new LinearLayoutManager(Bag.this);
            recyclerView.setLayoutManager(layoutManager);
            PokeMonBallAdapter adapter = new PokeMonBallAdapter(pokeMons);
            recyclerView.setAdapter(adapter);
            container.addView(view);
            return view;
        }
    }
    class PokeMonBallAdapter extends RecyclerView.Adapter<PokeMonBallAdapter.ViewHolder> {

        private List<PokeMonBall> List;

        public PokeMonBallAdapter(List<PokeMonBall> List) {
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
                    List<PokeMonBall> list = DataSupport.where("Name = ?", name).find(PokeMonBall.class);
                    PokeMonBall pokeMonBall = list.get(0);
                    Bag_Pic.setBackgroundResource(pokeMonBall.getImageSourceId());
                    anim4 = AnimationUtils.loadAnimation(Bag.this, R.anim.anim4);
                    Bag_Pic.startAnimation(anim4);
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            PokeMonBall pokeMonBall = List.get(position);
            holder.Name.setText(pokeMonBall.getName());
            holder.Number.setText(String.valueOf(pokeMonBall.getNumber()));
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

