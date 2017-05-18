package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 9/5/17.
 */

public class OwnItem extends DataSupport {
    private String Name;
    private int Number;
    private int Type;
    private int ImageResourceId;
    private int NumberInDex;

    public OwnItem(){}

    public OwnItem(String name, int number, int type, int imageResourceId, int numberInDex) {
        Name = name;
        Number = number;
        Type = type;
        ImageResourceId = imageResourceId;
        NumberInDex = numberInDex;
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

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
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

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public int getNumberInDex() {
        return NumberInDex;
    }

    public void setNumberInDex(int numberInDex) {
        NumberInDex = numberInDex;
    }
}
