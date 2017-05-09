package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 9/5/17.
 */

public class OwnItem extends DataSupport {
    private String Name;
    private int Number;
    private int Type;
    public OwnItem(){}

    public OwnItem(String name, int number, int type) {
        Name = name;
        Number = number;
        Type = type;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public void setType(int type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public int getNumber() {
        return Number;
    }

    public int getType() {
        return Type;
    }
}
