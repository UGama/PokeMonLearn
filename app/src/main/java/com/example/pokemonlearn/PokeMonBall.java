package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 8/5/17.
 */

public class PokeMonBall extends DataSupport {
    private String Name;
    private int ImageSourceId;
    private int Number;
    private Double rate;
    private int Price;

    public PokeMonBall() {}

    public PokeMonBall(String Name, int ImageSourceId, int Number, Double rate, int price) {
        this.Name = Name;
        this.ImageSourceId = ImageSourceId;
        this.Number = Number;
        this.rate = rate;
        this.Price = price;
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

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
