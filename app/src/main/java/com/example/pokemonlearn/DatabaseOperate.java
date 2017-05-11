package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


public class DatabaseOperate extends AppCompatActivity {


    private RecyclerView recyclerView;

    public void Add() {
        /*PokeMon pokeMontest = new PokeMon();
        pokeMontest.setImageSourceId(34);
        pokeMontest.setName("test");
        pokeMontest.setNumber(1);
        pokeMontest.save();*/
        ArrayList<PokeMon> list = new ArrayList<>();


        PokeMon p = new PokeMon(3, "Bulasaur", R.drawable.bulbasaur2, 20, R.drawable.bulbasaur);
        PokeMon p1 = new PokeMon(2, "Charmander", R.drawable.charmander2, 20, R.drawable.charmander);
        PokeMon p2 = new PokeMon(1, "Squirtle", R.drawable.squirtle2, 20, R.drawable.squirtle);
        PokeMon p3 = new PokeMon(4, "Oddish", R.drawable.oddish2, 19, R.drawable.oddish);
        PokeMon p4 = new PokeMon(5, "Caterpie", R.drawable.caterpie2, 20, R.drawable.caterpie);
        PokeMon p5 = new PokeMon(6, "Chansey", R.drawable.chansey2, 19, R.drawable.chansey);
        PokeMon p6 = new PokeMon(7, "Mewtwo", R.drawable.mewtwo2, 1, R.drawable.mewtwo);
        PokeMon p7 = new PokeMon(8, "Doduo", R.drawable.doduo2, 18, R.drawable.doduo);
        PokeMon p8 = new PokeMon(9, "Jigglypuff", R.drawable.jigglypuff2, 12, R.drawable.jigglypuff);
        PokeMon p9 = new PokeMon(10, "Gengar", R.drawable.gengar2, 20, R.drawable.gengar);
        PokeMon p10 = new PokeMon(11, "Magnemite", R.drawable.magnemite2, 4, R.drawable.magnemite);
        PokeMon p11 = new PokeMon(12, "Mankey", R.drawable.mankey2, 17, R.drawable.mankey);
        PokeMon p12 = new PokeMon(13, "Onix", R.drawable.onix2, 19, R.drawable.onix);
        PokeMon p13 = new PokeMon(14, "Vulpix", R.drawable.vulpix2, 4, R.drawable.vulpix);
        PokeMon p14 = new PokeMon(15, "Zapdos", R.drawable.zapdos2, 1, R.drawable.zapdos);
        PokeMon p15 = new PokeMon(16, "Meowth", R.drawable.meowth2, 17, R.drawable.meowth);
        PokeMon p16 = new PokeMon(17, "Wobbuffet", R.drawable.wobbuffet2, 4, R.drawable.wobbuffet);
        PokeMon p17 = new PokeMon(18, "Eevee", R.drawable.eevee2, 4, R.drawable.eevee);
        PokeMon p18 = new PokeMon(19, "Vaporeon", R.drawable.vaporeon2, 0, 0);
        PokeMon p19 = new PokeMon(20, "Jolteon", R.drawable.jolteon2, 0, 0);
        PokeMon p20 = new PokeMon(21, "Flareon", R.drawable.flareon2, 0, 0);
        PokeMon p21 = new PokeMon(22, "Espeon", R.drawable.espeon2, 0, 0);
        PokeMon p22 = new PokeMon(23, "Umbreon", R.drawable.umbreon2, 0, 0);
        PokeMon p23 = new PokeMon(24, "Leafeon", R.drawable.leafeon2, 0, 0);
        PokeMon p24 = new PokeMon(25, "Glaceon", R.drawable.glaceon2, 0, 0);
        PokeMon p25 = new PokeMon(26, "Sylveon", R.drawable.sylveon2, 0, 0);

        list.add(p);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        list.add(p11);
        list.add(p12);
        list.add(p13);
        list.add(p14);
        list.add(p15);
        list.add(p16);
        list.add(p17);
        list.add(p18);
        list.add(p19);
        list.add(p20);
        list.add(p21);
        list.add(p22);
        list.add(p23);
        list.add(p24);
        list.add(p25);

        DataSupport.saveAll(list);
    }

