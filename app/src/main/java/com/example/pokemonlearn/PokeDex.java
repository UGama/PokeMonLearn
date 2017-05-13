package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

import static org.litepal.crud.DataSupport.findAll;

/**
 * Created by Gama on 8/4/17.
 */

public class PokeDex extends AppCompatActivity implements View.OnClickListener {
    private Animation Fly_in;
    private Animation Flash;
    private Animation Left;
    private Animation Right;
    private Animation ConnectAnim;
    private Animation Layout_fly_in;
    private Animation Layout_fly_in2;

    private ImageView Computer;
    private ImageView flash2;
    private PercentRelativeLayout Left_shape;
    private ImageView Wanted;
    private ImageView Right_shape;
    private ImageView Connect;
    private ImageView PokeDex_init;
    private TextView PokeDex_name;

    private int times = 0;

    private TextView explain;

    private PercentRelativeLayout PokeDex_down;

    private RecyclerView recyclerView;
    private ImageView UP;
    private ImageView DOWN;
    private ImageView Decorate;

    private ImageView transfer1;
    private ImageView transfer2;
    private Animation trans_out1;
    private Animation trans_out2;

    private Animation anim4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex);
        transfer1 = (ImageView) findViewById(R.id.transfer1);
        transfer2 = (ImageView) findViewById(R.id.transfer2);
        transfer1.setVisibility(View.VISIBLE);
        transfer2.setVisibility(View.VISIBLE);
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
        Computer.setOnClickListener(this);
        Flash = AnimationUtils.loadAnimation(PokeDex.this, R.anim.flash);
        Flash.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (times <= 8) {
                    flash2.startAnimation(Flash);
                    times++;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Left_shape = (PercentRelativeLayout) findViewById(R.id.choseList);
        Left = AnimationUtils.loadAnimation(PokeDex.this, R.anim.dex_shape_left);
        Left_shape.startAnimation(Left);

        Right_shape = (ImageView) findViewById(R.id.Dex);
        Right = AnimationUtils.loadAnimation(PokeDex.this, R.anim.dex_shape_right);
        Right_shape.startAnimation(Right);

        Connect = (ImageView) findViewById(R.id.connect1);
        ConnectAnim = AnimationUtils.loadAnimation(PokeDex.this, R.anim.anim3);
        Connect.startAnimation(ConnectAnim);

        Connect = (ImageView) findViewById(R.id.connect2);
        Connect.startAnimation(ConnectAnim);

        PokeDex_down = (PercentRelativeLayout) findViewById(R.id.pokeDex_Layout_down);
        Layout_fly_in = AnimationUtils.loadAnimation(PokeDex.this, R.anim.layout_fly_in);
        PokeDex_down.startAnimation(Layout_fly_in);

        Wanted = (ImageView) findViewById(R.id.wanted);
        Wanted.startAnimation(Layout_fly_in);

        PokeDex_init = (ImageView) findViewById(R.id.pokeDex_Pic);
        PokeDex_init.startAnimation(Layout_fly_in);

        PokeDex_name = (TextView) findViewById(R.id.wood_name);
        PokeDex_name.startAnimation(Layout_fly_in);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        List<PokeMon> pokeMons = findAll(PokeMon.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PokeDexAdapter adapter = new PokeDexAdapter(pokeMons);
        recyclerView.setAdapter(adapter);
        Layout_fly_in2 = AnimationUtils.loadAnimation(PokeDex.this, R.anim.layout_fly_in2);
        recyclerView.startAnimation(Layout_fly_in2);

        UP = (ImageView) findViewById(R.id.gold_up);
        DOWN = (ImageView) findViewById(R.id.gold_down);
        UP.startAnimation(Right);
        DOWN.startAnimation(Right);
        Decorate = (ImageView) findViewById(R.id.pokeDex_decorate);
        Decorate.startAnimation(Right);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.computer:
                PokeDex_init.setBackgroundResource(R.drawable.pokedexinit);
                PokeDex_init.startAnimation(anim4);
                PokeDex_name.setText(" ??? ");
                times = 4;
                flash2.startAnimation(Flash);
        }
    }

    class PokeDexAdapter extends RecyclerView.Adapter<PokeDexAdapter.ViewHolder> {
        private List<PokeMon> PokeDexList;
        TextView PokemonName;

        public PokeDexAdapter(List<PokeMon> myPetList) {
            this.PokeDexList = myPetList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.pokedex_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.PetItemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    PokemonName = (TextView) v.findViewById(R.id.pokedex_name);
                    String Name = PokemonName.getText().toString();
                    Log.i("Name", Name);
                    List<PokeMon> PokeMonList = DataSupport.where("Name = ?", Name).find(PokeMon.class);
                    PokeMon FPokeMon = PokeMonList.get(0);
                    anim4 = AnimationUtils.loadAnimation(PokeDex.this, R.anim.anim4);
                    PokeDex_init.setBackgroundResource(FPokeMon.getImageSourceId());
                    PokeDex_init.startAnimation(anim4);
                    PokeDex_name.setText(FPokeMon.getName());
                    times = 4;
                    flash2.startAnimation(Flash);
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            PokeMon pokeMon = PokeDexList.get(position);
            holder.PokeMonName.setText(pokeMon.getName());
        }

        @Override
        public int getItemCount() {
            return PokeDexList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView PokeMonName;
            View PetItemView;
            public ViewHolder(View view) {
                super(view);
                PokeMonName = (TextView) view.findViewById(R.id.pokedex_name);
                PetItemView = view;
            }

        }
    }
}
