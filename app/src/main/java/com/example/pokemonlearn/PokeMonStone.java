package com.example.pokemonlearn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 11/5/17.
 */

public class PokeMonStone extends DataSupport {
    private String Name;
    private int ImageResourceId;
    private int Number;
    private int Price;

    public PokeMonStone() {}

    public PokeMonStone(String name, int imageResourceId, int number, int price) {
        this.Name = name;
        this.ImageResourceId = imageResourceId;
        this.Number = number;
        this.Price = price;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public String getName() {
        return Name;
    }

    public int getNumber() {
        return Number;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
