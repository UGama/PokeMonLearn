package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 8/5/17.
 */

public class PokeMonBall extends DataSupport {
    private String Name;
    private int ImageSourceId;
    private int Number;
    private int rate;

    public PokeMonBall() {}

    public PokeMonBall(String Name, int ImageSourceId, int Number, int rate) {
        this.Name = Name;
        this.ImageSourceId = ImageSourceId;
        this.Number = Number;
        this.rate = rate;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setImageSourceId(int imageSourceId) {
        ImageSourceId = imageSourceId;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public int getImageSourceId() {
        return ImageSourceId;
    }

    public int getNumber() {
        return Number;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
