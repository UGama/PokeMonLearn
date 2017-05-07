package com.example.pokemonlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


public class DatabaseOperate extends AppCompatActivity implements View.OnClickListener {

    Button AddDataDatabases;
    Button QueryDatabases;
    Button DeleteDatabases;
    Button UpdateDatabases;
    Button DeleteAllDatabases;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AddDataDatabases:
                Add();
                Log.i("DatabasesTest", "Add Successfully");
                break;
            case R.id.queryDatabases:
                Query();
                Log.i("DatabasesTest", "Query Successfully");
                break;
            case R.id.deleteDatabases:
                Delete();
                Log.i("DatabasesTest", "Delete Successfully");
                break;
            case R.id.updateDatabases:
                Update();
                Log.i("DatabasesTest", "Update Successfully");
                break;
            case R.id.deleteAll:
                DeleteAll();
                Log.i("DatabasesTest", "DeleteAll Successfully");
        }
    }

    /*public void Delete() {
        PokeMon school = new PokeMon();
        school.setScene("情侣约会");
        school.setEScene("date");
        school.save();
    }

    public void Add() {
        School school = new School();
        school.setScene("公园");
        school.setEScene("park");
        school.save();
    }

    public void Query() {
        List<School> Scene = DataSupport.findAll(School.class);
        for (School school : Scene) {
            Log.i("MainActivity", String.valueOf(school.getId()));
            Log.i("MainActivity", school.getScene());
            Log.i("MainActivity", school.getEScene());
        }

    }

    public void Update() {
        School school = new School();
        school.setScene("图书馆");
        school.update(1);
        Log.i("MainActivity", "Update successfully");
    }*/
    public void Delete() {
        DataSupport.deleteAll(PokeMon.class, "Number = ?", "99");
    }

    public void Update() {
        PokeMon pokeMon = new PokeMon();
        pokeMon.setImageSourceId(R.drawable.zapdos2);
        pokeMon.updateAll("Number = ?", "15");
    }

    public void Query() {
        List<PokeMon> pokeMons = DataSupport.findAll(PokeMon.class);
        for (PokeMon pokeMon : pokeMons) {
            Log.i("Query", pokeMon.getName() + "  " + String.valueOf(pokeMon.getImageSourceId()) + "  "
                    + String.valueOf(pokeMon.getNumber()));
        }
    }

    public void DeleteAll() {
        DataSupport.deleteAll(PokeMon.class);
    }
    public void Add() {
        /*PokeMon pokeMontest = new PokeMon();
        pokeMontest.setImageSourceId(34);
        pokeMontest.setName("test");
        pokeMontest.setNumber(1);
        pokeMontest.save();*/
        ArrayList<PokeMon> list = new ArrayList<>();
        PokeMon p = new PokeMon(1, "Squirtle", R.drawable.squirtle2);
        PokeMon p1 = new PokeMon(2, "Charmander", R.drawable.charmander2);
        PokeMon p2 = new PokeMon(3, "Bulasaur", R.drawable.bulbasaur2);
        PokeMon p3 = new PokeMon(4, "Oddish", R.drawable.oddish2);
        PokeMon p4 = new PokeMon(5, "Pikachu", R.drawable.pikachu2);
        PokeMon p5 = new PokeMon(6, "Chansey", R.drawable.chansey2);
        PokeMon p6 = new PokeMon(7, "Clefairy", R.drawable.clefairy2);
        PokeMon p7 = new PokeMon(8, "Doduo", R.drawable.doduo2);
        PokeMon p8 = new PokeMon(9, "Jigglypuff", R.drawable.jigglypuff2);
        PokeMon p9 = new PokeMon(10, "Gengar", R.drawable.gengar2);
        PokeMon p10 = new PokeMon(11, "Magnemite", R.drawable.magnemite2);
        PokeMon p11 = new PokeMon(12, "Mankey", R.drawable.mankey2);
        PokeMon p12 = new PokeMon(13, "Onix", R.drawable.onix2);
        PokeMon p13 = new PokeMon(14, "Vulpix", R.drawable.vulpix2);
        PokeMon p14 = new PokeMon(15, "Zapdos", R.drawable.zapdos2);
        PokeMon p15 = new PokeMon(16, "Meowth", R.drawable.meowth2);
        PokeMon p16 = new PokeMon(17, "Wobbuffet", R.drawable.wobbuffet);
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

        DataSupport.saveAll(list);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);
        AddDataDatabases = (Button) findViewById(R.id.AddDataDatabases);
        AddDataDatabases.setOnClickListener(this);

        QueryDatabases = (Button) findViewById(R.id.queryDatabases);
        QueryDatabases.setOnClickListener(this);

        DeleteDatabases = (Button) findViewById(R.id.deleteDatabases);
        DeleteDatabases.setOnClickListener(this);

        UpdateDatabases = (Button) findViewById(R.id.updateDatabases);
        UpdateDatabases.setOnClickListener(this);

        DeleteAllDatabases = (Button) findViewById(R.id.deleteAll);
        DeleteAllDatabases.setOnClickListener(this);

    }

}
