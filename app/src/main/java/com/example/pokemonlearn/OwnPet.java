package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 8/5/17.
 */

public class OwnPet extends DataSupport {
    private int Number;
    private String Name;
    private int ImageResourceId;

    public OwnPet() {}

    public OwnPet(String name, int imageResourceId, int number) {
        Name = name;
        ImageResourceId = imageResourceId;
        Number = number;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(int number) {
        Number = number;
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

    public int getImageResourceId() {
        return ImageResourceId;
    }
}
