package com.example.pokemonlearn;

import android.content.SharedPreferences;
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

        PokeMon p = new PokeMon(3, "妙蛙种子", R.drawable.bulbasaur2, 20, R.drawable.bulbasaur, null);
        PokeMon p1 = new PokeMon(2, "小火龙", R.drawable.charmander2, 20, R.drawable.charmander, null);
        PokeMon p2 = new PokeMon(1, "杰尼龟", R.drawable.squirtle2, 20, R.drawable.squirtle, null);
        PokeMon p3 = new PokeMon(4, "走路草", R.drawable.oddish2, 19, R.drawable.oddish, null);
        PokeMon p4 = new PokeMon(5, "绿毛虫", R.drawable.caterpie2, 20, R.drawable.caterpie, null);
        PokeMon p5 = new PokeMon(6, "幸运蛋", R.drawable.chansey2, 19, R.drawable.chansey, null);
        PokeMon p6 = new PokeMon(7, "超梦", R.drawable.mewtwo2, 1, R.drawable.mewtwo, null);
        PokeMon p7 = new PokeMon(8, "嘟嘟", R.drawable.doduo2, 18, R.drawable.doduo, null);
        PokeMon p8 = new PokeMon(9, "胖丁", R.drawable.jigglypuff2, 12, R.drawable.jigglypuff, null);
        PokeMon p9 = new PokeMon(10, "耿鬼", R.drawable.gengar2, 20, R.drawable.gengar, null);
        PokeMon p10 = new PokeMon(11, "小磁怪", R.drawable.magnemite2, 4, R.drawable.magnemite, null);
        PokeMon p11 = new PokeMon(12, "小猴怪", R.drawable.mankey2, 17, R.drawable.mankey, null);
        PokeMon p12 = new PokeMon(13, "大岩蛇", R.drawable.onix2, 19, R.drawable.onix, null);
        PokeMon p13 = new PokeMon(14, "六尾", R.drawable.vulpix2, 4, R.drawable.vulpix, null);
        PokeMon p14 = new PokeMon(15, "火焰鸟", R.drawable.zapdos2, 1, R.drawable.zapdos, null);
        PokeMon p15 = new PokeMon(16, "喵喵", R.drawable.meowth2, 17, R.drawable.meowth, null);
        PokeMon p16 = new PokeMon(17, "果然翁", R.drawable.wobbuffet2, 4, R.drawable.wobbuffet, null);
        PokeMon p17 = new PokeMon(18, "伊布", R.drawable.eevee2, 4, R.drawable.eevee, "+4/19+9/20+3/21+2/22+1/23+8/24+7/25");
        PokeMon p18 = new PokeMon(19, "水伊布", R.drawable.vaporeon2, 0, 0, null);
        PokeMon p19 = new PokeMon(20, "雷伊布", R.drawable.jolteon2, 0, 0, null);
        PokeMon p20 = new PokeMon(21, "火伊布", R.drawable.flareon2, 0, 0, null);
        PokeMon p21 = new PokeMon(22, "月光伊布", R.drawable.espeon2, 0, 0, null);
        PokeMon p22 = new PokeMon(23, "日光伊布", R.drawable.umbreon2, 0, 0, null);
        PokeMon p23 = new PokeMon(24, "叶伊布", R.drawable.leafeon2, 0, 0, null);
        PokeMon p24 = new PokeMon(25, "冰伊布", R.drawable.glaceon2, 0, 0, null);
        PokeMon p25 = new PokeMon(26, "仙子伊布", R.drawable.sylveon2, 0, 0, null);

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
        List<PokeMon> pokeMonList = DataSupport.findAll(PokeMon.class);
        List<OwnPet> list = new ArrayList<>();
        for (PokeMon pokeMon : pokeMonList) {
            OwnPet ownPet = new OwnPet(pokeMon.Name, pokeMon.getImageSourceId(), pokeMon.Number, R.drawable.master_ball);
            list.add(ownPet);
            if (list.size() >= 9) {
                break;
            }
        }
        DataSupport.saveAll(list);
    }

    public void myPetQuery() {
        List<OwnPet> pokeMons = DataSupport.findAll(OwnPet.class);
        for (OwnPet pokeMon : pokeMons) {
            Log.i("Query", pokeMon.getName() + "  " + String.valueOf(pokeMon.getImageResourceId()) + "  "
                    + String.valueOf(pokeMon.getNumber()));
        }
    }

    public void myPetDelete() {
        DataSupport.deleteAll(OwnPet.class);
    }

    public void PokeMonBallAdd() {
        List<PokeMonBall> list = new ArrayList<>();
        PokeMonBall p1 = new PokeMonBall("精灵球", R.drawable.pokeball, 1, 0.1, 100);
        PokeMonBall p2 = new PokeMonBall("超级球", R.drawable.great_ball, 2, 0.15, 200);
        PokeMonBall p3 = new PokeMonBall("高级球", R.drawable.ultra_ball, 3, 0.2, 300);
        PokeMonBall p4 = new PokeMonBall("大师球", R.drawable.master_ball, 4, 1.0, 999999999);
        PokeMonBall p5 = new PokeMonBall("狩猎球", R.drawable.safari_ball, 5, 0.15, 200);
        PokeMonBall p6 = new PokeMonBall("等级球", R.drawable.level_ball, 6, 0.1, 100);
        PokeMonBall p7 = new PokeMonBall("诱饵球", R.drawable.lure_ball, 7, 0.1, 100);
        PokeMonBall p8 = new PokeMonBall("月亮球", R.drawable.moon_ball, 8, 0.1, 100);
        PokeMonBall p9 = new PokeMonBall("友谊球", R.drawable.friend_ball, 9, 0.1, 100);
        PokeMonBall p10 = new PokeMonBall("甜蜜球", R.drawable.love_ball, 10, 0.1, 100);
        PokeMonBall p11 = new PokeMonBall("沉重球", R.drawable.heavy_ball, 11, 0.1, 100);
        PokeMonBall p12 = new PokeMonBall("速度球", R.drawable.fast_ball, 12, 0.1, 100);
        PokeMonBall p13 = new PokeMonBall("公园球", R.drawable.park_ball, 13, 0.15, 100);
        PokeMonBall p14 = new PokeMonBall("纪念球", R.drawable.premier_ball, 14, 0.1, 100);
        PokeMonBall p15 = new PokeMonBall("重复球", R.drawable.repeat_ball, 15, 0.1, 100);
        PokeMonBall p16 = new PokeMonBall("计时球", R.drawable.timer_ball, 16, 0.1, 100);
        PokeMonBall p17 = new PokeMonBall("巢穴球", R.drawable.nest_ball, 17, 0.1, 100);
        PokeMonBall p18 = new PokeMonBall("捕网球", R.drawable.net_ball, 18, 0.1, 100);
        PokeMonBall p19 = new PokeMonBall("潜水球", R.drawable.dive_ball, 19, 0.1, 100);
        PokeMonBall p20 = new PokeMonBall("先机球", R.drawable.quick_ball, 20, 0.1, 100);
        PokeMonBall p21 = new PokeMonBall("贵重球", R.drawable.cherish_ball, 21, 0.1, 100);
        PokeMonBall p22 = new PokeMonBall("竞赛球", R.drawable.sport_ball, 22, 0.15, 200);
        PokeMonBall p23 = new PokeMonBall("梦境球", R.drawable.dream_ball, 23, 0.1, 100);
        PokeMonBall p24 = new PokeMonBall("究极球", R.drawable.beast_ball, 24, 0.1, 100);
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

    public void PokeMonToolAdd(){
        List<PokeMonTool> list = new ArrayList<>();
        PokeMonTool p1 = new PokeMonTool("神奇糖果", R.drawable.rare_candy, 1, 1000);
        PokeMonTool p2 = new PokeMonTool("复活草", R.drawable.revival_herb, 2, 500);
        PokeMonTool p3 = new PokeMonTool("诱饵", R.drawable.bait, 3, 100);
        list.add(p1);list.add(p2);list.add(p3);
        DataSupport.saveAll(list);
    }

    public void PokeMonToolQuery() {
        List<PokeMonTool> pokeMons = DataSupport.findAll(PokeMonTool.class);
        for (PokeMonTool pokeMon : pokeMons) {
            Log.i("Query", pokeMon.getName() + "  " + String.valueOf(pokeMon.getNumber()));
        }
    }

    public void PokeMonToolDelete() {
        DataSupport.deleteAll(PokeMonTool.class);
    }

    public void PokeMonStoneAdd() {
        List<PokeMonStone> list = new ArrayList<>();
        PokeMonStone p1 = new PokeMonStone("日之石", R.drawable.stone_sun, 1, 500);
        PokeMonStone p2 = new PokeMonStone("月之石", R.drawable.stone_moon, 2, 500);
        PokeMonStone p3 = new PokeMonStone("火之石", R.drawable.stone_fire, 3, 500);
        PokeMonStone p4 = new PokeMonStone("水之石", R.drawable.stone_water, 4, 500);
        PokeMonStone p5 = new PokeMonStone("暗之石", R.drawable.stone_dusk, 5, 500);
        PokeMonStone p6 = new PokeMonStone("光之石", R.drawable.stone_shiny, 6, 500);
        PokeMonStone p7 = new PokeMonStone("冰之石", R.drawable.stone_ice, 7, 500);
        PokeMonStone p8 = new PokeMonStone("叶之石", R.drawable.stone_leaf, 8, 500);
        PokeMonStone p9 = new PokeMonStone("雷之石", R.drawable.stone_thunder, 9, 500);
        PokeMonStone p10 = new PokeMonStone("晓之石", R.drawable.stone_dawn, 10, 500);

        list.add(p1);list.add(p2);list.add(p3);list.add(p4);list.add(p5);
        list.add(p6);list.add(p7);list.add(p8);list.add(p9);list.add(p10);

        DataSupport.saveAll(list);
    }

    public void PokeMonStoneQuery() {
        List<PokeMonStone> list = DataSupport.findAll(PokeMonStone.class);
        for (PokeMonStone pokeMonBall : list) {
            Log.i("PokeMonBall", String.valueOf(pokeMonBall.getNumber()) + "  " + pokeMonBall.getName());
        }
    }

    public void PokeMonStoneDelete() {
        DataSupport.deleteAll(PokeMonStone.class);
    }

    public void PokeMonBookAdd() {
        List<PokeMonBook> list = new ArrayList<>();
        PokeMonBook p1 = new PokeMonBook("普通秘籍", R.drawable.skill_normal, 1, 1000);
        PokeMonBook p2 = new PokeMonBook("火之秘籍", R.drawable.skill_fire, 2, 1000);
        PokeMonBook p3 = new PokeMonBook("水之秘籍", R.drawable.skill_water, 3, 1000);
        PokeMonBook p4 = new PokeMonBook("电之秘籍", R.drawable.skill_electric, 4, 1000);
        PokeMonBook p5 = new PokeMonBook("草之秘籍", R.drawable.skill_grass, 5, 1000);
        PokeMonBook p6 = new PokeMonBook("冰之秘籍", R.drawable.skill_ice, 6, 1000);
        PokeMonBook p7 = new PokeMonBook("格斗秘籍", R.drawable.skill_fight, 7, 1000);
        PokeMonBook p8 = new PokeMonBook("毒之秘籍", R.drawable.skill_poison, 8, 1000);
        PokeMonBook p9 = new PokeMonBook("地面秘籍", R.drawable.skill_ground, 9, 1000);
        PokeMonBook p10 = new PokeMonBook("飞行秘籍", R.drawable.skill_fly, 10, 1000);
        PokeMonBook p11 = new PokeMonBook("超能秘籍", R.drawable.skill_psych, 11, 1000);
        PokeMonBook p12 = new PokeMonBook("虫之秘籍", R.drawable.skill_bug, 12, 1000);
        PokeMonBook p13 = new PokeMonBook("岩石秘籍", R.drawable.skill_rock, 13, 1000);
        PokeMonBook p14 = new PokeMonBook("幽灵秘籍", R.drawable.skill_ghost, 14, 1000);
        PokeMonBook p15 = new PokeMonBook("龙之秘籍", R.drawable.skill_dark, 15, 1000);
        PokeMonBook p16 = new PokeMonBook("恶之秘籍", R.drawable.skill_dark, 16, 1000);
        PokeMonBook p17 = new PokeMonBook("钢之秘籍", R.drawable.skill_steel, 17, 1000);
        
        list.add(p1);list.add(p2);list.add(p3);list.add(p4);list.add(p5);list.add(p6);
        list.add(p7);list.add(p8);list.add(p9);list.add(p10);list.add(p11);list.add(p12);
        list.add(p13);list.add(p14);list.add(p15);list.add(p16);list.add(p17);

        DataSupport.saveAll(list);
    }

    public void PokeMonBookQuery() {
        List<PokeMonBook> list = DataSupport.findAll(PokeMonBook.class);
        for (PokeMonBook pokeMonBall : list) {
            Log.i("PokeMonBall", String.valueOf(pokeMonBall.getNumber()) + "  " + pokeMonBall.getName());
        }
    }

    public void PokeMonBookDelete() {
        DataSupport.deleteAll(PokeMonBook.class);
    }

    public void OwnItemAdd() {
        List<PokeMonBall> pokeMonBalls = DataSupport.findAll(PokeMonBall.class);
        List<OwnItem> items = new ArrayList<>();
        for (PokeMonBall pokeMonBall : pokeMonBalls) {
            OwnItem ownItem = new OwnItem(pokeMonBall.getName(), 99, 1, pokeMonBall.getImageSourceId(), pokeMonBall.getNumber());
            items.add(ownItem);
        }
        List<PokeMonTool> pokeMonTools = DataSupport.findAll(PokeMonTool.class);
        for (PokeMonTool pokeMonTool : pokeMonTools) {
            OwnItem ownItem = new OwnItem(pokeMonTool.getName(), 99, 2, pokeMonTool.getImageResourceId(), pokeMonTool.getNumber());
            items.add(ownItem);
        }
        List<PokeMonStone> pokeMonStones = DataSupport.findAll(PokeMonStone.class);
        for (PokeMonStone pokeMonStone : pokeMonStones) {
            OwnItem ownItem = new OwnItem(pokeMonStone.getName(), 99, 3, pokeMonStone.getImageResourceId(), pokeMonStone.getNumber());
            items.add(ownItem);
        }
        List<PokeMonBook> pokeMonBooks = DataSupport.findAll(PokeMonBook.class);
        for (PokeMonBook pokeMonBook : pokeMonBooks) {
            OwnItem ownItem = new OwnItem(pokeMonBook.getName(), 99, 4, pokeMonBook.getImageResourceId(), pokeMonBook.getNumber());
            items.add(ownItem);
        }
        DataSupport.saveAll(items);
    }

    public void OwnItemQuery() {
        List<OwnItem> list = DataSupport.findAll(OwnItem.class);
        for (OwnItem ownItem : list) {
            Log.i("PokeMonBall", String.valueOf(ownItem.getNumber()) + "  " + ownItem.getName());
        }
    }

    public void OwnItemDelete() {
        DataSupport.deleteAll(OwnItem.class);
    }

    public void ResetScene() {
        DataSupport.deleteAll(Scene.class);
        List<Scene> scenes = new ArrayList<>();
        Scene s1 = new Scene(1, R.drawable.pet_init1, 0);
        Scene s2 = new Scene(2, R.drawable.pet_init2, 200);
        Scene s3 = new Scene(3, R.drawable.pet_init3, 200);
        Scene s4 = new Scene(4, R.drawable.pet_init4, 200);
        Scene s5 = new Scene(5, R.drawable.pet_init5, 200);
        Scene s6 = new Scene(6, R.drawable.pet_init6, 200);
        Scene s7 = new Scene(7, R.drawable.pet_init7, 200);
        Scene s8 = new Scene(8, R.drawable.pet_init8, 200);
        Scene s9 = new Scene(9, R.drawable.pet_init9, 200);
        Scene s10 = new Scene(10, R.drawable.pet_init10, 200);
        Scene s11 = new Scene(11, R.drawable.pet_init11, 200);
        Scene s12 = new Scene(12, R.drawable.pet_init12, 200);
        Scene s13 = new Scene(13, R.drawable.pet_init13, 200);
        Scene s14 = new Scene(14, R.drawable.pet_init14, 200);
        Scene s15 = new Scene(15, R.drawable.pet_init15, 200);
        scenes.add(s1);scenes.add(s2);scenes.add(s3);scenes.add(s4);scenes.add(s5);
        scenes.add(s6);scenes.add(s7);scenes.add(s8);scenes.add(s9);scenes.add(s10);
        scenes.add(s11);scenes.add(s12);scenes.add(s13);scenes.add(s14);scenes.add(s15);
        DataSupport.saveAll(scenes);
    }

    public void AddCoins() {
        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        int MyCoin = sharedPreferences.getInt("Coins", 0);
        MyCoin += 1000;
        SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
        editor.putInt("Coins", MyCoin);
        editor.apply();
        Log.i("MyCoin", String.valueOf(MyCoin));
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
        DatabaseButton b10 = new DatabaseButton("ADD POKEMON-TOOL", 10);
        DatabaseButton b11 = new DatabaseButton("QUERY POKEMON-TOOL", 11);
        DatabaseButton b12 = new DatabaseButton("DELETE POKEMON-TOOL", 12);
        DatabaseButton b13 = new DatabaseButton("ADD POKEMON-STONE", 13);
        DatabaseButton b14 = new DatabaseButton("QUERY POKEMON-STONE", 14);
        DatabaseButton b15 = new DatabaseButton("DELTE POKEMON-STONE", 15);
        DatabaseButton b16 = new DatabaseButton("ADD POKEMON-BOOK", 16);
        DatabaseButton b17 = new DatabaseButton("QUERY POKEMON-BOOK", 17);
        DatabaseButton b18 = new DatabaseButton("DELETE POKEMON-BOOK", 18);
        DatabaseButton b19 = new DatabaseButton("ADD OWN-ITEM", 19);
        DatabaseButton b20 = new DatabaseButton("QUERY OWN-ITEM", 20);
        DatabaseButton b21 = new DatabaseButton("DELETE OWN-ITEM", 21);
        DatabaseButton b22 = new DatabaseButton("重置场景", 22);
        DatabaseButton b23 = new DatabaseButton("加1000金", 23);

        list.add(b1);list.add(b2);list.add(b3);
        list.add(b4);list.add(b5);list.add(b6);
        list.add(b7);list.add(b8);list.add(b9);
        list.add(b10);list.add(b11);list.add(b12);
        list.add(b13);list.add(b14);list.add(b15);
        list.add(b16);list.add(b17);list.add(b18);
        list.add(b19);list.add(b20);list.add(b21);
        list.add(b22);list.add(b23);

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
                        case 10:
                            PokeMonToolAdd();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 11:
                            PokeMonToolQuery();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 12:
                            PokeMonToolDelete();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                        case 13:
                            PokeMonStoneAdd();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 14:
                            PokeMonStoneQuery();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 15:
                            PokeMonStoneDelete();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                        case 16:
                            PokeMonBookAdd();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 17:
                            PokeMonBookQuery();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 18:
                            PokeMonBookDelete();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                        case 19:
                            OwnItemAdd();
                            Log.i("DatabasesTest", "Add Successfully");
                            break;
                        case 20:
                            OwnItemQuery();
                            Log.i("DatabasesTest", "Query Successfully");
                            break;
                        case 21:
                            OwnItemDelete();
                            Log.i("DatabasesTest", "Delete Successfully");
                            break;
                        case 22:
                            ResetScene();
                            Log.i("DatabasesTest", "ResetScene");
                            break;
                        case 23:
                            AddCoins();
                            Log.i("DatabasesTest", "AddCoins");
                            break;
                    }
                }
            });
            holder.ItemView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        v.getBackground().setAlpha(125);
                    } else {
                        v.getBackground().setAlpha(255);
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

    private class DatabaseButton {
        private String text;
        private int Number;

        public DatabaseButton(String text, int number) {
            this.text = text;
            this.Number = number;
        }
    }

}
