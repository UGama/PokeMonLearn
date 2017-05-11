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

    private ImageView Item;
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
    private TextView Item_name;

    private ViewPage v1;
    private ViewPage v2;
    private ViewPage v3;
    private ViewPage v4;

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
        anim4 = AnimationUtils.loadAnimation(Bag.this, R.anim.anim4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.setSelected(position);
                position = position % 4;
                Bag_Pic.startAnimation(anim4);
                Item_name.startAnimation(anim4);
                switch (position) {
                    case 0:
                        Item.setBackgroundResource(v1.SourceId1);
                        Bag_Pic.setBackgroundResource(v1.SourceId2);
                        Item_name.setText(" ? ? ? ");
                        break;
                    case 1:
                        Item.setBackgroundResource(v2.SourceId1);
                        Bag_Pic.setBackgroundResource(v2.SourceId2);
                        Item_name.setText(" ? ? ? ");
                        break;
                    case 2:
                        Item.setBackgroundResource(v3.SourceId1);
                        Bag_Pic.setBackgroundResource(v3.SourceId2);
                        Item_name.setText(" ? ? ? ");
                        break;
                    case 3:
                        Item.setBackgroundResource(v4.SourceId1);
                        Bag_Pic.setBackgroundResource(v4.SourceId2);
                        Item_name.setText(" ? ? ? ");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Item = (ImageView) findViewById(R.id.Item);
        Background = (ImageView) findViewById(R.id.background);
        animation3 = AnimationUtils.loadAnimation(Bag.this, R.anim.anim2);
        Background.startAnimation(animation3);
        Item.startAnimation(animation3);
        viewPager.startAnimation(animation3);
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
        Item_name = (TextView) findViewById(R.id.item_name);
        Item_name.startAnimation(animation3);

    }
    public class MyPagerAdapter extends android.support.v4.view.PagerAdapter{

        List<ViewPage> List = new ArrayList<>();

        public MyPagerAdapter(){
            v1 = new ViewPage("精灵球", R.drawable.bag_decorate, R.drawable.init_ball, 1);
            v2 = new ViewPage("道具", R.drawable.bag_decorate1, R.drawable.init_ball2, 2);
            v3 = new ViewPage("进化石", R.drawable.bag_decorate2, R.drawable.init_ball3, 3);
            v4 = new ViewPage("秘籍", R.drawable.bag_decorate3, R.drawable.init_ball4, 4);
            List.add(v1);
            List.add(v2);
            List.add(v3);
            List.add(v4);
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
            textView.setText(List.get(position).Name);
            recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
            switch (List.get(position).Number) {
                case 1:
                    List<PokeMonBall> pokeMonBalls = DataSupport.findAll(PokeMonBall.class);
                    LinearLayoutManager layoutManager1 = new LinearLayoutManager(Bag.this);
                    recyclerView.setLayoutManager(layoutManager1);
                    List<OwnItem> items1 = new ArrayList<>();
                    for (PokeMonBall pokeMonBall : pokeMonBalls) {
                        OwnItem ownItem = new OwnItem(pokeMonBall.getName(), pokeMonBall.getNumber(), 1, pokeMonBall.getImageSourceId());
                        items1.add(ownItem);
                    }
                    ItemAdapter adapter1 = new ItemAdapter(items1);
                    recyclerView.setAdapter(adapter1);
                    break;
                case 2:
                    List<PokeMonTool> pokeMonTools = DataSupport.findAll(PokeMonTool.class);
                    LinearLayoutManager layoutManager2 = new LinearLayoutManager(Bag.this);
                    recyclerView.setLayoutManager(layoutManager2);
                    List<OwnItem> items2 = new ArrayList<>();
                    for (PokeMonTool pokeMonTool : pokeMonTools) {
                        OwnItem ownItem = new OwnItem(pokeMonTool.getName(), pokeMonTool.getNumber(), 2, pokeMonTool.getImageResourceId());
                        items2.add(ownItem);
                    }
                    ItemAdapter adapter2 = new ItemAdapter(items2);
                    recyclerView.setAdapter(adapter2);
                    break;
                case 3:
                    List<PokeMonStone> pokeMonStones = DataSupport.findAll(PokeMonStone.class);
                    LinearLayoutManager layoutManager3 = new LinearLayoutManager(Bag.this);
                    recyclerView.setLayoutManager(layoutManager3);
                    List<OwnItem> items3 = new ArrayList<>();
                    for (PokeMonStone pokeMonStone : pokeMonStones) {
                        OwnItem ownItem = new OwnItem(pokeMonStone.getName(), pokeMonStone.getNumber(), 3, pokeMonStone.getImageResourceId());
                        items3.add(ownItem);
                    }
                    ItemAdapter adapter3 = new ItemAdapter(items3);
                    recyclerView.setAdapter(adapter3);
                    break;
                case 4:
                    List<PokeMonBook> pokeMonBooks = DataSupport.findAll(PokeMonBook.class);
                    LinearLayoutManager layoutManager4 = new LinearLayoutManager(Bag.this);
                    recyclerView.setLayoutManager(layoutManager4);
                    List<OwnItem> items4 = new ArrayList<>();
                    for (PokeMonBook pokeMonBook : pokeMonBooks) {
                        OwnItem ownItem = new OwnItem(pokeMonBook.getName(), pokeMonBook.getNumber(), 4, pokeMonBook.getImageResourceId());
                        items4.add(ownItem);
                    }
                    ItemAdapter adapter4 = new ItemAdapter(items4);
                    recyclerView.setAdapter(adapter4);
                    break;
            }
            container.addView(view);
            return view;
        }
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

    class ViewPage {
        private String Name;
        private int SourceId1;
        private int SourceId2;
        private int Number;
        public ViewPage(String name, int S1, int S2,int number) {
            this.Name = name;
            this.SourceId1 = S1;
            this.SourceId2 = S2;
            this.Number = number;
        }
    }
}