    public void Query() {
        List<PokeMon> pokeMons = DataSupport.findAll(PokeMon.class);
        for (PokeMon pokeMon : pokeMons) {
            Log.i("Query", pokeMon.getName() + "  " + String.valueOf(pokeMon.getNumber())
                    + "  " + String.valueOf(pokeMon.getWeight()));
        }
    }

    public void DeleteAll() {
        DataSupport.deleteAll(PokeMon.class);
    }

    public void myPetAdd() {
        OwnPet Pikachu = new OwnPet();
        Pikachu.setPosition(R.drawable.pikachu2);
        Pikachu.setId(1);
        Pikachu.setName("Pikachu");
        Pikachu.save();
    }

    public void myPetQuery() {
        List<OwnPet> pokeMons = DataSupport.findAll(OwnPet.class);
        for (OwnPet pokeMon : pokeMons) {
            Log.i("Query", pokeMon.getName() + "  " + String.valueOf(pokeMon.getPosition()) + "  "
                    + String.valueOf(pokeMon.getId()));
        }
    }

    public void myPetDelete() {
        DataSupport.deleteAll(OwnPet.class);
    }

    public void PokeMonBallAdd() {
        List<PokeMonBall> list = new ArrayList<>();
        PokeMonBall p1 = new PokeMonBall("精灵球", R.drawable.pokeball, 1, 0.1);
        PokeMonBall p2 = new PokeMonBall("超级球", R.drawable.great_ball, 2, 0.15);
        PokeMonBall p3 = new PokeMonBall("高级球", R.drawable.ultra_ball, 3, 0.2);
        PokeMonBall p4 = new PokeMonBall("大师球", R.drawable.master_ball, 4, 1.0);
        PokeMonBall p5 = new PokeMonBall("狩猎球", R.drawable.safari_ball, 5, 0.15);
        PokeMonBall p6 = new PokeMonBall("等级球", R.drawable.level_ball, 6, 0.1);
        PokeMonBall p7 = new PokeMonBall("诱饵球", R.drawable.lure_ball, 7, 0.1);
        PokeMonBall p8 = new PokeMonBall("月亮球", R.drawable.moon_ball, 8, 0.1);
        PokeMonBall p9 = new PokeMonBall("友谊球", R.drawable.friend_ball, 9, 0.1);
        PokeMonBall p10 = new PokeMonBall("甜蜜球", R.drawable.love_ball, 10, 0.1);
        PokeMonBall p11 = new PokeMonBall("沉重球", R.drawable.heavy_ball, 11, 0.1);
        PokeMonBall p12 = new PokeMonBall("速度球", R.drawable.fast_ball, 12, 0.1);
        PokeMonBall p13 = new PokeMonBall("公园球", R.drawable.park_ball, 13, 0.15);
        PokeMonBall p14 = new PokeMonBall("纪念球", R.drawable.premier_ball, 14, 0.1);
        PokeMonBall p15 = new PokeMonBall("重复球", R.drawable.repeat_ball, 15, 0.1);
        PokeMonBall p16 = new PokeMonBall("计时球", R.drawable.timer_ball, 16, 0.1);
        PokeMonBall p17 = new PokeMonBall("巢穴球", R.drawable.nest_ball, 17, 0.1);
        PokeMonBall p18 = new PokeMonBall("捕网球", R.drawable.net_ball, 18, 0.1);
        PokeMonBall p19 = new PokeMonBall("潜水球", R.drawable.dive_ball, 19, 0.1);
        PokeMonBall p20 = new PokeMonBall("先机球", R.drawable.quick_ball, 20, 0.1);
        PokeMonBall p21 = new PokeMonBall("贵重球", R.drawable.cherish_ball, 21, 0.1);
        PokeMonBall p22 = new PokeMonBall("竞赛球", R.drawable.sport_ball, 22, 0.15);
        PokeMonBall p23 = new PokeMonBall("梦境球", R.drawable.dream_ball, 23, 0.1);
        PokeMonBall p24 = new PokeMonBall("究极球", R.drawable.beast_ball, 24, 0.1);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        list.add(p8);
        list.add(p9);
        list.add(p10);
        list.add(p11);
        list.add(p12);
        list.add(p13);
        list.add(p14);
        list.add(p15);
        list.add(p16);
        list.add(p17);
        list.add(p18);
        list.add(p19);
        list.add(p20);
        list.add(p21);
        list.add(p22);
        list.add(p23);
        list.add(p24);
        DataSupport.saveAll(list);
    }

