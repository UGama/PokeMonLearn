package com.example.pokemonlearn;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gama on 25/5/17.
 */

public class SSell extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;

    private PercentRelativeLayout Layout_Left1;
    private PercentRelativeLayout Layout_Left2;
    private PercentRelativeLayout Layout_Right;
    private Animation float2;
    private Animation float3;
    private ImageView Connect1;
    private ImageView Connect2;
    private ImageView Pet_Init;
    private RecyclerView recyclerView;
    private Animation animation2;
    private Animation animation3;
    private boolean FirstTouch;
    private ImageView S_Pic;
    private ImageView Item_Pic;
    private TextView Item_Name;
    private Animation anim4;

    private ImageView RightArrow;
    private ImageView LeftArrow;
    private AnimatorSet Right;
    private AnimatorSet Left;

    private Button Sell;
    private Button Cancel;

    private TextView SSell_Message;
    private ImageView Screen;
    private int Price;

    private ViewPage v1;
    private ViewPage v2;
    private ViewPage v3;
    private ViewPage v4;

    private ViewPager viewPager;
    private MyPagerAdapter myPagerAdapter;
    private ViewPagerIndicator indicator;
    private int PagesCount;

    private int MessageCount;

    private ImageView Black;
    private PercentRelativeLayout Dialog;
    private EditText editText;
    private Button D_Confirm;
    private Button D_Cancel;
    private int number;//(Buy Count)
    private int NumberInBag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_series);

        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer1.setVisibility(View.VISIBLE);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        transfer2.setVisibility(View.VISIBLE);
        trans_out1 = AnimationUtils.loadAnimation(SSell.this, R.anim.trans_out_up);
        trans_out2 = AnimationUtils.loadAnimation(SSell.this, R.anim.trans_out_down);
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
        viewPager.setVisibility(View.GONE);
        viewPager.setAdapter(myPagerAdapter);
        indicator = (ViewPagerIndicator) findViewById(R.id.indicator);
        indicator.setLength(myPagerAdapter.List.size());
        anim4 = AnimationUtils.loadAnimation(SSell.this, R.anim.anim4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                indicator.setSelected(position);
                position = position % 4;
                FirstTouch = true;
                Sell.setVisibility(View.GONE);
                Cancel.setVisibility(View.GONE);
                Item_Name.setText(" ? ? ? ");
                Log.i("Page", String.valueOf(position));
                switch (position) {
                    case 0:
                        S_Pic.startAnimation(anim4);
                        S_Pic.setImageResource(v1.SourceId1);
                        Item_Pic.setBackgroundResource(v1.SourceId2);
                        PagesCount = 1;
                        break;
                    case 1:
                        S_Pic.startAnimation(anim4);
                        S_Pic.setImageResource(v2.SourceId1);
                        Item_Pic.setBackgroundResource(v2.SourceId2);
                        PagesCount = 2;
                        break;
                    case 2:
                        S_Pic.startAnimation(anim4);
                        S_Pic.setImageResource(v3.SourceId1);
                        Item_Pic.setBackgroundResource(v3.SourceId2);
                        PagesCount = 3;
                        break;
                    case 3:
                        S_Pic.startAnimation(anim4);
                        S_Pic.setImageResource(v4.SourceId1);
                        Item_Pic.setBackgroundResource(v4.SourceId2);
                        PagesCount = 4;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        Pet_Init = (ImageView) findViewById(R.id.pet_init);
        Pet_Init.setVisibility(View.GONE);
        Pet_Init.setOnClickListener(this);

        animation2 = AnimationUtils.loadAnimation(SSell.this, R.anim.anim2);
        animation3 = AnimationUtils.loadAnimation(SSell.this, R.anim.anim3);
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
                viewPager.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(viewPager, "translationX", 800, 0);
                objectAnimator1.setDuration(600);
                objectAnimator1.setInterpolator(new LinearInterpolator());
                objectAnimator1.start();
                S_Pic.setVisibility(View.VISIBLE);
                Item_Name.setVisibility(View.VISIBLE);
                Item_Pic.setVisibility(View.VISIBLE);
                ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(S_Pic, "translationX", -800, 0);
                objectAnimator2.setDuration(600);
                objectAnimator2.setInterpolator(new LinearInterpolator());
                objectAnimator2.start();
                ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(Item_Name, "translationX", -800, 0);
                objectAnimator3.setDuration(600);
                objectAnimator3.setInterpolator(new LinearInterpolator());
                objectAnimator3.start();
                ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(Item_Pic, "translationX", -800, 0);
                objectAnimator4.setDuration(600);
                objectAnimator4.setInterpolator(new LinearInterpolator());
                objectAnimator4.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        indicator.startAnimation(animation3);
        animation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                RightArrow.setVisibility(View.VISIBLE);
                LeftArrow.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        RightArrow = (ImageView) findViewById(R.id.right_arrow);
        RightArrow.setVisibility(View.GONE);
        LeftArrow = (ImageView) findViewById(R.id.left_arrow);
        LeftArrow.setVisibility(View.GONE);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(RightArrow, "translationX", 0, 50);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(RightArrow, "translationX", 50, 0);
        Right = new AnimatorSet();
        Right.setDuration(400);
        Right.play(objectAnimator2).after(objectAnimator1);
        Right.start();
        Right.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Right.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        Left = new AnimatorSet();
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(LeftArrow, "translationX", 0, -50);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(LeftArrow, "translationX", -50, 0);
        Left.setDuration(400);
        Left.play(objectAnimator4).after(objectAnimator3);
        Left.start();
        Left.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Left.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        Layout_Left2 = (PercentRelativeLayout) findViewById(R.id.Layout_Left2);
        Layout_Left2.startAnimation(animation2);
        Connect2 = (ImageView) findViewById(R.id.connect2);
        Connect2.startAnimation(animation3);

        Sell = (Button) findViewById(R.id.action);
        Sell.setOnClickListener(this);
        Sell.setOnTouchListener(this);
        Sell.setBackgroundResource(R.drawable.s_sell);
        Sell.setVisibility(View.GONE);
        Cancel = (Button) findViewById(R.id.cancel);
        Cancel.setOnClickListener(this);
        Cancel.setOnTouchListener(this);
        Cancel.setVisibility(View.GONE);

        float2 = AnimationUtils.loadAnimation(SSell.this, R.anim.cap_float2);
        float3 = AnimationUtils.loadAnimation(SSell.this, R.anim.cap_float3);

        S_Pic = (ImageView) findViewById(R.id.S_Pic);
        S_Pic.setVisibility(View.GONE);
        Item_Pic = (ImageView) findViewById(R.id.item_pic);
        Item_Pic.setVisibility(View.GONE);
        Item_Name = (TextView) findViewById(R.id.item_name);
        Item_Name.setVisibility(View.GONE);

        SSell_Message = (TextView) findViewById(R.id.s_message);
        Screen = (ImageView) findViewById(R.id.screen);

        PagesCount = 1;
        MessageCount = 0;

        Black = (ImageView) findViewById(R.id.black);
        Black.getBackground().setAlpha(120);
        Dialog = (PercentRelativeLayout) findViewById(R.id.dialog);
        editText = (EditText) findViewById(R.id.editText);
        D_Confirm = (Button) findViewById(R.id.d_confirm);
        D_Confirm.setText("出售");
        D_Confirm.setOnClickListener(this);
        D_Confirm.setOnTouchListener(this);
        D_Cancel = (Button) findViewById(R.id.d_cancel);
        D_Cancel.setOnTouchListener(this);
        D_Cancel.setOnClickListener(this);

        FirstTouch = true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action:
                if (MessageCount == 0) {
                    Sell.setBackgroundResource(R.drawable.s_comfirm);
                    Sell.startAnimation(float2);
                    Cancel.startAnimation(float3);
                    String tip = "确定要出售 " + Item_Name.getText().toString() + " 吗？";
                    SSell_Message.setText(tip);
                    ScreenRun(Screen);
                    MessageCount = 1;
                } else if (MessageCount == 1) {
                    Black.setVisibility(View.VISIBLE);
                    Dialog.setVisibility(View.VISIBLE);
                    Sell.setVisibility(View.GONE);
                    Cancel.setVisibility(View.GONE);
                }
                break;
            case R.id.cancel:
                if (MessageCount == 0) {
                    finish();
                } else if (MessageCount == 1) {
                    MessageCount = 0;
                    Sell.setBackgroundResource(R.drawable.s_sell);
                    Sell.startAnimation(float2);
                    Cancel.startAnimation(float3);
                }
                break;
            case R.id.d_confirm:
                number = Integer.valueOf(editText.getText().toString());
                if (number < 0 || number > NumberInBag) {
                    Dialog_Show();
                } else {
                    SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                    int MyCoin = preferences.getInt("Coins", 0);
                    String item_name = Item_Name.getText().toString();
                    switch (PagesCount) {
                        case 1:
                            List<PokeMonBall> pokeMonBalls = DataSupport.where("Name = ?", item_name).find(PokeMonBall.class);
                            PokeMonBall pokeMonBall = pokeMonBalls.get(0);
                            Price = pokeMonBall.getPrice();
                            break;
                        case 2:
                            List<PokeMonTool> pokeMonTools = DataSupport.where("Name = ?", item_name).find(PokeMonTool.class);
                            PokeMonTool pokeMonTool = pokeMonTools.get(0);
                            Price = pokeMonTool.getPrice();
                            break;
                        case 3:
                            List<PokeMonStone> pokeMonStones = DataSupport.where("Name = ?", item_name).find(PokeMonStone.class);
                            PokeMonStone pokeMonStone = pokeMonStones.get(0);
                            Price = pokeMonStone.getPrice();
                            break;
                        case 4:
                            List<PokeMonBook> pokeMonBooks = DataSupport.where("Name = ?", item_name).find(PokeMonBook.class);
                            PokeMonBook pokeMonBook = pokeMonBooks.get(0);
                            Price = pokeMonBook.getPrice();
                            break;
                    }
                    SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                    MyCoin += number * Price / 2;
                    editor.putInt("Coins", MyCoin);
                    editor.apply();
                    if (number == NumberInBag) {
                        DataSupport.deleteAll(OwnItem.class, "Name = ?", Item_Name.getText().toString());
                    }else {
                        List<OwnItem> ownItems = DataSupport.where("Name = ?", Item_Name.getText().toString()).
                                find(OwnItem.class);
                        OwnItem ownItem = ownItems.get(0);
                        ownItem.setNumber(NumberInBag - number);
                        ownItem.save();
                    }
                    AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("恭喜")
                            .setMessage("出售成功！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Dialog.setVisibility(View.GONE);
                                    Black.setVisibility(View.GONE);
                                    editText.setText("");
                                }
                            }).show();
                    SSell_Message.setText("");
                    FirstTouch = true;
                    MessageCount = 0;
                }
                break;
            case R.id.d_cancel:
                Dialog.setVisibility(View.GONE);
                Black.setVisibility(View.GONE);
                editText.setText("");
                Sell.setVisibility(View.VISIBLE);
                Sell.setBackgroundResource(R.drawable.s_sell);
                Sell.startAnimation(float2);
                Cancel.setVisibility(View.VISIBLE);
                Cancel.startAnimation(float3);
                MessageCount = 0;
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.action:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Sell.getBackground().setAlpha(120);
                } else {
                    Sell.getBackground().setAlpha(255);
                }
                break;
            case R.id.cancel:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Cancel.getBackground().setAlpha(120);
                } else {
                    Cancel.getBackground().setAlpha(255);
                }
                break;
            case R.id.d_confirm:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    D_Confirm.getBackground().setAlpha(120);
                } else {
                    D_Confirm.getBackground().setAlpha(255);
                }
                break;
            case R.id.d_cancel:
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    D_Cancel.getBackground().setAlpha(120);
                } else {
                    D_Cancel.getBackground().setAlpha(255);
                }
                break;
        }
        return false;
    }

    private class MyPagerAdapter extends android.support.v4.view.PagerAdapter {

        List<ViewPage> List = new ArrayList<>();

        public MyPagerAdapter() {
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
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position = position % List.size();
            View view = LayoutInflater.from(SSell.this).inflate(R.layout.bag_item, null);
            TextView textView = (TextView) view.findViewById(R.id.item);
            textView.setText(List.get(position).Name);
            recyclerView = (RecyclerView) view.findViewById(R.id.RecyclerView);
            switch (List.get(position).Number) {
                case 1:
                    List<OwnItem> ownItems1 = DataSupport.where("Type = ?", "1").find(OwnItem.class);
                    LinearLayoutManager layoutManager1 = new LinearLayoutManager(SSell.this);
                    recyclerView.setLayoutManager(layoutManager1);
                    ItemAdapter adapter1 = new ItemAdapter(ownItems1);
                    recyclerView.setAdapter(adapter1);
                    break;
                case 2:
                    List<OwnItem> ownItems2 = DataSupport.where("Type = ?", "2").find(OwnItem.class);
                    LinearLayoutManager layoutManager2 = new LinearLayoutManager(SSell.this);
                    recyclerView.setLayoutManager(layoutManager2);
                    ItemAdapter adapter2 = new ItemAdapter(ownItems2);
                    recyclerView.setAdapter(adapter2);
                    break;
                case 3:
                    List<OwnItem> ownItems3 = DataSupport.where("Type = ?", "3").find(OwnItem.class);
                    LinearLayoutManager layoutManager3 = new LinearLayoutManager(SSell.this);
                    recyclerView.setLayoutManager(layoutManager3);
                    ItemAdapter adapter3 = new ItemAdapter(ownItems3);
                    recyclerView.setAdapter(adapter3);
                    break;
                case 4:
                    List<OwnItem> ownItems4 = DataSupport.where("Type = ?", "4").find(OwnItem.class);
                    LinearLayoutManager layoutManager4 = new LinearLayoutManager(SSell.this);
                    recyclerView.setLayoutManager(layoutManager4);
                    ItemAdapter adapter4 = new ItemAdapter(ownItems4);
                    recyclerView.setAdapter(adapter4);
                    break;
            }
            container.addView(view);
            return view;
        }

    }

    class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

        private List<OwnItem> List;

        private ItemAdapter(List<OwnItem> List) {
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
                    Item_Pic.setBackgroundResource(ownItem.getImageResourceId());
                    Item_Name.setText(ownItem.getName());
                    NumberInBag = ownItem.getNumber();
                    if (FirstTouch) {
                        Sell.setVisibility(View.VISIBLE);
                        Sell.setBackgroundResource(R.drawable.s_sell);
                        Sell.startAnimation(float2);
                        Cancel.setVisibility(View.VISIBLE);
                        Cancel.startAnimation(float3);
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

    public void Dialog_Show() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setTitle("错误")
                .setMessage("请输入正确的数字。")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

}
