package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 9/4/17.
 */

public class PokeMon extends DataSupport{
    int Number;
    String Name;
    int ImageSourceId;

    public PokeMon() {}
    public PokeMon(int Number, String Name, int imageSourceId) {
        this.Number = Number;
        this.Name = Name;
        this.ImageSourceId = imageSourceId;
    }


    public int getNumber() {
        return Number;
    }
    public String getName() {
        return Name;
    }
    public int getImageSourceId() {
        return ImageSourceId;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImageSourceId(int imageSourceId) {
        ImageSourceId = imageSourceId;
    }
}