    public void PokeMonBallQuery() {
        List<PokeMonBall> list = DataSupport.findAll(PokeMonBall.class);
        for (PokeMonBall pokeMonBall : list) {
            Log.i("PokeMonBall", String.valueOf(pokeMonBall.getNumber()) + "  " + pokeMonBall.getName());
        }
    }

    public void PokeMonBallDelete() {
        DataSupport.deleteAll(PokeMonBall.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<DatabaseButton> list = new ArrayList<>();
        DatabaseButton b1 = new DatabaseButton("ADD POKEMON", 1);
        DatabaseButton b2 = new DatabaseButton("QUERY POKEMON", 2);
        DatabaseButton b3 = new DatabaseButton("DELETE POKEMON", 3);
        DatabaseButton b4 = new DatabaseButton("ADD OWN-POKEMON", 4);
        DatabaseButton b5 = new DatabaseButton("QUERY OWN-POKEMON", 5);
        DatabaseButton b6 = new DatabaseButton("DELETE POKEMON", 6);
        DatabaseButton b7 = new DatabaseButton("ADD POKEMON-BALL", 7);
        DatabaseButton b8 = new DatabaseButton("QUERY POKEMON-BALL", 8);
        DatabaseButton b9 = new DatabaseButton("DELETE POKEMON-Ball", 9);
        list.add(b1);list.add(b2);list.add(b3);
        list.add(b4);list.add(b5);list.add(b6);
        list.add(b7);list.add(b8);list.add(b9);
        DatabaseOperateAdapter adapter = new DatabaseOperateAdapter(list);
        recyclerView.setAdapter(adapter);
    }

    class DatabaseOperateAdapter extends RecyclerView.Adapter<DatabaseOperateAdapter.ViewHolder> {

        private List<DatabaseButton> List;

        public DatabaseOperateAdapter(List<DatabaseButton> List) {
            this.List = List;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.database_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            final DatabaseButton databaseButton = List.get(position);
            holder.button.setText(databaseButton.text);
            holder.textView.setText(String.valueOf(databaseButton.Number));
            holder.ItemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    TextView numberText = (TextView) v.findViewById(R.id.TextView);
                    int number = Integer.valueOf(numberText.getText().toString());
                    switch (number) {
                        case 1:
                            Add();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 2:
                            Query();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 3:
                            DeleteAll();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                        case 4:
                            myPetAdd();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 5:
                            myPetQuery();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 6:
                            myPetDelete();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                        case 7:
                            PokeMonBallAdd();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 8:
                            PokeMonBallQuery();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 9:
                            PokeMonBallDelete();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                    }
                }
            });
            holder.ItemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        v.getBackground().setAlpha(255);
                    } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        v.getBackground().setAlpha(125);
                    }
                    return false;
                }
            });
        }

        @Override
        public int getItemCount() {
            return List.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView button;
            TextView textView;
            View ItemView;
            public ViewHolder(View view) {
                super(view);
                button = (TextView) view.findViewById(R.id.TextView2);
                textView = (TextView) view.findViewById(R.id.TextView);
                ItemView = view;
            }
        }



    }

    class DatabaseButton {
        private String text;
        private int Number;

        public DatabaseButton(String text, int number) {
            this.text = text;
            this.Number = number;
        }
    }

}
